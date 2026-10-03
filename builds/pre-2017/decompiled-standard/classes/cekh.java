/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.turb;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class cekh {
    public Map _a = new HashMap();
    public static cekh _b = new cekh();
    public qncw _c;
    public static double _d;
    public static double _e;
    public static double _f;
    public apbu _g;
    public ozlu _h;
    public EntityLivingBase _i;
    public float _j;
    public float _k;
    public double _l;
    public double _m;
    public double _n;

    public cekh() {
        this._a.put(jjza.class, new wpdq());
        this._a.put(xtcq.class, new pkpp());
        this._a.put(mcbr.class, new dhnh());
        this._a.put(yfav.class, new apfa());
        this._a.put(gaqr.class, new cejo());
        this._a.put(mtdr.class, new dyjs());
        this._a.put(zziy.class, new bbdv());
        this._a.put(vmyb.class, new lpeq());
        this._a.put(fool.class, new bsiw());
        for (htys htys2 : this._a.values()) {
            htys2.func_76893_a(this);
        }
    }

    public htys _a(Class clazz) {
        htys htys2 = (htys)this._a.get(clazz);
        if (htys2 == null && clazz != hurg.class) {
            htys2 = this._a(clazz.getSuperclass());
            this._a.put(clazz, htys2);
        }
        return htys2;
    }

    public boolean _a(hurg hurg2) {
        return this._b(hurg2) != null;
    }

    public htys _b(hurg hurg2) {
        return hurg2 == null ? null : this._a(hurg2.getClass());
    }

    public void _a(ozlu ozlu2, apbu apbu2, qncw qncw2, EntityLivingBase entityLivingBase, float f) {
        if (this._h != ozlu2) {
            this._a(ozlu2);
        }
        this._g = apbu2;
        this._i = entityLivingBase;
        this._c = qncw2;
        this._j = entityLivingBase.field_70126_B + (entityLivingBase.field_70177_z - entityLivingBase.field_70126_B) * f;
        this._k = entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * f;
        this._l = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
        this._m = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
        this._n = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
    }

    public void _a(hurg hurg2, float f) {
        int n = this._h.func_72802_i(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n, 0);
        int n2 = n % 65536;
        int n3 = n / 65536;
        iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._a(hurg2, (double)hurg2.field_70329_l - _d, (double)hurg2.field_70330_m - _e, (double)hurg2.field_70327_n - _f, f);
    }

    public void _a(hurg hurg2, double d, double d2, double d3, float f) {
        fmej._a(this, hurg2, d, d2, d3, f);
        htys htys2 = this._b(hurg2);
        if (htys2 != null) {
            try {
                htys2.func_76894_a(hurg2, d, d2, d3, f);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering Tile Entity");
                jxsn jxsn2 = crashReport.func_85058_a("Tile Entity Details");
                hurg2.func_85027_a(jxsn2);
                throw new turb(crashReport);
            }
        }
    }

    public void _a(ozlu ozlu2) {
        this._h = ozlu2;
        for (htys htys2 : this._a.values()) {
            if (htys2 == null) continue;
            htys2.func_76896_a(ozlu2);
        }
    }

    public qncw _a() {
        return this._c;
    }
}

