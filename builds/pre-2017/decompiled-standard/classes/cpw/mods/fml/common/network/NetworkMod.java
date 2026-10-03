/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.ITinyPacketHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface NetworkMod {
    public boolean clientSideRequired() default false;

    public boolean serverSideRequired() default false;

    public String[] channels() default {};

    public String versionBounds() default "";

    public Class<? extends IPacketHandler> packetHandler() default NULL.class;

    public Class<? extends ITinyPacketHandler> tinyPacketHandler() default NULL.class;

    public Class<? extends IConnectionHandler> connectionHandler() default NULL.class;

    public SidedPacketHandler clientPacketHandlerSpec() default @SidedPacketHandler(channels={}, packetHandler=NULL.class);

    public SidedPacketHandler serverPacketHandlerSpec() default @SidedPacketHandler(channels={}, packetHandler=NULL.class);

    public static @interface SidedPacketHandler {
        public String[] channels();

        public Class<? extends IPacketHandler> packetHandler();
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    public static @interface VersionCheckHandler {
    }

    public static interface NULL
    extends IConnectionHandler,
    IPacketHandler,
    ITinyPacketHandler {
    }
}

