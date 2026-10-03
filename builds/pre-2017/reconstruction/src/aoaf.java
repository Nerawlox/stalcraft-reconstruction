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
import net.minecraft.item.ItemStack;
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
    private ItemStack _h;

    public aoaf(ssyj ssyj2) {
        super(ssyj2);
        this._e = ssyj2;
        this.xSize = 175;
        this.ySize = 152;
    }

    @Override
    public void initGui() {
        super.initGui();
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
        ItemStack itemStack = this._e._b.getStack();
        if (itemStack != null && itemStack._a() instanceof oxnm) {
            String string = ((oxnm)((Object)itemStack._a()))._a();
            this.mc._N._a(string, 1.0f, 1.0f);
            this._f = true;
            this._g = 0L;
        }
    }

    @Override
    public void updateScreen() {
        boolean bl;
        super.updateScreen();
        ItemStack itemStack = this._e._b.getStack();
        boolean bl2 = bl = itemStack != null && itemStack._a() instanceof oxnm;
        if ((this._h == null || this._h != itemStack) && bl) {
            int n = ((oxnm)((Object)itemStack._a()))._e(itemStack);
            if (n > 0) {
                this._c.setText("\u0414\u0435\u0442\u0430\u043b\u0435\u0439: ~" + (n + 5) / 10 * 10);
                this._d.setEnabled(true);
            }
        } else if (this._h != null && itemStack == null) {
            this._c.setText("");
            this._d.setEnabled(false);
        }
        this._h = itemStack;
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
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.xSize * 2;
        int n4 = this.ySize * 2;
        this.renderer.bindTexture(_a);
        this.renderer.drawTexturedModalRect(new Point(this.screenWidth / 2 - n3 / 2, this.screenHeight / 2 - n4 / 2), new Point(0, 0), new Dimension(n3, n4));
        super.drawGuiContainerBackgroundLayer(f, n, n2);
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

