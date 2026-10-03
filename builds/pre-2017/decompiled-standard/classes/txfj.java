/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.dwan;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class txfj
extends tgdv {
    public static final String[] _a = new String[]{"pulling_0", "pulling_1", "pulling_2"};
    @SideOnly(value=Side.CLIENT)
    public dwan[] _b;

    public txfj(int n) {
        super(n);
        this.field_77777_bU = 1;
        this.func_77656_e(384);
        this.func_77637_a(tgbl.field_78037_j);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        boolean bl;
        int n2 = this.func_77626_a(cvzo2) - n;
        ArrowLooseEvent arrowLooseEvent = new ArrowLooseEvent(entityPlayer, cvzo2, n2);
        MinecraftForge.EVENT_BUS.post(arrowLooseEvent);
        if (arrowLooseEvent.isCanceled()) {
            return;
        }
        n2 = arrowLooseEvent.charge;
        boolean bl2 = bl = entityPlayer.field_71075_bZ._d || zhty._a(zhqo._x._y, cvzo2) > 0;
        if (bl || entityPlayer.field_71071_by._d(tgdv.field_77704_l.field_77779_bT)) {
            int n3;
            int n4;
            float f = (float)n2 / 20.0f;
            if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            EntityArrow entityArrow = new EntityArrow(ozlu2, entityPlayer, f * 2.0f);
            if (f == 1.0f) {
                entityArrow.func_70243_d(true);
            }
            if ((n4 = zhty._a(zhqo._u._y, cvzo2)) > 0) {
                entityArrow.func_70239_b(entityArrow.func_70242_d() + (double)n4 * 0.5 + 0.5);
            }
            if ((n3 = zhty._a(zhqo._v._y, cvzo2)) > 0) {
                entityArrow.func_70240_a(n3);
            }
            if (zhty._a(zhqo._w._y, cvzo2) > 0) {
                entityArrow.func_70015_d(100);
            }
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            ozlu2.func_72956_a(entityPlayer, "random.bow", 1.0f, 1.0f / (field_77697_d.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (bl) {
                entityArrow.field_70251_a = 2;
            } else {
                entityPlayer.field_71071_by._c(tgdv.field_77704_l.field_77779_bT);
            }
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72838_d(entityArrow);
            }
        }
    }

    @Override
    public cvzo func_77654_b(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        return cvzo2;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 72000;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._e;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        ArrowNockEvent arrowNockEvent = new ArrowNockEvent(entityPlayer, cvzo2);
        MinecraftForge.EVENT_BUS.post(arrowNockEvent);
        if (arrowNockEvent.isCanceled()) {
            return arrowNockEvent.result;
        }
        if (entityPlayer.field_71075_bZ._d || entityPlayer.field_71071_by._d(tgdv.field_77704_l.field_77779_bT)) {
            entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        }
        return cvzo2;
    }

    @Override
    public int func_77619_b() {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b(this.func_111208_A() + "_standby");
        this._b = new dwan[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = nege2._b(this.func_111208_A() + "_" + _a[i]);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _a(int n) {
        return this._b[n];
    }
}

