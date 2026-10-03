/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

@SideOnly(value=Side.CLIENT)
public class EntityMovingGrassFastFX
extends EntityFX {
    protected int offsetIndex;
    protected float lightScale = 0.8f;
    protected boolean flipU;

    public EntityMovingGrassFastFX(ozlu ozlu2, double d, double d2, double d3, float f, int n, int n2, float f2, int n3, dwan dwan2, boolean bl) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70159_w = f;
        this.field_70544_f = f;
        this.field_70181_x = 1.0;
        this.field_70179_y = n2;
        this.offsetIndex = n + 1;
        this.field_70552_h = (float)(n3 >> 16 & 0xFF) * 0.00392f * f2;
        this.field_70553_i = (float)(n3 >> 8 & 0xFF) * 0.00392f * f2;
        this.field_70551_j = (float)(n3 & 0xFF) * 0.00392f * f2;
        this.field_70547_e = 22;
        this.field_70145_X = true;
        this.field_70550_a = dwan2;
        this.flipU = bl;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.field_70181_x = 1.0 - (double)this.field_70546_d / (double)this.field_70547_e;
        this.field_70544_f = (float)(this.field_70159_w * this.field_70181_x);
        this.lightScale = 1.0f - (float)this.field_70181_x * 0.2f;
        this.field_70181_x *= 1.8;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        double d;
        double d2;
        if (this.flipU) {
            d2 = this.field_70550_a.func_94212_f();
            d = this.field_70550_a.func_94209_e();
        } else {
            d2 = this.field_70550_a.func_94209_e();
            d = this.field_70550_a.func_94212_f();
        }
        double d3 = this.field_70550_a.func_94206_g();
        double d4 = this.field_70550_a.func_94210_h();
        double d5 = this.field_70165_t - EntityFX.field_70556_an;
        double d6 = this.field_70163_u - EntityFX.field_70554_ao;
        double d7 = this.field_70161_v - EntityFX.field_70555_ap;
        double d8 = d6 - BlockRenderer.offsetMap24px[0][0];
        double d9 = d6 + BlockRenderer.offsetMap24px[0][0] + (double)this.field_70544_f;
        double d10 = d5 - BlockRenderer.offsetMap24px[this.offsetIndex][0];
        double d11 = d5 + BlockRenderer.offsetMap24px[this.offsetIndex][0];
        double d12 = d7 - BlockRenderer.offsetMap24px[this.offsetIndex][1];
        double d13 = d7 + BlockRenderer.offsetMap24px[this.offsetIndex][1];
        double d14 = BlockRenderer.offsetMap24px[this.offsetIndex][0] * this.field_70181_x;
        double d15 = BlockRenderer.offsetMap24px[this.offsetIndex][1] * this.field_70181_x;
        htvf2.func_78380_c((int)this.field_70179_y);
        htvf2.func_78369_a(this.field_70552_h * this.lightScale, this.field_70553_i * this.lightScale, this.field_70551_j * this.lightScale, this.field_82339_as);
        htvf2.func_78374_a(d11 + d14, d9, d13 - d15, d2, d3);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d10 + d14, d9, d12 - d15, d, d3);
        htvf2.func_78374_a(d11 - d14, d9, d13 + d15, d2, d3);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d10 - d14, d9, d12 + d15, d, d3);
        htvf2.func_78374_a(d10 - d14, d9, d12 + d15, d, d3);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d11 - d14, d9, d13 + d15, d2, d3);
        htvf2.func_78374_a(d10 + d14, d9, d12 - d15, d, d3);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d11 + d14, d9, d13 - d15, d2, d3);
        d10 = d5 - BlockRenderer.offsetMap24px[this.offsetIndex][2];
        d11 = d5 + BlockRenderer.offsetMap24px[this.offsetIndex][2];
        d12 = d7 - BlockRenderer.offsetMap24px[this.offsetIndex][3];
        d13 = d7 + BlockRenderer.offsetMap24px[this.offsetIndex][3];
        d14 = BlockRenderer.offsetMap24px[this.offsetIndex][0] * this.field_70181_x;
        d15 = BlockRenderer.offsetMap24px[this.offsetIndex][1] * this.field_70181_x;
        htvf2.func_78374_a(d11 - d14, d9, d13 - d15, d2, d3);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d10 - d14, d9, d12 - d15, d, d3);
        htvf2.func_78374_a(d11 + d14, d9, d13 + d15, d2, d3);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d10 + d14, d9, d12 + d15, d, d3);
        htvf2.func_78374_a(d10 + d14, d9, d12 + d15, d, d3);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d11 + d14, d9, d13 + d15, d2, d3);
        htvf2.func_78374_a(d10 - d14, d9, d12 - d15, d, d3);
        htvf2.func_78374_a(d10, d8, d12, d, d4);
        htvf2.func_78374_a(d11, d8, d13, d2, d4);
        htvf2.func_78374_a(d11 - d14, d9, d13 - d15, d2, d3);
    }
}

