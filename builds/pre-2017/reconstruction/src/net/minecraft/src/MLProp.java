/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.src;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
@Deprecated
public @interface MLProp {
    @Deprecated
    public String info() default "";

    @Deprecated
    public double max() default 1.7976931348623157E308;

    @Deprecated
    public double min() default 4.9E-324;

    @Deprecated
    public String name() default "";
}

