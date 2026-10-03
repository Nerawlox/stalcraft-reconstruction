/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.nbt.NBTTagCompound;

public class uguf
extends zwat {
    private List<ezfc> _a;

    public uguf(List<ezfc> list2) {
        this._a = list2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (ezfc ezfc2 : this._a) {
            dataOutput.writeByte(ezfc2._a.ordinal());
            dataOutput.writeLong(ezfc2._c);
            bsvf._a(ezfc2._b, dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new ArrayList<ezfc>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            ezfc.kjui kjui2 = ezfc.kjui.values()[dataInput.readByte()];
            long l = dataInput.readLong();
            NBTTagCompound nBTTagCompound = bsvf._a(dataInput);
            this._a.add(new ezfc(kjui2, nBTTagCompound, l));
        }
    }

    @Override
    public void processClient(boolean bl) {
        AbstractPdaTab abstractPdaTab = GuiPda.getCurrentTab();
        if (abstractPdaTab instanceof kjui) {
            ((kjui)((Object)abstractPdaTab))._a(this._a);
        }
    }

    public uguf() {
    }

    public static interface kjui {
        public void _a(List<ezfc> var1);
    }
}

