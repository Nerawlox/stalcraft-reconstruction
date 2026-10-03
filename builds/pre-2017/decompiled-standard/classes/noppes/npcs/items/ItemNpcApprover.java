/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;

public class ItemNpcApprover
extends tgdv {
    public ItemNpcApprover(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.field_77777_bU = 1;
        this.func_77637_a(CustomItems.tab);
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
        this.field_77791_bV = tgdv.field_77681_I.func_77617_a(0);
    }
}

