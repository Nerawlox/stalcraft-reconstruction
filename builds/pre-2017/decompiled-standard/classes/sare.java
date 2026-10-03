/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.pda.PdaMod;

public class sare
extends zwat {
    private int _a;

    public sare(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        PdaMod.instance.quests.activeQuest = this._a;
    }

    public sare() {
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

