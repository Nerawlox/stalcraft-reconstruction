/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import java.util.Set;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;

public abstract class MAtProcessorPotionQuality
extends MAtProcessorModel {
    public MAtProcessorPotionQuality(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
    }

    @Override
    protected void doProcess() {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        Set<Integer> set = this.getRequired();
        for (Integer n : set) {
            this.setValue(n, 0);
        }
        for (Integer n : entityClientPlayerMP.func_70651_bq()) {
            supr supr2 = (supr)((Object)n);
            int n2 = supr2._a();
            if (n2 < 32 && n2 >= 0) {
                if (!set.contains(n2)) continue;
                this.setValue(n2, this.getQuality(supr2));
                continue;
            }
            MAtmosConvLogger.warning("Found potion effect which ID is " + n2 + "!!!");
        }
    }

    protected abstract int getQuality(supr var1);
}

