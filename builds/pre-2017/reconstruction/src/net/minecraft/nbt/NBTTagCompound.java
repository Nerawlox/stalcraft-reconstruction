/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.turb;

public class NBTTagCompound
extends NBTBase {
    public Map _c = new HashMap();

    public NBTTagCompound() {
        super("");
    }

    public NBTTagCompound(String string) {
        super(string);
    }

    @Override
    public void _a(DataOutput dataOutput) {
        for (NBTBase nBTBase : this._c.values()) {
            NBTBase._a(nBTBase, dataOutput);
        }
        dataOutput.writeByte(0);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        NBTBase nBTBase;
        if (n > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this._c.clear();
        while ((nBTBase = NBTBase._b(dataInput, n + 1))._a() != 0) {
            this._c.put(nBTBase._b(), nBTBase);
        }
    }

    public Collection _d() {
        return this._c.values();
    }

    @Override
    public byte _a() {
        return 10;
    }

    public void _a(String string, NBTBase nBTBase) {
        this._c.put(string, nBTBase._a(string));
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
        this._c.put(string, new NBTTagString(string, string2));
    }

    public void _a(String string, byte[] byArray) {
        this._c.put(string, new yvxd(string, byArray));
    }

    public void _a(String string, int[] nArray) {
        this._c.put(string, new qoak(string, nArray));
    }

    public void _a(String string, NBTTagCompound nBTTagCompound) {
        this._c.put(string, nBTTagCompound._a(string));
    }

    public void _a(String string, boolean bl) {
        this._a(string, bl ? (byte)1 : 0);
    }

    public NBTBase _b(String string) {
        return (NBTBase)this._c.get(string);
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
            return ((NBTTagString)this._c.get((Object)string))._c;
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

    public NBTTagCompound _m(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return new NBTTagCompound(string);
            }
            return (NBTTagCompound)this._c.get(string);
        }
        catch (ClassCastException classCastException) {
            throw new turb(this._a(string, 10, classCastException));
        }
    }

    public NBTTagList _n(String string) {
        try {
            if (!this._c.containsKey(string)) {
                return new NBTTagList(string);
            }
            return (NBTTagList)this._c.get(string);
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
        CrashReport crashReport = CrashReport.makeCrashReport(classCastException, "Reading NBT data");
        CrashReportCategory crashReportCategory = crashReport.makeCategoryDepth("Corrupt NBT tag", 1);
        crashReportCategory._a("Tag type found", new sdfp(this, string));
        crashReportCategory._a("Tag type expected", new lpsl(this, n));
        crashReportCategory._a("Tag name", string);
        if (this._b() != null && this._b().length() > 0) {
            crashReportCategory._a("Tag parent", this._b());
        }
        return crashReport;
    }

    @Override
    public NBTBase _c() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound(this._b());
        for (String string : this._c.keySet()) {
            nBTTagCompound._a(string, ((NBTBase)this._c.get(string))._c());
        }
        return nBTTagCompound;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)object;
            return ((Object)this._c.entrySet()).equals(nBTTagCompound._c.entrySet());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ ((Object)this._c).hashCode();
    }

    public static /* synthetic */ Map _a(NBTTagCompound nBTTagCompound) {
        return nBTTagCompound._c;
    }
}

