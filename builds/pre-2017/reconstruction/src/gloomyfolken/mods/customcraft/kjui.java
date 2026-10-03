/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.customcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.HashSet;
import net.minecraft.item.ItemStack;

public class kjui
extends mqrl {
    @Override
    public String _a() {
        return "shaped_craft";
    }

    @Override
    public void _b(rpaa rpaa2) {
        String string;
        ItemStack itemStack = rpaa2._o("result");
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
            ItemStack itemStack2 = rpaa2._o(String.valueOf(c));
            if (itemStack2 == null) continue;
            arrayList.add(c);
            arrayList.add(itemStack2);
        }
        GameRegistry.addShapedRecipe(itemStack, arrayList.toArray());
    }

    @Override
    public boolean _b() {
        return false;
    }
}

