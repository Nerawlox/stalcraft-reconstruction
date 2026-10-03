/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public class ntra
extends zwat {
    public double _a;
    public double _b;
    public double _c;

    public ntra(double d, double d2, double d3) {
        this._a = d;
        this._b = d2;
        this._c = d3;
    }

    @Override
    public void processClient(boolean bl) {
        new ntra(this._a, this._b, this._c).sendToServer();
        SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(Minecraft._E()._t);
        smartMovingSelf.anticheat.__aU._m = this._a;
        smartMovingSelf.anticheat.__aU._n = this._b;
        smartMovingSelf.anticheat.__aU._o = this._c;
    }

    public ntra() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readDouble();
        this._b = dataInput.readDouble();
        this._c = dataInput.readDouble();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(this._a);
        dataOutput.writeDouble(this._b);
        dataOutput.writeDouble(this._c);
    }
}

