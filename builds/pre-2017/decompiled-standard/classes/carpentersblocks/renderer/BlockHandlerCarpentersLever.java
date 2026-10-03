/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.IconHandler;
import net.minecraft.util.dwan;
import net.minecraft.util.ofbx;

public class BlockHandlerCarpentersLever
extends BlockHandlerBase {
    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        twgu twgu3 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        this.renderLever(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    public boolean renderLever(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = n4 & 7;
        boolean bl = (n4 & 8) > 0;
        htvf htvf2 = htvc2.__aF;
        boolean bl2 = htvc2._b();
        float f = 0.25f;
        float f2 = 0.1875f;
        float f3 = 0.1875f;
        if (n5 == 5) {
            htvc2._a(0.5f - f2, 0.0, (double)(0.5f - f), (double)(0.5f + f2), (double)f3, (double)(0.5f + f));
        } else if (n5 == 6) {
            htvc2._a(0.5f - f, 0.0, (double)(0.5f - f2), (double)(0.5f + f), (double)f3, (double)(0.5f + f2));
        } else if (n5 == 4) {
            htvc2._a(0.5f - f2, 0.5f - f, (double)(1.0f - f3), (double)(0.5f + f2), (double)(0.5f + f), 1.0);
        } else if (n5 == 3) {
            htvc2._a(0.5f - f2, 0.5f - f, 0.0, (double)(0.5f + f2), (double)(0.5f + f), (double)f3);
        } else if (n5 == 2) {
            htvc2._a(1.0f - f3, 0.5f - f, (double)(0.5f - f2), 1.0, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 1) {
            htvc2._a(0.0, 0.5f - f, (double)(0.5f - f2), (double)f3, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 0) {
            htvc2._a(0.5f - f, 1.0f - f3, (double)(0.5f - f2), (double)(0.5f + f), 1.0, (double)(0.5f + f2));
        } else if (n5 == 7) {
            htvc2._a(0.5f - f2, 1.0f - f3, (double)(0.5f - f), (double)(0.5f + f2), 1.0, (double)(0.5f + f));
        }
        htvc2._d = true;
        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        htvc2._d = false;
        if (!bl2) {
            htvc2._a();
        }
        htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n, n2, n3));
        float f4 = 1.0f;
        if (twgu.field_71984_q[twgu2.field_71990_ca] > 0) {
            f4 = 1.0f;
        }
        htvf2.func_78386_a(f4, f4, f4);
        dwan dwan2 = IconHandler.icon_lever;
        if (htvc2._b()) {
            dwan2 = htvc2._b;
        }
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        ofbx[] ofbxArray = new ofbx[8];
        float f5 = 0.0625f;
        float f6 = 0.0625f;
        float f7 = 0.625f;
        ofbxArray[0] = htvc2._a.func_82732_R()._a(-f5, 0.0, -f6);
        ofbxArray[1] = htvc2._a.func_82732_R()._a(f5, 0.0, -f6);
        ofbxArray[2] = htvc2._a.func_82732_R()._a(f5, 0.0, f6);
        ofbxArray[3] = htvc2._a.func_82732_R()._a(-f5, 0.0, f6);
        ofbxArray[4] = htvc2._a.func_82732_R()._a(-f5, f7, -f6);
        ofbxArray[5] = htvc2._a.func_82732_R()._a(f5, f7, -f6);
        ofbxArray[6] = htvc2._a.func_82732_R()._a(f5, f7, f6);
        ofbxArray[7] = htvc2._a.func_82732_R()._a(-f5, f7, f6);
        for (int i = 0; i < 8; ++i) {
            if (bl) {
                ofbxArray[i]._e -= 0.0625;
                ofbxArray[i]._a(0.69813174f);
            } else {
                ofbxArray[i]._e += 0.0625;
                ofbxArray[i]._a(-0.69813174f);
            }
            if (n5 == 0 || n5 == 7) {
                ofbxArray[i]._c((float)Math.PI);
            }
            if (n5 == 6 || n5 == 0) {
                ofbxArray[i]._b(1.5707964f);
            }
            if (n5 > 0 && n5 < 5) {
                ofbxArray[i]._d -= 0.375;
                ofbxArray[i]._a(1.5707964f);
                if (n5 == 4) {
                    ofbxArray[i]._b(0.0f);
                }
                if (n5 == 3) {
                    ofbxArray[i]._b((float)Math.PI);
                }
                if (n5 == 2) {
                    ofbxArray[i]._b(1.5707964f);
                }
                if (n5 == 1) {
                    ofbxArray[i]._b(-1.5707964f);
                }
                ofbxArray[i]._c += (double)n + 0.5;
                ofbxArray[i]._d += (double)((float)n2 + 0.5f);
                ofbxArray[i]._e += (double)n3 + 0.5;
                continue;
            }
            if (n5 != 0 && n5 != 7) {
                ofbxArray[i]._c += (double)n + 0.5;
                ofbxArray[i]._d += (double)((float)n2 + 0.125f);
                ofbxArray[i]._e += (double)n3 + 0.5;
                continue;
            }
            ofbxArray[i]._c += (double)n + 0.5;
            ofbxArray[i]._d += (double)((float)n2 + 0.875f);
            ofbxArray[i]._e += (double)n3 + 0.5;
        }
        ofbx ofbx2 = null;
        ofbx ofbx3 = null;
        ofbx ofbx4 = null;
        ofbx ofbx5 = null;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                d = dwan2.func_94214_a(7.0);
                d2 = dwan2.func_94207_b(6.0);
                d3 = dwan2.func_94214_a(9.0);
                d4 = dwan2.func_94207_b(8.0);
            } else if (i == 2) {
                d = dwan2.func_94214_a(7.0);
                d2 = dwan2.func_94207_b(6.0);
                d3 = dwan2.func_94214_a(9.0);
                d4 = dwan2.func_94210_h();
            }
            if (i == 0) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[2];
                ofbx5 = ofbxArray[3];
            } else if (i == 1) {
                ofbx2 = ofbxArray[7];
                ofbx3 = ofbxArray[6];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[4];
            } else if (i == 2) {
                ofbx2 = ofbxArray[1];
                ofbx3 = ofbxArray[0];
                ofbx4 = ofbxArray[4];
                ofbx5 = ofbxArray[5];
            } else if (i == 3) {
                ofbx2 = ofbxArray[2];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[6];
            } else if (i == 4) {
                ofbx2 = ofbxArray[3];
                ofbx3 = ofbxArray[2];
                ofbx4 = ofbxArray[6];
                ofbx5 = ofbxArray[7];
            } else if (i == 5) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[3];
                ofbx4 = ofbxArray[7];
                ofbx5 = ofbxArray[4];
            }
            htvf2.func_78374_a(ofbx2._c, ofbx2._d, ofbx2._e, d, d4);
            htvf2.func_78374_a(ofbx3._c, ofbx3._d, ofbx3._e, d3, d4);
            htvf2.func_78374_a(ofbx4._c, ofbx4._d, ofbx4._e, d3, d2);
            htvf2.func_78374_a(ofbx5._c, ofbx5._d, ofbx5._e, d, d2);
        }
        return true;
    }
}

