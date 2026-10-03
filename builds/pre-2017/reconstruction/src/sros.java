/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\f"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldSpawnRequest;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "spawnId", "", "(I)V", "getSpawnId", "()I", "setSpawnId", "processClientToFrontend", "", "sender", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft"})
public final class sros
extends zwat {
    private int _a;

    public final int _r_() {
        return this._a;
    }

    public final void _a(int n) {
        this._a = n;
    }

    public sros(int n) {
        this._a = n;
    }

    public sros() {
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

