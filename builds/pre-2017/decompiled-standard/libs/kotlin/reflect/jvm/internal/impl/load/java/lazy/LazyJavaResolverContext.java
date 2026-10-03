/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaResolverContext {
    @NotNull
    private final JavaTypeResolver typeResolver;
    @NotNull
    private final JavaResolverComponents components;
    @NotNull
    private final TypeParameterResolver typeParameterResolver;

    @NotNull
    public final JavaTypeResolver getTypeResolver() {
        return this.typeResolver;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.components.getModule();
    }

    @NotNull
    public final JavaResolverComponents getComponents() {
        return this.components;
    }

    @NotNull
    public final TypeParameterResolver getTypeParameterResolver() {
        return this.typeParameterResolver;
    }

    public LazyJavaResolverContext(@NotNull JavaResolverComponents components, @NotNull TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkParameterIsNotNull(components, "components");
        Intrinsics.checkParameterIsNotNull(typeParameterResolver, "typeParameterResolver");
        this.components = components;
        this.typeParameterResolver = typeParameterResolver;
        this.typeResolver = new JavaTypeResolver(this, this.typeParameterResolver);
    }
}

