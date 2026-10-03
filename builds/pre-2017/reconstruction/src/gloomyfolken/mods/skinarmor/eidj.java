/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.skinarmor;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.skinarmor.SkinArmorMod;
import java.util.HashMap;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class eidj {
    private static HashMap<String, ResourceLocation> _a = new HashMap();

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static ResourceLocation _a(AbstractClientPlayer abstractClientPlayer) {
        ItemStack itemStack = abstractClientPlayer.func_71124_b(2);
        if (itemStack != null && itemStack._a() == SkinArmorMod._b) {
            String string = ncwh._c(itemStack)._j("skin");
            if (string.isEmpty()) {
                return AbstractClientPlayer.locationStevePng;
            }
            if (!_a.containsKey(string)) {
                _a.put(string, new ResourceLocation(string));
            }
            return _a.get(string);
        }
        return AbstractClientPlayer.locationStevePng;
    }
}

