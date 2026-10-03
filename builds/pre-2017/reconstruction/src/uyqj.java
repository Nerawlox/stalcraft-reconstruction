/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class uyqj
extends gphy {
    public int _h;
    private satl _k;
    private Random _l = new Random();
    public String _i = "";
    public String _j = "";

    public uyqj(int n, int n2, boolean bl) {
        super(n, bl);
        this._h = n2;
    }

    @Override
    public boolean hasTileEntity(int n) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new hbio(this);
    }

    public satl _a() {
        if (this._k != null) {
            return this._k;
        }
        if (GloomyCore.side.isServer()) {
            return InvokeWithResult.frontend(() -> null);
        }
        return null;
    }

    public uyqj _a(satl satl2) {
        this._k = satl2;
        return this;
    }

    @Override
    public void onBlockPreDestroy(World world, int n, int n2, int n3, int n4) {
        super.onBlockPreDestroy(world, n, n2, n3, n4);
        if (!world.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityChest != null) {
            for (int i = 0; i < tileEntityChest.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntityChest.getStackInSlot(i);
                if (itemStack == null) continue;
                float f = this._l.nextFloat() * 0.8f + 0.1f;
                float f2 = this._l.nextFloat() * 0.8f + 0.1f;
                float f3 = this._l.nextFloat() * 0.8f + 0.1f;
                while (itemStack._b > 0) {
                    int n6 = this._l.nextInt(21) + 10;
                    if (n6 > itemStack._b) {
                        n6 = itemStack._b;
                    }
                    itemStack._b -= n6;
                    EntityItem entityItem = new EntityItem(world, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack._d, n6, itemStack._j()));
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this._l.nextGaussian() * f4;
                    entityItem.motionY = (float)this._l.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this._l.nextGaussian() * f4;
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
        IInventory iInventory = this._a(world, n, n2, n3);
        if (iInventory != null) {
            entityPlayer.displayGUIChest(iInventory);
        }
        return true;
    }

    public IInventory _a(World world, int n, int n2, int n3) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity != null && !(tileEntity instanceof hbio)) {
            tileEntity.invalidate();
        }
        return (IInventory)((Object)world.getBlockTileEntity(n, n2, n3));
    }
}

