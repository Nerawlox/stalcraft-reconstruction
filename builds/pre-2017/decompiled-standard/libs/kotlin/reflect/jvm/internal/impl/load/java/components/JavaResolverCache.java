/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaResolverCache {
    public static final JavaResolverCache EMPTY = new JavaResolverCache(){

        @Override
        @Nullable
        public ClassDescriptor getClassResolvedFromSource(@NotNull FqName fqName2) {
            if (fqName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "getClassResolvedFromSource"));
            }
            return null;
        }

        @Override
        public void recordMethod(@NotNull JavaMethod method, @NotNull SimpleFunctionDescriptor descriptor2) {
            if (method == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "method", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordMethod"));
            }
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordMethod"));
            }
        }

        @Override
        public void recordConstructor(@NotNull JavaElement element, @NotNull ConstructorDescriptor descriptor2) {
            if (element == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "element", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordConstructor"));
            }
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordConstructor"));
            }
        }

        @Override
        public void recordField(@NotNull JavaField field, @NotNull PropertyDescriptor descriptor2) {
            if (field == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "field", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordField"));
            }
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordField"));
            }
        }

        @Override
        public void recordClass(@NotNull JavaClass javaClass, @NotNull ClassDescriptor descriptor2) {
            if (javaClass == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClass", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordClass"));
            }
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordClass"));
            }
        }
    };

    @Nullable
    public ClassDescriptor getClassResolvedFromSource(@NotNull FqName var1);

    public void recordMethod(@NotNull JavaMethod var1, @NotNull SimpleFunctionDescriptor var2);

    public void recordConstructor(@NotNull JavaElement var1, @NotNull ConstructorDescriptor var2);

    public void recordField(@NotNull JavaField var1, @NotNull PropertyDescriptor var2);

    public void recordClass(@NotNull JavaClass var1, @NotNull ClassDescriptor var2);
}

