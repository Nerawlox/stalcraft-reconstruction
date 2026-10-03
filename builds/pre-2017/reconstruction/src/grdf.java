/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ugqx;
import net.minecraft.world.World;

public class grdf
extends Item {
    public final Class _a;

    public grdf(int n, Class clazz) {
        super(n);
        this._a = clazz;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 == 0) {
            return false;
        }
        if (n4 == 1) {
            return false;
        }
        int n5 = ugqx._e[n4];
        EntityHanging entityHanging = this._a(world, n, n2, n3, n5);
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (entityHanging != null && entityHanging.onValidSurface()) {
            if (!world.isRemote) {
                world.spawnEntityInWorld(entityHanging);
            }
            --itemStack._b;
        }
        return true;
    }

    public EntityHanging _a(World world, int n, int n2, int n3, int n4) {
        if (this._a == EntityPainting.class) {
            return new EntityPainting(world, n, n2, n3, n4);
        }
        if (this._a == EntityItemFrame.class) {
            return new EntityItemFrame(world, n, n2, n3, n4);
        }
        return null;
    }
}

