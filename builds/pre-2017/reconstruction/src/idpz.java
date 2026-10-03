/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
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
        if (!MinecraftForge.EVENT_BUS.post(new ClientChatReceivedEvent(ChatMessageComponent._d(this._a)._i()))) {
            Minecraft._E()._t.addChatMessage(this._a);
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

