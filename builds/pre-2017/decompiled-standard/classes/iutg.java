/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldJoinRequest;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "battleId", "", "username", "(Ljava/lang/String;Ljava/lang/String;)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "processClientToFrontend", "", "sender", "Lnet/minecraft/entity/player/EntityPlayer;", "processFrontendToBackend", "Lgloomyfolken/bundle/backend/server/ConnectedServer;", "minecraft"})
public final class iutg
extends zwat {
    @NotNull
    private String _a;
    @NotNull
    private String _b;

    @NotNull
    public final String _o_() {
        return this._a;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._a = string;
    }

    @NotNull
    public final String _b() {
        return this._b;
    }

    public final void _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._b = string;
    }

    public iutg(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        Intrinsics.checkParameterIsNotNull(string2, "username");
        this._a = string;
        this._b = string2;
    }

    public /* synthetic */ iutg(String string, String string2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            string2 = "";
        }
        this(string, string2);
    }

    public iutg() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeUTF(this._b);
    }
}

