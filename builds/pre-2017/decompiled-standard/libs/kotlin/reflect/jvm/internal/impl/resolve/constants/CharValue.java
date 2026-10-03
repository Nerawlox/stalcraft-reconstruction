/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueConstant;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class CharValue
extends IntegerValueConstant<Character> {
    @NotNull
    private final SimpleType type;

    @Override
    @NotNull
    public SimpleType getType() {
        return this.type;
    }

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitCharValue(this, data2);
    }

    @Override
    @NotNull
    public String toString() {
        String string = "\\u%04X ('%s')";
        Object[] objectArray = new Object[]{(int)((Character)this.getValue()).charValue(), this.getPrintablePart(((Character)this.getValue()).charValue())};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkExpressionValueIsNotNull(string2, "java.lang.String.format(this, *args)");
        return string2;
    }

    private final String getPrintablePart(char c) {
        String string;
        switch (c) {
            case '\b': {
                return "\\b";
            }
            case '\t': {
                return "\\t";
            }
            case '\n': {
                return "\\n";
            }
            case '\f': {
                return "\\f";
            }
            case '\r': {
                return "\\r";
            }
        }
        if (this.isPrintableUnicode(c)) {
            String string2 = Character.toString(c);
            string = string2;
            Intrinsics.checkExpressionValueIsNotNull(string2, "Character.toString(c)");
        } else {
            string = "?";
        }
        return string;
    }

    private final boolean isPrintableUnicode(char c) {
        byte t = (byte)Character.getType(c);
        return t != 0 && t != 13 && t != 14 && t != 15 && t != 16 && t != 18 && t != 19;
    }

    public CharValue(char value, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        super(Character.valueOf(value));
        this.type = builtIns.getCharType();
    }
}

