/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldSetBanRequest;", "Lgloomyfolken/bundle/common/network/packet/clans/server/PacketClanRequestTargeted;", "targetUsername", "", "ban", "", "(Ljava/lang/String;Z)V", "getBan", "()Z", "setBan", "(Z)V", "getRequiredPermission", "Lgloomyfolken/bundle/common/clans/ClanPermission;", "run", "", "minecraft"})
public final class dwfp
extends owha {
    private boolean _a;

    public final boolean _p_() {
        return this._a;
    }

    public final void _a(boolean bl) {
        this._a = bl;
    }

    public dwfp(@NotNull String string, boolean bl) {
        Intrinsics.checkParameterIsNotNull(string, "targetUsername");
        super(string);
        this._a = bl;
    }

    public dwfp() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeBoolean(this._a);
    }
}

