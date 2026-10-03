/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class ExcludedTypeAnnotations {
    @NotNull
    private static final Set<FqName> annotationsForNullabilityAndMutability;
    @NotNull
    private static final Set<FqName> internalAnnotationsForResolve;
    public static final ExcludedTypeAnnotations INSTANCE;

    @NotNull
    public final Set<FqName> getAnnotationsForNullabilityAndMutability() {
        return annotationsForNullabilityAndMutability;
    }

    @NotNull
    public final Set<FqName> getInternalAnnotationsForResolve() {
        return internalAnnotationsForResolve;
    }

    private ExcludedTypeAnnotations() {
        INSTANCE = this;
        annotationsForNullabilityAndMutability = SetsKt.setOf(new FqName[]{new FqName("org.jetbrains.annotations.ReadOnly"), new FqName("org.jetbrains.annotations.Mutable"), new FqName("org.jetbrains.annotations.NotNull"), new FqName("org.jetbrains.annotations.Nullable"), new FqName("android.support.annotation.Nullable"), new FqName("android.support.annotation.NonNull"), new FqName("com.android.annotations.Nullable"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("javax.annotation.Nonnull"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("lombok.NonNull")});
        internalAnnotationsForResolve = SetsKt.setOf(new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});
    }

    static {
        new ExcludedTypeAnnotations();
    }
}

