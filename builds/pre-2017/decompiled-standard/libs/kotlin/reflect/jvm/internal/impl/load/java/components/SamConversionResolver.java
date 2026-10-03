/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SamConversionResolver {
    public static final EMPTY EMPTY = new EMPTY(null);

    @Nullable
    public SamConstructorDescriptor resolveSamConstructor(@NotNull DeclarationDescriptor var1, @NotNull Function0<? extends ClassifierDescriptor> var2);

    @Nullable
    public <D extends FunctionDescriptor> D resolveSamAdapter(@NotNull D var1);

    @Nullable
    public SimpleType resolveFunctionTypeIfSamInterface(@NotNull JavaClassDescriptor var1);

    public static final class EMPTY
    implements SamConversionResolver {
        @Nullable
        public <D extends FunctionDescriptor> Void resolveSamAdapter(@NotNull D original) {
            Intrinsics.checkParameterIsNotNull(original, "original");
            return null;
        }

        @Nullable
        public Void resolveSamConstructor(@NotNull DeclarationDescriptor constructorOwner, @NotNull Function0<? extends ClassifierDescriptor> classifier2) {
            Intrinsics.checkParameterIsNotNull(constructorOwner, "constructorOwner");
            Intrinsics.checkParameterIsNotNull(classifier2, "classifier");
            return null;
        }

        @Override
        @Nullable
        public SimpleType resolveFunctionTypeIfSamInterface(@NotNull JavaClassDescriptor classDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            return null;
        }

        private EMPTY() {
        }

        public /* synthetic */ EMPTY(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

