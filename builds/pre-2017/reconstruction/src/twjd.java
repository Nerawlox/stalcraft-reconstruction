/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class twjd
extends BlockFluid {
    public int _a;
    public boolean[] _b = new boolean[4];
    public int[] _c = new int[4];

    public twjd(int n, Material material) {
        super(n, material);
    }

    public void _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        world.setBlock(n, n2, n3, this.blockID + 1, n4, 2);
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this.blockMaterial != Material._i;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4;
        int n5 = this._e(world, n, n2, n3);
        int n6 = 1;
        if (this.blockMaterial == Material._i && !world.provider._f) {
            n6 = 2;
        }
        boolean bl = true;
        int n7 = this.tickRate(world);
        if (n5 > 0) {
            int n8 = -100;
            this._a = 0;
            int n9 = this._b(world, n - 1, n2, n3, n8);
            n9 = this._b(world, n + 1, n2, n3, n9);
            n9 = this._b(world, n, n2, n3 - 1, n9);
            n4 = (n9 = this._b(world, n, n2, n3 + 1, n9)) + n6;
            if (n4 >= 8 || n9 < 0) {
                n4 = -1;
            }
            if (this._e(world, n, n2 + 1, n3) >= 0) {
                int n10 = this._e(world, n, n2 + 1, n3);
                n4 = n10 >= 8 ? n10 : n10 + 8;
            }
            if (this._a >= 2 && this.blockMaterial == Material._h) {
                if (world.getBlockMaterial(n, n2 - 1, n3)._a()) {
                    n4 = 0;
                } else if (world.getBlockMaterial(n, n2 - 1, n3) == this.blockMaterial && world.getBlockMetadata(n, n2 - 1, n3) == 0) {
                    n4 = 0;
                }
            }
            if (this.blockMaterial == Material._i && n5 < 8 && n4 < 8 && n4 > n5 && random.nextInt(4) != 0) {
                n7 *= 4;
            }
            if (n4 == n5) {
                if (bl) {
                    this._a(world, n, n2, n3);
                }
            } else {
                n5 = n4;
                if (n4 < 0) {
                    world.setBlockToAir(n, n2, n3);
                } else {
                    world.func_72921_c(n, n2, n3, n4, 2);
                    world.scheduleBlockUpdate(n, n2, n3, this.blockID, n7);
                    world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
                }
            }
        } else {
            this._a(world, n, n2, n3);
        }
        if (this._d(world, n, n2 - 1, n3)) {
            if (this.blockMaterial == Material._i && world.getBlockMaterial(n, n2 - 1, n3) == Material._h) {
                world.setBlock(n, n2 - 1, n3, Block.stone.blockID);
                this._g(world, n, n2 - 1, n3);
                return;
            }
            if (n5 >= 8) {
                this._a(world, n, n2 - 1, n3, n5);
            } else {
                this._a(world, n, n2 - 1, n3, n5 + 8);
            }
        } else if (n5 >= 0 && (n5 == 0 || this._c(world, n, n2 - 1, n3))) {
            boolean[] blArray = this._b(world, n, n2, n3);
            n4 = n5 + n6;
            if (n5 >= 8) {
                n4 = 1;
            }
            if (n4 >= 8) {
                return;
            }
            if (blArray[0]) {
                this._a(world, n - 1, n2, n3, n4);
            }
            if (blArray[1]) {
                this._a(world, n + 1, n2, n3, n4);
            }
            if (blArray[2]) {
                this._a(world, n, n2, n3 - 1, n4);
            }
            if (blArray[3]) {
                this._a(world, n, n2, n3 + 1, n4);
            }
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        if (this._d(world, n, n2, n3)) {
            int n5 = world.getBlockId(n, n2, n3);
            if (n5 > 0) {
                if (this.blockMaterial == Material._i) {
                    this._g(world, n, n2, n3);
                } else if (n5 != Block.snow.blockID) {
                    Block.blocksList[n5].dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                }
            }
            world.setBlock(n, n2, n3, this.blockID, n4, 3);
        }
    }

    public int _a(World world, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1000;
        for (int i = 0; i < 4; ++i) {
            int n7;
            if (i == 0 && n5 == 1 || i == 1 && n5 == 0 || i == 2 && n5 == 3 || i == 3 && n5 == 2) continue;
            int n8 = n;
            int n9 = n3;
            if (i == 0) {
                n8 = n - 1;
            }
            if (i == 1) {
                ++n8;
            }
            if (i == 2) {
                n9 = n3 - 1;
            }
            if (i == 3) {
                ++n9;
            }
            if (this._c(world, n8, n2, n9) || world.getBlockMaterial(n8, n2, n9) == this.blockMaterial && world.getBlockMetadata(n8, n2, n9) == 0) continue;
            if (!this._c(world, n8, n2 - 1, n9)) {
                return n4;
            }
            if (n4 >= 4 || (n7 = this._a(world, n8, n2, n9, n4 + 1, i)) >= n6) continue;
            n6 = n7;
        }
        return n6;
    }

    public boolean[] _b(World world, int n, int n2, int n3) {
        int n4;
        int n5;
        for (n5 = 0; n5 < 4; ++n5) {
            this._c[n5] = 1000;
            n4 = n;
            int n6 = n3;
            if (n5 == 0) {
                n4 = n - 1;
            }
            if (n5 == 1) {
                ++n4;
            }
            if (n5 == 2) {
                n6 = n3 - 1;
            }
            if (n5 == 3) {
                ++n6;
            }
            if (this._c(world, n4, n2, n6) || world.getBlockMaterial(n4, n2, n6) == this.blockMaterial && world.getBlockMetadata(n4, n2, n6) == 0) continue;
            this._c[n5] = this._c(world, n4, n2 - 1, n6) ? this._a(world, n4, n2, n6, 1, n5) : 0;
        }
        n5 = this._c[0];
        for (n4 = 1; n4 < 4; ++n4) {
            if (this._c[n4] >= n5) continue;
            n5 = this._c[n4];
        }
        for (n4 = 0; n4 < 4; ++n4) {
            this._b[n4] = this._c[n4] == n5;
        }
        return this._b;
    }

    public boolean _c(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        if (n4 != Block.doorWood.blockID && n4 != Block.doorIron.blockID && n4 != Block.signPost.blockID && n4 != Block.ladder.blockID && n4 != Block.reed.blockID) {
            if (n4 == 0) {
                return false;
            }
            Material material = Block.blocksList[n4].blockMaterial;
            return material == Material._D ? true : material._c();
        }
        return true;
    }

    public int _b(World world, int n, int n2, int n3, int n4) {
        int n5 = this._e(world, n, n2, n3);
        if (n5 < 0) {
            return n4;
        }
        if (n5 == 0) {
            ++this._a;
        }
        if (n5 >= 8) {
            n5 = 0;
        }
        return n4 >= 0 && n5 >= n4 ? n4 : n5;
    }

    public boolean _d(World world, int n, int n2, int n3) {
        Material material = world.getBlockMaterial(n, n2, n3);
        return material == this.blockMaterial ? false : (material == Material._i ? false : !this._c(world, n, n2, n3));
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        if (world.getBlockId(n, n2, n3) == this.blockID) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        }
    }

    @Override
    public boolean func_82506_l() {
        return true;
    }
}

