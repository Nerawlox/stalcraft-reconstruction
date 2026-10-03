/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NpcSynchronizer;

public class ItemNpcDuplicator
extends tgdv {
    public ItemNpcDuplicator(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.field_77777_bU = 1;
        this.func_77637_a(CustomItems.tab);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            NpcSynchronizer.instance.createDupliEntity(entityPlayer, n, n2, n3);
        }
        return true;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!ozlu2.field_72995_K) {
            NpcSynchronizer.instance.openEditGui(entityPlayer);
        }
        return cvzo2;
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        return 0xCCCCCC;
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = tgdv.field_77682_J.func_77617_a(0);
    }
}

