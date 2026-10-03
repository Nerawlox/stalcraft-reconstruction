/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.turb;

public abstract class NBTBase {
    public static final String[] _a = new String[]{"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};
    public String _b;

    public abstract void _a(DataOutput var1);

    public abstract void _a(DataInput var1, int var2);

    public abstract byte _a();

    public NBTBase(String string) {
        this._b = string == null ? "" : string;
    }

    public NBTBase _a(String string) {
        this._b = string == null ? "" : string;
        return this;
    }

    public String _b() {
        if (this._b == null) {
            return "";
        }
        return this._b;
    }

    public static NBTBase _a(DataInput dataInput) {
        return NBTBase._b(dataInput, 0);
    }

    public static NBTBase _b(DataInput dataInput, int n) {
        byte by = dataInput.readByte();
        if (by == 0) {
            return new xbsi();
        }
        String string = dataInput.readUTF();
        NBTBase nBTBase = NBTBase._a(by, string);
        try {
            nBTBase._a(dataInput, n);
        }
        catch (IOException iOException) {
            CrashReport crashReport = CrashReport.makeCrashReport(iOException, "Loading NBT data");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("NBT Tag");
            crashReportCategory._a("Tag name", string);
            crashReportCategory._a("Tag type", by);
            throw new turb(crashReport);
        }
        return nBTBase;
    }

    public static void _a(NBTBase nBTBase, DataOutput dataOutput) {
        dataOutput.writeByte(nBTBase._a());
        if (nBTBase._a() == 0) {
            return;
        }
        dataOutput.writeUTF(nBTBase._b());
        nBTBase._a(dataOutput);
    }

    public static NBTBase _a(byte by, String string) {
        switch (by) {
            case 0: {
                return new xbsi();
            }
            case 1: {
                return new xsub(string);
            }
            case 2: {
                return new ixnt(string);
            }
            case 3: {
                return new hdfw(string);
            }
            case 4: {
                return new grhp(string);
            }
            case 5: {
                return new jjly(string);
            }
            case 6: {
                return new qoae(string);
            }
            case 7: {
                return new yvxd(string);
            }
            case 11: {
                return new qoak(string);
            }
            case 8: {
                return new NBTTagString(string);
            }
            case 9: {
                return new NBTTagList(string);
            }
            case 10: {
                return new NBTTagCompound(string);
            }
        }
        return null;
    }

    public static String _a(byte by) {
        switch (by) {
            case 0: {
                return "TAG_End";
            }
            case 1: {
                return "TAG_Byte";
            }
            case 2: {
                return "TAG_Short";
            }
            case 3: {
                return "TAG_Int";
            }
            case 4: {
                return "TAG_Long";
            }
            case 5: {
                return "TAG_Float";
            }
            case 6: {
                return "TAG_Double";
            }
            case 7: {
                return "TAG_Byte_Array";
            }
            case 11: {
                return "TAG_Int_Array";
            }
            case 8: {
                return "TAG_String";
            }
            case 9: {
                return "TAG_List";
            }
            case 10: {
                return "TAG_Compound";
            }
        }
        return "UNKNOWN";
    }

    public abstract NBTBase _c();

    public boolean equals(Object object) {
        if (!(object instanceof NBTBase)) {
            return false;
        }
        NBTBase nBTBase = (NBTBase)object;
        if (this._a() != nBTBase._a()) {
            return false;
        }
        if (this._b == null && nBTBase._b != null || this._b != null && nBTBase._b == null) {
            return false;
        }
        return this._b == null || this._b.equals(nBTBase._b);
    }

    public int hashCode() {
        return this._b.hashCode() ^ this._a();
    }
}

