/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope$WhenMappings;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class FunctionClassScope
extends GivenFunctionsMemberScope {
    @Override
    @NotNull
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        List<FunctionDescriptor> list;
        ClassDescriptor classDescriptor = this.getContainingClass();
        if (classDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        }
        switch (FunctionClassScope$WhenMappings.$EnumSwitchMapping$0[((FunctionClassDescriptor)classDescriptor).getFunctionKind().ordinal()]) {
            case 1: {
                list = CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor)this.getContainingClass(), false));
                break;
            }
            case 2: {
                list = CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor)this.getContainingClass(), true));
                break;
            }
            default: {
                list = CollectionsKt.emptyList();
            }
        }
        return list;
    }

    public FunctionClassScope(@NotNull StorageManager storageManager, @NotNull FunctionClassDescriptor containingClass) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(containingClass, "containingClass");
        super(storageManager, containingClass);
    }
}

