/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bw
 *  bx
 *  bz
 *  ca
 *  cb
 *  cd
 *  ce
 *  cf
 *  ch
 *  cj
 *  cl
 *  u
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class by
extends cl {
    private Map a = new HashMap();

    public by() {
        super("");
    }

    public by(String par1Str) {
        super(par1Str);
    }

    void a(DataOutput par1DataOutput) throws IOException {
        for (cl nbtbase : this.a.values()) {
            cl.a((cl)nbtbase, (DataOutput)par1DataOutput);
        }
        par1DataOutput.writeByte(0);
    }

    void a(DataInput par1DataInput, int par2) throws IOException {
        cl nbtbase;
        if (par2 > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.a.clear();
        while ((nbtbase = cl.b((DataInput)par1DataInput, (int)(par2 + 1))).a() != 0) {
            this.a.put(nbtbase.e(), nbtbase);
        }
    }

    public Collection c() {
        return this.a.values();
    }

    public byte a() {
        return 10;
    }

    public void a(String par1Str, cl par2NBTBase) {
        this.a.put(par1Str, par2NBTBase.p(par1Str));
    }

    public void a(String par1Str, byte par2) {
        this.a.put(par1Str, new bx(par1Str, par2));
    }

    public void a(String par1Str, short par2) {
        this.a.put(par1Str, new cj(par1Str, par2));
    }

    public void a(String par1Str, int par2) {
        this.a.put(par1Str, new cf(par1Str, par2));
    }

    public void a(String par1Str, long par2) {
        this.a.put(par1Str, new ch(par1Str, par2));
    }

    public void a(String par1Str, float par2) {
        this.a.put(par1Str, new cd(par1Str, par2));
    }

    public void a(String par1Str, double par2) {
        this.a.put(par1Str, new cb(par1Str, par2));
    }

    public void a(String par1Str, String par2Str) {
        this.a.put(par1Str, new ck(par1Str, par2Str));
    }

    public void a(String par1Str, byte[] par2ArrayOfByte) {
        this.a.put(par1Str, new bw(par1Str, par2ArrayOfByte));
    }

    public void a(String par1Str, int[] par2ArrayOfInteger) {
        this.a.put(par1Str, new ce(par1Str, par2ArrayOfInteger));
    }

    public void a(String par1Str, by par2NBTTagCompound) {
        this.a.put(par1Str, par2NBTTagCompound.p(par1Str));
    }

    public void a(String par1Str, boolean par2) {
        this.a(par1Str, (byte)(par2 ? 1 : 0));
    }

    public cl a(String par1Str) {
        return (cl)this.a.get(par1Str);
    }

    public boolean b(String par1Str) {
        return this.a.containsKey(par1Str);
    }

    public byte c(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? (byte)0 : ((bx)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 1, classcastexception));
        }
    }

    public short d(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? (short)0 : ((cj)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 2, classcastexception));
        }
    }

    public int e(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? 0 : ((cf)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 3, classcastexception));
        }
    }

    public long f(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? 0L : ((ch)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 4, classcastexception));
        }
    }

    public float g(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? 0.0f : ((cd)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 5, classcastexception));
        }
    }

    public double h(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? 0.0 : ((cb)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 6, classcastexception));
        }
    }

    public String i(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? "" : ((ck)((Object)this.a.get((Object)par1Str))).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 8, classcastexception));
        }
    }

    public byte[] j(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? new byte[]{} : ((bw)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 7, classcastexception));
        }
    }

    public int[] k(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? new int[]{} : ((ce)this.a.get((Object)par1Str)).a;
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 11, classcastexception));
        }
    }

    public by l(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? new by(par1Str) : (by)((Object)this.a.get(par1Str));
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 10, classcastexception));
        }
    }

    public cg m(String par1Str) {
        try {
            return !this.a.containsKey(par1Str) ? new cg(par1Str) : (cg)((Object)this.a.get(par1Str));
        }
        catch (ClassCastException classcastexception) {
            throw new u(this.a(par1Str, 9, classcastexception));
        }
    }

    public boolean n(String par1Str) {
        return this.c(par1Str) != 0;
    }

    public void o(String par1Str) {
        this.a.remove(par1Str);
    }

    public String toString() {
        String s2 = this.e() + ":[";
        for (String s1 : this.a.keySet()) {
            s2 = s2 + s1 + ":" + this.a.get(s1) + ",";
        }
        return s2 + "]";
    }

    public boolean d() {
        return this.a.isEmpty();
    }

    private b a(String par1Str, int par2, ClassCastException par3ClassCastException) {
        b crashreport = b.a(par3ClassCastException, "Reading NBT data");
        m crashreportcategory = crashreport.a("Corrupt NBT tag", 1);
        crashreportcategory.a("Tag type found", (Callable)new bz(this, par1Str));
        crashreportcategory.a("Tag type expected", (Callable)new ca(this, par2));
        crashreportcategory.a("Tag name", par1Str);
        if (this.e() != null && this.e().length() > 0) {
            crashreportcategory.a("Tag parent", this.e());
        }
        return crashreport;
    }

    public cl b() {
        by nbttagcompound = new by(this.e());
        for (String s2 : this.a.keySet()) {
            nbttagcompound.a(s2, ((cl)this.a.get(s2)).b());
        }
        return nbttagcompound;
    }

    public boolean equals(Object par1Obj) {
        if (super.equals(par1Obj)) {
            by nbttagcompound = (by)((Object)par1Obj);
            return this.a.entrySet().equals(nbttagcompound.a.entrySet());
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode() ^ this.a.hashCode();
    }

    static Map a(by par0NBTTagCompound) {
        return par0NBTTagCompound.a;
    }
}

