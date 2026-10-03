/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

public abstract class IntegerValueConstant<T>
extends ConstantValue<T> {
    protected IntegerValueConstant(T value) {
        super(value);
    }
}

