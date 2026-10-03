/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiGloomyGeneratedOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiOptionsSlider;
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiModVideoOptions
extends GuiGloomyGeneratedOptions {
    public static List<anpn> options = new ArrayList<anpn>();

    public GuiModVideoOptions(GuiScreen guiScreen) {
        super(guiScreen);
        this.screenTitle = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0433\u0440\u0430\u0444\u0438\u043a\u0438";
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        anpn anpn2 = this.buttonsMap.get(guiButton);
        if (anpn2 == ClientProxy.graphicsPreset) {
            anpn2.onChanged(true);
            this.updateButtonNames();
        }
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        GuiOptionsSlider guiOptionsSlider = (GuiOptionsSlider)this.buttonList.get(this.options().indexOf(ClientProxy.graphicsPreset));
        if (guiOptionsSlider.dragging) {
            ClientProxy.graphicsPreset.onChanged(true);
            this.updateButtonNames();
            this.options().forEach(anpn2 -> {
                if (anpn2 != ClientProxy.graphicsPreset && anpn2 instanceof hbdd) {
                    GuiOptionsSlider guiOptionsSlider = (GuiOptionsSlider)this.buttonList.get(this.options().indexOf(anpn2));
                    guiOptionsSlider.sliderValue = ((hbdd)anpn2).getSliderValue();
                }
            });
        }
    }

    @Override
    public List<anpn> options() {
        return options;
    }
}

