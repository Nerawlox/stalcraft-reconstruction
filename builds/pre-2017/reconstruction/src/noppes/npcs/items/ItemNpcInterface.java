/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemRenderInterface;
import org.lwjgl.opengl.GL11;

public class ItemNpcInterface
extends Item
implements ItemRenderInterface {
    public EnumNpcToolMaterial toolMaterial;

    public ItemNpcInterface(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.setCreativeTab(CustomItems.tab);
        CustomNpcs.proxy.registerItem(this.itemID);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.66f, 0.66f, 0.66f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
    }

    @Override
    public int getItemEnchantability() {
        return super.getItemEnchantability();
    }

    @Override
    public Item setUnlocalizedName(String string) {
        GameRegistry.registerItem(this, string);
        return super.setUnlocalizedName(string);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        if (entityLivingBase.getHealth() <= 0.0f) {
            return false;
        }
        itemStack._a(1, entityLivingBase2);
        return true;
    }
}

