/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\f"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldUpdateContext;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "getTag", "()Lnet/minecraft/nbt/NBTTagCompound;", "setTag", "processClient", "", "sentFromBackend", "", "minecraft"})
public final class wmxl
extends zwat {
    @NotNull
    private NBTTagCompound _a;

    @Override
    public void processClient(boolean bl) {
        block0: {
            pidb pidb2 = yuch._c;
            if (pidb2 == null) break block0;
            pidb2._b(this._a);
        }
    }

    @NotNull
    public final NBTTagCompound _j_() {
        return this._a;
    }

    public final void _a(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "<set-?>");
        this._a = nBTTagCompound;
    }

    public wmxl(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        this._a = nBTTagCompound;
    }

    public wmxl() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
    }
}

