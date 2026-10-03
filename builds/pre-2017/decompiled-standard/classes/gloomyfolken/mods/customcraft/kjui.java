/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.customcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.HashSet;

public class kjui
extends mqrl {
    @Override
    public String _a() {
        return "shaped_craft";
    }

    @Override
    public void _b(rpaa rpaa2) {
        String string;
        cvzo cvzo2 = rpaa2._o("result");
        int n = 0;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        HashSet<Character> hashSet = new HashSet<Character>();
        while ((string = rpaa2._a("recipe" + ++n, (String)null)) != null) {
            arrayList.add(string);
            for (Object object : (Object)string.toCharArray()) {
                hashSet.add(Character.valueOf((char)object));
            }
        }
        for (Character c : hashSet) {
            cvzo cvzo3 = rpaa2._o(String.valueOf(c));
            if (cvzo3 == null) continue;
            arrayList.add(c);
            arrayList.add(cvzo3);
        }
        GameRegistry.addShapedRecipe(cvzo2, arrayList.toArray());
    }

    @Override
    public boolean _b() {
        return false;
    }
}

