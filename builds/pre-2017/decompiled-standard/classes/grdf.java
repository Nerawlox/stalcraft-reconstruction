/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ugqx;

public class grdf
extends tgdv {
    public final Class _a;

    public grdf(int n, Class clazz) {
        super(n);
        this._a = clazz;
        this.func_77637_a(tgbl.field_78031_c);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 == 0) {
            return false;
        }
        if (n4 == 1) {
            return false;
        }
        int n5 = ugqx._e[n4];
        EntityHanging entityHanging = this._a(ozlu2, n, n2, n3, n5);
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (entityHanging != null && entityHanging.func_70518_d()) {
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72838_d(entityHanging);
            }
            --cvzo2._b;
        }
        return true;
    }

    public EntityHanging _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._a == EntityPainting.class) {
            return new EntityPainting(ozlu2, n, n2, n3, n4);
        }
        if (this._a == EntityItemFrame.class) {
            return new EntityItemFrame(ozlu2, n, n2, n3, n4);
        }
        return null;
    }
}

