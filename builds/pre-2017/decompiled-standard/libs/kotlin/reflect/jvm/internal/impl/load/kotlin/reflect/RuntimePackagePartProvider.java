/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackageParts;
import org.jetbrains.annotations.NotNull;

public final class RuntimePackagePartProvider
implements PackagePartProvider {
    private final ConcurrentHashMap<String, ModuleMapping> module2Mapping;
    private final ClassLoader classLoader;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void registerModule(@NotNull String moduleName) {
        ModuleMapping mapping;
        ModuleMapping moduleMapping;
        ModuleMapping moduleMapping2;
        Intrinsics.checkParameterIsNotNull(moduleName, "moduleName");
        try {
            ModuleMapping moduleMapping3;
            String resourcePath = "META-INF/" + moduleName + "." + ModuleMapping.MAPPING_FILE_EXT;
            InputStream inputStream = this.classLoader.getResourceAsStream(resourcePath);
            if (inputStream != null) {
                ModuleMapping moduleMapping4;
                Closeable closeable = inputStream;
                boolean bl = false;
                try {
                    InputStream stream = (InputStream)closeable;
                    moduleMapping4 = ModuleMapping.Companion.create(ByteStreamsKt.readBytes$default(stream, 0, 1, null), resourcePath);
                }
                catch (Exception exception) {
                    bl = true;
                    try {
                        Closeable closeable2 = closeable;
                        if (closeable2 != null) {
                            closeable2.close();
                        }
                    }
                    catch (Exception exception2) {
                        // empty catch block
                    }
                    throw (Throwable)exception;
                }
                finally {
                    if (!bl) {
                        Closeable closeable3 = closeable;
                        if (closeable3 != null) {
                            closeable3.close();
                        }
                    }
                }
                moduleMapping3 = moduleMapping4;
            } else {
                moduleMapping3 = null;
            }
            moduleMapping2 = moduleMapping3;
        }
        catch (Exception e) {
            moduleMapping2 = null;
        }
        if ((moduleMapping = (mapping = moduleMapping2)) == null) {
            moduleMapping = ModuleMapping.EMPTY;
        }
        this.module2Mapping.putIfAbsent(moduleName, moduleMapping);
    }

    @Override
    @NotNull
    public List<String> findPackageParts(@NotNull String packageFqName) {
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        Iterable iterable = $receiver$iv = (Iterable)this.module2Mapping.values();
        Collection destination$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv = $receiver$iv$iv;
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            PackageParts packageParts;
            Object element$iv$iv = element$iv$iv$iv;
            ModuleMapping it = (ModuleMapping)element$iv$iv;
            if (it.findPackageParts(packageFqName) == null) continue;
            PackageParts it$iv$iv = packageParts;
            destination$iv$iv.add(it$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            PackageParts it = (PackageParts)element$iv$iv;
            Iterable list$iv$iv = it.getParts();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return CollectionsKt.distinct((List)destination$iv$iv);
    }

    @Override
    @NotNull
    public List<String> findMetadataPackageParts(@NotNull String packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        throw (Throwable)new NotImplementedError(null, 1, null);
    }

    public RuntimePackagePartProvider(@NotNull ClassLoader classLoader) {
        Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
        this.classLoader = classLoader;
        this.module2Mapping = new ConcurrentHashMap();
    }
}

