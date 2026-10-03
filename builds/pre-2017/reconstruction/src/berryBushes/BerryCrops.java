/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import berryBushes.te.BushTE;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BerryCrops
extends BlockContainer {
    @SideOnly(value=Side.CLIENT)
    private Icon[] iconArray;

    public BerryCrops(int n) {
        super(n, Material._d);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Base.berry.itemID;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
        ItemStack itemStack = new ItemStack(Base.berry);
        itemStack._b = 1;
        EntityItem entityItem = new EntityItem(world, n, n2, n3, itemStack);
        if (!world.isRemote) {
            world.spawnEntityInWorld(entityItem);
        }
        if (world.getBlockTileEntity(n, n2, n3) instanceof BushTE) {
            BushTE bushTE = (BushTE)world.getBlockTileEntity(n, n2, n3);
            float f = bushTE.count;
            ItemStack itemStack2 = null;
            if (f > 8000.0f && f < 12000.0f) {
                itemStack2 = new ItemStack(Base.berry);
            }
            if (f >= 12000.0f && f < 18000.0f) {
                itemStack2 = new ItemStack(Base.berryII);
            }
            if (f >= 18000.0f && f < 24000.0f) {
                itemStack2 = new ItemStack(Base.berryIII);
            }
            if (f >= 24000.0f) {
                itemStack2 = new ItemStack(Base.berryIV);
            }
            if (f > 8000.0f) {
                int n5;
                EntityItem entityItem2 = new EntityItem(world, n, n2, n3, itemStack2);
                Random random = new Random();
                itemStack2._b = n5 = random.nextInt(2) + 1;
                if (!world.isRemote) {
                    world.spawnEntityInWorld(entityItem2);
                }
                bushTE.count = 5000.0f;
                bushTE.stack = null;
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (entityPlayer.getCurrentEquippedItem() != null) {
            if (entityPlayer.getCurrentEquippedItem()._a() instanceof hugs && entityPlayer.getCurrentEquippedItem()._j() == 15 && world.getBlockTileEntity(n, n2, n3) instanceof BushTE) {
                BushTE bushTE = (BushTE)world.getBlockTileEntity(n, n2, n3);
                if (bushTE.count < 24000.0f) {
                    bushTE.count += 400.0f;
                    if (!entityPlayer.capabilities._d) {
                        --entityPlayer.getCurrentEquippedItem()._b;
                    }
                }
            }
        } else if (world.getBlockTileEntity(n, n2, n3) instanceof BushTE) {
            BushTE bushTE = (BushTE)world.getBlockTileEntity(n, n2, n3);
            float f4 = bushTE.count;
            ItemStack itemStack = null;
            if (f4 > 8000.0f && f4 < 12000.0f) {
                itemStack = new ItemStack(Base.berry);
            }
            if (f4 >= 12000.0f && f4 < 18000.0f) {
                itemStack = new ItemStack(Base.berryII);
            }
            if (f4 >= 18000.0f && f4 < 24000.0f) {
                itemStack = new ItemStack(Base.berryIII);
            }
            if (f4 >= 24000.0f) {
                itemStack = new ItemStack(Base.berryIV);
            }
            if (f4 > 8000.0f) {
                int n5;
                EntityItem entityItem = new EntityItem(world, n, n2, n3, itemStack);
                Random random = new Random();
                itemStack._b = n5 = random.nextInt(2) + 1;
                if (!world.isRemote) {
                    world.spawnEntityInWorld(entityItem);
                }
                bushTE.count = 5000.0f;
                bushTE.stack = null;
            }
        }
        return false;
    }

    @Override
    public int getRenderType() {
        return RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("leaves_oak");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new BushTE();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

