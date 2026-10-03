/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;

public class MAtProcessorOptions
extends MAtProcessorModel {
    public MAtProcessorOptions(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
    }

    @Override
    protected void doProcess() {
        this.setValue(0, this.mod().getConfig().getBoolean("useroptions.altitudes.high") ? 1 : 0);
        this.setValue(1, this.mod().getConfig().getBoolean("useroptions.altitudes.low") ? 1 : 0);
    }
}

