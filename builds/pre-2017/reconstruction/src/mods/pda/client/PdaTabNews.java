/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.function.Function;
import mods.pda.client.PdaTabMeta;
import mods.pda.client.component.PdaNewsButton;
import mods.pda.client.component.PdaTabButton;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;

public class PdaTabNews
extends PdaTabMeta {
    public PdaTabNews(String string, String string2, Function<IAdvancedGui, AbstractPdaTab> function, int n) {
        super(string, string2, function, n);
    }

    @Override
    public PdaTabButton createTabButton(GuiPda guiPda, Point point, Dimension dimension) {
        return new PdaNewsButton((IAdvancedGui)guiPda, point, dimension, iedw._l, this.getTitle());
    }
}

