/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.ugqi;

public class ixoa
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public String _f;

    public ixoa() {
    }

    public ixoa(EntityPainting entityPainting) {
        this._a = entityPainting.field_70157_k;
        this._b = entityPainting.field_70523_b;
        this._c = entityPainting.field_70524_c;
        this._d = entityPainting.field_70521_d;
        this._e = entityPainting.field_82332_a;
        this._f = entityPainting.field_70522_e.__aK;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._f = ixoa.func_73282_a(dataInput, ugqi.__aJ);
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        ixoa.func_73271_a(this._f, dataOutput);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72495_a(this);
    }

    @Override
    public int func_73284_a() {
        return 24;
    }
}

