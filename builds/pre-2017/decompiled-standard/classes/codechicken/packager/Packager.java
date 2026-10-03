/*
 * Decompiled with CFR 0.152.
 */
package codechicken.packager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface Packager {
    public String getName() default "@Mod";

    public String getVersion() default "@Mod";

    public String[] getClasses() default {""};

    public String[] getBaseDirectories();

    public String[] getForcedClasses() default {""};

    public String getManifest() default "/";

    public String getModInfo() default "/";
}

