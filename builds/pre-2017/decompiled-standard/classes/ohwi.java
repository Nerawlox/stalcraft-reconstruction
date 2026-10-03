/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class ohwi
extends yeso {
    public EntityPlayer _a;
    public int _b;

    public ohwi(EntityPlayer entityPlayer, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
        this._a = entityPlayer;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return false;
    }

    @Override
    public cvzo func_75209_a(int n) {
        if (this.func_75216_d()) {
            this._b += Math.min(n, this.func_75211_c()._b);
        }
        return super.func_75209_a(n);
    }

    @Override
    public void func_82870_a(EntityPlayer entityPlayer, cvzo cvzo2) {
        this.func_75208_c(cvzo2);
        super.func_82870_a(entityPlayer, cvzo2);
    }

    @Override
    public void func_75210_a(cvzo cvzo2, int n) {
        this._b += n;
        this.func_75208_c(cvzo2);
    }

    @Override
    public void func_75208_c(cvzo cvzo2) {
        cvzo2._a(this._a.field_70170_p, this._a, this._b);
        if (!this._a.field_70170_p.field_72995_K) {
            int n;
            int n2 = this._b;
            float f = yewu._a()._b(cvzo2);
            if (f == 0.0f) {
                n2 = 0;
            } else if (f < 1.0f) {
                n = sajh._d((float)n2 * f);
                if (n < sajh._f((float)n2 * f) && (float)Math.random() < (float)n2 * f - (float)n) {
                    ++n;
                }
                n2 = n;
            }
            while (n2 > 0) {
                n = EntityXPOrb.func_70527_a(n2);
                n2 -= n;
                this._a.field_70170_p.func_72838_d(new EntityXPOrb(this._a.field_70170_p, this._a.field_70165_t, this._a.field_70163_u + 0.5, this._a.field_70161_v + 0.5, n));
            }
        }
        this._b = 0;
        GameRegistry.onItemSmelted(this._a, cvzo2);
        if (cvzo2._d == tgdv.field_77703_o.field_77779_bT) {
            this._a.func_71064_a(sdqa._k, 1);
        }
        if (cvzo2._d == tgdv.field_77753_aV.field_77779_bT) {
            this._a.func_71064_a(sdqa._p, 1);
        }
    }
}

