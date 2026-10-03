/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cl
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cg
extends cl {
    private List a = new ArrayList();
    private byte c;

    public cg() {
        super("");
    }

    public cg(String par1Str) {
        super(par1Str);
    }

    void a(DataOutput par1DataOutput) throws IOException {
        this.c = !this.a.isEmpty() ? ((cl)this.a.get(0)).a() : (byte)1;
        par1DataOutput.writeByte(this.c);
        par1DataOutput.writeInt(this.a.size());
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            ((cl)this.a.get(i2)).a(par1DataOutput);
        }
    }

    void a(DataInput par1DataInput, int par2) throws IOException {
        if (par2 > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.c = par1DataInput.readByte();
        int j2 = par1DataInput.readInt();
        this.a = new ArrayList();
        for (int k = 0; k < j2; ++k) {
            cl nbtbase = cl.a((byte)this.c, (String)null);
            nbtbase.a(par1DataInput, par2 + 1);
            this.a.add(nbtbase);
        }
    }

    public byte a() {
        return 9;
    }

    public String toString() {
        return "" + this.a.size() + " entries of type " + cl.a((byte)this.c);
    }

    public void a(cl par1NBTBase) {
        this.c = par1NBTBase.a();
        this.a.add(par1NBTBase);
    }

    public cl a(int par1) {
        return (cl)this.a.remove(par1);
    }

    public cl b(int par1) {
        return (cl)this.a.get(par1);
    }

    public int c() {
        return this.a.size();
    }

    public cl b() {
        cg nbttaglist = new cg(this.e());
        nbttaglist.c = this.c;
        for (cl nbtbase : this.a) {
            cl nbtbase1 = nbtbase.b();
            nbttaglist.a.add(nbtbase1);
        }
        return nbttaglist;
    }

    public boolean equals(Object par1Obj) {
        if (super.equals(par1Obj)) {
            cg nbttaglist = (cg)((Object)par1Obj);
            if (this.c == nbttaglist.c) {
                return this.a.equals(nbttaglist.a);
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode() ^ this.a.hashCode();
    }
}

