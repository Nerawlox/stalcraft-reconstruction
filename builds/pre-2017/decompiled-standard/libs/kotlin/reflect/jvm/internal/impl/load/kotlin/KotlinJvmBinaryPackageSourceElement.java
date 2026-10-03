/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinJvmBinaryPackageSourceElement
implements SourceElement {
    private final LazyJavaPackageFragment packageFragment;

    @NotNull
    public String toString() {
        return this.packageFragment + ": " + this.packageFragment.getBinaryClasses$kotlin_core().keySet();
    }

    @Override
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
        return sourceFile;
    }

    @NotNull
    public final KotlinJvmBinaryClass getRepresentativeBinaryClass() {
        return (KotlinJvmBinaryClass)CollectionsKt.first((Iterable)this.packageFragment.getBinaryClasses$kotlin_core().values());
    }

    @Nullable
    public final KotlinJvmBinaryClass getContainingBinaryClass(@NotNull DeserializedCallableMemberDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        Name name2 = UtilKt.getImplClassNameForDeserialized(descriptor2);
        if (name2 == null) {
            return null;
        }
        Name name3 = name2;
        return this.packageFragment.getBinaryClasses$kotlin_core().get(name3.asString());
    }

    public KotlinJvmBinaryPackageSourceElement(@NotNull LazyJavaPackageFragment packageFragment) {
        Intrinsics.checkParameterIsNotNull(packageFragment, "packageFragment");
        this.packageFragment = packageFragment;
    }
}

