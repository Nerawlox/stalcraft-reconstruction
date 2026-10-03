/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.action;

import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;

public class GuiActionListSwitch
extends GuiAction<McScrollList> {
    public final int prevSelectedLine;
    public final int selectedLine;

    public GuiActionListSwitch(McScrollList mcScrollList, int n) {
        super(mcScrollList);
        this.prevSelectedLine = n;
        this.selectedLine = mcScrollList.getSelectedLineId();
    }
}

