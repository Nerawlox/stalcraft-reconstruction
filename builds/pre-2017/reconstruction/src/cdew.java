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
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.component.TreeScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.money.zwat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class cdew
extends GuiScreenAdvanced {
    private static final int _b = 40;
    private static final String _c = "\u041f\u0440\u043e\u0447\u0435\u0435";
    private static final ResourceLocation _d = new ResourceLocation("stalker", "textures/gui/craft_background.png");
    public static final ComponentButtonStyle _a = new ComponentButtonStyle(){
        {
            this.setTexture(_d);
            this.setSize(110, 47);
            this.setDefaultUv(2, 463);
            this.setMouseOverUv(257, 463);
            this.setActiveUv(374, 463);
        }
    };
    private final GuiRenderer _e;
    private final String _f;
    private List<pidb> _g;
    private Point _h;
    private ezey _i;
    private GuiComponentsList<GuiComponent> _j;
    private GuiComponentsList<McToolTip> _k;
    private int _l;
    private int _m;
    private hsvw _n;
    private int _o;
    private boolean _p;

    public cdew(String string) {
        super(new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma12).setTextureSize(1024, 512).create());
        this._e = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma14).create();
        this._g = new ArrayList<pidb>();
        this._j = new GuiComponentsList(this);
        this._k = new GuiComponentsList(this);
        this._l = -1;
        this._m = 1;
        this._o = 0;
        this._p = false;
        this._f = string;
        this._c();
    }

    private void _c() {
        HashMap<String, pidb> hashMap = new HashMap<String, pidb>();
        Collection<hsvw> collection = hszb._a._a().values();
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        for (hsvw object2 : collection) {
            boolean pidb4;
            if (!magc._a(entityClientPlayerMP)._a(object2) || (pidb4 = !this._f.isEmpty() && !object2._j().isEmpty() && !object2._j().contains(this._f))) continue;
            String string2 = object2._f();
            if (string2 == null || string2.isEmpty()) {
                string2 = _c;
            }
            pidb pidb3 = hashMap.computeIfAbsent(string2, string -> new pidb((String)string));
            boolean bl = hszb._a._a(entityClientPlayerMP, object2, 1);
            pidb3._c.add(new eidj(object2, bl));
        }
        ArrayList arrayList = new ArrayList(hashMap.values());
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            pidb pidb4 = (pidb)iterator2.next();
            pidb4._c.sort(Comparator.comparing(eidj2 -> ((eidj)eidj2)._b._e()));
        }
        arrayList.sort(Comparator.comparing(pidb2 -> ((pidb)pidb2)._b));
        this._g.addAll(arrayList);
    }

    @Override
    public void initGui() {
        super.initGui();
        this._h = new Point(this.screenWidth / 2, this.screenHeight / 2);
        McBackground mcBackground = new McBackground(this, this._h.add(-400, -228), new Dimension(800, 456)).setTexture(_d).setHasBackground(true);
        this.addElement(mcBackground);
        this._i = new ezey(this, _a, new ArrayList<TreeScrollList.TreeElement>(this._g), this._h.add(-390, -218), new Dimension(270, 440));
        this.addElement(this._i);
        this.addElement(this._j);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        int n = this._i.getSelectedLineId();
        if (n != this._l) {
            TreeScrollList.TreeElement treeElement = (TreeScrollList.TreeElement)this._i.getSelectedLine();
            if (treeElement != null && treeElement instanceof eidj) {
                this._a(((eidj)treeElement)._b);
                this._l = n;
                this._m = 1;
            } else {
                this._a((hsvw)null);
                this._l = -1;
                this._m = 1;
            }
        }
        if (this._p && ++this._o == 40) {
            this._e();
        }
    }

    public void _a() {
        if (this._n != null) {
            this._a(this._n);
        }
    }

    private void _a(hsvw hsvw2) {
        this._j.clearElements();
        this._k.clearElements();
        this._n = hsvw2;
        if (hsvw2 == null) {
            return;
        }
        this._j.addElement(new McLabel((IAdvancedGui)this, hsvw2._e(), this._h.add(-this._e.getStringWidth(hsvw2._e()) / 2 + 50, -210), -1).setFontRenderer(ExternalFont.tahoma14));
        String string = "\u0418\u043d\u0433\u0440\u0435\u0434\u0438\u0435\u043d\u0442\u044b";
        this._j.addElement(new McLabel((IAdvancedGui)this, string, this._h.add(-ExternalFont.tahoma13.getStringWidth(string) + 50, -180), -1).setFontRenderer(ExternalFont.tahoma13));
        this._c(hsvw2);
        this._d(hsvw2);
        this._b(hsvw2);
        this._j.addElement(this._k);
    }

    private void _b(hsvw hsvw2) {
        GuiComponent guiComponent;
        Object object;
        int n;
        GuiRenderer guiRenderer = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma9).create();
        ItemStack itemStack = hsvw2._h()._l();
        List<String> list = this._a(itemStack);
        String string = hsvw2._g();
        if (!list.isEmpty()) {
            string = string + "\n\n\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0435\u0442\u0441\u044f:\n" + String.join((CharSequence)"\n", list);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = string.split("\n");
        int n2 = stringArray.length;
        for (n = 0; n < n2; ++n) {
            object = stringArray[n];
            arrayList.addAll(guiRenderer.wrapString((String)object, 150));
        }
        int n3 = 148 + arrayList.size() * (guiRenderer.getFontHeight() + 3);
        McScrollPane mcScrollPane = GuiHelper.createScrollPane(this, this._h.add(212, -218), new Dimension(180, 440), new Dimension(180, n3), true);
        this._j.addElement(mcScrollPane);
        for (n = 0; n < arrayList.size(); ++n) {
            object = new Point(10, 148 + n * (guiRenderer.getFontHeight() + 3));
            guiComponent = new McLabel((IAdvancedGui)this, (String)arrayList.get(n), (Point)object);
            mcScrollPane.getViewport().addElement(guiComponent);
            guiComponent.setRenderer(guiRenderer);
        }
        McImage mcImage = new McImage((IAdvancedGui)this, 15, 8, 889, 2, 133, 135, _d);
        object = new McDummySlot(this, itemStack, new Point(17, 11), 4.0f);
        guiComponent = (McToolTip)((McDummySlot)object).createToolTip().setRenderer(GuiHelper.widgetsRenderer);
        this._k.addElement((McToolTip)guiComponent);
        mcScrollPane.getViewport().addAll(new GuiComponent[]{mcImage, object});
    }

    private List<String> _a(ItemStack itemStack) {
        magc magc2 = magc._a(Minecraft._E()._t);
        return hszb._a._a().values().stream().filter(hsvw2 -> hsvw2._i().stream().anyMatch(itemStack2 -> itemStack2._a() == itemStack._a() && itemStack2._j() == itemStack._j())).filter(magc2::_a).map(hsvw::_e).collect(Collectors.toList());
    }

    private void _c(hsvw hsvw2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        List<ItemStack> list = hsvw2._i();
        for (int i = 0; i < list.size(); ++i) {
            ItemStack itemStack = list.get(i);
            GuiRenderer guiRenderer = GuiHelper.widgetsRenderer;
            McImage mcImage = new McImage((IAdvancedGui)this, this._h.x - 90, this._h.y - 150 + i * 40, 220, 0, 36, 36, GuiHelper.widgets);
            mcImage.setRenderer(guiRenderer);
            McDummySlot mcDummySlot = new McDummySlot(this, itemStack, mcImage.getLocation().x + 2, mcImage.getLocation().y + 2, 1.0f);
            mcDummySlot.setRenderer(guiRenderer);
            this._j.addAll(new GuiComponent[]{mcImage, mcDummySlot});
            this._k.addElement(mcDummySlot.createToolTip());
            this._j.addElement(new McLabel((IAdvancedGui)this, itemStack._s(), this._h.add(-50, -150 + i * 40 + 10), -1));
            int n = ncwh._b((EntityPlayer)entityClientPlayerMP, itemStack._d);
            int n2 = itemStack._b * this._m;
            String string = n + "/" + n2;
            this._j.addElement(new McLabel((IAdvancedGui)this, string, this._h.add(180 - this.renderer.getStringWidth(string), -150 + i * 40 + 10), n < n2 ? -65536 : -16711936));
        }
    }

    private void _d(hsvw hsvw2) {
        boolean bl;
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        boolean bl2 = hszb._a._a(entityClientPlayerMP, hsvw2, this._m);
        long l = hsvw2._b() * (long)this._m;
        boolean bl3 = bl = l <= 0L || zwat._a(entityClientPlayerMP)._a() >= l;
        if (l > 0L) {
            String string = "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c: " + NumberFormat.getNumberInstance(Locale.ENGLISH).format(l) + " \u0440\u0443\u0431.";
            this._j.addElement(new McLabel((IAdvancedGui)this, string, this._h.add(-65, 150), bl ? -1 : -65536).setFontRenderer(ExternalFont.tahoma10));
        }
        int n = this._m * hsvw2._h()._b;
        String string = "\u0418\u0437\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c";
        if (n > 1) {
            string = string + " " + n + " \u0448\u0442.";
        }
        McButton mcButton = new kjui(this, this._h.x - 65, this._h.y + (l > 0L ? 170 : 160), 200, 38, string).onClick(guiActionButtonClick -> this._d());
        mcButton.setRenderer(GuiComponent.hdRenderer.setFont(ExternalFont.tahoma12));
        mcButton.setEnabled(bl2);
        this._j.addElement(mcButton);
        GuiHelper.addButton(this._j, this._h.add(145, 145), new Dimension(40, 20), "+").onClick(guiActionButtonClick -> {
            ++this._m;
            this._a(hsvw2);
        });
        GuiHelper.addButton(this._j, this._h.add(145, 195), new Dimension(40, 20), "-").onClick(guiActionButtonClick -> {
            --this._m;
            this._a(hsvw2);
        }).setEnabled(this._m > 1);
        this._j.addElement(new McLabel((IAdvancedGui)this, String.valueOf(this._m), this._h.add(160, 170), -1));
    }

    private void _d() {
        if (this._p) {
            return;
        }
        this._p = true;
        this._o = 0;
    }

    private void _e() {
        this._p = false;
        this._o = 0;
        if (this._n != null) {
            new aohw(this._f, this._n._d(), this._m).sendToServer();
        }
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
            float f2 = (float)cdew.this._o / 40.0f;
            if (this.getVisible()) {
                this.renderer.drawRect(this.getLocation().x + 5, this.getLocation().y + 5, (float)(this.getSize().width - 10) * f2, this.getSize().height - 10, 1788056467);
            }
        }

        @Override
        public boolean getEnabled() {
            return super.getEnabled() && !cdew.this._p;
        }
    }

    private class ezey
    extends TreeScrollList {
        private GuiRenderer.RenderItemHD _b;

        public ezey(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<TreeScrollList.TreeElement> list, Point point, Dimension dimension) {
            super(iAdvancedGui, componentButtonStyle, list, point, dimension);
            this._b = this.renderer.createItemRender(2.0f);
            this.lineHeight = 47;
            McScrollBar mcScrollBar = new McScrollBar(iAdvancedGui, (IScrollable)this, McScrollBar.ScrollBarType.VERTICAL, new Point(point.x + dimension.width, point.y), dimension.height - 14, GuiHelper.sliderStyle.getVerticalBarStyle());
            this.setDrawLineSeparators(true);
            mcScrollBar.setRenderer(GuiHelper.widgetsRenderer);
            this.setSlider(mcScrollBar);
            iAdvancedGui.getElementsList().addElement(mcScrollBar);
            McScrollButton mcScrollButton = new McScrollButton(iAdvancedGui, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), GuiHelper.scrollButtonStyle.getTopArrowStyle());
            iAdvancedGui.getElementsList().addElement(mcScrollButton);
            mcScrollButton.setRenderer(GuiHelper.widgetsRenderer);
            McScrollButton mcScrollButton2 = new McScrollButton(iAdvancedGui, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), GuiHelper.scrollButtonStyle.getBottomArrowStyle());
            iAdvancedGui.getElementsList().addElement(mcScrollButton2);
            mcScrollButton2.setRenderer(GuiHelper.widgetsRenderer);
        }

        @Override
        protected void drawLine(int n, int n2, Point point) {
            Point point2 = this.getLocation();
            this.renderer.drawButton(this.getLocation().x, n2, new Dimension(this.getTotalWidth(), this.getStyle().getSize().height), this.getStyle(), this.getState(n, point));
            TreeScrollList.TreeElement treeElement = (TreeScrollList.TreeElement)this.lines.get(n);
            if (treeElement.isLeaf()) {
                eidj eidj2 = (eidj)treeElement;
                hsvw hsvw2 = eidj2._b;
                int n3 = eidj2._c ? 0x5500FF00 : 0x55FF0000;
                this.renderer.drawGradientRect(point2.x + 7, n2 + this.lineHeight - 11, this.getSize().width - 14, 10.0, 0, n3);
                this.renderer.bindTexture(GuiHelper.widgets);
                int n4 = point2.x + 25;
                GuiHelper.widgetsRenderer.drawTexturedModalRect(n4 - 2, n2 + 10 - 2, 220, 0, 36, 36);
                GL11.glEnable(3042);
                GL11.glPushAttrib(1048575);
                this._b.renderItemIcon(hsvw2._h(), n4, n2 + 10);
                GL11.glPopAttrib();
                this.renderer.drawString(hsvw2._e(), n4 + 50, n2 + Math.abs(this.lineHeight - this.renderer.getFontHeight()) / 2 + 5, -12368826);
            } else {
                cdew.this._e.drawString(treeElement.getString(), this.getLocation().x + 15, n2 + Math.abs(this.lineHeight - this.renderer.getFontHeight()) / 2, -12368826);
                cdew.this._e.drawString(this.isExpanded(treeElement) ? "\u2212 " : "+ ", this.getLocation().x + this.getSize().width - 30, n2 + Math.abs(this.lineHeight - this.renderer.getFontHeight()) / 2, -12368826);
            }
        }
    }

    private class pidb
    implements TreeScrollList.TreeElement {
        private String _b;
        private List<eidj> _c;

        public pidb(String string) {
            this._b = string;
            this._c = new ArrayList<eidj>();
        }

        @Override
        public String getString() {
            return this._b;
        }

        @Override
        public int getColor() {
            return -1;
        }

        @Override
        public Collection<? extends TreeScrollList.TreeElement> elements() {
            return this._c;
        }
    }

    private class eidj
    implements TreeScrollList.TreeElement {
        private hsvw _b;
        private boolean _c;

        public eidj(hsvw hsvw2, boolean bl) {
            this._b = hsvw2;
            this._c = bl;
        }

        @Override
        public String getString() {
            return this._b._e();
        }

        @Override
        public int getColor() {
            return -1;
        }

        @Override
        public Collection<? extends TreeScrollList.TreeElement> elements() {
            return Collections.emptyList();
        }
    }
}

