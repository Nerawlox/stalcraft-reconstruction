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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("igCooldownType", this.cooldownType);
        nBTTagCompound._a("igGivingMethod", this.givingMethod);
        nBTTagCompound._a("igCooldown", this.cooldown);
        nBTTagCompound._a("ItemGiverId", this.itemGiverId);
        nBTTagCompound._a("igLines", NBTTags.nbtStringList(this.lines));
        nBTTagCompound._a("igJobInventory", this.inventory.getToNBT());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.itemGiverId = nBTTagCompound._f("ItemGiverId");
        this.cooldownType = nBTTagCompound._f("igCooldownType");
        this.givingMethod = nBTTagCompound._f("igGivingMethod");
        this.cooldown = nBTTagCompound._f("igCooldown");
        this.lines = NBTTags.getStringList(nBTTagCompound._n("igLines"));
        this.inventory.setFromNBT(nBTTagCompound._m("igJobInventory"));
        if (this.itemGiverId == 0 && GlobalDataController.instance != null) {
            this.itemGiverId = GlobalDataController.instance.incrementItemGiverId();
        }
    }

    public NBTTagList newHashMapNBTList(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        for (String string : hashMap.keySet()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Line", string);
            nBTTagCompound._a("Time", (Long)hashMap.get(string));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public HashMap getNBTLines(NBTTagList nBTTagList) {
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            String string = nBTTagCompound._j("Line");
            long l = nBTTagCompound._g("Time");
            hashMap.put(string, l);
        }
        return hashMap;
    }

    private boolean giveItems(EntityPlayer entityPlayer) {
        PlayerItemGiverData playerItemGiverData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).itemgiverData;
        if (!this.canPlayerInteract(playerItemGiverData)) {
            return false;
        }
        Vector<ItemStack> vector = new Vector<ItemStack>();
        Vector<ItemStack> vector2 = new Vector<ItemStack>();
        for (ItemStack itemStack : this.inventory.items.values()) {
            if (itemStack == null) continue;
            vector.add(itemStack._l());
        }
        if (vector.isEmpty()) {
            return false;
        }
        if (this.isAllGiver()) {
            vector2 = vector;
        } else if (this.isRemainingGiver()) {
            for (ItemStack itemStack : vector) {
                if (this.playerHasItem(entityPlayer, itemStack._d)) continue;
                vector2.add(itemStack);
            }
        } else if (this.isRandomGiver()) {
            vector2.add(((ItemStack)vector.get(this.npc.worldObj.rand.nextInt(vector.size())))._l());
        } else if (this.isGiverWhenNotOwnedAny()) {
            boolean bl = false;
            for (ItemStack itemStack : vector) {
                if (!this.playerHasItem(entityPlayer, itemStack._d)) continue;
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
            for (ItemStack itemStack : this.inventory.items.values()) {
                if (n2 == n) {
                    vector2.add(itemStack._l());
                    break;
                }
                ++n2;
            }
        }
        if (this.givePlayerItems(entityPlayer, vector2)) {
            if (!this.lines.isEmpty()) {
                this.npc.say(entityPlayer, new Line((String)this.lines.get(this.npc.getRNG().nextInt(this.lines.size()))));
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
        return (int)(this.npc.worldObj.getWorldTime() / 24000L);
    }

    private boolean canPlayerInteract(PlayerItemGiverData playerItemGiverData) {
        return this.inventory.items.isEmpty() ? false : (this.isOnTimer() ? (!playerItemGiverData.hasInteractedBefore(this) ? true : playerItemGiverData.getTime(this) + (long)(this.cooldown * 1000) < System.currentTimeMillis()) : (this.isGiveOnce() ? !playerItemGiverData.hasInteractedBefore(this) : (this.isDaily() ? (!playerItemGiverData.hasInteractedBefore(this) ? true : (long)this.getDay() > playerItemGiverData.getTime(this)) : false)));
    }

    private boolean givePlayerItems(EntityPlayer entityPlayer, Vector<ItemStack> vector) {
        if (vector.isEmpty()) {
            return false;
        }
        if (this.freeInventorySlots(entityPlayer) < vector.size()) {
            return false;
        }
        InvokeSideOnly.frontend(() -> {});
        for (ItemStack itemStack : vector) {
            this.npc.givePlayerItem(entityPlayer, sajh._l._a(itemStack, this.npc.getEntityName(), false));
        }
        return true;
    }

    private boolean playerHasItem(EntityPlayer entityPlayer, int n) {
        for (ItemStack itemStack : entityPlayer.inventory._a) {
            if (itemStack == null || itemStack._d != n) continue;
            return true;
        }
        for (ItemStack itemStack : entityPlayer.inventory._b) {
            if (itemStack == null || itemStack._d != n) continue;
            return true;
        }
        return false;
    }

    private int freeInventorySlots(EntityPlayer entityPlayer) {
        int n = 0;
        for (ItemStack itemStack : entityPlayer.inventory._a) {
            if (itemStack != null) continue;
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
            this.toCheck = this.npc.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.npc.boundingBox._b(3.0, 3.0, 3.0));
            this.toCheck.removeAll(this.recentlyChecked);
            List list2 = this.npc.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.npc.boundingBox._b(10.0, 10.0, 10.0));
            this.recentlyChecked.retainAll(list2);
            this.recentlyChecked.addAll(this.toCheck);
            return this.toCheck.size() > 0;
        }
        return false;
    }

    @Override
    public void aiStartExecuting() {
        for (EntityPlayer entityPlayer : this.toCheck) {
            if (!this.npc.canEntityBeSeen(entityPlayer)) continue;
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

