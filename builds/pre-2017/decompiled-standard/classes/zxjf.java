/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import mods.pda.client.component.PdaBackground;

public class zxjf
extends GuiScreenAdvanced
implements qlgl.kjui,
srpu.kjui {
    private static final ComponentButtonStyle _a = new ComponentButtonStyle(){
        {
            this.setTexture(iedw._a);
            this.setDefaultUv(468, 800);
            this.setMouseOverUv(this.getDefaultUv());
            this.setSize(14, 14);
        }
    };
    private String _b;
    private boolean _c;
    private List<String> _d = null;
    private List<String> _e = null;
    private List<String> _f = null;
    private int _g;
    private boolean _h = false;
    private GuiComponentsList<McToolTip> _i = new GuiComponentsList(this);
    private McScrollPane _j;
    private McScrollPane _k;

    public zxjf(gqjz gqjz2, String string, boolean bl) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this._b = string;
        this._c = bl;
        this.parentScreen = gqjz2;
        new ncaj(string).sendClientToBackend();
        new eijo().sendToServer();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this._i.clearElements();
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        int n = (int)((float)this.screenWidth / 1920.0f * 1344.0f);
        int n3 = (int)((float)this.screenHeight / 1080.0f * 864.0f);
        this.addElement(new McBackground(this, point.add(-n / 2, -n3 / 2), new Dimension(n, n3)).setTexture(iedw._a).setTextureSize(new Dimension(64, 64)).setTextureCoords(new Point(128, 959)).setResizeBorder(20).setHasBackground(true));
        int n4 = n / 2;
        if (this._e != null && this._d != null) {
            List<String> list = this._d.stream().filter(string -> !this._e.contains(string)).collect(Collectors.toList());
            int n5 = n4 - 5;
            int n6 = n3 - 48;
            int n7 = point.y - n3 / 2 + 35;
            this._j = this._a("\u0423\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u0438 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438:", list, point.x - n4 + 5, n7, n5, n6, this._j, (mcScrollPane, n2) -> this._a(n, list, (McScrollPane)mcScrollPane, (int)n2));
            this._k = this._a("\u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0435 \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u0438:", this._e, point.x + 1, n7, n5, n6, this._k, (mcScrollPane, n2) -> this._a(n, (McScrollPane)mcScrollPane, (int)n2));
        }
        GuiHelper.addButton(this, point.add(n4 - 140, -n3 / 2 + 6), new Dimension(120, 24), iedw._l, "\u0417\u0430\u043a\u0440\u044b\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        this.addElement(this._i);
    }

    private void _a(int n, List<String> list, McScrollPane mcScrollPane, int n2) {
        if (!this._c) {
            return;
        }
        McButton mcButton = GuiHelper.addButton(mcScrollPane.getViewport(), new Point(n / 2 - 55, n2 * 27 + 8), new Dimension(14, 14), _a, "").onClick(guiActionButtonClick -> {
            String string = (String)list.get(n2);
            this._e.add(string);
            new ctcn(this._b, this._e).sendClientToBackend();
            this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
        });
        this._i.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u0438\u0440\u043e\u0432\u0430\u0442\u044c"), mcButton));
    }

    private void _a(int n, McScrollPane mcScrollPane, int n2) {
        if (!this._c) {
            return;
        }
        McButton mcButton = GuiHelper.addButton(mcScrollPane.getViewport(), new Point(n / 2 - 55, n2 * 27 + 8), new Dimension(14, 14), ogia._a, "").onClick(guiActionButtonClick -> {
            String string = this._e.get(n2);
            if (this._e.remove(string)) {
                new ctcn(this._b, this._e).sendClientToBackend();
                this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
            }
        });
        this._i.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u0421\u043d\u044f\u0442\u044c \u0440\u0435\u0437\u0435\u0440\u0432"), mcButton));
    }

    private McScrollPane _a(String string, List<String> list, int n, int n2, int n3, int n4, McScrollPane mcScrollPane, BiConsumer<McScrollPane, Integer> biConsumer) {
        Point point = new Point(n, n2);
        int n5 = 27;
        this.addElement(new McBackground(this, point, new Dimension(n3, n4)).setTexture(iedw._a).setTextureCoords(new Point(128, 931)).setTextureSize(new Dimension(64, 27)).setResizeBorder(4));
        this.addElement(new PdaBackground(this, point, new Dimension(n3, n4), false, false));
        int n6 = list.size();
        McScrollPane mcScrollPane2 = GuiHelper.createScrollPane((IAdvancedGui)this, point.add(10, 37), new Dimension(n3 - 16, n4 - 48), new Dimension(n3 - 16, n6 * n5), true, iedw._j, iedw._k);
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            Point point2 = new Point(0, i * n5);
            mcScrollPane2.getViewport().addElement(new McLabel((IAdvancedGui)this, i + 1 + ". " + string2, point2.add(0, 5), 0x939393));
            mcScrollPane2.getViewport().addElement(new McRect(this, point2.add(0, n5), new Dimension(n3 - 35, 1), 0x43939393));
            biConsumer.accept(mcScrollPane2, i);
        }
        if (mcScrollPane2.getVerticalScrollBar() != null) {
            mcScrollPane2.getTopButton().move(0, -16);
            mcScrollPane2.getVerticalScrollBar().move(0, -16);
            mcScrollPane2.getBottomButton().move(0, -2);
            mcScrollPane2.getVerticalScrollBar().setLength(mcScrollPane2.getVerticalScrollBar().getLength() + 13);
            mcScrollPane2.getVerticalScrollBar().setSliderLength(16);
            if (mcScrollPane != null && mcScrollPane.getVerticalScrollBar() != null) {
                mcScrollPane2.getVerticalScrollBar().pos = mcScrollPane.getVerticalScrollBar().pos;
            }
        }
        this.addElement(mcScrollPane2);
        GuiHelper.addLabel((IAdvancedGui)this, string, Point.zeroPoint, -7105645).setFontRenderer(ExternalFont.tahoma14).setCentered(n + n3 / 2, n2 + 18);
        return mcScrollPane2;
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        if (this.parentScreen instanceof ogia && this._h) {
            ((ogia)this.parentScreen)._a(this._e, this._f, null, this._g);
        }
    }

    @Override
    public void _a(List<String> list, List<String> list2, List<String> list3, int n) {
        this._e = list;
        this._f = list2;
        this._g = n;
        this._h = true;
        this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
    }

    @Override
    public void _a(List<ezfa> list) {
        this._d = list.stream().map(ezfa2 -> ezfa2._a).collect(Collectors.toList());
        this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
    }
}

