/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.items.ISpecialWeight;

public class WeightMap {
    public static HashMap itemsWeight = new HashMap();

    public static void loadWeightMap() {
        try {
            BufferedReader e2 = new BufferedReader(new InputStreamReader(StalkerMain.class.getResourceAsStream("/assets/stalker/weight.txt"), "UTF-8"));
            new StringBuffer();
            boolean flag = false;
            while (!flag) {
                String str = e2.readLine();
                if (str == null) {
                    flag = true;
                    continue;
                }
                if ((str = str.trim()).startsWith("#") || str.isEmpty()) continue;
                String[] splitted = str.split("-");
                itemsWeight.put(Integer.parseInt(splitted[0]), Float.valueOf(Float.parseFloat(splitted[1].replace(",", "."))));
            }
        }
        catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public static float getWeight(ye stack) {
        return stack.b() instanceof ISpecialWeight ? ((ISpecialWeight)((Object)stack.b())).getWeight(stack) : (itemsWeight.containsKey(stack.d) ? ((Float)itemsWeight.get(stack.d)).floatValue() * (float)stack.b : (stack.d < aqz.s.length && aqz.s[stack.d] != null ? (float)(1 * stack.b) : 0.1f * (float)stack.b));
    }

    public static float getWeight(int id) {
        return itemsWeight.containsKey(id) ? ((Float)itemsWeight.get(id)).floatValue() : (id < aqz.s.length && aqz.s[id] != null ? 1.0f : 0.1f);
    }
}

