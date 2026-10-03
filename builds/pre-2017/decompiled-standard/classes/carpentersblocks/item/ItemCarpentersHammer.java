/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.item;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCarpentersHammer
extends tgdv {
    public ItemCarpentersHammer(int n) {
        super(n);
        this.func_77655_b("itemCarpentersHammer");
        if (ItemHandler.itemCarpentersToolsDamageable) {
            this.func_77656_e(300);
        }
        this.canRepair = true;
        this.func_77637_a(CarpentersBlocks.tabCarpentersBlocks);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("carpentersblocks:hammer");
    }
}

