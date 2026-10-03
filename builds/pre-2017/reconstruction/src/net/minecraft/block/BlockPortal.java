/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPortal
extends dgwv {
    public BlockPortal(int n) {
        super(n, "portal", Material._D, false);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        super.updateTick(world, n, n2, n3, random);
        if (world.provider._d() && random.nextInt(2000) < world.difficultySetting) {
            Entity entity;
            int n4;
            for (n4 = n2; !world.doesBlockHaveSolidTopSurface(n, n4, n3) && n4 > 0; --n4) {
            }
            if (n4 > 0 && !world.isBlockNormalCube(n, n4 + 1, n3) && (entity = ItemMonsterPlacer._a(world, 57, (double)n + 0.5, (double)n4 + 1.1, (double)n3 + 0.5)) != null) {
                entity.timeUntilPortal = entity.getPortalCooldown();
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockId(n - 1, n2, n3) != this.blockID && iBlockAccess.getBlockId(n + 1, n2, n3) != this.blockID) {
            float f = 0.125f;
            float f2 = 0.5f;
            this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f2, 0.5f + f, 1.0f, 0.5f + f2);
        } else {
            float f = 0.5f;
            float f3 = 0.125f;
            this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f3, 0.5f + f, 1.0f, 0.5f + f3);
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

    public boolean _a(World world, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = 0;
        int n7 = 0;
        if (world.getBlockId(n - 1, n2, n3) == Block.obsidian.blockID || world.getBlockId(n + 1, n2, n3) == Block.obsidian.blockID) {
            n6 = 1;
        }
        if (world.getBlockId(n, n2, n3 - 1) == Block.obsidian.blockID || world.getBlockId(n, n2, n3 + 1) == Block.obsidian.blockID) {
            n7 = 1;
        }
        if (n6 == n7) {
            return false;
        }
        if (world.isAirBlock(n - n6, n2, n3 - n7)) {
            n -= n6;
            n3 -= n7;
        }
        for (n5 = -1; n5 <= 2; ++n5) {
            for (n4 = -1; n4 <= 3; ++n4) {
                boolean bl;
                boolean bl2 = bl = n5 == -1 || n5 == 2 || n4 == -1 || n4 == 3;
                if ((n5 == -1 || n5 == 2) && (n4 == -1 || n4 == 3)) continue;
                int n8 = world.getBlockId(n + n6 * n5, n2 + n4, n3 + n7 * n5);
                boolean bl3 = world.isAirBlock(n + n6 * n5, n2 + n4, n3 + n7 * n5);
                if (!(bl ? n8 != Block.obsidian.blockID : !bl3 && n8 != Block.fire.blockID)) continue;
                return false;
            }
        }
        for (n5 = 0; n5 < 2; ++n5) {
            for (n4 = 0; n4 < 3; ++n4) {
                world.setBlock(n + n6 * n5, n2 + n4, n3 + n7 * n5, Block.portal.blockID, 0, 2);
            }
        }
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = 1;
        if (world.getBlockId(n - 1, n2, n3) == this.blockID || world.getBlockId(n + 1, n2, n3) == this.blockID) {
            n5 = 1;
            n6 = 0;
        }
        int n7 = n2;
        while (world.getBlockId(n, n7 - 1, n3) == this.blockID) {
            --n7;
        }
        if (world.getBlockId(n, n7 - 1, n3) != Block.obsidian.blockID) {
            world.setBlockToAir(n, n2, n3);
        } else {
            int n8;
            for (n8 = 1; n8 < 4 && world.getBlockId(n, n7 + n8, n3) == this.blockID; ++n8) {
            }
            if (n8 == 3 && world.getBlockId(n, n7 + n8, n3) == Block.obsidian.blockID) {
                boolean bl;
                boolean bl2 = world.getBlockId(n - 1, n2, n3) == this.blockID || world.getBlockId(n + 1, n2, n3) == this.blockID;
                boolean bl3 = bl = world.getBlockId(n, n2, n3 - 1) == this.blockID || world.getBlockId(n, n2, n3 + 1) == this.blockID;
                if (bl2 && bl) {
                    world.setBlockToAir(n, n2, n3);
                } else if (!(world.getBlockId(n + n5, n2, n3 + n6) == Block.obsidian.blockID && world.getBlockId(n - n5, n2, n3 - n6) == this.blockID || world.getBlockId(n - n5, n2, n3 - n6) == Block.obsidian.blockID && world.getBlockId(n + n5, n2, n3 + n6) == this.blockID)) {
                    world.setBlockToAir(n, n2, n3);
                }
            } else {
                world.setBlockToAir(n, n2, n3);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        boolean bl;
        if (iBlockAccess.getBlockId(n, n2, n3) == this.blockID) {
            return false;
        }
        boolean bl2 = iBlockAccess.getBlockId(n - 1, n2, n3) == this.blockID && iBlockAccess.getBlockId(n - 2, n2, n3) != this.blockID;
        boolean bl3 = iBlockAccess.getBlockId(n + 1, n2, n3) == this.blockID && iBlockAccess.getBlockId(n + 2, n2, n3) != this.blockID;
        boolean bl4 = iBlockAccess.getBlockId(n, n2, n3 - 1) == this.blockID && iBlockAccess.getBlockId(n, n2, n3 - 2) != this.blockID;
        boolean bl5 = iBlockAccess.getBlockId(n, n2, n3 + 1) == this.blockID && iBlockAccess.getBlockId(n, n2, n3 + 2) != this.blockID;
        boolean bl6 = bl2 || bl3;
        boolean bl7 = bl = bl4 || bl5;
        return bl6 && n4 == 4 ? true : (bl6 && n4 == 5 ? true : (bl && n4 == 2 ? true : bl && n4 == 3));
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (entity.ridingEntity == null && entity.riddenByEntity == null) {
            entity.setInPortal();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (random.nextInt(100) == 0) {
            world.playSound((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "portal.portal", 0.5f, random.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int i = 0; i < 4; ++i) {
            double d = (float)n + random.nextFloat();
            double d2 = (float)n2 + random.nextFloat();
            double d3 = (float)n3 + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            int n4 = random.nextInt(2) * 2 - 1;
            d4 = ((double)random.nextFloat() - 0.5) * 0.5;
            d5 = ((double)random.nextFloat() - 0.5) * 0.5;
            d6 = ((double)random.nextFloat() - 0.5) * 0.5;
            if (world.getBlockId(n - 1, n2, n3) != this.blockID && world.getBlockId(n + 1, n2, n3) != this.blockID) {
                d = (double)n + 0.5 + 0.25 * (double)n4;
                d4 = random.nextFloat() * 2.0f * (float)n4;
            } else {
                d3 = (double)n3 + 0.5 + 0.25 * (double)n4;
                d6 = random.nextFloat() * 2.0f * (float)n4;
            }
            world.spawnParticle("portal", d, d2, d3, d4, d5, d6);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return 0;
    }
}

