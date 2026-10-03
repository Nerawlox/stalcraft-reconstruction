/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class uxwj
extends ytyx {
    private String _a;
    private String _b;
    private float _c;

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        yuch._b._a(this._a, this._b, this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readUTF();
        this._c = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeUTF(this._b);
        dataOutput.writeFloat(this._c);
    }
}

