/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiPlayer;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McViewport;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.clans.kjui;
import gloomyfolken.mods.stalker.clans.zwaw;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import mods.pda.client.component.PdaBackground;

public class xabu
extends GuiScreenAdvanced {
    private static DateTimeFormatter _a = DateTimeFormatter.ofPattern("dd.MM.yy");
    private static int[] _b = new int[]{14598668, 0xC5C5C5, 13727011, 0x3B3B3B, 0x3B3B3B, 0x3B3B3B, 0x3B3B3B};
    private List<zwaw> _c;
    private int _d;
    private int _e = 0;
    private float _f;
    private gloomyfolken.mods.stalker.clans.kjui _g;
    private amxi _h;
    private final boolean _i;

    public xabu(gqjz gqjz2, gloomyfolken.mods.stalker.clans.kjui kjui2, boolean bl) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this._i = bl;
        this.setParentScreen(gqjz2);
        this._g = kjui2;
        this._c = kjui2._d;
        this._h = pibk._a._a(kjui2._b);
        if (this._h == null) {
            throw new IllegalArgumentException("Unknown battle id: " + kjui2._b);
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this._f = (float)this.screenHeight / 968.0f;
        this._d = (int)(543.0f * this._f);
        this._a(1, 1, this.screenWidth - 2, this._d);
        this._c();
        this._b();
        ExternalFont externalFont = ExternalFont.tahoma14;
        String string = _a.format(this._g._a.atZone(ZoneId.systemDefault())) + ", " + this._h._e();
        GuiHelper.addLabel((IAdvancedGui)this, string, 10, 10).setFontRenderer(externalFont);
        GuiHelper.addButton(this, new Point(this.screenWidth - 150, 10), new Dimension(120, 30), iedw._l, "\u0417\u0430\u043a\u0440\u044b\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        String string2 = "\u041f\u043e\u0431\u0435\u0434\u0430: " + this._g._c;
        GuiHelper.addLabel((IAdvancedGui)this, string2, this.screenWidth - externalFont.getStringWidth(string2) * 2 - 20 - 150, 10).setFontRenderer(externalFont);
    }

    private void _b() {
        float f = 426.0f * this._f;
        Point point = new Point(0, (int)((float)this._d - f) / 2);
        Dimension dimension = new Dimension(this.screenWidth - 1, (int)f);
        this.addElement(new kjui(this, point, dimension, -1812004864, 0xFF0000));
        this.addElement(new McRect(this, point.add(0, -1), new Dimension(dimension.width, 1), -1819044973));
        this.addElement(new McRect(this, point.add(0, dimension.height + 1), new Dimension(dimension.width, 1), -1819044973));
        GuiHelper.addLabel(this, "\u041b\u0443\u0447\u0448\u0438\u0435 \u0438\u0433\u0440\u043e\u043a\u0438", Point.zeroPoint).setFontRenderer(ExternalFont.tahoma18).setCentered(this.screenWidth / 2, 30);
        float f2 = (float)this.screenWidth * 0.9f / 7.0f;
        for (int i = 0; i < this._c.size(); ++i) {
            this._a(f2, i);
        }
    }

    private void _c() {
        int n;
        List<kjui.kjui> list2 = this._g._e;
        int n2 = this.screenWidth / list2.size();
        int n3 = this.screenHeight - this._d - 4;
        for (n = 0; n < 4; ++n) {
            this._a(n * n2, this._d + 2, n2, n3);
        }
        for (n = 0; n < list2.size(); ++n) {
            kjui.kjui kjui2 = list2.get(n);
            this._a(n * n2, this._d + 2, n2, n3, kjui2);
        }
    }

    private void _a(int n, int n2, int n3, int n4, kjui.kjui kjui2) {
        List<kjui.pidb> list2 = kjui2._c;
        int n5 = (int)kjui2._b;
        this.addElement(new PdaBackground(this, new Point(n, n2), new Dimension(n3, n4), false));
        int n6 = n + 8;
        ExternalFont externalFont = ExternalFont.tahoma14;
        this.addElement(new McLabel((IAdvancedGui)this, kjui2._a, new Point(n6, n2 + 10), -1).setFontRenderer(externalFont));
        this.addElement(new McLabel((IAdvancedGui)this, "| " + n5, new Point(n6 += 8 + externalFont.getStringWidth(kjui2._a) * 2, n2 + 10), -1).setFontRenderer(externalFont));
        ExternalFont externalFont2 = ExternalFont.tahoma16;
        int n7 = n + n3 - 80;
        this.addElement(new McLabel((IAdvancedGui)this, "\u0423", n7 - 85, n2 + 8).setFontRenderer(externalFont2));
        this.addElement(new McLabel((IAdvancedGui)this, "\u041f", n7 - 55, n2 + 8).setFontRenderer(externalFont2));
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421", n7 - 25, n2 + 8).setFontRenderer(externalFont2));
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u0447\u0435\u0442", n7, n2 + 8).setFontRenderer(externalFont2));
        int n8 = n3 - 16;
        Dimension dimension = new Dimension(n8, this.screenHeight - this._d - 40);
        Dimension dimension2 = new Dimension(n8, list2.size() * 20);
        McScrollPane mcScrollPane = GuiHelper.createScrollPane((IAdvancedGui)this, new Point(n + 10, n2 + 37), dimension, dimension2, true, iedw._j, iedw._k);
        int n9 = 0;
        for (kjui.pidb pidb2 : list2) {
            Point point = new Point(3, n9 * 20);
            McViewport mcViewport = mcScrollPane.getViewport();
            int n10 = n9 % 2 == 1 ? -1 : -5263441;
            ExternalFont externalFont3 = ExternalFont.tahoma10;
            mcViewport.addElement(new McLabel((IAdvancedGui)this, n9 + 1 + ". " + pidb2._a(), point, n10));
            String string = String.valueOf(pidb2._b());
            McLabel mcLabel = new McLabel((IAdvancedGui)this, string, Point.zeroPoint, n10).setFontRenderer(externalFont3);
            mcViewport.addElement(mcLabel);
            String string2 = String.valueOf(pidb2._c());
            McLabel mcLabel2 = new McLabel((IAdvancedGui)this, string2, Point.zeroPoint, n10).setFontRenderer(externalFont3);
            mcViewport.addElement(mcLabel2);
            String string3 = String.valueOf(pidb2._d());
            McLabel mcLabel3 = new McLabel((IAdvancedGui)this, string3, Point.zeroPoint, n10).setFontRenderer(externalFont3);
            mcViewport.addElement(mcLabel3);
            McLabel mcLabel4 = new McLabel((IAdvancedGui)this, String.valueOf(pidb2._e()), Point.zeroPoint, n10).setFontRenderer(externalFont3);
            mcViewport.addElement(mcLabel4);
            int n11 = n3 - 90;
            mcLabel.setCentered(n11 - 80, point.y + 13);
            mcLabel2.setCentered(n11 - 50, point.y + 13);
            mcLabel3.setCentered(n11 - 20, point.y + 13);
            mcLabel4.setCentered(n11 + 20, point.y + 13);
            mcViewport.addElement(new McRect(this, new Point(0, n9 * 20 + 20), new Dimension(n3 - 34, 1), 1083413395));
            ++n9;
        }
        if (mcScrollPane.getVerticalScrollBar() != null) {
            mcScrollPane.getTopButton().move(0, -15);
            mcScrollPane.getBottomButton().move(0, -13);
            mcScrollPane.getVerticalScrollBar().move(0, -14);
            mcScrollPane.getVerticalScrollBar().setSliderLength(16);
        }
        this.addElement(mcScrollPane);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._e;
    }

    private void _a(float f, int n) {
        zwaw zwaw2 = this._c.get(n);
        float f2 = (float)(-(n + 1) / 2) * Math.signum((n + 1) % 2 * 2 - 1);
        float f3 = (float)(70.0 + (double)(10.0f * (1.0f - Math.abs(f2) / 3.0f)));
        int n2 = this.screenWidth / 2 - 100 + (int)(f2 * f);
        int n3 = (int)((float)(this._d / 2 + -100) + 16.0f * (1.0f - (f3 - 70.0f) / 10.0f));
        this.addElement(new pidb(this, new Point(n2, n3), new Dimension(200, 200), zwaw2, n, f2));
    }

    private void _a(int n, int n2, int n3, int n4) {
        this.addElement(new McBackground(this, new Point(n, n2), new Dimension(n3, n4)).setTexture(iedw._a).setTextureCoords(new Point(128, 959)).setTextureSize(new Dimension(64, 64)).setResizeBorder(20));
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        if (this._i) {
            new srot().sendToServer();
        }
    }

    private class kjui
    extends GuiComponent {
        private int _b;
        private int _c;

        public kjui(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, int n, int n2) {
            super(iAdvancedGui, point, dimension);
            this._b = n;
            this._c = n2;
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            this.renderer.drawHorizontalGradient(this.getLocation().x, this.getLocation().y, this.getSize().width / 2, this.getSize().height, this._c, this._b);
            this.renderer.drawHorizontalGradient(this.getSize().width / 2, this.getLocation().y, this.getSize().width / 2, this.getSize().height, this._b, this._c);
        }
    }

    private class pidb
    extends GuiComponentsList<GuiComponent> {
        private final zwaw _b;
        private final int _c;
        private final float _d;
        private final float _e;
        private final float _f;
        private McGuiPlayer _g;
        private Stat _h;
        private String _i;
        private int _j;

        protected pidb(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, zwaw zwaw2, int n, float f) {
            super(iAdvancedGui, point, dimension);
            this._b = zwaw2;
            this._c = n;
            this._d = f;
            this._e = (float)(70.0 + (double)(10.0f * (1.0f - Math.abs(f) / 3.0f))) * xabu.this._f;
            this._f = f * -8.0f;
            this._a();
        }

        private void _a() {
            int n = this.getSize().width;
            int n2 = this.getSize().height;
            this._g = new McGuiPlayer(this.parent, this.getLocation().x, this.getLocation().y, n, n2, this._e);
            cvzo cvzo2 = null;
            if (this._b._e() != null) {
                cvzo2 = cvzo._a(this._b._e());
            }
            this._g.setPreviewItem(38, cvzo2);
            this._g.setRotation(this._f);
            this.addElement(this._g);
            this._j = xabu.this._d / 2 + (int)(170.0f * xabu.this._f);
            this._h = this._b._c()._a();
            if (this._h != null) {
                Number number;
                switch (this._h.type) {
                    case DECIMAL: {
                        number = this._b._d();
                        break;
                    }
                    case INTEGER: {
                        number = (int)this._b._d();
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Unsupported stat type " + (Object)((Object)this._h.type));
                    }
                }
                this._i = this._h.displayer.format(this._h, number);
            } else {
                this._i = String.valueOf((int)this._b._d());
            }
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            zftb zftb2 = zftb._g;
            int n = (int)((float)xabu.this._e - Math.abs(this._d) * 10.0f);
            float f2 = Math.min(1.0f, zftb2._a(Math.max(n - 1, 0), 0.0f, 1.0f, 100.0f));
            float f3 = Math.min(1.0f, zftb2._a(Math.max(n, 0), 0.0f, 1.0f, 100.0f));
            this._a(jywc._a(f2, f3, f));
        }

        private void _a(float f) {
            this._g.scale = this._e * f;
            Point point = this.getLocation();
            Dimension dimension = this.getSize();
            int n = point.x + dimension.width / 2;
            int n2 = point.y + (int)(-90.0f * xabu.this._f * (this._e / 80.0f));
            int n3 = _b[this._c];
            int n4 = n3 | (int)(f * 175.0f) << 24;
            this.renderer.drawHorizontalGradient(point.x, n2, dimension.width / 2, this.renderer.getFontHeight(), n3, n4);
            this.renderer.drawHorizontalGradient(point.x + dimension.width / 2, n2, dimension.width / 2, this.renderer.getFontHeight(), n4, n3);
            int n5 = 0xFFFFFF | (int)(f * 255.0f) << 24;
            if ((n5 & 0xFF000000) == 0) {
                return;
            }
            this.renderer.getFontRenderer().renderCenteredString(this._b._a(), n / 2, (n2 + this.renderer.getFontHeight() / 2) / 2, n5, true);
            this.renderer.getFontRenderer().renderCenteredString(this._b._c()._c() + ":", n / 2, this._j / 2, n5, true);
            this.renderer.getFontRenderer().renderCenteredString(this._i, n / 2, this._j / 2 + 10, n5, true);
        }
    }
}

