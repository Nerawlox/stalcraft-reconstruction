/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinJvmBinarySourceElement
implements DeserializedContainerSource {
    @NotNull
    private final KotlinJvmBinaryClass binaryClass;
    @Nullable
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;

    @Override
    @NotNull
    public FqName getPresentableFqName() {
        FqName fqName2 = this.binaryClass.getClassId().asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "binaryClass.classId.asSingleFqName()");
        return fqName2;
    }

    @Override
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
        return sourceFile;
    }

    @NotNull
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.binaryClass;
    }

    @NotNull
    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.binaryClass;
    }

    @Nullable
    public IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility() {
        return this.incompatibility;
    }

    @Override
    public boolean isPreReleaseInvisible() {
        return this.isPreReleaseInvisible;
    }

    public KotlinJvmBinarySourceElement(@NotNull KotlinJvmBinaryClass binaryClass, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility, boolean isPreReleaseInvisible) {
        Intrinsics.checkParameterIsNotNull(binaryClass, "binaryClass");
        this.binaryClass = binaryClass;
        this.incompatibility = incompatibility;
        this.isPreReleaseInvisible = isPreReleaseInvisible;
    }

    public /* synthetic */ KotlinJvmBinarySourceElement(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData incompatibleVersionErrorData, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            incompatibleVersionErrorData = null;
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        this(kotlinJvmBinaryClass, incompatibleVersionErrorData, bl);
    }
}

