/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.sajh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.controllers.GlobalDataController;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerItemGiverData;
import noppes.npcs.roles.JobInterface;

public class JobItemGiver
extends JobInterface {
    public int cooldownType = 0;
    public int givingMethod = 0;
    public int cooldown = 10;
    public NpcMiscInventory inventory = new NpcMiscInventory(9);
    public int itemGiverId = 0;
    public List lines = new ArrayList();
    private int ticks = 10;
    private List recentlyChecked = new ArrayList();
    private List toCheck;

    public JobItemGiver(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.lines.add("Have these items {player}");
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("igCooldownType", this.cooldownType);
        qoac2._a("igGivingMethod", this.givingMethod);
        qoac2._a("igCooldown", this.cooldown);
        qoac2._a("ItemGiverId", this.itemGiverId);
        qoac2._a("igLines", NBTTags.nbtStringList(this.lines));
        qoac2._a("igJobInventory", this.inventory.getToNBT());
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.itemGiverId = qoac2._f("ItemGiverId");
        this.cooldownType = qoac2._f("igCooldownType");
        this.givingMethod = qoac2._f("igGivingMethod");
        this.cooldown = qoac2._f("igCooldown");
        this.lines = NBTTags.getStringList(qoac2._n("igLines"));
        this.inventory.setFromNBT(qoac2._m("igJobInventory"));
        if (this.itemGiverId == 0 && GlobalDataController.instance != null) {
            this.itemGiverId = GlobalDataController.instance.incrementItemGiverId();
        }
    }

    public bsyv newHashMapNBTList(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        for (String string : hashMap.keySet()) {
            qoac qoac2 = new qoac();
            qoac2._a("Line", string);
            qoac2._a("Time", (Long)hashMap.get(string));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public HashMap getNBTLines(bsyv bsyv2) {
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            String string = qoac2._j("Line");
            long l = qoac2._g("Time");
            hashMap.put(string, l);
        }
        return hashMap;
    }

    private boolean giveItems(EntityPlayer entityPlayer) {
        PlayerItemGiverData playerItemGiverData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).itemgiverData;
        if (!this.canPlayerInteract(playerItemGiverData)) {
            return false;
        }
        Vector<cvzo> vector = new Vector<cvzo>();
        Vector<cvzo> vector2 = new Vector<cvzo>();
        for (cvzo cvzo2 : this.inventory.items.values()) {
            if (cvzo2 == null) continue;
            vector.add(cvzo2._l());
        }
        if (vector.isEmpty()) {
            return false;
        }
        if (this.isAllGiver()) {
            vector2 = vector;
        } else if (this.isRemainingGiver()) {
            for (cvzo cvzo2 : vector) {
                if (this.playerHasItem(entityPlayer, cvzo2._d)) continue;
                vector2.add(cvzo2);
            }
        } else if (this.isRandomGiver()) {
            vector2.add(((cvzo)vector.get(this.npc.field_70170_p.field_73012_v.nextInt(vector.size())))._l());
        } else if (this.isGiverWhenNotOwnedAny()) {
            boolean bl = false;
            for (cvzo cvzo3 : vector) {
                if (!this.playerHasItem(entityPlayer, cvzo3._d)) continue;
                bl = true;
                break;
            }
            if (bl) {
                return false;
            }
            vector2 = vector;
        } else if (this.isChainedGiver()) {
            int n = playerItemGiverData.getItemIndex(this);
            int n2 = 0;
            for (cvzo cvzo4 : this.inventory.items.values()) {
                if (n2 == n) {
                    vector2.add(cvzo4._l());
                    break;
                }
                ++n2;
            }
        }
        if (this.givePlayerItems(entityPlayer, vector2)) {
            if (!this.lines.isEmpty()) {
                this.npc.say(entityPlayer, new Line((String)this.lines.get(this.npc.func_70681_au().nextInt(this.lines.size()))));
            }
            if (this.isDaily()) {
                playerItemGiverData.setTime(this, this.getDay());
            } else {
                playerItemGiverData.setTime(this, System.currentTimeMillis());
            }
            if (this.isChainedGiver()) {
                playerItemGiverData.setItemIndex(this, (playerItemGiverData.getItemIndex(this) + 1) % this.inventory.items.size());
            }
            return true;
        }
        return false;
    }

    private int getDay() {
        return (int)(this.npc.field_70170_p.func_72820_D() / 24000L);
    }

    private boolean canPlayerInteract(PlayerItemGiverData playerItemGiverData) {
        return this.inventory.items.isEmpty() ? false : (this.isOnTimer() ? (!playerItemGiverData.hasInteractedBefore(this) ? true : playerItemGiverData.getTime(this) + (long)(this.cooldown * 1000) < System.currentTimeMillis()) : (this.isGiveOnce() ? !playerItemGiverData.hasInteractedBefore(this) : (this.isDaily() ? (!playerItemGiverData.hasInteractedBefore(this) ? true : (long)this.getDay() > playerItemGiverData.getTime(this)) : false)));
    }

    private boolean givePlayerItems(EntityPlayer entityPlayer, Vector<cvzo> vector) {
        if (vector.isEmpty()) {
            return false;
        }
        if (this.freeInventorySlots(entityPlayer) < vector.size()) {
            return false;
        }
        InvokeSideOnly.frontend(() -> {});
        for (cvzo cvzo2 : vector) {
            this.npc.givePlayerItem(entityPlayer, sajh._l._a(cvzo2, this.npc.func_70023_ak(), false));
        }
        return true;
    }

    private boolean playerHasItem(EntityPlayer entityPlayer, int n) {
        for (cvzo cvzo2 : entityPlayer.field_71071_by._a) {
            if (cvzo2 == null || cvzo2._d != n) continue;
            return true;
        }
        for (cvzo cvzo2 : entityPlayer.field_71071_by._b) {
            if (cvzo2 == null || cvzo2._d != n) continue;
            return true;
        }
        return false;
    }

    private int freeInventorySlots(EntityPlayer entityPlayer) {
        int n = 0;
        for (cvzo cvzo2 : entityPlayer.field_71071_by._a) {
            if (cvzo2 != null) continue;
            ++n;
        }
        return n;
    }

    private boolean isRandomGiver() {
        return this.givingMethod == 0;
    }

    private boolean isAllGiver() {
        return this.givingMethod == 1;
    }

    private boolean isRemainingGiver() {
        return this.givingMethod == 2;
    }

    private boolean isGiverWhenNotOwnedAny() {
        return this.givingMethod == 3;
    }

    private boolean isChainedGiver() {
        return this.givingMethod == 4;
    }

    public boolean isOnTimer() {
        return this.cooldownType == 0;
    }

    private boolean isGiveOnce() {
        return this.cooldownType == 1;
    }

    private boolean isDaily() {
        return this.cooldownType == 2;
    }

    @Override
    public boolean aiShouldExecute() {
        --this.ticks;
        if (this.npc.dialogs.isEmpty() && this.ticks <= 0 && !this.inventory.items.isEmpty()) {
            this.ticks = 20;
            this.toCheck = this.npc.field_70170_p.func_72872_a(EntityPlayer.class, this.npc.field_70121_D._b(3.0, 3.0, 3.0));
            this.toCheck.removeAll(this.recentlyChecked);
            List list2 = this.npc.field_70170_p.func_72872_a(EntityPlayer.class, this.npc.field_70121_D._b(10.0, 10.0, 10.0));
            this.recentlyChecked.retainAll(list2);
            this.recentlyChecked.addAll(this.toCheck);
            return this.toCheck.size() > 0;
        }
        return false;
    }

    @Override
    public void aiStartExecuting() {
        for (EntityPlayer entityPlayer : this.toCheck) {
            if (!this.npc.func_70685_l(entityPlayer)) continue;
            this.recentlyChecked.add(entityPlayer);
            this.interact(entityPlayer);
        }
    }

    @Override
    public void onDialogInteract(EntityPlayer entityPlayer) {
        this.interact(entityPlayer);
    }

    private boolean interact(EntityPlayer entityPlayer) {
        if (!this.giveItems(entityPlayer)) {
            this.npc.performInteractReplica(entityPlayer);
        }
        return true;
    }

    @Override
    public void killed() {
    }

    @Override
    public void delete() {
    }
}

