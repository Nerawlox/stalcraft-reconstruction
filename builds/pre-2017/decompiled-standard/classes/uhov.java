/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import net.minecraft.util.eidj;

public class uhov
extends hurg {
    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public double func_82115_m() {
        twgu twgu2 = this.func_70311_o();
        return Math.min(fmea._a._a(twgu2), (float)(ClientProxy.decorblockRenderDistance.value * ClientProxy.decorblockRenderDistance.value));
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void func_70312_q() {
        super.func_70312_q();
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public eidj getRenderBoundingBox() {
        twgu twgu2 = this.func_70311_o();
        if (twgu2 == null) {
            return hurg.INFINITE_EXTENT_AABB;
        }
        return eidj._a()._a((double)this.field_70329_l + twgu2.field_72026_ch - 4.0, (double)this.field_70330_m + twgu2.field_72023_ci - 4.0, (double)this.field_70327_n + twgu2.field_72024_cj - 4.0, (double)this.field_70329_l + twgu2.field_72021_ck + 5.0, (double)this.field_70330_m + twgu2.field_72022_cl + 5.0, (double)this.field_70327_n + twgu2.field_72019_cm + 5.0);
    }
}

