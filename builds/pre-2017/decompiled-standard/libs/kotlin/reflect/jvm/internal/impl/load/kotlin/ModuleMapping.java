/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackageParts;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmPackageTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleMapping {
    @NotNull
    private final Map<String, PackageParts> packageFqName2Parts;
    private final String debugName;
    @JvmField
    @NotNull
    public static final String MAPPING_FILE_EXT = "kotlin_module";
    @JvmField
    @NotNull
    public static final ModuleMapping EMPTY;
    public static final Companion Companion;

    @Nullable
    public final PackageParts findPackageParts(@NotNull String packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return this.packageFqName2Parts.get(packageFqName);
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }

    @NotNull
    public final Map<String, PackageParts> getPackageFqName2Parts() {
        return this.packageFqName2Parts;
    }

    private ModuleMapping(Map<String, PackageParts> packageFqName2Parts, String debugName) {
        this.packageFqName2Parts = packageFqName2Parts;
        this.debugName = debugName;
    }

    static {
        Companion = new Companion(null);
        MAPPING_FILE_EXT = MAPPING_FILE_EXT;
        EMPTY = new ModuleMapping(MapsKt.<String, PackageParts>emptyMap(), "EMPTY");
    }

    public /* synthetic */ ModuleMapping(@NotNull Map packageFqName2Parts, @NotNull String debugName, DefaultConstructorMarker $constructor_marker) {
        this(packageFqName2Parts, debugName);
    }

    public static final class Companion {
        /*
         * WARNING - void declaration
         */
        @NotNull
        public final ModuleMapping create(@Nullable byte[] bytes, @Nullable String debugName) {
            Object object;
            void size$iv;
            JvmMetadataVersion jvmMetadataVersion;
            if (bytes == null) {
                return EMPTY;
            }
            DataInputStream stream = new DataInputStream(new ByteArrayInputStream(bytes));
            int n = stream.readInt();
            Object object2 = jvmMetadataVersion;
            Object object3 = jvmMetadataVersion;
            int[] result$iv = new int[size$iv];
            boolean bl = false;
            void var9_12 = size$iv - true;
            if (bl <= var9_12) {
                void i$iv;
                do {
                    int n2;
                    void var10_14 = ++i$iv;
                    void var11_17 = i$iv;
                    object = result$iv;
                    object[var11_17] = n2 = stream.readInt();
                } while (i$iv != var9_12);
            }
            object = result$iv;
            ((JvmMetadataVersion)object2)(Arrays.copyOf(object, ((int[])object).length));
            JvmMetadataVersion version = object3;
            if (version.isCompatible()) {
                PackageParts answer$iv;
                Object value$iv;
                Object $receiver$iv;
                Object key$iv;
                JvmPackageTable.PackageTable packageTable = JvmPackageTable.PackageTable.parseFrom(stream);
                if (packageTable == null) {
                    return EMPTY;
                }
                JvmPackageTable.PackageTable table = packageTable;
                LinkedHashMap result2 = new LinkedHashMap();
                for (JvmPackageTable.PackageParts proto : table.getPackagePartsList()) {
                    Object object4;
                    Map map2 = result2;
                    String string = proto.getPackageFqName();
                    Intrinsics.checkExpressionValueIsNotNull(string, "proto.packageFqName");
                    key$iv = string;
                    value$iv = $receiver$iv.get(key$iv);
                    if (value$iv == null) {
                        String string2 = proto.getPackageFqName();
                        Intrinsics.checkExpressionValueIsNotNull(string2, "proto.packageFqName");
                        answer$iv = new PackageParts(string2);
                        $receiver$iv.put(key$iv, answer$iv);
                        object4 = answer$iv;
                    } else {
                        object4 = value$iv;
                    }
                    PackageParts packageParts = (PackageParts)object4;
                    key$iv = CollectionsKt.withIndex(proto.getClassNameList()).iterator();
                    while (key$iv.hasNext()) {
                        String string3;
                        $receiver$iv = (IndexedValue)key$iv.next();
                        int index = ((IndexedValue)$receiver$iv).component1();
                        String partShortName = (String)((IndexedValue)$receiver$iv).component2();
                        Integer n3 = CollectionsKt.getOrNull(proto.getMultifileFacadeIdList(), index);
                        Integer multifileFacadeId = n3 != null ? Integer.valueOf(n3 - 1) : null;
                        Object object5 = packageParts;
                        String string4 = partShortName;
                        Object object6 = string4;
                        Intrinsics.checkExpressionValueIsNotNull(string4, "partShortName");
                        if (multifileFacadeId != null) {
                            Integer n4;
                            ProtocolStringList protocolStringList = proto.getMultifileFacadeNameList();
                            object2 = object6;
                            object3 = object5;
                            int p1 = ((Number)n4).intValue();
                            object = (String)CollectionsKt.getOrNull(protocolStringList, p1);
                            object5 = object3;
                            object6 = object2;
                            string3 = (String)object;
                        } else {
                            string3 = null;
                        }
                        ((PackageParts)object5).addPart((String)object6, string3);
                    }
                }
                for (JvmPackageTable.PackageParts proto : table.getMetadataPartsList()) {
                    Object object7;
                    $receiver$iv = result2;
                    Intrinsics.checkExpressionValueIsNotNull(proto.getPackageFqName(), "proto.packageFqName");
                    value$iv = $receiver$iv.get(key$iv);
                    if (value$iv == null) {
                        String string = proto.getPackageFqName();
                        Intrinsics.checkExpressionValueIsNotNull(string, "proto.packageFqName");
                        answer$iv = new PackageParts(string);
                        $receiver$iv.put(key$iv, answer$iv);
                        object7 = answer$iv;
                    } else {
                        object7 = value$iv;
                    }
                    PackageParts packageParts = (PackageParts)object7;
                    $receiver$iv = proto.getClassNameList();
                    Iterator iterator2 = $receiver$iv.iterator();
                    while (iterator2.hasNext()) {
                        Object element$iv = iterator2.next();
                        String p1 = (String)element$iv;
                        packageParts.addMetadataPart(p1);
                    }
                }
                Map map3 = result2;
                String string = debugName;
                if (string == null) {
                    string = "<unknown>";
                }
                return new ModuleMapping(map3, string, null);
            }
            return EMPTY;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

