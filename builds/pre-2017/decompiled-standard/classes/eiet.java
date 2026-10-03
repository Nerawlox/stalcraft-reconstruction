/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import net.minecraft.client.xpzm;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldSwitchGui;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "guiOpen", "", "lastDeath", "", "(ZJ)V", "getGuiOpen", "()Z", "setGuiOpen", "(Z)V", "getLastDeath", "()J", "setLastDeath", "(J)V", "processClient", "", "sentFromBackend", "minecraft"})
public final class eiet
extends zwat {
    private boolean _a;
    private long _b;

    @Override
    public void processClient(boolean bl) {
        xpzm xpzm2 = xpzm._E();
        if (this._a) {
            yuch._f = this._b;
            yuch._g = true;
            if (xpzm2._B instanceof ogia) {
                if (xpzm2._B == null) {
                    throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.clans.client.gui.GuiBattlePreparation");
                }
                ((ogia)xpzm2._B)._b = this._b;
            } else {
                xpzm2._a(new ogia(yuch._c, this._b));
            }
        } else {
            yuch._g = false;
            xpzm2._a((gqjz)null);
        }
    }

    public final boolean _i_() {
        return this._a;
    }

    public final void _a(boolean bl) {
        this._a = bl;
    }

    public final long _b() {
        return this._b;
    }

    public final void _a(long l) {
        this._b = l;
    }

    public eiet(boolean bl, long l) {
        this._a = bl;
        this._b = l;
    }

    public eiet() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readBoolean();
        this._b = dataInput.readLong();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._a);
        dataOutput.writeLong(this._b);
    }
}

