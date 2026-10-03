/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.InjectedModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;

public class FMLNetworkHandler {
    private static final int FML_HASH = Hashing.murmur3_32().hashString("FML").asInt();
    private static final int PROTOCOL_VERSION = 2;
    private static final FMLNetworkHandler INSTANCE = new FMLNetworkHandler();
    static final int LOGIN_RECEIVED = 1;
    static final int CONNECTION_VALID = 2;
    static final int FML_OUT_OF_DATE = -1;
    static final int MISSING_MODS_OR_VERSIONS = -2;
    private Map<yezc, Integer> loginStates = Maps.newHashMap();
    private Map<ModContainer, NetworkModHandler> networkModHandlers = Maps.newHashMap();
    private Map<Integer, NetworkModHandler> networkIdLookup = Maps.newHashMap();

    public static void handlePacket250Packet(Packet250CustomPayload packet250CustomPayload, jjpj jjpj2, NetHandler netHandler) {
        String string = packet250CustomPayload.channel;
        if (string.startsWith("MC|")) {
            netHandler.handleVanilla250Packet(packet250CustomPayload);
        }
        if (string.equals("FML")) {
            FMLNetworkHandler.instance().handleFMLPacket(packet250CustomPayload, jjpj2, netHandler);
        } else {
            NetworkRegistry.instance().handleCustomPacket(packet250CustomPayload, jjpj2, netHandler);
        }
    }

    public static void onConnectionEstablishedToServer(NetHandler netHandler, jjpj jjpj2, txpf txpf2) {
        NetworkRegistry.instance().clientLoggedIn(netHandler, jjpj2, txpf2);
    }

    private void handleFMLPacket(Packet250CustomPayload packet250CustomPayload, jjpj jjpj2, NetHandler netHandler) {
        FMLPacket fMLPacket = FMLPacket.readPacket(jjpj2, packet250CustomPayload.data);
        if (fMLPacket == null) {
            return;
        }
        String string = "";
        if (netHandler instanceof yezc) {
            string = ((yezc)netHandler)._g;
        } else {
            EntityPlayer entityPlayer = netHandler.getPlayer();
            if (entityPlayer != null) {
                string = entityPlayer.getCommandSenderName();
            }
        }
        fMLPacket.execute(jjpj2, this, netHandler, string);
    }

    public static void onConnectionReceivedFromClient(yezc yezc2, MinecraftServer minecraftServer, SocketAddress socketAddress, String string) {
        FMLNetworkHandler.instance().handleClientConnection(yezc2, minecraftServer, socketAddress, string);
    }

    private void handleClientConnection(yezc yezc2, MinecraftServer minecraftServer, SocketAddress socketAddress, String string) {
        if (!this.loginStates.containsKey(yezc2)) {
            if (this.handleVanillaLoginKick(yezc2, minecraftServer, socketAddress, string)) {
                FMLLog.fine("Connection from %s rejected - no FML packet received from client", string);
                yezc2._b("You don't have FML installed, you cannot connect to this server");
                return;
            }
            FMLLog.fine("Connection from %s was closed by vanilla minecraft", string);
            return;
        }
        switch (this.loginStates.get(yezc2)) {
            case 1: {
                String string2 = NetworkRegistry.instance().connectionReceived(yezc2, yezc2._d);
                if (string2 != null) {
                    yezc2._b(string2);
                    this.loginStates.remove(yezc2);
                    return;
                }
                if (!this.handleVanillaLoginKick(yezc2, minecraftServer, socketAddress, string)) {
                    this.loginStates.remove(yezc2);
                    return;
                }
                yezc._a(yezc2, false);
                yezc2._d._a(this.getModListRequestPacket());
                this.loginStates.put(yezc2, 2);
                break;
            }
            case 2: {
                yezc2._b(null);
                this.loginStates.remove(yezc2);
                break;
            }
            case -2: {
                yezc2._b("The server requires mods that are absent or out of date on your client");
                this.loginStates.remove(yezc2);
                break;
            }
            case -1: {
                yezc2._b("Your client is not running a new enough version of FML to connect to this server");
                this.loginStates.remove(yezc2);
                break;
            }
            default: {
                yezc2._b("There was a problem during FML negotiation");
                this.loginStates.remove(yezc2);
            }
        }
    }

    private boolean handleVanillaLoginKick(yezc yezc2, MinecraftServer minecraftServer, SocketAddress socketAddress, String string) {
        ozhc ozhc2 = minecraftServer.__ag();
        String string2 = ozhc2._a(socketAddress, string);
        if (string2 != null) {
            yezc2._b(string2);
        }
        return string2 == null;
    }

    public static void handleLoginPacketOnServer(yezc yezc2, txpf txpf2) {
        if (txpf2._a == FML_HASH) {
            if (txpf2._e == 2) {
                FMLLog.finest("Received valid FML login packet from %s", yezc2._d._c());
                FMLNetworkHandler.instance().loginStates.put(yezc2, 1);
            } else if (txpf2._e != 2) {
                FMLLog.finest("Received incorrect FML (%x) login packet from %s", txpf2._e, yezc2._d._c());
                FMLNetworkHandler.instance().loginStates.put(yezc2, -1);
            }
        } else {
            FMLLog.fine("Received invalid login packet (%x, %x) from %s", txpf2._a, txpf2._e, yezc2._d._c());
        }
    }

    static void setHandlerState(yezc yezc2, int n) {
        FMLNetworkHandler.instance().loginStates.put(yezc2, n);
    }

    public static FMLNetworkHandler instance() {
        return INSTANCE;
    }

    public static txpf getFMLFakeLoginPacket() {
        FMLCommonHandler.instance().getSidedDelegate().setClientCompatibilityLevel((byte)0);
        txpf txpf2 = new txpf();
        txpf2._a = FML_HASH;
        txpf2._e = 2;
        txpf2._d = EnumGameType._a;
        txpf2._b = nwix._c[0];
        return txpf2;
    }

    public Packet250CustomPayload getModListRequestPacket() {
        return PacketDispatcher.getPacket("FML", FMLPacket.makePacket(FMLPacket.Type.MOD_LIST_REQUEST, new Object[0]));
    }

    public void registerNetworkMod(NetworkModHandler networkModHandler) {
        this.networkModHandlers.put(networkModHandler.getContainer(), networkModHandler);
        this.networkIdLookup.put(networkModHandler.getNetworkId(), networkModHandler);
    }

    public boolean registerNetworkMod(ModContainer modContainer, Class<?> clazz, ASMDataTable aSMDataTable) {
        NetworkModHandler networkModHandler = new NetworkModHandler(modContainer, clazz, aSMDataTable);
        if (networkModHandler.isNetworkMod()) {
            this.registerNetworkMod(networkModHandler);
        }
        return networkModHandler.isNetworkMod();
    }

    public NetworkModHandler findNetworkModHandler(Object object) {
        if (object instanceof InjectedModContainer) {
            return this.networkModHandlers.get(((InjectedModContainer)object).wrappedContainer);
        }
        if (object instanceof ModContainer) {
            return this.networkModHandlers.get(object);
        }
        if (object instanceof Integer) {
            return this.networkIdLookup.get(object);
        }
        return this.networkModHandlers.get(FMLCommonHandler.instance().findContainerFor(object));
    }

    public Set<ModContainer> getNetworkModList() {
        return this.networkModHandlers.keySet();
    }

    public static void handlePlayerLogin(EntityPlayerMP entityPlayerMP, NetServerHandler netServerHandler, jjpj jjpj2) {
        NetworkRegistry.instance().playerLoggedIn(entityPlayerMP, netServerHandler, jjpj2);
        GameRegistry.onPlayerLogin(entityPlayerMP);
    }

    public Map<Integer, NetworkModHandler> getNetworkIdMap() {
        return this.networkIdLookup;
    }

    public void bindNetworkId(String string, Integer n) {
        Map<String, ModContainer> map = Loader.instance().getIndexedModList();
        NetworkModHandler networkModHandler = this.findNetworkModHandler(map.get(string));
        if (networkModHandler != null) {
            networkModHandler.setNetworkId(n);
            this.networkIdLookup.put(n, networkModHandler);
        }
    }

    public static void onClientConnectionToRemoteServer(NetHandler netHandler, String string, int n, jjpj jjpj2) {
        NetworkRegistry.instance().connectionOpened(netHandler, string, n, jjpj2);
    }

    public static void onClientConnectionToIntegratedServer(NetHandler netHandler, MinecraftServer minecraftServer, jjpj jjpj2) {
        NetworkRegistry.instance().connectionOpened(netHandler, minecraftServer, jjpj2);
    }

    public static void onConnectionClosed(jjpj jjpj2, EntityPlayer entityPlayer) {
        NetworkRegistry.instance().connectionClosed(jjpj2, entityPlayer);
    }

    public static void openGui(EntityPlayer entityPlayer, Object object, int n, World world, int n2, int n3, int n4) {
        ModContainer modContainer = FMLCommonHandler.instance().findContainerFor(object);
        if (modContainer == null) {
            NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(object);
            if (networkModHandler != null) {
                modContainer = networkModHandler.getContainer();
            } else {
                FMLLog.warning("A mod tried to open a gui on the server without being a NetworkMod", new Object[0]);
                return;
            }
        }
        if (entityPlayer instanceof EntityPlayerMP) {
            NetworkRegistry.instance().openRemoteGui(modContainer, (EntityPlayerMP)entityPlayer, n, world, n2, n3, n4);
        } else if (FMLCommonHandler.instance().getSide().equals((Object)Side.CLIENT)) {
            NetworkRegistry.instance().openLocalGui(modContainer, entityPlayer, n, world, n2, n3, n4);
        } else {
            FMLLog.fine("Invalid attempt to open a local GUI on a dedicated server. This is likely a bug. GUIID: %s,%d", modContainer.getModId(), n);
        }
    }

    public static Packet getEntitySpawningPacket(Entity entity) {
        EntityRegistry.EntityRegistration entityRegistration = EntityRegistry.instance().lookupModSpawn(entity.getClass(), false);
        if (entityRegistration == null) {
            return null;
        }
        if (entityRegistration.usesVanillaSpawning()) {
            return null;
        }
        return PacketDispatcher.getPacket("FML", FMLPacket.makePacket(FMLPacket.Type.ENTITYSPAWN, entityRegistration, entity, FMLNetworkHandler.instance().findNetworkModHandler(entityRegistration.getContainer())));
    }

    public static void makeEntitySpawnAdjustment(int n, EntityPlayerMP entityPlayerMP, int n2, int n3, int n4) {
        Packet250CustomPayload packet250CustomPayload = PacketDispatcher.getPacket("FML", FMLPacket.makePacket(FMLPacket.Type.ENTITYSPAWNADJUSTMENT, n, n2, n3, n4));
        entityPlayerMP.playerNetServerHandler.func_72567_b(packet250CustomPayload);
    }

    public static InetAddress computeLocalHost() throws IOException {
        InetAddress object = null;
        ArrayList<InetAddress> arrayList = Lists.newArrayList();
        InetAddress inetAddress = InetAddress.getLocalHost();
        for (NetworkInterface object2 : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            if (object2.isLoopback() || !object2.isUp()) continue;
            arrayList.addAll(Collections.list(object2.getInetAddresses()));
            if (!arrayList.contains(inetAddress)) continue;
            object = inetAddress;
            break;
        }
        if (object == null && !arrayList.isEmpty()) {
            for (InetAddress inetAddress2 : arrayList) {
                if (inetAddress2.getAddress().length != 4) continue;
                object = inetAddress2;
                break;
            }
        }
        if (object == null) {
            object = inetAddress;
        }
        return object;
    }

    public static Packet3Chat handleChatMessage(NetHandler netHandler, Packet3Chat packet3Chat) {
        return NetworkRegistry.instance().handleChat(netHandler, packet3Chat);
    }

    public static void handlePacket131Packet(NetHandler netHandler, yexp yexp2) {
        if (netHandler instanceof NetServerHandler || yexp2._a != Item.map.itemID) {
            NetworkRegistry.instance().handleTinyPacket(netHandler, yexp2);
        } else {
            FMLCommonHandler.instance().handleTinyPacket(netHandler, yexp2);
        }
    }

    public static int getCompatibilityLevel() {
        return 2;
    }

    public static boolean vanillaLoginPacketCompatibility() {
        return FMLCommonHandler.instance().getSidedDelegate().getClientCompatibilityLevel() == 0;
    }
}

