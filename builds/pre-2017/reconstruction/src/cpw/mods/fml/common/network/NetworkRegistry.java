/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.network.IChatListener;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.mods.asm.NetworkHooks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class NetworkRegistry {
    private static final NetworkRegistry INSTANCE = new NetworkRegistry();
    private Multimap<Player, String> activeChannels = ArrayListMultimap.create();
    private Multimap<String, IPacketHandler> universalPacketHandlers = ArrayListMultimap.create();
    private Multimap<String, IPacketHandler> clientPacketHandlers = ArrayListMultimap.create();
    private Multimap<String, IPacketHandler> serverPacketHandlers = ArrayListMultimap.create();
    private Set<IConnectionHandler> connectionHandlers = Sets.newLinkedHashSet();
    private Map<ModContainer, IGuiHandler> serverGuiHandlers = Maps.newHashMap();
    private Map<ModContainer, IGuiHandler> clientGuiHandlers = Maps.newHashMap();
    private List<IChatListener> chatListeners = Lists.newArrayList();

    public static NetworkRegistry instance() {
        return INSTANCE;
    }

    byte[] getPacketRegistry(Side side) {
        return Joiner.on('\u0000').join(Iterables.concat(Arrays.asList("FML"), this.universalPacketHandlers.keySet(), side.isClient() ? this.clientPacketHandlers.keySet() : this.serverPacketHandlers.keySet())).getBytes(Charsets.UTF_8);
    }

    public boolean isChannelActive(String string, Player player) {
        return this.activeChannels.containsEntry(player, string);
    }

    public void registerChannel(IPacketHandler iPacketHandler, String string) {
        if (Strings.isNullOrEmpty(string) || string != null && string.length() > 16) {
            FMLLog.severe("Invalid channel name '%s' : %s", string, Strings.isNullOrEmpty(string) ? "Channel name is empty" : "Channel name is too long (16 chars is maximum)");
            throw new RuntimeException("Channel name is invalid");
        }
        this.universalPacketHandlers.put(string, iPacketHandler);
    }

    public void registerChannel(IPacketHandler iPacketHandler, String string, Side side) {
        if (side == null) {
            this.registerChannel(iPacketHandler, string);
            return;
        }
        if (Strings.isNullOrEmpty(string) || string != null && string.length() > 16) {
            FMLLog.severe("Invalid channel name '%s' : %s", string, Strings.isNullOrEmpty(string) ? "Channel name is empty" : "Channel name is too long (16 chars is maximum)");
            throw new RuntimeException("Channel name is invalid");
        }
        if (side.isClient()) {
            this.clientPacketHandlers.put(string, iPacketHandler);
        } else {
            this.serverPacketHandlers.put(string, iPacketHandler);
        }
    }

    void activateChannel(Player player, String string) {
        NetworkHooks.activateChannel(this, player, string);
    }

    void deactivateChannel(Player player, String string) {
        this.activeChannels.remove(player, string);
    }

    public void registerConnectionHandler(IConnectionHandler iConnectionHandler) {
        this.connectionHandlers.add(iConnectionHandler);
    }

    public void registerChatListener(IChatListener iChatListener) {
        this.chatListeners.add(iChatListener);
    }

    void playerLoggedIn(EntityPlayerMP entityPlayerMP, NetServerHandler netServerHandler, jjpj jjpj2) {
        this.generateChannelRegistration(entityPlayerMP, netServerHandler, jjpj2);
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.playerLoggedIn(entityPlayerMP, netServerHandler, jjpj2);
        }
    }

    String connectionReceived(yezc yezc2, jjpj jjpj2) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            String string = iConnectionHandler.connectionReceived(yezc2, jjpj2);
            if (Strings.isNullOrEmpty(string)) continue;
            return string;
        }
        return null;
    }

    void connectionOpened(NetHandler netHandler, String string, int n, jjpj jjpj2) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.connectionOpened(netHandler, string, n, jjpj2);
        }
    }

    void connectionOpened(NetHandler netHandler, MinecraftServer minecraftServer, jjpj jjpj2) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.connectionOpened(netHandler, minecraftServer, jjpj2);
        }
    }

    void clientLoggedIn(NetHandler netHandler, jjpj jjpj2, txpf txpf2) {
        this.generateChannelRegistration(netHandler.getPlayer(), netHandler, jjpj2);
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.clientLoggedIn(netHandler, jjpj2, txpf2);
        }
    }

    void connectionClosed(jjpj jjpj2, EntityPlayer entityPlayer) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.connectionClosed(jjpj2);
        }
        this.activeChannels.removeAll(entityPlayer);
    }

    void generateChannelRegistration(EntityPlayer entityPlayer, NetHandler netHandler, jjpj jjpj2) {
        Packet250CustomPayload packet250CustomPayload = new Packet250CustomPayload();
        packet250CustomPayload.channel = "REGISTER";
        packet250CustomPayload.data = this.getPacketRegistry(entityPlayer instanceof EntityPlayerMP ? Side.SERVER : Side.CLIENT);
        packet250CustomPayload.length = packet250CustomPayload.data.length;
        jjpj2._a(packet250CustomPayload);
    }

    void handleCustomPacket(Packet250CustomPayload packet250CustomPayload, jjpj jjpj2, NetHandler netHandler) {
        if ("REGISTER".equals(packet250CustomPayload.channel)) {
            this.handleRegistrationPacket(packet250CustomPayload, netHandler.getPlayer());
        } else if ("UNREGISTER".equals(packet250CustomPayload.channel)) {
            this.handleUnregistrationPacket(packet250CustomPayload, netHandler.getPlayer());
        } else {
            this.handlePacket(packet250CustomPayload, jjpj2, netHandler.getPlayer());
        }
    }

    private void handlePacket(Packet250CustomPayload packet250CustomPayload, jjpj jjpj2, Player player) {
        String string = packet250CustomPayload.channel;
        for (IPacketHandler iPacketHandler : Iterables.concat(this.universalPacketHandlers.get(string), player instanceof EntityPlayerMP ? this.serverPacketHandlers.get(string) : this.clientPacketHandlers.get(string))) {
            iPacketHandler.onPacketData(jjpj2, packet250CustomPayload, player);
        }
    }

    private void handleRegistrationPacket(Packet250CustomPayload packet250CustomPayload, Player player) {
        List<String> list2 = this.extractChannelList(packet250CustomPayload);
        for (String string : list2) {
            this.activateChannel(player, string);
        }
    }

    private void handleUnregistrationPacket(Packet250CustomPayload packet250CustomPayload, Player player) {
        List<String> list2 = this.extractChannelList(packet250CustomPayload);
        for (String string : list2) {
            this.deactivateChannel(player, string);
        }
    }

    private List<String> extractChannelList(Packet250CustomPayload packet250CustomPayload) {
        String string = new String(packet250CustomPayload.data, Charsets.UTF_8);
        ArrayList<String> arrayList = Lists.newArrayList(Splitter.on('\u0000').split(string));
        return arrayList;
    }

    public void registerGuiHandler(Object object, IGuiHandler iGuiHandler) {
        NetworkModHandler networkModHandler;
        ModContainer modContainer = FMLCommonHandler.instance().findContainerFor(object);
        if (modContainer == null) {
            modContainer = Loader.instance().activeModContainer();
            FMLLog.log(Level.WARNING, "Mod %s attempted to register a gui network handler during a construction phase", modContainer.getModId());
        }
        if ((networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(modContainer)) == null) {
            FMLLog.log(Level.FINE, "The mod %s needs to be a @NetworkMod to register a Networked Gui Handler", modContainer.getModId());
        } else {
            this.serverGuiHandlers.put(modContainer, iGuiHandler);
        }
        this.clientGuiHandlers.put(modContainer, iGuiHandler);
    }

    void openRemoteGui(ModContainer modContainer, EntityPlayerMP entityPlayerMP, int n, World world, int n2, int n3, int n4) {
        Container container;
        IGuiHandler iGuiHandler = this.serverGuiHandlers.get(modContainer);
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(modContainer);
        if (iGuiHandler != null && networkModHandler != null && (container = (Container)iGuiHandler.getServerGuiElement(n, entityPlayerMP, world, n2, n3, n4)) != null) {
            entityPlayerMP.func_71117_bO();
            entityPlayerMP.closeContainer();
            int n5 = entityPlayerMP.currentWindowId;
            Packet250CustomPayload packet250CustomPayload = new Packet250CustomPayload();
            packet250CustomPayload.channel = "FML";
            packet250CustomPayload.data = FMLPacket.makePacket(FMLPacket.Type.GUIOPEN, n5, networkModHandler.getNetworkId(), n, n2, n3, n4);
            packet250CustomPayload.length = packet250CustomPayload.data.length;
            entityPlayerMP.playerNetServerHandler.func_72567_b(packet250CustomPayload);
            entityPlayerMP.openContainer = container;
            entityPlayerMP.openContainer.windowId = n5;
            entityPlayerMP.openContainer.func_75132_a(entityPlayerMP);
        }
    }

    void openLocalGui(ModContainer modContainer, EntityPlayer entityPlayer, int n, World world, int n2, int n3, int n4) {
        IGuiHandler iGuiHandler = this.clientGuiHandlers.get(modContainer);
        FMLCommonHandler.instance().showGuiScreen(iGuiHandler.getClientGuiElement(n, entityPlayer, world, n2, n3, n4));
    }

    public Packet3Chat handleChat(NetHandler netHandler, Packet3Chat packet3Chat) {
        Side side = Side.CLIENT;
        if (netHandler instanceof NetServerHandler) {
            side = Side.SERVER;
        }
        for (IChatListener iChatListener : this.chatListeners) {
            packet3Chat = side.isClient() ? iChatListener.clientChat(netHandler, packet3Chat) : iChatListener.serverChat(netHandler, packet3Chat);
        }
        return packet3Chat;
    }

    public void handleTinyPacket(NetHandler netHandler, yexp yexp2) {
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(yexp2._a);
        if (networkModHandler == null) {
            FMLLog.info("Received a tiny packet for network id %d that is not recognised here", yexp2._a);
            return;
        }
        if (networkModHandler.hasTinyPacketHandler()) {
            networkModHandler.getTinyPacketHandler().handle(netHandler, yexp2);
        } else {
            FMLLog.info("Received a tiny packet for a network mod that does not accept tiny packets %s", networkModHandler.getContainer().getModId());
        }
    }
}

