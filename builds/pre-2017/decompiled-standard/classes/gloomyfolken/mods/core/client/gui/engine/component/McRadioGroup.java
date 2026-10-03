/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.GuiException;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionRadiopanelSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioElement;

public class McRadioGroup
extends GuiComponentsList<GuiComponent> {
    protected McRadioElement activeButton;

    public McRadioGroup(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    public McRadioElement getActiveButton() {
        return this.activeButton;
    }

    public int getActiveElementIndex() {
        for (int i = 0; i < this.getElements().size(); ++i) {
            if (this.getElements().get(i) != this.activeButton) continue;
            return i;
        }
        return -1;
    }

    public McRadioElement getRadioElement(int n) {
        return (McRadioElement)this.getElements().get(n);
    }

    public void setActiveButton(int n) {
        this.setActiveButton((McRadioElement)this.getElements().get(n));
    }

    public void setActiveButton(McRadioElement mcRadioElement) {
        if (mcRadioElement != null && !this.getElements().contains(mcRadioElement)) {
            throw new GuiException("Radiobutton is not added to group!");
        }
        if (this.activeButton != null) {
            this.activeButton.setSelected(false);
        }
        this.activeButton = mcRadioElement;
        if (mcRadioElement != null) {
            mcRadioElement.setSelected(true);
        }
        new GuiActionRadiopanelSwitch(this).process();
    }
}

