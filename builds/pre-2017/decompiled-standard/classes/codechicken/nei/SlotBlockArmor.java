/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import net.minecraft.entity.player.eidj;

public class SlotBlockArmor
extends yesp {
    public SlotBlockArmor(ohws ohws2, eidj eidj2, int n, int n2, int n3, int n4) {
        super(ohws2, eidj2, n, n2, n3, n4);
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return super.func_75214_a(cvzo2) || CommonUtils.isBlock(cvzo2._d);
    }
}

