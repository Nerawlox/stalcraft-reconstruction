/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class cfbu {
    public Map _a = new HashMap();
    public final String _b = UUID.randomUUID().toString();
    public final URL _c;
    public final ujun _d;
    public final Timer _e = new Timer("Snooper Timer", true);
    public final Object _f = new Object();
    public final long _g;
    public boolean _h;
    public int _i;

    public cfbu(String string, ujun ujun2, long l) {
        try {
            this._c = new URL("http://snoop.minecraft.net/" + string + "?version=" + 1);
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException();
        }
        this._d = ujun2;
        this._g = l;
    }

    public void _a() {
        if (this._h) {
            return;
        }
        this._h = true;
        this._b();
        this._e.schedule((TimerTask)new rrmy(this), 0L, 900000L);
    }

    public void _b() {
        GloomyHooks.addBaseDataToSnooper(this);
    }

    public void _c() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> list2 = runtimeMXBean.getInputArguments();
        int n = 0;
        for (String string : list2) {
            if (!string.startsWith("-X")) continue;
            this._a("jvm_arg[" + n++ + "]", string);
        }
        this._a("jvm_args", n);
    }

    public void _d() {
        this._a("memory_total", Runtime.getRuntime().totalMemory());
        this._a("memory_max", Runtime.getRuntime().maxMemory());
        this._a("memory_free", Runtime.getRuntime().freeMemory());
        this._a("cpu_cores", Runtime.getRuntime().availableProcessors());
        this._d._a(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(String string, Object object) {
        Object object2 = this._f;
        synchronized (object2) {
            this._a.put(string, object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map _e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object object = this._f;
        synchronized (object) {
            this._d();
            for (Map.Entry entry : this._a.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return linkedHashMap;
    }

    public boolean _f() {
        return this._h;
    }

    public void _g() {
        this._e.cancel();
    }

    public String _h() {
        return this._b;
    }

    public long _i() {
        return this._g;
    }

    public static /* synthetic */ ujun _a(cfbu cfbu2) {
        return cfbu2._d;
    }

    public static /* synthetic */ Object _b(cfbu cfbu2) {
        return cfbu2._f;
    }

    public static /* synthetic */ Map _c(cfbu cfbu2) {
        return cfbu2._a;
    }

    public static /* synthetic */ int _d(cfbu cfbu2) {
        return cfbu2._i++;
    }

    public static /* synthetic */ URL _e(cfbu cfbu2) {
        return cfbu2._c;
    }
}

