/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class aoaf
extends GuiContainerAdvanced {
    private static final int _b = 50;
    public static final ResourceLocation _a = new ResourceLocation("stalker", "textures/gui/disassembler.png");
    private McLabel _c;
    private McButton _d;
    private ssyj _e;
    private boolean _f = false;
    private long _g = 0L;
    private cvzo _h;

    public aoaf(ssyj ssyj2) {
        super(ssyj2);
        this._e = ssyj2;
        this.field_74194_b = 175;
        this.field_74195_c = 152;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiRenderer guiRenderer = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma11).create();
        this._c = new McLabel((IAdvancedGui)this, "", new Point(this.screenWidth / 2 + 30, this.screenHeight / 2 - 85));
        this._c.setRenderer(guiRenderer);
        this.addElement(this._c);
        this._d = new kjui(this, this.screenWidth / 2 - 90, this.screenHeight / 2 - 54, 180, 30, "\u0420\u0430\u0437\u043e\u0431\u0440\u0430\u0442\u044c").onClick(guiActionButtonClick -> this._a());
        this._d.setRenderer(guiRenderer);
        this._d.setEnabled(false);
        this.addElement(this._d);
    }

    private void _a() {
        cvzo cvzo2 = this._e._b.func_75211_c();
        if (cvzo2 != null && cvzo2._a() instanceof oxnm) {
            String string = ((oxnm)((Object)cvzo2._a()))._a();
            this.field_73882_e._N._a(string, 1.0f, 1.0f);
            this._f = true;
            this._g = 0L;
        }
    }

    @Override
    public void func_73876_c() {
        boolean bl;
        super.func_73876_c();
        cvzo cvzo2 = this._e._b.func_75211_c();
        boolean bl2 = bl = cvzo2 != null && cvzo2._a() instanceof oxnm;
        if ((this._h == null || this._h != cvzo2) && bl) {
            int n = ((oxnm)((Object)cvzo2._a()))._e(cvzo2);
            if (n > 0) {
                this._c.setText("\u0414\u0435\u0442\u0430\u043b\u0435\u0439: ~" + (n + 5) / 10 * 10);
                this._d.setEnabled(true);
            }
        } else if (this._h != null && cvzo2 == null) {
            this._c.setText("");
            this._d.setEnabled(false);
        }
        this._h = cvzo2;
        if (this._f) {
            if (!bl) {
                this._f = false;
                this._g = 0L;
            } else if (++this._g == 50L) {
                new jiae().sendToServer();
                this._f = false;
                this._g = 0L;
            }
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.field_74194_b * 2;
        int n4 = this.field_74195_c * 2;
        this.renderer.bindTexture(_a);
        this.renderer.drawTexturedModalRect(new Point(this.screenWidth / 2 - n3 / 2, this.screenHeight / 2 - n4 / 2), new Point(0, 0), new Dimension(n3, n4));
        super.func_74185_a(f, n, n2);
    }

    private class kjui
    extends McButton {
        public kjui(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, String string) {
            super(iAdvancedGui, n, n2, string);
            this.setSize(new Dimension(n3, n4));
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            float f2 = (float)aoaf.this._g / 50.0f;
            if (this.getVisible()) {
                this.renderer.drawRect(this.getLocation().x + 5, this.getLocation().y + 5, (float)(this.getSize().width - 10) * f2, this.getSize().height - 10, 1788056467);
            }
        }

        @Override
        public boolean getEnabled() {
            return super.getEnabled() && !aoaf.this._f;
        }
    }
}

