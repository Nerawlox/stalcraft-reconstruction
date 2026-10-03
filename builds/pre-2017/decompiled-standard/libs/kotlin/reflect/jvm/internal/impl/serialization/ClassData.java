/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;

public final class ClassData {
    @NotNull
    private final NameResolver nameResolver;
    @NotNull
    private final ProtoBuf.Class classProto;

    @NotNull
    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @NotNull
    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    public ClassData(@NotNull NameResolver nameResolver, @NotNull ProtoBuf.Class classProto) {
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(classProto, "classProto");
        this.nameResolver = nameResolver;
        this.classProto = classProto;
    }

    @NotNull
    public final NameResolver component1() {
        return this.nameResolver;
    }

    @NotNull
    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    @NotNull
    public final ClassData copy(@NotNull NameResolver nameResolver, @NotNull ProtoBuf.Class classProto) {
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(classProto, "classProto");
        return new ClassData(nameResolver, classProto);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ClassData copy$default(ClassData classData, NameResolver nameResolver, ProtoBuf.Class clazz, int n, Object object) {
        if ((n & 1) != 0) {
            nameResolver = classData.nameResolver;
        }
        if ((n & 2) != 0) {
            clazz = classData.classProto;
        }
        return classData.copy(nameResolver, clazz);
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ")";
    }

    public int hashCode() {
        NameResolver nameResolver = this.nameResolver;
        ProtoBuf.Class clazz = this.classProto;
        return (nameResolver != null ? nameResolver.hashCode() : 0) * 31 + (clazz != null ? clazz.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof ClassData)) break block3;
                ClassData classData = (ClassData)object;
                if (!Intrinsics.areEqual(this.nameResolver, classData.nameResolver) || !Intrinsics.areEqual(this.classProto, classData.classProto)) break block3;
            }
            return true;
        }
        return false;
    }
}

