/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ConstantValueFactory {
    private final KotlinBuiltIns builtins;

    @NotNull
    public final LongValue createLongValue(long value) {
        return new LongValue(value, this.builtins);
    }

    @NotNull
    public final IntValue createIntValue(int value) {
        return new IntValue(value, this.builtins);
    }

    @NotNull
    public final ErrorValue createErrorValue(@NotNull String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        return ErrorValue.Companion.create(message);
    }

    @NotNull
    public final ShortValue createShortValue(short value) {
        return new ShortValue(value, this.builtins);
    }

    @NotNull
    public final ByteValue createByteValue(byte value) {
        return new ByteValue(value, this.builtins);
    }

    @NotNull
    public final DoubleValue createDoubleValue(double value) {
        return new DoubleValue(value, this.builtins);
    }

    @NotNull
    public final FloatValue createFloatValue(float value) {
        return new FloatValue(value, this.builtins);
    }

    @NotNull
    public final BooleanValue createBooleanValue(boolean value) {
        return new BooleanValue(value, this.builtins);
    }

    @NotNull
    public final CharValue createCharValue(char value) {
        return new CharValue(value, this.builtins);
    }

    @NotNull
    public final StringValue createStringValue(@NotNull String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        return new StringValue(value, this.builtins);
    }

    @NotNull
    public final NullValue createNullValue() {
        return new NullValue(this.builtins);
    }

    @NotNull
    public final EnumValue createEnumValue(@NotNull ClassDescriptor enumEntryClass) {
        Intrinsics.checkParameterIsNotNull(enumEntryClass, "enumEntryClass");
        return new EnumValue(enumEntryClass);
    }

    @NotNull
    public final ArrayValue createArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return new ArrayValue(value, type2, this.builtins);
    }

    @NotNull
    public final AnnotationValue createAnnotationValue(@NotNull AnnotationDescriptor value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        return new AnnotationValue(value);
    }

    @NotNull
    public final KClassValue createKClassValue(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return new KClassValue(type2);
    }

    @Nullable
    public final ConstantValue<?> createConstantValue(@Nullable Object value) {
        Object object = value;
        return object instanceof Byte ? (ConstantValue)this.createByteValue(((Number)value).byteValue()) : (object instanceof Short ? (ConstantValue)this.createShortValue(((Number)value).shortValue()) : (object instanceof Integer ? (ConstantValue)this.createIntValue(((Number)value).intValue()) : (object instanceof Long ? (ConstantValue)this.createLongValue(((Number)value).longValue()) : (object instanceof Character ? (ConstantValue)this.createCharValue(((Character)value).charValue()) : (object instanceof Float ? (ConstantValue)this.createFloatValue(((Number)value).floatValue()) : (object instanceof Double ? (ConstantValue)this.createDoubleValue(((Number)value).doubleValue()) : (object instanceof Boolean ? (ConstantValue)this.createBooleanValue((Boolean)value) : (object instanceof String ? (ConstantValue)this.createStringValue((String)value) : (Intrinsics.areEqual(object, null) ? (ConstantValue)this.createNullValue() : null)))))))));
    }

    @Nullable
    public final ConstantValue<?> createIntegerConstantValue(long value, @NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        KotlinType notNullExpected = TypeUtils.makeNotNullable(expectedType);
        return KotlinBuiltIns.isLong(notNullExpected) ? (ConstantValue)this.createLongValue(value) : (KotlinBuiltIns.isInt(notNullExpected) && value == (long)((int)value) ? (ConstantValue)this.createIntValue((int)value) : (KotlinBuiltIns.isShort(notNullExpected) && value == (long)((short)value) ? (ConstantValue)this.createShortValue((short)value) : (KotlinBuiltIns.isByte(notNullExpected) && value == (long)((byte)value) ? (ConstantValue)this.createByteValue((byte)value) : (KotlinBuiltIns.isChar(notNullExpected) ? (ConstantValue)this.createIntValue((int)value) : null))));
    }

    public ConstantValueFactory(@NotNull KotlinBuiltIns builtins) {
        Intrinsics.checkParameterIsNotNull(builtins, "builtins");
        this.builtins = builtins;
    }
}

