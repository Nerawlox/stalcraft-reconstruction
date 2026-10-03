/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationWithTarget {
    @NotNull
    private final AnnotationDescriptor annotation;
    @Nullable
    private final AnnotationUseSiteTarget target;

    @NotNull
    public final AnnotationDescriptor getAnnotation() {
        return this.annotation;
    }

    @Nullable
    public final AnnotationUseSiteTarget getTarget() {
        return this.target;
    }

    public AnnotationWithTarget(@NotNull AnnotationDescriptor annotation, @Nullable AnnotationUseSiteTarget target) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        this.annotation = annotation;
        this.target = target;
    }

    @NotNull
    public final AnnotationDescriptor component1() {
        return this.annotation;
    }

    @Nullable
    public final AnnotationUseSiteTarget component2() {
        return this.target;
    }

    @NotNull
    public final AnnotationWithTarget copy(@NotNull AnnotationDescriptor annotation, @Nullable AnnotationUseSiteTarget target) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        return new AnnotationWithTarget(annotation, target);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AnnotationWithTarget copy$default(AnnotationWithTarget annotationWithTarget, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int n, Object object) {
        if ((n & 1) != 0) {
            annotationDescriptor = annotationWithTarget.annotation;
        }
        if ((n & 2) != 0) {
            annotationUseSiteTarget = annotationWithTarget.target;
        }
        return annotationWithTarget.copy(annotationDescriptor, annotationUseSiteTarget);
    }

    public String toString() {
        return "AnnotationWithTarget(annotation=" + this.annotation + ", target=" + (Object)((Object)this.target) + ")";
    }

    public int hashCode() {
        AnnotationDescriptor annotationDescriptor = this.annotation;
        AnnotationUseSiteTarget annotationUseSiteTarget = this.target;
        return (annotationDescriptor != null ? annotationDescriptor.hashCode() : 0) * 31 + (annotationUseSiteTarget != null ? ((Object)((Object)annotationUseSiteTarget)).hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof AnnotationWithTarget)) break block3;
                AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget)object;
                if (!Intrinsics.areEqual(this.annotation, annotationWithTarget.annotation) || !Intrinsics.areEqual((Object)this.target, (Object)annotationWithTarget.target)) break block3;
            }
            return true;
        }
        return false;
    }
}

