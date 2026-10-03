/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class MAtProcessorEnchantments
extends MAtProcessorModel {
    public MAtProcessorEnchantments(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
    }

    @Override
    protected void doProcess() {
        Set<Integer> set = this.getRequired();
        for (Integer object2 : set) {
            this.setValue(object2, 0);
        }
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        ItemStack itemStack = this.getItem(entityClientPlayerMP);
        if (itemStack != null && itemStack._r() != null && itemStack._r()._d() > 0) {
            int n = itemStack._r()._d();
            NBTTagList nBTTagList = itemStack._r();
            for (int i = 0; i < n; ++i) {
                short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
                if (s >= 64 || s < 0 || !set.contains(s)) continue;
                short s2 = ((NBTTagCompound)nBTTagList._b(i))._e("lvl");
                this.setValue(s, s2);
            }
        }
    }

    protected abstract ItemStack getItem(EntityPlayer var1);
}

