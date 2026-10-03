/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.lib.inventory.InventoryUtils;
import codechicken.nei.FastTransferManager;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.recipe.IRecipeHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DefaultOverlayHandler
implements IOverlayHandler {
    int offsetx;
    int offsety;

    public DefaultOverlayHandler(int n, int n2) {
        this.offsetx = n;
        this.offsety = n2;
    }

    public DefaultOverlayHandler() {
        this(5, 11);
    }

    @Override
    public void overlayRecipe(GuiContainer guiContainer, IRecipeHandler iRecipeHandler, int n, boolean bl) {
        List<PositionedStack> list = iRecipeHandler.getIngredientStacks(n);
        List<DistributedIngred> list2 = this.getPermutationIngredients(list);
        if (!this.clearIngredients(guiContainer, list)) {
            return;
        }
        this.findInventoryQuantities(guiContainer, list2);
        List<IngredientDistribution> list3 = this.assignIngredients(list, list2);
        if (list3 == null) {
            return;
        }
        this.assignIngredSlots(guiContainer, list, list3);
        int n2 = this.calculateRecipeQuantity(list3);
        if (n2 != 0) {
            this.moveIngredients(guiContainer, list3, n2);
        }
    }

    private boolean clearIngredients(GuiContainer guiContainer, List<PositionedStack> list) {
        for (PositionedStack positionedStack : list) {
            for (Slot slot : guiContainer.inventorySlots.inventorySlots) {
                if (slot.xDisplayPosition != positionedStack.relx + this.offsetx || slot.yDisplayPosition != positionedStack.rely + this.offsety || !slot.getHasStack()) continue;
                FastTransferManager.clickSlot(guiContainer, slot.slotNumber, 0, 1);
                if (!slot.getHasStack()) continue;
                return false;
            }
        }
        return true;
    }

    private void moveIngredients(GuiContainer guiContainer, List<IngredientDistribution> list, int n) {
        block0: for (IngredientDistribution ingredientDistribution : list) {
            ItemStack itemStack = ingredientDistribution.permutation;
            int n2 = n * itemStack._b;
            int n3 = 0;
            int n4 = 0;
            Slot slot = ingredientDistribution.slots[0];
            int n5 = 0;
            int n6 = itemStack._d();
            for (Slot slot2 : guiContainer.inventorySlots.inventorySlots) {
                ItemStack itemStack2;
                if (!slot2.getHasStack() || !(slot2.inventory instanceof InventoryPlayer) || !InventoryUtils.canStack(itemStack2 = slot2.getStack(), itemStack)) continue;
                FastTransferManager.clickSlot(guiContainer, slot2.slotNumber);
                int n7 = Math.min(n2 - n3, itemStack2._b);
                for (int i = 0; i < n7; ++i) {
                    FastTransferManager.clickSlot(guiContainer, slot.slotNumber, 1);
                    ++n3;
                    if (++n5 < n6) continue;
                    if (++n4 == ingredientDistribution.slots.length) {
                        slot = null;
                        break;
                    }
                    slot = ingredientDistribution.slots[n4];
                    n5 = 0;
                }
                FastTransferManager.clickSlot(guiContainer, slot2.slotNumber);
                if (n3 < n2 && slot != null) continue;
                continue block0;
            }
        }
    }

    private int calculateRecipeQuantity(List<IngredientDistribution> list) {
        int n = Integer.MAX_VALUE;
        for (IngredientDistribution ingredientDistribution : list) {
            DistributedIngred distributedIngred = ingredientDistribution.distrib;
            if (distributedIngred.numSlots == 0) {
                return 0;
            }
            int n2 = distributedIngred.invAmount;
            if (n2 / distributedIngred.numSlots > distributedIngred.stack._d()) {
                n2 = distributedIngred.numSlots * distributedIngred.stack._d();
            }
            n = Math.min(n, n2 / distributedIngred.distributed);
        }
        return n;
    }

    private Slot[][] assignIngredSlots(GuiContainer guiContainer, List<PositionedStack> list, List<IngredientDistribution> list2) {
        Slot[][] slotArray = this.mapIngredSlots(guiContainer, list);
        HashMap<Slot, Integer> hashMap = new HashMap<Slot, Integer>();
        for (int i = 0; i < slotArray.length; ++i) {
            for (Slot slot : slotArray[i]) {
                if (hashMap.containsKey(slot)) continue;
                hashMap.put(slot, -1);
            }
        }
        HashSet hashSet = new HashSet(hashMap.keySet());
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            hashSet2.add(i);
            arrayList.add(new LinkedList());
        }
        while (hashSet.size() > 0 && hashSet2.size() > 0) {
            Iterator iterator2 = hashSet2.iterator();
            while (iterator2.hasNext()) {
                int n = (Integer)iterator2.next();
                boolean bl = false;
                DistributedIngred distributedIngred = list2.get((int)n).distrib;
                for (Slot slot : slotArray[n]) {
                    if (!hashSet.contains(slot)) continue;
                    hashSet.remove(slot);
                    if (slot.getHasStack()) continue;
                    ++distributedIngred.numSlots;
                    ((LinkedList)arrayList.get(n)).add(slot);
                    bl = true;
                    break;
                }
                if (bl && distributedIngred.numSlots * distributedIngred.stack._d() < distributedIngred.invAmount) continue;
                iterator2.remove();
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            list2.get((int)i).slots = ((LinkedList)arrayList.get(i)).toArray(new Slot[0]);
        }
        return slotArray;
    }

    private List<IngredientDistribution> assignIngredients(List<PositionedStack> list, List<DistributedIngred> list2) {
        ArrayList<IngredientDistribution> arrayList = new ArrayList<IngredientDistribution>();
        for (PositionedStack positionedStack : list) {
            DistributedIngred distributedIngred = null;
            ItemStack itemStack = null;
            int n = 0;
            block1: for (ItemStack itemStack2 : positionedStack.items) {
                for (int i = 0; i < list2.size(); ++i) {
                    int n2;
                    DistributedIngred distributedIngred2 = list2.get(i);
                    if (!InventoryUtils.canStack(itemStack2, distributedIngred2.stack) || distributedIngred2.invAmount - distributedIngred2.distributed < itemStack2._b || (n2 = (distributedIngred2.invAmount - distributedIngred2.invAmount / distributedIngred2.recipeAmount * distributedIngred2.distributed) / itemStack2._b) <= n) continue;
                    n = n2;
                    distributedIngred = distributedIngred2;
                    itemStack = itemStack2;
                    continue block1;
                }
            }
            if (distributedIngred == null) {
                return null;
            }
            distributedIngred.distributed += itemStack._b;
            arrayList.add(new IngredientDistribution(distributedIngred, itemStack));
        }
        return arrayList;
    }

    private void findInventoryQuantities(GuiContainer guiContainer, List<DistributedIngred> list) {
        for (Slot slot : guiContainer.inventorySlots.inventorySlots) {
            ItemStack itemStack;
            DistributedIngred distributedIngred;
            if (!slot.getHasStack() || !(slot.inventory instanceof InventoryPlayer) || (distributedIngred = this.findIngred(list, itemStack = slot.getStack())) == null) continue;
            distributedIngred.invAmount += itemStack._b;
        }
    }

    private List<DistributedIngred> getPermutationIngredients(List<PositionedStack> list) {
        ArrayList<DistributedIngred> arrayList = new ArrayList<DistributedIngred>();
        for (PositionedStack positionedStack : list) {
            for (ItemStack itemStack : positionedStack.items) {
                DistributedIngred distributedIngred = this.findIngred(arrayList, itemStack);
                if (distributedIngred == null) {
                    distributedIngred = new DistributedIngred(itemStack);
                    arrayList.add(distributedIngred);
                }
                distributedIngred.recipeAmount += itemStack._b;
            }
        }
        return arrayList;
    }

    public Slot[][] mapIngredSlots(GuiContainer guiContainer, List<PositionedStack> list) {
        Slot[][] slotArray = new Slot[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            LinkedList<Slot> linkedList = new LinkedList<Slot>();
            PositionedStack positionedStack = list.get(i);
            for (Slot slot : guiContainer.inventorySlots.inventorySlots) {
                if (slot.xDisplayPosition != positionedStack.relx + this.offsetx || slot.yDisplayPosition != positionedStack.rely + this.offsety) continue;
                linkedList.add(slot);
                break;
            }
            slotArray[i] = linkedList.toArray(new Slot[0]);
        }
        return slotArray;
    }

    public void clickSlot(GuiContainer guiContainer, int n, int n2, int n3) {
        Container container = guiContainer.inventorySlots;
        Slot slot = null;
        if (n >= 0 && n < container.inventorySlots.size()) {
            slot = container.getSlot(n);
        }
        guiContainer.sendMouseClick(slot, n, n2, n3);
    }

    public DistributedIngred findIngred(List<DistributedIngred> list, ItemStack itemStack) {
        for (DistributedIngred distributedIngred : list) {
            if (!InventoryUtils.canStack(itemStack, distributedIngred.stack)) continue;
            return distributedIngred;
        }
        return null;
    }

    public static class IngredientDistribution {
        public DistributedIngred distrib;
        public ItemStack permutation;
        public Slot[] slots;

        public IngredientDistribution(DistributedIngred distributedIngred, ItemStack itemStack) {
            this.distrib = distributedIngred;
            this.permutation = itemStack;
        }
    }

    public static class DistributedIngred {
        public ItemStack stack;
        public int invAmount;
        public int distributed;
        public int numSlots;
        public int recipeAmount;

        public DistributedIngred(ItemStack itemStack) {
            this.stack = InventoryUtils.copyStack(itemStack, 1);
        }
    }
}

