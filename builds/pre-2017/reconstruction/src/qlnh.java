/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.pda.client.hud.AchievementHud;

public class qlnh
extends zwat {
    private turb _a;

    public qlnh() {
    }

    public qlnh(turb turb2) {
        this._a = turb2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a._a());
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = wmvj._a(dataInput.readUTF());
    }

    @Override
    public void processClient(boolean bl) {
        AchievementHud.instance.displayCompletion(this._a);
    }
}

