/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.util.zwat;

public class cwaz
extends cezg {
    public String _a;
    public boolean _b = true;

    public cwaz() {
    }

    public cwaz(zwat zwat2) {
        this(zwat2._i());
    }

    public cwaz(zwat zwat2, boolean bl) {
        this(zwat2._i(), bl);
    }

    public cwaz(String string) {
        this(string, true);
    }

    public cwaz(String string, boolean bl) {
        if (string.length() > Short.MAX_VALUE) {
            string = string.substring(0, Short.MAX_VALUE);
        }
        this._a = string;
        this._b = bl;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = cwaz.func_73282_a(dataInput, Short.MAX_VALUE);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        cwaz.func_73271_a(this._a, dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72481_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2 + this._a.length() * 2;
    }

    public boolean _a() {
        return this._b;
    }
}

