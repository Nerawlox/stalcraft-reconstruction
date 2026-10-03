/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class dyjs
extends htys {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/enchanting_table_book.png");
    public ModelBook _b = new ModelBook();

    public void _a(mtdr mtdr2, double d, double d2, double d3, float f) {
        float f2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.75f, (float)d3 + 0.5f);
        float f3 = (float)mtdr2._a + f;
        GL11.glTranslatef(0.0f, 0.1f + sajh._a(f3 * 0.1f) * 0.01f, 0.0f);
        for (f2 = mtdr2._h - mtdr2._i; f2 >= (float)Math.PI; f2 -= (float)Math.PI * 2) {
        }
        while (f2 < (float)(-Math.PI)) {
            f2 += (float)Math.PI * 2;
        }
        float f4 = mtdr2._i + f2 * f;
        GL11.glRotatef(-f4 * 180.0f / (float)Math.PI, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        this.func_110628_a(_a);
        float f5 = mtdr2._c + (mtdr2._b - mtdr2._c) * f + 0.25f;
        float f6 = mtdr2._c + (mtdr2._b - mtdr2._c) * f + 0.75f;
        f5 = (f5 - (float)sajh._b((double)f5)) * 1.6f - 0.3f;
        f6 = (f6 - (float)sajh._b((double)f6)) * 1.6f - 0.3f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        float f7 = mtdr2._g + (mtdr2._f - mtdr2._g) * f;
        GL11.glEnable(2884);
        this._b.func_78088_a(null, f3, f5, f6, f7, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    public /* synthetic */ void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this._a((mtdr)hurg2, d, d2, d3, f);
    }
}

