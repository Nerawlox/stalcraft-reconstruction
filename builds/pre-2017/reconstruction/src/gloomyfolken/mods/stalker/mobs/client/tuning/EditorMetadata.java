/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface EditorMetadata {
    public String name() default "[unassigned]";

    public String type() default "";
}

