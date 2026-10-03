/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleClassResolverImpl
implements ModuleClassResolver {
    private final Function1<JavaClass, JavaDescriptorResolver> descriptorResolverByJavaClass;

    @Override
    @Nullable
    public ClassDescriptor resolveClass(@NotNull JavaClass javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "javaClass");
        return this.descriptorResolverByJavaClass.invoke(javaClass).resolveClass(javaClass);
    }

    public ModuleClassResolverImpl(@NotNull Function1<? super JavaClass, JavaDescriptorResolver> descriptorResolverByJavaClass) {
        Intrinsics.checkParameterIsNotNull(descriptorResolverByJavaClass, "descriptorResolverByJavaClass");
        this.descriptorResolverByJavaClass = descriptorResolverByJavaClass;
    }
}

