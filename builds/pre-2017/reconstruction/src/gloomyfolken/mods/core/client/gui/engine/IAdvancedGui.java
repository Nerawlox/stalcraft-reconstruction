/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.ActionManager;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import net.minecraft.client.gui.GuiScreen;

public interface IAdvancedGui {
    public GuiScreen getGui();

    public GuiRenderer getRenderer();

    public GuiComponentsList getElementsList();

    public ActionManager getActionManager();
}

