/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.xpzm;

public class qlmx
extends zwat {
    public dwmf _a;

    public qlmx() {
    }

    public qlmx(dwmf dwmf2) {
        this._a = dwmf2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this._a.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new dwmf();
        this._a.read(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof GuiPda && ((GuiPda)gqjz2).currentTab instanceof kjui) {
            ((kjui)((Object)((GuiPda)gqjz2).currentTab)).updatePlayerProfile(this._a);
        }
    }

    public static interface kjui {
        public void updatePlayerProfile(dwmf var1);
    }
}

