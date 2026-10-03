/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldReader;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "readBattlefield", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "id", "", "readBattlefields", "", "BattlefieldConfigDeserializer", "BattlefieldPointConfigDeserializer", "BattlefieldSlotConfigDeserializer", "minecraft"})
public final class pibk {
    @NotNull
    private static final Gson _b;
    public static final pibk _a;

    @NotNull
    public final Gson _a() {
        return _b;
    }

    @NotNull
    public final List<amxi> _b() {
        ArrayList arrayList = new ArrayList();
        List<String> list2 = srxe._a("/assets/bundle/clans/battlefields/");
        for (String string : list2) {
            try {
                String string2 = srxe._b(string);
                Collection collection = arrayList;
                amxi amxi2 = _b.fromJson(string2, amxi.class);
                collection.add(amxi2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return arrayList;
    }

    @Nullable
    public final amxi _a(@NotNull String string) {
        Object v0;
        block1: {
            Iterable iterable;
            Intrinsics.checkParameterIsNotNull(string, "id");
            Iterable iterable2 = iterable = (Iterable)this._b();
            for (Object t : iterable2) {
                amxi amxi2 = (amxi)t;
                if (!Intrinsics.areEqual(amxi2._d(), string)) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    private pibk() {
        _a = this;
        Gson gson2 = zwjx._a(new GsonBuilder()).registerTypeAdapter((Type)((Object)amxi.class), new kjui()).registerTypeAdapter((Type)((Object)amxi.pidb.class), new eidj()).registerTypeAdapter((Type)((Object)amxi.kjui.class), new pidb()).create();
        Intrinsics.checkExpressionValueIsNotNull(gson2, "PositionGson.registerAda\u2026())\n            .create()");
        _b = gson2;
    }

    static {
        new pibk();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldReader$BattlefieldConfigDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
    private static final class pibk$kjui
    implements JsonDeserializer<amxi> {
        @NotNull
        public amxi _a(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            int n;
            Object object;
            amxi amxi2;
            Intrinsics.checkParameterIsNotNull(jsonElement, "json");
            Intrinsics.checkParameterIsNotNull(type, "typeOfT");
            Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String string = ofji._a(jsonObject, "id");
            Intrinsics.checkExpressionValueIsNotNull(string, "obj.getString(\"id\")");
            String string2 = ofji._a(jsonObject, "name");
            Intrinsics.checkExpressionValueIsNotNull(string2, "obj.getString(\"name\")");
            String string3 = ofji._a(jsonObject, "locationName");
            Intrinsics.checkExpressionValueIsNotNull(string3, "obj.getString(\"locationName\")");
            List<String> list2 = ofji._d(jsonObject, "capturedBases", kjui._a);
            String string4 = ofji._a(jsonObject, "icon");
            Intrinsics.checkExpressionValueIsNotNull(string4, "obj.getString(\"icon\")");
            String string5 = ofji._a(jsonObject, "description");
            Intrinsics.checkExpressionValueIsNotNull(string5, "obj.getString(\"description\")");
            List list3 = ofji._d(jsonObject, "captureDays", pidb._a);
            LocalTime localTime = LocalTime.parse(ofji._a(jsonObject, "captureStart"));
            Intrinsics.checkExpressionValueIsNotNull(localTime, "LocalTime.parse(obj.getString(\"captureStart\"))");
            LocalTime localTime2 = LocalTime.parse(ofji._a(jsonObject, "captureEnd"));
            Intrinsics.checkExpressionValueIsNotNull(localTime2, "LocalTime.parse(obj.getString(\"captureEnd\"))");
            Duration duration = Duration.parse(ofji._a(jsonObject, "biddingStart"));
            Intrinsics.checkExpressionValueIsNotNull(duration, "Duration.parse(obj.getString(\"biddingStart\"))");
            Duration duration2 = Duration.parse(ofji._a(jsonObject, "biddingEnd"));
            Intrinsics.checkExpressionValueIsNotNull(duration2, "Duration.parse(obj.getString(\"biddingEnd\"))");
            Object object2 = jsonObject.get("defaultLoot").getAsJsonObject().entrySet();
            float f = ofji._a(jsonObject, "mapFinishZ", 100.0f);
            float f2 = ofji._a(jsonObject, "mapFinishX", 100.0f);
            float f3 = ofji._a(jsonObject, "mapStartZ", 0.0f);
            float f4 = ofji._a(jsonObject, "mapStartX", 0.0f);
            List<amxi.kjui> list4 = ofji._a(jsonObject, "capturePoints", amxi.kjui.class, jsonDeserializationContext);
            List<amxi.pidb> list5 = ofji._a(jsonObject, "battleSlots", amxi.pidb.class, jsonDeserializationContext);
            int n2 = ofji._a(jsonObject, "personalCaseId", -1);
            String string6 = owkq._a(ofji._a(jsonObject, "winnerClanLoot", ""));
            Duration duration3 = duration2;
            Duration duration4 = duration;
            LocalTime localTime3 = localTime2;
            LocalTime localTime4 = localTime;
            List list6 = list3;
            String string7 = string5;
            String string8 = string4;
            List<String> list7 = list2;
            String string9 = string3;
            String string10 = string2;
            String string11 = string;
            amxi amxi3 = amxi2;
            amxi amxi4 = amxi2;
            Object object3 = object2;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object2, 10));
            Iterator iterator2 = object3.iterator();
            while (iterator2.hasNext()) {
                Object t = iterator2.next();
                Map.Entry entry = (Map.Entry)t;
                object = collection;
                String string12 = (String)entry.getKey();
                Pair<Integer, Integer> pair = TuplesKt.to(Integer.parseInt(string12), ((JsonElement)entry.getValue()).getAsInt());
                object.add(pair);
            }
            object = (List)collection;
            amxi amxi5 = amxi4;
            amxi amxi6 = amxi3;
            String string13 = string11;
            String string14 = string10;
            String string15 = string9;
            List<String> list8 = list7;
            String string16 = string8;
            String string17 = string7;
            List list9 = list6;
            LocalTime localTime5 = localTime4;
            LocalTime localTime6 = localTime3;
            Duration duration5 = duration4;
            Duration duration6 = duration3;
            String string18 = string6;
            int n3 = n2;
            List<amxi.pidb> list10 = list5;
            List<amxi.kjui> list11 = list4;
            float f5 = f4;
            float f6 = f3;
            float f7 = f2;
            float f8 = f;
            Object object4 = MapsKt.toMap((Iterable)object);
            int n4 = ofji._a(jsonObject, "ammoClips", 0);
            Duration duration7 = Duration.parse(ofji._a(jsonObject, "respawnDuration", "PT10S"));
            Duration duration8 = duration7;
            Intrinsics.checkExpressionValueIsNotNull(duration7, "Duration.parse(obj.getSt\u2026spawnDuration\", \"PT10S\"))");
            String string19 = owkq._a(ofji._a(jsonObject, "startTime", ""));
            if (string19 != null) {
                object2 = string19;
                Duration duration9 = duration8;
                int n5 = n4;
                object = object4;
                f = f8;
                f2 = f7;
                f3 = f6;
                f4 = f5;
                list4 = list11;
                list5 = list10;
                n2 = n3;
                string6 = string18;
                duration3 = duration6;
                duration4 = duration5;
                localTime3 = localTime6;
                localTime4 = localTime5;
                list6 = list9;
                string7 = string17;
                string8 = string16;
                list7 = list8;
                string9 = string15;
                string10 = string14;
                string11 = string13;
                amxi3 = amxi6;
                amxi4 = amxi5;
                object3 = object2;
                int n6 = bqgh._a((String)object3);
                amxi5 = amxi4;
                amxi6 = amxi3;
                string13 = string11;
                string14 = string10;
                string15 = string9;
                list8 = list7;
                string16 = string8;
                string17 = string7;
                list9 = list6;
                localTime5 = localTime4;
                localTime6 = localTime3;
                duration5 = duration4;
                duration6 = duration3;
                string18 = string6;
                n3 = n2;
                list10 = list5;
                list11 = list4;
                f5 = f4;
                f6 = f3;
                f7 = f2;
                f8 = f;
                object4 = object;
                n4 = n5;
                duration8 = duration9;
                n = n6;
            } else {
                n = -1;
            }
            amxi6(string13, string14, string15, list8, string16, string17, list9, localTime5, localTime6, duration5, duration6, string18, n3, list10, list11, f5, f6, f7, f8, (Map<Integer, Integer>)object4, n4, duration8, n, ofji._a(jsonObject, "scoreEnemyKill", 0.0));
            return amxi5;
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldReader$BattlefieldSlotConfigDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
    private static final class eidj
    implements JsonDeserializer<amxi.pidb> {
        @NotNull
        public amxi.pidb _a(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            Collection<dfkn> collection;
            amxi.pidb pidb2;
            Intrinsics.checkParameterIsNotNull(jsonElement, "json");
            Intrinsics.checkParameterIsNotNull(type, "typeOfT");
            Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            Object t = jsonDeserializationContext.deserialize(jsonObject.get("position"), (Type)((Object)einh.class));
            Intrinsics.checkExpressionValueIsNotNull(t, "context.deserialize(obj.\u2026ocalLocation::class.java)");
            Iterable iterable = ofji._a(jsonObject, "spawnRegions", null, kjui._a, 2, null);
            List<hrvl> list2 = ofji._a(jsonObject, "spawnPoints", hrvl.class, jsonDeserializationContext);
            int n = ofji._a(jsonObject, "numPlayers", 25);
            int n2 = ofji._a(jsonObject, "basePrice", 0);
            boolean bl = ofji._c(jsonObject, "isDefenderSlot");
            einh einh2 = (einh)t;
            amxi.pidb pidb3 = pidb2;
            amxi.pidb pidb4 = pidb2;
            Iterable iterable2 = iterable;
            Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object t2 : iterable2) {
                double[] dArray = (double[])t2;
                collection = collection2;
                dfkn dfkn2 = new dfkn(dArray);
                collection.add(dfkn2);
            }
            collection = (List)collection2;
            pidb3(einh2, bl, n2, n, list2, (List<? extends dfkn>)collection);
            return pidb4;
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldReader$BattlefieldPointConfigDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldPointConfig;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
    private static final class pidb
    implements JsonDeserializer<amxi.kjui> {
        @NotNull
        public amxi.kjui _a(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            Intrinsics.checkParameterIsNotNull(jsonElement, "json");
            Intrinsics.checkParameterIsNotNull(type, "typeOfT");
            Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String string = ofji._a(jsonObject, "name", "");
            Intrinsics.checkExpressionValueIsNotNull(string, "obj.getString(\"name\", \"\")");
            Object t = jsonDeserializationContext.deserialize(jsonObject.get("position"), (Type)((Object)einh.class));
            Intrinsics.checkExpressionValueIsNotNull(t, "context.deserialize(obj.\u2026ocalLocation::class.java)");
            return new amxi.kjui(string, (einh)t, ofji._a(jsonObject, "blockId", -1), ofji._a(jsonObject, "scoreGainPerSecond", 1.0), ofji._a(jsonObject, "captureSeconds", 30.0), ofji._a(jsonObject, "maxCapturePlayers", 5), ofji._a(jsonObject, "captureMinY", 0.0), ofji._a(jsonObject, "captureMaxY", 255.0), ofji._b(jsonObject, "captureBounds", kjui._a), ofji._a(jsonObject, "spawnPoints", hrvl.class, jsonDeserializationContext), ofji._a(jsonObject, "ownedByDefender", false));
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

