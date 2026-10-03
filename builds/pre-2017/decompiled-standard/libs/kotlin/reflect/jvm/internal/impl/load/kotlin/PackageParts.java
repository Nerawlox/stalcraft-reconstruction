/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PackageParts {
    private final LinkedHashMap<String, String> packageParts;
    @NotNull
    private final Set<String> metadataParts;
    @NotNull
    private final String packageFqName;

    @NotNull
    public final Set<String> getParts() {
        Set<String> set = this.packageParts.keySet();
        Intrinsics.checkExpressionValueIsNotNull(set, "packageParts.keys");
        return set;
    }

    @NotNull
    public final Set<String> getMetadataParts() {
        return this.metadataParts;
    }

    public final void addPart(@NotNull String partShortName, @Nullable String facadeShortName) {
        Intrinsics.checkParameterIsNotNull(partShortName, "partShortName");
        Map map2 = this.packageParts;
        String string = facadeShortName;
        map2.put(partShortName, string);
    }

    public final void removePart(@NotNull String shortName) {
        Intrinsics.checkParameterIsNotNull(shortName, "shortName");
        this.packageParts.remove(shortName);
    }

    public final void addMetadataPart(@NotNull String shortName) {
        Intrinsics.checkParameterIsNotNull(shortName, "shortName");
        Set<String> set = this.metadataParts;
        if (set == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
        }
        TypeIntrinsics.asMutableSet(set).add(shortName);
    }

    /*
     * WARNING - void declaration
     */
    public final void addTo(@NotNull JvmPackageTable.PackageTable.Builder builder) {
        Object object;
        JvmPackageTable.PackageParts.Builder $receiver;
        JvmPackageTable.PackageTable.Builder builder2;
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Object object2 = this.getParts();
        if (!object2.isEmpty()) {
            Object partNames;
            Object element$iv$iv;
            void $receiver$iv$iv;
            object2 = JvmPackageTable.PackageParts.newBuilder();
            builder2 = builder;
            $receiver = (JvmPackageTable.PackageParts.Builder)object2;
            $receiver.setPackageFqName(this.packageFqName);
            Map facadeNameToId = new LinkedHashMap();
            Object $receiver$iv = this.getParts();
            Iterable iterable = $receiver$iv;
            Map.Entry destination$iv$iv = new LinkedHashMap();
            Iterator<Object> iterator2 = $receiver$iv$iv.iterator();
            while (iterator2.hasNext()) {
                Object object3;
                Map.Entry $receiver$iv$iv$iv = destination$iv$iv;
                element$iv$iv = iterator2.next();
                String it = (String)element$iv$iv;
                String key$iv$iv = this.getMultifileFacadeName(it);
                Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    ArrayList answer$iv$iv$iv = new ArrayList();
                    $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object3 = answer$iv$iv$iv;
                } else {
                    object3 = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object3;
                list$iv$iv.add(element$iv$iv);
            }
            Object object4 = destination$iv$iv;
            Comparator comparator = ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
            $receiver$iv = MapsKt.toSortedMap(object4, comparator);
            Iterator<Object> iterator3 = $receiver$iv.entrySet().iterator();
            while (iterator3.hasNext()) {
                Map.Entry object5;
                destination$iv$iv = object5 = iterator3.next();
                String facadeName = (String)destination$iv$iv.getKey();
                destination$iv$iv = object5;
                partNames = (List)destination$iv$iv.getValue();
                for (String partName : CollectionsKt.sorted((Iterable)partNames)) {
                    Object object6;
                    void $receiver$iv2;
                    $receiver.addClassName(partName);
                    if (facadeName == null) continue;
                    element$iv$iv = facadeNameToId;
                    int n = 1;
                    object4 = $receiver;
                    Object value$iv = $receiver$iv2.get(facadeName);
                    if (value$iv == null) {
                        Integer answer$iv = facadeNameToId.size();
                        $receiver$iv2.put(facadeName, answer$iv);
                        object6 = answer$iv;
                    } else {
                        object6 = value$iv;
                    }
                    Object v = object6;
                    ((JvmPackageTable.PackageParts.Builder)object4).addMultifileFacadeId(n + ((Number)v).intValue());
                }
            }
            partNames = $receiver$iv = (Iterable)CollectionsKt.zip((Iterable)facadeNameToId.values(), facadeNameToId.keySet());
            Comparator comparator2 = new Comparator<Pair<? extends Integer, ? extends String>>(){

                /*
                 * Ignored method signature, as it can't be verified against descriptor
                 */
                public int compare(Object a, Object b) {
                    Object receiver = a;
                    Comparable comparable = (Comparable)((Pair)receiver).getFirst();
                    receiver = b;
                    Comparable comparable2 = comparable;
                    A a2 = ((Pair)receiver).getFirst();
                    return ComparisonsKt.compareValues(comparable2, (Comparable)a2);
                }
            };
            for (Pair pair : CollectionsKt.sortedWith(partNames, comparator2)) {
                boolean bl;
                int facadeId = ((Number)pair.component1()).intValue();
                String facadeName = (String)pair.component2();
                boolean bl2 = bl = facadeId == $receiver.getMultifileFacadeNameCount();
                if (_Assertions.ENABLED && !bl) {
                    String string = "Multifile facades are loaded incorrectly: " + facadeNameToId;
                    throw (Throwable)((Object)new AssertionError((Object)string));
                }
                $receiver.addMultifileFacadeName(facadeName);
            }
            object = object2;
            builder2.addPackageParts((JvmPackageTable.PackageParts.Builder)object);
        }
        if (!(object2 = (Collection)this.metadataParts).isEmpty()) {
            object2 = JvmPackageTable.PackageParts.newBuilder();
            builder2 = builder;
            $receiver = (JvmPackageTable.PackageParts.Builder)object2;
            $receiver.setPackageFqName(this.packageFqName);
            $receiver.addAllClassName(CollectionsKt.sorted((Iterable)this.metadataParts));
            object = object2;
            builder2.addMetadataParts((JvmPackageTable.PackageParts.Builder)object);
        }
    }

    @Nullable
    public final String getMultifileFacadeName(@NotNull String partShortName) {
        Intrinsics.checkParameterIsNotNull(partShortName, "partShortName");
        return this.packageParts.get(partShortName);
    }

    /*
     * WARNING - void declaration
     */
    public final void plusAssign(@NotNull PackageParts other) {
        void $receiver$iv;
        Object object;
        Intrinsics.checkParameterIsNotNull(other, "other");
        Map map2 = other.packageParts;
        Object object2 = map2.entrySet().iterator();
        while (object2.hasNext()) {
            Object object3 = object = object2.next();
            String partShortName = (String)object3.getKey();
            object3 = object;
            String facadeShortName = (String)object3.getValue();
            this.addPart(partShortName, facadeShortName);
        }
        object = other.metadataParts;
        object2 = this;
        for (Object element$iv : $receiver$iv) {
            String p1 = (String)element$iv;
            ((PackageParts)object2).addMetadataPart(p1);
        }
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof PackageParts && Intrinsics.areEqual(((PackageParts)other).packageFqName, this.packageFqName) && Intrinsics.areEqual(((PackageParts)other).packageParts, this.packageParts) && Intrinsics.areEqual(((PackageParts)other).metadataParts, this.metadataParts);
    }

    public int hashCode() {
        return (this.packageFqName.hashCode() * 31 + this.packageParts.hashCode()) * 31 + ((Object)this.metadataParts).hashCode();
    }

    @NotNull
    public String toString() {
        return SetsKt.plus(this.getParts(), (Iterable)this.metadataParts).toString();
    }

    @NotNull
    public final String getPackageFqName() {
        return this.packageFqName;
    }

    public PackageParts(@NotNull String packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        this.packageFqName = packageFqName;
        PackageParts packageParts = this;
        Cloneable cloneable2 = new LinkedHashMap();
        packageParts.packageParts = cloneable2;
        packageParts = this;
        cloneable2 = new LinkedHashSet();
        packageParts.metadataParts = (Set)((Object)cloneable2);
    }
}

