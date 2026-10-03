/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class gqva
extends GuiSlot {
    public final pknz _a;
    public ResourceLocation _b;
    public final /* synthetic */ ekou _c;

    public gqva(ekou ekou2, pknz pknz2) {
        this._c = ekou2;
        super(ekou._a(ekou2), ekou2.width, ekou2.height, 32, ekou2.height - 55 + 4, 36);
        this._a = pknz2;
        pknz2._c();
    }

    @Override
    public int getSize() {
        return 1 + this._a._d().size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
        List list = this._a._d();
        try {
            if (n == 0) {
                throw new RuntimeException("This is so horrible ;D");
            }
            this._a._a((yehh)list.get(n - 1));
            ekou._b(this._c)._c();
        }
        catch (Exception exception) {
            this._a._a(new yehh[0]);
            ekou._c(this._c)._c();
        }
        ekou._d((ekou)this._c)._M.skin = this._a._f();
        ekou._e((ekou)this._c)._M.saveOptions();
    }

    @Override
    public boolean isSelected(int n) {
        List list = this._a._e();
        if (n == 0) {
            return list.isEmpty();
        }
        return list.contains(this._a._d().get(n - 1));
    }

    @Override
    public int getContentHeight() {
        return this.getSize() * 36;
    }

    @Override
    public void drawBackground() {
        this._c.drawDefaultBackground();
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        TextureManager textureManager = ekou._f(this._c)._R();
        if (n == 0) {
            try {
                fnrl fnrl2 = this._a._c;
                yekc yekc2 = (yekc)fnrl2.getPackMetadata(this._a._d, "pack");
                if (this._b == null) {
                    this._b = textureManager._a("texturepackicon", new sctt(fnrl2.getPackImage()));
                }
                textureManager._a(this._b);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(0xFFFFFF);
                tessellator.addVertexWithUV(n2, n3 + n4, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(n2 + 32, n3 + n4, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(n2 + 32, n3, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(n2, n3, 0.0, 0.0, 0.0);
                tessellator.draw();
                this._c.drawString(ekou._g(this._c), "Default", n2 + 32 + 2, n3 + 1, 0xFFFFFF);
                this._c.drawString(ekou._h(this._c), yekc2._a(), n2 + 32 + 2, n3 + 12 + 10, 0x808080);
            }
            catch (IOException iOException) {
                // empty catch block
            }
            return;
        }
        yehh yehh2 = (yehh)this._a._d().get(n - 1);
        yehh2._a(textureManager);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0xFFFFFF);
        tessellator.addVertexWithUV(n2, n3 + n4, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(n2 + 32, n3 + n4, 0.0, 1.0, 1.0);
        tessellator.addVertexWithUV(n2 + 32, n3, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(n2, n3, 0.0, 0.0, 0.0);
        tessellator.draw();
        String string = yehh2._d();
        if (string.length() > 32) {
            string = string.substring(0, 32).trim() + "...";
        }
        this._c.drawString(ekou._i(this._c), string, n2 + 32 + 2, n3 + 1, 0xFFFFFF);
        List list = ekou._j(this._c)._c(yehh2._e(), 183);
        for (int i = 0; i < 2 && i < list.size(); ++i) {
            this._c.drawString(ekou._k(this._c), (String)list.get(i), n2 + 32 + 2, n3 + 12 + 10 * i, 0x808080);
        }
    }

    public static /* synthetic */ pknz _a(gqva gqva2) {
        return gqva2._a;
    }
}

