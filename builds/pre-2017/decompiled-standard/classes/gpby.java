/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiOtherInventory;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;

public class gpby
implements yctv<zwyn> {
    @Override
    public zwyn _a(EntityLivingBase entityLivingBase, mssh ... msshArray) {
        return new zwyn(entityLivingBase, msshArray);
    }

    @Override
    public zwyn _a(ccxr ccxr2) {
        return new zwyn(ccxr2._a, ccxr2._a.field_71071_by);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public zybc _a(zwyn zwyn2) {
        if (zwyn2.owner == xpzm._E()._t) {
            if (zwyn2.player.field_71075_bZ._d) {
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

