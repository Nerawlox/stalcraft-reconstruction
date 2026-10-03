/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingConfigurationImpl
implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE;

    @Override
    @NotNull
    public KotlinType commonSupertype(@NotNull Collection<? extends KotlinType> types) {
        Intrinsics.checkParameterIsNotNull(types, "types");
        throw (Throwable)((Object)new AssertionError((Object)("There should be no intersection type in existing descriptors, but found: " + CollectionsKt.joinToString$default(types, null, null, null, 0, null, null, 63, null))));
    }

    @Override
    @Nullable
    public Void getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        return null;
    }

    @Override
    @Nullable
    public String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        return null;
    }

    @Override
    public void processErrorType(@NotNull KotlinType kotlinType, @NotNull ClassDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
    }

    private TypeMappingConfigurationImpl() {
        INSTANCE = this;
    }

    static {
        new TypeMappingConfigurationImpl();
    }

    @Override
    @NotNull
    public Function2<String, String, String> getInnerClassNameFactory() {
        return TypeMappingConfiguration.DefaultImpls.getInnerClassNameFactory(this);
    }
}

