/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.sajz;
import net.minecraft.util.uxqz;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class uzug
implements sajz {
    public String _a = "";
    public Minecraft _b;
    public String _c = "";
    public long _d = Minecraft._M();
    public boolean _e;

    public uzug(Minecraft minecraft) {
        this._b = minecraft;
    }

    public void _a(String string) {
        this._e = false;
        this._c(string);
    }

    @Override
    public void _b(String string) {
        this._e = true;
        this._c(string);
    }

    public void _c(String string) {
        this._c = string;
        if (!this._b.__ap) {
            if (this._e) {
                return;
            }
            throw new uxqz();
        }
        htou htou2 = new htou(this._b._M, this._b._n, this._b._o);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 100.0, 300.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    @Override
    public void _d(String string) {
        if (!this._b.__ap) {
            if (this._e) {
                return;
            }
            throw new uxqz();
        }
        this._d = 0L;
        this._a = string;
        this._a(-1);
        this._d = 0L;
    }

    @Override
    public void _a(int n) {
        if (!this._b.__ap) {
            if (this._e) {
                return;
            }
            throw new uxqz();
        }
        long l = Minecraft._M();
        if (l - this._d < 100L) {
            return;
        }
        this._d = l;
        htou htou2 = new htou(this._b._M, this._b._n, this._b._o);
        int n2 = htou2._a();
        int n3 = htou2._b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 100.0, 300.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        GL11.glClear(16640);
        Tessellator tessellator = Tessellator.instance;
        this._b._R()._a(Gui.optionsBackground);
        float f = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x404040);
        tessellator.addVertexWithUV(0.0, n3, 0.0, 0.0, (float)n3 / f);
        tessellator.addVertexWithUV(n2, n3, 0.0, (float)n2 / f, (float)n3 / f);
        tessellator.addVertexWithUV(n2, 0.0, 0.0, (float)n2 / f, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
        tessellator.draw();
        if (n >= 0) {
            int n4 = 100;
            int n5 = 2;
            int n6 = n2 / 2 - n4 / 2;
            int n7 = n3 / 2 + 16;
            GL11.glDisable(3553);
            tessellator.startDrawingQuads();
            tessellator.setColorOpaque_I(0x808080);
            tessellator.addVertex(n6, n7, 0.0);
            tessellator.addVertex(n6, n7 + n5, 0.0);
            tessellator.addVertex(n6 + n4, n7 + n5, 0.0);
            tessellator.addVertex(n6 + n4, n7, 0.0);
            tessellator.setColorOpaque_I(0x80FF80);
            tessellator.addVertex(n6, n7, 0.0);
            tessellator.addVertex(n6, n7 + n5, 0.0);
            tessellator.addVertex(n6 + n, n7 + n5, 0.0);
            tessellator.addVertex(n6 + n, n7, 0.0);
            tessellator.draw();
            GL11.glEnable(3553);
        }
        this._b._z._a(this._c, (n2 - this._b._z._b(this._c)) / 2, n3 / 2 - 4 - 16, 0xFFFFFF);
        this._b._z._a(this._a, (n2 - this._b._z._b(this._a)) / 2, n3 / 2 - 4 + 8, 0xFFFFFF);
        Display.update();
        try {
            Thread.yield();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

