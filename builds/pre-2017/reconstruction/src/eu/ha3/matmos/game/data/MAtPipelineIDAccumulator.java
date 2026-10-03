/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.GenericSheet;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.engine.interfaces.Sheet;
import eu.ha3.matmos.game.data.MAtScanCoordsPipeline;
import eu.ha3.matmos.game.system.MAtMod;
import net.minecraft.client.Minecraft;

public class MAtPipelineIDAccumulator
extends MAtScanCoordsPipeline {
    private Sheet<Integer> tempnormal = new GenericSheet<Integer>(4096, 0);
    private int count;
    private String normalName;
    private String proportionnalName;
    private int proportionnalTotal;

    public MAtPipelineIDAccumulator(MAtMod mAtMod, IntegerData integerData, String string, String string2, int n) {
        super(mAtMod, integerData);
        this.normalName = string;
        this.proportionnalName = string2;
        this.proportionnalTotal = n;
    }

    @Override
    void doBegin() {
        this.count = 0;
        for (int i = 0; i < this.tempnormal.getSize(); ++i) {
            this.tempnormal.set(i, 0);
        }
    }

    @Override
    void doInput(long l, long l2, long l3) {
        int n = Minecraft._E()._r.getBlockId((int)l, (int)l2, (int)l3);
        if (n >= this.tempnormal.getSize() || n < 0) {
            return;
        }
        this.tempnormal.set(n, this.tempnormal.get(n) + 1);
        ++this.count;
    }

    @Override
    void doFinish() {
        Sheet<Integer> sheet = null;
        Sheet<Integer> sheet2 = null;
        sheet = this.data().getSheet(this.normalName);
        if (this.proportionnalName != null) {
            sheet2 = this.data().getSheet(this.proportionnalName);
        }
        for (int i = 0; i < this.tempnormal.getSize(); ++i) {
            sheet.set(i, this.tempnormal.get(i));
            if (this.proportionnalName == null) continue;
            sheet2.set(i, (int)((float)(this.proportionnalTotal * this.tempnormal.get(i)) / (float)this.count));
        }
    }
}

