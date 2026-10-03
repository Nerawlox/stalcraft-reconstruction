/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.action;

import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.component.McTabButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPane;

public class GuiActionTabSwitch
extends GuiAction<McTabPane> {
    public final McTabButton newActive;

    public GuiActionTabSwitch(McTabPane mcTabPane) {
        super(mcTabPane);
        this.newActive = mcTabPane.getActiveTab();
    }
}

