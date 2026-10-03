/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cl
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ck
extends cl {
    public String a;

    public ck(String par1Str) {
        super(par1Str);
    }

    public ck(String par1Str, String par2Str) {
        super(par1Str);
        this.a = par2Str;
        if (par2Str == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    void a(DataOutput par1DataOutput) throws IOException {
        par1DataOutput.writeUTF(this.a);
    }

    void a(DataInput par1DataInput, int par2) throws IOException {
        this.a = par1DataInput.readUTF();
    }

    public byte a() {
        return 8;
    }

    public String toString() {
        return "" + this.a;
    }

    public cl b() {
        return new ck(this.e(), this.a);
    }

    public boolean equals(Object par1Obj) {
        if (!super.equals(par1Obj)) {
            return false;
        }
        ck nbttagstring = (ck)((Object)par1Obj);
        return this.a == null && nbttagstring.a == null || this.a != null && this.a.equals(nbttagstring.a);
    }

    public int hashCode() {
        return super.hashCode() ^ this.a.hashCode();
    }
}

