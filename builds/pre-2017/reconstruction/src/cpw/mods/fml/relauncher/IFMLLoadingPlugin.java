/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public interface IFMLLoadingPlugin {
    @Deprecated
    public String[] getLibraryRequestClass();

    public String[] getASMTransformerClass();

    public String getModContainerClass();

    public String getSetupClass();

    public void injectData(Map<String, Object> var1);

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface SortingIndex {
        public int value() default 0;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface DependsOn {
        public String[] value() default {};
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface Name {
        public String value() default "";
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface MCVersion {
        public String value() default "";
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface TransformerExclusions {
        public String[] value() default {""};
    }
}

