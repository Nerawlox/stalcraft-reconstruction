/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e\u00a8\u0006\""}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldMembers;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "reservedUsernames", "", "", "memberUsernames", "joiningUsernames", "numPlayers", "", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;I)V", "", "getJoiningUsernames", "()Ljava/util/List;", "setJoiningUsernames", "(Ljava/util/List;)V", "getMemberUsernames", "setMemberUsernames", "getNumPlayers", "()I", "setNumPlayers", "(I)V", "getReservedUsernames", "setReservedUsernames", "processClient", "", "sentFromBackend", "", "read", "input", "Ljava/io/DataInput;", "write", "output", "Ljava/io/DataOutput;", "BattlefieldMembersConsumer", "minecraft"})
public final class qlgl
extends zwat {
    @NotNull
    private List<String> _a;
    @NotNull
    private List<String> _b;
    @NotNull
    private List<String> _c;
    private int _d;

    @NotNull
    public final List<String> _g_() {
        return this._a;
    }

    public final void _a(@NotNull List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "<set-?>");
        this._a = list2;
    }

    @NotNull
    public final List<String> _b() {
        return this._b;
    }

    public final void _b(@NotNull List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "<set-?>");
        this._b = list2;
    }

    @NotNull
    public final List<String> _c() {
        return this._c;
    }

    public final void _c(@NotNull List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "<set-?>");
        this._c = list2;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        zwat.writeStringList(this._a, dataOutput);
        zwat.writeStringList(this._b, dataOutput);
        zwat.writeStringList(this._c, dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void read(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        List<String> list2 = zwat.readStringList(dataInput);
        Intrinsics.checkExpressionValueIsNotNull(list2, "readStringList(input)");
        this._a = list2;
        List<String> list3 = zwat.readStringList(dataInput);
        Intrinsics.checkExpressionValueIsNotNull(list3, "readStringList(input)");
        this._b = list3;
        List<String> list4 = zwat.readStringList(dataInput);
        Intrinsics.checkExpressionValueIsNotNull(list4, "readStringList(input)");
        this._c = list4;
        this._d = dataInput.readInt();
    }

    @Override
    public void processClient(boolean bl) {
        gqjz gqjz2 = xpzm._E()._B;
        if (!(gqjz2 instanceof kjui)) {
            gqjz2 = null;
        }
        kjui kjui2 = (kjui)((Object)gqjz2);
        if (kjui2 == null) {
            return;
        }
        kjui kjui3 = kjui2;
        kjui3._a(this._a, this._b, this._c, this._d);
    }

    public final int _d() {
        return this._d;
    }

    public final void _a(int n) {
        this._d = n;
    }

    public qlgl(@NotNull Collection<String> collection, @NotNull Collection<String> collection2, @NotNull Collection<String> collection3, int n) {
        Intrinsics.checkParameterIsNotNull(collection, "reservedUsernames");
        Intrinsics.checkParameterIsNotNull(collection2, "memberUsernames");
        Intrinsics.checkParameterIsNotNull(collection3, "joiningUsernames");
        this._d = n;
        this._a = new ArrayList<String>(collection);
        this._b = new ArrayList<String>(collection2);
        this._c = new ArrayList<String>(collection3);
    }

    public qlgl() {
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldMembers$BattlefieldMembersConsumer;", "", "updateMembers", "", "reserved", "", "", "members", "joiningUsernames", "numPlayers", "", "minecraft"})
    public static interface kjui {
        public void _a(@NotNull List<String> var1, @NotNull List<String> var2, @NotNull List<String> var3, int var4);
    }
}

