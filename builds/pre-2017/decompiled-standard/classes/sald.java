/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.kjui;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattleResults;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "results", "Lgloomyfolken/mods/stalker/clans/BattleResult;", "onBattlefield", "", "(Lgloomyfolken/mods/stalker/clans/BattleResult;Z)V", "battleResultsTag", "Lnet/minecraft/nbt/NBTTagCompound;", "(Lnet/minecraft/nbt/NBTTagCompound;Z)V", "getBattleResultsTag", "()Lnet/minecraft/nbt/NBTTagCompound;", "setBattleResultsTag", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "getOnBattlefield", "()Z", "setOnBattlefield", "(Z)V", "processClient", "", "sentFromBackend", "minecraft"})
public final class sald
extends zwat {
    @NotNull
    private qoac _a;
    private boolean _b;

    @Override
    public void processClient(boolean bl) {
        xpzm xpzm2 = xpzm._E();
        xpzm2._a(new xabu(xpzm2._B, new kjui(this._a), this._b));
    }

    @NotNull
    public final qoac _d_() {
        return this._a;
    }

    public final void _a(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "<set-?>");
        this._a = qoac2;
    }

    public final boolean _b() {
        return this._b;
    }

    public final void _a(boolean bl) {
        this._b = bl;
    }

    public sald(@NotNull qoac qoac2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(qoac2, "battleResultsTag");
        this._a = qoac2;
        this._b = bl;
    }

    public sald() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
        this._b = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
        dataOutput.writeBoolean(this._b);
    }
}

