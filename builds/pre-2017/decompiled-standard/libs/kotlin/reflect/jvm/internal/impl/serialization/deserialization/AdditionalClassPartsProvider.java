/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface AdditionalClassPartsProvider {
    @NotNull
    public Collection<KotlinType> getSupertypes(@NotNull DeserializedClassDescriptor var1);

    @NotNull
    public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name var1, @NotNull DeserializedClassDescriptor var2);

    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull DeserializedClassDescriptor var1);

    @NotNull
    public Collection<Name> getFunctionsNames(@NotNull DeserializedClassDescriptor var1);

    public static final class None
    implements AdditionalClassPartsProvider {
        public static final None INSTANCE;

        @Override
        @NotNull
        public Collection<KotlinType> getSupertypes(@NotNull DeserializedClassDescriptor classDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        @Override
        @NotNull
        public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name2, @NotNull DeserializedClassDescriptor classDescriptor) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        @Override
        @NotNull
        public Collection<Name> getFunctionsNames(@NotNull DeserializedClassDescriptor classDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        @Override
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors(@NotNull DeserializedClassDescriptor classDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        private None() {
            INSTANCE = this;
        }

        static {
            new None();
        }
    }
}

