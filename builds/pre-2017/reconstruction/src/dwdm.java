/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0003H\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/PacketBattlefieldInitializeContext;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "captureContext", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;)V", "battleId", "", "defenderClanName", "slotOwnerClans", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getDefenderClanName", "setDefenderClanName", "getSlotOwnerClans", "()Ljava/util/List;", "setSlotOwnerClans", "(Ljava/util/List;)V", "makeContext", "processBackendToFrontend", "", "processClient", "sentFromBackend", "", "read", "input", "Ljava/io/DataInput;", "write", "output", "Ljava/io/DataOutput;", "minecraft"})
public final class dwdm
extends zwat {
    @NotNull
    private String _a;
    @Nullable
    private String _b;
    @NotNull
    private List<String> _c;

    @Override
    public void write(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        dataOutput.writeUTF(this._a);
        Object object = this._b;
        Object object2 = dataOutput;
        Object object3 = object;
        if (object3 == null) {
            object3 = "";
        }
        String string = object3;
        object2.writeUTF(string);
        Object object4 = object = (Iterable)this._c;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object, 10));
        Iterator iterator2 = object4.iterator();
        while (iterator2.hasNext()) {
            Object t = iterator2.next();
            String string2 = (String)t;
            object2 = collection;
            String string3 = string2;
            String string4 = string3;
            if (string4 == null) {
                string4 = "";
            }
            string = string4;
            object2.add(string);
        }
        zwat.writeStringList((List)collection, dataOutput);
    }

    @Override
    public void read(@NotNull DataInput dataInput) {
        Collection<String> collection;
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        String string = dataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(string, "input.readUTF()");
        this._a = string;
        this._b = owkq._a(dataInput.readUTF());
        Iterable iterable = zwat.readStringList(dataInput);
        dwdm dwdm2 = this;
        Iterable iterable2 = iterable;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            String string2 = (String)t;
            collection = collection2;
            String string3 = string2;
            String string4 = string3 != null ? owkq._a(string3) : null;
            collection.add(string4);
        }
        collection = (List)collection2;
        dwdm2._c = collection;
    }

    @Override
    public void processClient(boolean bl) {
        pidb pidb2 = this._d();
        pkix pkix2 = Minecraft._E()._r;
        Intrinsics.checkExpressionValueIsNotNull(pkix2, "Minecraft.getMinecraft().theWorld");
        pidb2._a(pkix2);
        yuch._c = pidb2;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    private final pidb _d() {
        return new pidb(this._a, this._b, this._c);
    }

    @NotNull
    public final String _c_() {
        return this._a;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._a = string;
    }

    @Nullable
    public final String _b() {
        return this._b;
    }

    public final void _b(@Nullable String string) {
        this._b = string;
    }

    @NotNull
    public final List<String> _c() {
        return this._c;
    }

    public final void _a(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this._c = list;
    }

    public dwdm(@NotNull String string, @Nullable String string2, @NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        Intrinsics.checkParameterIsNotNull(list, "slotOwnerClans");
        this._a = string;
        this._b = string2;
        this._c = list;
    }

    public dwdm() {
    }
}

