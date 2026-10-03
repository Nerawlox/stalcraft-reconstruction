/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014\u00a8\u0006\t"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldKickRequest;", "Lgloomyfolken/bundle/common/network/packet/clans/server/PacketClanRequestTargeted;", "targetUsername", "", "(Ljava/lang/String;)V", "getRequiredPermission", "Lgloomyfolken/bundle/common/clans/ClanPermission;", "run", "", "minecraft"})
public final class rols
extends owha {
    public rols(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "targetUsername");
        super(string);
    }

    public rols() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
    }
}

