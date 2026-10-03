/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ejection.kjui;
import gloomyfolken.mods.ejection.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class zwaw
extends ytyx {
    private int _a;

    public zwaw(int n) {
        this._a = n;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        if (this._a < 0 && kjui._a._b != null) {
            kjui._a._b._e();
        }
        if (this._a >= 0) {
            if (kjui._a._b == null) {
                new pidb(false, this._a)._a();
            } else {
                kjui._a._b._a = this._a;
            }
        }
    }

    public zwaw() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }
}

