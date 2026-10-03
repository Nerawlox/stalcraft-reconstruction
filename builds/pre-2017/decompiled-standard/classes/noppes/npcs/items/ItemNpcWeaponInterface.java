/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.items.ItemRenderInterface;
import org.lwjgl.opengl.GL11;

public class ItemNpcWeaponInterface
extends vmpw
implements ItemRenderInterface {
    public ItemNpcWeaponInterface(int n, txfz txfz2) {
        super(n - 26700 + CustomNpcs.ItemStartId, txfz2);
        this.func_77637_a(CustomItems.tab);
        CustomNpcs.proxy.registerItem(this.field_77779_bT);
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.66f, 0.66f, 0.66f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
    }

    @Override
    public tgdv func_77655_b(String string) {
        GameRegistry.registerItem(this, string);
        return super.func_77655_b(string);
    }
}

