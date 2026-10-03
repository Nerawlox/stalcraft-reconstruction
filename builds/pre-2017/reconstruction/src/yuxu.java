/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class yuxu
extends Block {
    public static final int[][] _a = new int[][]{{2, 6}, {3, 7}, {2, 3}, {6, 7}, {0, 4}, {1, 5}, {0, 1}, {4, 5}};
    public final Block _b;
    public final int _c;
    public boolean _d;
    public int _e;

    public yuxu(int n, Block block, int n2) {
        super(n, block.blockMaterial);
        this._b = block;
        this._c = n2;
        this.setHardness(block.blockHardness);
        this.setResistance(block.blockResistance / 3.0f);
        this.setStepSound(block.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this._d) {
            this.setBlockBounds(0.5f * (float)(this._e % 2), 0.5f * (float)(this._e / 2 % 2), 0.5f * (float)(this._e / 4 % 2), 0.5f + 0.5f * (float)(this._e % 2), 0.5f + 0.5f * (float)(this._e / 2 % 2), 0.5f + 0.5f * (float)(this._e / 4 % 2));
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 10;
    }

    public void _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if ((n4 & 4) != 0) {
            this.setBlockBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }

    public static boolean _a(int n) {
        return n > 0 && Block.blocksList[n] instanceof yuxu;
    }

    public boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        return yuxu._a(n5) && iBlockAccess.getBlockMetadata(n, n2, n3) == n4;
    }

    public boolean _b(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 3;
        float f = 0.5f;
        float f2 = 1.0f;
        if ((n4 & 4) != 0) {
            f = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.5f;
        boolean bl = true;
        if (n5 == 0) {
            f3 = 0.5f;
            f6 = 1.0f;
            int n6 = iBlockAccess.getBlockId(n + 1, n2, n3);
            int n7 = iBlockAccess.getBlockMetadata(n + 1, n2, n3);
            if (yuxu._a(n6) && (n4 & 4) == (n7 & 4)) {
                int n8 = n7 & 3;
                if (n8 == 3 && !this._a(iBlockAccess, n, n2, n3 + 1, n4)) {
                    f6 = 0.5f;
                    bl = false;
                } else if (n8 == 2 && !this._a(iBlockAccess, n, n2, n3 - 1, n4)) {
                    f5 = 0.5f;
                    bl = false;
                }
            }
        } else if (n5 == 1) {
            f4 = 0.5f;
            f6 = 1.0f;
            int n9 = iBlockAccess.getBlockId(n - 1, n2, n3);
            int n10 = iBlockAccess.getBlockMetadata(n - 1, n2, n3);
            if (yuxu._a(n9) && (n4 & 4) == (n10 & 4)) {
                int n11 = n10 & 3;
                if (n11 == 3 && !this._a(iBlockAccess, n, n2, n3 + 1, n4)) {
                    f6 = 0.5f;
                    bl = false;
                } else if (n11 == 2 && !this._a(iBlockAccess, n, n2, n3 - 1, n4)) {
                    f5 = 0.5f;
                    bl = false;
                }
            }
        } else if (n5 == 2) {
            f5 = 0.5f;
            f6 = 1.0f;
            int n12 = iBlockAccess.getBlockId(n, n2, n3 + 1);
            int n13 = iBlockAccess.getBlockMetadata(n, n2, n3 + 1);
            if (yuxu._a(n12) && (n4 & 4) == (n13 & 4)) {
                int n14 = n13 & 3;
                if (n14 == 1 && !this._a(iBlockAccess, n + 1, n2, n3, n4)) {
                    f4 = 0.5f;
                    bl = false;
                } else if (n14 == 0 && !this._a(iBlockAccess, n - 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    bl = false;
                }
            }
        } else if (n5 == 3) {
            int n15 = iBlockAccess.getBlockId(n, n2, n3 - 1);
            int n16 = iBlockAccess.getBlockMetadata(n, n2, n3 - 1);
            if (yuxu._a(n15) && (n4 & 4) == (n16 & 4)) {
                int n17 = n16 & 3;
                if (n17 == 1 && !this._a(iBlockAccess, n + 1, n2, n3, n4)) {
                    f4 = 0.5f;
                    bl = false;
                } else if (n17 == 0 && !this._a(iBlockAccess, n - 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    bl = false;
                }
            }
        }
        this.setBlockBounds(f3, f, f5, f4, f2, f6);
        return bl;
    }

    public boolean _c(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 3;
        float f = 0.5f;
        float f2 = 1.0f;
        if ((n4 & 4) != 0) {
            f = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.5f;
        float f6 = 1.0f;
        boolean bl = false;
        if (n5 == 0) {
            int n6 = iBlockAccess.getBlockId(n - 1, n2, n3);
            int n7 = iBlockAccess.getBlockMetadata(n - 1, n2, n3);
            if (yuxu._a(n6) && (n4 & 4) == (n7 & 4)) {
                int n8 = n7 & 3;
                if (n8 == 3 && !this._a(iBlockAccess, n, n2, n3 - 1, n4)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    bl = true;
                } else if (n8 == 2 && !this._a(iBlockAccess, n, n2, n3 + 1, n4)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    bl = true;
                }
            }
        } else if (n5 == 1) {
            int n9 = iBlockAccess.getBlockId(n + 1, n2, n3);
            int n10 = iBlockAccess.getBlockMetadata(n + 1, n2, n3);
            if (yuxu._a(n9) && (n4 & 4) == (n10 & 4)) {
                f3 = 0.5f;
                f4 = 1.0f;
                int n11 = n10 & 3;
                if (n11 == 3 && !this._a(iBlockAccess, n, n2, n3 - 1, n4)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    bl = true;
                } else if (n11 == 2 && !this._a(iBlockAccess, n, n2, n3 + 1, n4)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    bl = true;
                }
            }
        } else if (n5 == 2) {
            int n12 = iBlockAccess.getBlockId(n, n2, n3 - 1);
            int n13 = iBlockAccess.getBlockMetadata(n, n2, n3 - 1);
            if (yuxu._a(n12) && (n4 & 4) == (n13 & 4)) {
                f5 = 0.0f;
                f6 = 0.5f;
                int n14 = n13 & 3;
                if (n14 == 1 && !this._a(iBlockAccess, n - 1, n2, n3, n4)) {
                    bl = true;
                } else if (n14 == 0 && !this._a(iBlockAccess, n + 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    bl = true;
                }
            }
        } else if (n5 == 3) {
            int n15 = iBlockAccess.getBlockId(n, n2, n3 + 1);
            int n16 = iBlockAccess.getBlockMetadata(n, n2, n3 + 1);
            if (yuxu._a(n15) && (n4 & 4) == (n16 & 4)) {
                int n17 = n16 & 3;
                if (n17 == 1 && !this._a(iBlockAccess, n - 1, n2, n3, n4)) {
                    bl = true;
                } else if (n17 == 0 && !this._a(iBlockAccess, n + 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    bl = true;
                }
            }
        }
        if (bl) {
            this.setBlockBounds(f3, f, f5, f4, f2, f6);
        }
        return bl;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        this._a(world, n, n2, n3);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        boolean bl = this._b(world, n, n2, n3);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        if (bl && this._c(world, n, n2, n3)) {
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        this._b.randomDisplayTick(world, n, n2, n3, random);
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._b.onBlockClicked(world, n, n2, n3, entityPlayer);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
        this._b.onBlockDestroyedByPlayer(world, n, n2, n3, n4);
    }

    @Override
    public int getMixedBrightnessForBlock(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this._b.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3);
    }

    @Override
    public float getBlockBrightness(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this._b.getBlockBrightness(iBlockAccess, n, n2, n3);
    }

    @Override
    public float getExplosionResistance(Entity entity) {
        return this._b.getExplosionResistance(entity);
    }

    @Override
    public int getRenderBlockPass() {
        return this._b.getRenderBlockPass();
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return this._b.getIcon(n, this._c);
    }

    @Override
    public int tickRate(World world) {
        return this._b.tickRate(world);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return this._b.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void velocityToAddToEntity(World world, int n, int n2, int n3, Entity entity, Vec3 vec3) {
        this._b.velocityToAddToEntity(world, n, n2, n3, entity, vec3);
    }

    @Override
    public boolean isCollidable() {
        return this._b.isCollidable();
    }

    @Override
    public boolean canCollideCheck(int n, boolean bl) {
        return this._b.canCollideCheck(n, bl);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return this._b.canPlaceBlockAt(world, n, n2, n3);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        this.onNeighborBlockChange(world, n, n2, n3, 0);
        this._b.onBlockAdded(world, n, n2, n3);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        this._b.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public void onEntityWalking(World world, int n, int n2, int n3, Entity entity) {
        this._b.onEntityWalking(world, n, n2, n3, entity);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        this._b.updateTick(world, n, n2, n3, random);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return this._b.onBlockActivated(world, n, n2, n3, entityPlayer, 0, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int n, int n2, int n3, Explosion explosion) {
        this._b.onBlockDestroyedByExplosion(world, n, n2, n3, explosion);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        int n5 = world.getBlockMetadata(n, n2, n3) & 4;
        if (n4 == 0) {
            world.func_72921_c(n, n2, n3, 2 | n5, 2);
        }
        if (n4 == 1) {
            world.func_72921_c(n, n2, n3, 1 | n5, 2);
        }
        if (n4 == 2) {
            world.func_72921_c(n, n2, n3, 3 | n5, 2);
        }
        if (n4 == 3) {
            world.func_72921_c(n, n2, n3, 0 | n5, 2);
        }
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (n4 == 0 || n4 != 1 && (double)f2 > 0.5) {
            return n5 | 4;
        }
        return n5;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        void var12_16;
        void object;
        MovingObjectPosition[] movingObjectPositionArray = new MovingObjectPosition[8];
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 3;
        boolean bl = (n4 & 4) == 4;
        int[] nArray = _a[n5 + (bl ? 4 : 0)];
        this._d = true;
        boolean i = false;
        while (object < 8) {
            this._e = object;
            int[] nArray2 = nArray;
            int n6 = nArray2.length;
            for (int j = 0; j < n6; ++j) {
                int n7 = nArray2[j];
                if (n7 != object) continue;
            }
            movingObjectPositionArray[object] = super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
            ++object;
        }
        for (int j : nArray) {
            movingObjectPositionArray[j] = null;
        }
        Object var12_15 = null;
        double d = 0.0;
        for (MovingObjectPosition movingObjectPosition : movingObjectPositionArray) {
            double d2;
            if (movingObjectPosition == null || !((d2 = movingObjectPosition._h._e(vec32)) > d)) continue;
            MovingObjectPosition movingObjectPosition2 = movingObjectPosition;
            d = d2;
        }
        return var12_16;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

