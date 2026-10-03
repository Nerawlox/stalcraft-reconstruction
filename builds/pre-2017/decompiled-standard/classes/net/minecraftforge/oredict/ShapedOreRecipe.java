/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraftforge.oredict.OreDictionary;

public class ShapedOreRecipe
implements lpso {
    private static final int MAX_CRAFT_GRID_WIDTH = 3;
    private static final int MAX_CRAFT_GRID_HEIGHT = 3;
    private cvzo output = null;
    private Object[] input = null;
    private int width = 0;
    private int height = 0;
    private boolean mirrored = true;

    public ShapedOreRecipe(twgu twgu2, Object ... objectArray) {
        this(new cvzo(twgu2), objectArray);
    }

    public ShapedOreRecipe(tgdv tgdv2, Object ... objectArray) {
        this(new cvzo(tgdv2), objectArray);
    }

    /*
     * WARNING - void declaration
     */
    public ShapedOreRecipe(cvzo cvzo2, Object ... objectArray) {
        void var9_22;
        Object object;
        this.output = cvzo2._l();
        String string = "";
        int n = 0;
        if (objectArray[n] instanceof Boolean) {
            this.mirrored = (Boolean)objectArray[n];
            if (objectArray[n + 1] instanceof Object[]) {
                objectArray = (Object[])objectArray[n + 1];
            } else {
                n = 1;
            }
        }
        if (objectArray[n] instanceof String[]) {
            object = (String[])objectArray[n++];
            for (String string2 : object) {
                this.width = string2.length();
                string = string + string2;
            }
            this.height = ((String[])object).length;
        } else {
            while (objectArray[n] instanceof String) {
                object = (String)objectArray[n++];
                string = string + (String)object;
                this.width = ((String)object).length();
                ++this.height;
            }
        }
        if (this.width * this.height != string.length()) {
            object = "Invalid shaped ore recipe: ";
            for (Object object2 : objectArray) {
                object = (String)object + object2 + ", ";
            }
            object = (String)object + this.output;
            throw new RuntimeException((String)object);
        }
        object = new HashMap();
        while (n < objectArray.length) {
            Character c = (Character)objectArray[n];
            Object object3 = objectArray[n + 1];
            if (object3 instanceof cvzo) {
                ((HashMap)object).put(c, ((cvzo)object3)._l());
            } else if (object3 instanceof tgdv) {
                ((HashMap)object).put(c, new cvzo((tgdv)object3));
            } else if (object3 instanceof twgu) {
                ((HashMap)object).put(c, new cvzo((twgu)object3, 1, Short.MAX_VALUE));
            } else if (object3 instanceof String) {
                ((HashMap)object).put(c, OreDictionary.getOres((String)object3));
            } else {
                String string3 = "Invalid shaped ore recipe: ";
                for (Object object4 : objectArray) {
                    string3 = string3 + object4 + ", ";
                }
                string3 = string3 + this.output;
                throw new RuntimeException(string3);
            }
            n += 2;
        }
        this.input = new Object[this.width * this.height];
        boolean bl = false;
        char[] cArray = string.toCharArray();
        int n2 = cArray.length;
        boolean bl2 = false;
        while (var9_22 < n2) {
            char c = cArray[var9_22];
            this.input[++var6_11] = ((HashMap)object).get(Character.valueOf(c));
            ++var9_22;
        }
    }

    ShapedOreRecipe(xbtf xbtf2, Map<cvzo, String> map) {
        this.output = xbtf2.func_77571_b();
        this.width = xbtf2._a;
        this.height = xbtf2._b;
        this.input = new Object[xbtf2._c.length];
        block0: for (int i = 0; i < this.input.length; ++i) {
            cvzo cvzo2 = xbtf2._c[i];
            if (cvzo2 == null) continue;
            this.input[i] = xbtf2._c[i];
            for (Map.Entry<cvzo, String> entry : map.entrySet()) {
                if (!OreDictionary.itemMatches(entry.getKey(), cvzo2, true)) continue;
                this.input[i] = OreDictionary.getOres(entry.getValue());
                continue block0;
            }
        }
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        return this.output._l();
    }

    @Override
    public int func_77570_a() {
        return this.input.length;
    }

    @Override
    public cvzo func_77571_b() {
        return this.output;
    }

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        for (int i = 0; i <= 3 - this.width; ++i) {
            for (int j = 0; j <= 3 - this.height; ++j) {
                if (this.checkMatch(bsse2, i, j, false)) {
                    return true;
                }
                if (!this.mirrored || !this.checkMatch(bsse2, i, j, true)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkMatch(bsse bsse2, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int n3 = i - n;
                int n4 = j - n2;
                Object object = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this.width && n4 < this.height) {
                    object = bl ? this.input[this.width - n3 - 1 + n4 * this.width] : this.input[n3 + n4 * this.width];
                }
                cvzo cvzo2 = bsse2.func_70463_b(i, j);
                if (object instanceof cvzo) {
                    if (this.checkItemEquals((cvzo)object, cvzo2)) continue;
                    return false;
                }
                if (object instanceof ArrayList) {
                    boolean bl2 = false;
                    for (cvzo cvzo3 : (ArrayList)object) {
                        bl2 = bl2 || this.checkItemEquals(cvzo3, cvzo2);
                    }
                    if (bl2) continue;
                    return false;
                }
                if (object != null || cvzo2 == null) continue;
                return false;
            }
        }
        return true;
    }

    private boolean checkItemEquals(cvzo cvzo2, cvzo cvzo3) {
        if (cvzo3 == null && cvzo2 != null || cvzo3 != null && cvzo2 == null) {
            return false;
        }
        return cvzo2._d == cvzo3._d && (cvzo2._j() == Short.MAX_VALUE || cvzo2._j() == cvzo3._j());
    }

    public ShapedOreRecipe setMirrored(boolean bl) {
        this.mirrored = bl;
        return this;
    }

    public Object[] getInput() {
        return this.input;
    }
}

