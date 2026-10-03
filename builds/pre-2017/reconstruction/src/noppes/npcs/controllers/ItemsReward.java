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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NBTTags;
import noppes.npcs.NpcMiscInventory;

public class ItemsReward {
    public RewardSelectionMethod selectionMethod = RewardSelectionMethod.ALL;
    public NpcMiscInventory items = new NpcMiscInventory(16);
    public int[] weights = new int[16];
    public boolean rewardViaMail = false;
    public String mailTitle = "\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0437\u0430 \u0437\u0430\u0434\u0430\u043d\u0438\u0435";
    public String mailText = "";

    public void readNBT(NBTTagCompound nBTTagCompound) {
        Object object;
        this.selectionMethod = nBTTagCompound._o("RandomReward") ? RewardSelectionMethod.ONE_RANDOM : (((String)(object = nBTTagCompound._j("SelectionMethod"))).isEmpty() ? RewardSelectionMethod.ALL : RewardSelectionMethod.valueOf((String)object));
        this.rewardViaMail = nBTTagCompound._o("RewardViaMail");
        this.mailTitle = nBTTagCompound._j("RewardMailTitle");
        this.mailText = nBTTagCompound._j("RewardMailText");
        this.items.setFromNBT(nBTTagCompound._m("Rewards"));
        object = NBTTags.getIntArray(nBTTagCompound._n("RewardWeights"));
        Arrays.fill(this.weights, 0);
        System.arraycopy(object, 0, this.weights, 0, ((Object)object).length);
    }

    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("SelectionMethod", this.selectionMethod.name());
        nBTTagCompound._a("RewardViaMail", this.rewardViaMail);
        nBTTagCompound._a("RewardMailTitle", this.mailTitle);
        nBTTagCompound._a("RewardMailText", this.mailText);
        nBTTagCompound._a("Rewards", this.items.getToNBT());
        nBTTagCompound._a("RewardWeights", NBTTags.nbtIntArray(this.weights));
        return nBTTagCompound;
    }

    public boolean isRandom() {
        return this.selectionMethod != RewardSelectionMethod.ALL;
    }

    public int getWeight(int n) {
        return Math.max(1, this.weights[n]);
    }

    public Collection<ItemStack> getQuestReward(EntityPlayer entityPlayer) {
        if (this.selectionMethod == RewardSelectionMethod.ALL) {
            return new ArrayList<ItemStack>(this.items.items.values());
        }
        List list = this.items.items.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toList());
        if (this.selectionMethod == RewardSelectionMethod.ONE_RANDOM) {
            Map.Entry entry2 = McExtensionsKt.weightedRandomElement(list, entry -> this.getWeight((Integer)entry.getKey()));
            return Collections.singletonList(entry2.getValue());
        }
        if (this.selectionMethod == RewardSelectionMethod.ALL_RANDOM) {
            Random random = new Random();
            ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
            for (Map.Entry entry3 : list) {
                double d = (double)this.getWeight((Integer)entry3.getKey()) / 100.0;
                if (!(random.nextDouble() < d)) continue;
                arrayList.add((ItemStack)entry3.getValue());
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

