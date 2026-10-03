/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.IPlayerData;
import noppes.npcs.roles.JobItemGiver;

public class PlayerItemGiverData
implements IPlayerData {
    private HashMap itemgivers = new HashMap();
    private HashMap chained = new HashMap();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.chained = NBTTags.getIntegerIntegerMap(nBTTagCompound._n("ItemGiverChained"));
        this.itemgivers = NBTTags.getIntegerLongMap(nBTTagCompound._n("ItemGiversList"));
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("ItemGiverChained", NBTTags.nbtIntegerIntegerMap(this.chained));
        nBTTagCompound._a("ItemGiversList", NBTTags.nbtIntegerLongMap(this.itemgivers));
        return nBTTagCompound;
    }

    public boolean hasInteractedBefore(JobItemGiver jobItemGiver) {
        return this.itemgivers.containsKey(jobItemGiver.itemGiverId);
    }

    public long getTime(JobItemGiver jobItemGiver) {
        return (Long)this.itemgivers.get(jobItemGiver.itemGiverId);
    }

    public void setTime(JobItemGiver jobItemGiver, long l) {
        this.itemgivers.put(jobItemGiver.itemGiverId, l);
    }

    public int getItemIndex(JobItemGiver jobItemGiver) {
        return this.chained.containsKey(jobItemGiver.itemGiverId) ? (Integer)this.chained.get(jobItemGiver.itemGiverId) : 0;
    }

    public void setItemIndex(JobItemGiver jobItemGiver, int n) {
        this.chained.put(jobItemGiver.itemGiverId, n);
    }
}

