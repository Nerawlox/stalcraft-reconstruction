/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/server/PacketBattlefieldSetReserveRequest;", "Lgloomyfolken/bundle/common/network/packet/clans/server/PacketClanRequest;", "battleId", "", "reservedUsernames", "", "(Ljava/lang/String;Ljava/util/List;)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getReservedUsernames", "()Ljava/util/List;", "setReservedUsernames", "(Ljava/util/List;)V", "getRequiredPermission", "Lgloomyfolken/bundle/common/clans/ClanPermission;", "read", "", "input", "Ljava/io/DataInput;", "run", "write", "output", "Ljava/io/DataOutput;", "minecraft"})
public final class ctcn
extends tuuw {
    @NotNull
    private List<String> _a;
    @NotNull
    private String _b;

    @NotNull
    public final List<String> _q_() {
        return this._a;
    }

    public final void _a(@NotNull List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "<set-?>");
        this._a = list2;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        dataOutput.writeUTF(this._b);
        qlgf.writeStringList(this._a, dataOutput);
    }

    @Override
    public void read(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        String string = dataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(string, "input.readUTF()");
        this._b = string;
        List<String> list2 = qlgf.readStringList(dataInput);
        Intrinsics.checkExpressionValueIsNotNull(list2, "ReadAndWriteAble.readStringList(input)");
        this._a = list2;
    }

    @NotNull
    public final String _b() {
        return this._b;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._b = string;
    }

    public ctcn(@NotNull String string, @NotNull List<String> list2) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        Intrinsics.checkParameterIsNotNull(list2, "reservedUsernames");
        this._b = string;
        this._a = new ArrayList(list2);
    }

    public ctcn() {
    }
}

