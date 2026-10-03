/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class rqlb {
    public static final ResourceLocation _a = new ResourceLocation("textures/map/map_icons.png");
    public final sctt _b;
    public int[] _c = new int[16384];
    public GameSettings _d;
    public final ResourceLocation _e;

    public rqlb(GameSettings gameSettings, TextureManager textureManager) {
        this._d = gameSettings;
        TextureManager textureManager2 = textureManager;
        this._b = new sctt(128, 128);
        this._e = textureManager._a("map", this._b);
        this._c = this._b._b();
        for (int i = 0; i < this._c.length; ++i) {
            this._c[i] = 0;
        }
    }

    public void _a(EntityPlayer entityPlayer, TextureManager textureManager, thdd thdd2) {
        int n;
        byte by;
        int n2;
        for (n2 = 0; n2 < 16384; ++n2) {
            by = thdd2._e[n2];
            if (by / 4 == 0) {
                this._c[n2] = (n2 + n2 / 128 & 1) * 8 + 16 << 24;
                continue;
            }
            int n3 = MapColor._a[by / 4]._p;
            int n4 = by & 3;
            n = 220;
            if (n4 == 2) {
                n = 255;
            }
            if (n4 == 0) {
                n = 180;
            }
            int n5 = (n3 >> 16 & 0xFF) * n / 255;
            int n6 = (n3 >> 8 & 0xFF) * n / 255;
            int n7 = (n3 & 0xFF) * n / 255;
            this._c[n2] = 0xFF000000 | n5 << 16 | n6 << 8 | n7;
        }
        this._b._a();
        n2 = 0;
        by = 0;
        Tessellator tessellator = Tessellator.instance;
        float f = 0.0f;
        textureManager._a(this._e);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glDisable(3008);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((float)(n2 + 0) + f, (float)(by + 128) - f, -0.01f, 0.0, 1.0);
        tessellator.addVertexWithUV((float)(n2 + 128) - f, (float)(by + 128) - f, -0.01f, 1.0, 1.0);
        tessellator.addVertexWithUV((float)(n2 + 128) - f, (float)(by + 0) + f, -0.01f, 1.0, 0.0);
        tessellator.addVertexWithUV((float)(n2 + 0) + f, (float)(by + 0) + f, -0.01f, 0.0, 0.0);
        tessellator.draw();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        textureManager._a(_a);
        n = 0;
        for (ozsr ozsr2 : thdd2._h.values()) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)n2 + (float)ozsr2._b / 2.0f + 64.0f, (float)by + (float)ozsr2._c / 2.0f + 64.0f, -0.02f);
            GL11.glRotatef((float)(ozsr2._d * 360) / 16.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            float f2 = (float)(ozsr2._a % 4 + 0) / 4.0f;
            float f3 = (float)(ozsr2._a / 4 + 0) / 4.0f;
            float f4 = (float)(ozsr2._a % 4 + 1) / 4.0f;
            float f5 = (float)(ozsr2._a / 4 + 1) / 4.0f;
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-1.0, 1.0, (float)n * 0.001f, f2, f3);
            tessellator.addVertexWithUV(1.0, 1.0, (float)n * 0.001f, f4, f3);
            tessellator.addVertexWithUV(1.0, -1.0, (float)n * 0.001f, f4, f5);
            tessellator.addVertexWithUV(-1.0, -1.0, (float)n * 0.001f, f2, f5);
            tessellator.draw();
            GL11.glPopMatrix();
            ++n;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f, -0.04f);
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
}

