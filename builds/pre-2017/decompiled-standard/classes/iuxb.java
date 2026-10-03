/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.misc.vjsq;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.xpzm;

public class iuxb
extends zwat {
    private List<pidb> _a = new ArrayList<pidb>();

    public iuxb() {
    }

    public iuxb(List<pidb> list2) {
        this._a = list2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (pidb pidb2 : this._a) {
            dataOutput.writeUTF(pidb2._a());
            dataOutput.writeLong(pidb2._c);
            dataOutput.writeByte(pidb2._d().ordinal());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            long l = dataInput.readLong();
            eidj eidj2 = eidj.values()[dataInput.readByte()];
            this._a.add(new pidb(string, l, eidj2));
        }
    }

    @Override
    public void processClient(boolean bl) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof GuiPda && ((GuiPda)gqjz2).currentTab instanceof kjui) {
            ((kjui)((Object)((GuiPda)gqjz2).currentTab)).updateFriends(this._a);
        }
    }

    public static interface kjui {
        public void updateFriends(List<pidb> var1);
    }

    public static enum eidj {
        _a,
        _b,
        _c;

    }

    public static class pidb
    implements vjsq {
        public static final int _a = 100;
        private String _b;
        private long _c;
        private eidj _d;

        public pidb(String string, long l, eidj eidj2) {
            this._b = string;
            this._c = l;
            this._d = eidj2;
        }

        public String _a() {
            return this._b;
        }

        public boolean _b() {
            return this._c < 0L;
        }

        public long _c() {
            return this._c;
        }

        public eidj _d() {
            return this._d;
        }

        @Override
        public String getString() {
            return this._b;
        }

        @Override
        public int getColor() {
            return 0x939393;
        }

        public String _e() {
            String string = "";
            if (this._d() == eidj._c) {
                string = this._b() ? "\u0412 \u0441\u0435\u0442\u0438" : "\u041d\u0435 \u0432 \u0441\u0435\u0442\u0438";
            } else if (this._d() == eidj._b) {
                string = "\u0417\u0430\u043f\u0440\u043e\u0441 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d";
            } else if (this._d() == eidj._a) {
                string = "\u0417\u0430\u043f\u0440\u043e\u0441 \u043f\u043e\u043b\u0443\u0447\u0435\u043d";
            }
            return string;
        }
    }
}

