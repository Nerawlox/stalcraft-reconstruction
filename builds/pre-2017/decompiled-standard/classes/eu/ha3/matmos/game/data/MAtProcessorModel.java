/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.conv.ProcessorModel;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.system.MAtMod;

public abstract class MAtProcessorModel
extends ProcessorModel {
    private MAtMod mod;

    public MAtProcessorModel(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(integerData, string, string2);
        this.mod = mAtMod;
    }

    public MAtMod mod() {
        return this.mod;
    }
}

