/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonBase
extends Block {
    public final boolean _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;
    @SideOnly(value=Side.CLIENT)
    public Icon _c;
    @SideOnly(value=Side.CLIENT)
    public Icon _d;

    public BlockPistonBase(int n, boolean bl) {
        super(n, Material._G);
        this._a = bl;
        this.setStepSound(soundStoneFootstep);
        this.setHardness(0.5f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _a() {
        return this._d;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.setBlockBounds(f, f2, f3, f4, f5, f6);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        int n3 = BlockPistonBase._a(n2);
        return n3 > 5 ? this._d : (n == n3 ? (!BlockPistonBase._b(n2) && this.minX <= 0.0 && this.minY <= 0.0 && this.minZ <= 0.0 && this.maxX >= 1.0 && this.maxY >= 1.0 && this.maxZ >= 1.0 ? this._d : this._b) : (n == owak._a[n3] ? this._c : this.blockIcon));
    }

    @SideOnly(value=Side.CLIENT)
    public static Icon _a(String string) {
        return string == "piston_side" ? Block.pistonBase.blockIcon : (string == "piston_top_normal" ? Block.pistonBase._d : (string == "piston_top_sticky" ? Block.pistonStickyBase._d : (string == "piston_inner" ? Block.pistonBase._b : null)));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("piston_side");
        this._d = iconRegister._b(this._a ? "piston_top_sticky" : "piston_top_normal");
        this._b = iconRegister._b("piston_inner");
        this._c = iconRegister._b("piston_bottom");
    }

    @Override
    public int getRenderType() {
        return 16;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = BlockPistonBase._a(world, n, n2, n3, entityLivingBase);
        world.func_72921_c(n, n2, n3, n4, 2);
        if (!world.isRemote) {
            this._a(world, n, n2, n3);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            this._a(world, n, n2, n3);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (!world.isRemote && world.getBlockTileEntity(n, n2, n3) == null) {
            this._a(world, n, n2, n3);
        }
    }

    public void _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = BlockPistonBase._a(n4);
        if (n5 != 7) {
            boolean bl = this._a(world, n, n2, n3, n5);
            if (bl && !BlockPistonBase._b(n4)) {
                if (BlockPistonBase._b(world, n, n2, n3, n5)) {
                    world.addBlockEvent(n, n2, n3, this.blockID, 0, n5);
                }
            } else if (!bl && BlockPistonBase._b(n4)) {
                world.func_72921_c(n, n2, n3, n5, 2);
                world.addBlockEvent(n, n2, n3, this.blockID, 1, n5);
            }
        }
    }

    public boolean _a(World world, int n, int n2, int n3, int n4) {
        return n4 != 0 && world.getIndirectPowerOutput(n, n2 - 1, n3, 0) ? true : (n4 != 1 && world.getIndirectPowerOutput(n, n2 + 1, n3, 1) ? true : (n4 != 2 && world.getIndirectPowerOutput(n, n2, n3 - 1, 2) ? true : (n4 != 3 && world.getIndirectPowerOutput(n, n2, n3 + 1, 3) ? true : (n4 != 5 && world.getIndirectPowerOutput(n + 1, n2, n3, 5) ? true : (n4 != 4 && world.getIndirectPowerOutput(n - 1, n2, n3, 4) ? true : (world.getIndirectPowerOutput(n, n2, n3, 0) ? true : (world.getIndirectPowerOutput(n, n2 + 2, n3, 1) ? true : (world.getIndirectPowerOutput(n, n2 + 1, n3 - 1, 2) ? true : (world.getIndirectPowerOutput(n, n2 + 1, n3 + 1, 3) ? true : (world.getIndirectPowerOutput(n - 1, n2 + 1, n3, 4) ? true : world.getIndirectPowerOutput(n + 1, n2 + 1, n3, 5)))))))))));
    }

    @Override
    public boolean onBlockEventReceived(World world, int n, int n2, int n3, int n4, int n5) {
        if (!world.isRemote) {
            boolean bl = this._a(world, n, n2, n3, n5);
            if (bl && n4 == 1) {
                world.func_72921_c(n, n2, n3, n5 | 8, 2);
                return false;
            }
            if (!bl && n4 == 0) {
                return false;
            }
        }
        if (n4 == 0) {
            if (!this._c(world, n, n2, n3, n5)) {
                return false;
            }
            world.func_72921_c(n, n2, n3, n5 | 8, 2);
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "tile.piston.out", 0.5f, world.rand.nextFloat() * 0.25f + 0.6f);
        } else if (n4 == 1) {
            TileEntity tileEntity = world.getBlockTileEntity(n + owak._b[n5], n2 + owak._c[n5], n3 + owak._d[n5]);
            if (tileEntity instanceof TileEntityPiston) {
                ((TileEntityPiston)tileEntity)._e();
            }
            world.setBlock(n, n2, n3, Block.pistonMoving.blockID, n5, 3);
            world.setBlockTileEntity(n, n2, n3, BlockPistonMoving._a(this.blockID, n5, n5, false, true));
            if (this._a) {
                TileEntityPiston tileEntityPiston;
                TileEntity tileEntity2;
                int n6 = n + owak._b[n5] * 2;
                int n7 = n2 + owak._c[n5] * 2;
                int n8 = n3 + owak._d[n5] * 2;
                int n9 = world.getBlockId(n6, n7, n8);
                int n10 = world.getBlockMetadata(n6, n7, n8);
                boolean bl = false;
                if (n9 == Block.pistonMoving.blockID && (tileEntity2 = world.getBlockTileEntity(n6, n7, n8)) instanceof TileEntityPiston && (tileEntityPiston = (TileEntityPiston)tileEntity2)._c() == n5 && tileEntityPiston._b()) {
                    tileEntityPiston._e();
                    n9 = tileEntityPiston._a();
                    n10 = tileEntityPiston.getBlockMetadata();
                    bl = true;
                }
                if (!bl && n9 > 0 && BlockPistonBase._a(n9, world, n6, n7, n8, false) && (Block.blocksList[n9].getMobilityFlag() == 0 || n9 == Block.pistonBase.blockID || n9 == Block.pistonStickyBase.blockID)) {
                    world.setBlock(n += owak._b[n5], n2 += owak._c[n5], n3 += owak._d[n5], Block.pistonMoving.blockID, n10, 3);
                    world.setBlockTileEntity(n, n2, n3, BlockPistonMoving._a(n9, n10, n5, false, false));
                    world.setBlockToAir(n6, n7, n8);
                } else if (!bl) {
                    world.setBlockToAir(n + owak._b[n5], n2 + owak._c[n5], n3 + owak._d[n5]);
                }
            } else {
                world.setBlockToAir(n + owak._b[n5], n2 + owak._c[n5], n3 + owak._d[n5]);
            }
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "tile.piston.in", 0.5f, world.rand.nextFloat() * 0.15f + 0.6f);
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (BlockPistonBase._b(n4)) {
            float f = 0.25f;
            switch (BlockPistonBase._a(n4)) {
                case 0: {
                    this.setBlockBounds(0.0f, 0.25f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
                    break;
                }
                case 2: {
                    this.setBlockBounds(0.0f, 0.0f, 0.25f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.75f);
                    break;
                }
                case 4: {
                    this.setBlockBounds(0.25f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 5: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.75f, 1.0f, 1.0f);
                }
            }
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    public static int _a(int n) {
        return n & 7;
    }

    public static boolean _b(int n) {
        return (n & 8) != 0;
    }

    public static int _a(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        int n4;
        if (sajh._e((float)entityLivingBase.posX - (float)n) < 2.0f && sajh._e((float)entityLivingBase.posZ - (float)n3) < 2.0f) {
            double d = entityLivingBase.posY + 1.82 - (double)entityLivingBase.yOffset;
            if (d - (double)n2 > 2.0) {
                return 1;
            }
            if ((double)n2 - d > 0.0) {
                return 0;
            }
        }
        return (n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) == 0 ? 2 : (n4 == 1 ? 5 : (n4 == 2 ? 3 : (n4 == 3 ? 4 : 0)));
    }

    public static boolean _a(int n, World world, int n2, int n3, int n4, boolean bl) {
        if (n == Block.obsidian.blockID) {
            return false;
        }
        if (n != Block.pistonBase.blockID && n != Block.pistonStickyBase.blockID) {
            if (Block.blocksList[n].getBlockHardness(world, n2, n3, n4) == -1.0f) {
                return false;
            }
            if (Block.blocksList[n].getMobilityFlag() == 2) {
                return false;
            }
            if (Block.blocksList[n].getMobilityFlag() == 1) {
                return bl;
            }
        } else if (BlockPistonBase._b(world.getBlockMetadata(n2, n3, n4))) {
            return false;
        }
        return !world.blockHasTileEntity(n2, n3, n4);
    }

    public static boolean _b(World world, int n, int n2, int n3, int n4) {
        int n5 = n + owak._b[n4];
        int n6 = n2 + owak._c[n4];
        int n7 = n3 + owak._d[n4];
        for (int i = 0; i < 13; ++i) {
            if (n6 <= 0 || n6 >= world.getHeight() - 1) {
                return false;
            }
            int n8 = world.getBlockId(n5, n6, n7);
            if (world.isAirBlock(n5, n6, n7)) break;
            if (!BlockPistonBase._a(n8, world, n5, n6, n7, true)) {
                return false;
            }
            if (Block.blocksList[n8].getMobilityFlag() == 1) break;
            if (i == 12) {
                return false;
            }
            n5 += owak._b[n4];
            n6 += owak._c[n4];
            n7 += owak._d[n4];
        }
        return true;
    }

    public boolean _c(World world, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10 = n + owak._b[n4];
        int n11 = n2 + owak._c[n4];
        int n12 = n3 + owak._d[n4];
        for (n9 = 0; n9 < 13; ++n9) {
            if (n11 <= 0 || n11 >= world.getHeight() - 1) {
                return false;
            }
            n8 = world.getBlockId(n10, n11, n12);
            if (world.isAirBlock(n10, n11, n12)) break;
            if (!BlockPistonBase._a(n8, world, n10, n11, n12, true)) {
                return false;
            }
            if (Block.blocksList[n8].getMobilityFlag() != 1) {
                if (n9 == 12) {
                    return false;
                }
                n10 += owak._b[n4];
                n11 += owak._c[n4];
                n12 += owak._d[n4];
                continue;
            }
            float f = Block.blocksList[n8] instanceof zgzq ? -1.0f : 1.0f;
            Block.blocksList[n8].dropBlockAsItemWithChance(world, n10, n11, n12, world.getBlockMetadata(n10, n11, n12), f, 0);
            world.setBlockToAir(n10, n11, n12);
            break;
        }
        n9 = n10;
        n8 = n11;
        int n13 = n12;
        int n14 = 0;
        int[] nArray = new int[13];
        while (n10 != n || n11 != n2 || n12 != n3) {
            n7 = n10 - owak._b[n4];
            n6 = n11 - owak._c[n4];
            n5 = n12 - owak._d[n4];
            int n15 = world.getBlockId(n7, n6, n5);
            int n16 = world.getBlockMetadata(n7, n6, n5);
            if (n15 == this.blockID && n7 == n && n6 == n2 && n5 == n3) {
                world.setBlock(n10, n11, n12, Block.pistonMoving.blockID, n4 | (this._a ? 8 : 0), 4);
                world.setBlockTileEntity(n10, n11, n12, BlockPistonMoving._a(Block.pistonExtension.blockID, n4 | (this._a ? 8 : 0), n4, true, false));
            } else {
                world.setBlock(n10, n11, n12, Block.pistonMoving.blockID, n16, 4);
                world.setBlockTileEntity(n10, n11, n12, BlockPistonMoving._a(n15, n16, n4, true, false));
            }
            nArray[n14++] = n15;
            n10 = n7;
            n11 = n6;
            n12 = n5;
        }
        n10 = n9;
        n11 = n8;
        n12 = n13;
        n14 = 0;
        while (n10 != n || n11 != n2 || n12 != n3) {
            n7 = n10 - owak._b[n4];
            n6 = n11 - owak._c[n4];
            n5 = n12 - owak._d[n4];
            world.notifyBlocksOfNeighborChange(n7, n6, n5, nArray[n14++]);
            n10 = n7;
            n11 = n6;
            n12 = n5;
        }
        return true;
    }
}

