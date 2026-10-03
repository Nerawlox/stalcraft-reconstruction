/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import net.minecraft.client.xpzm;

public class MAtProcessorContact
extends MAtProcessorModel {
    private int[] contactSum = new int[4096];

    public MAtProcessorContact(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
    }

    private void emptyContact() {
        for (int i = 0; i < this.contactSum.length; ++i) {
            this.contactSum[i] = 0;
        }
    }

    @Override
    protected void doProcess() {
        int n;
        xpzm xpzm2 = xpzm._E();
        int n2 = (int)Math.floor(xpzm2._t.field_70165_t);
        int n3 = (int)Math.floor(xpzm2._t.field_70163_u) - 1;
        int n4 = (int)Math.floor(xpzm2._t.field_70161_v);
        this.emptyContact();
        for (n = 0; n < 12; ++n) {
            int n5 = n3 + (n > 7 ? n - 9 : n % 2);
            if (n5 < 0 || n5 >= this.mod().util().getWorldHeight()) continue;
            int n6 = n2 + (n < 4 ? (n < 2 ? -1 : 1) : 0);
            int n7 = n4 + (n > 3 && n < 8 ? (n < 6 ? -1 : 1) : 0);
            int n8 = xpzm._E()._r.func_72798_a(n6, n5, n7);
            if (n8 >= this.contactSum.length && n8 < 0) continue;
            this.contactSum[n8] = this.contactSum[n8] + 1;
        }
        for (n = 0; n < this.contactSum.length; ++n) {
            this.setValue(n, this.contactSum[n]);
        }
    }
}

