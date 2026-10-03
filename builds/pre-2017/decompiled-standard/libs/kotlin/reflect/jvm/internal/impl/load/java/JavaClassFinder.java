/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ReadOnly;

public interface JavaClassFinder {
    @Nullable
    public JavaClass findClass(@NotNull ClassId var1);

    @Nullable
    public JavaPackage findPackage(@NotNull FqName var1);

    @ReadOnly
    @Nullable
    public Set<String> knownClassNamesInPackage(@NotNull FqName var1);
}

