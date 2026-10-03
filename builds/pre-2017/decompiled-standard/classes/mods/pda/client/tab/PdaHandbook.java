/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.TreeScrollList;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.misc.ezfa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;

public class PdaHandbook
extends AbstractPdaTab {
    private static int firstColumnWidth = 315;
    private static int secondColumnWidth = 426;
    private List<anmx> content = new ArrayList<anmx>(piwi._a());
    private McScrollList<anmx> list;
    private McScrollPane infoPane;
    private anmx selected = null;
    private anmx displayed = null;

    public PdaHandbook(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        if (this.displayed != null) {
            this.decrementPictureUsageCount();
            this.displayed = null;
        }
        this.selected = null;
        this.setupContentList();
        this.pda.addElement(this.list);
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, new Dimension(firstColumnWidth, this.pdaScreen.height), true);
        this.drawColoredScreenBackground(this.pdaScreenStart.add(firstColumnWidth, 0), new Dimension(secondColumnWidth, this.pdaScreen.height), true, -7236972);
        super.drawComponent(point, f);
    }

    @Override
    public void tick() {
        super.tick();
        anmx anmx2 = this.list.getSelectedLine();
        if (anmx2 instanceof eixm && this.selected != anmx2) {
            this.selected = anmx2;
            this.showPage((eixm)this.selected);
        }
    }

    @Override
    public void onScreenClose() {
        super.onScreenClose();
        this.decrementPictureUsageCount();
    }

    private void setupContentList() {
        anmx anmx2 = null;
        if (this.list != null) {
            anmx2 = this.list.getSelectedLine();
        }
        Point point = this.pdaScreenStart.add(5, 22);
        Dimension dimension = new Dimension(firstColumnWidth - 22, this.pdaScreen.height - 20);
        if (this.list == null) {
            this.list = this.createTreeList(this.content, point, dimension);
        } else {
            this.updateList(this.list, point, dimension);
        }
        if (anmx2 != null) {
            this.list.setSelectedLineId(this.content.indexOf(anmx2));
        }
        this.list.setDrawIndices(false);
    }

    private void showPage(eixm eixm2) {
        int n;
        int n2;
        this.decrementPictureUsageCount();
        if (this.infoPane != null) {
            this.pda.removeElement(this.infoPane);
        }
        int n3 = secondColumnWidth - 200;
        String string = eixm2._b() != null ? ezfc._a(eixm2._b()) : "";
        List<String> list = this.wrapWithLinebreaks(string, n3, null);
        String string2 = eixm2._c() != null ? ezfc._a(eixm2._c()) : "";
        int n4 = secondColumnWidth - 55;
        List<String> list2 = this.wrapWithLinebreaks(string2, n4, null);
        int n5 = this.renderer.getFontHeight() + 3;
        int n6 = 40 + n5 * list.size() + n5 * list2.size() + 30;
        this.infoPane = GuiPda.createScrollPane(this.pda, this.pdaScreenStart.add(this.pdaScreen.width - secondColumnWidth + 10, 40), new Dimension(secondColumnWidth - 16, this.pdaScreen.height - 35), new Dimension(secondColumnWidth - 16, n6));
        this.infoPane.getBottomButton().setLocation(this.infoPane.getBottomButton().getLocation().add(0, -6));
        this.infoPane.getTopButton().setLocation(this.infoPane.getTopButton().getLocation().add(0, -18));
        this.infoPane.getVerticalScrollBar().setLocation(this.infoPane.getVerticalScrollBar().getLocation().add(0, -18));
        this.infoPane.getVerticalScrollBar().setLength(this.infoPane.getVerticalScrollBar().getLength() + 10);
        Dimension dimension = new Dimension(secondColumnWidth - 36, 1);
        int n7 = -12368826;
        int n8 = 50;
        for (n2 = 0; n2 < list.size(); ++n2) {
            this.infoPane.getViewport().addElement(new McLabel((IAdvancedGui)this.pda, list.get(n2), new Point(170, n8 + n2 * n5), n7));
        }
        int n9 = n2 = string.isEmpty() ? 0 : list.size() * n5;
        if (eixm2 instanceof kkiq) {
            n = this.setupItemPage((kkiq)eixm2);
            n2 = Math.max(128 + (n != 0 ? 70 : 10), n2);
        } else if (eixm2 instanceof anms) {
            n2 = Math.max(n2, this.setupManualPage((anms)eixm2));
        }
        n = n8 + n2 + 20;
        if (n2 > 0) {
            this.infoPane.getViewport().addElement(new McRect(this.pda, new Point(0, n - 10), dimension, n7));
        }
        for (int i = 0; i < list2.size(); ++i) {
            this.infoPane.getViewport().addElement(new McLabel((IAdvancedGui)this.pda, list2.get(i), new Point(10, n + i * n5), n7));
        }
        GuiRenderer guiRenderer = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma14).create();
        String string3 = eixm2.getString();
        McLabel mcLabel = new McLabel((IAdvancedGui)this.pda, string3, new Point((secondColumnWidth - 36) / 2 - guiRenderer.getStringWidth(string3) / 2, 13), n7);
        mcLabel.setRenderer(guiRenderer);
        this.infoPane.getViewport().addElement(new McRect(this.pda, new Point(0, 6), dimension, n7));
        this.infoPane.getViewport().addElement(new McRect(this.pda, new Point(0, 42), dimension, n7));
        this.infoPane.getViewport().addElement(mcLabel);
        this.infoPane.getViewport().setViewSize(new Dimension(this.infoPane.getViewport().getViewSize().width, n + list2.size() * n5));
        this.pda.addElement(this.infoPane);
        this.displayed = eixm2;
    }

    private void decrementPictureUsageCount() {
        if (this.displayed instanceof anms && ((anms)this.displayed)._g()) {
            ((anms)this.displayed)._f();
        }
    }

    private boolean setupItemPage(kkiq kkiq2) {
        cvzo cvzo2 = kkiq2._d();
        GuiRenderer guiRenderer = new GuiRendererBuilder().setTextureSize(256, 256).create();
        McDummySlot mcDummySlot = new McDummySlot(this.pda, cvzo2, 15, 65, 4.0f);
        mcDummySlot.setEnabled(false);
        mcDummySlot.setRenderer(guiRenderer);
        this.infoPane.getViewport().addElement(mcDummySlot);
        if (cvzo2._a() instanceof ezfa && ((ezfa)((Object)cvzo2._a()))._a_(cvzo2)) {
            McButton mcButton = new McButton(this.pda, 15, 223, iedw._l, "\u041f\u043e\u043a\u0430\u0437\u0430\u0442\u044c");
            mcButton.setSize(new Dimension(138, 30));
            mcButton.onClick(guiActionButtonClick -> mcDummySlot.runClickListener());
            this.infoPane.getViewport().addElement(mcButton);
            return true;
        }
        return false;
    }

    private int setupManualPage(anms anms2) {
        if (!anms2._g()) {
            return 0;
        }
        temw temw2 = anms2._e();
        if (temw2 != null) {
            int n = anms2._h();
            float f = (float)n / (float)temw2._c()._a;
            int n2 = (int)(f * (float)temw2._c()._b);
            McImage mcImage = new McImage((IAdvancedGui)this.pda, new Point(20, 50), new Point(0, 0), new Dimension(n, n2), temw2);
            this.infoPane.getViewport().addElement(mcImage);
            mcImage.setRenderer(new GuiRendererBuilder(mcImage.getRenderer()).setTextureSize(n, n2).create());
            return n2;
        }
        return 0;
    }

    private List<String> wrapWithLinebreaks(String string2, int n, Predicate<String> predicate) {
        return Stream.of(string2.split("\n")).filter(string -> predicate == null || predicate.test((String)string)).map(string -> this.renderer.wrapString((String)string, n)).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private <T extends TreeScrollList.TreeElement> McScrollList<T> createTreeList(List<T> list, Point point, Dimension dimension) {
        TreeScrollList treeScrollList = new TreeScrollList((IAdvancedGui)this.pda, iedw._g, list, Point.zeroPoint, Dimension.zeroDimension);
        this.updateList(treeScrollList, point, dimension);
        return treeScrollList;
    }

    private void updateList(McScrollList mcScrollList, Point point, Dimension dimension) {
        mcScrollList.setLocation(point.add(5, 12));
        mcScrollList.setSize(dimension.add(-13, -35));
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)mcScrollList, McScrollBar.ScrollBarType.VERTICAL, new Point(point.x + dimension.width, point.y + 12), dimension.height - 38, iedw._j.getVerticalBarStyle());
        if (mcScrollList.getSlider() != null) {
            mcScrollBar.pos = mcScrollList.getSlider().pos;
        }
        mcScrollBar.setSliderLength(16);
        mcScrollList.setSlider(mcScrollBar);
        this.pda.addElement(mcScrollBar);
        this.parent.getElementsList().addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.parent.getElementsList().addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 28), iedw._k.getBottomArrowStyle()));
        mcScrollList.getSlider().setStyle(iedw._j.getVerticalBarStyle());
    }

    protected void drawColoredScreenBackground(Point point, Dimension dimension, boolean bl, int n) {
        GL11.glEnable(3042);
        xpzm._E()._R()._a(iedw._a);
        this.renderer.drawTiledRect(point, new Point(128, 959), dimension, new Dimension(64, 64), 20);
        this.renderer.drawRect(point.add(5, 35), dimension.add(-25, -40), n);
        GL11.glEnable(3042);
        if (bl) {
            this.renderer.drawTiledRect(point.add(5, 5), new Point(64, 768), new Dimension(dimension.width - 18, 27), new Dimension(64, 27), 23, 0);
        }
        this.renderer.drawTiledRect(point.add(dimension.width - 18, 20), new Point(24, 832), new Dimension(15, dimension.height - 30), new Dimension(15, 64), 2);
        this.renderer.drawRect(point.add(10, 37), new Dimension(dimension.width - 35, 1), 0x64646464);
        this.renderer.drawRect(point.add(10, dimension.height - 8), new Dimension(dimension.width - 35, 1), 0x64646464);
        xpzm._E()._R()._a(iedw._b);
        this.renderer.drawTiledRect(point.add(5, 35), new Point(0, 0), dimension.add(-25, -40), new Dimension(718, 450), 5, 0);
        GL11.glDisable(3042);
    }
}

