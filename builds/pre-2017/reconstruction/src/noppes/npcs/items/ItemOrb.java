/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import java.awt.Color;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import noppes.npcs.items.ItemNpcInterface;

public class ItemOrb
extends ItemNpcInterface {
    public ItemOrb(int n) {
        super(n);
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
}

