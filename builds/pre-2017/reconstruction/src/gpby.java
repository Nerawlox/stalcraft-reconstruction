/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiOtherInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.IInventory;

public class gpby
implements yctv<zwyn> {
    @Override
    public zwyn _a(EntityLivingBase entityLivingBase, IInventory ... iInventoryArray) {
        return new zwyn(entityLivingBase, iInventoryArray);
    }

    @Override
    public zwyn _a(ccxr ccxr2) {
        return new zwyn(ccxr2._a, ccxr2._a.inventory);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public GuiContainer _a(zwyn zwyn2) {
        if (zwyn2.owner == Minecraft._E()._t) {
            if (zwyn2.player.capabilities._d) {
                return new qngy(zwyn2.player);
            }
            return new cebg(zwyn2.player);
        }
        return new GuiOtherInventory(zwyn2);
    }

    @Override
    public int _a() {
        return 40;
    }

    @Override
    public int _b() {
        return 9;
    }
}

