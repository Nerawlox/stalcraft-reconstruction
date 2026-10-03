/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawBound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaTypeAttributes {
    @NotNull
    public TypeUsage getHowThisTypeIsUsed();

    @NotNull
    public TypeUsage getHowThisTypeIsUsedAccordingToAnnotations();

    public boolean isMarkedNotNull();

    @NotNull
    public JavaTypeFlexibility getFlexibility();

    public boolean getAllowFlexible();

    @NotNull
    public Annotations getTypeAnnotations();

    public boolean isForAnnotationParameter();

    @Nullable
    public TypeParameterDescriptor getUpperBoundOfTypeParameter();

    @NotNull
    public RawBound getRawBound();

    public static final class DefaultImpls {
        @NotNull
        public static JavaTypeFlexibility getFlexibility(JavaTypeAttributes $this) {
            return JavaTypeFlexibility.INFLEXIBLE;
        }

        public static boolean getAllowFlexible(JavaTypeAttributes $this) {
            return true;
        }

        public static boolean isForAnnotationParameter(JavaTypeAttributes $this) {
            return false;
        }

        @Nullable
        public static TypeParameterDescriptor getUpperBoundOfTypeParameter(JavaTypeAttributes $this) {
            return null;
        }

        @NotNull
        public static RawBound getRawBound(JavaTypeAttributes $this) {
            return RawBound.NOT_RAW;
        }
    }
}

