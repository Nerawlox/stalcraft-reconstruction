/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectKotlinClassFinder
implements KotlinClassFinder {
    private final ClassLoader classLoader;

    private final KotlinJvmBinaryClass findKotlinClass(String fqName2) {
        ReflectKotlinClass reflectKotlinClass;
        Class<?> clazz = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, fqName2);
        if (clazz != null) {
            Class<?> clazz2;
            Class<?> it = clazz2 = clazz;
            reflectKotlinClass = ReflectKotlinClass.Factory.create(it);
        } else {
            reflectKotlinClass = null;
        }
        return reflectKotlinClass;
    }

    @Override
    @Nullable
    public KotlinJvmBinaryClass findKotlinClass(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        return this.findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(classId));
    }

    @Override
    @Nullable
    public KotlinJvmBinaryClass findKotlinClass(@NotNull JavaClass javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "javaClass");
        Object object = javaClass.getFqName();
        if (object == null || (object = ((FqName)object).asString()) == null) {
            return null;
        }
        return this.findKotlinClass((String)object);
    }

    @Override
    @Nullable
    public InputStream findMetadata(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        return null;
    }

    @Override
    public boolean hasMetadataPackage(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return false;
    }

    @Override
    @Nullable
    public InputStream findBuiltInsData(@NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return null;
    }

    public ReflectKotlinClassFinder(@NotNull ClassLoader classLoader) {
        Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
        this.classLoader = classLoader;
    }
}

