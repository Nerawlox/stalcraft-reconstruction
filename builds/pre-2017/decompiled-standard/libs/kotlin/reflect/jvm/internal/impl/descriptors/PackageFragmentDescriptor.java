/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public interface PackageFragmentDescriptor
extends ClassOrPackageFragmentDescriptor {
    @Override
    @NotNull
    public ModuleDescriptor getContainingDeclaration();

    @NotNull
    public FqName getFqName();

    @NotNull
    public MemberScope getMemberScope();
}

