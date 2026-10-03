/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.entity.ezey;

public class qoia
extends cezg {
    public int _a;
    public List _b;

    public qoia() {
    }

    public qoia(int n, ezey ezey2, boolean bl) {
        this._a = n;
        this._b = bl ? ezey2._c() : ezey2._b();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = ezey._a(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        ezey._a(this._b, dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72493_a(this);
    }

    @Override
    public int func_73284_a() {
        return 5;
    }

    public List _a() {
        return this._b;
    }
}

