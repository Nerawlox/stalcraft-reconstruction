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
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionRadiopanelSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class zghn
extends GuiScreenAdvanced
implements ejiw {
    private static final ResourceLocation _a = new ResourceLocation("stalkerclans", "textures/gui/clan_storage.png");
    private static final ComponentButtonStyle _b = new ComponentButtonStyle(){
        {
            this.setTexture(_a);
            this.setSize(55, 18);
            this.setDefaultUv(943, 431);
            this.setMouseOverUv(943, 451);
            this.setDisabledUv(941, 471);
        }
    };
    private static final ComponentButtonStyle _c = new ComponentButtonStyle(){
        {
            this.setTexture(_a);
            this.setSize(12, 18);
            this.setDefaultUv(1000, 431);
            this.setMouseOverUv(1000, 451);
            this.setDisabledUv(1000, 471);
        }
    };
    private int _d;
    private int _e;
    private int _f;
    private srli _g;
    private int _h = 0;
    private GuiComponentsList<McToolTip> _i;

    public zghn(GuiScreen guiScreen, int n, int n2, int n3) {
        super(new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma10).setTextureSize(1024, 512).create(), 800, 500, guiScreen);
        this._d = n;
        this._e = n2;
        this._f = n3;
    }

    @Override
    public void initGui() {
        this._i = new GuiComponentsList(this);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        this.addElement(new McBackground(this, point.add(-400, -250), new Dimension(800, 500)).setTexture(_a).setHasBackground(true));
        if (this._g != null) {
            this._a(point);
        }
        this._c(point);
        this._b(point);
        this.addElement(this._i);
    }

    private void _a(Point point) {
        ArrayList<Map.Entry<wnce, srli.kjui>> arrayList = new ArrayList<Map.Entry<wnce, srli.kjui>>(this._g._a().entrySet());
        List list2 = IntStream.range(0, arrayList.size()).mapToObj(n -> pzop._a(n, ((Map.Entry)arrayList.get(n)).getKey(), ((Map.Entry)arrayList.get(n)).getValue())).filter(pzop2 -> ((srli.kjui)pzop2._c)._a()._a() != null && ((srli.kjui)pzop2._c)._c() > 0).sorted(this._d()).collect(Collectors.toList());
        int n2 = list2.size();
        int n3 = (n2 / 3 + 1) * 100 + 2;
        McScrollPane mcScrollPane = GuiHelper.createScrollPane(this, point.add(-198, -206), new Dimension(590, 450), new Dimension(590, n3), true);
        int n4 = 0;
        for (pzop pzop3 : list2) {
            if (((srli.kjui)pzop3._c)._c() <= 0) continue;
            int n5 = n4 % 3 * 191 + 2;
            int n6 = n4 / 3 * 100 + 2;
            kjui kjui2 = new kjui(this, new Point(n5, n6), new Dimension(189, 78), (Integer)pzop3._a, (srli.kjui)pzop3._c);
            mcScrollPane.getViewport().addAll(new GuiComponent[]{kjui2});
            ++n4;
        }
        this.addElement(mcScrollPane);
    }

    private void _b(Point point) {
        kkzc kkzc2 = yuch._a;
        if (kkzc2 != null) {
            int n = 0;
            int n2 = 0;
            for (ItemStack itemStack : this.mc._t.inventory._a) {
                if (itemStack == null) {
                    ++n;
                }
                ++n2;
            }
            this.addElement(new McImage((IAdvancedGui)this, point.add(-380, 140), new Point(960, 343), new Dimension(28, 32), _a));
            this.addElement(new McLabel((IAdvancedGui)this, n2 - n + "/" + n2 + " \u043c\u0435\u0441\u0442 \u0437\u0430\u043d\u044f\u0442\u043e", point.add(-342, 142)).setFontRenderer(ExternalFont.tahoma12));
            int n3 = kkzc2._l;
            this.addElement(new McImage((IAdvancedGui)this, point.add(-380, 190), new Point(958, 385), new Dimension(34, 26), _a));
            this.addElement(new McLabel((IAdvancedGui)this, n3 + " \u041e\u041b", point.add(-342, 192)).setFontRenderer(ExternalFont.tahoma12));
        }
    }

    private void _c(Point point) {
        ComponentCheckboxStyle componentCheckboxStyle = (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McRadioButton.class);
        Point point2 = point.add(-370, -40);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043f\u043e:", point2.add(0, 0)).setFontRenderer(ExternalFont.tahoma13));
        McRadioGroup mcRadioGroup = new McRadioGroup(this);
        GuiRenderer guiRenderer = GuiHelper.widgetsRenderer.setFont(ExternalFont.tahoma12);
        mcRadioGroup.addElement(new McRadioButton(mcRadioGroup, "ID", point2.add(0, 25), componentCheckboxStyle).setRenderer(guiRenderer));
        mcRadioGroup.addElement(new McRadioButton(mcRadioGroup, "\u0446\u0435\u043d\u0435 (\u0432\u043e\u0437\u0440.)", point2.add(0, 50), componentCheckboxStyle).setRenderer(guiRenderer));
        mcRadioGroup.addElement(new McRadioButton(mcRadioGroup, "\u0446\u0435\u043d\u0435 (\u0443\u0431\u044b\u0432.)", point2.add(0, 75), componentCheckboxStyle).setRenderer(guiRenderer));
        mcRadioGroup.setActiveButton(this._h);
        this.actionManager.registerActionHandler(mcRadioGroup, GuiActionRadiopanelSwitch.class, guiActionRadiopanelSwitch -> {
            this._h = ((McRadioGroup)guiActionRadiopanelSwitch.component).getActiveElementIndex();
            this.setWorldAndResolution(this.mc, this.width, this.height);
        });
        this.addElement(mcRadioGroup);
    }

    private Comparator<pzop<Integer, wnce, srli.kjui>> _d() {
        if (this._h == 0) {
            return Comparator.comparing(pzop2 -> ((wnce)pzop2._b)._c());
        }
        if (this._h == 1) {
            return Comparator.comparing(pzop2 -> ((srli.kjui)pzop2._c)._b());
        }
        return Comparator.comparing(pzop2 -> -((srli.kjui)pzop2._c)._b());
    }

    @Override
    public void apply(srli srli2) {
        this._g = srli2;
        this.setWorldAndResolution(this.mc, this.width, this.height);
    }

    private void _a(int n, int n2) {
        srli.kjui kjui2 = this._g._a(n);
        if (kjui2 != null) {
            new dwfk(this._d, this._e, this._f, n, kjui2._a()._c(), n2, kjui2._b()).sendToServer();
        }
    }

    private class kjui
    extends GuiComponentsList {
        private final int _c;
        private final srli.kjui _d;
        int _a;
        private McButton _e;
        private McLabel _f;
        private McButton _g;
        private McButton _h;
        private long _i;

        protected kjui(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, int n, srli.kjui kjui2) {
            super(iAdvancedGui, point, dimension);
            this._a = 1;
            this._i = 0L;
            this._c = n;
            this._d = kjui2;
            this._a();
        }

        private void _a() {
            ItemStack itemStack = this._d._a()._a();
            this.addElement(new McImage(this.parent, Point.zeroPoint, new Point(832, 44), new Dimension(189, 95), _a));
            this.addElement(new McImage(this.parent, new Point(4, 4), new Point(148, 0), new Dimension(72, 72), GuiHelper.widgets).setRenderer(GuiHelper.widgetsRenderer));
            McDummySlot mcDummySlot = new McDummySlot(this.parent, itemStack, new Point(8, 8), 2.0f);
            mcDummySlot.setRenderer(GuiComponent.hdRenderer);
            this.addElement(mcDummySlot);
            zghn.this._i.addElement(mcDummySlot.createToolTip());
            this.addElement(new McLabel(this.parent, itemStack._s(), new Point(82, 4)).setMaxWidth(100));
            int n = this.renderer.getFontHeight();
            GuiRenderer guiRenderer = this.renderer.setFont(ExternalFont.tahoma10);
            String string = String.valueOf(this._d._c()) + " \u0448\u0442.";
            this.addElement(new McLabel(this.parent, string, new Point(40 - guiRenderer.getStringWidth(string) / 2, 78)).setRenderer(guiRenderer));
            this.addElement(new McLabel(this.parent, this._d._b() + " \u041e\u041b", new Point(86, 8 + n)).setFontRenderer(ExternalFont.tahoma13));
            this._e = new McButton(this.parent, new Point(82, 72), _b, "\u041a\u0443\u043f\u0438\u0442\u044c");
            this._e.onClick(guiActionButtonClick -> zghn.this._a(this._c, this._a));
            this.addElement(this._e);
            this.addElement(new McImage(this.parent, new Point(150, 72), new Point(920, 431), new Dimension(21, 18), _a));
            this._f = new McLabel(this.parent, String.valueOf(this._a), new Point(157, 74), -1);
            this.addElement(this._f);
            this._g = new McButton(this.parent, new Point(138, 72), _c, "+").onClick(guiActionButtonClick -> this._b());
            this.addElement(this._g);
            this._h = new McButton(this.parent, new Point(171, 72), _c, "-").onClick(guiActionButtonClick -> this._c());
            this.addElement(this._h);
        }

        private void _b() {
            if (this._a < this._d._c()) {
                ++this._a;
            }
        }

        private void _c() {
            if (this._a > 1) {
                --this._a;
            }
        }

        @Override
        public void tick() {
            super.tick();
            if (yuch._a != null) {
                this._e.setEnabled(yuch._a._l >= this._d._b() * this._a);
            }
            int n = this._e.textColor = this._e.getEnabled() ? -1 : -65536;
            if (this._g.isPressed || this._h.isPressed) {
                if (this._i > 10L) {
                    if (this._g.isPressed) {
                        this._b();
                    } else {
                        this._c();
                    }
                } else {
                    ++this._i;
                }
            } else {
                this._i = 0L;
            }
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            this._f.setText(String.valueOf(this._a));
            int n = this._f.getRenderer().getStringWidth(this._f.getText());
            this._f.setLocation(new Point(160 - n / 2, 74));
        }
    }
}

