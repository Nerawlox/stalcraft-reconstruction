/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldBidRequest;", "Lgloomyfolken/bundle/common/network/packet/clans/server/PacketClanRequest;", "battleId", "", "slotId", "", "bid", "(Ljava/lang/String;II)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getBid", "()I", "setBid", "(I)V", "getSlotId", "setSlotId", "getRequiredPermission", "Lgloomyfolken/bundle/common/clans/ClanPermission;", "run", "", "minecraft"})
public final class qljc
extends tuuw {
    @NotNull
    private String _a;
    private int _b;
    private int _c;

    @NotNull
    public final String _l_() {
        return this._a;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._a = string;
    }

    public final int _b() {
        return this._b;
    }

    public final void _a(int n) {
        this._b = n;
    }

    public final int _c() {
        return this._c;
    }

    public final void _b(int n) {
        this._c = n;
    }

    public qljc(@NotNull String string, int n, int n2) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        this._a = string;
        this._b = n;
        this._c = n2;
    }

    public qljc() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
    }
}

