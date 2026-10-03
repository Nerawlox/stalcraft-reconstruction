/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper;

import net.minecraft.util.dwan;

public class VertexHelper {
    protected double offset = 0.0;

    public void setOffset(double d) {
        this.offset = d;
    }

    public void clearOffset() {
        this.offset = 0.0;
    }

    public boolean iconHasFloatingHeight(dwan dwan2) {
        return dwan2 == jzmk._a() || dwan2.func_94215_i().contains("overlay/overlay_") && dwan2.func_94215_i().endsWith("_side");
    }

    public void setupVertex(htvc htvc2, double d, double d2, double d3, double d4, double d5, int n) {
        htvf htvf2 = htvc2.__aF;
        if (htvc2._w) {
            switch (n) {
                case 0: {
                    htvf2.func_78386_a(htvc2.__ap, htvc2.__at, htvc2.__ax);
                    htvf2.func_78380_c(htvc2.__al);
                    break;
                }
                case 1: {
                    htvf2.func_78386_a(htvc2.__aq, htvc2.__au, htvc2.__ay);
                    htvf2.func_78380_c(htvc2.__am);
                    break;
                }
                case 2: {
                    htvf2.func_78386_a(htvc2.__ar, htvc2.__av, htvc2.__az);
                    htvf2.func_78380_c(htvc2.__an);
                    break;
                }
                case 3: {
                    htvf2.func_78386_a(htvc2.__as, htvc2.__aw, htvc2.__aA);
                    htvf2.func_78380_c(htvc2.__ao);
                }
            }
        }
        htvf2.func_78374_a(d, d2, d3, d4, d5);
    }
}

