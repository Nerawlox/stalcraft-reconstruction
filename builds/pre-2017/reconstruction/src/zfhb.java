/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class zfhb
extends zwat {
    public kjui _a;
    public String _b;

    public zfhb() {
    }

    public zfhb(kjui kjui2, String string) {
        this._a = kjui2;
        this._b = string;
    }

    @Override
    public void processClient(boolean bl) {
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen instanceof GuiPda) {
            ((GuiPda)guiScreen).showNotification(this._a, this._b);
        } else {
            new idpz((this._a == kjui._a ? EnumChatFormatting._m : "") + this._b).processClient(bl);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = kjui.values()[dataInput.readInt()];
        this._b = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.ordinal());
        dataOutput.writeUTF(this._b);
    }

    public static enum kjui {
        _a,
        _b;

    }
}

