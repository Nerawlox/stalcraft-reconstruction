/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaClassDataFinder
implements ClassDataFinder {
    @NotNull
    private final KotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;

    @Override
    @Nullable
    public ClassDataWithSource findClassData(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.kotlinClassFinder.findKotlinClass(classId);
        if (kotlinJvmBinaryClass == null) {
            return null;
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        boolean bl = Intrinsics.areEqual(kotlinClass.getClassId(), classId);
        if (_Assertions.ENABLED && !bl) {
            String string = "Class with incorrect id found: expected " + classId + ", actual " + kotlinClass.getClassId();
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        return this.deserializedDescriptorResolver.readClassData$kotlin_core(kotlinClass);
    }

    @NotNull
    public final KotlinClassFinder getKotlinClassFinder$kotlin_core() {
        return this.kotlinClassFinder;
    }

    public JavaClassDataFinder(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.kotlinClassFinder = kotlinClassFinder;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver;
    }
}

