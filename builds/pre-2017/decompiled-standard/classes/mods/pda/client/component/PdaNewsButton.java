/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import mods.pda.PdaMod;
import mods.pda.client.component.PdaTabButton;

public class PdaNewsButton
extends PdaTabButton {
    public PdaNewsButton(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, ComponentButtonStyle componentButtonStyle, String string) {
        super(iAdvancedGui, point, dimension, componentButtonStyle, string);
    }

    @Override
    protected Point getIconUV() {
        if (PdaMod.getClientPda().newsFetcher.hasUnread) {
            return new Point(74, 821);
        }
        return super.getIconUV();
    }
}

