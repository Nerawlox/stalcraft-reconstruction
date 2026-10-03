/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Annotations
extends Iterable<AnnotationDescriptor>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);

    public boolean isEmpty();

    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName var1);

    public boolean hasAnnotation(@NotNull FqName var1);

    @Nullable
    public AnnotationDescriptor findExternalAnnotation(@NotNull FqName var1);

    @NotNull
    public List<AnnotationWithTarget> getUseSiteTargetedAnnotations();

    @NotNull
    public List<AnnotationWithTarget> getAllAnnotations();

    public static final class DefaultImpls {
        public static boolean hasAnnotation(@NotNull Annotations $this, FqName fqName2) {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            return $this.findAnnotation(fqName2) != null;
        }
    }

    public static final class Companion {
        @NotNull
        private static final Annotations EMPTY;

        @NotNull
        public final Annotations getEMPTY() {
            return EMPTY;
        }

        @Nullable
        public final AnnotationWithTarget findAnyAnnotation(@NotNull Annotations annotations2, @NotNull FqName fqName2) {
            Object v0;
            block1: {
                Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
                Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                Iterable $receiver$iv = annotations2.getAllAnnotations();
                for (Object element$iv : $receiver$iv) {
                    AnnotationWithTarget it = (AnnotationWithTarget)element$iv;
                    if (!AnnotationsKt.checkAnnotationName(it.getAnnotation(), fqName2)) continue;
                    v0 = element$iv;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }

        @Nullable
        public final AnnotationDescriptor findUseSiteTargetedAnnotation(@NotNull Annotations annotations2, @NotNull AnnotationUseSiteTarget target, @NotNull FqName fqName2) {
            Object v0;
            block1: {
                Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
                Intrinsics.checkParameterIsNotNull((Object)target, "target");
                Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                Iterable $receiver$iv = this.getUseSiteTargetedAnnotations(annotations2, target);
                for (Object element$iv : $receiver$iv) {
                    AnnotationDescriptor it = (AnnotationDescriptor)element$iv;
                    if (!AnnotationsKt.checkAnnotationName(it, fqName2)) continue;
                    v0 = element$iv;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }

        /*
         * WARNING - void declaration
         */
        private final List<AnnotationDescriptor> getUseSiteTargetedAnnotations(Annotations annotations2, AnnotationUseSiteTarget target) {
            void $receiver$iv;
            ArrayList<AnnotationDescriptor> initial$iv;
            Iterable iterable = annotations2.getUseSiteTargetedAnnotations();
            ArrayList<AnnotationDescriptor> accumulator$iv = initial$iv = new ArrayList<AnnotationDescriptor>();
            for (Object element$iv : $receiver$iv) {
                void targeted;
                AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget)element$iv;
                ArrayList<AnnotationDescriptor> list = accumulator$iv;
                if (Intrinsics.areEqual((Object)target, (Object)targeted.getTarget())) {
                    list.add(targeted.getAnnotation());
                }
                accumulator$iv = list;
            }
            return accumulator$iv;
        }

        private Companion() {
            EMPTY = new Annotations(){

                public boolean isEmpty() {
                    return true;
                }

                @Nullable
                public Void findAnnotation(@NotNull FqName fqName2) {
                    Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                    return null;
                }

                @Nullable
                public Void findExternalAnnotation(@NotNull FqName fqName2) {
                    Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                    return null;
                }

                @NotNull
                public List<AnnotationWithTarget> getUseSiteTargetedAnnotations() {
                    return CollectionsKt.emptyList();
                }

                @NotNull
                public List<AnnotationWithTarget> getAllAnnotations() {
                    return CollectionsKt.emptyList();
                }

                @NotNull
                public Iterator<AnnotationDescriptor> iterator() {
                    return CollectionsKt.emptyList().iterator();
                }

                @NotNull
                public String toString() {
                    return "EMPTY";
                }

                public boolean hasAnnotation(@NotNull FqName fqName2) {
                    Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                    return DefaultImpls.hasAnnotation(this, fqName2);
                }
            };
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

