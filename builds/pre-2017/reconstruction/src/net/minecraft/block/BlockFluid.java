/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockFluid
extends Block {
    @SideOnly(value=Side.CLIENT)
    public Icon[] _d;

    public BlockFluid(int n, Material material) {
        super(n, material);
        float f = 0.0f;
        float f2 = 0.0f;
        this.setBlockBounds(0.0f + f2, 0.0f + f, 0.0f + f2, 1.0f + f2, 1.0f + f, 1.0f + f2);
        this.setTickRandomly(true);
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this.blockMaterial != Material._i;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this.blockMaterial != Material._h) {
            return 0xFFFFFF;
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int n7 = iBlockAccess.getBiomeGenForCoords(n + j, n3 + i)._n();
                n4 += (n7 & 0xFF0000) >> 16;
                n5 += (n7 & 0xFF00) >> 8;
                n6 += n7 & 0xFF;
            }
        }
        return (n4 / 9 & 0xFF) << 16 | (n5 / 9 & 0xFF) << 8 | n6 / 9 & 0xFF;
    }

    public static float _a(int n) {
        if (n >= 8) {
            n = 0;
        }
        return (float)(n + 1) / 9.0f;
    }

    @Deprecated
    public float _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 1.0f - BlockFluid._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n != 0 && n != 1 ? this._d[1] : this._d[0];
    }

    public int _e(World world, int n, int n2, int n3) {
        return world.getBlockMaterial(n, n2, n3) == this.blockMaterial ? world.getBlockMetadata(n, n2, n3) : -1;
    }

    public int _b(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockMaterial(n, n2, n3) != this.blockMaterial) {
            return -1;
        }
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (n4 >= 8) {
            n4 = 0;
        }
        return n4;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canCollideCheck(int n, boolean bl) {
        return bl && n == 0;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        Material material = iBlockAccess.getBlockMaterial(n, n2, n3);
        return material == this.blockMaterial ? false : (n4 == 1 ? true : (material == Material._w ? false : super.isBlockSolid(iBlockAccess, n, n2, n3, n4)));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        Material material = iBlockAccess.getBlockMaterial(n, n2, n3);
        return material == this.blockMaterial ? false : (n4 == 1 ? true : (material == Material._w ? false : super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4)));
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int getRenderType() {
        return 4;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    public Vec3 _c(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4;
        Vec3 vec3 = iBlockAccess.getWorldVec3Pool()._a(0.0, 0.0, 0.0);
        int n5 = this._b(iBlockAccess, n, n2, n3);
        for (n4 = 0; n4 < 4; ++n4) {
            int n6;
            int n7;
            int n8 = n;
            int n9 = n3;
            if (n4 == 0) {
                n8 = n - 1;
            }
            if (n4 == 1) {
                n9 = n3 - 1;
            }
            if (n4 == 2) {
                ++n8;
            }
            if (n4 == 3) {
                ++n9;
            }
            if ((n7 = this._b(iBlockAccess, n8, n2, n9)) < 0) {
                if (iBlockAccess.getBlockMaterial(n8, n2, n9)._c() || (n7 = this._b(iBlockAccess, n8, n2 - 1, n9)) < 0) continue;
                n6 = n7 - (n5 - 8);
                vec3 = vec3._c((n8 - n) * n6, (n2 - n2) * n6, (n9 - n3) * n6);
                continue;
            }
            if (n7 < 0) continue;
            n6 = n7 - n5;
            vec3 = vec3._c((n8 - n) * n6, (n2 - n2) * n6, (n9 - n3) * n6);
        }
        if (iBlockAccess.getBlockMetadata(n, n2, n3) >= 8) {
            n4 = 0;
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n, n2, n3 - 1, 2)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n, n2, n3 + 1, 3)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n - 1, n2, n3, 4)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n + 1, n2, n3, 5)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n, n2 + 1, n3 - 1, 2)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n, n2 + 1, n3 + 1, 3)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n - 1, n2 + 1, n3, 4)) {
                n4 = 1;
            }
            if (n4 != 0 || this.isBlockSolid(iBlockAccess, n + 1, n2 + 1, n3, 5)) {
                n4 = 1;
            }
            if (n4 != 0) {
                vec3 = vec3._a()._c(0.0, -6.0, 0.0);
            }
        }
        vec3 = vec3._a();
        return vec3;
    }

    @Override
    public void velocityToAddToEntity(World world, int n, int n2, int n3, Entity entity, Vec3 vec3) {
        Vec3 vec32 = this._c(world, n, n2, n3);
        vec3._c += vec32._c;
        vec3._d += vec32._d;
        vec3._e += vec32._e;
    }

    @Override
    public int tickRate(World world) {
        return this.blockMaterial == Material._h ? 5 : (this.blockMaterial == Material._i ? (world.provider._g ? 10 : 30) : 0);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        this._f(world, n, n2, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        this._f(world, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getMixedBrightnessForBlock(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getLightBrightnessForSkyBlocks(n, n2, n3, 0);
        int n5 = iBlockAccess.getLightBrightnessForSkyBlocks(n, n2 + 1, n3, 0);
        int n6 = n4 & 0xFF;
        int n7 = n5 & 0xFF;
        int n8 = n4 >> 16 & 0xFF;
        int n9 = n5 >> 16 & 0xFF;
        return (n6 > n7 ? n6 : n7) | (n8 > n9 ? n8 : n9) << 16;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float getBlockBrightness(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        float f;
        float f2 = iBlockAccess.getLightBrightness(n, n2, n3);
        return f2 > (f = iBlockAccess.getLightBrightness(n, n2 + 1, n3)) ? f2 : f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return this.blockMaterial == Material._h ? 1 : 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        double d;
        double d2;
        double d3;
        int n4;
        if (this.blockMaterial == Material._h) {
            if (random.nextInt(10) == 0 && ((n4 = world.getBlockMetadata(n, n2, n3)) <= 0 || n4 >= 8)) {
                world.spawnParticle("suspended", (float)n + random.nextFloat(), (float)n2 + random.nextFloat(), (float)n3 + random.nextFloat(), 0.0, 0.0, 0.0);
            }
            for (n4 = 0; n4 < 0; ++n4) {
                int n5 = random.nextInt(4);
                int n6 = n;
                int n7 = n3;
                if (n5 == 0) {
                    n6 = n - 1;
                }
                if (n5 == 1) {
                    ++n6;
                }
                if (n5 == 2) {
                    n7 = n3 - 1;
                }
                if (n5 == 3) {
                    ++n7;
                }
                if (world.getBlockMaterial(n6, n2, n7) != Material._a || !world.getBlockMaterial(n6, n2 - 1, n7)._c() && !world.getBlockMaterial(n6, n2 - 1, n7)._d()) continue;
                float f = 0.0625f;
                d3 = (float)n + random.nextFloat();
                double d4 = (float)n2 + random.nextFloat();
                double d5 = (float)n3 + random.nextFloat();
                if (n5 == 0) {
                    d3 = (float)n - f;
                }
                if (n5 == 1) {
                    d3 = (float)(n + 1) + f;
                }
                if (n5 == 2) {
                    d5 = (float)n3 - f;
                }
                if (n5 == 3) {
                    d5 = (float)(n3 + 1) + f;
                }
                double d6 = 0.0;
                double d7 = 0.0;
                if (n5 == 0) {
                    d6 = -f;
                }
                if (n5 == 1) {
                    d6 = f;
                }
                if (n5 == 2) {
                    d7 = -f;
                }
                if (n5 == 3) {
                    d7 = f;
                }
                world.spawnParticle("splash", d3, d4, d5, d6, 0.0, d7);
            }
        }
        if (this.blockMaterial == Material._h && random.nextInt(64) == 0 && (n4 = world.getBlockMetadata(n, n2, n3)) > 0 && n4 < 8) {
            world.playSound((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "liquid.water", random.nextFloat() * 0.25f + 0.75f, random.nextFloat() * 1.0f + 0.5f, false);
        }
        if (this.blockMaterial == Material._i && world.getBlockMaterial(n, n2 + 1, n3) == Material._a && !world.isBlockOpaqueCube(n, n2 + 1, n3)) {
            if (random.nextInt(100) == 0) {
                d2 = (float)n + random.nextFloat();
                d = (double)n2 + this.maxY;
                d3 = (float)n3 + random.nextFloat();
                world.spawnParticle("lava", d2, d, d3, 0.0, 0.0, 0.0);
                world.playSound(d2, d, d3, "liquid.lavapop", 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
            if (random.nextInt(200) == 0) {
                world.playSound(n, n2, n3, "liquid.lava", 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
        }
        if (random.nextInt(10) == 0 && world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && !world.getBlockMaterial(n, n2 - 2, n3)._c()) {
            d2 = (float)n + random.nextFloat();
            d = (double)n2 - 1.05;
            d3 = (float)n3 + random.nextFloat();
            if (this.blockMaterial == Material._h) {
                world.spawnParticle("dripWater", d2, d, d3, 0.0, 0.0, 0.0);
            } else {
                world.spawnParticle("dripLava", d2, d, d3, 0.0, 0.0, 0.0);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static double _a(IBlockAccess iBlockAccess, int n, int n2, int n3, Material material) {
        Vec3 vec3 = null;
        if (material == Material._h) {
            vec3 = Block.waterMoving._c(iBlockAccess, n, n2, n3);
        }
        if (material == Material._i) {
            vec3 = Block.lavaMoving._c(iBlockAccess, n, n2, n3);
        }
        return vec3._c == 0.0 && vec3._e == 0.0 ? -1000.0 : Math.atan2(vec3._e, vec3._c) - 1.5707963267948966;
    }

    public void _f(World world, int n, int n2, int n3) {
        if (world.getBlockId(n, n2, n3) == this.blockID && this.blockMaterial == Material._i) {
            boolean bl = false;
            if (bl || world.getBlockMaterial(n, n2, n3 - 1) == Material._h) {
                bl = true;
            }
            if (bl || world.getBlockMaterial(n, n2, n3 + 1) == Material._h) {
                bl = true;
            }
            if (bl || world.getBlockMaterial(n - 1, n2, n3) == Material._h) {
                bl = true;
            }
            if (bl || world.getBlockMaterial(n + 1, n2, n3) == Material._h) {
                bl = true;
            }
            if (bl || world.getBlockMaterial(n, n2 + 1, n3) == Material._h) {
                bl = true;
            }
            if (bl) {
                int n4 = world.getBlockMetadata(n, n2, n3);
                if (n4 == 0) {
                    world.setBlock(n, n2, n3, Block.obsidian.blockID);
                } else if (n4 <= 4) {
                    world.setBlock(n, n2, n3, Block.cobblestone.blockID);
                }
                this._g(world, n, n2, n3);
            }
        }
    }

    public void _g(World world, int n, int n2, int n3) {
        world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
        for (int i = 0; i < 8; ++i) {
            world.spawnParticle("largesmoke", (double)n + Math.random(), (double)n2 + 1.2, (double)n3 + Math.random(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._d = this.blockMaterial == Material._i ? new Icon[]{iconRegister._b("lava_still"), iconRegister._b("lava_flow")} : new Icon[]{iconRegister._b("water_still"), iconRegister._b("water_flow")};
    }

    @SideOnly(value=Side.CLIENT)
    public static Icon _a(String string) {
        return string == "water_still" ? Block.waterMoving._d[0] : (string == "water_flow" ? Block.waterMoving._d[1] : (string == "lava_still" ? Block.lavaMoving._d[0] : (string == "lava_flow" ? Block.lavaMoving._d[1] : null)));
    }
}

