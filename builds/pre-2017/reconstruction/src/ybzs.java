/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2={"Lgloomyfolken/bundle/common/config/LocationReader;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "createLocationConfig", "Lgloomyfolken/bundle/common/config/LocationConfig;", "text", "", "LocationConfigDeserializer", "LocationConfigEntryDeserializer", "minecraft"})
public final class ybzs {
    @NotNull
    private static final Gson _b;
    public static final ybzs _a;

    @NotNull
    public final Gson _a() {
        return _b;
    }

    @NotNull
    public final dwbf _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "text");
        dwbf dwbf2 = _b.fromJson(string, dwbf.class);
        if (dwbf2 == null) {
            Intrinsics.throwNpe();
        }
        return dwbf2;
    }

    private ybzs() {
        _a = this;
        Gson gson2 = zwjx._a(new GsonBuilder()).registerTypeAdapter((Type)((Object)dwbf.class), new kjui()).registerTypeAdapter((Type)((Object)sajh.class), new pidb()).create();
        Intrinsics.checkExpressionValueIsNotNull(gson2, "PositionGson.registerAda\u2026())\n            .create()");
        _b = gson2;
    }

    static {
        new ybzs();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/bundle/common/config/LocationReader$LocationConfigDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/bundle/common/config/LocationConfig;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
    private static final class kjui
    implements JsonDeserializer<dwbf> {
        @NotNull
        public dwbf _a(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            Intrinsics.checkParameterIsNotNull(jsonElement, "json");
            Intrinsics.checkParameterIsNotNull(type, "typeOfT");
            Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("locations");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (JsonElement jsonElement2 : jsonArray) {
                sajh sajh2;
                sajh sajh3 = (sajh)jsonDeserializationContext.deserialize(jsonElement2, (Type)((Object)sajh.class));
                Map map = linkedHashMap;
                String string = sajh3._c();
                Intrinsics.checkExpressionValueIsNotNull(sajh3, "location");
                map.put(string, sajh2);
            }
            Map map = linkedHashMap;
            Object t = jsonDeserializationContext.deserialize(jsonObject.get("defaultSavepoint"), (Type)((Object)iuyn.class));
            Intrinsics.checkExpressionValueIsNotNull(t, "context.deserialize(root\u2026obalPosition::class.java)");
            iuyn iuyn2 = (iuyn)t;
            Object t2 = jsonDeserializationContext.deserialize(jsonObject.get("fallbackSavepoint"), (Type)((Object)iuyn.class));
            Intrinsics.checkExpressionValueIsNotNull(t2, "context.deserialize(root\u2026obalPosition::class.java)");
            return new dwbf(map, iuyn2, (iuyn)t2);
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/bundle/common/config/LocationReader$LocationConfigEntryDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/bundle/common/config/LocationConfigEntry;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
    private static final class ybzs$pidb
    implements JsonDeserializer<sajh> {
        @NotNull
        public sajh _a(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            Map map;
            double d;
            Duration duration;
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            boolean bl;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            float f;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            boolean bl7;
            hrvl hrvl2;
            List list;
            List list2;
            Object object;
            String string2;
            String string3;
            sajh sajh2;
            sajh sajh3;
            JsonObject jsonObject;
            block9: {
                block8: {
                    Object object2;
                    Object object3;
                    Object object4;
                    sajh sajh4;
                    sajh sajh5;
                    String string4;
                    String string5;
                    Object object5;
                    block7: {
                        sajh sajh6;
                        Intrinsics.checkParameterIsNotNull(jsonElement, "json");
                        Intrinsics.checkParameterIsNotNull(type, "typeOfT");
                        Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
                        jsonObject = jsonElement.getAsJsonObject();
                        String string6 = ofji._a(jsonObject, "name");
                        Intrinsics.checkExpressionValueIsNotNull(string6, "obj.getString(\"name\")");
                        String string7 = ofji._a(jsonObject, "localizedName");
                        Intrinsics.checkExpressionValueIsNotNull(string7, "obj.getString(\"localizedName\")");
                        object5 = (Object[])sajh.kjui.values();
                        string5 = string7;
                        string4 = string6;
                        sajh5 = sajh6;
                        sajh4 = sajh6;
                        for (int i = 0; i < ((Object[])object5).length; ++i) {
                            object4 = object5[i];
                            object3 = (sajh.kjui)((Object)object4);
                            if (!Intrinsics.areEqual(object3._a(), ofji._a(jsonObject, "type", "open_world"))) {
                                continue;
                            }
                            break block7;
                        }
                        throw (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
                    }
                    Object object6 = object4;
                    sajh3 = sajh4;
                    sajh2 = sajh5;
                    string3 = string4;
                    string2 = string5;
                    object = (sajh.kjui)((Object)object6);
                    list2 = ofji._b(jsonObject, "bounds", kjui._a);
                    list = ofji._b(jsonObject, "tpBorders", null, pidb._a, 2, null);
                    Object t = jsonDeserializationContext.deserialize(jsonObject.get("spawnPoint"), (Type)((Object)hrvl.class));
                    Intrinsics.checkExpressionValueIsNotNull(t, "context.deserialize(obj.\u2026ocalPosition::class.java)");
                    hrvl2 = (hrvl)t;
                    bl7 = ofji._a(jsonObject, "respawnOnPoint", false);
                    n10 = ofji._b(jsonObject, "xmxMB");
                    n9 = ofji._b(jsonObject, "optimalPlayers");
                    n8 = ofji._a(jsonObject, "maxPlayersPerInstance", 0);
                    n7 = ofji._a(jsonObject, "maxInstances", 1);
                    n6 = ofji._a(jsonObject, "minServers", 1);
                    n5 = ofji._a(jsonObject, "maxServers", 10000);
                    f = ofji._a(jsonObject, "artefaktSpawnFactor", 1.0f);
                    bl6 = ofji._a(jsonObject, "noEjection", false);
                    bl5 = ofji._a(jsonObject, "noCorpses", false);
                    bl4 = ofji._a(jsonObject, "noDrop", false);
                    bl3 = ofji._a(jsonObject, "noMobs", false);
                    bl2 = ofji._a(jsonObject, "noItemDamage", false);
                    bl = ofji._a(jsonObject, "removeCommonEntities", false);
                    n4 = ofji._a(jsonObject, "corpseBagSpawnDelay", 30) * 1000;
                    n3 = ofji._a(jsonObject, "corpseBagEmptyLifetime", 10) * 1000;
                    n2 = ofji._a(jsonObject, "corpseBagLootedLifetime", 600) * 1000;
                    n = ofji._a(jsonObject, "corpseBagUnlootedLifetime", 1800) * 1000;
                    String string8 = ofji._a(jsonObject, "loot", "");
                    string = string8;
                    Intrinsics.checkExpressionValueIsNotNull(string8, "obj.getString(\"loot\", \"\")");
                    Duration duration2 = Duration.parse(ofji._a(jsonObject, "lootCooldown", "PT1H"));
                    duration = duration2;
                    Intrinsics.checkExpressionValueIsNotNull(duration2, "Duration.parse(obj.getSt\u2026(\"lootCooldown\", \"PT1H\"))");
                    d = ofji._a(jsonObject, "lootProbability", 1.0);
                    map = jsonObject.get("resourcePoints");
                    if (map == null || (map = ((JsonElement)((Object)map)).getAsJsonObject()) == null || (map = ((JsonObject)((Object)map)).entrySet()) == null) break block8;
                    object5 = (Iterable)((Object)map);
                    double d2 = d;
                    Duration duration3 = duration;
                    String string9 = string;
                    int n11 = n;
                    int n12 = n2;
                    int n13 = n3;
                    int n14 = n4;
                    boolean bl8 = bl;
                    boolean bl9 = bl2;
                    boolean bl10 = bl3;
                    boolean bl11 = bl4;
                    boolean bl12 = bl5;
                    boolean bl13 = bl6;
                    float f2 = f;
                    int n15 = n5;
                    int n16 = n6;
                    int n17 = n7;
                    int n18 = n8;
                    int n19 = n9;
                    int n20 = n10;
                    boolean bl14 = bl7;
                    hrvl hrvl3 = hrvl2;
                    List list3 = list;
                    List list4 = list2;
                    object6 = object;
                    string5 = string2;
                    string4 = string3;
                    sajh5 = sajh2;
                    sajh4 = sajh3;
                    Object object7 = object5;
                    object4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(object5, 10));
                    object3 = object7.iterator();
                    while (object3.hasNext()) {
                        Object e = object3.next();
                        Map.Entry entry = (Map.Entry)e;
                        object2 = object4;
                        Pair pair = TuplesKt.to(entry.getKey(), Float.valueOf(((JsonElement)entry.getValue()).getAsFloat()));
                        object2.add(pair);
                    }
                    object2 = (List)object4;
                    sajh3 = sajh4;
                    sajh2 = sajh5;
                    string3 = string4;
                    string2 = string5;
                    object = object6;
                    list2 = list4;
                    list = list3;
                    hrvl2 = hrvl3;
                    bl7 = bl14;
                    n10 = n20;
                    n9 = n19;
                    n8 = n18;
                    n7 = n17;
                    n6 = n16;
                    n5 = n15;
                    f = f2;
                    bl6 = bl13;
                    bl5 = bl12;
                    bl4 = bl11;
                    bl3 = bl10;
                    bl2 = bl9;
                    bl = bl8;
                    n4 = n14;
                    n3 = n13;
                    n2 = n12;
                    n = n11;
                    string = string9;
                    duration = duration3;
                    d = d2;
                    map = MapsKt.toMap((Iterable)object2);
                    if (map != null) break block9;
                }
                map = MapsKt.emptyMap();
            }
            sajh2(string3, string2, (sajh.kjui)((Object)object), list2, list, hrvl2, bl7, n10, n9, n8, n7, n6, n5, f, bl6, bl5, bl4, bl3, bl2, bl, n4, n3, n2, n, string, duration, d, map, ofji._a(jsonObject, "ignoreGlobalTime", false));
            return sajh3;
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

