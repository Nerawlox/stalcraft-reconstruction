/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.minecraft.item.ItemBlock;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface Mod {
    public String modid();

    public String name() default "";

    public String version() default "";

    public String dependencies() default "";

    public boolean useMetadata() default false;

    public String acceptedMinecraftVersions() default "";

    public String bukkitPlugin() default "";

    @Deprecated
    public String modExclusionList() default "";

    public String certificateFingerprint() default "";

    public String modLanguage() default "java";

    @Deprecated
    public String asmHookClass() default "";

    public CustomProperty[] customProperties() default {};

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    public static @interface InstanceFactory {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    @Deprecated
    public static @interface Item {
        public String name();

        public String typeClass();
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    @Deprecated
    public static @interface Block {
        public String name();

        public Class<?> itemTypeClass() default ItemBlock.class;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface Metadata {
        public String value() default "";
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface Instance {
        public String value() default "";
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface IMCCallback {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface ServerStopped {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface ServerStopping {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface ServerStarted {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface ServerStarting {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface ServerAboutToStart {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface PostInit {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface Init {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface PreInit {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    @Deprecated
    public static @interface FingerprintWarning {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    public static @interface EventHandler {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={})
    public static @interface CustomProperty {
        public String k();

        public String v();
    }
}

