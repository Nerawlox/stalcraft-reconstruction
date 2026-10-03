/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Flags {
    public static final BooleanFlagField SUSPEND_TYPE = FlagField.booleanFirst();
    public static final BooleanFlagField HAS_ANNOTATIONS = FlagField.booleanFirst();
    public static final FlagField<ProtoBuf.Visibility> VISIBILITY = FlagField.after((FlagField)HAS_ANNOTATIONS, (Internal.EnumLite[])ProtoBuf.Visibility.values());
    public static final FlagField<ProtoBuf.Modality> MODALITY = FlagField.after(VISIBILITY, (Internal.EnumLite[])ProtoBuf.Modality.values());
    public static final FlagField<ProtoBuf.Class.Kind> CLASS_KIND = FlagField.after(MODALITY, (Internal.EnumLite[])ProtoBuf.Class.Kind.values());
    public static final BooleanFlagField IS_INNER = FlagField.booleanAfter(CLASS_KIND);
    public static final BooleanFlagField IS_DATA = FlagField.booleanAfter(IS_INNER);
    public static final BooleanFlagField IS_EXTERNAL_CLASS = FlagField.booleanAfter(IS_DATA);
    public static final BooleanFlagField IS_SECONDARY = FlagField.booleanAfter(VISIBILITY);
    public static final FlagField<ProtoBuf.MemberKind> MEMBER_KIND = FlagField.after(MODALITY, (Internal.EnumLite[])ProtoBuf.MemberKind.values());
    public static final BooleanFlagField IS_OPERATOR = FlagField.booleanAfter(MEMBER_KIND);
    public static final BooleanFlagField IS_INFIX = FlagField.booleanAfter(IS_OPERATOR);
    public static final BooleanFlagField IS_INLINE = FlagField.booleanAfter(IS_INFIX);
    public static final BooleanFlagField IS_TAILREC = FlagField.booleanAfter(IS_INLINE);
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION = FlagField.booleanAfter(IS_TAILREC);
    public static final BooleanFlagField IS_SUSPEND = FlagField.booleanAfter(IS_EXTERNAL_FUNCTION);
    public static final BooleanFlagField IS_VAR = FlagField.booleanAfter(MEMBER_KIND);
    public static final BooleanFlagField HAS_GETTER = FlagField.booleanAfter(IS_VAR);
    public static final BooleanFlagField HAS_SETTER = FlagField.booleanAfter(HAS_GETTER);
    public static final BooleanFlagField IS_CONST = FlagField.booleanAfter(HAS_SETTER);
    public static final BooleanFlagField IS_LATEINIT = FlagField.booleanAfter(IS_CONST);
    public static final BooleanFlagField HAS_CONSTANT = FlagField.booleanAfter(IS_LATEINIT);
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY = FlagField.booleanAfter(HAS_CONSTANT);
    public static final BooleanFlagField IS_DELEGATED = FlagField.booleanAfter(IS_EXTERNAL_PROPERTY);
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE = FlagField.booleanAfter(HAS_ANNOTATIONS);
    public static final BooleanFlagField IS_CROSSINLINE = FlagField.booleanAfter(DECLARES_DEFAULT_VALUE);
    public static final BooleanFlagField IS_NOINLINE = FlagField.booleanAfter(IS_CROSSINLINE);
    public static final BooleanFlagField IS_NOT_DEFAULT = FlagField.booleanAfter(MODALITY);
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR = FlagField.booleanAfter(IS_NOT_DEFAULT);
    public static final BooleanFlagField IS_INLINE_ACCESSOR = FlagField.booleanAfter(IS_EXTERNAL_ACCESSOR);

    private Flags() {
    }

    public static int getTypeFlags(boolean isSuspend) {
        return SUSPEND_TYPE.toFlags(isSuspend);
    }

    public static int getClassFlags(boolean hasAnnotations, Visibility visibility, Modality modality, ClassKind kind, boolean inner, boolean isCompanionObject, boolean isData, boolean isExternal) {
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | MODALITY.toFlags(Flags.modality(modality)) | VISIBILITY.toFlags(Flags.visibility(visibility)) | CLASS_KIND.toFlags(Flags.classKind(kind, isCompanionObject)) | IS_INNER.toFlags(inner) | IS_DATA.toFlags(isData) | IS_EXTERNAL_CLASS.toFlags(isExternal);
    }

    private static ProtoBuf.Class.Kind classKind(ClassKind kind, boolean isCompanionObject) {
        if (isCompanionObject) {
            return ProtoBuf.Class.Kind.COMPANION_OBJECT;
        }
        switch (kind) {
            case CLASS: {
                return ProtoBuf.Class.Kind.CLASS;
            }
            case INTERFACE: {
                return ProtoBuf.Class.Kind.INTERFACE;
            }
            case ENUM_CLASS: {
                return ProtoBuf.Class.Kind.ENUM_CLASS;
            }
            case ENUM_ENTRY: {
                return ProtoBuf.Class.Kind.ENUM_ENTRY;
            }
            case ANNOTATION_CLASS: {
                return ProtoBuf.Class.Kind.ANNOTATION_CLASS;
            }
            case OBJECT: {
                return ProtoBuf.Class.Kind.OBJECT;
            }
        }
        throw new IllegalArgumentException("Unknown class kind: " + (Object)((Object)kind));
    }

    public static int getConstructorFlags(boolean hasAnnotations, @NotNull Visibility visibility, boolean isSecondary) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getConstructorFlags"));
        }
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | VISIBILITY.toFlags(Flags.visibility(visibility)) | IS_SECONDARY.toFlags(isSecondary);
    }

    public static int getFunctionFlags(boolean hasAnnotations, @NotNull Visibility visibility, @NotNull Modality modality, @NotNull CallableMemberDescriptor.Kind memberKind, boolean isOperator, boolean isInfix, boolean isInline, boolean isTailrec, boolean isExternal, boolean isSuspend) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getFunctionFlags"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getFunctionFlags"));
        }
        if (memberKind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberKind", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getFunctionFlags"));
        }
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | VISIBILITY.toFlags(Flags.visibility(visibility)) | MODALITY.toFlags(Flags.modality(modality)) | MEMBER_KIND.toFlags(Flags.memberKind(memberKind)) | IS_OPERATOR.toFlags(isOperator) | IS_INFIX.toFlags(isInfix) | IS_INLINE.toFlags(isInline) | IS_TAILREC.toFlags(isTailrec) | IS_EXTERNAL_FUNCTION.toFlags(isExternal) | IS_SUSPEND.toFlags(isSuspend);
    }

    public static int getPropertyFlags(boolean hasAnnotations, @NotNull Visibility visibility, @NotNull Modality modality, @NotNull CallableMemberDescriptor.Kind memberKind, boolean isVar, boolean hasGetter, boolean hasSetter, boolean hasConstant, boolean isConst, boolean lateInit, boolean isExternal, boolean isDelegated) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getPropertyFlags"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getPropertyFlags"));
        }
        if (memberKind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberKind", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getPropertyFlags"));
        }
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | VISIBILITY.toFlags(Flags.visibility(visibility)) | MODALITY.toFlags(Flags.modality(modality)) | MEMBER_KIND.toFlags(Flags.memberKind(memberKind)) | IS_VAR.toFlags(isVar) | HAS_GETTER.toFlags(hasGetter) | HAS_SETTER.toFlags(hasSetter) | IS_CONST.toFlags(isConst) | IS_LATEINIT.toFlags(lateInit) | HAS_CONSTANT.toFlags(hasConstant) | IS_EXTERNAL_PROPERTY.toFlags(isExternal) | IS_DELEGATED.toFlags(isDelegated);
    }

    public static int getAccessorFlags(boolean hasAnnotations, @NotNull Visibility visibility, @NotNull Modality modality, boolean isNotDefault, boolean isExternal, boolean isInlineAccessor) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getAccessorFlags"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "getAccessorFlags"));
        }
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | MODALITY.toFlags(Flags.modality(modality)) | VISIBILITY.toFlags(Flags.visibility(visibility)) | IS_NOT_DEFAULT.toFlags(isNotDefault) | IS_EXTERNAL_ACCESSOR.toFlags(isExternal) | IS_INLINE_ACCESSOR.toFlags(isInlineAccessor);
    }

    @NotNull
    private static ProtoBuf.Visibility visibility(@NotNull Visibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
        }
        if (visibility == Visibilities.INTERNAL) {
            ProtoBuf.Visibility visibility2 = ProtoBuf.Visibility.INTERNAL;
            if (visibility2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
            }
            return visibility2;
        }
        if (visibility == Visibilities.PUBLIC) {
            ProtoBuf.Visibility visibility3 = ProtoBuf.Visibility.PUBLIC;
            if (visibility3 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
            }
            return visibility3;
        }
        if (visibility == Visibilities.PRIVATE) {
            ProtoBuf.Visibility visibility4 = ProtoBuf.Visibility.PRIVATE;
            if (visibility4 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
            }
            return visibility4;
        }
        if (visibility == Visibilities.PRIVATE_TO_THIS) {
            ProtoBuf.Visibility visibility5 = ProtoBuf.Visibility.PRIVATE_TO_THIS;
            if (visibility5 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
            }
            return visibility5;
        }
        if (visibility == Visibilities.PROTECTED) {
            ProtoBuf.Visibility visibility6 = ProtoBuf.Visibility.PROTECTED;
            if (visibility6 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
            }
            return visibility6;
        }
        if (visibility == Visibilities.LOCAL) {
            ProtoBuf.Visibility visibility7 = ProtoBuf.Visibility.LOCAL;
            if (visibility7 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "visibility"));
            }
            return visibility7;
        }
        throw new IllegalArgumentException("Unknown visibility: " + visibility);
    }

    @NotNull
    private static ProtoBuf.Modality modality(@NotNull Modality modality) {
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "modality"));
        }
        switch (modality) {
            case FINAL: {
                ProtoBuf.Modality modality2 = ProtoBuf.Modality.FINAL;
                if (modality2 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "modality"));
                }
                return modality2;
            }
            case OPEN: {
                ProtoBuf.Modality modality3 = ProtoBuf.Modality.OPEN;
                if (modality3 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "modality"));
                }
                return modality3;
            }
            case ABSTRACT: {
                ProtoBuf.Modality modality4 = ProtoBuf.Modality.ABSTRACT;
                if (modality4 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "modality"));
                }
                return modality4;
            }
            case SEALED: {
                ProtoBuf.Modality modality5 = ProtoBuf.Modality.SEALED;
                if (modality5 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "modality"));
                }
                return modality5;
            }
        }
        throw new IllegalArgumentException("Unknown modality: " + (Object)((Object)modality));
    }

    @NotNull
    private static ProtoBuf.MemberKind memberKind(@NotNull CallableMemberDescriptor.Kind kind) {
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "memberKind"));
        }
        switch (kind) {
            case DECLARATION: {
                ProtoBuf.MemberKind memberKind = ProtoBuf.MemberKind.DECLARATION;
                if (memberKind == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "memberKind"));
                }
                return memberKind;
            }
            case FAKE_OVERRIDE: {
                ProtoBuf.MemberKind memberKind = ProtoBuf.MemberKind.FAKE_OVERRIDE;
                if (memberKind == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "memberKind"));
                }
                return memberKind;
            }
            case DELEGATION: {
                ProtoBuf.MemberKind memberKind = ProtoBuf.MemberKind.DELEGATION;
                if (memberKind == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "memberKind"));
                }
                return memberKind;
            }
            case SYNTHESIZED: {
                ProtoBuf.MemberKind memberKind = ProtoBuf.MemberKind.SYNTHESIZED;
                if (memberKind == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags", "memberKind"));
                }
                return memberKind;
            }
        }
        throw new IllegalArgumentException("Unknown member kind: " + (Object)((Object)kind));
    }

    public static int getValueParameterFlags(boolean hasAnnotations, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline) {
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | DECLARES_DEFAULT_VALUE.toFlags(declaresDefaultValue) | IS_CROSSINLINE.toFlags(isCrossinline) | IS_NOINLINE.toFlags(isNoinline);
    }

    public static int getTypeAliasFlags(boolean hasAnnotations, Visibility visibility) {
        return HAS_ANNOTATIONS.toFlags(hasAnnotations) | VISIBILITY.toFlags(Flags.visibility(visibility));
    }

    private static class EnumLiteFlagField<E extends Internal.EnumLite>
    extends FlagField<E> {
        private final E[] values;

        public EnumLiteFlagField(int offset, E[] values2) {
            super(offset, EnumLiteFlagField.bitWidth(values2));
            this.values = values2;
        }

        private static <E> int bitWidth(@NotNull E[] enumEntries) {
            if (enumEntries == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/serialization/Flags$EnumLiteFlagField", "bitWidth"));
            }
            int length = enumEntries.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; --i) {
                if ((length & 1 << i) == 0) continue;
                return i + 1;
            }
            throw new IllegalStateException("Empty enum: " + enumEntries.getClass());
        }

        @Override
        @Nullable
        public E get(int flags) {
            int maskUnshifted = (1 << this.bitWidth) - 1;
            int mask = maskUnshifted << this.offset;
            int value = (flags & mask) >> this.offset;
            for (E e : this.values) {
                if (e.getNumber() != value) continue;
                return e;
            }
            return null;
        }

        @Override
        public int toFlags(E value) {
            return value.getNumber() << this.offset;
        }
    }

    public static class BooleanFlagField
    extends FlagField<Boolean> {
        public BooleanFlagField(int offset) {
            super(offset, 1);
        }

        @Override
        @NotNull
        public Boolean get(int flags) {
            Boolean bl = (flags & 1 << this.offset) != 0;
            if (bl == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField", "get"));
            }
            return bl;
        }

        @Override
        public int toFlags(Boolean value) {
            return value != false ? 1 << this.offset : 0;
        }
    }

    public static abstract class FlagField<E> {
        protected final int offset;
        protected final int bitWidth;

        public static <E extends Internal.EnumLite> FlagField<E> after(FlagField<?> previousField, E[] values2) {
            int offset = previousField.offset + previousField.bitWidth;
            return new EnumLiteFlagField(offset, values2);
        }

        public static <E extends Internal.EnumLite> FlagField<E> first(E[] values2) {
            return new EnumLiteFlagField(0, values2);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> previousField) {
            int offset = previousField.offset + previousField.bitWidth;
            return new BooleanFlagField(offset);
        }

        private FlagField(int offset, int bitWidth) {
            this.offset = offset;
            this.bitWidth = bitWidth;
        }

        public abstract E get(int var1);

        public abstract int toFlags(E var1);
    }
}

