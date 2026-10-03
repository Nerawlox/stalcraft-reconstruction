/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001&B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u001eH\u0007J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\bR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006'"}, d2={"Lgloomyfolken/bundle/common/clans/StackCatalog;", "", "()V", "stacks", "", "Lgloomyfolken/bundle/common/utils/ItemStackData;", "(Ljava/util/List;)V", "list", "Lnet/minecraft/nbt/NBTTagList;", "(Lnet/minecraft/nbt/NBTTagList;)V", "_contents", "Ljava/util/LinkedHashMap;", "Lgloomyfolken/bundle/common/clans/StackCatalog$StackCatalogEntry;", "contents", "", "getContents", "()Ljava/util/Map;", "setContents", "(Ljava/util/Map;)V", "addStack", "", "stack", "numItems", "", "filterPrices", "preservedStacks", "", "getEntry", "index", "getPrice", "Lnet/minecraft/item/ItemStack;", "readFromNBT", "setPrice", "price", "setPrices", "prices", "", "writeToNBT", "StackCatalogEntry", "minecraft"})
public final class srli {
    private final LinkedHashMap<wnce, kjui> _a;
    @NotNull
    private Map<wnce, kjui> _b;

    @NotNull
    public final Map<wnce, kjui> _a() {
        return this._b;
    }

    public final void _a(@NotNull Map<wnce, kjui> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this._b = map;
    }

    public final void _a(@NotNull bsyv bsyv2) {
        Intrinsics.checkParameterIsNotNull(bsyv2, "list");
        int n = 0;
        int n2 = bsyv2._d() - 1;
        if (n <= n2) {
            while (true) {
                huhy huhy2 = bsyv2._b(n);
                if (huhy2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                }
                qoac qoac2 = (qoac)huhy2;
                qoac qoac3 = qoac2._m("item");
                Intrinsics.checkExpressionValueIsNotNull(qoac3, "tag.getCompoundTag(\"item\")");
                wnce wnce2 = new wnce(qoac3);
                kjui kjui2 = new kjui(wnce2, qoac2._f("price"), qoac2._f("numItems"));
                this._a.put(wnce2, kjui2);
                if (n == n2) break;
                ++n;
            }
        }
    }

    @NotNull
    public final bsyv _b() {
        bsyv bsyv2 = new bsyv();
        Object object = this._b;
        for (Map.Entry<wnce, kjui> entry : object.entrySet()) {
            qoac qoac2;
            Object object2 = entry;
            object = object2.getKey();
            object2 = entry;
            kjui kjui2 = object2.getValue();
            object2 = new qoac();
            qoac qoac3 = qoac2 = flra._a((qoac)object2, "item");
            Intrinsics.checkExpressionValueIsNotNull(qoac3, "itemTag");
            ((wnce)object)._a(qoac3);
            ((qoac)object2)._a("item", (huhy)qoac2);
            ((qoac)object2)._a("price", kjui2._b());
            ((qoac)object2)._a("numItems", kjui2._c());
            bsyv2._a((huhy)object2);
        }
        return bsyv2;
    }

    public final void _a(@NotNull wnce wnce2, int n) {
        Intrinsics.checkParameterIsNotNull(wnce2, "stack");
        this._a(wnce2)._a(n);
    }

    public final void _b(@NotNull wnce wnce2, int n) {
        Intrinsics.checkParameterIsNotNull(wnce2, "stack");
        wnce wnce3 = wnce._a(wnce2, 0, 1, 0, null, 13, null);
        int n2 = n * wnce2._d();
        kjui kjui2 = this._a(wnce3);
        kjui2._b(kjui2._c() + n2);
    }

    private final kjui _a(final wnce wnce2) {
        kjui kjui2 = this._a.computeIfAbsent(wnce2, new Function<wnce, kjui>(){

            @Override
            public /* synthetic */ Object apply(Object object) {
                return this._a((wnce)object);
            }

            @NotNull
            public final kjui _a(@NotNull wnce wnce22) {
                Intrinsics.checkParameterIsNotNull(wnce22, "it");
                return new kjui(wnce2, 0, 0, 6, null);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "_contents.computeIfAbsen\u2026tackCatalogEntry(stack) }");
        return kjui2;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public final int _a(@NotNull cvzo cvzo2) {
        Intrinsics.checkParameterIsNotNull(cvzo2, "stack");
        wnce wnce2 = wnce._a(new wnce(cvzo2), 0, 1, 0, null, 13, null);
        kjui kjui2 = this._b.get(wnce2);
        int n = kjui2 != null ? kjui2._b() : 0;
        return n * cvzo2._b;
    }

    public final void _a(final @NotNull Set<wnce> set) {
        Intrinsics.checkParameterIsNotNull(set, "preservedStacks");
        this._a.entrySet().removeIf(new Predicate<Map.Entry<wnce, kjui>>(){

            @Override
            public /* synthetic */ boolean test(Object object) {
                return this._a((Map.Entry)object);
            }

            public final boolean _a(@NotNull Map.Entry<wnce, kjui> entry) {
                Intrinsics.checkParameterIsNotNull(entry, "it");
                return set.contains(entry.getKey()) ^ true && entry.getValue()._c() == 0;
            }
        });
        Iterable iterable = set;
        for (Object t : iterable) {
            wnce wnce2 = (wnce)t;
            this._a.putIfAbsent(wnce2, new kjui(wnce2, 0, 0, 6, null));
        }
    }

    public final void _a(@NotNull int[] nArray) {
        Intrinsics.checkParameterIsNotNull(nArray, "prices");
        for (IndexedValue indexedValue : CollectionsKt.withIndex((Iterable)this._b.values())) {
            int n;
            int n2 = indexedValue.component1();
            kjui kjui2 = (kjui)indexedValue.component2();
            int[] nArray2 = nArray;
            kjui kjui3 = kjui2;
            if (n2 >= 0 && n2 <= ArraysKt.getLastIndex(nArray2)) {
                n = nArray2[n2];
            } else {
                int n3 = n2;
                n = 0;
            }
            int n4 = n;
            kjui3._a(n4);
        }
    }

    @Nullable
    public final kjui _a(int n) {
        return (kjui)CollectionsKt.elementAtOrNull((Iterable)this._b.values(), n);
    }

    public srli() {
        this._a = new LinkedHashMap();
        Map map = Collections.unmodifiableMap((Map)this._a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Collections.unmodifiableMap(_contents)");
        this._b = map;
    }

    public srli(@NotNull List<wnce> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "stacks");
        this._a = new LinkedHashMap();
        Map map = Collections.unmodifiableMap((Map)this._a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Collections.unmodifiableMap(_contents)");
        this._b = map;
        for (wnce wnce2 : list2) {
            this._a(wnce2, 0);
        }
    }

    public srli(@NotNull bsyv bsyv2) {
        Intrinsics.checkParameterIsNotNull(bsyv2, "list");
        this._a = new LinkedHashMap();
        Map map = Collections.unmodifiableMap((Map)this._a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Collections.unmodifiableMap(_contents)");
        this._b = map;
        this._a(bsyv2);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/bundle/common/clans/StackCatalog$StackCatalogEntry;", "", "stack", "Lgloomyfolken/bundle/common/utils/ItemStackData;", "price", "", "numItems", "(Lgloomyfolken/bundle/common/utils/ItemStackData;II)V", "getNumItems", "()I", "setNumItems", "(I)V", "getPrice", "setPrice", "getStack", "()Lgloomyfolken/bundle/common/utils/ItemStackData;", "minecraft"})
    public static final class kjui {
        @NotNull
        private final wnce _a;
        private int _b;
        private int _c;

        @NotNull
        public final wnce _a() {
            return this._a;
        }

        public final int _b() {
            return this._b;
        }

        public final void _a(int n) {
            this._b = n;
        }

        public final int _c() {
            return this._c;
        }

        public final void _b(int n) {
            this._c = n;
        }

        public kjui(@NotNull wnce wnce2, int n, int n2) {
            Intrinsics.checkParameterIsNotNull(wnce2, "stack");
            this._a = wnce2;
            this._b = n;
            this._c = n2;
        }

        public /* synthetic */ kjui(wnce wnce2, int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 2) != 0) {
                n = 0;
            }
            if ((n3 & 4) != 0) {
                n2 = 0;
            }
            this(wnce2, n, n2);
        }
    }
}

