/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.ktcore.McExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NBTTags;
import noppes.npcs.NpcMiscInventory;

public class ItemsReward {
    public RewardSelectionMethod selectionMethod = RewardSelectionMethod.ALL;
    public NpcMiscInventory items = new NpcMiscInventory(16);
    public int[] weights = new int[16];
    public boolean rewardViaMail = false;
    public String mailTitle = "\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0437\u0430 \u0437\u0430\u0434\u0430\u043d\u0438\u0435";
    public String mailText = "";

    public void readNBT(qoac qoac2) {
        Object object;
        this.selectionMethod = qoac2._o("RandomReward") ? RewardSelectionMethod.ONE_RANDOM : (((String)(object = qoac2._j("SelectionMethod"))).isEmpty() ? RewardSelectionMethod.ALL : RewardSelectionMethod.valueOf((String)object));
        this.rewardViaMail = qoac2._o("RewardViaMail");
        this.mailTitle = qoac2._j("RewardMailTitle");
        this.mailText = qoac2._j("RewardMailText");
        this.items.setFromNBT(qoac2._m("Rewards"));
        object = NBTTags.getIntArray(qoac2._n("RewardWeights"));
        Arrays.fill(this.weights, 0);
        System.arraycopy(object, 0, this.weights, 0, ((Object)object).length);
    }

    public qoac writeNBT(qoac qoac2) {
        qoac2._a("SelectionMethod", this.selectionMethod.name());
        qoac2._a("RewardViaMail", this.rewardViaMail);
        qoac2._a("RewardMailTitle", this.mailTitle);
        qoac2._a("RewardMailText", this.mailText);
        qoac2._a("Rewards", this.items.getToNBT());
        qoac2._a("RewardWeights", NBTTags.nbtIntArray(this.weights));
        return qoac2;
    }

    public boolean isRandom() {
        return this.selectionMethod != RewardSelectionMethod.ALL;
    }

    public int getWeight(int n) {
        return Math.max(1, this.weights[n]);
    }

    public Collection<cvzo> getQuestReward(EntityPlayer entityPlayer) {
        if (this.selectionMethod == RewardSelectionMethod.ALL) {
            return new ArrayList<cvzo>(this.items.items.values());
        }
        List list = this.items.items.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toList());
        if (this.selectionMethod == RewardSelectionMethod.ONE_RANDOM) {
            Map.Entry entry2 = McExtensionsKt.weightedRandomElement(list, entry -> this.getWeight((Integer)entry.getKey()));
            return Collections.singletonList(entry2.getValue());
        }
        if (this.selectionMethod == RewardSelectionMethod.ALL_RANDOM) {
            Random random = new Random();
            ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
            for (Map.Entry entry3 : list) {
                double d = (double)this.getWeight((Integer)entry3.getKey()) / 100.0;
                if (!(random.nextDouble() < d)) continue;
                arrayList.add((cvzo)entry3.getValue());
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public static enum RewardSelectionMethod {
        ALL,
        ONE_RANDOM,
        ALL_RANDOM;

    }
}

