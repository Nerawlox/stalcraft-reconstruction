/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiGloomyGeneratedOptions;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;

public class GuiModPerformanceOptions
extends GuiGloomyGeneratedOptions {
    public static List<anpn> options = new ArrayList<anpn>();

    public GuiModPerformanceOptions(GuiScreen guiScreen) {
        super(guiScreen);
        this.screenTitle = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u0438";
    }

    @Override
    public List<anpn> options() {
        return options;
    }
}

