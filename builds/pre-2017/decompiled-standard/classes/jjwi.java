/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import net.minecraft.util.hanr;

public class jjwi {
    public volatile boolean _a;
    public volatile Map _b;
    public volatile Map _c;
    public nwek _d;
    public File _e;
    public File _f;
    public File _g;
    public File _h;
    public File _i;
    public File _j;
    public hanr _k;
    public int _l;
    public int _m;

    public jjwi(hanr hanr2, nwek nwek2, File file) {
        String string = hanr2._a();
        String string2 = string.toLowerCase();
        this._e = new File(file, "stats_" + string2 + "_unsent.dat");
        this._f = new File(file, "stats_" + string2 + ".dat");
        this._i = new File(file, "stats_" + string2 + "_unsent.old");
        this._j = new File(file, "stats_" + string2 + ".old");
        this._g = new File(file, "stats_" + string2 + "_unsent.tmp");
        this._h = new File(file, "stats_" + string2 + ".tmp");
        if (!string2.equals(string)) {
            this._a(file, "stats_" + string + "_unsent.dat", this._e);
            this._a(file, "stats_" + string + ".dat", this._f);
            this._a(file, "stats_" + string + "_unsent.old", this._i);
            this._a(file, "stats_" + string + ".old", this._j);
            this._a(file, "stats_" + string + "_unsent.tmp", this._g);
            this._a(file, "stats_" + string + ".tmp", this._h);
        }
        this._d = nwek2;
        this._k = hanr2;
        if (this._e.exists()) {
            nwek2._a(this._a(this._e, this._g, this._i));
        }
        this._a();
    }

    public void _a(File file, String string, File file2) {
        File file3 = new File(file, string);
        if (file3.exists() && !file3.isDirectory() && !file2.exists()) {
            file3.renameTo(file2);
        }
    }

    public Map _a(File file, File file2, File file3) {
        if (file.exists()) {
            return this._a(file);
        }
        if (file3.exists()) {
            return this._a(file3);
        }
        if (file2.exists()) {
            return this._a(file2);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map _a(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string);
            }
            Map map = nwek._a(stringBuilder.toString());
            return map;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(Map map, File file, File file2, File file3) {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file2, false));
        try {
            printWriter.print(nwek._a(this._k._a(), "local", map));
        }
        finally {
            printWriter.close();
        }
        if (file3.exists()) {
            file3.delete();
        }
        if (file.exists()) {
            file.renameTo(file3);
        }
        file2.renameTo(file);
    }

    public void _a() {
        if (this._a) {
            throw new IllegalStateException("Can't get stats from server while StatsSyncher is busy!");
        }
        this._l = 100;
        this._a = true;
        new hdqh(this).start();
    }

    public void _a(Map map) {
        if (this._a) {
            throw new IllegalStateException("Can't save stats while StatsSyncher is busy!");
        }
        this._l = 100;
        this._a = true;
        new gang(this, map).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _b(Map map) {
        int n = 30;
        while (this._a && --n > 0) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this._a = true;
        try {
            this._a(map, this._e, this._g, this._i);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            this._a = false;
        }
    }

    public boolean _b() {
        return this._l <= 0 && !this._a && this._c == null;
    }

    public void _c() {
        if (this._l > 0) {
            --this._l;
        }
        if (this._m > 0) {
            --this._m;
        }
        if (this._c != null) {
            this._d._c(this._c);
            this._c = null;
        }
        if (this._b != null) {
            this._d._b(this._b);
            this._b = null;
        }
    }

    public static /* synthetic */ Map _a(jjwi jjwi2) {
        return jjwi2._b;
    }

    public static /* synthetic */ File _b(jjwi jjwi2) {
        return jjwi2._f;
    }

    public static /* synthetic */ File _c(jjwi jjwi2) {
        return jjwi2._h;
    }

    public static /* synthetic */ File _d(jjwi jjwi2) {
        return jjwi2._j;
    }

    public static /* synthetic */ void _a(jjwi jjwi2, Map map, File file, File file2, File file3) {
        jjwi2._a(map, file, file2, file3);
    }

    public static /* synthetic */ Map _a(jjwi jjwi2, Map map) {
        jjwi2._b = map;
        return jjwi2._b;
    }

    public static /* synthetic */ Map _a(jjwi jjwi2, File file, File file2, File file3) {
        return jjwi2._a(file, file2, file3);
    }

    public static /* synthetic */ boolean _a(jjwi jjwi2, boolean bl) {
        jjwi2._a = bl;
        return jjwi2._a;
    }

    public static /* synthetic */ File _e(jjwi jjwi2) {
        return jjwi2._e;
    }

    public static /* synthetic */ File _f(jjwi jjwi2) {
        return jjwi2._g;
    }

    public static /* synthetic */ File _g(jjwi jjwi2) {
        return jjwi2._i;
    }
}

