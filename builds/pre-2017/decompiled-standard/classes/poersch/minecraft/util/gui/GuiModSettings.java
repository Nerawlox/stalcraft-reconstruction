/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ezfc;
import net.minecraftforge.common.Configuration;
import poersch.minecraft.util.gui.GuiButton;
import poersch.minecraft.util.gui.GuiHorizontalBar;
import poersch.minecraft.util.gui.GuiOptionButton;
import poersch.minecraft.util.gui.GuiScrollPanel;
import poersch.minecraft.util.gui.GuiSlider;
import poersch.minecraft.util.gui.GuiToolTip;
import poersch.minecraft.util.gui.ISettingsUpdatedCallback;
import poersch.minecraft.util.options.Option;
import poersch.minecraft.util.options.OptionInterval;

@SideOnly(value=Side.CLIENT)
public class GuiModSettings
extends gqjz {
    private final String screenTitle;
    private final Option[] modOptions;
    private final Configuration modConfig;
    private final ISettingsUpdatedCallback callback;
    private GuiScrollPanel optionPanel;
    private GuiToolTip guiToolTip;
    private boolean saveOptions = false;
    private String updateURL;

    public GuiModSettings(String string, String string2, Option[] optionArray, Configuration configuration) {
        this(string, string2, optionArray, configuration, null);
    }

    public GuiModSettings(String string, String string2, Option[] optionArray, Configuration configuration, ISettingsUpdatedCallback iSettingsUpdatedCallback) {
        this.screenTitle = (Object)((Object)ezfc._j) + string + (Object)((Object)ezfc._p) + " Settings";
        this.modOptions = optionArray;
        this.modConfig = configuration;
        this.updateURL = string2;
        this.callback = iSettingsUpdatedCallback;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.optionPanel = new GuiScrollPanel(100, 0, 34, this.field_73880_f, this.field_73881_g - 84, 5);
        this.field_73887_h.add(this.optionPanel);
        if (this.updateURL == null) {
            this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g - 44, wpcz._a("gui.done")));
        } else {
            this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g - 44, 98, 20, wpcz._a("gui.done")));
            this.field_73887_h.add(new mrxl(201, this.field_73880_f / 2 + 2, this.field_73881_g - 44, 98, 20, (Object)((Object)ezfc._g) + "Download Latest"));
        }
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < this.modOptions.length; ++i) {
            if (this.modOptions[i] == null) {
                this.optionPanel.buttonList.add(new GuiHorizontalBar(i, this.optionPanel.getWidth() / 2 - 175, n2 += (n + 1 >> 1) * 24, 350, 4));
                n2 += 8;
                n = 0;
                continue;
            }
            if (this.modOptions[i] instanceof OptionInterval) {
                this.optionPanel.buttonList.add(new GuiSlider(i, this.optionPanel.getWidth() / 2 - 155 + (n & 1) * 160, n2 + (n >> 1) * 24, this.modOptions[i].name, ((Float)this.modOptions[i].value).floatValue(), ((OptionInterval)this.modOptions[i]).minValue, ((OptionInterval)this.modOptions[i]).maxValue, Float.valueOf(((OptionInterval)this.modOptions[i]).defaultValue)).setToolTip(this.modOptions[i].description));
            } else {
                this.optionPanel.buttonList.add(new GuiOptionButton(i, this.optionPanel.getWidth() / 2 - 155 + (n & 1) * 160, n2 + (n >> 1) * 24, this.modOptions[i].name, this.modOptions[i].getPossibleValues(), this.modOptions[i].getValue()).setToolTip(this.modOptions[i].description));
            }
            ++n;
        }
        this.optionPanel.updateSliderSize();
        this.guiToolTip = new GuiToolTip();
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73742_g) {
            if (jiok2.field_73741_f == 200) {
                this.saveOptions = true;
                this.field_73882_e._a((gqjz)null);
            }
            if (jiok2.field_73741_f == 201) {
                ((mrxl)jiok2)._a(this.updateURL);
            }
        }
    }

    @Override
    public void func_73874_b() {
        if (this.saveOptions) {
            for (GuiButton guiButton : this.optionPanel.buttonList) {
                if (guiButton instanceof GuiSlider) {
                    this.modOptions[((GuiSlider)guiButton).field_73741_f].setValue(((GuiSlider)guiButton).getValue());
                    continue;
                }
                if (!(guiButton instanceof GuiOptionButton)) continue;
                this.modOptions[((GuiOptionButton)guiButton).field_73741_f].setValue(((GuiOptionButton)guiButton).getValue());
            }
            for (int i = 0; i < this.modOptions.length; ++i) {
                if (this.modOptions[i] == null) continue;
                this.modOptions[i].write();
            }
            this.modConfig.save();
            if (this.callback != null) {
                this.callback.onSettingsUpdated();
            }
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.screenTitle, this.field_73880_f / 2, 20, 0xFFFFFF);
        GuiButton guiButton = null;
        for (int i = 0; i < this.field_73887_h.size(); ++i) {
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            jiok2.func_73737_a(this.field_73882_e, n, n2);
            if (!(jiok2 instanceof GuiButton) || ((GuiButton)jiok2).mouseOver() == null) continue;
            guiButton = ((GuiButton)jiok2).mouseOver();
        }
        this.guiToolTip.setButton(this.field_73882_e, guiButton);
        this.guiToolTip.draw(this.field_73882_e, n, n2);
    }
}

