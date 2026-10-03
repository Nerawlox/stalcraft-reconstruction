/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization$WhenMappings;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Deserialization {
    public static final Deserialization INSTANCE;

    /*
     * Enabled aggressive block sorting
     */
    @JvmStatic
    @NotNull
    public static final CallableMemberDescriptor.Kind memberKind(@Nullable ProtoBuf.MemberKind memberKind) {
        CallableMemberDescriptor.Kind kind;
        ProtoBuf.MemberKind memberKind2 = memberKind;
        if (memberKind2 != null) {
            switch (Deserialization$WhenMappings.$EnumSwitchMapping$0[memberKind2.ordinal()]) {
                case 1: {
                    kind = CallableMemberDescriptor.Kind.DECLARATION;
                    return kind;
                }
                case 2: {
                    kind = CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
                    return kind;
                }
                case 3: {
                    kind = CallableMemberDescriptor.Kind.DELEGATION;
                    return kind;
                }
                case 4: {
                    kind = CallableMemberDescriptor.Kind.SYNTHESIZED;
                    return kind;
                }
            }
        }
        kind = CallableMemberDescriptor.Kind.DECLARATION;
        return kind;
    }

    /*
     * Enabled aggressive block sorting
     */
    @JvmStatic
    @NotNull
    public static final Modality modality(@Nullable ProtoBuf.Modality modality) {
        Modality modality2;
        ProtoBuf.Modality modality3 = modality;
        if (modality3 != null) {
            switch (Deserialization$WhenMappings.$EnumSwitchMapping$1[modality3.ordinal()]) {
                case 1: {
                    modality2 = Modality.FINAL;
                    return modality2;
                }
                case 2: {
                    modality2 = Modality.OPEN;
                    return modality2;
                }
                case 3: {
                    modality2 = Modality.ABSTRACT;
                    return modality2;
                }
                case 4: {
                    modality2 = Modality.SEALED;
                    return modality2;
                }
            }
        }
        modality2 = Modality.FINAL;
        return modality2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @JvmStatic
    @NotNull
    public static final Visibility visibility(@Nullable ProtoBuf.Visibility visibility) {
        Visibility visibility2;
        ProtoBuf.Visibility visibility3 = visibility;
        if (visibility3 != null) {
            switch (Deserialization$WhenMappings.$EnumSwitchMapping$2[visibility3.ordinal()]) {
                case 1: {
                    visibility2 = Visibilities.INTERNAL;
                    return visibility2;
                }
                case 2: {
                    visibility2 = Visibilities.PRIVATE;
                    return visibility2;
                }
                case 3: {
                    visibility2 = Visibilities.PRIVATE_TO_THIS;
                    return visibility2;
                }
                case 4: {
                    visibility2 = Visibilities.PROTECTED;
                    return visibility2;
                }
                case 5: {
                    visibility2 = Visibilities.PUBLIC;
                    return visibility2;
                }
                case 6: {
                    visibility2 = Visibilities.LOCAL;
                    return visibility2;
                }
            }
        }
        visibility2 = Visibilities.PRIVATE;
        return visibility2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @JvmStatic
    @NotNull
    public static final ClassKind classKind(@Nullable ProtoBuf.Class.Kind kind) {
        ClassKind classKind;
        ProtoBuf.Class.Kind kind2 = kind;
        if (kind2 != null) {
            switch (Deserialization$WhenMappings.$EnumSwitchMapping$3[kind2.ordinal()]) {
                case 1: {
                    classKind = ClassKind.CLASS;
                    return classKind;
                }
                case 2: {
                    classKind = ClassKind.INTERFACE;
                    return classKind;
                }
                case 3: {
                    classKind = ClassKind.ENUM_CLASS;
                    return classKind;
                }
                case 4: {
                    classKind = ClassKind.ENUM_ENTRY;
                    return classKind;
                }
                case 5: {
                    classKind = ClassKind.ANNOTATION_CLASS;
                    return classKind;
                }
                case 6: 
                case 7: {
                    classKind = ClassKind.OBJECT;
                    return classKind;
                }
            }
        }
        classKind = ClassKind.CLASS;
        return classKind;
    }

    @JvmStatic
    @NotNull
    public static final Variance variance(@NotNull ProtoBuf.TypeParameter.Variance variance) {
        Variance variance2;
        Intrinsics.checkParameterIsNotNull(variance, "variance");
        switch (Deserialization$WhenMappings.$EnumSwitchMapping$4[variance.ordinal()]) {
            case 1: {
                variance2 = Variance.IN_VARIANCE;
                break;
            }
            case 2: {
                variance2 = Variance.OUT_VARIANCE;
                break;
            }
            case 3: {
                variance2 = Variance.INVARIANT;
                break;
            }
            default: {
                variance2 = Variance.INVARIANT;
            }
        }
        return variance2;
    }

    @JvmStatic
    @NotNull
    public static final Variance variance(@NotNull ProtoBuf.Type.Argument.Projection variance) {
        Variance variance2;
        Intrinsics.checkParameterIsNotNull(variance, "variance");
        switch (Deserialization$WhenMappings.$EnumSwitchMapping$5[variance.ordinal()]) {
            case 1: {
                variance2 = Variance.IN_VARIANCE;
                break;
            }
            case 2: {
                variance2 = Variance.OUT_VARIANCE;
                break;
            }
            case 3: {
                variance2 = Variance.INVARIANT;
                break;
            }
            case 4: {
                throw (Throwable)new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + variance);
            }
            default: {
                variance2 = Variance.INVARIANT;
            }
        }
        return variance2;
    }

    private Deserialization() {
        INSTANCE = this;
    }

    static {
        new Deserialization();
    }
}

