/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.tileentity;

import carpentersblocks.tileentity.CompatibilityHelper;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class TECarpentersBlock
extends hurg {
    public short[] cover = new short[7];
    public byte[] pattern = new byte[7];
    public byte[] color = new byte[7];
    public byte[] overlay = new byte[7];
    public short data = 0;

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        if (!qoac2._c("color")) {
            CompatibilityHelper.convertData(this, qoac2);
        } else {
            for (int i = 0; i < 7; ++i) {
                this.cover[i] = qoac2._e("cover_" + i);
            }
            this.pattern = qoac2._k("pattern");
            this.color = qoac2._k("color");
            this.overlay = qoac2._k("overlay");
            this.data = qoac2._e("data");
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        for (int i = 0; i < 7; ++i) {
            qoac2._a("cover_" + i, this.cover[i]);
        }
        qoac2._a("pattern", this.pattern);
        qoac2._a("color", this.color);
        qoac2._a("overlay", this.overlay);
        qoac2._a("data", this.data);
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, qoac2);
    }

    public void writeToBytes(DataOutput dataOutput) throws IOException {
        boolean bl = this.hasCover();
        boolean bl2 = this.hasNonZeroByte(this.pattern);
        boolean bl3 = this.hasNonZeroByte(this.color);
        boolean bl4 = this.hasNonZeroByte(this.overlay);
        dataOutput.writeByte((bl ? 1 : 0) << 3 | (bl2 ? 1 : 0) << 2 | (bl3 ? 1 : 0) << 1 | (bl4 ? 1 : 0));
        if (bl) {
            for (short s : this.cover) {
                dataOutput.writeShort(s);
            }
        } else {
            dataOutput.writeShort(this.cover[this.cover.length - 1]);
        }
        if (bl2) {
            dataOutput.write(this.pattern);
        }
        if (bl3) {
            dataOutput.write(this.color);
        }
        if (bl4) {
            dataOutput.write(this.overlay);
        }
        dataOutput.writeShort(this.data);
    }

    public void readFromBytes(DataInput dataInput) throws IOException {
        boolean bl;
        byte by = dataInput.readByte();
        boolean bl2 = (by & 8) != 0;
        boolean bl3 = (by & 4) != 0;
        boolean bl4 = (by & 2) != 0;
        boolean bl5 = bl = (by & 1) != 0;
        if (bl2) {
            for (int i = 0; i < this.cover.length; ++i) {
                this.cover[i] = dataInput.readShort();
            }
        } else {
            this.cover[this.cover.length - 1] = dataInput.readShort();
        }
        if (bl3) {
            dataInput.readFully(this.pattern);
        }
        if (bl4) {
            dataInput.readFully(this.color);
        }
        if (bl) {
            dataInput.readFully(this.overlay);
        }
        this.data = dataInput.readShort();
    }

    private boolean hasNonZeroByte(byte[] byArray) {
        boolean bl = false;
        for (byte by : byArray) {
            if (by == 0) continue;
            bl = true;
        }
        return bl;
    }

    private boolean hasCover() {
        boolean bl = false;
        for (int i = 0; i < 6; ++i) {
            if (this.cover[i] == 0) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.func_70307_a(wpte2._e);
        if (this.field_70331_k.field_72995_K) {
            xpzm._E()._s._c(this.field_70329_l, this.field_70330_m, this.field_70327_n);
            this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
        }
    }

    public static TECarpentersBlock get(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2 instanceof zzie) {
            return TECarpentersBlock.get(((zzie)sdrg2)._e, n, n2, n3);
        }
        return TECarpentersBlock.get((ozlu)sdrg2, n, n2, n3);
    }

    public static TECarpentersBlock get(ozlu ozlu2, int n, int n2, int n3) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof TECarpentersBlock) {
            return (TECarpentersBlock)hurg2;
        }
        return null;
    }
}

