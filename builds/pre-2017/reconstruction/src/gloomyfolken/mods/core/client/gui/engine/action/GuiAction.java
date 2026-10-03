/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.action;

import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;

public class GuiAction<T extends GuiComponent> {
    public final T component;

    protected GuiAction(T t) {
        this.component = t;
    }

    public final void process() {
        ((GuiComponent)this.component).getParent().getActionManager().processAction(this);
    }
}

