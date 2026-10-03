/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.ActionManager;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;

public interface IAdvancedGui {
    public gqjz getGui();

    public GuiRenderer getRenderer();

    public GuiComponentsList getElementsList();

    public ActionManager getActionManager();
}

