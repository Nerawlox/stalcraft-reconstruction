/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiGloomyGeneratedOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiOptionsSlider;
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.ArrayList;
import java.util.List;

public class GuiModVideoOptions
extends GuiGloomyGeneratedOptions {
    public static List<anpn> options = new ArrayList<anpn>();

    public GuiModVideoOptions(gqjz gqjz2) {
        super(gqjz2);
        this.screenTitle = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0433\u0440\u0430\u0444\u0438\u043a\u0438";
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        anpn anpn2 = this.buttonsMap.get(jiok2);
        if (anpn2 == ClientProxy.graphicsPreset) {
            anpn2.onChanged(true);
            this.updateButtonNames();
        }
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        GuiOptionsSlider guiOptionsSlider = (GuiOptionsSlider)this.field_73887_h.get(this.options().indexOf(ClientProxy.graphicsPreset));
        if (guiOptionsSlider.dragging) {
            ClientProxy.graphicsPreset.onChanged(true);
            this.updateButtonNames();
            this.options().forEach(anpn2 -> {
                if (anpn2 != ClientProxy.graphicsPreset && anpn2 instanceof hbdd) {
                    GuiOptionsSlider guiOptionsSlider = (GuiOptionsSlider)this.field_73887_h.get(this.options().indexOf(anpn2));
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

