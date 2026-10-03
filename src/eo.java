/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ez
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class eo
extends ey {
    private String a;
    private int b;
    private int c = Integer.MAX_VALUE;
    private int d;
    private float e;
    private int f;

    public eo() {
    }

    public eo(String par1Str, double par2, double par4, double par6, float par8, float par9) {
        this.a = par1Str;
        this.b = (int)(par2 * 8.0);
        this.c = (int)(par4 * 8.0);
        this.d = (int)(par6 * 8.0);
        this.e = par8;
        this.f = (int)(par9 * 63.0f);
        if (this.f < 0) {
            this.f = 0;
        }
        if (this.f > 255) {
            this.f = 255;
        }
    }

    @Override
    public void a(DataInput par1DataInput) throws IOException {
        this.a = eo.a(par1DataInput, 256);
        this.b = par1DataInput.readInt();
        this.c = par1DataInput.readInt();
        this.d = par1DataInput.readInt();
        this.e = par1DataInput.readFloat();
        this.f = par1DataInput.readUnsignedByte();
    }

    @Override
    public void a(DataOutput par1DataOutput) throws IOException {
        eo.a(this.a, par1DataOutput);
        par1DataOutput.writeInt(this.b);
        par1DataOutput.writeInt(this.c);
        par1DataOutput.writeInt(this.d);
        par1DataOutput.writeFloat(this.e);
        par1DataOutput.writeByte(this.f);
    }

    @Override
    public void a(ez par1NetHandler) {
        par1NetHandler.a(this);
    }

    @Override
    public int a() {
        return 24;
    }

    @SideOnly(value=Side.CLIENT)
    public String d() {
        return this.a;
    }

    @SideOnly(value=Side.CLIENT)
    public double f() {
        return (float)this.b / 8.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public double g() {
        return (float)this.c / 8.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public double h() {
        return (float)this.d / 8.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public float i() {
        return this.e;
    }

    @SideOnly(value=Side.CLIENT)
    public float j() {
        return (float)this.f / 63.0f;
    }
}

