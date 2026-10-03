/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.ezey;
import gloomyfolken.mods.ejection.kjui;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.DamageSource;

public class pidb {
    public int _a = 0;
    private final boolean _c;
    private String _d = null;
    private static final int _e = 1;
    public static DamageSource _b = new gloomyfolken.mods.core.misc.ezey("ejection", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0432\u044b\u0431\u0440\u043e\u0441\u0430", ezey.kjui._i).setDamageBypassesArmor();

    public pidb(boolean bl, int n) {
        this._c = bl;
        this._a = n;
    }

    static void _a(int n) {
        InvokeSideOnly.frontend(() -> {});
    }

    public void _a() {
        if (this._c) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverStart(), ()V)((pidb)this));
        } else {
            InvokeSideOnly.client(this::_f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _f() {
        if (kjui._a._b != null) {
            kjui._a._b._e();
        }
        kjui._a._b = this;
        Minecraft._E()._N._a("ejection:ejection_start", 1.0f, 1.0f);
        this._d = "sound_" + (Minecraft._E()._N._h + 1) % 256;
        Minecraft._E()._N._a("ejection:ejection", 0.01f, 1.0f);
        Minecraft._E()._N._c.setLooping(this._d, true);
    }

    public void _b() {
        if (this._a < 12000) {
            ++this._a;
        }
        if (this._c) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((pidb)this));
        } else {
            InvokeSideOnly.client(this::_g);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _g() {
        Minecraft minecraft = Minecraft._E();
        minecraft._M.clouds = false;
        float f = Math.min(1.0f, (float)(this._a * 2 / 12000));
        minecraft._N._c.setVolume(this._d, f * 0.25f * minecraft._M.soundVolume);
        if (minecraft._t.worldObj.provider instanceof igyo) {
            pkix pkix2 = minecraft._r;
            double d = 0.01;
            if (this._a >= 6000) {
                d *= 2.0;
            }
            if (Math.random() < d) {
                int n = (int)(minecraft._t.posX + (double)(pkix2.rand.nextInt(100) - 50));
                int n2 = (int)(minecraft._t.posZ + (double)(pkix2.rand.nextInt(100) - 50));
                pkix2.addWeatherEffect(new EntityLightningBolt(pkix2, n, 200.0, n2));
                minecraft._N._a("ambient.weather.thunder", n, (float)minecraft._t.posY, n2, 5.0f, (float)(0.5 + Math.random() * 2.0));
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public float _c() {
        if (this._a < 6000) {
            return (float)this._a / 6000.0f;
        }
        if ((float)this._a > 9600.0f) {
            return (float)(12000 - this._a) / 2400.0f;
        }
        return 1.0f;
    }

    @Deprecated
    @ezey(_a={eidj.CLIENT})
    public float[] _d() {
        if (this._a >= 6000 && this._a < 9600) {
            return new float[]{0.65f, 0.0f, 0.0f, 1.0f};
        }
        float f = 1.0f;
        if (this._a < 6000) {
            f = (float)this._a / 6000.0f;
        } else if ((float)this._a > 9600.0f) {
            f = (float)(12000 - this._a) / 2400.0f;
        }
        if (f < 0.5f) {
            float f2 = f * 2.0f;
            return new float[]{0.5f + 0.5f * f2, 0.5f - 0.15f * f2, 0.5f - 0.5f * f2, 1.0f};
        }
        float f3 = (f - 0.5f) * 2.0f;
        return new float[]{1.0f - 0.35f * f3, 0.35f - 0.35f * f3, 0.0f, 1.0f};
    }

    public void _e() {
        if (this._c) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverEjectionEnd(), ()V)((pidb)this));
        } else {
            InvokeSideOnly.client(this::_h);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _h() {
        Minecraft._E()._M.clouds = true;
        kjui._a._b = null;
        Minecraft._E()._N._a("ejection:ejection_end", 1.0f, 1.0f);
        Minecraft._E()._N._c.stop(this._d);
    }
}

