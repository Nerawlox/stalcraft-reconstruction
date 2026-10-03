/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.Random;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluidClassic
extends BlockFluidBase {
    protected boolean[] isOptimalFlowDirection = new boolean[4];
    protected int[] flowCost = new int[4];
    protected FluidStack stack;

    public BlockFluidClassic(int n, Fluid fluid, tflj tflj2) {
        super(n, fluid, tflj2);
        this.stack = new FluidStack(fluid, 1000);
    }

    public BlockFluidClassic setFluidStack(FluidStack fluidStack) {
        this.stack = fluidStack;
        return this;
    }

    public BlockFluidClassic setFluidStackAmount(int n) {
        this.stack.amount = n;
        return this;
    }

    @Override
    public int getQuantaValue(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72798_a(n, n2, n3) == 0) {
            return 0;
        }
        if (sdrg2.func_72798_a(n, n2, n3) != this.field_71990_ca) {
            return -1;
        }
        int n4 = this.quantaPerBlock - sdrg2.func_72805_g(n, n2, n3);
        return n4;
    }

    @Override
    public boolean func_71913_a(int n, boolean bl) {
        return bl && n == 0;
    }

    @Override
    public int getMaxRenderHeightMeta() {
        return 0;
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        if (this.maxScaledLight == 0) {
            return super.getLightValue(sdrg2, n, n2, n3);
        }
        int n4 = this.quantaPerBlock - sdrg2.func_72805_g(n, n2, n3) - 1;
        return (int)((float)n4 / this.quantaPerBlockFloat * (float)this.maxScaledLight);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4;
        int n5 = this.quantaPerBlock - ozlu2.func_72805_g(n, n2, n3);
        int n6 = -101;
        if (n5 < this.quantaPerBlock) {
            n4 = n2 - this.densityDir;
            if (ozlu2.func_72798_a(n, n4, n3) == this.field_71990_ca || ozlu2.func_72798_a(n - 1, n4, n3) == this.field_71990_ca || ozlu2.func_72798_a(n + 1, n4, n3) == this.field_71990_ca || ozlu2.func_72798_a(n, n4, n3 - 1) == this.field_71990_ca || ozlu2.func_72798_a(n, n4, n3 + 1) == this.field_71990_ca) {
                n6 = this.quantaPerBlock - 1;
            } else {
                int n7 = -100;
                n7 = this.getLargerQuanta(ozlu2, n - 1, n2, n3, n7);
                n7 = this.getLargerQuanta(ozlu2, n + 1, n2, n3, n7);
                n7 = this.getLargerQuanta(ozlu2, n, n2, n3 - 1, n7);
                n7 = this.getLargerQuanta(ozlu2, n, n2, n3 + 1, n7);
                n6 = n7 - 1;
            }
            if (n6 != n5) {
                n5 = n6;
                if (n6 <= 0) {
                    ozlu2.func_94571_i(n, n2, n3);
                } else {
                    ozlu2.func_72921_c(n, n2, n3, this.quantaPerBlock - n6, 3);
                    ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.tickRate);
                    ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
                }
            }
        } else if (n5 >= this.quantaPerBlock) {
            ozlu2.func_72921_c(n, n2, n3, 0, 2);
        }
        if (this.canDisplace(ozlu2, n, n2 + this.densityDir, n3)) {
            this.flowIntoBlock(ozlu2, n, n2 + this.densityDir, n3, 1);
            return;
        }
        n4 = this.quantaPerBlock - n5 + 1;
        if (n4 >= this.quantaPerBlock) {
            return;
        }
        if (this.isSourceBlock(ozlu2, n, n2, n3) || !this.isFlowingVertically(ozlu2, n, n2, n3)) {
            boolean[] blArray;
            if (ozlu2.func_72798_a(n, n2 - this.densityDir, n3) == this.field_71990_ca) {
                n4 = 1;
            }
            if ((blArray = this.getOptimalFlowDirections(ozlu2, n, n2, n3))[0]) {
                this.flowIntoBlock(ozlu2, n - 1, n2, n3, n4);
            }
            if (blArray[1]) {
                this.flowIntoBlock(ozlu2, n + 1, n2, n3, n4);
            }
            if (blArray[2]) {
                this.flowIntoBlock(ozlu2, n, n2, n3 - 1, n4);
            }
            if (blArray[3]) {
                this.flowIntoBlock(ozlu2, n, n2, n3 + 1, n4);
            }
        }
    }

    public boolean isFlowingVertically(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72798_a(n, n2 + this.densityDir, n3) == this.field_71990_ca || sdrg2.func_72798_a(n, n2, n3) == this.field_71990_ca && this.canFlowInto(sdrg2, n, n2 + this.densityDir, n3);
    }

    public boolean isSourceBlock(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72798_a(n, n2, n3) == this.field_71990_ca && sdrg2.func_72805_g(n, n2, n3) == 0;
    }

    protected boolean[] getOptimalFlowDirections(ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5;
        for (n5 = 0; n5 < 4; ++n5) {
            this.flowCost[n5] = 1000;
            n4 = n;
            int n6 = n2;
            int n7 = n3;
            switch (n5) {
                case 0: {
                    --n4;
                    break;
                }
                case 1: {
                    ++n4;
                    break;
                }
                case 2: {
                    --n7;
                    break;
                }
                case 3: {
                    ++n7;
                }
            }
            if (!this.canFlowInto(ozlu2, n4, n6, n7) || this.isSourceBlock(ozlu2, n4, n6, n7)) continue;
            this.flowCost[n5] = this.canFlowInto(ozlu2, n4, n6 + this.densityDir, n7) ? 0 : this.calculateFlowCost(ozlu2, n4, n6, n7, 1, n5);
        }
        n5 = this.flowCost[0];
        for (n4 = 1; n4 < 4; ++n4) {
            if (this.flowCost[n4] >= n5) continue;
            n5 = this.flowCost[n4];
        }
        for (n4 = 0; n4 < 4; ++n4) {
            this.isOptimalFlowDirection[n4] = this.flowCost[n4] == n5;
        }
        return this.isOptimalFlowDirection;
    }

    protected int calculateFlowCost(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1000;
        for (int i = 0; i < 4; ++i) {
            int n7;
            if (i == 0 && n5 == 1 || i == 1 && n5 == 0 || i == 2 && n5 == 3 || i == 3 && n5 == 2) continue;
            int n8 = n;
            int n9 = n2;
            int n10 = n3;
            switch (i) {
                case 0: {
                    --n8;
                    break;
                }
                case 1: {
                    ++n8;
                    break;
                }
                case 2: {
                    --n10;
                    break;
                }
                case 3: {
                    ++n10;
                }
            }
            if (!this.canFlowInto(ozlu2, n8, n9, n10) || this.isSourceBlock(ozlu2, n8, n9, n10)) continue;
            if (this.canFlowInto(ozlu2, n8, n9 + this.densityDir, n10)) {
                return n4;
            }
            if (n4 >= 4 || (n7 = this.calculateFlowCost(ozlu2, n8, n9, n10, n4 + 1, i)) >= n6) continue;
            n6 = n7;
        }
        return n6;
    }

    protected void flowIntoBlock(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (n4 < 0) {
            return;
        }
        if (this.displaceIfPossible(ozlu2, n, n2, n3)) {
            ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca, n4, 3);
        }
    }

    protected boolean canFlowInto(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72799_c(n, n2, n3)) {
            return true;
        }
        int n4 = sdrg2.func_72798_a(n, n2, n3);
        if (n4 == this.field_71990_ca) {
            return true;
        }
        if (this.displacementIds.containsKey(n4)) {
            return (Boolean)this.displacementIds.get(n4);
        }
        tflj tflj2 = twgu.field_71973_m[n4].field_72018_cp;
        if (tflj2._c() || tflj2 == tflj._h || tflj2 == tflj._i || tflj2 == tflj._D) {
            return false;
        }
        int n5 = BlockFluidClassic.getDensity(sdrg2, n, n2, n3);
        if (n5 == Integer.MAX_VALUE) {
            return true;
        }
        return this.density > n5;
    }

    protected int getLargerQuanta(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = this.getQuantaValue(sdrg2, n, n2, n3);
        if (n5 <= 0) {
            return n4;
        }
        return n5 >= n4 ? n5 : n4;
    }

    @Override
    public FluidStack drain(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        if (!this.isSourceBlock(ozlu2, n, n2, n3)) {
            return null;
        }
        if (bl) {
            ozlu2.func_94571_i(n, n2, n3);
        }
        return this.stack.copy();
    }

    @Override
    public boolean canDrain(ozlu ozlu2, int n, int n2, int n3) {
        return this.isSourceBlock(ozlu2, n, n2, n3);
    }
}

