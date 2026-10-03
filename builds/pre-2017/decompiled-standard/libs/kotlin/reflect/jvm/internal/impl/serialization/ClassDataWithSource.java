/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import org.jetbrains.annotations.NotNull;

public final class ClassDataWithSource {
    @NotNull
    private final ClassData classData;
    @NotNull
    private final SourceElement sourceElement;

    @NotNull
    public final ClassData getClassData() {
        return this.classData;
    }

    @NotNull
    public final SourceElement getSourceElement() {
        return this.sourceElement;
    }

    public ClassDataWithSource(@NotNull ClassData classData, @NotNull SourceElement sourceElement) {
        Intrinsics.checkParameterIsNotNull(classData, "classData");
        Intrinsics.checkParameterIsNotNull(sourceElement, "sourceElement");
        this.classData = classData;
        this.sourceElement = sourceElement;
    }

    @NotNull
    public final ClassData component1() {
        return this.classData;
    }

    @NotNull
    public final SourceElement component2() {
        return this.sourceElement;
    }

    @NotNull
    public final ClassDataWithSource copy(@NotNull ClassData classData, @NotNull SourceElement sourceElement) {
        Intrinsics.checkParameterIsNotNull(classData, "classData");
        Intrinsics.checkParameterIsNotNull(sourceElement, "sourceElement");
        return new ClassDataWithSource(classData, sourceElement);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ClassDataWithSource copy$default(ClassDataWithSource classDataWithSource, ClassData classData, SourceElement sourceElement, int n, Object object) {
        if ((n & 1) != 0) {
            classData = classDataWithSource.classData;
        }
        if ((n & 2) != 0) {
            sourceElement = classDataWithSource.sourceElement;
        }
        return classDataWithSource.copy(classData, sourceElement);
    }

    public String toString() {
        return "ClassDataWithSource(classData=" + this.classData + ", sourceElement=" + this.sourceElement + ")";
    }

    public int hashCode() {
        ClassData classData = this.classData;
        SourceElement sourceElement = this.sourceElement;
        return (classData != null ? ((Object)classData).hashCode() : 0) * 31 + (sourceElement != null ? sourceElement.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof ClassDataWithSource)) break block3;
                ClassDataWithSource classDataWithSource = (ClassDataWithSource)object;
                if (!Intrinsics.areEqual(this.classData, classDataWithSource.classData) || !Intrinsics.areEqual(this.sourceElement, classDataWithSource.sourceElement)) break block3;
            }
            return true;
        }
        return false;
    }
}

