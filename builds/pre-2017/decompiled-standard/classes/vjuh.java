/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.ClansMod;
import gloomyfolken.mods.stalker.clans.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/PacketBattlefieldFinishCapture;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "battleId", "", "winnerClanName", "(Ljava/lang/String;Ljava/lang/String;)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getWinnerClanName", "setWinnerClanName", "processClient", "", "sentFromBackend", "", "processFrontendToBackend", "sender", "Lgloomyfolken/bundle/backend/server/ConnectedServer;", "minecraft"})
public final class vjuh
extends zwat {
    @Nullable
    private String _a;
    @NotNull
    private String _b;

    @Nullable
    public final String _b_() {
        return this._a;
    }

    public final void _a(@Nullable String string) {
        this._a = string;
    }

    @Override
    public void processClient(boolean bl) {
        pidb pidb2 = yuch._c;
        if (pidb2 != null) {
            pidb2._a(this._a);
        }
        ClansMod.instance._D._a(Intrinsics.areEqual(this._a, yuch._a._a));
    }

    @NotNull
    public final String _b() {
        return this._b;
    }

    public final void _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._b = string;
    }

    public vjuh(@NotNull String string, @Nullable String string2) {
        String string3;
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        this._b = string;
        vjuh vjuh2 = this;
        String string4 = string2;
        if (string4 != null) {
            String string5 = string4;
            vjuh vjuh3 = vjuh2;
            String string6 = string5;
            if (string6 == null) {
                string6 = "";
            }
            String string7 = string6;
            vjuh2 = vjuh3;
            string3 = string7;
        } else {
            string3 = null;
        }
        vjuh2._a = string3;
    }

    public vjuh() {
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

