/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;

public class nutn
extends twgu {
    @SideOnly(value=Side.CLIENT)
    public dwan[] _a;
    @SideOnly(value=Side.CLIENT)
    public dwan[] _b;

    public nutn(int n, tflj tflj2) {
        super(n, tflj2);
        float f = 0.5f;
        float f2 = 1.0f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return this._b[0];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71895_b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 != 1 && n4 != 0) {
            boolean bl;
            int n5 = this._c(sdrg2, n, n2, n3);
            int n6 = n5 & 3;
            boolean bl2 = (n5 & 4) != 0;
            boolean bl3 = false;
            boolean bl4 = bl = (n5 & 8) != 0;
            if (bl2) {
                if (n6 == 0 && n4 == 2) {
                    bl3 = !bl3;
                } else if (n6 == 1 && n4 == 5) {
                    bl3 = !bl3;
                } else if (n6 == 2 && n4 == 3) {
                    bl3 = !bl3;
                } else if (n6 == 3 && n4 == 4) {
                    bl3 = !bl3;
                }
            } else {
                if (n6 == 0 && n4 == 5) {
                    bl3 = !bl3;
                } else if (n6 == 1 && n4 == 3) {
                    bl3 = !bl3;
                } else if (n6 == 2 && n4 == 4) {
                    bl3 = !bl3;
                } else if (n6 == 3 && n4 == 2) {
                    boolean bl5 = bl3 = !bl3;
                }
                if ((n5 & 0x10) != 0) {
                    boolean bl6 = bl3 = !bl3;
                }
            }
            return bl ? this._a[bl3 ? 1 : 0] : this._b[bl3 ? 1 : 0];
        }
        return this._b[0];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._a = new dwan[2];
        this._b = new dwan[2];
        this._a[0] = nege2._b(this.func_111023_E() + "_upper");
        this._b[0] = nege2._b(this.func_111023_E() + "_lower");
        this._a[1] = new zyjh(this._a[0], true, false);
        this._b[1] = new zyjh(this._b[0], true, false);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = this._c(sdrg2, n, n2, n3);
        return (n4 & 4) != 0;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 7;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a(this._c(sdrg2, n, n2, n3));
    }

    public int _a(sdrg sdrg2, int n, int n2, int n3) {
        return this._c(sdrg2, n, n2, n3) & 3;
    }

    public boolean _b(sdrg sdrg2, int n, int n2, int n3) {
        return (this._c(sdrg2, n, n2, n3) & 4) != 0;
    }

    public void _a(int n) {
        boolean bl;
        float f = 0.1875f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        int n2 = n & 3;
        boolean bl2 = (n & 4) != 0;
        boolean bl3 = bl = (n & 0x10) != 0;
        if (n2 == 0) {
            if (bl2) {
                if (!bl) {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                } else {
                    this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                }
            } else {
                this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
            }
        } else if (n2 == 1) {
            if (bl2) {
                if (!bl) {
                    this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                } else {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                }
            } else {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
            }
        } else if (n2 == 2) {
            if (bl2) {
                if (!bl) {
                    this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                } else {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                }
            } else {
                this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        } else if (n2 == 3) {
            if (bl2) {
                if (!bl) {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                } else {
                    this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
            } else {
                this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (this.field_72018_cp == tflj._f) {
            return false;
        }
        int n5 = this._c(ozlu2, n, n2, n3);
        int n6 = n5 & 7;
        n6 ^= 4;
        if ((n5 & 8) == 0) {
            ozlu2.func_72921_c(n, n2, n3, n6, 2);
            ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
        } else {
            ozlu2.func_72921_c(n, n2 - 1, n3, n6, 2);
            ozlu2.func_72909_d(n, n2 - 1, n3, n, n2, n3);
        }
        ozlu2.func_72889_a(entityPlayer, 1003, n, n2, n3, 0);
        return true;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        boolean bl2;
        int n4 = this._c(ozlu2, n, n2, n3);
        boolean bl3 = bl2 = (n4 & 4) != 0;
        if (bl2 != bl) {
            int n5 = n4 & 7;
            n5 ^= 4;
            if ((n4 & 8) == 0) {
                ozlu2.func_72921_c(n, n2, n3, n5, 2);
                ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
            } else {
                ozlu2.func_72921_c(n, n2 - 1, n3, n5, 2);
                ozlu2.func_72909_d(n, n2 - 1, n3, n, n2, n3);
            }
            ozlu2.func_72889_a(null, 1003, n, n2, n3, 0);
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if ((n5 & 8) == 0) {
            boolean bl = false;
            if (ozlu2.func_72798_a(n, n2 + 1, n3) != this.field_71990_ca) {
                ozlu2.func_94571_i(n, n2, n3);
                bl = true;
            }
            if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
                ozlu2.func_94571_i(n, n2, n3);
                bl = true;
                if (ozlu2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca) {
                    ozlu2.func_94571_i(n, n2 + 1, n3);
                }
            }
            if (bl) {
                if (!ozlu2.field_72995_K) {
                    this.func_71897_c(ozlu2, n, n2, n3, n5, 0);
                }
            } else {
                boolean bl2;
                boolean bl3 = bl2 = ozlu2.func_72864_z(n, n2, n3) || ozlu2.func_72864_z(n, n2 + 1, n3);
                if ((bl2 || n4 > 0 && twgu.field_71973_m[n4].func_71853_i()) && n4 != this.field_71990_ca) {
                    this._a(ozlu2, n, n2, n3, bl2);
                }
            }
        } else {
            if (ozlu2.func_72798_a(n, n2 - 1, n3) != this.field_71990_ca) {
                ozlu2.func_94571_i(n, n2, n3);
            }
            if (n4 > 0 && n4 != this.field_71990_ca) {
                this.func_71863_a(ozlu2, n, n2 - 1, n3, n4);
            }
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return (n & 8) != 0 ? 0 : (this.field_72018_cp == tflj._f ? tgdv.field_77766_aB.field_77779_bT : tgdv.field_77790_av.field_77779_bT);
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return n2 >= 255 ? false : ozlu2.func_72797_t(n, n2 - 1, n3) && super.func_71930_b(ozlu2, n, n2, n3) && super.func_71930_b(ozlu2, n, n2 + 1, n3);
    }

    @Override
    public int func_71915_e() {
        return 1;
    }

    public int _c(sdrg sdrg2, int n, int n2, int n3) {
        int n4;
        int n5;
        boolean bl;
        int n6 = sdrg2.func_72805_g(n, n2, n3);
        boolean bl2 = bl = (n6 & 8) != 0;
        if (bl) {
            n5 = sdrg2.func_72805_g(n, n2 - 1, n3);
            n4 = n6;
        } else {
            n5 = n6;
            n4 = sdrg2.func_72805_g(n, n2 + 1, n3);
        }
        boolean bl3 = (n4 & 1) != 0;
        return n5 & 7 | (bl ? 8 : 0) | (bl3 ? 16 : 0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_72018_cp == tflj._f ? tgdv.field_77766_aB.field_77779_bT : tgdv.field_77790_av.field_77779_bT;
    }

    @Override
    public void func_71846_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        if (entityPlayer.field_71075_bZ._d && (n4 & 8) != 0 && ozlu2.func_72798_a(n, n2 - 1, n3) == this.field_71990_ca) {
            ozlu2.func_94571_i(n, n2 - 1, n3);
        }
    }
}

