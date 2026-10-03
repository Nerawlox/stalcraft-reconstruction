/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ezey(_a={eidj.FRONTEND, eidj.CLIENT})
@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldSingleStat;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "username", "", "clanName", "type", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "value", "", "(Ljava/lang/String;Ljava/lang/String;Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;D)V", "getClanName", "()Ljava/lang/String;", "setClanName", "(Ljava/lang/String;)V", "getType", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "setType", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;)V", "getUsername", "setUsername", "getValue", "()D", "setValue", "(D)V", "processClient", "", "sentFromBackend", "", "minecraft"})
public final class amzi
extends zwat {
    @NotNull
    private String _a;
    @NotNull
    private String _b;
    @NotNull
    private pidb.zwat _c;
    private double _d;

    @Override
    public void processClient(boolean bl) {
        Object object = yuch._c;
        if (object == null || (object = ((pidb)object)._h()) == null) {
            return;
        }
        Object object2 = object;
        ((pidb.zwaw)object2)._a(this._a, this._b)._a(this._c)._a(this._d);
    }

    @NotNull
    public final String _h_() {
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

    @NotNull
    public final pidb.zwat _c() {
        return this._c;
    }

    public final void _a(@NotNull pidb.zwat zwat2) {
        Intrinsics.checkParameterIsNotNull((Object)zwat2, "<set-?>");
        this._c = zwat2;
    }

    public final double _d() {
        return this._d;
    }

    public final void _a(double d) {
        this._d = d;
    }

    public amzi(@NotNull String string, @NotNull String string2, @NotNull pidb.zwat zwat2, double d) {
        Intrinsics.checkParameterIsNotNull(string, "username");
        Intrinsics.checkParameterIsNotNull(string2, "clanName");
        Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
        this._a = string;
        this._b = string2;
        this._c = zwat2;
        this._d = d;
    }

    public amzi() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readUTF();
        this._c = pidb.zwat.values()[dataInput.readInt()];
        this._d = dataInput.readDouble();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeUTF(this._b);
        dataOutput.writeInt(this._c.ordinal());
        dataOutput.writeDouble(this._d);
    }
}

