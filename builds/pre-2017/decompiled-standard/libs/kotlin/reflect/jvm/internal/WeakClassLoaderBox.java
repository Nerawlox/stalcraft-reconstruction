/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0017"}, d2={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"})
final class WeakClassLoaderBox {
    @NotNull
    private final WeakReference<ClassLoader> ref;
    private final int identityHashCode;
    @Nullable
    private ClassLoader temporaryStrongRef;

    @NotNull
    public final WeakReference<ClassLoader> getRef() {
        return this.ref;
    }

    public final int getIdentityHashCode() {
        return this.identityHashCode;
    }

    @Nullable
    public final ClassLoader getTemporaryStrongRef() {
        return this.temporaryStrongRef;
    }

    public final void setTemporaryStrongRef(@Nullable ClassLoader classLoader) {
        this.temporaryStrongRef = classLoader;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof WeakClassLoaderBox && (ClassLoader)this.ref.get() == (ClassLoader)((WeakClassLoaderBox)other).ref.get();
    }

    public int hashCode() {
        return this.identityHashCode;
    }

    @NotNull
    public String toString() {
        ClassLoader classLoader;
        ClassLoader it;
        Object object = (ClassLoader)this.ref.get();
        if (object == null || (object = (it = (classLoader = object)).toString()) == null) {
            object = "<null>";
        }
        return object;
    }

    public WeakClassLoaderBox(@NotNull ClassLoader classLoader) {
        Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
        this.ref = new WeakReference<ClassLoader>(classLoader);
        this.identityHashCode = System.identityHashCode(classLoader);
        this.temporaryStrongRef = classLoader;
    }
}

