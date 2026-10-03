/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class ForgeChunkManager {
    private static int defaultMaxCount;
    private static int defaultMaxChunks;
    private static boolean overridesEnabled;
    private static Map<World, Multimap<String, Ticket>> tickets;
    private static Map<String, Integer> ticketConstraints;
    private static Map<String, Integer> chunkConstraints;
    private static SetMultimap<String, Ticket> playerTickets;
    private static Map<String, LoadingCallback> callbacks;
    private static Map<World, ImmutableSetMultimap<jjym, Ticket>> forcedChunks;
    private static BiMap<UUID, Ticket> pendingEntities;
    private static Map<World, Cache<Long, Chunk>> dormantChunkCache;
    private static File cfgFile;
    private static Configuration config;
    private static int playerTicketLength;
    private static int dormantChunkCacheSize;
    private static Set<String> warnedMods;

    public static boolean savedWorldHasForcedChunkTickets(File file) {
        File file2 = new File(file, "forcedchunks.dat");
        if (file2.exists() && file2.isFile()) {
            try {
                NBTTagCompound nBTTagCompound = bsvf._a(file2);
                return nBTTagCompound._n("TicketList")._d() > 0;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        return false;
    }

    static void loadWorld(World world) {
        ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();
        tickets.put(world, arrayListMultimap);
        forcedChunks.put(world, ImmutableSetMultimap.of());
        if (!(world instanceof WorldServer)) {
            return;
        }
        dormantChunkCache.put(world, CacheBuilder.newBuilder().maximumSize(dormantChunkCacheSize).build());
        WorldServer worldServer = (WorldServer)world;
        File file = worldServer.getChunkSaveLocation();
        File file2 = new File(file, "forcedchunks.dat");
        if (file2.exists() && file2.isFile()) {
            List<Ticket> list2;
            int n;
            Object object;
            NBTTagCompound nBTTagCompound;
            ArrayListMultimap arrayListMultimap2 = ArrayListMultimap.create();
            HashMap hashMap = Maps.newHashMap();
            try {
                nBTTagCompound = bsvf._a(file2);
            }
            catch (IOException iOException) {
                FMLLog.log(Level.WARNING, iOException, "Unable to read forced chunk data at %s - it will be ignored", file2.getAbsolutePath());
                return;
            }
            NBTTagList nBTTagList = nBTTagCompound._n("TicketList");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound object2 = (NBTTagCompound)nBTTagList._b(i);
                object = object2._j("Owner");
                n = "Forge".equals(object);
                if (n == 0 && !Loader.isModLoaded((String)object)) {
                    FMLLog.warning("Found chunkloading data for mod %s which is currently not available or active - it will be removed from the world save", object);
                    continue;
                }
                if (n == 0 && !callbacks.containsKey(object)) {
                    FMLLog.warning("The mod %s has registered persistent chunkloading data but doesn't seem to want to be called back with it - it will be removed from the world save", object);
                    continue;
                }
                list2 = object2._n("Tickets");
                for (int j = 0; j < ((NBTTagList)((Object)list2))._d(); ++j) {
                    NBTTagCompound nBTTagCompound2 = (NBTTagCompound)((NBTTagList)((Object)list2))._b(j);
                    object = nBTTagCompound2._c("ModId") ? nBTTagCompound2._j("ModId") : object;
                    Type type = Type.values()[nBTTagCompound2._d("Type")];
                    byte by = nBTTagCompound2._d("ChunkListDepth");
                    Ticket ticket = new Ticket((String)object, type, world);
                    if (nBTTagCompound2._c("ModData")) {
                        ticket.modData = nBTTagCompound2._m("ModData");
                    }
                    if (nBTTagCompound2._c("Player")) {
                        ticket.player = nBTTagCompound2._j("Player");
                        if (!hashMap.containsKey(ticket.modId)) {
                            hashMap.put(object, ArrayListMultimap.create());
                        }
                        ((ListMultimap)hashMap.get(ticket.modId)).put(ticket.player, ticket);
                    } else {
                        arrayListMultimap2.put(object, ticket);
                    }
                    if (type != Type.ENTITY) continue;
                    ticket.entityChunkX = nBTTagCompound2._f("chunkX");
                    ticket.entityChunkZ = nBTTagCompound2._f("chunkZ");
                    UUID uUID = new UUID(nBTTagCompound2._g("PersistentIDMSB"), nBTTagCompound2._g("PersistentIDLSB"));
                    pendingEntities.put(uUID, ticket);
                }
            }
            for (Ticket ticket : ImmutableSet.copyOf(pendingEntities.values())) {
                if (ticket.ticketType != Type.ENTITY || ticket.entity != null) continue;
                world.getChunkFromChunkCoords(ticket.entityChunkX, ticket.entityChunkZ);
            }
            for (Ticket ticket : ImmutableSet.copyOf(pendingEntities.values())) {
                if (ticket.ticketType != Type.ENTITY || ticket.entity != null) continue;
                FMLLog.warning("Failed to load persistent chunkloading entity %s from store.", pendingEntities.inverse().get(ticket));
                arrayListMultimap2.remove(ticket.modId, ticket);
            }
            pendingEntities.clear();
            for (String string : arrayListMultimap2.keySet()) {
                object = callbacks.get(string);
                if (object == null) continue;
                n = ForgeChunkManager.getMaxTicketLengthFor(string);
                list2 = arrayListMultimap2.get(string);
                if (object instanceof OrderedLoadingCallback) {
                    OrderedLoadingCallback orderedLoadingCallback = (OrderedLoadingCallback)object;
                    list2 = orderedLoadingCallback.ticketsLoaded(ImmutableList.copyOf(list2), world, n);
                }
                if (list2.size() > n) {
                    FMLLog.warning("The mod %s has too many open chunkloading tickets %d. Excess will be dropped", string, list2.size());
                    list2.subList(n, list2.size()).clear();
                }
                tickets.get(world).putAll(string, list2);
                object.ticketsLoaded(ImmutableList.copyOf(list2), world);
            }
            for (String string : hashMap.keySet()) {
                object = callbacks.get(string);
                if (object == null) continue;
                ListMultimap<String, Ticket> listMultimap = (ListMultimap<String, Ticket>)hashMap.get(string);
                if (object instanceof PlayerOrderedLoadingCallback) {
                    list2 = (PlayerOrderedLoadingCallback)object;
                    listMultimap = list2.playerTicketsLoaded(ImmutableListMultimap.copyOf(listMultimap), world);
                    playerTickets.putAll(listMultimap);
                }
                tickets.get(world).putAll("Forge", listMultimap.values());
                object.ticketsLoaded(ImmutableList.copyOf(listMultimap.values()), world);
            }
        }
    }

    static void unloadWorld(World world) {
        if (!(world instanceof WorldServer)) {
            return;
        }
        forcedChunks.remove(world);
        dormantChunkCache.remove(world);
        if (!MinecraftServer._I()._y()) {
            playerTickets.clear();
            tickets.clear();
        }
    }

    public static void setForcedChunkLoadingCallback(Object object, LoadingCallback loadingCallback) {
        ModContainer modContainer = ForgeChunkManager.getContainer(object);
        if (modContainer == null) {
            FMLLog.warning("Unable to register a callback for an unknown mod %s (%s : %x)", object, object.getClass().getName(), System.identityHashCode(object));
            return;
        }
        callbacks.put(modContainer.getModId(), loadingCallback);
    }

    public static int ticketCountAvailableFor(Object object, World world) {
        ModContainer modContainer = ForgeChunkManager.getContainer(object);
        if (modContainer != null) {
            String string = modContainer.getModId();
            int n = ForgeChunkManager.getMaxTicketLengthFor(string);
            return n - tickets.get(world).get(string).size();
        }
        return 0;
    }

    private static ModContainer getContainer(Object object) {
        ModContainer modContainer = (ModContainer)Loader.instance().getModObjectList().inverse().get(object);
        return modContainer;
    }

    public static int getMaxTicketLengthFor(String string) {
        int n = ticketConstraints.containsKey(string) && overridesEnabled ? ticketConstraints.get(string) : defaultMaxCount;
        return n;
    }

    public static int getMaxChunkDepthFor(String string) {
        int n = chunkConstraints.containsKey(string) && overridesEnabled ? chunkConstraints.get(string) : defaultMaxChunks;
        return n;
    }

    public static int ticketCountAvailableFor(String string) {
        return playerTicketLength - playerTickets.get(string).size();
    }

    public static Ticket requestPlayerTicket(Object object, String string, World world, Type type) {
        ModContainer modContainer = ForgeChunkManager.getContainer(object);
        if (modContainer == null) {
            FMLLog.log(Level.SEVERE, "Failed to locate the container for mod instance %s (%s : %x)", object, object.getClass().getName(), System.identityHashCode(object));
            return null;
        }
        if (playerTickets.get(string).size() > playerTicketLength) {
            FMLLog.warning("Unable to assign further chunkloading tickets to player %s (on behalf of mod %s)", string, modContainer.getModId());
            return null;
        }
        Ticket ticket = new Ticket(modContainer.getModId(), type, world, string);
        playerTickets.put(string, ticket);
        tickets.get(world).put("Forge", ticket);
        return ticket;
    }

    public static Ticket requestTicket(Object object, World world, Type type) {
        int n;
        ModContainer modContainer = ForgeChunkManager.getContainer(object);
        if (modContainer == null) {
            FMLLog.log(Level.SEVERE, "Failed to locate the container for mod instance %s (%s : %x)", object, object.getClass().getName(), System.identityHashCode(object));
            return null;
        }
        String string = modContainer.getModId();
        if (!callbacks.containsKey(string)) {
            FMLLog.severe("The mod %s has attempted to request a ticket without a listener in place", string);
            throw new RuntimeException("Invalid ticket request");
        }
        int n2 = n = ticketConstraints.containsKey(string) ? ticketConstraints.get(string) : defaultMaxCount;
        if (tickets.get(world).get(string).size() >= n) {
            if (!warnedMods.contains(string)) {
                FMLLog.info("The mod %s has attempted to allocate a chunkloading ticket beyond it's currently allocated maximum : %d", string, n);
                warnedMods.add(string);
            }
            return null;
        }
        Ticket ticket = new Ticket(string, type, world);
        tickets.get(world).put(string, ticket);
        return ticket;
    }

    public static void releaseTicket(Ticket ticket) {
        if (ticket == null) {
            return;
        }
        if (ticket.isPlayerTicket() ? !playerTickets.containsValue(ticket) : !tickets.get(ticket.world).containsEntry(ticket.modId, ticket)) {
            return;
        }
        if (ticket.requestedChunks != null) {
            for (jjym jjym2 : ImmutableSet.copyOf(ticket.requestedChunks)) {
                ForgeChunkManager.unforceChunk(ticket, jjym2);
            }
        }
        if (ticket.isPlayerTicket()) {
            playerTickets.remove(ticket.player, ticket);
            tickets.get(ticket.world).remove("Forge", ticket);
        } else {
            tickets.get(ticket.world).remove(ticket.modId, ticket);
        }
    }

    public static void forceChunk(Ticket ticket, jjym jjym2) {
        if (ticket == null || jjym2 == null) {
            return;
        }
        if (ticket.ticketType == Type.ENTITY && ticket.entity == null) {
            throw new RuntimeException("Attempted to use an entity ticket to force a chunk, without an entity");
        }
        if (ticket.isPlayerTicket() ? !playerTickets.containsValue(ticket) : !tickets.get(ticket.world).containsEntry(ticket.modId, ticket)) {
            FMLLog.severe("The mod %s attempted to force load a chunk with an invalid ticket. This is not permitted.", ticket.modId);
            return;
        }
        ticket.requestedChunks.add(jjym2);
        MinecraftForge.EVENT_BUS.post(new ForceChunkEvent(ticket, jjym2));
        ImmutableMultimap immutableMultimap = ((ImmutableSetMultimap.Builder)((ImmutableSetMultimap.Builder)ImmutableSetMultimap.builder().putAll(forcedChunks.get(ticket.world))).put(jjym2, ticket)).build();
        forcedChunks.put(ticket.world, (ImmutableSetMultimap<jjym, Ticket>)immutableMultimap);
        if (ticket.maxDepth > 0 && ticket.requestedChunks.size() > ticket.maxDepth) {
            jjym jjym3 = (jjym)ticket.requestedChunks.iterator().next();
            ForgeChunkManager.unforceChunk(ticket, jjym3);
        }
    }

    public static void reorderChunk(Ticket ticket, jjym jjym2) {
        if (ticket == null || jjym2 == null || !ticket.requestedChunks.contains(jjym2)) {
            return;
        }
        ticket.requestedChunks.remove(jjym2);
        ticket.requestedChunks.add(jjym2);
    }

    public static void unforceChunk(Ticket ticket, jjym jjym2) {
        if (ticket == null || jjym2 == null) {
            return;
        }
        ticket.requestedChunks.remove(jjym2);
        MinecraftForge.EVENT_BUS.post(new UnforceChunkEvent(ticket, jjym2));
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create((Multimap)forcedChunks.get(ticket.world));
        linkedHashMultimap.remove(jjym2, ticket);
        ImmutableSetMultimap immutableSetMultimap = ImmutableSetMultimap.copyOf(linkedHashMultimap);
        forcedChunks.put(ticket.world, immutableSetMultimap);
    }

    static void loadConfiguration() {
        for (String string : config.getCategoryNames()) {
            if (string.equals("Forge") || string.equals("defaults")) continue;
            Property property = config.get(string, "maximumTicketCount", 200);
            Property property2 = config.get(string, "maximumChunksPerTicket", 25);
            ticketConstraints.put(string, property.getInt(200));
            chunkConstraints.put(string, property2.getInt(25));
        }
        if (config.hasChanged()) {
            config.save();
        }
    }

    public static ImmutableSetMultimap<jjym, Ticket> getPersistentChunksFor(World world) {
        return forcedChunks.containsKey(world) ? forcedChunks.get(world) : ImmutableSetMultimap.of();
    }

    static void saveWorld(World world) {
        if (!(world instanceof WorldServer)) {
            return;
        }
        WorldServer worldServer = (WorldServer)world;
        File file = worldServer.getChunkSaveLocation();
        File file2 = new File(file, "forcedchunks.dat");
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        nBTTagCompound._a("TicketList", nBTTagList);
        Multimap<String, Ticket> multimap = tickets.get(worldServer);
        for (String string : multimap.keySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagList._a(nBTTagCompound2);
            nBTTagCompound2._a("Owner", string);
            NBTTagList nBTTagList2 = new NBTTagList();
            nBTTagCompound2._a("Tickets", nBTTagList2);
            for (Ticket ticket : multimap.get(string)) {
                NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
                nBTTagCompound3._a("Type", (byte)ticket.ticketType.ordinal());
                nBTTagCompound3._a("ChunkListDepth", (byte)ticket.maxDepth);
                if (ticket.isPlayerTicket()) {
                    nBTTagCompound3._a("ModId", ticket.modId);
                    nBTTagCompound3._a("Player", ticket.player);
                }
                if (ticket.modData != null) {
                    nBTTagCompound3._a("ModData", ticket.modData);
                }
                if (ticket.ticketType == Type.ENTITY && ticket.entity != null && ticket.entity.writeToNBTOptional(new NBTTagCompound())) {
                    nBTTagCompound3._a("chunkX", sajh._c((double)((Ticket)ticket).entity.chunkCoordX));
                    nBTTagCompound3._a("chunkZ", sajh._c((double)((Ticket)ticket).entity.chunkCoordZ));
                    nBTTagCompound3._a("PersistentIDMSB", ticket.entity.getPersistentID().getMostSignificantBits());
                    nBTTagCompound3._a("PersistentIDLSB", ticket.entity.getPersistentID().getLeastSignificantBits());
                    nBTTagList2._a(nBTTagCompound3);
                    continue;
                }
                if (ticket.ticketType == Type.ENTITY) continue;
                nBTTagList2._a(nBTTagCompound3);
            }
        }
        try {
            bsvf._b(nBTTagCompound, file2);
        }
        catch (IOException iOException) {
            FMLLog.log(Level.WARNING, iOException, "Unable to write forced chunk data to %s - chunkloading won't work", file2.getAbsolutePath());
            return;
        }
    }

    static void loadEntity(Entity entity) {
        UUID uUID = entity.getPersistentID();
        Ticket ticket = (Ticket)pendingEntities.get(uUID);
        if (ticket != null) {
            ticket.bindEntity(entity);
            pendingEntities.remove(uUID);
        }
    }

    public static void putDormantChunk(long l, Chunk chunk) {
        Cache<Long, Chunk> cache = dormantChunkCache.get(chunk._g);
        if (cache != null) {
            cache.put(l, chunk);
        }
    }

    public static Chunk fetchDormantChunk(long l, World world) {
        Cache<Long, Chunk> cache = dormantChunkCache.get(world);
        if (cache == null) {
            return null;
        }
        Chunk chunk = cache.getIfPresent(l);
        if (chunk != null) {
            for (List list2 : chunk._m) {
                for (Entity entity : list2) {
                    entity.resetEntityId();
                }
            }
        }
        return chunk;
    }

    static void captureConfig(File file) {
        Object object;
        cfgFile = new File(file, "forgeChunkLoading.cfg");
        config = new Configuration(cfgFile, true);
        try {
            config.load();
        }
        catch (Exception exception) {
            object = new File(cfgFile.getParentFile(), "forgeChunkLoading.cfg.bak");
            if (((File)object).exists()) {
                ((File)object).delete();
            }
            cfgFile.renameTo((File)object);
            FMLLog.log(Level.SEVERE, exception, "A critical error occured reading the forgeChunkLoading.cfg file, defaults will be used - the invalid file is backed up at forgeChunkLoading.cfg.bak", new Object[0]);
        }
        config.addCustomCategoryComment("defaults", "Default configuration for forge chunk loading control");
        Property property = config.get("defaults", "maximumTicketCount", 200);
        property.comment = "The default maximum ticket count for a mod which does not have an override\nin this file. This is the number of chunk loading requests a mod is allowed to make.";
        defaultMaxCount = property.getInt(200);
        object = config.get("defaults", "maximumChunksPerTicket", 25);
        ((Property)object).comment = "The default maximum number of chunks a mod can force, per ticket, \nfor a mod without an override. This is the maximum number of chunks a single ticket can force.";
        defaultMaxChunks = ((Property)object).getInt(25);
        Property property2 = config.get("defaults", "playerTicketCount", 500);
        property2.comment = "The number of tickets a player can be assigned instead of a mod. This is shared across all mods and it is up to the mods to use it.";
        playerTicketLength = property2.getInt(500);
        Property property3 = config.get("defaults", "dormantChunkCacheSize", 0);
        property3.comment = "Unloaded chunks can first be kept in a dormant cache for quicker\nloading times. Specify the size (in chunks) of that cache here";
        dormantChunkCacheSize = property3.getInt(0);
        FMLLog.info("Configured a dormant chunk cache size of %d", property3.getInt(0));
        Property property4 = config.get("defaults", "enabled", true);
        property4.comment = "Are mod overrides enabled?";
        overridesEnabled = property4.getBoolean(true);
        config.addCustomCategoryComment("Forge", "Sample mod specific control section.\nCopy this section and rename the with the modid for the mod you wish to override.\nA value of zero in either entry effectively disables any chunkloading capabilities\nfor that mod");
        Property property5 = config.get("Forge", "maximumTicketCount", 200);
        property5.comment = "Maximum ticket count for the mod. Zero disables chunkloading capabilities.";
        property5 = config.get("Forge", "maximumChunksPerTicket", 25);
        property5.comment = "Maximum chunks per ticket for the mod.";
        for (String string : config.getCategoryNames()) {
            if (string.equals("Forge") || string.equals("defaults")) continue;
            Property property6 = config.get(string, "maximumTicketCount", 200);
            Property property7 = config.get(string, "maximumChunksPerTicket", 25);
        }
    }

    public static ConfigCategory getConfigFor(Object object) {
        ModContainer modContainer = ForgeChunkManager.getContainer(object);
        if (modContainer != null) {
            return config.getCategory(modContainer.getModId());
        }
        return null;
    }

    public static void addConfigProperty(Object object, String string, String string2, Property.Type type) {
        ModContainer modContainer = ForgeChunkManager.getContainer(object);
        if (modContainer != null) {
            ConfigCategory configCategory = config.getCategory(modContainer.getModId());
            configCategory.put(string, new Property(string, string2, type));
        }
    }

    static {
        tickets = new MapMaker().weakKeys().makeMap();
        ticketConstraints = Maps.newHashMap();
        chunkConstraints = Maps.newHashMap();
        playerTickets = HashMultimap.create();
        callbacks = Maps.newHashMap();
        forcedChunks = new MapMaker().weakKeys().makeMap();
        pendingEntities = HashBiMap.create();
        dormantChunkCache = new MapMaker().weakKeys().makeMap();
        warnedMods = Sets.newHashSet();
    }

    public static class UnforceChunkEvent
    extends Event {
        public final Ticket ticket;
        public final jjym location;
        private static ListenerList LISTENER_LIST;

        public UnforceChunkEvent(Ticket ticket, jjym jjym2) {
            this.ticket = ticket;
            this.location = jjym2;
        }

        public UnforceChunkEvent() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class ForceChunkEvent
    extends Event {
        public final Ticket ticket;
        public final jjym location;
        private static ListenerList LISTENER_LIST;

        public ForceChunkEvent(Ticket ticket, jjym jjym2) {
            this.ticket = ticket;
            this.location = jjym2;
        }

        public ForceChunkEvent() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class Ticket {
        private String modId;
        private Type ticketType;
        private LinkedHashSet<jjym> requestedChunks;
        private NBTTagCompound modData;
        public final World world;
        private int maxDepth;
        private String entityClazz;
        private int entityChunkX;
        private int entityChunkZ;
        private Entity entity;
        private String player;

        Ticket(String string, Type type, World world) {
            this.modId = string;
            this.ticketType = type;
            this.world = world;
            this.maxDepth = ForgeChunkManager.getMaxChunkDepthFor(string);
            this.requestedChunks = Sets.newLinkedHashSet();
        }

        Ticket(String string, Type type, World world, String string2) {
            this(string, type, world);
            if (string2 == null) {
                FMLLog.log(Level.SEVERE, "Attempt to create a player ticket without a valid player", new Object[0]);
                throw new RuntimeException();
            }
            this.player = string2;
        }

        public void setChunkListDepth(int n) {
            if (n > ForgeChunkManager.getMaxChunkDepthFor(this.modId) || n <= 0 && ForgeChunkManager.getMaxChunkDepthFor(this.modId) > 0) {
                FMLLog.warning("The mod %s tried to modify the chunk ticket depth to: %d, its allowed maximum is: %d", this.modId, n, ForgeChunkManager.getMaxChunkDepthFor(this.modId));
            } else {
                this.maxDepth = n;
            }
        }

        public int getChunkListDepth() {
            return this.maxDepth;
        }

        public int getMaxChunkListDepth() {
            return ForgeChunkManager.getMaxChunkDepthFor(this.modId);
        }

        public void bindEntity(Entity entity) {
            if (this.ticketType != Type.ENTITY) {
                throw new RuntimeException("Cannot bind an entity to a non-entity ticket");
            }
            this.entity = entity;
        }

        public NBTTagCompound getModData() {
            if (this.modData == null) {
                this.modData = new NBTTagCompound();
            }
            return this.modData;
        }

        public Entity getEntity() {
            return this.entity;
        }

        public boolean isPlayerTicket() {
            return this.player != null;
        }

        public String getPlayerName() {
            return this.player;
        }

        public String getModId() {
            return this.modId;
        }

        public Type getType() {
            return this.ticketType;
        }

        public ImmutableSet getChunkList() {
            return ImmutableSet.copyOf(this.requestedChunks);
        }
    }

    public static enum Type {
        NORMAL,
        ENTITY;

    }

    public static interface PlayerOrderedLoadingCallback
    extends LoadingCallback {
        public ListMultimap<String, Ticket> playerTicketsLoaded(ListMultimap<String, Ticket> var1, World var2);
    }

    public static interface OrderedLoadingCallback
    extends LoadingCallback {
        public List<Ticket> ticketsLoaded(List<Ticket> var1, World var2, int var3);
    }

    public static interface LoadingCallback {
        public void ticketsLoaded(List<Ticket> var1, World var2);
    }
}

