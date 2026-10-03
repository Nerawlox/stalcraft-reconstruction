/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import cpw.mods.fml.relauncher.Side;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface SideOnly {
    public Side value();
}

