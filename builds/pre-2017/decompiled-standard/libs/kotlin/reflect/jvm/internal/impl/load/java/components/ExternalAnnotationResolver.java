/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ExternalAnnotationResolver {
    public static final ExternalAnnotationResolver EMPTY = new ExternalAnnotationResolver(){

        @Override
        @Nullable
        public JavaAnnotation findExternalAnnotation(@NotNull JavaAnnotationOwner owner, @NotNull FqName fqName2) {
            if (owner == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "owner", "kotlin/reflect/jvm/internal/impl/load/java/components/ExternalAnnotationResolver$1", "findExternalAnnotation"));
            }
            if (fqName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/load/java/components/ExternalAnnotationResolver$1", "findExternalAnnotation"));
            }
            return null;
        }
    };

    @Nullable
    public JavaAnnotation findExternalAnnotation(@NotNull JavaAnnotationOwner var1, @NotNull FqName var2);
}

