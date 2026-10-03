/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ez
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class eq
extends ey {
    public int a;
    public byte b;
    public byte c;
    public byte d;
    public byte e;
    public byte f;
    public boolean g;

    public eq() {
    }

    public eq(int par1) {
        this.a = par1;
    }

    @Override
    public void a(DataInput par1DataInput) throws IOException {
        this.a = par1DataInput.readInt();
    }

    @Override
    public void a(DataOutput par1DataOutput) throws IOException {
        par1DataOutput.writeInt(this.a);
    }

    @Override
    public void a(ez par1NetHandler) {
        par1NetHandler.a(this);
    }

    @Override
    public int a() {
        return 4;
    }

    @Override
    public String toString() {
        return "Entity_" + super.toString();
    }

    @Override
    public boolean e() {
        return true;
    }

    @Override
    public boolean a(ey par1Packet) {
        eq packet30entity = (eq)par1Packet;
        return packet30entity.a == this.a;
    }
}

