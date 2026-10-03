/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.xpzm;

public class eiku
extends zwat {
    private byte[] _a;
    private List<String> _b;

    public eiku() {
    }

    public eiku(byte[] byArray, List<String> list) {
        this._a = byArray;
        this._b = list;
    }

    public eiku(uxqz uxqz2, List<String> list) {
        this(uxqz2.toByteArray(), list);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        eiku.writeStringList(this._b, dataOutput);
        dataOutput.writeInt(this._a.length);
        dataOutput.write(this._a);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = eiku.readStringList(dataInput);
        this._a = new byte[dataInput.readInt()];
        dataInput.readFully(this._a);
    }

    @Override
    public void processClient(boolean bl) {
        uxqz uxqz2 = uxqz._a(this._a);
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof GuiPda && ((GuiPda)gqjz2).currentTab instanceof kjui) {
            ((kjui)((Object)((GuiPda)gqjz2).currentTab)).updateAchivements(uxqz2, this._b);
        }
    }

    public static interface kjui {
        public void updateAchivements(uxqz var1, List<String> var2);
    }
}

