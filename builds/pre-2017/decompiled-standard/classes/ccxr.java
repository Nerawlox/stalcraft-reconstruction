/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.stats.PlayerStats;
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.IOException;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;

public class ccxr
implements IExtendedEntityProperties {
    public final EntityPlayer _a;
    public float _b;
    private double[] _l = new double[]{0.0, 0.0, 0.0};
    private float[] _m = new float[]{0.0f, 0.0f};
    public static final String _c = "st_attrib";
    public static final String _d = "GloomyData";
    public static final String _e = "attribs";
    public bqwg<cvzo> _f;
    public HashMap<String, bqwg> _g = new HashMap();
    public HashMap<String, tehy> _h = new HashMap();
    private List<bqdo> _n = new ArrayList<bqdo>();
    private boolean _o = false;
    private PlayerStats _p;
    private uxqz _q;
    public static ToLongFunction<ccxr> _i = ccxr2 -> InvokeWithResult.frontend(() -> null);
    public static ToIntFunction<ccxr> _j = ccxr2 -> InvokeWithResult.frontend(() -> null);
    private boolean _r;
    public bqwg<Float> _k;
    private kjui _s = new kjui();

    public ccxr(EntityPlayer entityPlayer) {
        this._a = entityPlayer;
    }

    public void _a() {
        MinecraftForge.EVENT_BUS.post(new mquk(this));
        this._p = new PlayerStats();
        this._p.player = this._a;
        this._q = new uxqz(this._a.field_71092_bJ);
        this._b = this._a.func_110143_aJ();
        this._k();
        this._f = new bqwg.kjui<Class<cvzo>>(this, "bp", cvzo.class)._a()._f();
        this._k = new bqwg.kjui<Float>(this, "mspd", Float.valueOf(0.1f))._f();
        this._c();
    }

    public boolean _b() {
        return this._o;
    }

    public void _c() {
        this._a.field_71070_bA = this._a.field_71069_bz = GloomyCore.instance.containerFactory._a(this);
        for (Map.Entry<String, tehy> entry : this._h.entrySet()) {
            entry.getValue().resetHandler();
        }
    }

    public void _a(bqwg bqwg2) {
        this._g.put(bqwg2._b, bqwg2);
    }

    public void _d() {
        for (Map.Entry<String, tehy> entry : this._h.entrySet()) {
            entry.getValue().tick();
        }
        if (!this._a.field_70170_p.field_72995_K) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((ccxr)this));
        }
    }

    public void _e() {
        this._a.func_70080_a(this._l[0], this._l[1], this._l[2], this._m[0], this._m[1]);
    }

    private void _k() {
        this._l[0] = this._a.field_70169_q;
        this._l[1] = this._a.field_70167_r + (double)this._a.field_70139_V;
        this._l[2] = this._a.field_70166_s;
        this._m[0] = this._a.field_70126_B;
        this._m[1] = this._a.field_70127_C;
    }

    public qoac _f() {
        qoac qoac2 = this._a.getEntityData();
        if (!qoac2._c("PlayerPersisted")) {
            qoac2._a("PlayerPersisted", (huhy)new qoac());
        }
        return qoac2._m("PlayerPersisted");
    }

    public boolean _g() {
        return this._r;
    }

    public boolean _h() {
        return this._f._b() != null;
    }

    private void _a(qoac qoac2, String string, qlgf qlgf2) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        try {
            qlgf2.write(byteArrayDataOutput);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        qoac2._a(string, byteArrayDataOutput.toByteArray());
    }

    private <T extends qlgf> T _b(qoac qoac2, String string, T t) {
        byte[] byArray = qoac2._k(string);
        if (byArray.length > 0) {
            try {
                t.read(ByteStreams.newDataInput(byArray));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public void init(Entity entity, ozlu ozlu2) {
    }

    public pzde _a(turb turb2) {
        return this._q._a().computeIfAbsent(turb2, this::_b);
    }

    public kjwj _a(srok srok2) {
        return (kjwj)this._a((turb)srok2);
    }

    public hank _a(tdpx tdpx2) {
        return (hank)this._a((turb)tdpx2);
    }

    public samo _a(hanr hanr2) {
        return (samo)this._a((turb)hanr2);
    }

    private pzde _b(turb turb2) {
        Object s = turb2._f();
        ((pzde)s)._a = this._a.field_71092_bJ;
        return s;
    }

    public PlayerStats _i() {
        return this._p;
    }

    public uxqz _j() {
        return this._q;
    }

    public static class kjui {
        private List<mqfb<Float, Long>> _a = new ArrayList<mqfb<Float, Long>>(2);
        private static final double _b = (double)0.001f;
        private static final int _c = 600;
    }
}

