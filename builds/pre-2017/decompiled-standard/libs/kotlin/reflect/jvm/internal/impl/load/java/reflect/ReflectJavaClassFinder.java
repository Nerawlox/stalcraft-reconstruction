/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.reflect;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassFinder
implements JavaClassFinder {
    private final ClassLoader classLoader;

    @Override
    @Nullable
    public JavaClass findClass(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        FqName packageFqName = classId.getPackageFqName();
        String relativeClassName = StringsKt.replace$default(classId.getRelativeClassName().asString(), '.', '$', false, 4, null);
        String name2 = packageFqName.isRoot() ? relativeClassName : packageFqName.asString() + "." + relativeClassName;
        Class<?> klass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, name2);
        return klass != null ? (JavaClass)new ReflectJavaClass(klass) : null;
    }

    @Override
    @Nullable
    public JavaPackage findPackage(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return new ReflectJavaPackage(fqName2);
    }

    @Override
    @Nullable
    public Set<String> knownClassNamesInPackage(@NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return null;
    }

    public ReflectJavaClassFinder(@NotNull ClassLoader classLoader) {
        Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
        this.classLoader = classLoader;
    }
}

