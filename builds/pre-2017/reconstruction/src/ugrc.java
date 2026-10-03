/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldList;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "list", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldsList;", "(Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldsList;)V", "data", "Lnet/minecraft/nbt/NBTTagCompound;", "getData", "()Lnet/minecraft/nbt/NBTTagCompound;", "setData", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "serverTimeMillis", "", "getServerTimeMillis", "()J", "setServerTimeMillis", "(J)V", "serverTimeZoneOffsetSeconds", "", "getServerTimeZoneOffsetSeconds", "()I", "setServerTimeZoneOffsetSeconds", "(I)V", "processClient", "", "sentFromBackend", "", "minecraft"})
public final class ugrc
extends zwat {
    @NotNull
    private NBTTagCompound _a;
    private long _b;
    private int _c;

    @NotNull
    public final NBTTagCompound _f_() {
        return this._a;
    }

    public final void _a(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "<set-?>");
        this._a = nBTTagCompound;
    }

    public final long _b() {
        return this._b;
    }

    public final void _a(long l) {
        this._b = l;
    }

    public final int _c() {
        return this._c;
    }

    public final void _a(int n) {
        this._c = n;
    }

    @Override
    public void processClient(boolean bl) {
        block1: {
            AbstractPdaTab abstractPdaTab = GuiPda.getCurrentTab();
            if (!(abstractPdaTab instanceof ndex)) {
                abstractPdaTab = null;
            }
            ndex ndex2 = (ndex)abstractPdaTab;
            if (ndex2 == null) break block1;
            ndex2._a(new pzdf(this._a));
        }
    }

    public ugrc(@NotNull pzdf pzdf2) {
        Intrinsics.checkParameterIsNotNull(pzdf2, "list");
        this._b = System.currentTimeMillis();
        this._c = ZoneId.systemDefault().getRules().getOffset(Instant.now()).getTotalSeconds();
        this._a = new NBTTagCompound();
        pzdf2._a(this._a, false);
    }

    public ugrc() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
        this._b = dataInput.readLong();
        this._c = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
        dataOutput.writeLong(this._b);
        dataOutput.writeInt(this._c);
    }
}

