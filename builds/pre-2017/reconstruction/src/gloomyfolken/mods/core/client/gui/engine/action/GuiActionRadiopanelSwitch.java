/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.action;

import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioElement;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;

public class GuiActionRadiopanelSwitch
extends GuiAction<McRadioGroup> {
    public final McRadioElement newActive;

    public GuiActionRadiopanelSwitch(McRadioGroup mcRadioGroup) {
        super(mcRadioGroup);
        this.newActive = mcRadioGroup.getActiveButton();
    }
}

