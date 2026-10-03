/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;
import net.minecraft.server.management.BanList;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.demo.DemoWorldManager;

public abstract class ozhc {
    public static final SimpleDateFormat _c = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public final MinecraftServer _d;
    public final List _e = new ArrayList();
    public final BanList _f = new BanList(new File("banned-players.txt"));
    public final BanList _g = new BanList(new File("banned-ips.txt"));
    public Set _h = new HashSet();
    public Set _i = new HashSet();
    public lqjs _j;
    public boolean _k;
    public int _l;
    public int _m;
    public EnumGameType _n;
    public boolean _o;
    public int _p;

    public ozhc(MinecraftServer minecraftServer) {
        this._d = minecraftServer;
        this._f._a(false);
        this._g._a(false);
        this._l = 8;
    }

    public void _a(jjpj jjpj2, EntityPlayerMP entityPlayerMP) {
        Object object2;
        NBTTagCompound nBTTagCompound = this._b(entityPlayerMP);
        entityPlayerMP.setWorld(this._d._a(entityPlayerMP.dimension));
        entityPlayerMP.theItemInWorldManager._a((WorldServer)entityPlayerMP.worldObj);
        String string = "local";
        if (jjpj2._c() != null) {
            string = jjpj2._c().toString();
        }
        this._d._O()._a(entityPlayerMP.getCommandSenderName() + "[" + string + "] logged in with entity id " + entityPlayerMP.entityId + " at (" + entityPlayerMP.posX + ", " + entityPlayerMP.posY + ", " + entityPlayerMP.posZ + ")");
        WorldServer worldServer = this._d._a(entityPlayerMP.dimension);
        ChunkCoordinates chunkCoordinates = worldServer.getSpawnPoint();
        this._a(entityPlayerMP, null, worldServer);
        NetServerHandler netServerHandler = new NetServerHandler(this._d, jjpj2, entityPlayerMP);
        netServerHandler.func_72567_b(new txpf(entityPlayerMP.entityId, worldServer.getWorldInfo()._u(), entityPlayerMP.theItemInWorldManager._a(), worldServer.getWorldInfo()._t(), worldServer.provider._i, worldServer.difficultySetting, worldServer.getHeight(), this._r()));
        netServerHandler.func_72567_b(new Packet250CustomPayload("MC|Brand", this._g()._H().getBytes(Charsets.UTF_8)));
        netServerHandler.func_72567_b(new xbzt(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c));
        netServerHandler.func_72567_b(new Packet202PlayerAbilities(entityPlayerMP.capabilities));
        netServerHandler.func_72567_b(new Packet16BlockItemSwitch(entityPlayerMP.inventory._c));
        this._a((ServerScoreboard)worldServer.getScoreboard(), entityPlayerMP);
        this._b(entityPlayerMP, worldServer);
        this._a(ChatMessageComponent._b("multiplayer.player.joined", entityPlayerMP.getTranslatedEntityName())._a(EnumChatFormatting._o));
        this._c(entityPlayerMP);
        netServerHandler.setPlayerLocation(entityPlayerMP.posX, entityPlayerMP.posY, entityPlayerMP.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
        this._d.__ah()._a(netServerHandler);
        netServerHandler.func_72567_b(new rrld(worldServer.getTotalWorldTime(), worldServer.getWorldTime(), worldServer.getGameRules()._b("doDaylightCycle")));
        if (this._d._U().length() > 0) {
            entityPlayerMP.requestTexturePackLoad(this._d._U(), this._d._V());
        }
        for (Object object2 : entityPlayerMP.getActivePotionEffects()) {
            netServerHandler.func_72567_b(new cwaw(entityPlayerMP.entityId, (PotionEffect)object2));
        }
        entityPlayerMP.addSelfToInternalCraftingInventory();
        FMLNetworkHandler.handlePlayerLogin(entityPlayerMP, netServerHandler, jjpj2);
        if (nBTTagCompound != null && nBTTagCompound._c("Riding") && (object2 = jgro._a(nBTTagCompound._m("Riding"), (World)worldServer)) != null) {
            ((Entity)object2).forceSpawn = true;
            worldServer.spawnEntityInWorld((Entity)object2);
            entityPlayerMP.mountEntity((Entity)object2);
            ((Entity)object2).forceSpawn = false;
        }
    }

    public void _a(ServerScoreboard serverScoreboard, EntityPlayerMP entityPlayerMP) {
        HashSet<ScoreObjective> hashSet = new HashSet<ScoreObjective>();
        for (ScorePlayerTeam scorePlayerTeam : serverScoreboard._e()) {
            entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet209SetPlayerTeam(scorePlayerTeam, 0));
        }
        for (int i = 0; i < 3; ++i) {
            ScoreObjective scoreObjective = serverScoreboard._a(i);
            if (scoreObjective == null || hashSet.contains(scoreObjective)) continue;
            List list = serverScoreboard._f(scoreObjective);
            for (Packet packet : list) {
                entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
            }
            hashSet.add(scoreObjective);
        }
    }

    public void _a(WorldServer[] worldServerArray) {
        this._j = worldServerArray[0].getSaveHandler().func_75756_e();
    }

    public void _a(EntityPlayerMP entityPlayerMP, WorldServer worldServer) {
        WorldServer worldServer2 = entityPlayerMP.getServerForPlayer();
        if (worldServer != null) {
            worldServer.getPlayerManager()._c(entityPlayerMP);
        }
        worldServer2.getPlayerManager()._a(entityPlayerMP);
        worldServer2.theChunkProviderServer._a((int)entityPlayerMP.posX >> 4, (int)entityPlayerMP.posZ >> 4);
    }

    public int _h() {
        return PlayerManager._a(this._u());
    }

    public NBTTagCompound _b(EntityPlayerMP entityPlayerMP) {
        NBTTagCompound nBTTagCompound;
        NBTTagCompound nBTTagCompound2 = this._d._j[0].getWorldInfo()._i();
        if (entityPlayerMP.getCommandSenderName().equals(this._d._M()) && nBTTagCompound2 != null) {
            entityPlayerMP.readFromNBT(nBTTagCompound2);
            nBTTagCompound = nBTTagCompound2;
            System.out.println("loading single player");
        } else {
            nBTTagCompound = this._j._b(entityPlayerMP);
        }
        return nBTTagCompound;
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        this._j._a(entityPlayerMP);
    }

    public void _c(EntityPlayerMP entityPlayerMP) {
        this._a(new bbzw(entityPlayerMP.getCommandSenderName(), true, 1000));
        this._e.add(entityPlayerMP);
        WorldServer worldServer = this._d._a(entityPlayerMP.dimension);
        worldServer.spawnEntityInWorld(entityPlayerMP);
        this._a(entityPlayerMP, (WorldServer)null);
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP2 = (EntityPlayerMP)this._e.get(i);
            entityPlayerMP.playerNetServerHandler.func_72567_b(new bbzw(entityPlayerMP2.getCommandSenderName(), true, entityPlayerMP2.ping));
        }
    }

    public void _d(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.getServerForPlayer().getPlayerManager()._d(entityPlayerMP);
    }

    public void _e(EntityPlayerMP entityPlayerMP) {
        GameRegistry.onPlayerLogout(entityPlayerMP);
        WorldServer worldServer = entityPlayerMP.getServerForPlayer();
        if (entityPlayerMP.ridingEntity != null) {
            worldServer.removePlayerEntityDangerously(entityPlayerMP.ridingEntity);
            System.out.println("removing player mount");
        }
        worldServer.getPlayerManager()._c(entityPlayerMP);
        this._e.remove(entityPlayerMP);
        this._a(new bbzw(entityPlayerMP.getCommandSenderName(), false, 9999));
    }

    public String _a(SocketAddress socketAddress, String string) {
        if (this._f._a(string)) {
            BanEntry banEntry = (BanEntry)this._f._b().get(string);
            String string2 = "You are banned from this server!\nReason: " + banEntry._f();
            if (banEntry._d() != null) {
                string2 = string2 + "\nYour ban will be removed on " + _c.format(banEntry._d());
            }
            return string2;
        }
        if (!this._e(string)) {
            return "You are not white-listed on this server!";
        }
        String string3 = socketAddress.toString();
        string3 = string3.substring(string3.indexOf("/") + 1);
        if (this._g._a(string3 = string3.substring(0, string3.indexOf(":")))) {
            BanEntry banEntry = (BanEntry)this._g._b().get(string3);
            String string4 = "Your IP address is banned from this server!\nReason: " + banEntry._f();
            if (banEntry._d() != null) {
                string4 = string4 + "\nYour ban will be removed on " + _c.format(banEntry._d());
            }
            return string4;
        }
        return this._e.size() >= this._l ? "The server is full!" : null;
    }

    public EntityPlayerMP _f(String string) {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (!entityPlayerMP.getCommandSenderName().equalsIgnoreCase(string)) continue;
            arrayList.add(entityPlayerMP);
        }
        for (EntityPlayerMP entityPlayerMP : arrayList) {
            entityPlayerMP.playerNetServerHandler.func_72565_c("You logged in from another location");
        }
        ItemInWorldManager itemInWorldManager = this._d._R() ? new DemoWorldManager(this._d._a(0)) : new ItemInWorldManager(this._d._a(0));
        return new EntityPlayerMP(this._d, this._d._a(0), string, itemInWorldManager);
    }

    public EntityPlayerMP _a(EntityPlayerMP entityPlayerMP, int n, boolean bl) {
        ChunkCoordinates chunkCoordinates;
        WorldServer worldServer = this._d._a(n);
        if (worldServer == null) {
            n = 0;
        } else if (!worldServer.provider._e()) {
            n = worldServer.provider._a(entityPlayerMP);
        }
        entityPlayerMP.getServerForPlayer().getEntityTracker()._a(entityPlayerMP);
        entityPlayerMP.getServerForPlayer().getEntityTracker()._b(entityPlayerMP);
        entityPlayerMP.getServerForPlayer().getPlayerManager()._c(entityPlayerMP);
        this._e.remove(entityPlayerMP);
        this._d._a(entityPlayerMP.dimension).removePlayerEntityDangerously(entityPlayerMP);
        ChunkCoordinates chunkCoordinates2 = entityPlayerMP.getBedLocation(n);
        boolean bl2 = entityPlayerMP.isSpawnForced(n);
        entityPlayerMP.dimension = n;
        ItemInWorldManager itemInWorldManager = this._d._R() ? new DemoWorldManager(this._d._a(entityPlayerMP.dimension)) : new ItemInWorldManager(this._d._a(entityPlayerMP.dimension));
        EntityPlayerMP entityPlayerMP2 = new EntityPlayerMP(this._d, this._d._a(entityPlayerMP.dimension), entityPlayerMP.getCommandSenderName(), itemInWorldManager);
        entityPlayerMP2.playerNetServerHandler = entityPlayerMP.playerNetServerHandler;
        entityPlayerMP2.clonePlayer(entityPlayerMP, bl);
        entityPlayerMP2.dimension = n;
        entityPlayerMP2.entityId = entityPlayerMP.entityId;
        WorldServer worldServer2 = this._d._a(entityPlayerMP.dimension);
        this._a(entityPlayerMP2, entityPlayerMP, worldServer2);
        if (chunkCoordinates2 != null) {
            chunkCoordinates = EntityPlayer.verifyRespawnCoordinates(this._d._a(entityPlayerMP.dimension), chunkCoordinates2, bl2);
            if (chunkCoordinates != null) {
                entityPlayerMP2.setLocationAndAngles((float)chunkCoordinates._a + 0.5f, (float)chunkCoordinates._b + 0.1f, (float)chunkCoordinates._c + 0.5f, 0.0f, 0.0f);
                entityPlayerMP2.setSpawnChunk(chunkCoordinates2, bl2);
            } else {
                entityPlayerMP2.playerNetServerHandler.func_72567_b(new Packet70GameEvent(0, 0));
            }
        }
        worldServer2.theChunkProviderServer._a((int)entityPlayerMP2.posX >> 4, (int)entityPlayerMP2.posZ >> 4);
        while (!worldServer2.getCollidingBoundingBoxes(entityPlayerMP2, entityPlayerMP2.boundingBox).isEmpty()) {
            entityPlayerMP2.setPosition(entityPlayerMP2.posX, entityPlayerMP2.posY + 1.0, entityPlayerMP2.posZ);
        }
        entityPlayerMP2.playerNetServerHandler.func_72567_b(new Packet9Respawn(entityPlayerMP2.dimension, (byte)entityPlayerMP2.worldObj.difficultySetting, entityPlayerMP2.worldObj.getWorldInfo()._u(), entityPlayerMP2.worldObj.getHeight(), entityPlayerMP2.theItemInWorldManager._a()));
        chunkCoordinates = worldServer2.getSpawnPoint();
        entityPlayerMP2.playerNetServerHandler.setPlayerLocation(entityPlayerMP2.posX, entityPlayerMP2.posY, entityPlayerMP2.posZ, entityPlayerMP2.rotationYaw, entityPlayerMP2.rotationPitch);
        entityPlayerMP2.playerNetServerHandler.func_72567_b(new xbzt(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c));
        entityPlayerMP2.playerNetServerHandler.func_72567_b(new rajk(entityPlayerMP2.experience, entityPlayerMP2.experienceTotal, entityPlayerMP2.experienceLevel));
        this._b(entityPlayerMP2, worldServer2);
        worldServer2.getPlayerManager()._a(entityPlayerMP2);
        worldServer2.spawnEntityInWorld(entityPlayerMP2);
        this._e.add(entityPlayerMP2);
        entityPlayerMP2.addSelfToInternalCraftingInventory();
        entityPlayerMP2.setHealth(entityPlayerMP2.getHealth());
        GameRegistry.onPlayerRespawn(entityPlayerMP2);
        return entityPlayerMP2;
    }

    public void _a(EntityPlayerMP entityPlayerMP, int n) {
        this._a(entityPlayerMP, n, this._d._a(n).getDefaultTeleporter());
    }

    public void _a(EntityPlayerMP entityPlayerMP, int n, Teleporter teleporter) {
        int n2 = entityPlayerMP.dimension;
        WorldServer worldServer = this._d._a(entityPlayerMP.dimension);
        entityPlayerMP.dimension = n;
        WorldServer worldServer2 = this._d._a(entityPlayerMP.dimension);
        entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet9Respawn(entityPlayerMP.dimension, (byte)entityPlayerMP.worldObj.difficultySetting, worldServer2.getWorldInfo()._u(), worldServer2.getHeight(), entityPlayerMP.theItemInWorldManager._a()));
        worldServer.removePlayerEntityDangerously(entityPlayerMP);
        entityPlayerMP.isDead = false;
        this._a(entityPlayerMP, n2, worldServer, worldServer2, teleporter);
        this._a(entityPlayerMP, worldServer);
        entityPlayerMP.playerNetServerHandler.setPlayerLocation(entityPlayerMP.posX, entityPlayerMP.posY, entityPlayerMP.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
        entityPlayerMP.theItemInWorldManager._a(worldServer2);
        this._b(entityPlayerMP, worldServer2);
        this._f(entityPlayerMP);
        for (PotionEffect potionEffect : entityPlayerMP.getActivePotionEffects()) {
            entityPlayerMP.playerNetServerHandler.func_72567_b(new cwaw(entityPlayerMP.entityId, potionEffect));
        }
        GameRegistry.onPlayerChangedDimension(entityPlayerMP);
    }

    public void _a(Entity entity, int n, WorldServer worldServer, WorldServer worldServer2) {
        this._a(entity, n, worldServer, worldServer2, worldServer2.getDefaultTeleporter());
    }

    public void _a(Entity entity, int n, WorldServer worldServer, WorldServer worldServer2, Teleporter teleporter) {
        WorldProvider worldProvider = worldServer.provider;
        WorldProvider worldProvider2 = worldServer2.provider;
        double d = worldProvider._p() / worldProvider2._p();
        double d2 = entity.posX * d;
        double d3 = entity.posZ * d;
        double d4 = entity.posX;
        double d5 = entity.posY;
        double d6 = entity.posZ;
        float f = entity.rotationYaw;
        worldServer.theProfiler._a("moving");
        if (entity.dimension == 1) {
            ChunkCoordinates chunkCoordinates = n == 1 ? worldServer2.getSpawnPoint() : worldServer2.getEntrancePortalLocation();
            d2 = chunkCoordinates._a;
            entity.posY = chunkCoordinates._b;
            d3 = chunkCoordinates._c;
            entity.setLocationAndAngles(d2, entity.posY, d3, 90.0f, 0.0f);
            if (entity.isEntityAlive()) {
                worldServer.updateEntityWithOptionalForce(entity, false);
            }
        }
        worldServer.theProfiler._b();
        if (n != 1) {
            worldServer.theProfiler._a("placing");
            d2 = sajh._a((int)d2, -29999872, 29999872);
            d3 = sajh._a((int)d3, -29999872, 29999872);
            if (entity.isEntityAlive()) {
                worldServer2.spawnEntityInWorld(entity);
                entity.setLocationAndAngles(d2, entity.posY, d3, entity.rotationYaw, entity.rotationPitch);
                worldServer2.updateEntityWithOptionalForce(entity, false);
                teleporter.placeInPortal(entity, d4, d5, d6, f);
            }
            worldServer.theProfiler._b();
        }
        entity.setWorld(worldServer2);
    }

    public void _i() {
        if (++this._p > 600) {
            this._p = 0;
        }
        if (this._p < this._e.size()) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(this._p);
            this._a(new bbzw(entityPlayerMP.getCommandSenderName(), true, entityPlayerMP.ping));
        }
    }

    public void _a(Packet packet) {
        for (int i = 0; i < this._e.size(); ++i) {
            ((EntityPlayerMP)this._e.get((int)i)).playerNetServerHandler.func_72567_b(packet);
        }
    }

    public void _a(Packet packet, int n) {
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (entityPlayerMP.dimension != n) continue;
            entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
        }
    }

    public String _j() {
        String string = "";
        for (int i = 0; i < this._e.size(); ++i) {
            if (i > 0) {
                string = string + ", ";
            }
            string = string + ((EntityPlayerMP)this._e.get(i)).getCommandSenderName();
        }
        return string;
    }

    public String[] _k() {
        String[] stringArray = new String[this._e.size()];
        for (int i = 0; i < this._e.size(); ++i) {
            stringArray[i] = ((EntityPlayerMP)this._e.get(i)).getCommandSenderName();
        }
        return stringArray;
    }

    public BanList _l() {
        return this._f;
    }

    public BanList _m() {
        return this._g;
    }

    public void _a(String string) {
        this._h.add(string.toLowerCase());
    }

    public void _b(String string) {
        this._h.remove(string.toLowerCase());
    }

    public boolean _e(String string) {
        string = string.trim().toLowerCase();
        return !this._k || this._h.contains(string) || this._i.contains(string);
    }

    public boolean _g(String string) {
        return this._h.contains(string.trim().toLowerCase()) || this._d._N() && this._d._j[0].getWorldInfo()._v() && this._d._M().equalsIgnoreCase(string) || this._o;
    }

    public EntityPlayerMP _h(String string) {
        EntityPlayerMP entityPlayerMP;
        Iterator iterator2 = this._e.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return null;
        } while (!(entityPlayerMP = (EntityPlayerMP)iterator2.next()).getCommandSenderName().equalsIgnoreCase(string));
        return entityPlayerMP;
    }

    public List _a(ChunkCoordinates chunkCoordinates, int n, int n2, int n3, int n4, int n5, int n6, Map map, String string, String string2, World world) {
        if (this._e.isEmpty()) {
            return null;
        }
        List list = new ArrayList();
        boolean bl = n3 < 0;
        boolean bl2 = string != null && string.startsWith("!");
        boolean bl3 = string2 != null && string2.startsWith("!");
        int n7 = n * n;
        int n8 = n2 * n2;
        n3 = sajh._a(n3);
        if (bl2) {
            string = string.substring(1);
        }
        if (bl3) {
            string2 = string2.substring(1);
        }
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (world != null && entityPlayerMP.worldObj != world || string != null && bl2 == string.equalsIgnoreCase(entityPlayerMP.getEntityName())) continue;
            if (string2 != null) {
                String string3;
                Team team = entityPlayerMP.getTeam();
                String string4 = string3 = team == null ? "" : team._a();
                if (bl3 == string2.equalsIgnoreCase(string3)) continue;
            }
            if (chunkCoordinates != null && (n > 0 || n2 > 0)) {
                float f = chunkCoordinates._b(entityPlayerMP.func_82114_b());
                if (n > 0 && f < (float)n7 || n2 > 0 && f > (float)n8) continue;
            }
            if (!this._a((EntityPlayer)entityPlayerMP, map) || n4 != EnumGameType._a._a() && n4 != entityPlayerMP.theItemInWorldManager._a()._a() || n5 > 0 && entityPlayerMP.experienceLevel < n5 || entityPlayerMP.experienceLevel > n6) continue;
            ((List)list).add(entityPlayerMP);
        }
        if (chunkCoordinates != null) {
            Collections.sort(list, new ozhb(chunkCoordinates));
        }
        if (bl) {
            Collections.reverse(list);
        }
        if (n3 > 0) {
            list = ((List)list).subList(0, Math.min(n3, ((List)list).size()));
        }
        return list;
    }

    public boolean _a(EntityPlayer entityPlayer, Map map) {
        if (map != null && map.size() != 0) {
            boolean bl;
            Map.Entry entry;
            int n;
            Iterator iterator2 = map.entrySet().iterator();
            do {
                Scoreboard scoreboard;
                ScoreObjective scoreObjective;
                if (!iterator2.hasNext()) {
                    return true;
                }
                entry = iterator2.next();
                String string = (String)entry.getKey();
                bl = false;
                if (string.endsWith("_min") && string.length() > 4) {
                    bl = true;
                    string = string.substring(0, string.length() - 4);
                }
                if ((scoreObjective = (scoreboard = entityPlayer.getWorldScoreboard())._a(string)) == null) {
                    return false;
                }
                Score score = entityPlayer.getWorldScoreboard()._a(entityPlayer.getEntityName(), scoreObjective);
                n = score._b();
                if (n >= (Integer)entry.getValue() || !bl) continue;
                return false;
            } while (n <= (Integer)entry.getValue() || bl);
            return false;
        }
        return true;
    }

    public void _a(double d, double d2, double d3, double d4, int n, Packet packet) {
        this._a(null, d, d2, d3, d4, n, packet);
    }

    public void _a(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, int n, Packet packet) {
        for (int i = 0; i < this._e.size(); ++i) {
            double d5;
            double d6;
            double d7;
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (entityPlayerMP == entityPlayer || entityPlayerMP.dimension != n || !((d7 = d - entityPlayerMP.posX) * d7 + (d6 = d2 - entityPlayerMP.posY) * d6 + (d5 = d3 - entityPlayerMP.posZ) * d5 < d4 * d4)) continue;
            entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
        }
    }

    public void _n() {
        for (int i = 0; i < this._e.size(); ++i) {
            this._a((EntityPlayerMP)this._e.get(i));
        }
    }

    public void _d(String string) {
        this._i.add(string);
    }

    public void _c(String string) {
        this._i.remove(string);
    }

    public Set _o() {
        return this._i;
    }

    public Set _p() {
        return this._h;
    }

    public void _a() {
    }

    public void _b(EntityPlayerMP entityPlayerMP, WorldServer worldServer) {
        entityPlayerMP.playerNetServerHandler.func_72567_b(new rrld(worldServer.getTotalWorldTime(), worldServer.getWorldTime(), worldServer.getGameRules()._b("doDaylightCycle")));
        if (worldServer.isRaining()) {
            entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet70GameEvent(1, 0));
        }
    }

    public void _f(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.sendContainerToPlayer(entityPlayerMP.inventoryContainer);
        entityPlayerMP.setPlayerHealthUpdated();
        entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet16BlockItemSwitch(entityPlayerMP.inventory._c));
    }

    public int _q() {
        return this._e.size();
    }

    public int _r() {
        return this._l;
    }

    public String[] _s() {
        return this._d._j[0].getSaveHandler().func_75756_e()._a();
    }

    public boolean _t() {
        return this._k;
    }

    public void _a(boolean bl) {
        this._k = bl;
    }

    public List _i(String string) {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (EntityPlayerMP entityPlayerMP : this._e) {
            if (!entityPlayerMP.getPlayerIP().equals(string)) continue;
            arrayList.add(entityPlayerMP);
        }
        return arrayList;
    }

    public int _u() {
        return this._m;
    }

    public MinecraftServer _g() {
        return this._d;
    }

    public NBTTagCompound _c() {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(EnumGameType enumGameType) {
        this._n = enumGameType;
    }

    public void _a(EntityPlayerMP entityPlayerMP, EntityPlayerMP entityPlayerMP2, World world) {
        if (entityPlayerMP2 != null) {
            entityPlayerMP.theItemInWorldManager._a(entityPlayerMP2.theItemInWorldManager._a());
        } else if (this._n != null) {
            entityPlayerMP.theItemInWorldManager._a(this._n);
        }
        entityPlayerMP.theItemInWorldManager._b(world.getWorldInfo()._r());
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(boolean bl) {
        this._o = bl;
    }

    public void _v() {
        while (!this._e.isEmpty()) {
            ((EntityPlayerMP)this._e.get((int)0)).playerNetServerHandler.func_72565_c("Server closed");
        }
    }

    public void _a(ChatMessageComponent chatMessageComponent, boolean bl) {
        this._d.sendChatToPlayer(chatMessageComponent);
        this._a(new Packet3Chat(chatMessageComponent, bl));
    }

    public void _a(ChatMessageComponent chatMessageComponent) {
        this._a(chatMessageComponent, true);
    }
}

