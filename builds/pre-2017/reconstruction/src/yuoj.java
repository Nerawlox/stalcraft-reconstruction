/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.respawn.RespawnMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class yuoj
extends zwat {
    private vlfg _a;

    public yuoj(vlfg vlfg2) {
        this._a = vlfg2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a._a.ordinal());
        this._a.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        ndni ndni2 = ndni.values()[dataInput.readInt()];
        this._a = ndni2 == ndni._a ? new klfx() : new cupm();
        this._a.read(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        RespawnMod.instance._e = this._a;
        Minecraft minecraft = Minecraft._E();
        GuiScreen guiScreen = minecraft._B;
        if (guiScreen instanceof jzaw) {
            ndni ndni2 = this._a._a;
            if (ndni2 == ndni._a && !(guiScreen instanceof qmsy)) {
                minecraft._a(new qmsy());
            } else if (!(guiScreen instanceof cumr)) {
                minecraft._a(new cumr());
            } else {
                guiScreen.setWorldAndResolution(minecraft, minecraft._n / 2, minecraft._o / 2);
            }
        }
    }

    public yuoj() {
    }
}

