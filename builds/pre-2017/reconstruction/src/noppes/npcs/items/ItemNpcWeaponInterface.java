/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.items.ItemRenderInterface;
import org.lwjgl.opengl.GL11;

public class ItemNpcWeaponInterface
extends ItemSword
implements ItemRenderInterface {
    public ItemNpcWeaponInterface(int n, txfz txfz2) {
        super(n - 26700 + CustomNpcs.ItemStartId, txfz2);
        this.setCreativeTab(CustomItems.tab);
        CustomNpcs.proxy.registerItem(this.itemID);
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.66f, 0.66f, 0.66f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
    }

    @Override
    public Item setUnlocalizedName(String string) {
        GameRegistry.registerItem(this, string);
        return super.setUnlocalizedName(string);
    }
}

