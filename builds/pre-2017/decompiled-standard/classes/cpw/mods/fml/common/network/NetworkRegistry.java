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

    void playerLoggedIn(EntityPlayerMP entityPlayerMP, xbvu xbvu2, jjpj jjpj2) {
        this.generateChannelRegistration(entityPlayerMP, xbvu2, jjpj2);
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.playerLoggedIn(entityPlayerMP, xbvu2, jjpj2);
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

    void connectionOpened(elai elai2, String string, int n, jjpj jjpj2) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.connectionOpened(elai2, string, n, jjpj2);
        }
    }

    void connectionOpened(elai elai2, dzfd dzfd2, jjpj jjpj2) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.connectionOpened(elai2, dzfd2, jjpj2);
        }
    }

    void clientLoggedIn(elai elai2, jjpj jjpj2, txpf txpf2) {
        this.generateChannelRegistration(elai2.getPlayer(), elai2, jjpj2);
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.clientLoggedIn(elai2, jjpj2, txpf2);
        }
    }

    void connectionClosed(jjpj jjpj2, EntityPlayer entityPlayer) {
        for (IConnectionHandler iConnectionHandler : this.connectionHandlers) {
            iConnectionHandler.connectionClosed(jjpj2);
        }
        this.activeChannels.removeAll(entityPlayer);
    }

    void generateChannelRegistration(EntityPlayer entityPlayer, elai elai2, jjpj jjpj2) {
        jjqf jjqf2 = new jjqf();
        jjqf2.field_73630_a = "REGISTER";
        jjqf2.field_73629_c = this.getPacketRegistry(entityPlayer instanceof EntityPlayerMP ? Side.SERVER : Side.CLIENT);
        jjqf2.field_73628_b = jjqf2.field_73629_c.length;
        jjpj2._a(jjqf2);
    }

    void handleCustomPacket(jjqf jjqf2, jjpj jjpj2, elai elai2) {
        if ("REGISTER".equals(jjqf2.field_73630_a)) {
            this.handleRegistrationPacket(jjqf2, elai2.getPlayer());
        } else if ("UNREGISTER".equals(jjqf2.field_73630_a)) {
            this.handleUnregistrationPacket(jjqf2, elai2.getPlayer());
        } else {
            this.handlePacket(jjqf2, jjpj2, elai2.getPlayer());
        }
    }

    private void handlePacket(jjqf jjqf2, jjpj jjpj2, Player player) {
        String string = jjqf2.field_73630_a;
        for (IPacketHandler iPacketHandler : Iterables.concat(this.universalPacketHandlers.get(string), player instanceof EntityPlayerMP ? this.serverPacketHandlers.get(string) : this.clientPacketHandlers.get(string))) {
            iPacketHandler.onPacketData(jjpj2, jjqf2, player);
        }
    }

    private void handleRegistrationPacket(jjqf jjqf2, Player player) {
        List<String> list2 = this.extractChannelList(jjqf2);
        for (String string : list2) {
            this.activateChannel(player, string);
        }
    }

    private void handleUnregistrationPacket(jjqf jjqf2, Player player) {
        List<String> list2 = this.extractChannelList(jjqf2);
        for (String string : list2) {
            this.deactivateChannel(player, string);
        }
    }

    private List<String> extractChannelList(jjqf jjqf2) {
        String string = new String(jjqf2.field_73629_c, Charsets.UTF_8);
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

    void openRemoteGui(ModContainer modContainer, EntityPlayerMP entityPlayerMP, int n, ozlu ozlu2, int n2, int n3, int n4) {
        jjgc jjgc2;
        IGuiHandler iGuiHandler = this.serverGuiHandlers.get(modContainer);
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(modContainer);
        if (iGuiHandler != null && networkModHandler != null && (jjgc2 = (jjgc)iGuiHandler.getServerGuiElement(n, entityPlayerMP, ozlu2, n2, n3, n4)) != null) {
            entityPlayerMP.func_71117_bO();
            entityPlayerMP.func_71128_l();
            int n5 = entityPlayerMP.field_71139_cq;
            jjqf jjqf2 = new jjqf();
            jjqf2.field_73630_a = "FML";
            jjqf2.field_73629_c = FMLPacket.makePacket(FMLPacket.Type.GUIOPEN, n5, networkModHandler.getNetworkId(), n, n2, n3, n4);
            jjqf2.field_73628_b = jjqf2.field_73629_c.length;
            entityPlayerMP.field_71135_a.func_72567_b(jjqf2);
            entityPlayerMP.field_71070_bA = jjgc2;
            entityPlayerMP.field_71070_bA.field_75152_c = n5;
            entityPlayerMP.field_71070_bA.func_75132_a(entityPlayerMP);
        }
    }

    void openLocalGui(ModContainer modContainer, EntityPlayer entityPlayer, int n, ozlu ozlu2, int n2, int n3, int n4) {
        IGuiHandler iGuiHandler = this.clientGuiHandlers.get(modContainer);
        FMLCommonHandler.instance().showGuiScreen(iGuiHandler.getClientGuiElement(n, entityPlayer, ozlu2, n2, n3, n4));
    }

    public cwaz handleChat(elai elai2, cwaz cwaz2) {
        Side side = Side.CLIENT;
        if (elai2 instanceof xbvu) {
            side = Side.SERVER;
        }
        for (IChatListener iChatListener : this.chatListeners) {
            cwaz2 = side.isClient() ? iChatListener.clientChat(elai2, cwaz2) : iChatListener.serverChat(elai2, cwaz2);
        }
        return cwaz2;
    }

    public void handleTinyPacket(elai elai2, yexp yexp2) {
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(yexp2._a);
        if (networkModHandler == null) {
            FMLLog.info("Received a tiny packet for network id %d that is not recognised here", yexp2._a);
            return;
        }
        if (networkModHandler.hasTinyPacketHandler()) {
            networkModHandler.getTinyPacketHandler().handle(elai2, yexp2);
        } else {
            FMLLog.info("Received a tiny packet for a network mod that does not accept tiny packets %s", networkModHandler.getContainer().getModId());
        }
    }
}

