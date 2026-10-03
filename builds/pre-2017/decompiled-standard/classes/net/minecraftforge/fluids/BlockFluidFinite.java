/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.Random;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluidFinite
extends BlockFluidBase {
    public BlockFluidFinite(int n, Fluid fluid, tflj tflj2) {
        super(n, fluid, tflj2);
    }

    @Override
    public int getQuantaValue(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72799_c(n, n2, n3)) {
            return 0;
        }
        if (sdrg2.func_72798_a(n, n2, n3) != this.field_71990_ca) {
            return -1;
        }
        int n4 = sdrg2.func_72805_g(n, n2, n3) + 1;
        return n4;
    }

    @Override
    public boolean func_71913_a(int n, boolean bl) {
        return bl && n == this.quantaPerBlock - 1;
    }

    @Override
    public int getMaxRenderHeightMeta() {
        return this.quantaPerBlock - 1;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4;
        int n5;
        boolean bl = false;
        int n6 = n5 = ozlu2.func_72805_g(n, n2, n3) + 1;
        if ((n5 = this.tryToFlowVerticallyInto(ozlu2, n, n2, n3, n5)) < 1) {
            return;
        }
        if (n5 != n6) {
            bl = true;
            if (n5 == 1) {
                ozlu2.func_72921_c(n, n2, n3, n5 - 1, 2);
                return;
            }
        } else if (n5 == 1) {
            return;
        }
        int n7 = n5 - 1;
        if (this.displaceIfPossible(ozlu2, n, n2, n3 - 1)) {
            ozlu2.func_94575_c(n, n2, n3 - 1, 0);
        }
        if (this.displaceIfPossible(ozlu2, n, n2, n3 + 1)) {
            ozlu2.func_94575_c(n, n2, n3 + 1, 0);
        }
        if (this.displaceIfPossible(ozlu2, n - 1, n2, n3)) {
            ozlu2.func_94575_c(n - 1, n2, n3, 0);
        }
        if (this.displaceIfPossible(ozlu2, n + 1, n2, n3)) {
            ozlu2.func_94575_c(n + 1, n2, n3, 0);
        }
        int n8 = this.getQuantaValueBelow(ozlu2, n, n2, n3 - 1, n7);
        int n9 = this.getQuantaValueBelow(ozlu2, n, n2, n3 + 1, n7);
        int n10 = this.getQuantaValueBelow(ozlu2, n - 1, n2, n3, n7);
        int n11 = this.getQuantaValueBelow(ozlu2, n + 1, n2, n3, n7);
        int n12 = n5;
        int n13 = 1;
        if (n8 >= 0) {
            ++n13;
            n12 += n8;
        }
        if (n9 >= 0) {
            ++n13;
            n12 += n9;
        }
        if (n10 >= 0) {
            ++n13;
            n12 += n10;
        }
        if (n11 >= 0) {
            ++n13;
            n12 += n11;
        }
        if (n13 == 1) {
            if (bl) {
                ozlu2.func_72921_c(n, n2, n3, n5 - 1, 2);
            }
            return;
        }
        int n14 = n12 / n13;
        int n15 = n12 % n13;
        if (n8 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n8) {
                if (n4 == 0) {
                    ozlu2.func_94575_c(n, n2, n3 - 1, 0);
                } else {
                    ozlu2.func_72832_d(n, n2, n3 - 1, this.field_71990_ca, n4 - 1, 2);
                }
                ozlu2.func_72836_a(n, n2, n3 - 1, this.field_71990_ca, this.tickRate);
            }
            --n13;
        }
        if (n9 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n9) {
                if (n4 == 0) {
                    ozlu2.func_94575_c(n, n2, n3 + 1, 0);
                } else {
                    ozlu2.func_72832_d(n, n2, n3 + 1, this.field_71990_ca, n4 - 1, 2);
                }
                ozlu2.func_72836_a(n, n2, n3 + 1, this.field_71990_ca, this.tickRate);
            }
            --n13;
        }
        if (n10 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n10) {
                if (n4 == 0) {
                    ozlu2.func_94575_c(n - 1, n2, n3, 0);
                } else {
                    ozlu2.func_72832_d(n - 1, n2, n3, this.field_71990_ca, n4 - 1, 2);
                }
                ozlu2.func_72836_a(n - 1, n2, n3, this.field_71990_ca, this.tickRate);
            }
            --n13;
        }
        if (n11 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n11) {
                if (n4 == 0) {
                    ozlu2.func_94575_c(n + 1, n2, n3, 0);
                } else {
                    ozlu2.func_72832_d(n + 1, n2, n3, this.field_71990_ca, n4 - 1, 2);
                }
                ozlu2.func_72836_a(n + 1, n2, n3, this.field_71990_ca, this.tickRate);
            }
            --n13;
        }
        if (n15 > 0) {
            ++n14;
        }
        ozlu2.func_72921_c(n, n2, n3, n14 - 1, 2);
    }

    public int tryToFlowVerticallyInto(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = n2 + this.densityDir;
        if (n5 < 0 || n5 >= ozlu2.func_72800_K()) {
            ozlu2.func_94571_i(n, n2, n3);
            return 0;
        }
        int n6 = this.getQuantaValueBelow(ozlu2, n, n5, n3, this.quantaPerBlock);
        if (n6 >= 0) {
            if ((n6 += n4) > this.quantaPerBlock) {
                ozlu2.func_72832_d(n, n5, n3, this.field_71990_ca, this.quantaPerBlock - 1, 3);
                ozlu2.func_72836_a(n, n5, n3, this.field_71990_ca, this.tickRate);
                return n6 - this.quantaPerBlock;
            }
            if (n6 > 0) {
                ozlu2.func_72832_d(n, n5, n3, this.field_71990_ca, n6 - 1, 3);
                ozlu2.func_72836_a(n, n5, n3, this.field_71990_ca, this.tickRate);
                ozlu2.func_94571_i(n, n2, n3);
                return 0;
            }
            return n4;
        }
        int n7 = BlockFluidFinite.getDensity(ozlu2, n, n5, n3);
        if (n7 == Integer.MAX_VALUE) {
            if (this.displaceIfPossible(ozlu2, n, n5, n3)) {
                ozlu2.func_72832_d(n, n5, n3, this.field_71990_ca, n4 - 1, 3);
                ozlu2.func_72836_a(n, n5, n3, this.field_71990_ca, this.tickRate);
                ozlu2.func_94571_i(n, n2, n3);
                return 0;
            }
            return n4;
        }
        if (this.densityDir < 0) {
            if (n7 < this.density) {
                int n8 = ozlu2.func_72798_a(n, n5, n3);
                BlockFluidBase blockFluidBase = (BlockFluidBase)twgu.field_71973_m[n8];
                int n9 = ozlu2.func_72805_g(n, n5, n3);
                ozlu2.func_72832_d(n, n5, n3, this.field_71990_ca, n4 - 1, 3);
                ozlu2.func_72832_d(n, n2, n3, n8, n9, 3);
                ozlu2.func_72836_a(n, n5, n3, this.field_71990_ca, this.tickRate);
                ozlu2.func_72836_a(n, n2, n3, n8, blockFluidBase.func_71859_p_(ozlu2));
                return 0;
            }
        } else if (n7 > this.density) {
            int n10 = ozlu2.func_72798_a(n, n5, n3);
            BlockFluidBase blockFluidBase = (BlockFluidBase)twgu.field_71973_m[n10];
            int n11 = ozlu2.func_72805_g(n, n5, n3);
            ozlu2.func_72832_d(n, n5, n3, this.field_71990_ca, n4 - 1, 3);
            ozlu2.func_72832_d(n, n2, n3, n10, n11, 3);
            ozlu2.func_72836_a(n, n5, n3, this.field_71990_ca, this.tickRate);
            ozlu2.func_72836_a(n, n2, n3, n10, blockFluidBase.func_71859_p_(ozlu2));
            return 0;
        }
        return n4;
    }

    @Override
    public FluidStack drain(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        return null;
    }

    @Override
    public boolean canDrain(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }
}

