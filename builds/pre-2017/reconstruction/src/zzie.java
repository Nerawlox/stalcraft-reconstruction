/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3Pool;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeDirection;

public class zzie
implements IBlockAccess {
    public int _a;
    public int _b;
    public Chunk[][] _c;
    public boolean _d;
    public World _e;

    public zzie(World world, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        Chunk chunk;
        int n8;
        int n9;
        this._e = world;
        this._a = n - n7 >> 4;
        this._b = n3 - n7 >> 4;
        int n10 = n4 + n7 >> 4;
        int n11 = n6 + n7 >> 4;
        this._c = new Chunk[n10 - this._a + 1][n11 - this._b + 1];
        this._d = true;
        for (n9 = this._a; n9 <= n10; ++n9) {
            for (n8 = this._b; n8 <= n11; ++n8) {
                chunk = world.getChunkFromChunkCoords(n9, n8);
                if (chunk == null) continue;
                this._c[n9 - this._a][n8 - this._b] = chunk;
            }
        }
        for (n9 = n >> 4; n9 <= n4 >> 4; ++n9) {
            for (n8 = n3 >> 4; n8 <= n6 >> 4; ++n8) {
                chunk = this._c[n9 - this._a][n8 - this._b];
                if (chunk == null || chunk._e(n2, n5)) continue;
                this._d = false;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean extendedLevelsInChunkCache() {
        return this._d;
    }

    @Override
    public int getBlockId(int n, int n2, int n3) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            return 0;
        }
        int n4 = (n >> 4) - this._a;
        int n5 = (n3 >> 4) - this._b;
        if (n4 >= 0 && n4 < this._c.length && n5 >= 0 && n5 < this._c[n4].length) {
            Chunk chunk = this._c[n4][n5];
            return chunk == null ? 0 : chunk._d(n & 0xF, n2, n3 & 0xF);
        }
        return 0;
    }

    @Override
    public TileEntity getBlockTileEntity(int n, int n2, int n3) {
        int n4 = (n >> 4) - this._a;
        int n5 = (n3 >> 4) - this._b;
        if (n4 >= 0 && n4 < this._c.length && n5 >= 0 && n5 < this._c[n4].length) {
            Chunk chunk = this._c[n4][n5];
            return chunk == null ? null : chunk._g(n & 0xF, n2, n3 & 0xF);
        }
        return null;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float getBrightness(int n, int n2, int n3, int n4) {
        int n5 = this._a(n, n2, n3);
        if (n5 < n4) {
            n5 = n4;
        }
        return this._e.provider._h[n5];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getLightBrightnessForSkyBlocks(int n, int n2, int n3, int n4) {
        int n5 = this._a(EnumSkyBlock._a, n, n2, n3);
        int n6 = this._a(EnumSkyBlock._b, n, n2, n3);
        if (n6 < n4) {
            n6 = n4;
        }
        return n5 << 20 | n6 << 4;
    }

    @Override
    public int getBlockMetadata(int n, int n2, int n3) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            return 0;
        }
        int n4 = (n >> 4) - this._a;
        int n5 = (n3 >> 4) - this._b;
        if (n4 >= 0 && n4 < this._c.length && n5 >= 0 && n5 < this._c[n4].length) {
            Chunk chunk = this._c[n4][n5];
            return chunk == null ? 0 : chunk._e(n & 0xF, n2, n3 & 0xF);
        }
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float getLightBrightness(int n, int n2, int n3) {
        return this._e.provider._h[this._a(n, n2, n3)];
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(int n, int n2, int n3) {
        return this._a(n, n2, n3, true);
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(int n, int n2, int n3, boolean bl) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 <= 30000000) {
            int n4;
            if (bl && ((n4 = this.getBlockId(n, n2, n3)) == Block.stoneSingleSlab.blockID || n4 == Block.woodSingleSlab.blockID || n4 == Block.tilledField.blockID || n4 == Block.stairsWoodOak.blockID || n4 == Block.stairsCobblestone.blockID)) {
                int n5 = this._a(n, n2 + 1, n3, false);
                int n6 = this._a(n + 1, n2, n3, false);
                int n7 = this._a(n - 1, n2, n3, false);
                int n8 = this._a(n, n2, n3 + 1, false);
                int n9 = this._a(n, n2, n3 - 1, false);
                if (n6 > n5) {
                    n5 = n6;
                }
                if (n7 > n5) {
                    n5 = n7;
                }
                if (n8 > n5) {
                    n5 = n8;
                }
                if (n9 > n5) {
                    n5 = n9;
                }
                return n5;
            }
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                n4 = 15 - this._e.skylightSubtracted;
                if (n4 < 0) {
                    n4 = 0;
                }
                return n4;
            }
            n4 = (n >> 4) - this._a;
            int n10 = (n3 >> 4) - this._b;
            return this._c[n4][n10]._c(n & 0xF, n2, n3 & 0xF, this._e.skylightSubtracted);
        }
        return 15;
    }

    @Override
    public Material getBlockMaterial(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        return n4 == 0 ? Material._a : Block.blocksList[n4].blockMaterial;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public BiomeGenBase getBiomeGenForCoords(int n, int n2) {
        return this._e.getBiomeGenForCoords(n, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean isBlockOpaqueCube(int n, int n2, int n3) {
        Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
        return block == null ? false : block.isOpaqueCube();
    }

    @Override
    public boolean isBlockNormalCube(int n, int n2, int n3) {
        Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
        return block == null ? false : block.blockMaterial._c() && block.renderAsNormalBlock();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean doesBlockHaveSolidTopSurface(int n, int n2, int n3) {
        return this._e.doesBlockHaveSolidTopSurface(n, n2, n3);
    }

    @Override
    public Vec3Pool getWorldVec3Pool() {
        return this._e.getWorldVec3Pool();
    }

    @Override
    public boolean isAirBlock(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        return n4 == 0 || Block.blocksList[n4] == null || Block.blocksList[n4].isAirBlock(this._e, n, n2, n3);
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        if (n2 >= 0 && n2 < 256 && n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 <= 30000000) {
            if (enumSkyBlock == EnumSkyBlock._a && this._e.provider._g) {
                return 0;
            }
            if (Block.useNeighborBrightness[this.getBlockId(n, n2, n3)]) {
                int n4 = this._b(enumSkyBlock, n, n2 + 1, n3);
                int n5 = this._b(enumSkyBlock, n + 1, n2, n3);
                int n6 = this._b(enumSkyBlock, n - 1, n2, n3);
                int n7 = this._b(enumSkyBlock, n, n2, n3 + 1);
                int n8 = this._b(enumSkyBlock, n, n2, n3 - 1);
                if (n5 > n4) {
                    n4 = n5;
                }
                if (n6 > n4) {
                    n4 = n6;
                }
                if (n7 > n4) {
                    n4 = n7;
                }
                if (n8 > n4) {
                    n4 = n8;
                }
                return n4;
            }
            int n9 = (n >> 4) - this._a;
            int n10 = (n3 >> 4) - this._b;
            return this._c[n9][n10]._a(enumSkyBlock, n & 0xF, n2, n3 & 0xF);
        }
        return enumSkyBlock._c;
    }

    @SideOnly(value=Side.CLIENT)
    public int _b(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        if (n2 >= 0 && n2 < 256 && n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 <= 30000000) {
            int n4 = (n >> 4) - this._a;
            int n5 = (n3 >> 4) - this._b;
            return this._c[n4][n5]._a(enumSkyBlock, n & 0xF, n2, n3 & 0xF);
        }
        return enumSkyBlock._c;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getHeight() {
        return 256;
    }

    @Override
    public int isBlockProvidingPowerTo(int n, int n2, int n3, int n4) {
        int n5 = this.getBlockId(n, n2, n3);
        return n5 == 0 ? 0 : Block.blocksList[n5].isProvidingStrongPower(this, n, n2, n3, n4);
    }

    @Override
    public boolean isBlockSolidOnSide(int n, int n2, int n3, ForgeDirection forgeDirection, boolean bl) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return bl;
        }
        int n4 = this.getBlockId(n, n2, n3);
        Block block = Block.blocksList[n4];
        if (block != null) {
            return block.isBlockSolidOnSide(this._e, n, n2, n3, forgeDirection);
        }
        return false;
    }
}

