/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  t
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bit
extends bil {
    public double i;
    public double j;

    public bit(String par1Str) {
        super(par1Str);
    }

    @Override
    public void j() {
        atv minecraft = atv.w();
        if (minecraft.f != null && minecraft.h != null) {
            this.a((abw)minecraft.f, minecraft.h.u, minecraft.h.w, minecraft.h.A, false, false);
        } else {
            this.a(null, 0.0, 0.0, 0.0, true, false);
        }
    }

    public void a(abw par1World, double par2, double par4, double par6, boolean par8, boolean par9) {
        if (!this.a.isEmpty()) {
            double d3 = 0.0;
            if (par1World != null && !par8) {
                t chunkcoordinates = par1World.K();
                double d4 = (double)chunkcoordinates.a - par2;
                double d5 = (double)chunkcoordinates.c - par4;
                d3 = -(((par6 %= 360.0) - 90.0) * Math.PI / 180.0 - Math.atan2(d5, d4));
                if (!par1World.t.d()) {
                    d3 = Math.random() * Math.PI * 2.0;
                }
            }
            if (par9) {
                this.i = d3;
            } else {
                double d6;
                for (d6 = d3 - this.i; d6 < -Math.PI; d6 += Math.PI * 2) {
                }
                while (d6 >= Math.PI) {
                    d6 -= Math.PI * 2;
                }
                if (d6 < -1.0) {
                    d6 = -1.0;
                }
                if (d6 > 1.0) {
                    d6 = 1.0;
                }
                this.j += d6 * 0.1;
                this.j *= 0.8;
                this.i += this.j;
            }
            int i2 = (int)((this.i / (Math.PI * 2) + 1.0) * (double)this.a.size()) % this.a.size();
            while (i2 < 0) {
                i2 = (i2 + this.a.size()) % this.a.size();
            }
            if (i2 != this.g) {
                this.g = i2;
                bip.a((int[])this.a.get(this.g), this.e, this.f, this.c, this.d, false, false);
            }
        }
    }
}

