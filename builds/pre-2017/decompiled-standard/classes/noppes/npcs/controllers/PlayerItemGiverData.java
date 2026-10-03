/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.IPlayerData;
import noppes.npcs.roles.JobItemGiver;

public class PlayerItemGiverData
implements IPlayerData {
    private HashMap itemgivers = new HashMap();
    private HashMap chained = new HashMap();

    public void readNBT(qoac qoac2) {
        this.chained = NBTTags.getIntegerIntegerMap(qoac2._n("ItemGiverChained"));
        this.itemgivers = NBTTags.getIntegerLongMap(qoac2._n("ItemGiversList"));
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        qoac2._a("ItemGiverChained", NBTTags.nbtIntegerIntegerMap(this.chained));
        qoac2._a("ItemGiversList", NBTTags.nbtIntegerLongMap(this.itemgivers));
        return qoac2;
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

