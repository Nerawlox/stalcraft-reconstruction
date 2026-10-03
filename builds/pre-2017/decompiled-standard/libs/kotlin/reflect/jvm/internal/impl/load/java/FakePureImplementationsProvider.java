/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FakePureImplementationsProvider {
    private static final HashMap<FqName, FqName> pureImplementations;
    public static final FakePureImplementationsProvider INSTANCE;

    @Nullable
    public final FqName getPurelyImplementedInterface(@NotNull FqName classFqName) {
        Intrinsics.checkParameterIsNotNull(classFqName, "classFqName");
        return pureImplementations.get(classFqName);
    }

    /*
     * WARNING - void declaration
     */
    private final void implementedWith(@NotNull FqName $receiver, List<FqName> implementations) {
        void $receiver$iv;
        Iterable iterable = implementations;
        Map destination$iv = pureImplementations;
        for (Object element$iv : $receiver$iv) {
            Map map2 = destination$iv;
            FqName it = (FqName)element$iv;
            Pair<FqName, FqName> pair = TuplesKt.to(it, $receiver);
            map2.put(pair.getFirst(), pair.getSecond());
        }
    }

    /*
     * WARNING - void declaration
     */
    private final List<FqName> fqNameListOf(String ... names) {
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = (Object[])names;
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void p1;
            void item$iv$iv = $receiver$iv$iv[i];
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            FqName fqName2 = new FqName((String)p1);
            collection.add(fqName2);
        }
        return (List)destination$iv$iv;
    }

    private FakePureImplementationsProvider() {
        INSTANCE = this;
        pureImplementations = new HashMap();
        this.implementedWith(KotlinBuiltIns.FQ_NAMES.mutableList, this.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        this.implementedWith(KotlinBuiltIns.FQ_NAMES.mutableSet, this.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        this.implementedWith(KotlinBuiltIns.FQ_NAMES.mutableMap, this.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        this.implementedWith(new FqName("java.util.function.Function"), this.fqNameListOf("java.util.function.UnaryOperator"));
        this.implementedWith(new FqName("java.util.function.BiFunction"), this.fqNameListOf("java.util.function.BinaryOperator"));
    }

    static {
        new FakePureImplementationsProvider();
    }
}

