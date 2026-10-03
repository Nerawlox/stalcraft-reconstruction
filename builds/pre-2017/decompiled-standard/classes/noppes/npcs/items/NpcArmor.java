/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;

public class NpcArmor
extends lpno {
    private String texture;

    public NpcArmor(int n, yery yery2, int n2, String string) {
        super(n - 26700 + CustomNpcs.ItemStartId, yery2, 0, n2);
        this.texture = string;
        this.func_77637_a(CustomItems.tabArmor);
    }

    @Override
    public String getArmorTexture(cvzo cvzo2, Entity entity, int n, int n2) {
        return this.field_77881_a == 2 ? "customnpcs:textures/armor/" + this.texture + "_2.png" : "customnpcs:textures/armor/" + this.texture + "_1.png";
    }

    @Override
    public tgdv func_77655_b(String string) {
        GameRegistry.registerItem(this, string);
        return super.func_77655_b(string);
    }
}

