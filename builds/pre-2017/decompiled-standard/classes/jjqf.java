/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class jjqf
extends cezg {
    public String field_73630_a;
    public int field_73628_b;
    public byte[] field_73629_c;

    public jjqf() {
    }

    public jjqf(String string, byte[] byArray) {
        this.field_73630_a = string;
        this.field_73629_c = byArray;
        if (byArray != null) {
            this.field_73628_b = byArray.length;
            if (this.field_73628_b > Short.MAX_VALUE) {
                throw new IllegalArgumentException("Payload may not be larger than 32k");
            }
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this.field_73630_a = jjqf.func_73282_a(dataInput, 20);
        this.field_73628_b = dataInput.readShort();
        if (this.field_73628_b > 0 && this.field_73628_b < Short.MAX_VALUE) {
            this.field_73629_c = new byte[this.field_73628_b];
            dataInput.readFully(this.field_73629_c);
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        jjqf.func_73271_a(this.field_73630_a, dataOutput);
        dataOutput.writeShort((short)this.field_73628_b);
        if (this.field_73629_c != null) {
            dataOutput.write(this.field_73629_c);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72501_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2 + this.field_73630_a.length() * 2 + 2 + this.field_73628_b;
    }
}

