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
import net.minecraft.entity.player.eidj;

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
    public void overlayRecipe(zybc zybc2, IRecipeHandler iRecipeHandler, int n, boolean bl) {
        List<PositionedStack> list = iRecipeHandler.getIngredientStacks(n);
        List<DistributedIngred> list2 = this.getPermutationIngredients(list);
        if (!this.clearIngredients(zybc2, list)) {
            return;
        }
        this.findInventoryQuantities(zybc2, list2);
        List<IngredientDistribution> list3 = this.assignIngredients(list, list2);
        if (list3 == null) {
            return;
        }
        this.assignIngredSlots(zybc2, list, list3);
        int n2 = this.calculateRecipeQuantity(list3);
        if (n2 != 0) {
            this.moveIngredients(zybc2, list3, n2);
        }
    }

    private boolean clearIngredients(zybc zybc2, List<PositionedStack> list) {
        for (PositionedStack positionedStack : list) {
            for (yeso yeso2 : zybc2.field_74193_d.field_75151_b) {
                if (yeso2.field_75223_e != positionedStack.relx + this.offsetx || yeso2.field_75221_f != positionedStack.rely + this.offsety || !yeso2.func_75216_d()) continue;
                FastTransferManager.clickSlot(zybc2, yeso2.field_75222_d, 0, 1);
                if (!yeso2.func_75216_d()) continue;
                return false;
            }
        }
        return true;
    }

    private void moveIngredients(zybc zybc2, List<IngredientDistribution> list, int n) {
        block0: for (IngredientDistribution ingredientDistribution : list) {
            cvzo cvzo2 = ingredientDistribution.permutation;
            int n2 = n * cvzo2._b;
            int n3 = 0;
            int n4 = 0;
            yeso yeso2 = ingredientDistribution.slots[0];
            int n5 = 0;
            int n6 = cvzo2._d();
            for (yeso yeso3 : zybc2.field_74193_d.field_75151_b) {
                cvzo cvzo3;
                if (!yeso3.func_75216_d() || !(yeso3.field_75224_c instanceof eidj) || !InventoryUtils.canStack(cvzo3 = yeso3.func_75211_c(), cvzo2)) continue;
                FastTransferManager.clickSlot(zybc2, yeso3.field_75222_d);
                int n7 = Math.min(n2 - n3, cvzo3._b);
                for (int i = 0; i < n7; ++i) {
                    FastTransferManager.clickSlot(zybc2, yeso2.field_75222_d, 1);
                    ++n3;
                    if (++n5 < n6) continue;
                    if (++n4 == ingredientDistribution.slots.length) {
                        yeso2 = null;
                        break;
                    }
                    yeso2 = ingredientDistribution.slots[n4];
                    n5 = 0;
                }
                FastTransferManager.clickSlot(zybc2, yeso3.field_75222_d);
                if (n3 < n2 && yeso2 != null) continue;
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

    private yeso[][] assignIngredSlots(zybc zybc2, List<PositionedStack> list, List<IngredientDistribution> list2) {
        yeso[][] yesoArray = this.mapIngredSlots(zybc2, list);
        HashMap<yeso, Integer> hashMap = new HashMap<yeso, Integer>();
        for (int i = 0; i < yesoArray.length; ++i) {
            for (yeso yeso2 : yesoArray[i]) {
                if (hashMap.containsKey(yeso2)) continue;
                hashMap.put(yeso2, -1);
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
                for (yeso yeso3 : yesoArray[n]) {
                    if (!hashSet.contains(yeso3)) continue;
                    hashSet.remove(yeso3);
                    if (yeso3.func_75216_d()) continue;
                    ++distributedIngred.numSlots;
                    ((LinkedList)arrayList.get(n)).add(yeso3);
                    bl = true;
                    break;
                }
                if (bl && distributedIngred.numSlots * distributedIngred.stack._d() < distributedIngred.invAmount) continue;
                iterator2.remove();
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            list2.get((int)i).slots = ((LinkedList)arrayList.get(i)).toArray(new yeso[0]);
        }
        return yesoArray;
    }

    private List<IngredientDistribution> assignIngredients(List<PositionedStack> list, List<DistributedIngred> list2) {
        ArrayList<IngredientDistribution> arrayList = new ArrayList<IngredientDistribution>();
        for (PositionedStack positionedStack : list) {
            DistributedIngred distributedIngred = null;
            cvzo cvzo2 = null;
            int n = 0;
            block1: for (cvzo cvzo3 : positionedStack.items) {
                for (int i = 0; i < list2.size(); ++i) {
                    int n2;
                    DistributedIngred distributedIngred2 = list2.get(i);
                    if (!InventoryUtils.canStack(cvzo3, distributedIngred2.stack) || distributedIngred2.invAmount - distributedIngred2.distributed < cvzo3._b || (n2 = (distributedIngred2.invAmount - distributedIngred2.invAmount / distributedIngred2.recipeAmount * distributedIngred2.distributed) / cvzo3._b) <= n) continue;
                    n = n2;
                    distributedIngred = distributedIngred2;
                    cvzo2 = cvzo3;
                    continue block1;
                }
            }
            if (distributedIngred == null) {
                return null;
            }
            distributedIngred.distributed += cvzo2._b;
            arrayList.add(new IngredientDistribution(distributedIngred, cvzo2));
        }
        return arrayList;
    }

    private void findInventoryQuantities(zybc zybc2, List<DistributedIngred> list) {
        for (yeso yeso2 : zybc2.field_74193_d.field_75151_b) {
            cvzo cvzo2;
            DistributedIngred distributedIngred;
            if (!yeso2.func_75216_d() || !(yeso2.field_75224_c instanceof eidj) || (distributedIngred = this.findIngred(list, cvzo2 = yeso2.func_75211_c())) == null) continue;
            distributedIngred.invAmount += cvzo2._b;
        }
    }

    private List<DistributedIngred> getPermutationIngredients(List<PositionedStack> list) {
        ArrayList<DistributedIngred> arrayList = new ArrayList<DistributedIngred>();
        for (PositionedStack positionedStack : list) {
            for (cvzo cvzo2 : positionedStack.items) {
                DistributedIngred distributedIngred = this.findIngred(arrayList, cvzo2);
                if (distributedIngred == null) {
                    distributedIngred = new DistributedIngred(cvzo2);
                    arrayList.add(distributedIngred);
                }
                distributedIngred.recipeAmount += cvzo2._b;
            }
        }
        return arrayList;
    }

    public yeso[][] mapIngredSlots(zybc zybc2, List<PositionedStack> list) {
        yeso[][] yesoArray = new yeso[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            LinkedList<yeso> linkedList = new LinkedList<yeso>();
            PositionedStack positionedStack = list.get(i);
            for (yeso yeso2 : zybc2.field_74193_d.field_75151_b) {
                if (yeso2.field_75223_e != positionedStack.relx + this.offsetx || yeso2.field_75221_f != positionedStack.rely + this.offsety) continue;
                linkedList.add(yeso2);
                break;
            }
            yesoArray[i] = linkedList.toArray(new yeso[0]);
        }
        return yesoArray;
    }

    public void clickSlot(zybc zybc2, int n, int n2, int n3) {
        jjgc jjgc2 = zybc2.field_74193_d;
        yeso yeso2 = null;
        if (n >= 0 && n < jjgc2.field_75151_b.size()) {
            yeso2 = jjgc2.func_75139_a(n);
        }
        zybc2.sendMouseClick(yeso2, n, n2, n3);
    }

    public DistributedIngred findIngred(List<DistributedIngred> list, cvzo cvzo2) {
        for (DistributedIngred distributedIngred : list) {
            if (!InventoryUtils.canStack(cvzo2, distributedIngred.stack)) continue;
            return distributedIngred;
        }
        return null;
    }

    public static class IngredientDistribution {
        public DistributedIngred distrib;
        public cvzo permutation;
        public yeso[] slots;

        public IngredientDistribution(DistributedIngred distributedIngred, cvzo cvzo2) {
            this.distrib = distributedIngred;
            this.permutation = cvzo2;
        }
    }

    public static class DistributedIngred {
        public cvzo stack;
        public int invAmount;
        public int distributed;
        public int numSlots;
        public int recipeAmount;

        public DistributedIngred(cvzo cvzo2) {
            this.stack = InventoryUtils.copyStack(cvzo2, 1);
        }
    }
}

