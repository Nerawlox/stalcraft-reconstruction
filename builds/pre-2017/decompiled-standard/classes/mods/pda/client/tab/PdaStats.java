/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.bundle.common.core.stats.PlayerStats;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

public class PdaStats
extends AbstractPdaTab
implements qlmx.kjui {
    private Stat.StatsCategory category;
    private List<StatListEntry> content = new ArrayList<StatListEntry>();
    private PlayerStats playerStats;
    private String username;

    public PdaStats(IAdvancedGui iAdvancedGui, String string, PlayerStats playerStats, Stat.StatsCategory statsCategory) {
        super(iAdvancedGui);
        this.category = statsCategory;
        this.playerStats = playerStats;
        this.username = string;
        this.allowParentJump = true;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.createHorizontalTabs(Stream.of(Stat.StatsCategory.values()).map(statsCategory -> Pair.of(statsCategory.title, statsCategory)).collect(Collectors.toList()));
        this.initList();
        if (this.playerStats != null) {
            this.updateContent();
        }
    }

    @Override
    public void requestInformation() {
        if (this.playerStats == null) {
            new jxzm(this.username).sendToServer();
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    private void updateContent() {
        this.content.clear();
        Stat.getAll().stream().filter(stat -> stat.category == this.category).map(stat -> new StatListEntry((Stat)stat, this.playerStats.getOr((Stat)stat, stat.type.getDefault()))).forEach(this.content::add);
    }

    private void createHorizontalTabs(List<Pair<String, Stat.StatsCategory>> list) {
        int n = 0;
        GuiRenderer guiRenderer = this.pda.rendererWithFont(ExternalFont.tahoma11);
        for (int i = 0; i < list.size(); ++i) {
            String string = list.get(i).getKey();
            Stat.StatsCategory statsCategory = list.get(i).getValue();
            int n2 = guiRenderer.getStringWidth(string);
            McButton mcButton = GuiHelper.addButton(this.parent, this.pdaScreenStart.add(10 + n, 15), new Dimension(n2, 15), iedw._f, string);
            n += n2 + 10;
            mcButton.setRenderer(guiRenderer);
            mcButton.onClick(guiActionButtonClick -> {
                this.category = statsCategory;
                this.pda.openTab(this);
            });
            this.pda.addElement(mcButton);
            if (this.category != statsCategory) {
                mcButton.mouseOverTextColor = 0xFFFFFF;
                mcButton.textColor = iedw._e.getRGB();
            } else {
                mcButton.textColor = 0x109101;
                this.pda.addElement(mcButton);
            }
            if (i == list.size() - 1) continue;
            this.pda.addElement(new McImage((IAdvancedGui)this.pda, mcButton.getLocation().add(n2, 0), new Point(84, 880), new Dimension(11, 13), iedw._a));
        }
    }

    protected void initList() {
        Point point = this.pdaScreenStart.add(5, 23);
        Dimension dimension = new Dimension(this.pdaScreen.width - 23, this.pdaScreen.height - 35);
        StatScrollList statScrollList = new StatScrollList(this.parent, iedw._g, this.content, point.add(5, 28), dimension.add(-13, -35));
        statScrollList.setEnabled(false);
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)statScrollList, McScrollBar.ScrollBarType.VERTICAL, point.add(dimension.width, 14), dimension.height - 28, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        statScrollList.setSlider(mcScrollBar);
        statScrollList.setDrawLineSeparators(true);
        this.pda.addElement(statScrollList);
        this.pda.addElement(mcScrollBar);
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), iedw._k.getBottomArrowStyle()));
    }

    @Override
    public void updatePlayerProfile(dwmf dwmf2) {
        if (dwmf2._d().equals(this.username)) {
            this.playerStats = dwmf2._e();
            this.updateContent();
        }
    }

    private static class StatScrollList
    extends McScrollList<StatListEntry> {
        public StatScrollList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<StatListEntry> list, Point point, Dimension dimension) {
            super(iAdvancedGui, componentButtonStyle, list, point, dimension);
        }

        @Override
        protected void drawLine(int n, int n2, Point point) {
            Object object;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.renderer.drawButton(this.getLocation().x, n2 + 2, new Dimension(this.getTotalWidth(), this.getStyle().getSize().height), this.getStyle(), this.getState(n, point));
            int n3 = 5;
            int n4 = n2 + Math.abs(26 - this.renderer.getFontHeight()) / 2;
            if (this.drawIndices) {
                object = String.valueOf(n + 1) + ".";
                this.renderer.drawString((String)object, this.getLocation().x + 25 - this.renderer.getStringWidth((String)object), n4, this.getStyle().getFontColor().getRGB());
                n3 += 25;
            }
            object = (StatListEntry)this.lines.get(n);
            this.renderer.drawString(((StatListEntry)object).stat.title, this.getLocation().x + n3, n4, ((StatListEntry)object).getColor());
            String string = ((StatListEntry)object).getString();
            this.renderer.drawString(string, this.getLocation().x + this.getSize().width - this.renderer.getStringWidth(string) - 5, n4, ((StatListEntry)object).getColor());
            if (this.isDrawLineSeparators() && n != this.lines.size() - 1) {
                this.renderer.drawRect(this.getLocation().x, n2 + this.getStyle().getSize().height + 2, this.getSize().width, 1.0, 0x64646464);
            }
        }
    }

    private class StatListEntry
    implements vjsq {
        public final Stat stat;
        public final Object data;

        private StatListEntry(Stat stat, Object object) {
            this.stat = stat;
            this.data = object;
        }

        @Override
        public String getString() {
            return this.stat.displayer.format(this.stat, this.data);
        }

        @Override
        public int getColor() {
            return 0x939393;
        }
    }
}

