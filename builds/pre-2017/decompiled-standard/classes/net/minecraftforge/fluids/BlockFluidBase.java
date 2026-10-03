/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.minecraft.util.ofbx;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

public abstract class BlockFluidBase
extends twgu
implements IFluidBlock {
    protected static final Map<Integer, Boolean> defaultDisplacementIds = new HashMap<Integer, Boolean>();
    protected Map<Integer, Boolean> displacementIds = new HashMap<Integer, Boolean>();
    protected int quantaPerBlock = 8;
    protected float quantaPerBlockFloat = 8.0f;
    protected int density = 1;
    protected int densityDir = -1;
    protected int temperature = 295;
    protected int tickRate = 20;
    protected int renderPass = 1;
    protected int maxScaledLight = 0;
    protected final String fluidName;

    public BlockFluidBase(int n, Fluid fluid, tflj tflj2) {
        super(n, tflj2);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.func_71907_b(true);
        this.func_71896_v();
        this.fluidName = fluid.getName();
        this.density = fluid.density;
        this.temperature = fluid.temperature;
        this.maxScaledLight = fluid.luminosity;
        this.tickRate = fluid.viscosity / 200;
        this.densityDir = fluid.density > 0 ? -1 : 1;
        fluid.setBlockID(n);
        this.displacementIds.putAll(defaultDisplacementIds);
    }

    public BlockFluidBase setQuantaPerBlock(int n) {
        if (n > 16 || n < 1) {
            n = 8;
        }
        this.quantaPerBlock = n;
        this.quantaPerBlockFloat = n;
        return this;
    }

    public BlockFluidBase setDensity(int n) {
        if (n == 0) {
            n = 1;
        }
        this.density = n;
        this.densityDir = n > 0 ? -1 : 1;
        return this;
    }

    public BlockFluidBase setTemperature(int n) {
        this.temperature = n;
        return this;
    }

    public BlockFluidBase setTickRate(int n) {
        if (n <= 0) {
            n = 20;
        }
        this.tickRate = n;
        return this;
    }

    public BlockFluidBase setRenderPass(int n) {
        this.renderPass = n;
        return this;
    }

    public BlockFluidBase setMaxScaledLight(int n) {
        this.maxScaledLight = n;
        return this;
    }

    public boolean canDisplace(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72799_c(n, n2, n3)) {
            return true;
        }
        int n4 = sdrg2.func_72798_a(n, n2, n3);
        if (n4 == this.field_71990_ca) {
            return false;
        }
        if (this.displacementIds.containsKey(n4)) {
            return this.displacementIds.get(n4);
        }
        tflj tflj2 = twgu.field_71973_m[n4].field_72018_cp;
        if (tflj2._c() || tflj2 == tflj._D) {
            return false;
        }
        int n5 = BlockFluidBase.getDensity(sdrg2, n, n2, n3);
        if (n5 == Integer.MAX_VALUE) {
            return true;
        }
        return this.density > n5;
    }

    public boolean displaceIfPossible(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72799_c(n, n2, n3)) {
            return true;
        }
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        if (n4 == this.field_71990_ca) {
            return false;
        }
        if (this.displacementIds.containsKey(n4)) {
            if (this.displacementIds.get(n4).booleanValue()) {
                twgu.field_71973_m[n4].func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                return true;
            }
            return false;
        }
        tflj tflj2 = twgu.field_71973_m[n4].field_72018_cp;
        if (tflj2._c() || tflj2 == tflj._D) {
            return false;
        }
        int n5 = BlockFluidBase.getDensity(ozlu2, n, n2, n3);
        if (n5 == Integer.MAX_VALUE) {
            twgu.field_71973_m[n4].func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            return true;
        }
        return this.density > n5;
    }

    public abstract int getQuantaValue(sdrg var1, int var2, int var3, int var4);

    @Override
    public abstract boolean func_71913_a(int var1, boolean var2);

    public abstract int getMaxRenderHeightMeta();

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.tickRate);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.tickRate);
    }

    @Override
    public boolean func_82506_l() {
        return false;
    }

    @Override
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return true;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return this.tickRate;
    }

    @Override
    public void func_71901_a(ozlu ozlu2, int n, int n2, int n3, Entity entity, ofbx ofbx2) {
        if (this.densityDir > 0) {
            return;
        }
        ofbx ofbx3 = this.getFlowVector(ozlu2, n, n2, n3);
        ofbx2._c += ofbx3._c * (double)(this.quantaPerBlock * 4);
        ofbx2._d += ofbx3._d * (double)(this.quantaPerBlock * 4);
        ofbx2._e += ofbx3._e * (double)(this.quantaPerBlock * 4);
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        if (this.maxScaledLight == 0) {
            return super.getLightValue(sdrg2, n, n2, n3);
        }
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        return (int)((float)n4 / this.quantaPerBlockFloat * (float)this.maxScaledLight);
    }

    @Override
    public int func_71857_b() {
        return FluidRegistry.renderIdFluid;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public float func_71870_f(sdrg sdrg2, int n, int n2, int n3) {
        float f;
        float f2 = sdrg2.func_72801_o(n, n2, n3);
        return f2 > (f = sdrg2.func_72801_o(n, n2 + 1, n3)) ? f2 : f;
    }

    @Override
    public int func_71874_e(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72802_i(n, n2, n3, 0);
        int n5 = sdrg2.func_72802_i(n, n2 + 1, n3, 0);
        int n6 = n4 & 0xFF;
        int n7 = n5 & 0xFF;
        int n8 = n4 >> 16 & 0xFF;
        int n9 = n5 >> 16 & 0xFF;
        return (n6 > n7 ? n6 : n7) | (n8 > n9 ? n8 : n9) << 16;
    }

    @Override
    public int func_71856_s_() {
        return this.renderPass;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (sdrg2.func_72798_a(n, n2, n3) != this.field_71990_ca) {
            return !sdrg2.func_72804_r(n, n2, n3);
        }
        tflj tflj2 = sdrg2.func_72803_f(n, n2, n3);
        return tflj2 == this.field_72018_cp ? false : super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    public static final int getDensity(sdrg sdrg2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (!(twgu2 instanceof BlockFluidBase)) {
            return Integer.MAX_VALUE;
        }
        return ((BlockFluidBase)twgu2).density;
    }

    public static final int getTemperature(sdrg sdrg2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (!(twgu2 instanceof BlockFluidBase)) {
            return Integer.MAX_VALUE;
        }
        return ((BlockFluidBase)twgu2).temperature;
    }

    public static double getFlowDirection(sdrg sdrg2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (!sdrg2.func_72803_f(n, n2, n3)._d()) {
            return -1000.0;
        }
        ofbx ofbx2 = ((BlockFluidBase)twgu2).getFlowVector(sdrg2, n, n2, n3);
        return ofbx2._c == 0.0 && ofbx2._e == 0.0 ? -1000.0 : Math.atan2(ofbx2._e, ofbx2._c) - 1.5707963267948966;
    }

    public final int getQuantaValueBelow(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = this.getQuantaValue(sdrg2, n, n2, n3);
        if (n5 >= n4) {
            return -1;
        }
        return n5;
    }

    public final int getQuantaValueAbove(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = this.getQuantaValue(sdrg2, n, n2, n3);
        if (n5 <= n4) {
            return -1;
        }
        return n5;
    }

    public final float getQuantaPercentage(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = this.getQuantaValue(sdrg2, n, n2, n3);
        return (float)n4 / this.quantaPerBlockFloat;
    }

    public ofbx getFlowVector(sdrg sdrg2, int n, int n2, int n3) {
        int n4;
        ofbx ofbx2 = sdrg2.func_82732_R()._a(0.0, 0.0, 0.0);
        int n5 = this.quantaPerBlock - this.getQuantaValue(sdrg2, n, n2, n3);
        for (n4 = 0; n4 < 4; ++n4) {
            int n6;
            int n7 = n;
            int n8 = n3;
            switch (n4) {
                case 0: {
                    --n7;
                    break;
                }
                case 1: {
                    --n8;
                    break;
                }
                case 2: {
                    ++n7;
                    break;
                }
                case 3: {
                    ++n8;
                }
            }
            int n9 = this.quantaPerBlock - this.getQuantaValue(sdrg2, n7, n2, n8);
            if (n9 >= this.quantaPerBlock) {
                if (sdrg2.func_72803_f(n7, n2, n8)._c() || (n9 = this.quantaPerBlock - this.getQuantaValue(sdrg2, n7, n2 - 1, n8)) < 0) continue;
                n6 = n9 - (n5 - this.quantaPerBlock);
                ofbx2 = ofbx2._c((n7 - n) * n6, (n2 - n2) * n6, (n8 - n3) * n6);
                continue;
            }
            if (n9 < 0) continue;
            n6 = n9 - n5;
            ofbx2 = ofbx2._c((n7 - n) * n6, (n2 - n2) * n6, (n8 - n3) * n6);
        }
        if (sdrg2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca) {
            int n10 = n4 = this.func_71924_d(sdrg2, n, n2, n3 - 1, 2) || this.func_71924_d(sdrg2, n, n2, n3 + 1, 3) || this.func_71924_d(sdrg2, n - 1, n2, n3, 4) || this.func_71924_d(sdrg2, n + 1, n2, n3, 5) || this.func_71924_d(sdrg2, n, n2 + 1, n3 - 1, 2) || this.func_71924_d(sdrg2, n, n2 + 1, n3 + 1, 3) || this.func_71924_d(sdrg2, n - 1, n2 + 1, n3, 4) || this.func_71924_d(sdrg2, n + 1, n2 + 1, n3, 5) ? 1 : 0;
            if (n4 != 0) {
                ofbx2 = ofbx2._a()._c(0.0, -6.0, 0.0);
            }
        }
        ofbx2 = ofbx2._a();
        return ofbx2;
    }

    @Override
    public Fluid getFluid() {
        return FluidRegistry.getFluid(this.fluidName);
    }

    @Override
    public float getFilledPercentage(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = this.getQuantaValue(ozlu2, n, n2, n3) + 1;
        float f = (float)n4 / this.quantaPerBlockFloat;
        if (f > 1.0f) {
            f = 1.0f;
        }
        return f * (float)(this.density > 0 ? 1 : -1);
    }

    static {
        defaultDisplacementIds.put(twgu.field_72054_aE.field_71990_ca, false);
        defaultDisplacementIds.put(twgu.field_72045_aL.field_71990_ca, false);
        defaultDisplacementIds.put(twgu.field_72053_aD.field_71990_ca, false);
        defaultDisplacementIds.put(twgu.field_72042_aI.field_71990_ca, false);
        defaultDisplacementIds.put(twgu.field_72040_aX.field_71990_ca, false);
    }
}

