/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.WeakClassLoaderBox;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"})
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = new ConcurrentHashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final RuntimeModuleData getOrCreateModule(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader($receiver);
        WeakClassLoaderBox key = new WeakClassLoaderBox(classLoader);
        WeakReference cached = (WeakReference)moduleByClassLoader.get(key);
        if (cached != null) {
            RuntimeModuleData runtimeModuleData = (RuntimeModuleData)cached.get();
            if (runtimeModuleData != null) {
                RuntimeModuleData runtimeModuleData2;
                RuntimeModuleData it;
                RuntimeModuleData runtimeModuleData3 = it = (runtimeModuleData2 = runtimeModuleData);
                Intrinsics.checkExpressionValueIsNotNull(runtimeModuleData3, "it");
                return runtimeModuleData3;
            }
            moduleByClassLoader.remove(key, cached);
        }
        RuntimeModuleData module = RuntimeModuleData.Companion.create(classLoader);
        try {
            while (true) {
                WeakReference<RuntimeModuleData> ref;
                if ((ref = moduleByClassLoader.putIfAbsent(key, new WeakReference<RuntimeModuleData>(module))) == null) {
                    RuntimeModuleData $i$a$1$let = module;
                    return $i$a$1$let;
                }
                RuntimeModuleData result2 = (RuntimeModuleData)ref.get();
                if (result2 != null) {
                    RuntimeModuleData runtimeModuleData = result2;
                    return runtimeModuleData;
                }
                moduleByClassLoader.remove(key, ref);
            }
        }
        finally {
            key.setTemporaryStrongRef(null);
        }
    }
}

