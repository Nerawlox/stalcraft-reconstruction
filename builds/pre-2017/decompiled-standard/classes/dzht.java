/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class dzht {
    public final grqc _a = new grqc();
    public final File _b;
    public boolean _c = true;

    public dzht(File file) {
        this._b = file;
    }

    public boolean _a() {
        return this._c;
    }

    public void _a(boolean bl) {
        this._c = bl;
    }

    public Map _b() {
        this._c();
        return this._a;
    }

    public boolean _a(String string) {
        if (!this._a()) {
            return false;
        }
        this._c();
        return this._a.containsKey(string);
    }

    public void _a(eljf eljf2) {
        this._a._a(eljf2._a(), eljf2);
        this._e();
    }

    public void _b(String string) {
        this._a.remove(string);
        this._e();
    }

    public void _c() {
        Iterator iterator2 = this._a.values().iterator();
        while (iterator2.hasNext()) {
            eljf eljf2 = (eljf)iterator2.next();
            if (!eljf2._e()) continue;
            iterator2.remove();
        }
    }

    public void _d() {
        BufferedReader bufferedReader;
        if (!this._b.isFile()) {
            return;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(this._b));
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new Error();
        }
        try {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                eljf eljf2;
                if (string.startsWith("#") || (eljf2 = eljf._c(string)) == null) continue;
                this._a._a(eljf2._a(), eljf2);
            }
        }
        catch (IOException iOException) {
            dzfd._I()._O()._b("Could not load ban list", iOException);
        }
    }

    public void _e() {
        this._b(true);
    }

    public void _b(boolean bl) {
        boolean bl2 = FileWriteBlocker.saveToFile(this, bl);
        if (bl2) {
            boolean bl3 = bl2;
            return;
        }
        this._c();
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this._b, false));
            if (bl) {
                printWriter.println("# Updated " + new SimpleDateFormat().format(new Date()) + " by Minecraft " + "1.6.4");
                printWriter.println("# victim name | ban date | banned by | banned until | reason");
                printWriter.println();
            }
            for (eljf eljf2 : this._a.values()) {
                printWriter.println(eljf2._g());
            }
            printWriter.close();
        }
        catch (IOException iOException) {
            dzfd._I()._O()._b("Could not save ban list", iOException);
        }
    }
}

