/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
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
import org.jetbrains.annotations.NotNull;

public interface AnnotationArgumentVisitor<R, D> {
    public R visitLongValue(@NotNull LongValue var1, D var2);

    public R visitIntValue(IntValue var1, D var2);

    public R visitErrorValue(ErrorValue var1, D var2);

    public R visitShortValue(ShortValue var1, D var2);

    public R visitByteValue(ByteValue var1, D var2);

    public R visitDoubleValue(DoubleValue var1, D var2);

    public R visitFloatValue(FloatValue var1, D var2);

    public R visitBooleanValue(BooleanValue var1, D var2);

    public R visitCharValue(CharValue var1, D var2);

    public R visitStringValue(StringValue var1, D var2);

    public R visitNullValue(NullValue var1, D var2);

    public R visitEnumValue(EnumValue var1, D var2);

    public R visitArrayValue(ArrayValue var1, D var2);

    public R visitAnnotationValue(AnnotationValue var1, D var2);

    public R visitKClassValue(KClassValue var1, D var2);
}

