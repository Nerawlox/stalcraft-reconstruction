/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldGetMembers;", "Lgloomyfolken/bundle/common/network/packet/clans/server/PacketClanRequest;", "battleId", "", "(Ljava/lang/String;)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "run", "", "minecraft"})
public final class ncaj
extends tuuw {
    @NotNull
    private String _a;

    @NotNull
    public final String _n_() {
        return this._a;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._a = string;
    }

    public ncaj(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        this._a = string;
    }

    public ncaj() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._a);
    }
}

