/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class BlockFurnace
extends BlockContainer {
    public final Random _a = new Random();
    public final boolean _b;
    public static boolean _c;
    public Icon _d;
    public Icon _e;

    public BlockFurnace(int n, boolean bl) {
        super(n, Material._e);
        this._b = bl;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.furnaceIdle.blockID;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        this._a(world, n, n2, n3);
    }

    public void _a(World world, int n, int n2, int n3) {
        if (world.isRemote) {
            return;
        }
        int n4 = world.getBlockId(n, n2, n3 - 1);
        int n5 = world.getBlockId(n, n2, n3 + 1);
        int n6 = world.getBlockId(n - 1, n2, n3);
        int n7 = world.getBlockId(n + 1, n2, n3);
        int n8 = 3;
        if (Block.opaqueCubeLookup[n4] && !Block.opaqueCubeLookup[n5]) {
            n8 = 3;
        }
        if (Block.opaqueCubeLookup[n5] && !Block.opaqueCubeLookup[n4]) {
            n8 = 2;
        }
        if (Block.opaqueCubeLookup[n6] && !Block.opaqueCubeLookup[n7]) {
            n8 = 5;
        }
        if (Block.opaqueCubeLookup[n7] && !Block.opaqueCubeLookup[n6]) {
            n8 = 4;
        }
        world.func_72921_c(n, n2, n3, n8, 2);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._d;
        }
        if (n == 0) {
            return this._d;
        }
        if (n != n2) {
            return this.blockIcon;
        }
        return this._e;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("furnace_side");
        this._e = iconRegister._b(this._b ? "furnace_front_on" : "furnace_front_off");
        this._d = iconRegister._b("furnace_top");
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (!this._b) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        float f = (float)n + 0.5f;
        float f2 = (float)n2 + 0.0f + random.nextFloat() * 6.0f / 16.0f;
        float f3 = (float)n3 + 0.5f;
        float f4 = 0.52f;
        float f5 = random.nextFloat() * 0.6f - 0.3f;
        if (n4 == 4) {
            world.spawnParticle("smoke", f - f4, f2, f3 + f5, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f - f4, f2, f3 + f5, 0.0, 0.0, 0.0);
        } else if (n4 == 5) {
            world.spawnParticle("smoke", f + f4, f2, f3 + f5, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f + f4, f2, f3 + f5, 0.0, 0.0, 0.0);
        } else if (n4 == 2) {
            world.spawnParticle("smoke", f + f5, f2, f3 - f4, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f + f5, f2, f3 - f4, 0.0, 0.0, 0.0);
        } else if (n4 == 3) {
            world.spawnParticle("smoke", f + f5, f2, f3 + f4, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f + f5, f2, f3 + f4, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityFurnace != null) {
            entityPlayer.displayGUIFurnace(tileEntityFurnace);
        }
        return true;
    }

    public static void _a(boolean bl, World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        _c = true;
        if (bl) {
            world.setBlock(n, n2, n3, Block.furnaceBurning.blockID);
        } else {
            world.setBlock(n, n2, n3, Block.furnaceIdle.blockID);
        }
        _c = false;
        world.func_72921_c(n, n2, n3, n4, 2);
        if (tileEntity != null) {
            tileEntity.validate();
            world.setBlockTileEntity(n, n2, n3, tileEntity);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityFurnace();
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        if (n4 == 0) {
            world.func_72921_c(n, n2, n3, 2, 2);
        }
        if (n4 == 1) {
            world.func_72921_c(n, n2, n3, 5, 2);
        }
        if (n4 == 2) {
            world.func_72921_c(n, n2, n3, 3, 2);
        }
        if (n4 == 3) {
            world.func_72921_c(n, n2, n3, 4, 2);
        }
        if (itemStack._u()) {
            ((TileEntityFurnace)world.getBlockTileEntity(n, n2, n3))._a(itemStack._s());
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntityFurnace tileEntityFurnace;
        if (!_c && (tileEntityFurnace = (TileEntityFurnace)world.getBlockTileEntity(n, n2, n3)) != null) {
            for (int i = 0; i < tileEntityFurnace.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntityFurnace.getStackInSlot(i);
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
                    if (itemStack._p()) {
                        entityItem.getEntityItem()._d((NBTTagCompound)itemStack._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this._a.nextGaussian() * f4;
                    entityItem.motionY = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this._a.nextGaussian() * f4;
                    world.spawnEntityInWorld(entityItem);
                }
            }
            world.func_96440_m(n, n2, n3, n4);
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        return Container.calcRedstoneFromInventory((IInventory)((Object)world.getBlockTileEntity(n, n2, n3)));
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Block.furnaceIdle.blockID;
    }
}

