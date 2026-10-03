/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.mods.core.misc.pzde;
import net.minecraft.util.jxtc;

public class Resistances {
    public float arrow = 1.0f;
    public float playermelee = 1.0f;

    public qoac writeToNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("Arrow", this.arrow);
        qoac2._a("Melee", this.playermelee);
        return qoac2;
    }

    public void readToNBT(qoac qoac2) {
        this.arrow = qoac2._h("Arrow");
        this.playermelee = qoac2._h("Melee");
    }

    public float applyResistance(jxtc jxtc2, float f) {
        if (!jxtc2.field_76373_n.equals("arrow") && !jxtc2.field_76373_n.equals("thrown")) {
            boolean bl = jxtc2 instanceof pzde;
            if (jxtc2.field_76373_n.equals("player") || jxtc2.field_76373_n.equals("mob") || bl) {
                if (bl) {
                    f *= 3.0f;
                }
                f *= 2.0f - this.playermelee;
            }
        } else {
            f *= 2.0f - this.arrow;
        }
        return f;
    }
}

