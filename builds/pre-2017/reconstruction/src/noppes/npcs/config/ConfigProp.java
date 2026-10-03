/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface ConfigProp {
    public String name() default "";

    public String info() default "";
}

