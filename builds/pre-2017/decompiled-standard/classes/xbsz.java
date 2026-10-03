/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class xbsz
implements jjmf {
    public final Logger _a;
    public final String _b;
    public final String _c;
    public final String _d;

    public xbsz(String string, String string2, String string3) {
        this._a = Logger.getLogger(string);
        this._c = string;
        this._d = string2;
        this._b = string3;
        this._a();
    }

    public void _a() {
        this._a.setParent(FMLLog.getLogger());
        for (Handler handler : this._a.getHandlers()) {
            this._a.removeHandler(handler);
        }
        msvo msvo2 = new msvo(this, null);
        try {
            Handler handler;
            handler = new FileHandler(this._b, true);
            handler.setFormatter(msvo2);
            this._a.addHandler(handler);
        }
        catch (Exception exception) {
            this._a.log(Level.WARNING, "Failed to log " + this._c + " to " + this._b, exception);
        }
    }

    @Override
    public void _a(String string) {
        this._a.log(Level.INFO, string);
    }

    @Override
    public void _b(String string) {
        this._a.log(Level.WARNING, string);
    }

    @Override
    public void _a(String string, Object ... objectArray) {
        this._a.log(Level.WARNING, String.format(string, objectArray));
    }

    @Override
    public void _a(String string, Throwable throwable) {
        this._a.log(Level.WARNING, string, throwable);
    }

    @Override
    public void _c(String string) {
        this._a.log(Level.SEVERE, string);
    }

    @Override
    public void _b(String string, Throwable throwable) {
        this._a.log(Level.SEVERE, string, throwable);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void _d(String string) {
        this._a.log(Level.FINE, string);
    }

    public static String _a(xbsz xbsz2) {
        return xbsz2._d;
    }
}

