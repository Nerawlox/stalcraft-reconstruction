/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;

public interface IActionHandler<T extends GuiAction> {
    public void processAction(T var1);
}

