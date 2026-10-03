/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class CloneableClassScope
extends GivenFunctionsMemberScope {
    @NotNull
    private static final Name CLONE_NAME;
    public static final Companion Companion;

    @Override
    @NotNull
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl;
        SimpleFunctionDescriptorImpl $receiver = simpleFunctionDescriptorImpl = SimpleFunctionDescriptorImpl.create(this.getContainingClass(), Annotations.Companion.getEMPTY(), Companion.getCLONE_NAME$kotlin_core(), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        $receiver.initialize((KotlinType)null, this.getContainingClass().getThisAsReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), (KotlinType)DescriptorUtilsKt.getBuiltIns(this.getContainingClass()).getAnyType(), Modality.OPEN, Visibilities.PROTECTED);
        return CollectionsKt.listOf(simpleFunctionDescriptorImpl);
    }

    public CloneableClassScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(containingClass, "containingClass");
        super(storageManager, containingClass);
    }

    static {
        Companion = new Companion(null);
        CLONE_NAME = Name.identifier("clone");
    }

    public static final class Companion {
        @NotNull
        public final Name getCLONE_NAME$kotlin_core() {
            return CLONE_NAME;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

