/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.events;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.faction.pidb;
import gloomyfolken.mods.stalker.clans.jgro;
import gloomyfolken.mods.stalker.clans.zwat;
import gloomyfolken.mods.stalker.hud.kjui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.GlobalDataController;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;
import noppes.npcs.controllers.RelationData;
import noppes.npcs.controllers.SoundPresetsController;
import noppes.npcs.controllers.TransportController;

public class CustomNpcsEvents {
    private List<Entity> entitiesToClear = new ArrayList<Entity>();

    @ForgeSubscribe
    public void invoke(WorldEvent.Load load) {
        World world = load.world;
        if (!world.isRemote && DimensionManager.getWorld(0) == world) {
            new PlayerDataController();
            new QuestController();
            new DialogController();
            new BankController();
            new RecipeController();
            new FactionController();
            new TransportController();
            new GlobalDataController();
            new NpcSynchronizer();
            new SoundPresetsController();
        }
    }

    @ForgeSubscribe
    public void onInitHandlers(mquk mquk2) {
        mquk2._a("customnpcs", new PlayerData(mquk2._a));
    }

    @ForgeSubscribe
    public void invoke(PlayerInteractEvent playerInteractEvent) {
        EntityPlayer entityPlayer = playerInteractEvent.entityPlayer;
        int n = entityPlayer.worldObj.getBlockId(playerInteractEvent.x, playerInteractEvent.y, playerInteractEvent.z);
        if (n == Block.workbench.blockID && !entityPlayer.worldObj.isRemote) {
            Object object2;
            RecipeController recipeController = RecipeController.instance;
            NBTTagList nBTTagList = new NBTTagList();
            for (Object object2 : recipeController.globalRecipes.values()) {
                nBTTagList._a(((RecipeCarpentry)object2).writeNBT());
            }
            object2 = new NBTTagCompound();
            ((NBTTagCompound)object2)._a("recipes", nBTTagList);
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.SyncRecipes, object2);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void onGetCrosshairColor(kjui kjui2) {
        boolean bl;
        if (kjui2._a != -1) {
            return;
        }
        Entity entity = ClientProxy.ticker._c;
        Minecraft minecraft = Minecraft._E();
        boolean bl2 = bl = entity != null && entity != RenderManager._b._j && entity.isEntityAlive() && !entity.isInvisibleToPlayer(minecraft._t) && entity.riddenByEntity == null;
        if (!bl) {
            return;
        }
        if (entity instanceof EntityNPCInterface) {
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
            RelationData.PlayerFactionRelation playerFactionRelation = this.getNpcRelation(minecraft._t, entityNPCInterface.getFaction());
            if (playerFactionRelation != RelationData.PlayerFactionRelation.DEFAULT) {
                if (playerFactionRelation == RelationData.PlayerFactionRelation.FRIENDLY) {
                    kjui2._a = -16711936;
                } else if (playerFactionRelation == RelationData.PlayerFactionRelation.AGRESSIVE) {
                    kjui2._a = -65536;
                }
                return;
            }
            jgro jgro2 = this.getFactionRelation(minecraft._t, entityNPCInterface.getFaction());
            if (jgro2 == jgro._c) {
                kjui2._a = -16711936;
            } else if (jgro2 == jgro._b) {
                kjui2._a = -65536;
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    private RelationData.PlayerFactionRelation getNpcRelation(EntityPlayer entityPlayer, Faction faction) {
        if (faction.id == -1) {
            return RelationData.PlayerFactionRelation.DEFAULT;
        }
        String string = zwat._b((EntityPlayer)entityPlayer)._c._b();
        if (string != null) {
            if (faction.relationData.enemyClans.contains(string)) {
                return RelationData.PlayerFactionRelation.AGRESSIVE;
            }
            if (faction.relationData.allyClans.contains(string)) {
                return RelationData.PlayerFactionRelation.FRIENDLY;
            }
        }
        tupg tupg2 = pidb._a(entityPlayer)._a();
        return faction.relationData.factionRelations.get((Object)tupg2);
    }

    @ezey(_a={eidj.CLIENT})
    private jgro getFactionRelation(EntityPlayer entityPlayer, Faction faction) {
        if (faction.id == -1) {
            return jgro._e;
        }
        HashMap<Integer, Integer> hashMap = PlayerData.getData((EntityPlayer)entityPlayer).factionData.getFactionData();
        int n = hashMap.getOrDefault(faction.id, 0);
        if (n >= faction.friendlyPoints) {
            return jgro._c;
        }
        if (n >= faction.neutralPoints) {
            return jgro._e;
        }
        return jgro._b;
    }
}

