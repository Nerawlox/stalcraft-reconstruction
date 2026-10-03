/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.base.Strings;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.network.FMLNetworkException;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.ITinyPacketHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.InvalidVersionSpecificationException;
import cpw.mods.fml.common.versioning.VersionRange;
import cpw.mods.fml.relauncher.Side;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.logging.Level;

public class NetworkModHandler {
    private static Object connectionHandlerDefaultValue;
    private static Object packetHandlerDefaultValue;
    private static Object clientHandlerDefaultValue;
    private static Object serverHandlerDefaultValue;
    private static Object tinyPacketHandlerDefaultValue;
    private static int assignedIds;
    private int localId;
    private int networkId;
    private ModContainer container;
    private NetworkMod mod;
    private Method checkHandler;
    private VersionRange acceptableRange;
    private ITinyPacketHandler tinyPacketHandler;

    public NetworkModHandler(ModContainer modContainer, NetworkMod networkMod) {
        this.container = modContainer;
        this.mod = networkMod;
        this.networkId = this.localId = assignedIds++;
        if (tgdv.field_77744_bd.field_77779_bT == assignedIds) {
            ++assignedIds;
        }
    }

    public NetworkModHandler(ModContainer modContainer, Class<?> clazz, ASMDataTable aSMDataTable) {
        this(modContainer, clazz.getAnnotation(NetworkMod.class));
        if (this.mod == null) {
            return;
        }
        Set<ASMDataTable.ASMData> set = aSMDataTable.getAnnotationsFor(modContainer).get(NetworkMod.VersionCheckHandler.class.getName());
        String string = null;
        for (ASMDataTable.ASMData aSMData : set) {
            if (!aSMData.getClassName().equals(clazz.getName())) continue;
            string = aSMData.getObjectName();
            string = string.substring(0, string.indexOf(40));
            break;
        }
        if (string != null) {
            try {
                Method method = clazz.getDeclaredMethod(string, String.class);
                if (method.isAnnotationPresent(NetworkMod.VersionCheckHandler.class)) {
                    this.checkHandler = method;
                }
            }
            catch (Exception exception) {
                FMLLog.log(Level.WARNING, exception, "The declared version check handler method %s on network mod id %s is not accessible", string, modContainer.getModId());
            }
        }
        this.configureNetworkMod(modContainer);
    }

    protected void configureNetworkMod(ModContainer modContainer) {
        String string;
        if (this.checkHandler == null && !Strings.isNullOrEmpty(string = this.mod.versionBounds())) {
            try {
                this.acceptableRange = VersionRange.createFromVersionSpec(string);
            }
            catch (InvalidVersionSpecificationException invalidVersionSpecificationException) {
                FMLLog.log(Level.WARNING, invalidVersionSpecificationException, "Invalid bounded range %s specified for network mod id %s", string, modContainer.getModId());
            }
        }
        FMLLog.finest("Testing mod %s to verify it accepts its own version in a remote connection", modContainer.getModId());
        boolean bl = this.acceptVersion(modContainer.getVersion());
        if (!bl) {
            FMLLog.severe("The mod %s appears to reject its own version number (%s) in its version handling. This is likely a severe bug in the mod!", modContainer.getModId(), modContainer.getVersion());
        } else {
            FMLLog.finest("The mod %s accepts its own version (%s)", modContainer.getModId(), modContainer.getVersion());
        }
        this.tryCreatingPacketHandler(modContainer, this.mod.packetHandler(), this.mod.channels(), null);
        if (FMLCommonHandler.instance().getSide().isClient() && this.mod.clientPacketHandlerSpec() != this.getClientHandlerSpecDefaultValue()) {
            this.tryCreatingPacketHandler(modContainer, this.mod.clientPacketHandlerSpec().packetHandler(), this.mod.clientPacketHandlerSpec().channels(), Side.CLIENT);
        }
        if (this.mod.serverPacketHandlerSpec() != this.getServerHandlerSpecDefaultValue()) {
            this.tryCreatingPacketHandler(modContainer, this.mod.serverPacketHandlerSpec().packetHandler(), this.mod.serverPacketHandlerSpec().channels(), Side.SERVER);
        }
        if (this.mod.connectionHandler() != this.getConnectionHandlerDefaultValue()) {
            IConnectionHandler iConnectionHandler;
            try {
                iConnectionHandler = this.mod.connectionHandler().newInstance();
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "Unable to create connection handler instance %s", this.mod.connectionHandler().getName());
                throw new FMLNetworkException(exception);
            }
            NetworkRegistry.instance().registerConnectionHandler(iConnectionHandler);
        }
        if (this.mod.tinyPacketHandler() != this.getTinyPacketHandlerDefaultValue()) {
            try {
                this.tinyPacketHandler = this.mod.tinyPacketHandler().newInstance();
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "Unable to create tiny packet handler instance %s", this.mod.tinyPacketHandler().getName());
                throw new FMLNetworkException(exception);
            }
        }
    }

    private void tryCreatingPacketHandler(ModContainer modContainer, Class<? extends IPacketHandler> clazz, String[] stringArray, Side side) {
        if (side != null && side.isClient() && !FMLCommonHandler.instance().getSide().isClient()) {
            return;
        }
        if (clazz != this.getPacketHandlerDefaultValue()) {
            if (stringArray.length == 0) {
                FMLLog.log(Level.WARNING, "The mod id %s attempted to register a packet handler without specifying channels for it", modContainer.getModId());
            } else {
                IPacketHandler iPacketHandler;
                try {
                    iPacketHandler = clazz.newInstance();
                }
                catch (Exception exception) {
                    FMLLog.log(Level.SEVERE, exception, "Unable to create a packet handler instance %s for mod %s", clazz.getName(), modContainer.getModId());
                    throw new FMLNetworkException(exception);
                }
                for (String string : stringArray) {
                    NetworkRegistry.instance().registerChannel(iPacketHandler, string, side);
                }
            }
        } else if (stringArray.length > 0) {
            FMLLog.warning("The mod id %s attempted to register channels without specifying a packet handler", modContainer.getModId());
        }
    }

    private Object getConnectionHandlerDefaultValue() {
        try {
            if (connectionHandlerDefaultValue == null) {
                connectionHandlerDefaultValue = NetworkMod.class.getMethod("connectionHandler", new Class[0]).getDefaultValue();
            }
            return connectionHandlerDefaultValue;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("Derp?", noSuchMethodException);
        }
    }

    private Object getPacketHandlerDefaultValue() {
        try {
            if (packetHandlerDefaultValue == null) {
                packetHandlerDefaultValue = NetworkMod.class.getMethod("packetHandler", new Class[0]).getDefaultValue();
            }
            return packetHandlerDefaultValue;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("Derp?", noSuchMethodException);
        }
    }

    private Object getTinyPacketHandlerDefaultValue() {
        try {
            if (tinyPacketHandlerDefaultValue == null) {
                tinyPacketHandlerDefaultValue = NetworkMod.class.getMethod("tinyPacketHandler", new Class[0]).getDefaultValue();
            }
            return tinyPacketHandlerDefaultValue;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("Derp?", noSuchMethodException);
        }
    }

    private Object getClientHandlerSpecDefaultValue() {
        try {
            if (clientHandlerDefaultValue == null) {
                clientHandlerDefaultValue = NetworkMod.class.getMethod("clientPacketHandlerSpec", new Class[0]).getDefaultValue();
            }
            return clientHandlerDefaultValue;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("Derp?", noSuchMethodException);
        }
    }

    private Object getServerHandlerSpecDefaultValue() {
        try {
            if (serverHandlerDefaultValue == null) {
                serverHandlerDefaultValue = NetworkMod.class.getMethod("serverPacketHandlerSpec", new Class[0]).getDefaultValue();
            }
            return serverHandlerDefaultValue;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("Derp?", noSuchMethodException);
        }
    }

    public boolean requiresClientSide() {
        return this.mod.clientSideRequired();
    }

    public boolean requiresServerSide() {
        return this.mod.serverSideRequired();
    }

    public boolean acceptVersion(String string) {
        if (this.checkHandler != null) {
            try {
                return (Boolean)this.checkHandler.invoke(this.container.getMod(), string);
            }
            catch (Exception exception) {
                FMLLog.log(Level.WARNING, exception, "There was a problem invoking the checkhandler method %s for network mod id %s", this.checkHandler.getName(), this.container.getModId());
                return false;
            }
        }
        if (this.acceptableRange != null) {
            return this.acceptableRange.containsVersion(new DefaultArtifactVersion(string));
        }
        return this.container.getVersion().equals(string);
    }

    public int getLocalId() {
        return this.localId;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public ModContainer getContainer() {
        return this.container;
    }

    public NetworkMod getMod() {
        return this.mod;
    }

    public boolean isNetworkMod() {
        return this.mod != null;
    }

    public void setNetworkId(int n) {
        this.networkId = n;
    }

    public boolean hasTinyPacketHandler() {
        return this.tinyPacketHandler != null;
    }

    public ITinyPacketHandler getTinyPacketHandler() {
        return this.tinyPacketHandler;
    }

    static {
        assignedIds = 1;
    }
}

