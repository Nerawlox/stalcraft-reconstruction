/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface SidedProxy {
    public String clientSide() default "";

    public String serverSide() default "";

    @Deprecated
    public String bukkitSide() default "";

    public String modId() default "";
}

