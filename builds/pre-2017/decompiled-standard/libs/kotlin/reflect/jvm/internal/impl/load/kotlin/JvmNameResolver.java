/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmNameResolver$WhenMappings;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmNameResolver
implements NameResolver {
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final JvmProtoBuf.StringTableTypes types;
    private final String[] strings;
    @NotNull
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;
    public static final Companion Companion;

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public String getString(int index) {
        JvmProtoBuf.StringTableTypes.Record.Operation operation;
        Integer end;
        Integer begin;
        Object object;
        Object object2;
        String string;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(index);
        String string2 = record.hasString() ? record.getString() : (string = record.hasPredefinedIndex() && CollectionsKt.getIndices((Collection)Companion.getPREDEFINED_STRINGS()).contains(record.getPredefinedIndex()) ? Companion.getPREDEFINED_STRINGS().get(record.getPredefinedIndex()) : this.strings[index]);
        if (record.getSubstringIndexCount() >= 2) {
            object2 = record.getSubstringIndexList();
            List<Integer> list = object2;
            object = list.get(0);
            list = object2;
            Integer n = list.get(1);
            object2 = null;
            Integer n2 = begin;
            Intrinsics.checkExpressionValueIsNotNull(n2, "begin");
            if (Intrinsics.compare(0, n2) <= 0) {
                int n3 = begin;
                Integer n4 = end;
                Intrinsics.checkExpressionValueIsNotNull(n4, "end");
                if (Intrinsics.compare(n3, n4) <= 0 && Intrinsics.compare(end, string.length()) <= 0) {
                    object2 = string;
                    Integer n5 = begin;
                    Intrinsics.checkExpressionValueIsNotNull(n5, "begin");
                    int n6 = n5;
                    Integer n7 = end;
                    Intrinsics.checkExpressionValueIsNotNull(n7, "end");
                    int n8 = n7;
                    Object object3 = object2;
                    if (object3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string3 = ((String)object3).substring(n6, n8);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    string = string3;
                }
            }
        }
        if (record.getReplaceCharCount() >= 2) {
            void to;
            void from;
            object2 = record.getReplaceCharList();
            List<Integer> list = object2;
            begin = list.get(0);
            list = object2;
            end = list.get(1);
            object2 = null;
            string = StringsKt.replace$default(string, (char)from.intValue(), (char)to.intValue(), false, 4, null);
        }
        if ((operation = record.getOperation()) == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        switch (JvmNameResolver$WhenMappings.$EnumSwitchMapping$0[operation.ordinal()]) {
            case 1: {
                break;
            }
            case 2: {
                string = StringsKt.replace$default(string, '$', '.', false, 4, null);
                break;
            }
            case 3: {
                if (string.length() >= 2) {
                    object = string;
                    int n = 1;
                    int n9 = string.length() - 1;
                    Object object4 = object;
                    if (object4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string4 = ((String)object4).substring(n, n9);
                    Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    string = string4;
                }
                string = StringsKt.replace$default(string, '$', '.', false, 4, null);
            }
        }
        String string5 = string;
        Intrinsics.checkExpressionValueIsNotNull(string5, "string");
        return string5;
    }

    @Override
    @NotNull
    public Name getName(int index) {
        return Name.guessByFirstCharacter(this.getString(index));
    }

    @Override
    @NotNull
    public ClassId getClassId(int index) {
        FqName fqName2;
        String string;
        FqName fqName3;
        FqName fqName4;
        FqName fqName5;
        String string2 = this.getString(index);
        int lastSlash = StringsKt.lastIndexOf$default((CharSequence)string2, '/', 0, false, 6, null);
        if (lastSlash < 0) {
            fqName5 = FqName.ROOT;
        } else {
            FqName fqName6;
            String string3 = string2;
            int n = 0;
            fqName4 = fqName6;
            fqName3 = fqName6;
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string5 = string4.substring(n, lastSlash);
            Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            string = string5;
            fqName5 = fqName3;
            fqName4(StringsKt.replace$default(string, '/', '.', false, 4, null));
        }
        FqName packageName = fqName5;
        String string6 = string2;
        int n = lastSlash + 1;
        fqName4 = fqName2;
        fqName3 = fqName2;
        String string7 = string6;
        if (string7 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string8 = string7.substring(n);
        Intrinsics.checkExpressionValueIsNotNull(string8, "(this as java.lang.String).substring(startIndex)");
        string = string8;
        fqName4(string);
        FqName className = fqName3;
        return new ClassId(packageName, className, this.localNameIndices.contains(index));
    }

    public JvmNameResolver(@NotNull JvmProtoBuf.StringTableTypes types, @NotNull String[] strings) {
        Intrinsics.checkParameterIsNotNull(types, "types");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        this.types = types;
        this.strings = strings;
        ArrayList arrayList = this.types.getLocalNameList();
        JvmNameResolver jvmNameResolver = this;
        ArrayList $receiver = arrayList;
        Collection<Object> collection = $receiver.isEmpty() ? SetsKt.emptySet() : CollectionsKt.toSet($receiver);
        jvmNameResolver.localNameIndices = collection;
        arrayList = new ArrayList<Integer>();
        jvmNameResolver = this;
        $receiver = arrayList;
        List<JvmProtoBuf.StringTableTypes.Record> records = this.types.getRecordList();
        $receiver.ensureCapacity(records.size());
        Iterator<JvmProtoBuf.StringTableTypes.Record> iterator2 = records.iterator();
        block0: while (iterator2.hasNext()) {
            int n = 0;
            JvmProtoBuf.StringTableTypes.Record record = iterator2.next();
            int n2 = record.getRange();
            int n3 = n2 - 1;
            if (n > n3) continue;
            while (true) {
                int it = ++n;
                $receiver.add(record);
                if (n == n3) continue block0;
            }
        }
        $receiver.trimToSize();
        collection = arrayList;
        jvmNameResolver.records = (List)collection;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_3;
        void $receiver$iv$iv;
        Companion = new Companion(null);
        PREDEFINED_STRINGS = CollectionsKt.listOf(new String[]{"kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator"});
        Iterable $receiver$iv = CollectionsKt.withIndex((Iterable)Companion.getPREDEFINED_STRINGS());
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
        Iterable iterable = $receiver$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $receiver$iv$iv) {
            IndexedValue it;
            IndexedValue indexedValue = (IndexedValue)element$iv$iv;
            Map map2 = destination$iv$iv;
            String string = (String)it.getValue();
            it = (IndexedValue)element$iv$iv;
            Integer n = it.getIndex();
            map2.put(string, n);
        }
        PREDEFINED_STRINGS_MAP = var3_3;
    }

    public static final class Companion {
        @NotNull
        public final List<String> getPREDEFINED_STRINGS() {
            return PREDEFINED_STRINGS;
        }

        private final Map<String, Integer> getPREDEFINED_STRINGS_MAP() {
            return PREDEFINED_STRINGS_MAP;
        }

        @Nullable
        public final Integer getPredefinedStringIndex(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "string");
            return this.getPREDEFINED_STRINGS_MAP().get(string);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

