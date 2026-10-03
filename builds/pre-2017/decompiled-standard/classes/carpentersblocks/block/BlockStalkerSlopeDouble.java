/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.block.BlockStalkerSlope;
import carpentersblocks.data.Slope;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;

public class BlockStalkerSlopeDouble
extends BlockStalkerSlope {
    public BlockStalkerSlopeDouble(int n, twgu twgu2) {
        super(n, twgu2);
        this.func_71864_b("BlockSlopeDouble_" + twgu2.field_71968_b);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        this.getCoverBlock().func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        Slope slope = BlockStalkerSlopeDouble.getSlopeFromMeta(n4);
        this.addSlopeCollision(slope, n, n2 + 1, n3, list);
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        return this.getCoverBlock().func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    @Override
    public boolean shouldRenderBase() {
        return true;
    }
}

