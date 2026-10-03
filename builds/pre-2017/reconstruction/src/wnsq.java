/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class wnsq
extends Packet {
    public String _a;

    public wnsq() {
    }

    public wnsq(String string) {
        this._a = string;
    }

    @Override
    public void readPacketData(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        if (netHandler instanceof yezc) {
            yezc yezc2 = (yezc)netHandler;
            String string = yezc2._g;
            if (string.startsWith("Test-") && GloomyCore.instance.testSession != null && GloomyCore.instance.testSession.equals(this._a)) {
                yezc2._j = true;
                yezc2._h = true;
            }
        }
    }

    @Override
    public int getPacketSize() {
        return this._a.length() + 2;
    }
}

