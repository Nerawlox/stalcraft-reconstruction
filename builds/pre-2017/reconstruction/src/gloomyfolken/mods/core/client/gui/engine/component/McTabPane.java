/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiException;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McTabButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPageButton;
import java.util.ArrayList;
import java.util.List;

public class McTabPane
extends GuiComponentsList<McTabButton> {
    protected List<McTabButton> tabs = new ArrayList<McTabButton>();
    protected int startTab;
    protected int tabsAtPage;
    public McTabButton activeTab;
    protected boolean scrollable;
    protected boolean autoResize;
    protected int resizeBorder;
    protected int tabBorder;
    protected int maxWidth;
    protected int nextButtonX;
    protected McTabPageButton prevButton;
    protected McTabPageButton nextButton;

    public McTabPane(IAdvancedGui iAdvancedGui, Point point) {
        super(iAdvancedGui, point, Dimension.zeroDimension);
    }

    public McTabPane(IAdvancedGui iAdvancedGui, Point point, int n) {
        this(iAdvancedGui, point);
        this.tabBorder = n;
    }

    public void addTab(McTabButton mcTabButton, boolean bl) {
        this.tabs.add(mcTabButton);
        if (!this.scrollable) {
            this.addElement(mcTabButton);
        }
        if (bl) {
            this.autoPosition(mcTabButton);
        }
    }

    public void setScrollable(McTabPageButton mcTabPageButton, McTabPageButton mcTabPageButton2, int n, boolean bl, int n2) {
        this.scrollable = true;
        this.maxWidth = n;
        this.autoResize = bl;
        this.resizeBorder = n2;
        this.prevButton = mcTabPageButton;
        this.nextButton = mcTabPageButton2;
        this.nextPage();
    }

    private void autoPosition(McTabButton mcTabButton) {
        mcTabButton.setLocation(new Point(this.nextButtonX, 0));
        this.nextButtonX += mcTabButton.getSize().width + this.tabBorder;
    }

    public void nextPage() {
        if (this.autoResize) {
            this.resizeTabs();
        }
        int n = this.startTab + this.tabsAtPage;
        this.setupPage(n, this.getNumTabsAtPage(n, 1));
    }

    public void prevPage() {
        if (this.autoResize) {
            this.resizeTabs();
        }
        int n = this.startTab - 1;
        int n2 = this.getNumTabsAtPage(n, -1);
        this.setupPage(this.startTab - n2, n2);
    }

    private void resizeTabs() {
        for (McTabButton mcTabButton : this.tabs) {
            mcTabButton.textToWidth(this.resizeBorder);
        }
    }

    private void setupPage(int n, int n2) {
        this.startTab = n;
        this.getVisibleTabs().clear();
        this.tabsAtPage = n2;
        this.nextButtonX = 0;
        this.autoPosition(this.prevButton);
        this.getVisibleTabs().add(this.prevButton);
        this.prevButton.setEnabled(n != 0);
        if (this.autoResize) {
            int n3;
            int n4 = this.tabBorder * (n2 - 1);
            int n5 = this.maxWidth - this.prevButton.getSize().width - this.nextButton.getSize().width - this.tabBorder * 2;
            for (n3 = n; n3 < n + n2; ++n3) {
                n4 += this.tabs.get((int)n3).getSize().width;
            }
            n3 = n5 - n4;
            int n6 = n3 / n2;
            for (int i = n; i < n + n2; ++i) {
                McTabButton mcTabButton = this.tabs.get(i);
                mcTabButton.setWidth(mcTabButton.getSize().width + n6 + (i - n < n3 % n2 ? 1 : 0));
                this.autoPosition(mcTabButton);
                this.getVisibleTabs().add(mcTabButton);
            }
        } else {
            for (int i = n; i < n + n2; ++i) {
                McTabButton mcTabButton = this.tabs.get(i);
                this.autoPosition(mcTabButton);
                this.getVisibleTabs().add(mcTabButton);
            }
        }
        this.autoPosition(this.nextButton);
        this.getVisibleTabs().add(this.nextButton);
        this.nextButton.setEnabled(n + n2 < this.tabs.size());
    }

    private int getNumTabsAtPage(int n, int n2) {
        int n3 = this.prevButton.getSize().width + this.nextButton.getSize().width + this.tabBorder;
        int n4 = n;
        int n5 = 0;
        while (n3 <= this.maxWidth && n4 >= 0 && n4 < this.tabs.size()) {
            if ((n3 += this.tabs.get((int)(n4 += n2)).getSize().width + this.tabBorder) > this.maxWidth) continue;
            ++n5;
        }
        return n5;
    }

    public McTabButton getActiveTab() {
        return this.activeTab;
    }

    public int getActiveTabIndex() {
        for (int i = 0; i < this.tabs.size(); ++i) {
            if (this.tabs.get(i) != this.activeTab) continue;
            return i;
        }
        return -1;
    }

    public int getNumTabs() {
        return this.tabs.size();
    }

    public McTabButton getTab(int n) {
        return this.tabs.get(n);
    }

    public void setActiveTab(McTabButton mcTabButton) {
        if (mcTabButton != null && !this.tabs.contains(mcTabButton)) {
            throw new GuiException("Tab button is not added to pane!");
        }
        if (this.activeTab != null) {
            this.activeTab.setActive(false);
        }
        this.activeTab = mcTabButton;
        if (mcTabButton != null) {
            mcTabButton.setActive(true);
        }
    }

    protected List<McTabButton> getVisibleTabs() {
        return this.getElements();
    }
}

