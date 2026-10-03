/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmPackagePartSource
implements DeserializedContainerSource {
    @NotNull
    private final JvmClassName className;
    @Nullable
    private final JvmClassName facadeClassName;
    @Nullable
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;

    @Override
    @NotNull
    public FqName getPresentableFqName() {
        FqName fqName2 = this.getClassId().asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "classId.asSingleFqName()");
        return fqName2;
    }

    @NotNull
    public final Name getSimpleName() {
        Name name2 = Name.identifier(StringsKt.substringAfterLast$default(this.className.getInternalName(), '/', null, 2, null));
        Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(classNam\u2026.substringAfterLast('/'))");
        return name2;
    }

    @NotNull
    public final ClassId getClassId() {
        return new ClassId(this.className.getPackageFqName(), this.getSimpleName());
    }

    @NotNull
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.className;
    }

    @Override
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
        return sourceFile;
    }

    @NotNull
    public final JvmClassName getClassName() {
        return this.className;
    }

    @Nullable
    public final JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    @Nullable
    public IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility() {
        return this.incompatibility;
    }

    @Override
    public boolean isPreReleaseInvisible() {
        return this.isPreReleaseInvisible;
    }

    public JvmPackagePartSource(@NotNull JvmClassName className, @Nullable JvmClassName facadeClassName, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility, boolean isPreReleaseInvisible) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        this.className = className;
        this.facadeClassName = facadeClassName;
        this.incompatibility = incompatibility;
        this.isPreReleaseInvisible = isPreReleaseInvisible;
    }

    public /* synthetic */ JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, IncompatibleVersionErrorData incompatibleVersionErrorData, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            incompatibleVersionErrorData = null;
        }
        if ((n & 8) != 0) {
            bl = false;
        }
        this(jvmClassName, jvmClassName2, incompatibleVersionErrorData, bl);
    }

    public JvmPackagePartSource(@NotNull KotlinJvmBinaryClass kotlinClass, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility, boolean isPreReleaseInvisible) {
        JvmClassName jvmClassName;
        Intrinsics.checkParameterIsNotNull(kotlinClass, "kotlinClass");
        JvmPackagePartSource jvmPackagePartSource = this;
        JvmClassName jvmClassName2 = JvmClassName.byClassId(kotlinClass.getClassId());
        JvmClassName jvmClassName3 = jvmClassName2;
        Intrinsics.checkExpressionValueIsNotNull(jvmClassName2, "JvmClassName.byClassId(kotlinClass.classId)");
        String string = kotlinClass.getClassHeader().getMultifileClassName();
        if (string != null) {
            String string2 = string;
            JvmClassName jvmClassName4 = jvmClassName3;
            JvmPackagePartSource jvmPackagePartSource2 = jvmPackagePartSource;
            String it = string2;
            CharSequence charSequence = it;
            JvmClassName jvmClassName5 = charSequence.length() > 0 ? JvmClassName.byInternalName(it) : null;
            jvmPackagePartSource = jvmPackagePartSource2;
            jvmClassName3 = jvmClassName4;
            jvmClassName = jvmClassName5;
        } else {
            jvmClassName = null;
        }
        jvmPackagePartSource(jvmClassName3, jvmClassName, incompatibility, isPreReleaseInvisible);
    }

    public /* synthetic */ JvmPackagePartSource(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData incompatibleVersionErrorData, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            incompatibleVersionErrorData = null;
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        this(kotlinJvmBinaryClass, incompatibleVersionErrorData, bl);
    }
}

