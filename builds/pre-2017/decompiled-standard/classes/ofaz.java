/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.chat.ChatMod;
import mods.chat.client.MessageStorage;

public class ofaz
extends zwat {
    private jxsn _a;

    public ofaz(jxsn jxsn2) {
        this._a = jxsn2;
    }

    public ofaz() {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this._a._a(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = jxsn._a(dataInput);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(boolean bl) {
        this._a = new jxsn(this._a._a, this._a._b, this._a._c, this._a._d, System.currentTimeMillis(), this._a._f);
        MessageStorage.RECEIVED.add(this._a);
        ChatMod.instance.chatHud.getChat().handleReceivedMessage(this._a);
    }
}

