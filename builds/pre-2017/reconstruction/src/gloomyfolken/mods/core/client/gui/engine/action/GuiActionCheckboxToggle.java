/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.action;

import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;

public class GuiActionCheckboxToggle
extends GuiAction<McCheckBox> {
    public final boolean newState;

    public GuiActionCheckboxToggle(McCheckBox mcCheckBox) {
        super(mcCheckBox);
        this.newState = mcCheckBox.getActive();
    }
}

