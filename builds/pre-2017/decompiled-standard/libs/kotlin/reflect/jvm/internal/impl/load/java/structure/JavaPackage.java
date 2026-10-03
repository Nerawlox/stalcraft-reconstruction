/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public interface JavaPackage
extends JavaElement {
    @NotNull
    public FqName getFqName();

    @NotNull
    public Collection<JavaPackage> getSubPackages();

    @NotNull
    public Collection<JavaClass> getClasses(@NotNull Function1<? super Name, Boolean> var1);
}

