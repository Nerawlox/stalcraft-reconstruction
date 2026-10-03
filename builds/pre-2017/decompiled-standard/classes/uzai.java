/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.EntityLivingBase;

public class uzai
extends oxot {
    public qoac _c;

    public uzai() {
    }

    public uzai(EntityLivingBase entityLivingBase) {
        super(entityLivingBase.func_110143_aJ() / entityLivingBase.func_110138_aP());
        this._c = new qoac();
        entityLivingBase.func_70039_c(this._c);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        bsvf._a(this._c, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._c = bsvf._a(dataInput);
    }
}

