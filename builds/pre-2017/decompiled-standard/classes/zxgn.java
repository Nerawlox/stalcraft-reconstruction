/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class zxgn
extends ytyx {
    private Map<Integer, Integer> _a;

    public zxgn(Map<Integer, Integer> map) {
        this._a = map;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.keySet().size());
        for (int n : this._a.keySet()) {
            dataOutput.writeInt(n);
            dataOutput.writeInt(this._a.get(n));
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            this._a.put(dataInput.readInt(), dataInput.readInt());
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof oxhq) {
            ((oxhq)gqjz2)._a(this._a);
        }
    }

    public zxgn() {
    }
}

