/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecartTNT;
import org.lwjgl.opengl.GL11;

public class fnqt
extends scrm {
    public void _a(EntityMinecartTNT entityMinecartTNT, float f, Block block, int n) {
        int n2 = entityMinecartTNT.func_94104_d();
        if (n2 > -1 && (float)n2 - f + 1.0f < 10.0f) {
            float f2 = 1.0f - ((float)n2 - f + 1.0f) / 10.0f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f2 *= f2;
            f2 *= f2;
            float f3 = 1.0f + f2 * 0.3f;
            GL11.glScalef(f3, f3, f3);
        }
        super._a(entityMinecartTNT, f, block, n);
        if (n2 > -1 && n2 / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, (1.0f - ((float)n2 - f + 1.0f) / 100.0f) * 0.8f);
            GL11.glPushMatrix();
            this._c._a(Block.tnt, 0, 1.0f);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }
}

