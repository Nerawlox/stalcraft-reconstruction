/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.minecraftforge.oredict.OreDictionary;

public class ShapelessOreRecipe
implements lpso {
    private cvzo output = null;
    private ArrayList input = new ArrayList();

    public ShapelessOreRecipe(twgu twgu2, Object ... objectArray) {
        this(new cvzo(twgu2), objectArray);
    }

    public ShapelessOreRecipe(tgdv tgdv2, Object ... objectArray) {
        this(new cvzo(tgdv2), objectArray);
    }

    public ShapelessOreRecipe(cvzo cvzo2, Object ... objectArray) {
        this.output = cvzo2._l();
        for (Object object : objectArray) {
            if (object instanceof cvzo) {
                this.input.add(((cvzo)object)._l());
                continue;
            }
            if (object instanceof tgdv) {
                this.input.add(new cvzo((tgdv)object));
                continue;
            }
            if (object instanceof twgu) {
                this.input.add(new cvzo((twgu)object));
                continue;
            }
            if (object instanceof String) {
                this.input.add(OreDictionary.getOres((String)object));
                continue;
            }
            String string = "Invalid shapeless ore recipe: ";
            for (Object object2 : objectArray) {
                string = string + object2 + ", ";
            }
            string = string + this.output;
            throw new RuntimeException(string);
        }
    }

    ShapelessOreRecipe(vmoj vmoj2, Map<cvzo, String> map) {
        this.output = vmoj2.func_77571_b();
        for (cvzo cvzo2 : vmoj2._b) {
            Object object = cvzo2;
            for (Map.Entry<cvzo, String> entry : map.entrySet()) {
                if (!OreDictionary.itemMatches(entry.getKey(), cvzo2, false)) continue;
                object = OreDictionary.getOres(entry.getValue());
                break;
            }
            this.input.add(object);
        }
    }

    @Override
    public int func_77570_a() {
        return this.input.size();
    }

    @Override
    public cvzo func_77571_b() {
        return this.output;
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        return this.output._l();
    }

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        ArrayList arrayList = new ArrayList(this.input);
        for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
            cvzo cvzo2 = bsse2.func_70301_a(i);
            if (cvzo2 == null) continue;
            boolean bl = false;
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                boolean bl2 = false;
                Object e = iterator.next();
                if (e instanceof cvzo) {
                    bl2 = this.checkItemEquals((cvzo)e, cvzo2);
                } else if (e instanceof ArrayList) {
                    for (cvzo cvzo3 : (ArrayList)e) {
                        bl2 = bl2 || this.checkItemEquals(cvzo3, cvzo2);
                    }
                }
                if (!bl2) continue;
                bl = true;
                arrayList.remove(e);
                break;
            }
            if (bl) continue;
            return false;
        }
        return arrayList.isEmpty();
    }

    private boolean checkItemEquals(cvzo cvzo2, cvzo cvzo3) {
        return cvzo2._d == cvzo3._d && (cvzo2._j() == Short.MAX_VALUE || cvzo2._j() == cvzo3._j());
    }

    public ArrayList getInput() {
        return this.input;
    }
}

