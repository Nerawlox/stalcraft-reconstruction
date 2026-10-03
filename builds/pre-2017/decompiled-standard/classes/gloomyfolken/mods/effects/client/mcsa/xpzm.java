/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import org.lwjgl.util.vector.Vector3f;

public class xpzm {
    public static void _a(zxep zxep2) {
        htvf htvf2 = htvf.field_78398_a;
        rpms rpms2 = zxep2._a;
        htvf2.func_78371_b(4);
        for (int i = 0; i < zxep2._c.length; ++i) {
            zxep.kjui kjui2 = zxep2._a(i);
            if (rpms2.hasUvs()) {
                htvf2.func_78385_a(kjui2._b.x, kjui2._b.y);
            }
            if (rpms2.hasNormals()) {
                htvf2.func_78375_b(kjui2._c.x, kjui2._c.y, kjui2._c.z);
            }
            Vector3f vector3f = kjui2._a;
            htvf2.func_78377_a(vector3f.x, vector3f.y, vector3f.z);
        }
        htvf2.func_78381_a();
    }
}

