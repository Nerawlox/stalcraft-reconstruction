/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.eifc;
import gloomyfolken.mods.core.misc.jxsn;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class kjwj
extends Item
implements jxsn {
    protected final List<String> _b_;

    public kjwj(int n, String string, String string2, List<String> list, int n2) {
        super(n - 256);
        this.setUnlocalizedName(eifc._a(string) + "_" + n);
        LanguageRegistry.addName(this, string);
        this.setTextureName(string2);
        this._b_ = list;
        this.maxStackSize = n2;
        this.setCreativeTab(GloomyCore.tab);
    }

    @Override
    public final void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bl) {
    }

    @Override
    public void _b(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list) {
        list.addAll(this._b_);
    }
}

