/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.IInventory;

public class loee
implements yctv<jzak> {
    public jzak _b(EntityLivingBase entityLivingBase, IInventory ... iInventoryArray) {
        return new jzak(entityLivingBase, iInventoryArray);
    }

    public jzak _b(ccxr ccxr2) {
        return new jzak(ccxr2._a, ccxr2._a.inventory, tupg._a((ccxr)ccxr2)._c);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public GuiContainer _a(jzak jzak2) {
        if (jzak2.owner == Minecraft._E()._t) {
            return new nuis(jzak2.player);
        }
        return new hsxd(jzak2);
    }

    @Override
    public int _a() {
        return 61;
    }

    @Override
    public int _b() {
        return 4;
    }

    @Override
    public /* synthetic */ zwyn _a(ccxr ccxr2) {
        return this._b(ccxr2);
    }

    @Override
    public /* synthetic */ zwyn _a(EntityLivingBase entityLivingBase, IInventory[] iInventoryArray) {
        return this._b(entityLivingBase, iInventoryArray);
    }
}

