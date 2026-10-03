/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.events;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.client.controllers.CloneController;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumQuestType;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.permissions.CustomNpcsPermissions;
import noppes.npcs.quests.QuestItem;

public class ItemInteractEvent {
    public static EntityVillager Merchant;

    @ForgeSubscribe
    public void inventoryChanged(jhla.eidj eidj2) {
        if (!eidj2._a.isOwnerPlayer || eidj2._a.isLocalWorld || eidj2._c.isEmpty()) {
            return;
        }
        EntityPlayer entityPlayer = eidj2._a.player;
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        QuestData questData = playerData.questData.activeQuests.get(playerData.activeQuest);
        boolean bl = questData != null && questData.quest.type == EnumQuestType.Item;
        boolean bl2 = false;
        if (bl) {
            NpcMiscInventory npcMiscInventory = ((QuestItem)questData.quest.questInterface).items;
            Set<Integer> set = eidj2._b.keySet();
            block0: for (int n : set) {
                cvzo cvzo2 = eidj2._b.get(n);
                cvzo cvzo3 = eidj2._c.get(n);
                for (cvzo cvzo4 : npcMiscInventory.items.values()) {
                    if (!ncwh._a(cvzo4, cvzo2, false, true) && !ncwh._a(cvzo4, cvzo3, false, true)) continue;
                    bl2 = true;
                    continue block0;
                }
            }
        }
        playerData.questData.checkQuestCompletion(entityPlayer, EnumQuestType.Item);
        if (bl2) {
            InvokeSideOnly.frontend(!entityPlayer.field_70170_p.field_72995_K, () -> {});
        }
    }

    @ForgeSubscribe
    public void invoke(bqug bqug2) {
        if (this.doInteract(bqug2._b, bqug2.entityPlayer, bqug2._a)) {
            bqug2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void invoke2(EntityInteractEvent entityInteractEvent) {
        if (this.doInteract(entityInteractEvent.entityPlayer.func_70694_bm(), entityInteractEvent.entityPlayer, entityInteractEvent.target)) {
            entityInteractEvent.setCanceled(true);
        }
    }

    private boolean doInteract(cvzo cvzo2, EntityPlayer entityPlayer, Entity entity) {
        if (cvzo2 != null) {
            boolean bl = entityPlayer.field_70170_p.field_72995_K;
            boolean bl2 = entity instanceof EntityNPCInterface;
            if (cvzo2._d == CustomItems.wand.field_77779_bT && bl2 && !bl) {
                if (entityPlayer.func_70093_af()) {
                    this.openApproveGui(entityPlayer, entity);
                } else {
                    NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.MainMenuDisplay, (EntityNPCInterface)entity);
                }
                return true;
            }
            if (cvzo2._d == CustomItems.cloner.field_77779_bT) {
                if (bl) {
                    InvokeSideOnly.client(() -> {
                        CloneController.toClone = entity;
                        CustomNpcs.proxy.openGui(0, 0, 0, EnumGuiType.MobSpawnerAdd, entityPlayer);
                    });
                }
                return true;
            }
            if (cvzo2._d == CustomItems.wand.field_77779_bT && entity instanceof EntityVillager) {
                Merchant = (EntityVillager)entity;
                InvokeSideOnly.frontend(!bl, () -> {});
                return true;
            }
            if (cvzo2._d == CustomItems.duplicator.field_77779_bT && bl2 && !bl) {
                InvokeSideOnly.frontend(() -> {});
                return true;
            }
            if (cvzo2._d == CustomItems.approver.field_77779_bT && bl2 && !bl) {
                this.openApproveGui(entityPlayer, entity);
                return true;
            }
            if (cvzo2._a() instanceof dgmz && entityPlayer.field_71075_bZ._d && bl2) {
                if (!bl) {
                    EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
                    if (entityNPCInterface.status.canEdit(entityPlayer) || CustomNpcsPermissions.Instance.hasPermission(entityPlayer, "customnpcs.npc.editall")) {
                        entityNPCInterface.inventory.armor.put(1, cvzo2._l());
                        entityNPCInterface.sync();
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void openApproveGui(EntityPlayer entityPlayer, Entity entity) {
        InvokeSideOnly.frontend(() -> {});
    }
}

