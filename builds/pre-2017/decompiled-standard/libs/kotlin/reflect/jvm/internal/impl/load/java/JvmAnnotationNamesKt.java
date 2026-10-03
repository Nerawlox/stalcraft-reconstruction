/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class JvmAnnotationNamesKt {
    @NotNull
    private static final List<FqName> NULLABLE_ANNOTATIONS;
    @NotNull
    private static final FqName JAVAX_NONNULL_ANNOTATION;
    @NotNull
    private static final List<FqName> NOT_NULL_ANNOTATIONS;
    @NotNull
    private static final List<FqName> READ_ONLY_ANNOTATIONS;
    @NotNull
    private static final List<FqName> MUTABLE_ANNOTATIONS;
    @NotNull
    private static final Set<FqName> ANNOTATIONS_COPIED_TO_TYPES;

    @NotNull
    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    @NotNull
    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return JAVAX_NONNULL_ANNOTATION;
    }

    @NotNull
    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    @NotNull
    public static final List<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    @NotNull
    public static final List<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getANNOTATIONS_COPIED_TO_TYPES() {
        return ANNOTATIONS_COPIED_TO_TYPES;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var2_2;
        void $receiver$iv$iv;
        NULLABLE_ANNOTATIONS = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("android.support.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull")});
        JAVAX_NONNULL_ANNOTATION = new FqName("javax.annotation.Nonnull");
        NOT_NULL_ANNOTATIONS = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("android.support.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull")});
        READ_ONLY_ANNOTATIONS = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION);
        MUTABLE_ANNOTATIONS = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION);
        Iterable $receiver$iv = CollectionsKt.listOf(new List[]{NULLABLE_ANNOTATIONS, NOT_NULL_ANNOTATIONS, READ_ONLY_ANNOTATIONS, MUTABLE_ANNOTATIONS, CollectionsKt.listOf(JAVAX_NONNULL_ANNOTATION)});
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            List it = (List)element$iv$iv;
            Iterable list$iv$iv = it;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        ANNOTATIONS_COPIED_TO_TYPES = CollectionsKt.toSet((List)var2_2);
    }
}

