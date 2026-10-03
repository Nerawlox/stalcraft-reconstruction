/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaPackage
extends ReflectJavaElement
implements JavaPackage {
    @NotNull
    private final FqName fqName;

    @Override
    @NotNull
    public Collection<JavaClass> getClasses(@NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<JavaPackage> getSubPackages() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaPackage && Intrinsics.areEqual(this.getFqName(), ((ReflectJavaPackage)other).getFqName());
    }

    public int hashCode() {
        return this.getFqName().hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.getFqName();
    }

    @Override
    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    public ReflectJavaPackage(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        this.fqName = fqName2;
    }
}

