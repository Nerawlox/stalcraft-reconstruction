/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.hud.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class htbo
extends zwat {
    public int _a;

    public htbo(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        GuiIngame guiIngame = Minecraft._E()._J;
        if (guiIngame instanceof pidb) {
            ((pidb)guiIngame)._a(this._a);
        }
    }

    public htbo() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }
}

