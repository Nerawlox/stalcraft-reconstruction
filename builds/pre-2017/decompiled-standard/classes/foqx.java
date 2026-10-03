/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class foqx
implements aqaj {
    public dzfd _a;
    public yfgy _b;

    public foqx(dzfd dzfd2, yfgy yfgy2) {
        this._a = dzfd2;
        this._b = yfgy2;
    }

    @Override
    public void _a(String string, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    @Override
    public void _b(Entity entity) {
        this._b.func_73039_n()._a(entity);
    }

    @Override
    public void _c(Entity entity) {
        this._b.func_73039_n()._b(entity);
    }

    @Override
    public void _a(String string, double d, double d2, double d3, float f, float f2) {
        this._a.__ag()._a(d, d2, d3, f > 1.0f ? (double)(16.0f * f) : 16.0, this._b.field_73011_w._i, new lpza(string, d, d2, d3, f, f2));
    }

    @Override
    public void _a(EntityPlayer entityPlayer, String string, double d, double d2, double d3, float f, float f2) {
        this._a.__ag()._a(entityPlayer, d, d2, d3, f > 1.0f ? (double)(16.0f * f) : 16.0, this._b.field_73011_w._i, new lpza(string, d, d2, d3, f, f2));
    }

    @Override
    public void _b(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void _b(int n, int n2, int n3) {
        this._b.func_73040_p()._a(n, n2, n3);
    }

    @Override
    public void _c(int n, int n2, int n3) {
    }

    @Override
    public void _a(String string, int n, int n2, int n3) {
    }

    @Override
    public void _a(EntityPlayer entityPlayer, int n, int n2, int n3, int n4, int n5) {
        this._a.__ag()._a(entityPlayer, n2, n3, n4, 64.0, this._b.field_73011_w._i, new qohl(n, n2, n3, n4, n5, false));
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, int n5) {
        this._a.__ag()._a(new qohl(n, n2, n3, n4, n5, true));
    }

    @Override
    public void _b(int n, int n2, int n3, int n4, int n5) {
        for (EntityPlayerMP entityPlayerMP : this._a.__ag()._e) {
            double d;
            double d2;
            double d3;
            if (entityPlayerMP == null || entityPlayerMP.field_70170_p != this._b || entityPlayerMP.field_70157_k == n || !((d3 = (double)n2 - entityPlayerMP.field_70165_t) * d3 + (d2 = (double)n3 - entityPlayerMP.field_70163_u) * d2 + (d = (double)n4 - entityPlayerMP.field_70161_v) * d < 1024.0)) continue;
            entityPlayerMP.field_71135_a.func_72567_b(new igpu(n, n2, n3, n4, n5));
        }
    }
}

