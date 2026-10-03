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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ezey(_a={eidj.FRONTEND, eidj.CLIENT})
@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldTotalStats;", "Lgloomyfolken/bundle/common/core/CommonPacket;", "captureStats", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;)V", "statsTable", "", "Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldTotalStats$StatSyncEntry;", "processClient", "", "sentFromBackend", "", "read", "input", "Ljava/io/DataInput;", "write", "output", "Ljava/io/DataOutput;", "StatSyncEntry", "minecraft"})
public final class iuqq
extends zwat {
    private List<kjui> _a;

    @Override
    public void write(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        List<kjui> list2 = this._a;
        if (list2 == null) {
            Intrinsics.throwNpe();
        }
        List<kjui> list3 = list2;
        dataOutput.writeInt(list3.size());
        for (kjui kjui2 : list3) {
            dataOutput.writeUTF(kjui2._a());
            dataOutput.writeUTF(kjui2._b());
            dataOutput.writeInt(kjui2._c().ordinal());
            dataOutput.writeDouble(kjui2._d());
        }
    }

    @Override
    public void read(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        int n = dataInput.readInt();
        ArrayList arrayList = new ArrayList(n);
        int n2 = 1;
        int n3 = n;
        if (n2 <= n3) {
            while (true) {
                Collection collection = arrayList;
                String string = dataInput.readUTF();
                Intrinsics.checkExpressionValueIsNotNull(string, "input.readUTF()");
                String string2 = dataInput.readUTF();
                Intrinsics.checkExpressionValueIsNotNull(string2, "input.readUTF()");
                kjui kjui2 = new kjui(string, string2, pidb.zwat._k._a()[dataInput.readInt()], dataInput.readDouble());
                collection.add(kjui2);
                if (n2 == n3) break;
                ++n2;
            }
        }
        this._a = arrayList;
    }

    @Override
    public void processClient(boolean bl) {
        Object object = yuch._c;
        if (object == null || (object = ((pidb)object)._h()) == null) {
            return;
        }
        Object object2 = object;
        ((pidb.zwaw)object2)._c();
        List<kjui> list2 = this._a;
        if (list2 == null) {
            Intrinsics.throwNpe();
        }
        for (kjui kjui2 : list2) {
            kjui2._a((pidb.zwaw)object2);
        }
    }

    public iuqq(@NotNull pidb.zwaw zwaw2) {
        Object object;
        Object object2;
        Intrinsics.checkParameterIsNotNull(zwaw2, "captureStats");
        Object object3 = zwaw2._a();
        iuqq iuqq2 = this;
        Object object4 = object3;
        Collection collection = new ArrayList();
        Iterator iterator2 = object4;
        Iterator<Map.Entry<pidb.pidb, HashMap<String, pidb.zwaw.kjui>>> iterator3 = iterator2.entrySet().iterator();
        while (iterator3.hasNext()) {
            object = object2 = iterator3.next();
            iterator2 = object.getValue().values();
            CollectionsKt.addAll(collection, iterator2);
        }
        List list2 = (List)collection;
        object4 = object3 = (Iterable)list2;
        collection = new ArrayList();
        iterator2 = object4.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry;
            Object t;
            iterator3 = iterator2.next();
            object2 = (pidb.zwaw.kjui)((Object)iterator3);
            object = ((pidb.zwaw.kjui)object2)._a().entrySet();
            Object object5 = object;
            Collection collection2 = new ArrayList();
            Iterator iterator4 = object5.iterator();
            while (iterator4.hasNext()) {
                t = iterator4.next();
                entry = (Map.Entry)t;
                if (!((pidb.zwaw.kjui.kjui)entry.getValue())._f()._b()) continue;
                collection2.add(t);
            }
            object = (List)collection2;
            object5 = object;
            collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(object, 10));
            iterator4 = object5.iterator();
            while (iterator4.hasNext()) {
                t = iterator4.next();
                entry = (Map.Entry)t;
                Collection collection3 = collection2;
                String string = ((pidb.zwaw.kjui)object2)._c();
                String string2 = ((pidb.zwaw.kjui)object2)._d();
                Object k = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(k, "it.key");
                kjui kjui2 = new kjui(string, string2, (pidb.zwat)((Object)k), ((pidb.zwaw.kjui.kjui)entry.getValue())._a());
                collection3.add(kjui2);
            }
            Iterable iterable = (List)collection2;
            CollectionsKt.addAll(collection, iterable);
        }
        iuqq2._a = list2 = (List)collection;
    }

    public iuqq() {
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014R\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/bundle/common/network/packet/clans/client/PacketBattlefieldTotalStats$StatSyncEntry;", "", "username", "", "clanName", "type", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "value", "", "(Ljava/lang/String;Ljava/lang/String;Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;D)V", "getClanName", "()Ljava/lang/String;", "getType", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "getUsername", "getValue", "()D", "add", "", "stats", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "minecraft"})
    private static final class kjui {
        @NotNull
        private final String _a;
        @NotNull
        private final String _b;
        @NotNull
        private final pidb.zwat _c;
        private final double _d;

        public final void _a(@NotNull pidb.zwaw zwaw2) {
            Intrinsics.checkParameterIsNotNull(zwaw2, "stats");
            zwaw2._a(this._a, this._b)._a(this._c)._a(this._d);
        }

        @NotNull
        public final String _a() {
            return this._a;
        }

        @NotNull
        public final String _b() {
            return this._b;
        }

        @NotNull
        public final pidb.zwat _c() {
            return this._c;
        }

        public final double _d() {
            return this._d;
        }

        public kjui(@NotNull String string, @NotNull String string2, @NotNull pidb.zwat zwat2, double d) {
            Intrinsics.checkParameterIsNotNull(string, "username");
            Intrinsics.checkParameterIsNotNull(string2, "clanName");
            Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
            this._a = string;
            this._b = string2;
            this._c = zwat2;
            this._d = d;
        }
    }
}

