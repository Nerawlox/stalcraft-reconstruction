/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.function.Function;
import mods.pda.client.component.PdaTabButton;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;

public class PdaTabMeta {
    private final String id;
    private final String title;
    private final Function<IAdvancedGui, AbstractPdaTab> tab;
    private final int priority;

    public PdaTabMeta(String string, String string2, Function<IAdvancedGui, AbstractPdaTab> function, int n) {
        this.id = string;
        this.title = string2;
        this.tab = function;
        this.priority = n;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPriority() {
        return this.priority;
    }

    public AbstractPdaTab createPdaTab(IAdvancedGui iAdvancedGui) {
        return this.tab.apply(iAdvancedGui);
    }

    public PdaTabButton createTabButton(GuiPda guiPda, Point point, Dimension dimension) {
        return new PdaTabButton((IAdvancedGui)guiPda, point, dimension, iedw._l, this.getTitle());
    }
}

