/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import mods.regions.Region;
import mods.regions.RegionFlag;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/SicknessRegions;", "", "()V", "damage", "Lmods/regions/RegionFlag;", "getDamage", "()Lmods/regions/RegionFlag;", "effects", "getEffects", "intSetAd", "Lmods/regions/RegionFlag$FlagAdapter;", "", "", "getIntSetAd", "()Lmods/regions/RegionFlag$FlagAdapter;", "itemsWhitelist", "getItemsWhitelist", "sicknessAd", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessAccumulation;", "getSicknessAd", "registerFlags", "", "minecraft"})
public final class klcd {
    @NotNull
    private static final RegionFlag.FlagAdapter<Set<Integer>> _b;
    @NotNull
    private static final RegionFlag.FlagAdapter<yulf> _c;
    @NotNull
    private static final RegionFlag _d;
    @NotNull
    private static final RegionFlag _e;
    @NotNull
    private static final RegionFlag _f;
    public static final klcd _a;

    @NotNull
    public final RegionFlag.FlagAdapter<Set<Integer>> _a() {
        return _b;
    }

    @NotNull
    public final RegionFlag.FlagAdapter<yulf> _b() {
        return _c;
    }

    @NotNull
    public final RegionFlag _c() {
        return _d;
    }

    @NotNull
    public final RegionFlag _d() {
        return _e;
    }

    @NotNull
    public final RegionFlag _e() {
        return _f;
    }

    public final void _f() {
        Region.registerFlag(_d);
        Region.registerFlag(_e);
        Region.registerFlag(_f);
    }

    private klcd() {
        _a = this;
        _b = new RegionFlag.FlagAdapter<Set<? extends Integer>>(){

            @NotNull
            public Set<Integer> _a(@NotNull JsonElement jsonElement) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(jsonElement, "element");
                Iterable iterable2 = iterable = (Iterable)jsonElement.getAsJsonArray();
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    JsonElement jsonElement2 = (JsonElement)t;
                    Collection collection2 = collection;
                    Integer n = jsonElement2.getAsInt();
                    collection2.add(n);
                }
                return CollectionsKt.toSet((List)collection);
            }

            @Override
            public /* synthetic */ Object fromJson(JsonElement jsonElement) {
                return this._a(jsonElement);
            }

            public void _a(@NotNull Set<Integer> set, @NotNull DataOutput dataOutput) {
                Intrinsics.checkParameterIsNotNull(set, "obj");
                Intrinsics.checkParameterIsNotNull(dataOutput, "output");
                dataOutput.writeInt(set.size());
                Iterable iterable = set;
                for (Object t : iterable) {
                    int n = ((Number)t).intValue();
                    dataOutput.writeInt(n);
                }
            }

            @Override
            public /* synthetic */ void write(Object object, DataOutput dataOutput) {
                this._a((Set)object, dataOutput);
            }

            @NotNull
            public Set<Integer> _a(@NotNull DataInput dataInput) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(dataInput, "input");
                Iterable iterable2 = iterable = (Iterable)RangesKt.until(0, dataInput.readInt());
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator iterator2 = iterable2.iterator();
                while (iterator2.hasNext()) {
                    int n;
                    int n2 = n = ((IntIterator)iterator2).nextInt();
                    Collection collection2 = collection;
                    Integer n3 = dataInput.readInt();
                    collection2.add(n3);
                }
                return CollectionsKt.toSet((List)collection);
            }

            @Override
            public /* synthetic */ Object read(DataInput dataInput) {
                return this._a(dataInput);
            }

            @Override
            @NotNull
            public Pair<Set<Integer>, Integer> parse(@NotNull String[] stringArray) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(stringArray, "args");
                Iterable iterable2 = iterable = (Iterable)StringsKt.split$default((CharSequence)stringArray[0], new String[]{","}, false, 0, 6, null);
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    String string = (String)t;
                    Collection collection2 = collection;
                    String string2 = string;
                    Integer n = Integer.parseInt(string2);
                    collection2.add(n);
                }
                Pair<Set<Integer>, Integer> pair = Pair.of(CollectionsKt.toSet((List)collection), 1);
                Intrinsics.checkExpressionValueIsNotNull(pair, "Pair.of(args[0].split(\",\u2026 it.toInt() }.toSet(), 1)");
                return pair;
            }
        };
        _c = new RegionFlag.FlagAdapter<yulf>(){

            @NotNull
            public yulf _a(@NotNull JsonElement jsonElement) {
                Intrinsics.checkParameterIsNotNull(jsonElement, "element");
                yulf yulf2 = new yulf();
                Iterable iterable = jsonElement.getAsJsonArray();
                int n = 0;
                for (Object t : iterable) {
                    int n2 = n++;
                    JsonElement jsonElement2 = (JsonElement)t;
                    int n3 = n2;
                    yulf2._b()[n3] = jsonElement2.getAsFloat();
                }
                return yulf2;
            }

            @Override
            public /* synthetic */ Object fromJson(JsonElement jsonElement) {
                return this._a(jsonElement);
            }

            @NotNull
            public JsonElement _a(@NotNull yulf yulf2) {
                Intrinsics.checkParameterIsNotNull(yulf2, "obj");
                JsonElement jsonElement = new Gson().toJsonTree(yulf2._b());
                Intrinsics.checkExpressionValueIsNotNull(jsonElement, "Gson().toJsonTree(obj.values)");
                return jsonElement;
            }

            @Override
            public /* synthetic */ JsonElement toJson(Object object) {
                return this._a((yulf)object);
            }

            public void _a(@NotNull yulf yulf2, @NotNull DataOutput dataOutput) {
                Intrinsics.checkParameterIsNotNull(yulf2, "obj");
                Intrinsics.checkParameterIsNotNull(dataOutput, "output");
                float[] fArray = yulf2._b();
                for (int i = 0; i < fArray.length; ++i) {
                    float f;
                    float f2 = f = fArray[i];
                    dataOutput.writeFloat(f2);
                }
            }

            @Override
            public /* synthetic */ void write(Object object, DataOutput dataOutput) {
                this._a((yulf)object, dataOutput);
            }

            @NotNull
            public yulf _a(@NotNull DataInput dataInput) {
                Intrinsics.checkParameterIsNotNull(dataInput, "input");
                yulf yulf2 = new yulf();
                int n = ((Object[])klcb.values()).length;
                int n2 = 0;
                int n3 = n - 1;
                if (n2 <= n3) {
                    do {
                        int n4 = ++n2;
                        yulf2._b()[n4] = dataInput.readFloat();
                    } while (n2 != n3);
                }
                return yulf2;
            }

            @Override
            public /* synthetic */ Object read(DataInput dataInput) {
                return this._a(dataInput);
            }

            @Override
            @NotNull
            public Pair<yulf, Integer> parse(@NotNull String[] stringArray) {
                Object object;
                Intrinsics.checkParameterIsNotNull(stringArray, "args");
                String string = stringArray[0];
                yulf yulf2 = new yulf();
                Iterable iterable = StringsKt.split$default((CharSequence)string, new String[]{";"}, false, 0, 6, null);
                Iterable iterable2 = iterable;
                Collection collection3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Object object2 = iterable2.iterator();
                while (object2.hasNext()) {
                    object = object2.next();
                    String string2 = (String)object;
                    Collection collection2 = collection3;
                    List list = StringsKt.split$default((CharSequence)string2, new String[]{"@"}, false, 0, 6, null);
                    collection2.add(list);
                }
                iterable = (List)collection3;
                for (Collection collection3 : iterable) {
                    klcb klcb2;
                    yulf yulf3;
                    object2 = (List)collection3;
                    object = (String)object2.get(1);
                    float f = yulf2._a(klcb._f._a((String)object2.get(0)));
                    float f2 = Float.parseFloat(object);
                    yulf3._a(klcb2, f + f2);
                }
                Pair<yulf, Integer> pair = Pair.of(yulf2, 1);
                Intrinsics.checkExpressionValueIsNotNull(pair, "Pair.of(accum, 1)");
                return pair;
            }
        };
        _d = new RegionFlag("sick_items", _b, true, new String[0]);
        _e = new RegionFlag("sick_effects", _c, true, new String[0]);
        _f = new RegionFlag("sick_damage", RegionFlag.doubleAd, false, new String[0]);
    }

    static {
        new klcd();
    }
}

