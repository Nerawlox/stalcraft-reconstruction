/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import java.awt.Color;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemStaff;

public class ItemElementalStaff
extends ItemStaff {
    public ItemElementalStaff(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n, enumNpcToolMaterial);
        this.setHasSubtypes(true);
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        float[] fArray = EntitySheep.fleeceColorTable[itemStack._j()];
        return new Color(fArray[0], fArray[1], fArray[2]).getRGB();
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 0; i < 16; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    public ItemStack getProjectile(ItemStack itemStack) {
        return new ItemStack(CustomItems.orb, 1, itemStack._j());
    }

    @Override
    public void spawnParticle(ItemStack itemStack, EntityPlayer entityPlayer) {
        CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", itemStack._j(), 4);
    }
}

