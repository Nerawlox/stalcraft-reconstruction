/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.platform;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public interface PlatformToKotlinClassMap {
    public static final PlatformToKotlinClassMap EMPTY = new PlatformToKotlinClassMap(){

        @Override
        @NotNull
        public Collection<ClassDescriptor> mapPlatformClass(@NotNull ClassDescriptor classDescriptor) {
            if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/platform/PlatformToKotlinClassMap$1", "mapPlatformClass"));
            }
            List<ClassDescriptor> list = Collections.emptyList();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/PlatformToKotlinClassMap$1", "mapPlatformClass"));
            }
            return list;
        }
    };

    @NotNull
    public Collection<ClassDescriptor> mapPlatformClass(@NotNull ClassDescriptor var1);
}

