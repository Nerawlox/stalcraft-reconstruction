/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.minecraftforge.event.EventPriority;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface ForgeSubscribe {
    public EventPriority priority() default EventPriority.NORMAL;

    public boolean receiveCanceled() default false;
}

