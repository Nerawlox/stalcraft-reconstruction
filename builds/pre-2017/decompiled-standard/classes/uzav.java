/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/DetectorConfig;", "Lgloomyfolken/mods/core/configuration/ConfigReader;", "()V", "configMap", "Ljava/util/EnumMap;", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "Lgloomyfolken/mods/stalker/misc/sickness/DetectorConfig$DetectorProps;", "get", "type", "getFiles", "", "Lnet/minecraft/util/ResourceLocation;", "onConfigReadFinished", "", "readPart", "part", "Lgloomyfolken/mods/core/configuration/ConfigPart;", "DetectorProps", "DetectorPropsEntry", "minecraft"})
public final class uzav
extends ccsw {
    private static final EnumMap<klcb, kjui> _b;
    public static final uzav _a;

    @NotNull
    public final kjui _a(@NotNull klcb klcb2) {
        Object object;
        Intrinsics.checkParameterIsNotNull((Object)klcb2, "type");
        Map map = _b;
        Object v = map.get((Object)klcb2);
        if (v == null) {
            kjui kjui2 = new kjui();
            map.put(klcb2, kjui2);
            object = kjui2;
        } else {
            object = v;
        }
        return (kjui)object;
    }

    @Override
    protected void _a(@NotNull anof anof2) {
        List<String> list;
        Intrinsics.checkParameterIsNotNull(anof2, "part");
        String string = anof2._a;
        Intrinsics.checkExpressionValueIsNotNull(string, "part.header");
        klcb klcb2 = klcb._f._a(string);
        float f = anof2._j("start_power");
        int n = anof2._g("period_base");
        int n2 = anof2._g("period_random");
        int n3 = n;
        IntRange intRange = new IntRange(n3, n + n2);
        ClosedFloatingPointRange<Float> closedFloatingPointRange = RangesKt.rangeTo(anof2._a("volume_min", 0.9f), anof2._a("volume_max", 1.0f));
        ClosedFloatingPointRange<Float> closedFloatingPointRange2 = RangesKt.rangeTo(anof2._a("pitch_min", 0.9f), anof2._a("pitch_max", 1.0f));
        List<String> list2 = list = anof2._c("sound_names");
        Intrinsics.checkExpressionValueIsNotNull(list2, "soundNames");
        pidb pidb2 = new pidb(f, intRange, closedFloatingPointRange, closedFloatingPointRange2, list2);
        Collection collection = _a._a(klcb2)._a();
        collection.add(pidb2);
    }

    @Override
    protected void _d() {
        for (kjui kjui2 : _b.values()) {
            List list = kjui2._a();
            if (list.size() <= 1) continue;
            List list2 = list;
            Comparator comparator = new Comparator<T>(){

                public final int compare(T t, T t2) {
                    pidb pidb2 = (pidb)t;
                    Comparable comparable = Float.valueOf(pidb2._a());
                    pidb2 = (pidb)t2;
                    Comparable comparable2 = comparable;
                    Float f = Float.valueOf(pidb2._a());
                    return ComparisonsKt.compareValues(comparable2, (Comparable)f);
                }
            };
            CollectionsKt.sortWith(list2, comparator);
        }
    }

    @Override
    @NotNull
    protected List<ResourceLocation> _a() {
        return CollectionsKt.listOf(new ResourceLocation("stalker", "detectors.txt"));
    }

    private uzav() {
        _a = this;
        _b = new EnumMap(klcb.class);
        this._c();
    }

    static {
        new uzav();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/DetectorConfig$DetectorProps;", "", "()V", "entryList", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/stalker/misc/sickness/DetectorConfig$DetectorPropsEntry;", "Lkotlin/collections/ArrayList;", "getEntryList", "()Ljava/util/ArrayList;", "getEntry", "power", "", "minecraft"})
    public static final class kjui {
        @NotNull
        private final ArrayList<pidb> _a = new ArrayList();

        @NotNull
        public final ArrayList<pidb> _a() {
            return this._a;
        }

        @Nullable
        public final pidb _a(float f) {
            Object v0;
            block1: {
                Iterable iterable = CollectionsKt.asReversedMutable((List)this._a);
                for (Object t : iterable) {
                    pidb pidb2 = (pidb)t;
                    if (!(f > pidb2._a())) continue;
                    v0 = t;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/DetectorConfig$DetectorPropsEntry;", "", "startPower", "", "period", "Lkotlin/ranges/IntRange;", "volume", "Lkotlin/ranges/ClosedFloatingPointRange;", "pitch", "soundNames", "", "", "(FLkotlin/ranges/IntRange;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Ljava/util/List;)V", "getPeriod", "()Lkotlin/ranges/IntRange;", "getPitch", "()Lkotlin/ranges/ClosedFloatingPointRange;", "getSoundNames", "()Ljava/util/List;", "getStartPower", "()F", "getVolume", "minecraft"})
    public static final class pidb {
        private final float _a;
        @NotNull
        private final IntRange _b;
        @NotNull
        private final ClosedFloatingPointRange<Float> _c;
        @NotNull
        private final ClosedFloatingPointRange<Float> _d;
        @NotNull
        private final List<String> _e;

        public final float _a() {
            return this._a;
        }

        @NotNull
        public final IntRange _b() {
            return this._b;
        }

        @NotNull
        public final ClosedFloatingPointRange<Float> _c() {
            return this._c;
        }

        @NotNull
        public final ClosedFloatingPointRange<Float> _d() {
            return this._d;
        }

        @NotNull
        public final List<String> _e() {
            return this._e;
        }

        public pidb(float f, @NotNull IntRange intRange, @NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange, @NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange2, @NotNull List<String> list) {
            Intrinsics.checkParameterIsNotNull(intRange, "period");
            Intrinsics.checkParameterIsNotNull(closedFloatingPointRange, "volume");
            Intrinsics.checkParameterIsNotNull(closedFloatingPointRange2, "pitch");
            Intrinsics.checkParameterIsNotNull(list, "soundNames");
            this._a = f;
            this._b = intRange;
            this._c = closedFloatingPointRange;
            this._d = closedFloatingPointRange2;
            this._e = list;
        }
    }
}

