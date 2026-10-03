/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.settings.GameSettings;

public class pknz {
    public static final FileFilter _a = new lpdf();
    public final File _b;
    public final fnrl _c;
    public final rqxe _d;
    public List _e = Lists.newArrayList();
    public List _f = Lists.newArrayList();

    public pknz(File file, fnrl fnrl2, rqxe rqxe2, GameSettings gameSettings) {
        this._b = file;
        this._c = fnrl2;
        this._d = rqxe2;
        this._a();
        this._c();
        for (yehh yehh2 : this._e) {
            if (!yehh2._d().equals(gameSettings.field_74346_m)) continue;
            this._f.add(yehh2);
        }
    }

    public void _a() {
        if (!this._b.isDirectory()) {
            this._b.delete();
            this._b.mkdirs();
        }
    }

    public List _b() {
        if (this._b.isDirectory()) {
            return Arrays.asList(this._b.listFiles(_a));
        }
        return Collections.emptyList();
    }

    public void _c() {
        ArrayList<yehh> arrayList = Lists.newArrayList();
        for (Object object : this._b()) {
            yehh yehh2 = new yehh(this, (File)object, null);
            if (!this._e.contains(yehh2)) {
                try {
                    yehh2._a();
                    arrayList.add(yehh2);
                }
                catch (Exception exception) {
                    arrayList.remove(yehh2);
                }
                continue;
            }
            arrayList.add((yehh)this._e.get(this._e.indexOf(yehh2)));
        }
        this._e.removeAll(arrayList);
        for (Object object : this._e) {
            ((yehh)object)._b();
        }
        this._e = arrayList;
    }

    public List _d() {
        return ImmutableList.copyOf(this._e);
    }

    public List _e() {
        return ImmutableList.copyOf(this._f);
    }

    public String _f() {
        if (this._f.isEmpty()) {
            return "Default";
        }
        return ((yehh)this._f.get(0))._d();
    }

    public void _a(yehh ... yehhArray) {
        this._f.clear();
        Collections.addAll(this._f, yehhArray);
    }

    public File _g() {
        return this._b;
    }
}

