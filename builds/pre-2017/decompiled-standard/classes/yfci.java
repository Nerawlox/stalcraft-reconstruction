/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import mcoptifine.Reflector;
import mcoptifine.WorldServerOF;
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.qlgf;

public class yfci
extends dzfd {
    public final xpzm _W;
    public final nfhj _X;
    public final jjmf _Y;
    public jjxu _Z;
    public boolean __aa;
    public boolean __ab;
    public scql __ac;

    public yfci(xpzm xpzm2, String string, String string2, nfhj nfhj2) {
        super(new File(xpzm2._P, "saves"));
        this._Y = new xbsz("Minecraft-Server", " [SERVER]", new File(xpzm2._P, "output-server.log").getAbsolutePath());
        this._j(xpzm2._P()._a());
        this._k(string);
        this._l(string2);
        this._b(xpzm2._y());
        this._c(nfhj2._c());
        this._d(256);
        this._a(new susm(this));
        this._W = xpzm2;
        this._o = xpzm2._Q();
        this._X = nfhj2;
        Reflector.callVoid(Reflector.ModLoader_registerServer, this);
        try {
            this._Z = new jjxu(this);
        }
        catch (IOException iOException) {
            throw new Error();
        }
    }

    @Override
    public void _a(String string, String string2, long l, nwix nwix2, String string3) {
        this._f(string);
        mtms mtms2 = this._S()._a(string, true);
        if (Reflector.DimensionManager.exists()) {
            Integer[] integerArray;
            yfgy yfgy2 = this._R() ? new zily(this, mtms2, string2, 0, this._g, this._O()) : new WorldServerOF(this, mtms2, string2, 0, this._X, this._g, this._O());
            Integer[] integerArray2 = integerArray = (Integer[])Reflector.call(Reflector.DimensionManager_getStaticDimensionIDs, new Object[0]);
            int n = integerArray.length;
            for (int i = 0; i < n; ++i) {
                int n2 = integerArray2[i];
                yfgy yfgy3 = n2 == 0 ? yfgy2 : new rasa(this, mtms2, string2, n2, this._X, yfgy2, this._g, this._O());
                ((yfgy)yfgy3).func_72954_a(new foqx(this, yfgy3));
                if (!this._N()) {
                    ((yfgy)yfgy3).func_72912_H()._a(this._r());
                }
                if (!Reflector.EventBus.exists()) continue;
                Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, yfgy3);
            }
            this.__ag()._a(new yfgy[]{yfgy2});
        } else {
            this._j = new yfgy[3];
            for (int i = 0; i < this._j.length; ++i) {
                int n = 0;
                if (i == 1) {
                    n = -1;
                }
                if (i == 2) {
                    n = 1;
                }
                this._j[i] = i == 0 ? (this._R() ? new zily(this, mtms2, string2, n, this._g, this._O()) : new WorldServerOF(this, mtms2, string2, n, this._X, this._g, this._O())) : new rasa(this, mtms2, string2, n, this._X, this._j[0], this._g, this._O());
                this._j[i].func_72954_a(new foqx(this, this._j[i]));
                this.__ag()._a(this._j);
            }
        }
        this._c(this._s());
        this._p();
    }

    @Override
    public boolean _n() throws IOException {
        Object object;
        this._Y._a("Starting integrated minecraft server version 1.6.4");
        this._d(false);
        this._e(true);
        this._f(true);
        this._g(true);
        this._h(true);
        this._Y._a("Generating keypair");
        this._a(qlgf._b());
        if (Reflector.FMLCommonHandler_handleServerAboutToStart.exists()) {
            object = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (!Reflector.callBoolean(object, Reflector.FMLCommonHandler_handleServerAboutToStart, this)) {
                return false;
            }
        }
        this._a(this._j(), this._P(), this._X._d(), this._X._h(), this._X._j());
        this._n(this._M() + " - " + this._j[0].func_72912_H()._k());
        if (Reflector.FMLCommonHandler_handleServerStarting.exists()) {
            object = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (Reflector.FMLCommonHandler_handleServerStarting.getReturnType() == Boolean.TYPE) {
                return Reflector.callBoolean(object, Reflector.FMLCommonHandler_handleServerStarting, this);
            }
            Reflector.callVoid(object, Reflector.FMLCommonHandler_handleServerStarting, this);
        }
        return true;
    }

    @Override
    public void _C() {
        boolean bl = this.__aa;
        this.__aa = this._Z._f();
        if (!bl && this.__aa) {
            this._Y._a("Saving and pausing game...");
            this.__ag()._n();
            this._a(false);
        }
        if (!this.__aa) {
            super._C();
        }
    }

    @Override
    public boolean _q() {
        return false;
    }

    @Override
    public xtby _r() {
        return this._X._e();
    }

    @Override
    public int _s() {
        return this._W._M.field_74318_M;
    }

    @Override
    public boolean _t() {
        return this._X._f();
    }

    @Override
    public File _A() {
        return this._W._P;
    }

    @Override
    public boolean _W() {
        return false;
    }

    public jjxu _a() {
        return this._Z;
    }

    @Override
    public void _a(CrashReport crashReport) {
        this._W._a(crashReport);
    }

    @Override
    public CrashReport _b(CrashReport crashReport) {
        crashReport = super._b(crashReport);
        crashReport.func_85056_g()._a("Type", new cwew(this));
        crashReport.func_85056_g()._a("Is Modded", new mtbo(this));
        return crashReport;
    }

    @Override
    public void _a(cfbu cfbu2) {
        super._a(cfbu2);
        cfbu2._a("snooper_partner", this._W._L()._h());
    }

    @Override
    public boolean _G() {
        return xpzm._E()._G();
    }

    @Override
    public String _a(xtby xtby2, boolean bl) {
        try {
            String string = this._Z._d();
            this._O()._a("Started on " + string);
            this.__ab = true;
            this.__ac = new scql(this.__ad(), string);
            this.__ac.start();
            this.__ag()._a(xtby2);
            this.__ag()._b(bl);
            return string;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    @Override
    public jjmf _O() {
        return this._Y;
    }

    @Override
    public void _w() {
        super._w();
        if (this.__ac != null) {
            this.__ac.interrupt();
            this.__ac = null;
        }
    }

    @Override
    public void _z() {
        super._z();
        if (this.__ac != null) {
            this.__ac.interrupt();
            this.__ac = null;
        }
    }

    public boolean _b() {
        return this.__ab;
    }

    @Override
    public void _a(xtby xtby2) {
        this.__ag()._a(xtby2);
    }

    @Override
    public boolean __ac() {
        return true;
    }

    @Override
    public int _u() {
        return 4;
    }

    @Override
    public vmra __ah() {
        return this._a();
    }
}

