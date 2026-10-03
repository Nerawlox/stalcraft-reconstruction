/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.skinarmor;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.skinarmor.SkinArmorMod;
import java.util.HashMap;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

public class eidj {
    private static HashMap<String, ResourceLocation> _a = new HashMap();

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static ResourceLocation _a(AbstractClientPlayer abstractClientPlayer) {
        cvzo cvzo2 = abstractClientPlayer.func_71124_b(2);
        if (cvzo2 != null && cvzo2._a() == SkinArmorMod._b) {
            String string = ncwh._c(cvzo2)._j("skin");
            if (string.isEmpty()) {
                return AbstractClientPlayer.field_110314_b;
            }
            if (!_a.containsKey(string)) {
                _a.put(string, new ResourceLocation(string));
            }
            return _a.get(string);
        }
        return AbstractClientPlayer.field_110314_b;
    }
}

