/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD})
public @interface Hook {
    public ReturnCondition returnCondition() default ReturnCondition.NEVER;

    public HookPriority priority() default HookPriority.NORMAL;

    public String targetMethod() default "";

    public String returnType() default "";

    public boolean createMethod() default false;

    public boolean injectOnExit() default false;

    @Deprecated
    public int injectOnLine() default -1;

    public String returnAnotherMethod() default "";

    public boolean returnNull() default false;

    public boolean booleanReturnConstant() default false;

    public byte byteReturnConstant() default 0;

    public short shortReturnConstant() default 0;

    public int intReturnConstant() default 0;

    public long longReturnConstant() default 0L;

    public float floatReturnConstant() default 0.0f;

    public double doubleReturnConstant() default 0.0;

    public char charReturnConstant() default 0;

    public String stringReturnConstant() default "";

    @Target(value={ElementType.PARAMETER})
    public static @interface ReturnValue {
    }

    @Target(value={ElementType.PARAMETER})
    public static @interface LocalVariable {
        public int value();
    }
}

