/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldsUpdateBidding;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "battleId", "", "bidding", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "(Ljava/lang/String;Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "data", "Lnet/minecraft/nbt/NBTTagCompound;", "getData", "()Lnet/minecraft/nbt/NBTTagCompound;", "setData", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "processClient", "", "sentFromBackend", "", "minecraft"})
public final class dwdb
extends zwat {
    @NotNull
    private qoac _a;
    @NotNull
    private String _b;

    @NotNull
    public final qoac _k_() {
        return this._a;
    }

    public final void _a(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "<set-?>");
        this._a = qoac2;
    }

    @Override
    public void processClient(boolean bl) {
        block1: {
            AbstractPdaTab abstractPdaTab = GuiPda.getCurrentTab();
            if (!(abstractPdaTab instanceof hbtc)) {
                abstractPdaTab = null;
            }
            hbtc hbtc2 = (hbtc)abstractPdaTab;
            if (hbtc2 == null) break block1;
            hbtc2._a(this._b, this._a);
        }
    }

    @NotNull
    public final String _b() {
        return this._b;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._b = string;
    }

    public dwdb(@NotNull String string, @NotNull sajz.kjui kjui2) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        Intrinsics.checkParameterIsNotNull(kjui2, "bidding");
        this._b = string;
        this._a = new qoac();
        kjui2._b(this._a);
    }

    public dwdb() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
        this._b = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
        dataOutput.writeUTF(this._b);
    }
}

