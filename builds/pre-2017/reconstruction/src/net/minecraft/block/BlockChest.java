/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockChest
extends BlockContainer {
    public final Random _a = new Random();
    public final int _b;

    public BlockChest(int n, int n2) {
        super(n, Material._d);
        this._b = n2;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
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
        return 22;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockId(n, n2, n3 - 1) == this.blockID) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0f, 0.9375f, 0.875f, 0.9375f);
        } else if (iBlockAccess.getBlockId(n, n2, n3 + 1) == this.blockID) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 1.0f);
        } else if (iBlockAccess.getBlockId(n - 1, n2, n3) == this.blockID) {
            this.setBlockBounds(0.0f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        } else if (iBlockAccess.getBlockId(n + 1, n2, n3) == this.blockID) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 1.0f, 0.875f, 0.9375f);
        } else {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        this._a(world, n, n2, n3);
        int n4 = world.getBlockId(n, n2, n3 - 1);
        int n5 = world.getBlockId(n, n2, n3 + 1);
        int n6 = world.getBlockId(n - 1, n2, n3);
        int n7 = world.getBlockId(n + 1, n2, n3);
        if (n4 == this.blockID) {
            this._a(world, n, n2, n3 - 1);
        }
        if (n5 == this.blockID) {
            this._a(world, n, n2, n3 + 1);
        }
        if (n6 == this.blockID) {
            this._a(world, n - 1, n2, n3);
        }
        if (n7 == this.blockID) {
            this._a(world, n + 1, n2, n3);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = world.getBlockId(n, n2, n3 - 1);
        int n5 = world.getBlockId(n, n2, n3 + 1);
        int n6 = world.getBlockId(n - 1, n2, n3);
        int n7 = world.getBlockId(n + 1, n2, n3);
        int n8 = 0;
        int n9 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        if (n9 == 0) {
            n8 = 2;
        }
        if (n9 == 1) {
            n8 = 5;
        }
        if (n9 == 2) {
            n8 = 3;
        }
        if (n9 == 3) {
            n8 = 4;
        }
        if (n4 != this.blockID && n5 != this.blockID && n6 != this.blockID && n7 != this.blockID) {
            world.func_72921_c(n, n2, n3, n8, 3);
        } else {
            if (!(n4 != this.blockID && n5 != this.blockID || n8 != 4 && n8 != 5)) {
                if (n4 == this.blockID) {
                    world.func_72921_c(n, n2, n3 - 1, n8, 3);
                } else {
                    world.func_72921_c(n, n2, n3 + 1, n8, 3);
                }
                world.func_72921_c(n, n2, n3, n8, 3);
            }
            if (!(n6 != this.blockID && n7 != this.blockID || n8 != 2 && n8 != 3)) {
                if (n6 == this.blockID) {
                    world.func_72921_c(n - 1, n2, n3, n8, 3);
                } else {
                    world.func_72921_c(n + 1, n2, n3, n8, 3);
                }
                world.func_72921_c(n, n2, n3, n8, 3);
            }
        }
        if (itemStack._u()) {
            ((TileEntityChest)world.getBlockTileEntity(n, n2, n3))._a(itemStack._s());
        }
    }

    public void _a(World world, int n, int n2, int n3) {
        if (!world.isRemote) {
            int n4;
            int n5 = world.getBlockId(n, n2, n3 - 1);
            int n6 = world.getBlockId(n, n2, n3 + 1);
            int n7 = world.getBlockId(n - 1, n2, n3);
            int n8 = world.getBlockId(n + 1, n2, n3);
            boolean bl = true;
            if (n5 != this.blockID && n6 != this.blockID) {
                if (n7 != this.blockID && n8 != this.blockID) {
                    n4 = 3;
                    if (Block.opaqueCubeLookup[n5] && !Block.opaqueCubeLookup[n6]) {
                        n4 = 3;
                    }
                    if (Block.opaqueCubeLookup[n6] && !Block.opaqueCubeLookup[n5]) {
                        n4 = 2;
                    }
                    if (Block.opaqueCubeLookup[n7] && !Block.opaqueCubeLookup[n8]) {
                        n4 = 5;
                    }
                    if (Block.opaqueCubeLookup[n8] && !Block.opaqueCubeLookup[n7]) {
                        n4 = 4;
                    }
                } else {
                    int n9 = world.getBlockId(n7 == this.blockID ? n - 1 : n + 1, n2, n3 - 1);
                    int n10 = world.getBlockId(n7 == this.blockID ? n - 1 : n + 1, n2, n3 + 1);
                    n4 = 3;
                    boolean bl2 = true;
                    int n11 = n7 == this.blockID ? world.getBlockMetadata(n - 1, n2, n3) : world.getBlockMetadata(n + 1, n2, n3);
                    if (n11 == 2) {
                        n4 = 2;
                    }
                    if ((Block.opaqueCubeLookup[n5] || Block.opaqueCubeLookup[n9]) && !Block.opaqueCubeLookup[n6] && !Block.opaqueCubeLookup[n10]) {
                        n4 = 3;
                    }
                    if ((Block.opaqueCubeLookup[n6] || Block.opaqueCubeLookup[n10]) && !Block.opaqueCubeLookup[n5] && !Block.opaqueCubeLookup[n9]) {
                        n4 = 2;
                    }
                }
            } else {
                int n12 = world.getBlockId(n - 1, n2, n5 == this.blockID ? n3 - 1 : n3 + 1);
                int n13 = world.getBlockId(n + 1, n2, n5 == this.blockID ? n3 - 1 : n3 + 1);
                n4 = 5;
                boolean bl3 = true;
                int n14 = n5 == this.blockID ? world.getBlockMetadata(n, n2, n3 - 1) : world.getBlockMetadata(n, n2, n3 + 1);
                if (n14 == 4) {
                    n4 = 4;
                }
                if ((Block.opaqueCubeLookup[n7] || Block.opaqueCubeLookup[n12]) && !Block.opaqueCubeLookup[n8] && !Block.opaqueCubeLookup[n13]) {
                    n4 = 5;
                }
                if ((Block.opaqueCubeLookup[n8] || Block.opaqueCubeLookup[n13]) && !Block.opaqueCubeLookup[n7] && !Block.opaqueCubeLookup[n12]) {
                    n4 = 4;
                }
            }
            world.func_72921_c(n, n2, n3, n4, 3);
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        int n4 = 0;
        if (world.getBlockId(n - 1, n2, n3) == this.blockID) {
            ++n4;
        }
        if (world.getBlockId(n + 1, n2, n3) == this.blockID) {
            ++n4;
        }
        if (world.getBlockId(n, n2, n3 - 1) == this.blockID) {
            ++n4;
        }
        if (world.getBlockId(n, n2, n3 + 1) == this.blockID) {
            ++n4;
        }
        return n4 > 1 ? false : (this._b(world, n - 1, n2, n3) ? false : (this._b(world, n + 1, n2, n3) ? false : (this._b(world, n, n2, n3 - 1) ? false : !this._b(world, n, n2, n3 + 1))));
    }

    public boolean _b(World world, int n, int n2, int n3) {
        return world.getBlockId(n, n2, n3) != this.blockID ? false : (world.getBlockId(n - 1, n2, n3) == this.blockID ? true : (world.getBlockId(n + 1, n2, n3) == this.blockID ? true : (world.getBlockId(n, n2, n3 - 1) == this.blockID ? true : world.getBlockId(n, n2, n3 + 1) == this.blockID)));
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        super.onNeighborBlockChange(world, n, n2, n3, n4);
        TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityChest != null) {
            tileEntityChest.updateContainingBlockInfo();
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityChest != null) {
            for (int i = 0; i < tileEntityChest.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntityChest.getStackInSlot(i);
                if (itemStack == null) continue;
                float f = this._a.nextFloat() * 0.8f + 0.1f;
                float f2 = this._a.nextFloat() * 0.8f + 0.1f;
                float f3 = this._a.nextFloat() * 0.8f + 0.1f;
                while (itemStack._b > 0) {
                    int n6 = this._a.nextInt(21) + 10;
                    if (n6 > itemStack._b) {
                        n6 = itemStack._b;
                    }
                    itemStack._b -= n6;
                    EntityItem entityItem = new EntityItem(world, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack._d, n6, itemStack._j()));
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this._a.nextGaussian() * f4;
                    entityItem.motionY = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this._a.nextGaussian() * f4;
                    if (itemStack._p()) {
                        entityItem.getEntityItem()._d((NBTTagCompound)itemStack._q()._c());
                    }
                    world.spawnEntityInWorld(entityItem);
                }
            }
            world.func_96440_m(n, n2, n3, n4);
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        IInventory iInventory = this._c(world, n, n2, n3);
        if (iInventory != null) {
            entityPlayer.displayGUIChest(iInventory);
        }
        return true;
    }

    public IInventory _c(World world, int n, int n2, int n3) {
        IInventory iInventory = (TileEntityChest)world.getBlockTileEntity(n, n2, n3);
        if (iInventory == null) {
            return null;
        }
        if (world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN)) {
            return null;
        }
        if (BlockChest._d(world, n, n2, n3)) {
            return null;
        }
        if (world.getBlockId(n - 1, n2, n3) == this.blockID && (world.isBlockSolidOnSide(n - 1, n2 + 1, n3, ForgeDirection.DOWN) || BlockChest._d(world, n - 1, n2, n3))) {
            return null;
        }
        if (world.getBlockId(n + 1, n2, n3) == this.blockID && (world.isBlockSolidOnSide(n + 1, n2 + 1, n3, ForgeDirection.DOWN) || BlockChest._d(world, n + 1, n2, n3))) {
            return null;
        }
        if (world.getBlockId(n, n2, n3 - 1) == this.blockID && (world.isBlockSolidOnSide(n, n2 + 1, n3 - 1, ForgeDirection.DOWN) || BlockChest._d(world, n, n2, n3 - 1))) {
            return null;
        }
        if (world.getBlockId(n, n2, n3 + 1) == this.blockID && (world.isBlockSolidOnSide(n, n2 + 1, n3 + 1, ForgeDirection.DOWN) || BlockChest._d(world, n, n2, n3 + 1))) {
            return null;
        }
        if (world.getBlockId(n - 1, n2, n3) == this.blockID) {
            iInventory = new huew("container.chestDouble", (TileEntityChest)world.getBlockTileEntity(n - 1, n2, n3), iInventory);
        }
        if (world.getBlockId(n + 1, n2, n3) == this.blockID) {
            iInventory = new huew("container.chestDouble", iInventory, (TileEntityChest)world.getBlockTileEntity(n + 1, n2, n3));
        }
        if (world.getBlockId(n, n2, n3 - 1) == this.blockID) {
            iInventory = new huew("container.chestDouble", (TileEntityChest)world.getBlockTileEntity(n, n2, n3 - 1), iInventory);
        }
        if (world.getBlockId(n, n2, n3 + 1) == this.blockID) {
            iInventory = new huew("container.chestDouble", iInventory, (TileEntityChest)world.getBlockTileEntity(n, n2, n3 + 1));
        }
        return iInventory;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        TileEntityChest tileEntityChest = new TileEntityChest();
        return tileEntityChest;
    }

    @Override
    public boolean canProvidePower() {
        return this._b == 1;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (!this.canProvidePower()) {
            return 0;
        }
        int n5 = ((TileEntityChest)iBlockAccess.getBlockTileEntity((int)n, (int)n2, (int)n3))._i;
        return sajh._a(n5, 0, 15);
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return n4 == 1 ? this.isProvidingWeakPower(iBlockAccess, n, n2, n3, n4) : 0;
    }

    public static boolean _d(World world, int n, int n2, int n3) {
        EntityOcelot entityOcelot;
        EntityOcelot entityOcelot2;
        Iterator iterator2 = world.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB._a()._a(n, n2 + 1, n3, n + 1, n2 + 2, n3 + 1)).iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while (!(entityOcelot2 = (entityOcelot = (EntityOcelot)iterator2.next())).isSitting());
        return true;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        return Container.calcRedstoneFromInventory(this._c(world, n, n2, n3));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("planks_oak");
    }
}

