/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.misc.hanr;
import gloomyfolken.mods.shop.data.CaseType;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class cufb
extends GuiScreenAdvanced {
    private static ResourceLocation _a = new ResourceLocation("shop", "textures/gui/celebration_rays.png");
    private static final GuiRenderer _b = new GuiRendererBuilder().setTextureSize(512, 512).create();
    private GuiRenderer.RenderItemHD _c;
    private CaseType _d;
    private ItemStack[] _e;
    private final String _f;
    private int _g;
    private final int _h = 800;
    private float _i;
    private boolean _j;
    private float _k;
    private int _l;
    private boolean _m;
    private float _n;
    private int _o;
    private int _p;
    private int _q;
    private McButton _r;
    private kjui _s;
    private pzne[] _t;

    public cufb(GuiScreen guiScreen, CaseType caseType, ItemStack[] itemStackArray, String string) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma14).create(), 600, 400, guiScreen);
        this._c = this.renderer.createItemRender(4.0f);
        this._g = 0;
        this._h = 800;
        this._n = -0.025f;
        this._o = 440;
        this._p = this._o / 2;
        this._q = 72;
        this._d = caseType;
        this._e = itemStackArray;
        this._f = string;
        this._d();
    }

    @Override
    public void initGui() {
        super.initGui();
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        kjui kjui2 = new kjui(this, point, 1.5f);
        if (this._s != null) {
            kjui2._b = this._s._b;
            kjui2._a = this._s._a;
        } else {
            kjui2._a = false;
        }
        this._s = kjui2;
        this.addElement(this._s);
        McBackground mcBackground = new McBackground(this, point.add(-240, -110), new Dimension(500, 200));
        mcBackground.setTexture(iedw._a).setTextureCoords(new Point(128, 959)).setTextureSize(new Dimension(64, 64)).setResizeBorder(20);
        this.addElement(mcBackground);
        if (this._d._d().isEmpty()) {
            this.closeScreen();
        }
        this._r = GuiHelper.addButton(this, point.add(-100, 45), new Dimension(200, 30), iedw._l, "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c").onClick(guiActionButtonClick -> {
            if (!this._j) {
                this._j = true;
            } else if (!this._m) {
                this._g();
            } else {
                this._c();
            }
        });
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        Object object;
        super.drawScreen(n, n2, f);
        Point point = new Point(this.screenWidth / 2 - 250 + 10, this.screenHeight / 2 - 110);
        Dimension dimension = new Dimension(500, 200);
        Minecraft._E()._R()._a(iedw._a);
        this.renderer.drawTiledRect(new Point(this.screenWidth / 2 - this._p, this.screenHeight / 2 - 50 - 5), new Point(227, 950), new Dimension(this._o, this._q + 10), new Dimension(19, 21), 3);
        if (this._d._d().size() > 1) {
            object = this._g + 1 + "-\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442";
            this.renderer.drawString((String)object, this.screenWidth / 2 - this.renderer.getStringWidth((String)object) / 2, this.screenHeight / 2 - 100, 0x939393);
        }
        Minecraft._E()._R()._a(iedw._b);
        this.renderer.drawTexturedModalRect(point.add(5, 35), new Point(0, 0), dimension.add(-20, -40));
        this.renderer.drawRect(point.add(10, 37), new Dimension(dimension.width - 35, 1), 0x64646464);
        this.renderer.drawRect(point.add(10, dimension.height - 10), new Dimension(dimension.width - 35, 1), 0x64646464);
        this._a(n * 2, n2 * 2, f);
        object = ExternalFont.tahoma14;
        if (!this._f.isEmpty()) {
            ((ExternalFont)object).drawString(this._f, (double)(this.screenWidth / 4 - ((ExternalFont)object).getStringWidth(this._f) / 2), (double)(this.screenHeight / 4 - 80), -1, true);
        }
        if (this._m && this._r == this.elementsList.getElementMouseOver()) {
            String string = "\u0412\u044b\u0438\u0433\u0440\u0430\u043d\u043d\u044b\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0431\u0443\u0434\u0435\u0442 \u043f\u043e\u043c\u0435\u0449\u0451\u043d \u043d\u0430 \u0441\u043a\u043b\u0430\u0434 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0445 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432";
            ((ExternalFont)object).drawString(string, (double)(this.screenWidth / 4 - ((ExternalFont)object).getStringWidth(string) / 2), (double)(this.screenHeight / 4 + 50), -1, true);
        }
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        if (this.getParentScreen() instanceof oxhq) {
            ((oxhq)this.getParentScreen())._a(this._d.case_id, this._e, false);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this._k > 0.0f) {
            this._i += this._k * 3.0f;
            if (this._j) {
                this._k += this._n * 3.0f;
            }
        } else if (!this._m) {
            this._e();
        }
    }

    private void _c() {
        if (this._g == this._d._d().size() - 1) {
            this.closeScreen();
        } else {
            ++this._g;
        }
        this._d();
    }

    private void _d() {
        List<pzne> list2 = this._d._d().get((int)this._g)._b;
        this._k = 8.0f;
        this._l = -1;
        this._j = false;
        this._i = Math.max(this._q * list2.size(), this._o) * 4;
        this._t = new pzne[list2.size() * 2];
        int[] nArray = new Random().ints(0, list2.size() * 2).distinct().limit(this._t.length).toArray();
        for (int i = 0; i < nArray.length; ++i) {
            this._t[nArray[i]] = list2.get(i / 2);
        }
        this._m = false;
        if (this._s != null) {
            this._s._a = false;
        }
        if (this._r != null) {
            this._r.text = "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c";
        }
    }

    private void _e() {
        this._r.text = "\u0417\u0430\u0431\u0440\u0430\u0442\u044c";
        this._m = true;
        this._s.setVisible(true);
        this._s._b = 0;
        this._s._a = true;
    }

    private void _a(int n, int n2, float f) {
        Point point = new Point(this.screenWidth / 2 - this._p, this.screenHeight / 2 - 50);
        int n3 = Math.max(this._o / this._q, this._t.length) * 2;
        boolean bl = this._f();
        float f2 = this._i - (this._i - Math.max(this._k, 0.0f) * 3.0f);
        float f3 = this._i + f * f2;
        int n4 = n3 * this._q;
        ItemStack itemStack = null;
        GL11.glEnable(3089);
        this.renderer.scaledScissor(point, new Dimension(this._o, 80));
        for (int i = 0; i < n3; ++i) {
            int n5 = (int)((float)(i * this._q) - f3);
            int n6 = n5;
            if (n6 <= 0) {
                n6 = n5 + (-n5 / n4 + 1) * n4 - this._q;
            }
            if (bl && this._l == -1 && n6 > 800 - this._q / 2 && n6 < 800) {
                this._l = i;
            }
            ItemStack itemStack2 = this._l == i ? this._e[this._g] : this._t[i % this._t.length]._k();
            int n7 = point.x + n6;
            int n8 = point.y;
            if (itemStack2 != null) {
                this._a(itemStack2, n7, n8);
            }
            if (!this._m) continue;
            if (n > point.x && n < point.x + this._o && n > n7 && n < n7 + this._q && n2 > n8 && n2 < n8 + this._q) {
                itemStack = itemStack2;
            }
            if (this._l != i) continue;
            this._a(n7, n8);
        }
        ScissorHelper.popScissor();
        this._a(point);
        if (itemStack != null) {
            List list2 = itemStack._a((EntityPlayer)Minecraft._E()._t, false);
            this.renderer.drawHoveringText(list2, new Point(n, n2), new Dimension(this.screenWidth, this.screenHeight));
        }
    }

    private void _a(Point point) {
        GL11.glEnable(3042);
        this.renderer.bindTexture(iedw._a);
        this.renderer.drawTiledRect(point.add(this._p - 9, -5), new Point(257, 882), new Dimension(18, this._q + 10), new Dimension(18, 29), 0, 12);
    }

    private boolean _f() {
        int n;
        float f;
        return this._j && (f = this._k * this._k / (2.0f * -this._n)) > (float)(800 - this._p - (n = this._q / 2)) && f < (float)(800 - this._p + n);
    }

    private void _a(ItemStack itemStack, int n, int n2) {
        GuiHelper.widgetsRenderer.bindTexture(GuiHelper.widgets);
        GuiHelper.widgetsRenderer.drawTexturedModalRect(n, n2, 147, 0, this._q, this._q);
        GL11.glEnable(3042);
        GL11.glPushAttrib(1048575);
        this._c.renderStack(itemStack, n + 4, n2 + 4);
        GL11.glPopAttrib();
        hanr hanr2 = hanr._b(itemStack);
        if (hanr2 != hanr._a) {
            int n3 = hanr2._l;
            this.renderer.drawGradientRect(n, n2 + this._q - 10, this._q, 10.0, n3, n3 | 0xAA000000);
        }
    }

    private void _a(int n, int n2) {
        float f = (float)this._s._b / 50.0f;
        float f2 = (float)(15.0 * (-Math.pow(2.0, -10.0f * f) + 1.0));
        this.renderer.drawGradientRect(n, n2, this._q, f2, -1426073856, 16766720);
        this.renderer.drawGradientRect(n, (float)(n2 + this._q) - f2, this._q, f2, 16766720, -1426073856);
    }

    private void _g() {
        this._i += this._k * this._k / (2.0f * -this._n);
        this._k = 0.0f;
        int n = this._o / this._q;
        int n2 = Math.max(n, this._t.length) * 2;
        for (int i = 0; i < n2; ++i) {
            int n3 = (int)((float)(i * this._q) - this._i);
            int n4 = n3;
            if (n4 <= 0) {
                n4 = n3 + (-n3 / (n2 * this._q) + 1) * n2 * this._q + this._q - 2 * this._q;
            }
            if (this._p <= n4 || this._p >= n4 + this._q) continue;
            this._l = i;
        }
        this._e();
    }

    private class kjui
    extends GuiComponent {
        boolean _a;
        int _b;
        float _c;
        double _d;

        public kjui(IAdvancedGui iAdvancedGui, Point point, float f) {
            super(iAdvancedGui, point, Dimension.zeroDimension);
            this._a = false;
            this._b = 0;
            this._c = 1.0f;
            this._d = 0.0;
            this._c = f;
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            cufb.this.drawDefaultBackground();
            if (!this._a) {
                return;
            }
            float f2 = 100.0f;
            float f3 = (float)this._b < f2 ? zftb._f._a((float)this._b + f, 0.0f, 1.0f, f2) * this._c : this._c + 0.1f * (float)Math.sin(((float)this._b + f) / 30.0f);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            _b.bindTexture(_a);
            GL11.glTranslated(this.getLocation().x / 2, this.getLocation().y / 2, 0.0);
            GL11.glRotated(this._d - (1.0 - (double)f) * 0.6, 0.0, 0.0, 1.0);
            GL11.glScaled(f3, f3, 1.0);
            _b.drawTexturedModalRect(new Point(-256, -256), Point.zeroPoint, new Dimension(512, 512));
            GL11.glPopMatrix();
        }

        @Override
        public void tick() {
            super.tick();
            this._d += 0.6;
            this._b += 3;
        }
    }
}

