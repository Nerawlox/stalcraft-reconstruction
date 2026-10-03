/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.items.ItemNpcInterface;

public class ItemMusic
extends ItemNpcInterface {
    public ItemMusic(int n) {
        super(n);
        this.func_77637_a(CustomItems.tabMisc);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (ozlu2.field_72995_K) {
            return cvzo2;
        }
        int n = ozlu2.field_73012_v.nextInt(24);
        float f = (float)Math.pow(2.0, (double)(n - 12) / 12.0);
        String string = "harp";
        ozlu2.func_72908_a(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, "note." + string, 3.0f, f);
        ozlu2.func_72869_a("note", entityPlayer.field_70163_u, entityPlayer.field_70163_u + 1.2, entityPlayer.field_70163_u, (double)n / 24.0, 0.0, 0.0);
        return cvzo2;
    }
}

