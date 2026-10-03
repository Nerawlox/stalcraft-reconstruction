/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;

public class idpz
extends zwat {
    public String _a;

    public idpz(String string) {
        this._a = string;
    }

    @Override
    public void processClient(boolean bl) {
        if (!MinecraftForge.EVENT_BUS.post(new ClientChatReceivedEvent(net.minecraft.util.zwat._d(this._a)._i()))) {
            xpzm._E()._t.func_71035_c(this._a);
        }
    }

    public idpz() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
    }
}

