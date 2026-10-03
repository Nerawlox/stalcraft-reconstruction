/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.Availability;

public class RecipeCarpentry
implements lpso {
    public int id = -1;
    public String name = "";
    public int recipeWidth = 4;
    public int recipeHeight = 4;
    public cvzo recipeOutput;
    public Availability availability = new Availability();
    public boolean isGlobal = false;
    public boolean ignoreDamage = false;
    private cvzo[] recipeItems = new cvzo[16];

    public RecipeCarpentry() {
    }

    public RecipeCarpentry(int n, String string) {
        this.id = n;
        this.name = string;
    }

    public void readNBT(qoac qoac2) {
        this.id = qoac2._f("ID");
        this.recipeWidth = qoac2._f("Width");
        this.recipeHeight = qoac2._f("Height");
        this.recipeOutput = cvzo._a(qoac2._m("Item"));
        this.recipeItems = NBTTags.getItemStackArray(qoac2._n("Materials"));
        this.availability.readFromNBT(qoac2._m("Availability"));
        this.ignoreDamage = qoac2._o("IgnoreDamage");
        this.name = qoac2._j("Name");
        this.isGlobal = qoac2._o("Global");
    }

    public qoac writeNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("ID", this.id);
        qoac2._a("Width", this.recipeWidth);
        qoac2._a("Height", this.recipeHeight);
        if (this.recipeOutput != null) {
            qoac2._a("Item", this.recipeOutput._b(new qoac()));
        }
        qoac2._a("Materials", NBTTags.nbtItemStackArray(this.recipeItems));
        qoac2._a("Availability", this.availability.writeToNBT(new qoac()));
        qoac2._a("Name", this.name);
        qoac2._a("Global", this.isGlobal);
        qoac2._a("IgnoreDamage", this.ignoreDamage);
        return qoac2;
    }

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        for (int i = 0; i <= 4 - this.recipeWidth; ++i) {
            for (int j = 0; j <= 4 - this.recipeHeight; ++j) {
                if (this.checkMatch(bsse2, i, j, true)) {
                    return true;
                }
                if (!this.checkMatch(bsse2, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkMatch(bsse bsse2, int n, int n2, boolean bl) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                cvzo cvzo2;
                int n3 = i - n;
                int n4 = j - n2;
                cvzo cvzo3 = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this.recipeWidth && n4 < this.recipeHeight) {
                    cvzo3 = bl ? this.recipeItems[this.recipeWidth - n3 - 1 + n4 * this.recipeWidth] : this.recipeItems[n3 + n4 * this.recipeWidth];
                }
                if ((cvzo2 = bsse2.func_70463_b(i, j)) == null && cvzo3 == null || ncwh._a(cvzo3, cvzo2, this.ignoreDamage)) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        return this.recipeOutput == null ? null : this.recipeOutput._l();
    }

    @Override
    public int func_77570_a() {
        return 16;
    }

    @Override
    public cvzo func_77571_b() {
        return this.recipeOutput;
    }

    public void addRecipe(cvzo cvzo2, Object ... objectArray) {
        int n;
        int n2;
        Object object;
        Object object2;
        String string = "";
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (objectArray[n3] instanceof String[]) {
            object2 = (String[])objectArray[n3++];
            object = object2;
            n2 = ((String[])object2).length;
            for (n = 0; n < n2; ++n) {
                String string2 = object[n];
                ++n5;
                n4 = string2.length();
                string = string + string2;
            }
        } else {
            while (objectArray[n3] instanceof String) {
                object2 = (String)objectArray[n3++];
                ++n5;
                n4 = ((String)object2).length();
                string = string + (String)object2;
            }
        }
        object2 = new HashMap();
        while (n3 < objectArray.length) {
            object = (Character)objectArray[n3];
            cvzo cvzo3 = null;
            if (objectArray[n3 + 1] instanceof tgdv) {
                cvzo3 = new cvzo((tgdv)objectArray[n3 + 1]);
            } else if (objectArray[n3 + 1] instanceof twgu) {
                cvzo3 = new cvzo((twgu)objectArray[n3 + 1], 1, -1);
            } else if (objectArray[n3 + 1] instanceof cvzo) {
                cvzo3 = (cvzo)objectArray[n3 + 1];
            }
            ((HashMap)object2).put(object, cvzo3);
            n3 += 2;
        }
        object = new cvzo[n4 * n5];
        for (n2 = 0; n2 < n4 * n5; ++n2) {
            n = string.charAt(n2);
            object[n2] = ((HashMap)object2).containsKey(Character.valueOf((char)n)) ? ((cvzo)((HashMap)object2).get(Character.valueOf((char)n)))._l() : null;
        }
        this.recipeOutput = cvzo2;
        this.recipeItems = object;
        this.recipeWidth = n4;
        this.recipeHeight = n5;
        if (n4 == 4 || n5 == 4) {
            this.isGlobal = false;
        }
    }

    public cvzo getCraftingItem(int n) {
        return this.recipeItems != null && n < this.recipeItems.length ? this.recipeItems[n] : null;
    }

    public void setCraftingItem(int n, cvzo cvzo2) {
        if (n < this.recipeItems.length) {
            this.recipeItems[n] = cvzo2;
        }
    }

    public void clear() {
        this.recipeOutput = null;
        this.recipeItems = new cvzo[16];
    }
}

