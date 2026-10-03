/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.spawn.region;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnEntryInfo;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionBounds;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionEntry;
import java.awt.Point;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionReader;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "parser", "Lcom/google/gson/JsonParser;", "readRegions", "", "", "Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionEntry;", "json", "bounds", "", "Ljava/awt/Point;", "JsonBoundsDeserializer", "minecraft"})
public final class SpawnRegionReader {
    private static final Gson gson;
    private static final JsonParser parser;
    public static final SpawnRegionReader INSTANCE;

    @NotNull
    public final Map<String, SpawnRegionEntry> readRegions(@NotNull String string, @Nullable List<? extends Point> list2) {
        Intrinsics.checkParameterIsNotNull(string, "json");
        HashMap hashMap = new HashMap();
        Set<Map.Entry<String, JsonElement>> set = parser.parse(string).getAsJsonObject().entrySet();
        for (Map.Entry<String, JsonElement> entry : set) {
            Object object = entry;
            String string2 = object.getKey();
            object = entry;
            JsonElement jsonElement = object.getValue();
            object = gson.fromJson(jsonElement, SpawnRegionEntry.class);
            Object object2 = jsonElement.getAsJsonObject().get("config").getAsJsonObject().get("spawn_entries").getAsJsonArray();
            Object object3 = object2.iterator();
            while (object3.hasNext()) {
                JsonObject jsonObject;
                Object t = object3.next();
                JsonElement jsonElement2 = (JsonElement)t;
                JsonObject jsonObject2 = jsonObject = jsonElement2.getAsJsonObject();
                ArrayList<qman> arrayList = ((SpawnRegionEntry)object).getConfiguration().getPossibleSpawnEntries();
                String string3 = jsonObject2.get("name").getAsString();
                Intrinsics.checkExpressionValueIsNotNull(string3, "obj.get(\"name\").asString");
                arrayList.add(new MutantSpawnEntryInfo(string3, jsonObject2.get("weight").getAsFloat()));
            }
            ((SpawnRegionEntry)object).getConfiguration().getPossibleSpawnEntries();
            ((SpawnRegionEntry)object).getBounds().generateTriangles(list2);
            ((SpawnRegionEntry)object).getConfiguration().setEntityCountPercentage(((SpawnRegionEntry)object).getBounds().getClippedAreaCoverage());
            object2 = hashMap;
            object3 = TuplesKt.to(string2, object);
            object2.put(((Pair)object3).getFirst(), ((Pair)object3).getSecond());
        }
        return hashMap;
    }

    @NotNull
    public static /* synthetic */ Map readRegions$default(SpawnRegionReader spawnRegionReader, String string, List list2, int n, Object object) {
        if ((n & 2) != 0) {
            list2 = null;
        }
        return spawnRegionReader.readRegions(string, list2);
    }

    private SpawnRegionReader() {
        INSTANCE = this;
        gson = new GsonBuilder().registerTypeAdapter((Type)((Object)SpawnRegionBounds.class), new JsonBoundsDeserializer()).create();
        parser = new JsonParser();
    }

    static {
        new SpawnRegionReader();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionReader$JsonBoundsDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionBounds;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
    private static final class JsonBoundsDeserializer
    implements JsonDeserializer<SpawnRegionBounds> {
        @Override
        @NotNull
        public SpawnRegionBounds deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            Iterable iterable;
            Intrinsics.checkParameterIsNotNull(jsonElement, "json");
            Intrinsics.checkParameterIsNotNull(type, "typeOfT");
            Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
            Iterable iterable2 = iterable = (Iterable)jsonElement.getAsJsonArray();
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object t : iterable2) {
                JsonElement jsonElement2 = (JsonElement)t;
                Collection collection2 = collection;
                Point point = new Point((int)jsonElement2.getAsJsonArray().get(0).getAsDouble(), (int)jsonElement2.getAsJsonArray().get(1).getAsDouble());
                collection2.add(point);
            }
            List list2 = (List)collection;
            return new SpawnRegionBounds(list2);
        }
    }
}

