/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import java.util.ArrayList;
import java.util.List;

public class PositionedStack {
    public int relx;
    public int rely;
    public cvzo[] items;
    public cvzo item;
    private boolean permutated = false;

    public PositionedStack(Object object, int n, int n2, boolean bl) {
        this.items = NEIServerUtils.extractRecipeItems(object);
        this.relx = n;
        this.rely = n2;
        if (bl) {
            this.generatePermutations();
        } else {
            this.setPermutationToRender(0);
        }
    }

    public PositionedStack(Object object, int n, int n2) {
        this(object, n, n2, true);
    }

    public void generatePermutations() {
        if (this.permutated) {
            return;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (cvzo cvzo2 : this.items) {
            if (cvzo2 == null || cvzo2._a() == null) continue;
            if (cvzo2._j() == Short.MAX_VALUE) {
                List<cvzo> list = NEIClientUtils.getValidItems(cvzo2._d);
                if (!list.isEmpty()) {
                    for (cvzo cvzo3 : list) {
                        arrayList.add(cvzo3._l());
                    }
                    continue;
                }
                cvzo cvzo4 = new cvzo(cvzo2._d, cvzo2._b, 0);
                cvzo4._e = cvzo2._e;
                arrayList.add(cvzo4);
                continue;
            }
            arrayList.add(cvzo2._l());
        }
        this.items = arrayList.toArray(new cvzo[0]);
        if (this.items.length == 0) {
            this.items = new cvzo[]{new cvzo(twgu.field_72067_ar)};
        }
        this.permutated = true;
        this.setPermutationToRender(0);
    }

    public void setMaxSize(int n) {
        for (cvzo cvzo2 : this.items) {
            if (cvzo2._b <= n) continue;
            cvzo2._b = n;
        }
    }

    public PositionedStack copy() {
        return new PositionedStack(this.items, this.relx, this.rely);
    }

    public void setPermutationToRender(int n) {
        this.item = this.items[n]._l();
        if (this.item._j() == -1) {
            this.item._b(0);
        }
    }

    public boolean contains(cvzo cvzo2) {
        for (cvzo cvzo3 : this.items) {
            if (!NEIServerUtils.areStacksSameTypeCrafting(cvzo3, cvzo2)) continue;
            return true;
        }
        return false;
    }

    public boolean contains(int n) {
        for (cvzo cvzo2 : this.items) {
            if (cvzo2._d != n) continue;
            return true;
        }
        return false;
    }
}

