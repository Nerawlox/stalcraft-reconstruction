/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.turb;

public class qoac
extends huhy {
    public Map _c = new HashMap();

    public qoac() {
        super("");
    }

    public qoac(String string) {
        super(string);
    }

    @Override
    public void _a(DataOutput dataOutput) {
        for (huhy huhy2 : this._c.values()) {
            huhy._a(huhy2, dataOutput);
        }
        dataOutput.writeByte(0);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        huhy huhy2;
        if (n > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this._c.clear();
        while ((huhy2 = huhy._b(dataInput, n + 1))._a() != 0) {
            this._c.put(huhy2._b(), huhy2);
        }
    }

    public Collection _d() {
        return this._c.values();
    }

    @Override
    public byte _a() {
        return 10;
    }

    public void _a(String string, huhy huhy2) {
        this._c.put(string, huhy2._a(string));
    }

    public void _a(String string, byte by) {
        this._c.put(string, new xsub(string, by));
    }

    public void _a(String string, short s) {
        this._c.put(string, new ixnt(string, s));
    }

    public void _a(String string, int n) {
        this._c.put(string, new hdfw(string, n));
    }

    public void _a(String string, long l) {
        this._c.put(string, new grhp(string, l));
    }

    public void _a(String string, float f) {
        this._c.put(string, new jjly(string, f));
    }

    public void _a(String string, double d) {
        this._c.put(string, new qoae(string, d));
    }

    public void _a(String string, String string2) {
        this._c.put(string, new xsxy(string, string2));
    }

    public void _a(String string, byte[] byArray) {
        this._c.put(string, new yvxd(string, byArray));
    }

    public void _a(String string, int[] nArray) {
        this._c.put(string, new qoak(string, nArray));
    }

    public void _a(String string, qoac qoac2) {
        this._c.put(string, qoac2._a(string));
    }

    public void _a(String string, boolean bl) {
        this._a(string, bl ? (byte)1 : 0);
    }

    public huhy _b(String string) {
        return (huhy)this._c.get(string);
    }

    public boolean _c(String string) {
        return this._c.containsKey(string);
    }

    public byte _d(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return 0;
            }
            return ((xsub)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 1, classCastException));
        }
    }

    public short _e(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return 0;
            }
            return ((ixnt)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 2, classCastException));
        }
    }

    public int _f(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return 0;
            }
            return ((hdfw)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 3, classCastException));
        }
    }

    public long _g(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return 0L;
            }
            return ((grhp)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 4, classCastException));
        }
    }

    public float _h(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return 0.0f;
            }
            return ((jjly)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 5, classCastException));
        }
    }

    public double _i(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return 0.0;
            }
            return ((qoae)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 6, classCastException));
        }
    }

    public String _j(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return "";
            }
            return ((xsxy)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 8, classCastException));
        }
    }

    public byte[] _k(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return new byte[0];
            }
            return ((yvxd)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 7, classCastException));
        }
    }

    public int[] _l(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return new int[0];
            }
            return ((qoak)this._c.get((Object)string))._c;
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 11, classCastException));
        }
    }

    public qoac _m(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return new qoac(string);
            }
            return (qoac)this._c.get(string);
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 10, classCastException));
        }
    }

    public bsyv _n(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return new bsyv(string);
            }
            return (bsyv)this._c.get(string);
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 9, classCastException));
        }
    }

    public boolean _o(String string) {
        return this._d(string) != 0;
    }

    public void _p(String string) {
        this._c.remove(string);
    }

    public String toString() {
        String string = this._b() + ":[";
        for (String string2 : this._c.keySet()) {
            string = string + string2 + ":" + this._c.get(string2) + ",";
        }
        return string + "]";
    }

    public boolean _e() {
        return this._c.isEmpty();
    }

    public CrashReport _a(String string, int n, ClassCastException classCastException) {
        CrashReport crashReport = CrashReport.func_85055_a(classCastException, "Reading NBT data");
        jxsn jxsn2 = crashReport.func_85057_a("Corrupt NBT tag", 1);
        jxsn2._a("Tag type found", new sdfp(this, string));
        jxsn2._a("Tag type expected", new lpsl(this, n));
        jxsn2._a("Tag name", string);
        if (this._b() != null && this._b().length() > 0) {
            jxsn2._a("Tag parent", this._b());
        }
        return crashReport;
    }

    @Override
    public huhy _c() {
        qoac qoac2 = new qoac(this._b());
        for (String string : this._c.keySet()) {
            qoac2._a(string, ((huhy)this._c.get(string))._c());
        }
        return qoac2;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            qoac qoac2 = (qoac)object;
            return ((Object)this._c.entrySet()).equals(qoac2._c.entrySet());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ ((Object)this._c).hashCode();
    }

    public static /* synthetic */ Map _a(qoac qoac2) {
        return qoac2._c;
    }
}

