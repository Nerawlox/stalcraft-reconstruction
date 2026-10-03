/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class IncompatibleVersionErrorData<T extends BinaryVersion> {
    @NotNull
    private final T actualVersion;
    @NotNull
    private final T expectedVersion;
    @NotNull
    private final String filePath;
    @NotNull
    private final ClassId classId;

    @NotNull
    public final T getActualVersion() {
        return this.actualVersion;
    }

    @NotNull
    public final T getExpectedVersion() {
        return this.expectedVersion;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    public final ClassId getClassId() {
        return this.classId;
    }

    public IncompatibleVersionErrorData(@NotNull T actualVersion, @NotNull T expectedVersion, @NotNull String filePath, @NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(actualVersion, "actualVersion");
        Intrinsics.checkParameterIsNotNull(expectedVersion, "expectedVersion");
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        this.actualVersion = actualVersion;
        this.expectedVersion = expectedVersion;
        this.filePath = filePath;
        this.classId = classId;
    }

    @NotNull
    public final T component1() {
        return this.actualVersion;
    }

    @NotNull
    public final T component2() {
        return this.expectedVersion;
    }

    @NotNull
    public final String component3() {
        return this.filePath;
    }

    @NotNull
    public final ClassId component4() {
        return this.classId;
    }

    @NotNull
    public final IncompatibleVersionErrorData<T> copy(@NotNull T actualVersion, @NotNull T expectedVersion, @NotNull String filePath, @NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(actualVersion, "actualVersion");
        Intrinsics.checkParameterIsNotNull(expectedVersion, "expectedVersion");
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        return new IncompatibleVersionErrorData<T>(actualVersion, expectedVersion, filePath, classId);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ IncompatibleVersionErrorData copy$default(IncompatibleVersionErrorData incompatibleVersionErrorData, BinaryVersion binaryVersion, BinaryVersion binaryVersion2, String string, ClassId classId, int n, Object object) {
        if ((n & 1) != 0) {
            binaryVersion = incompatibleVersionErrorData.actualVersion;
        }
        if ((n & 2) != 0) {
            binaryVersion2 = incompatibleVersionErrorData.expectedVersion;
        }
        if ((n & 4) != 0) {
            string = incompatibleVersionErrorData.filePath;
        }
        if ((n & 8) != 0) {
            classId = incompatibleVersionErrorData.classId;
        }
        return incompatibleVersionErrorData.copy(binaryVersion, binaryVersion2, string, classId);
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ")";
    }

    public int hashCode() {
        T t = this.actualVersion;
        T t2 = this.expectedVersion;
        String string = this.filePath;
        ClassId classId = this.classId;
        return (((t != null ? t.hashCode() : 0) * 31 + (t2 != null ? t2.hashCode() : 0)) * 31 + (string != null ? string.hashCode() : 0)) * 31 + (classId != null ? ((Object)classId).hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof IncompatibleVersionErrorData)) break block3;
                IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData)object;
                if (!Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) || !Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) || !Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) || !Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId)) break block3;
            }
            return true;
        }
        return false;
    }
}

