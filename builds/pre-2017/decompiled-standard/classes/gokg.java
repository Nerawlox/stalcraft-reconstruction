/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldData;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "battlefield", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;)V", "battleId", "", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "data", "Lnet/minecraft/nbt/NBTTagCompound;", "getData", "()Lnet/minecraft/nbt/NBTTagCompound;", "setData", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "processClient", "", "sentFromBackend", "", "BattlefieldConsumer", "minecraft"})
public final class gokg
extends zwat {
    @NotNull
    private String _a;
    @NotNull
    private qoac _b;

    @NotNull
    public final String _e_() {
        return this._a;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._a = string;
    }

    @NotNull
    public final qoac _b() {
        return this._b;
    }

    public final void _a(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "<set-?>");
        this._b = qoac2;
    }

    @Override
    public void processClient(boolean bl) {
        block4: {
            amxi amxi2;
            Object object;
            block3: {
                object = pibk._a._b();
                List<amxi> list = object;
                ListIterator<amxi> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    amxi amxi3 = listIterator.previous();
                    amxi amxi4 = amxi3;
                    if (!Intrinsics.areEqual(amxi4._d(), this._a)) continue;
                    amxi2 = amxi3;
                    break block3;
                }
                amxi2 = null;
            }
            amxi amxi5 = amxi2;
            if (amxi5 == null) {
                return;
            }
            amxi amxi6 = amxi5;
            object = new sajz(amxi6);
            ((sajz)object)._b(this._b);
            AbstractPdaTab abstractPdaTab = GuiPda.getCurrentTab();
            if (!(abstractPdaTab instanceof kjui)) {
                abstractPdaTab = null;
            }
            kjui kjui2 = (kjui)((Object)abstractPdaTab);
            if (kjui2 == null) break block4;
            kjui2._a(this._a, (sajz)object);
        }
    }

    public gokg(@NotNull sajz sajz2) {
        Intrinsics.checkParameterIsNotNull(sajz2, "battlefield");
        this._a = sajz2._i()._d();
        this._b = new qoac();
        sajz2._c(this._b);
    }

    public gokg() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        qlgf.writeNBTTagCompound(this._b, dataOutput);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldData$BattlefieldConsumer;", "", "updateBattlefield", "", "battleId", "", "battlefield", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "minecraft"})
    public static interface kjui {
        public void _a(@NotNull String var1, @NotNull sajz var2);
    }
}

