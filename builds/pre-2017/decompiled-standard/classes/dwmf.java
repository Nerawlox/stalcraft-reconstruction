/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.stats.PlayerStats;
import gloomyfolken.bundle.common.core.tupg;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class dwmf
extends qlgf {
    private String _a;
    private String _b;
    private List<String> _c;
    private tupg _d;
    private String _e;
    private vjsq _f;
    private boolean _g;
    private int[] _h;
    private byte[] _i;
    private long _j;
    private transient PlayerStats _k;

    public dwmf() {
    }

    public dwmf(String string, PlayerStats playerStats, String string2, List<String> list, tupg tupg2, String string3, vjsq vjsq2, boolean bl, int[] nArray, long l) {
        this(string, playerStats.toByteArray(), string2, list, tupg2, string3, vjsq2, bl, nArray, l);
        this._k = playerStats;
    }

    public dwmf(String string, byte[] byArray, String string2, List<String> list, tupg tupg2, String string3, vjsq vjsq2, boolean bl, int[] nArray, long l) {
        this._a = string;
        this._i = byArray;
        this._b = string2;
        this._c = list;
        this._d = tupg2;
        this._e = string3;
        this._f = vjsq2;
        this._g = bl;
        this._h = nArray;
        this._j = l;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._i.length);
        dataOutput.write(this._i);
        dataOutput.writeUTF(this._b);
        dataOutput.writeInt(this._d.ordinal());
        dataOutput.writeUTF(this._e);
        dataOutput.writeInt(this._f.ordinal());
        dataOutput.writeBoolean(this._g);
        for (int n : this._h) {
            dataOutput.writeShort(n);
        }
        dwmf.writeStringList(this._c, dataOutput);
        dataOutput.writeLong(this._j);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._i = new byte[dataInput.readInt()];
        dataInput.readFully(this._i);
        this._b = dataInput.readUTF();
        this._d = tupg.values()[dataInput.readInt()];
        this._e = dataInput.readUTF();
        this._f = vjsq.values()[dataInput.readInt()];
        this._g = dataInput.readBoolean();
        this._h = new int[4];
        for (int i = 0; i < 4; ++i) {
            this._h[i] = dataInput.readShort();
        }
        this._c = dwmf.readStringList(dataInput);
        this._j = dataInput.readLong();
    }

    public String _a() {
        return bqgh._b.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(this._j), ZoneOffset.UTC));
    }

    public String _b() {
        if (this._j < 0L) {
            return null;
        }
        return bqgh._e(System.currentTimeMillis() - this._j);
    }

    public long _c() {
        return this._j;
    }

    public static List<String> _a(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("displayedAchievements");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            arrayList.add(((xsxy)bsyv2._b((int)i))._c);
        }
        return arrayList;
    }

    private static short _a(byte[] byArray) {
        if (byArray.length > 0) {
            if (byArray[0] == 1) {
                return 0;
            }
            byte by = byArray[1];
            byte by2 = byArray[2];
            if ((by | by2) < 0) {
                return 0;
            }
            return (short)((by << 8) + by2);
        }
        return 0;
    }

    public String _d() {
        return this._a;
    }

    public PlayerStats _e() {
        if (this._k == null) {
            this._k = PlayerStats.fromBytes(this._i);
        }
        return this._k;
    }

    public String _f() {
        return this._b;
    }

    public List<String> _g() {
        return this._c;
    }

    public tupg _h() {
        return this._d;
    }

    public String _i() {
        return this._e;
    }

    public vjsq _j() {
        return this._f;
    }

    public boolean _k() {
        return this._g;
    }

    public int[] _l() {
        return this._h;
    }
}

