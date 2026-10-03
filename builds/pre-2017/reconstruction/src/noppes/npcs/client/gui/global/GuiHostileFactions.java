/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import noppes.npcs.client.gui.global.GuiNPCManageFactions;
import noppes.npcs.controllers.Faction;

public class GuiHostileFactions
extends GuiScreenAdvanced {
    private Faction faction;
    private Map<String, Integer> allFactions;
    private Set<String> hostileFactions;

    public GuiHostileFactions(GuiNPCManageFactions guiNPCManageFactions, Faction faction, Map<String, Integer> map, Set<String> set) {
        super(GuiHelper.widgetsRenderer, 600, 580, guiNPCManageFactions);
        this.faction = faction;
        this.allFactions = map;
        this.hostileFactions = set;
    }

    @Override
    public void initGui() {
        super.initGui();
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop + 25, this.guiWidth, this.guiHeight, true);
        List list2 = this.allFactions.entrySet().stream().map(entry -> new FactionEntry((String)entry.getKey(), this.hostileFactions.contains(entry.getKey()))).collect(Collectors.toList());
        list2.sort(Comparator.comparing(factionEntry -> ((FactionEntry)factionEntry).faction));
        Point point = new Point(this.screenWidth / 2 - 275, this.screenHeight / 2 - 250);
        Dimension dimension = new Dimension(550, 500);
        FactionList factionList = new FactionList(this, GuiHelper.listStyle, list2, point, dimension.add(-13, 0));
        factionList.setRenderer(GuiComponent.hdRenderer);
        McScrollBar mcScrollBar = new McScrollBar((IAdvancedGui)this, (IScrollable)factionList, McScrollBar.ScrollBarType.VERTICAL, point.add(dimension.width, 14), dimension.height - 28, GuiHelper.sliderStyle.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        factionList.setSlider(mcScrollBar);
        factionList.setDrawLineSeparators(true);
        this.addElement(factionList);
        this.addElement(mcScrollBar);
        this.addElement(new McScrollButton((IAdvancedGui)this, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, point.add(dimension.width, 0), GuiHelper.scrollButtonStyle.getTopArrowStyle()));
        this.addElement(new McScrollButton((IAdvancedGui)this, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, point.add(dimension.width, dimension.height - 14), GuiHelper.scrollButtonStyle.getBottomArrowStyle()));
        this.addElement(GuiHelper.addButton(this, this.screenWidth / 2 - 100, this.screenHeight / 2 + 260, 200, 35, "\u0417\u0430\u043a\u0440\u044b\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen()));
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        this.faction.attackFactions.clear();
        List list2 = this.hostileFactions.stream().map(string -> this.allFactions.get(string)).collect(Collectors.toList());
        this.faction.attackFactions.addAll(list2);
    }

    private class FactionList
    extends McScrollList<FactionEntry> {
        public FactionList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List list2, Point point, Dimension dimension) {
            super(iAdvancedGui, componentButtonStyle, list2, point, dimension);
        }

        @Override
        public void setSelectedLineId(int n) {
            super.setSelectedLineId(n);
            FactionEntry factionEntry = (FactionEntry)this.getSelectedLine();
            if (factionEntry != null) {
                factionEntry.hostile = !factionEntry.hostile;
                if (factionEntry.hostile) {
                    GuiHostileFactions.this.hostileFactions.add(factionEntry.faction);
                } else {
                    GuiHostileFactions.this.hostileFactions.remove(factionEntry.faction);
                }
                this.setSelectedLineId(-1);
            }
        }
    }

    private class FactionEntry
    implements vjsq {
        private String faction;
        private boolean hostile;

        public FactionEntry(String string, boolean bl) {
            this.faction = string;
            this.hostile = bl;
        }

        @Override
        public String getString() {
            return this.faction;
        }

        @Override
        public int getColor() {
            return this.hostile ? 0xFF1111 : -1;
        }
    }
}

