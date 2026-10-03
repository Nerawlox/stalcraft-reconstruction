/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.util.vector.Vector3f;

public class xpzm {
    public static void _a(zxep zxep2) {
        Tessellator tessellator = Tessellator.instance;
        rpms rpms2 = zxep2._a;
        tessellator.startDrawing(4);
        for (int i = 0; i < zxep2._c.length; ++i) {
            zxep.kjui kjui2 = zxep2._a(i);
            if (rpms2.hasUvs()) {
                tessellator.setTextureUV(kjui2._b.x, kjui2._b.y);
            }
            if (rpms2.hasNormals()) {
                tessellator.setNormal(kjui2._c.x, kjui2._c.y, kjui2._c.z);
            }
            Vector3f vector3f = kjui2._a;
            tessellator.addVertex(vector3f.x, vector3f.y, vector3f.z);
        }
        tessellator.draw();
    }
}

