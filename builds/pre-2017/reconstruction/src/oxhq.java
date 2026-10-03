/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiActionHandler;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.misc.hanr;
import gloomyfolken.mods.shop.ShopMod;
import gloomyfolken.mods.shop.data.CaseData;
import gloomyfolken.mods.shop.data.CaseType;
import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class oxhq
extends GuiScreenAdvanced
implements hsso.kjui,
zxgf.kjui {
    protected static final GuiRenderer _a = new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create();
    protected static final GuiRenderer _b = new GuiRendererBuilder().setTextureSize(64, 64).create();
    private static int _d = 6;
    private CaseType _e;
    private GuiComponentsList<GuiComponent> _f;
    private McScrollPane _g;
    private McScrollPane _h;
    private GuiComponentsList<McToolTip> _i;
    private McButton _j;
    private McLabel _k;
    private McLabel _l;
    protected int _c = -1;

    public oxhq(GuiScreen guiScreen) {
        super(_a, 800, 496, guiScreen);
        if (ShopMod._b() == null) {
            new sbqn().sendToServer();
        }
    }

    @Override
    public void initGui() {
        this.addElement(new kjui(this));
        this._l = new McLabel((IAdvancedGui)this, this._g(), new Point(this.guiLeft + 30, this.guiTop + 440), 0x939393);
        this.setBalance(this._c);
        this.addElement(this._l);
        this._c();
        if (ShopMod._b() != null) {
            this._a();
            this._b();
        }
        new cddu().sendToServer();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.renderer.drawRect(this.guiLeft + 15, this.guiTop + 421, 252.0, 1.0, 0x55939393);
    }

    private void _a(String string, int n, int n2) {
        if (this._k != null) {
            this.removeElement(this._k);
        }
        this._k = new McLabel((IAdvancedGui)this, string, new Point(n, n2), 0x939393);
        this._k.setCentered(n, n2);
        if (this._e != null) {
            this.addElement(this._k);
        }
    }

    private void _a() {
        List list2 = ShopMod._b().typeList.stream().filter(caseType -> caseType.isListable).collect(Collectors.toList());
        if (this._g != null) {
            this.removeElement(this._g);
            this._g = null;
        }
        int n = 100;
        this._g = new McScrollPane(this, new Point(this.guiLeft + 19, this.guiTop + 37), new Dimension(268, 320), new Dimension(264, n * list2.size()), true);
        this._g.setScrollButtonStyle(iedw._k);
        this._g.setScrollBarStyle(iedw._j);
        this._g.initControls();
        McScrollBar mcScrollBar = this._g.getVerticalScrollBar();
        if (mcScrollBar != null) {
            mcScrollBar.setSliderLength(16);
            mcScrollBar.setLocation(mcScrollBar.getLocation().add(-1, -14));
            mcScrollBar.setLength(412);
        }
        if (this._g.getTopButton() != null) {
            this._g.getTopButton().setLocation(new Point(256, -16));
        }
        if (this._g.getBottomButton() != null) {
            this._g.getBottomButton().setLocation(new Point(256, 415));
        }
        this.addElement(this._g);
        for (int i = 0; i < list2.size(); ++i) {
            CaseType caseType2 = (CaseType)list2.get(i);
            vkwc vkwc2 = new vkwc(this, caseType2, 0, i * n);
            vkwc2.setRenderer(_a);
            if (this._e != null && caseType2 == this._e) {
                vkwc2._b.setActive(true);
            }
            this._g.getViewport().addElement(vkwc2);
        }
    }

    private void _b() {
        int n;
        if (this._e == null) {
            return;
        }
        if (this._h != null) {
            this.removeElement(this._h);
            this._h = null;
        }
        if (this._i != null) {
            this.removeElement(this._i);
            this._i = null;
        }
        if (this._f != null) {
            this.removeElement(this._f);
            this._f = null;
        }
        if (this._e._d().isEmpty()) {
            return;
        }
        this._a("\u0418\u0437 \u044d\u0442\u043e\u0433\u043e \u043a\u0435\u0439\u0441\u0430 \u0432\u044b \u043c\u043e\u0436\u0435\u0442\u0435 \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c:", this.guiLeft + 547, this.guiTop + 55);
        if (this._h != null) {
            this.removeElement(this._h);
            this._h = null;
        }
        List list3 = this._e._d().stream().map(flpm2 -> new ArrayList<pzne>(flpm2._c())).collect(Collectors.toList());
        int n2 = list3.stream().mapToInt(list2 -> (int)(Math.ceil((double)list2.size() / (double)_d) * 72.0) + 45).sum();
        this._h = GuiHelper.createScrollPane((IAdvancedGui)this, new Point(this.guiLeft + 310, this.guiTop + 80), new Dimension(462, 380), new Dimension(452, n2), true, iedw._j, iedw._k);
        McScrollBar mcScrollBar = this._h.getVerticalScrollBar();
        if (mcScrollBar != null) {
            n = 10;
            this._h.getTopButton().setLocation(new Point(463 + n, -60));
            this._h.getBottomButton().setLocation(new Point(463 + n, 372));
            mcScrollBar.setLocation(new Point(463 + n, -45));
            mcScrollBar.setLength(414);
            mcScrollBar.setSliderLength(16);
        }
        this.addElement(this._h);
        this._i = new GuiComponentsList(this);
        n = 5;
        for (int i = 0; i < list3.size(); ++i) {
            ArrayList<pzne> arrayList = new ArrayList<pzne>((Collection)list3.get(i));
            if (arrayList.isEmpty()) continue;
            Comparator<pzne> comparator = Collections.reverseOrder(Comparator.comparing(pzne2 -> hanr._a(pzne2._f()))).thenComparing(pzne2 -> Float.valueOf(pzne2._b));
            arrayList.sort(comparator);
            if (list3.size() > 1) {
                this._h.getViewport().addElement(new McLabel((IAdvancedGui)this, i + 1 + "-\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442:", new Point(10, n), 0x939393));
                n += 25;
            }
            int n3 = (int)(Math.ceil((double)arrayList.size() / (double)_d) * 72.0);
            McBackground mcBackground = new McBackground(this, new Point(10, n - 4), new Dimension(434, n3 + 8)).setTexture(iedw._a).setTextureCoords(new Point(227, 950)).setTextureSize(new Dimension(19, 21));
            mcBackground.setResizeBorder(3);
            this._h.getViewport().addElement(mcBackground);
            for (int j = 0; j < arrayList.size(); ++j) {
                pzne pzne3 = (pzne)arrayList.get(j);
                rplo rplo2 = new rplo(this, pzne3._k(), j % _d * 72 + 10, j / _d * 72 + n);
                this._h.getViewport().addElement(rplo2);
                this._i.addElement(rplo2._a());
            }
            n += n3 + 20;
        }
        this.addElement(this._i);
    }

    public void _a(vkwc vkwc2) {
        if (this._e != null) {
            this._e = null;
            this._h();
            this._e();
            this.removeElement(this._k);
        }
        if (vkwc2._b.getActive()) {
            for (GuiComponent guiComponent : this._g.getViewport().getElements()) {
                if (!(guiComponent instanceof vkwc) || guiComponent == vkwc2) continue;
                vkwc vkwc3 = (vkwc)guiComponent;
                if (!((vkwc)guiComponent)._b.getActive()) continue;
                vkwc3._b.setActive(false);
                break;
            }
            this._e = vkwc2._a;
            this._d();
            this._b();
        }
    }

    private void _c() {
        McButton mcButton = GuiHelper.addButton(this, new Point(this.guiLeft + 16 + 120, this.guiTop + 430), new Dimension(130, 30), iedw._l, "\u041f\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u044c");
        if (ShopMod._a() != null) {
            mcButton.onClick(guiActionButtonClick -> {
                try {
                    Desktop.getDesktop().browse(new URL(ShopMod._a().addFundsLink).toURI());
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            });
        }
        if (this._e != null) {
            this._e();
        }
        this._j = new McButton((IAdvancedGui)this, new Point(this.guiLeft + 16, this.guiTop + 380), iedw._l, "\u041e\u0442\u043a\u0440\u044b\u0442\u044c");
        this._j.setSize(new Dimension(250, 30));
        if (this._e != null) {
            this._d();
        }
    }

    private void _d() {
        this._f();
        this.addElement(this._j);
    }

    @GuiActionHandler
    public void _a(GuiActionButtonClick guiActionButtonClick) {
        if (this._e == null) {
            return;
        }
        if (guiActionButtonClick.component == this._j) {
            new yudo(this._e.case_id).sendToServer();
        }
    }

    private void _e() {
        this.removeElement(this._j);
    }

    @Override
    public void setBalance(int n) {
        this._c = n;
        this._l.setText(this._g());
        if (this._e != null) {
            this._f();
        }
    }

    private void _f() {
        if (this._e != null) {
            this._j.setEnabled((this._e.amount == 0 || this._e.casesLeft > 0) && this._c >= this._e._e());
            this._j.text = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c (" + this._e._e() + " \u0440\u0443\u0431.)";
        } else {
            this._j.text = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c";
        }
    }

    private String _g() {
        if (this._c != -1) {
            return this._c + " " + ShopMod._a().currencyName;
        }
        return "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430...";
    }

    public void _a(Map<Integer, Integer> map) {
        for (GuiComponent guiComponent : this._g.getViewport().getElements()) {
            if (!(guiComponent instanceof vkwc)) continue;
            int n = ((vkwc)guiComponent)._a.case_id;
            if (map.containsKey(n)) {
                ((vkwc)guiComponent)._a(map.get(n));
                continue;
            }
            ((vkwc)guiComponent)._a(0);
        }
    }

    public void _a(int n) {
        for (GuiComponent guiComponent : this._g.getViewport().getElements()) {
            if (!(guiComponent instanceof vkwc) || ((vkwc)guiComponent)._a.case_id != n) continue;
            ((vkwc)guiComponent)._a(((vkwc)guiComponent)._a.casesLeft - 1);
            break;
        }
        this._f();
    }

    private void _h() {
        if (this._h != null) {
            this.removeElement(this._h);
            this._h = null;
        }
        if (this._f != null) {
            this.removeElement(this._f);
            this._f = null;
        }
        if (this._i != null) {
            this.removeElement(this._i);
            this._i = null;
        }
    }

    public void _a(int n, ItemStack[] itemStackArray, boolean bl) {
        this._h();
        CaseType caseType = ShopMod._b()._a(n);
        if (caseType != null) {
            if (bl) {
                Minecraft._E()._a(new cufb(this, caseType, itemStackArray, ""));
                if (this._i != null) {
                    this.removeElement(this._i);
                }
            } else {
                this._a("\u0412\u044b \u043f\u043e\u043b\u0443\u0447\u0430\u0435\u0442\u0435:", this.guiLeft + 547, this.guiTop + 55);
                this._i = new GuiComponentsList(this);
                this._h = GuiHelper.addScrollPane(this, this.guiLeft + 324, this.guiTop + 67, 452, 384, 442, 72 * (itemStackArray.length / _d));
                for (int i = 0; i < itemStackArray.length; ++i) {
                    rplo rplo2 = new rplo(this, itemStackArray[i], i % _d * 72, i / _d * 72);
                    this._h.getViewport().addElement(rplo2);
                    this._i.addElement(rplo2._a());
                }
                this.addElement(this._i);
            }
        }
        this._f();
    }

    @Override
    public void _a(CaseData caseData) {
        this.setWorldAndResolution(this.mc, this.width, this.height);
    }

    private class kjui
    extends GuiComponent {
        protected kjui(IAdvancedGui iAdvancedGui) {
            super(iAdvancedGui);
        }

        @Override
        public void drawComponent(Point point, float f) {
            oxhq.this.drawDefaultBackground();
            GL11.glEnable(3042);
            _a.bindTexture(iedw._a);
            _a.drawTiledRect(new Point(oxhq.this.guiLeft, oxhq.this.guiTop - 10), new Point(128, 959), new Dimension(800, 490), new Dimension(64, 64), 20);
            iedw._a(_a, new Point(oxhq.this.guiLeft + 5, oxhq.this.guiTop - 2), new Dimension(287, 480), true, false);
            iedw._a(_a, new Point(oxhq.this.guiLeft + 290, oxhq.this.guiTop - 2), new Dimension(510, 480), true, false);
        }
    }
}

