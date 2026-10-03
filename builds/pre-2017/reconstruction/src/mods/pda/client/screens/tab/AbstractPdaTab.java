/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.screens.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import java.awt.Color;
import java.util.Collections;
import mods.pda.client.component.PictureButton;
import mods.pda.client.screens.GuiPda;

public abstract class AbstractPdaTab
extends GuiComponent {
    protected Point pdaScreenStart = new Point(0, 0);
    protected Dimension pdaScreen = new Dimension(0, 0);
    protected GuiPda pda = null;
    public AbstractPdaTab parentTab;
    protected boolean allowParentJump = false;

    protected AbstractPdaTab(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    public void init(GuiPda guiPda) {
        this.pda = guiPda;
        if (this.parentTab != null && this.allowParentJump) {
            this.addPictureButton(this.pdaScreenStart.add(this.pdaScreen.width - 60, 10), new Point(278, 844), new Dimension(23, 15), "\u041d\u0430\u0437\u0430\u0434", false, guiActionButtonClick -> this.pda.openTab(this.parentTab)).setGlColorEnabled(-7105645);
        }
    }

    public void requestInformation() {
    }

    protected void drawScreenBackground(Point point, Dimension dimension, boolean bl) {
        iedw._a(this.renderer, point, dimension, bl, true);
    }

    protected PictureButton addPictureButton(Point point, Point point2, Dimension dimension, String string, boolean bl, IActionHandler<GuiActionButtonClick> iActionHandler) {
        PictureButton pictureButton = new PictureButton((IAdvancedGui)this.pda, iedw._a, point, point2, dimension);
        if (bl) {
            pictureButton.setGlColorDisabled(Color.cyan.getRGB());
            pictureButton.setGlColorEnabled(Color.green.getRGB());
        }
        this.pda.getActionManager().registerActionHandler(pictureButton, GuiActionButtonClick.class, iActionHandler);
        this.pda.addElement(pictureButton);
        if (string != null) {
            this.pda.addElement(new McToolTip((IAdvancedGui)this.pda, Collections.singletonList(string), pictureButton));
        }
        return pictureButton;
    }

    protected void decorateList(McScrollList mcScrollList) {
        Point point = mcScrollList.getLocation().add(-5, -28);
        Dimension dimension = mcScrollList.getSize().add(13, 35);
        McScrollBar mcScrollBar = this.createSlider(mcScrollList, point.add(dimension.width, 0), dimension.height);
        mcScrollList.setSlider(mcScrollBar);
        mcScrollList.setDrawLineSeparators(true);
    }

    protected McScrollBar createSlider(IScrollable iScrollable, Point point, int n) {
        McScrollBar mcScrollBar = new McScrollBar(this.parent, iScrollable, McScrollBar.ScrollBarType.VERTICAL, point.add(0, 14), n, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        this.pda.addElement(mcScrollBar);
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x, point.y), iedw._k.getTopArrowStyle()));
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x, point.y + n - 45), iedw._k.getBottomArrowStyle()));
        return mcScrollBar;
    }

    public void onScreenClose() {
    }

    public Point getPdaScreenStart() {
        return this.pdaScreenStart;
    }

    public void setPdaScreenStart(Point point) {
        this.pdaScreenStart = point;
    }

    public Dimension getPdaScreen() {
        return this.pdaScreen;
    }

    public void setPdaScreen(Dimension dimension) {
        this.pdaScreen = dimension;
    }

    public void refresh() {
        this.pda.openTab(this);
    }
}

