/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
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
extends GuiScreen {
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
        this.screenTitle = (Object)((Object)EnumChatFormatting._j) + string + (Object)((Object)EnumChatFormatting._p) + " Settings";
        this.modOptions = optionArray;
        this.modConfig = configuration;
        this.updateURL = string2;
        this.callback = iSettingsUpdatedCallback;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.optionPanel = new GuiScrollPanel(100, 0, 34, this.width, this.height - 84, 5);
        this.buttonList.add(this.optionPanel);
        if (this.updateURL == null) {
            this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height - 44, wpcz._a("gui.done")));
        } else {
            this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height - 44, 98, 20, wpcz._a("gui.done")));
            this.buttonList.add(new mrxl(201, this.width / 2 + 2, this.height - 44, 98, 20, (Object)((Object)EnumChatFormatting._g) + "Download Latest"));
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
    protected void actionPerformed(net.minecraft.client.gui.GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id == 200) {
                this.saveOptions = true;
                this.mc._a((GuiScreen)null);
            }
            if (guiButton.id == 201) {
                ((mrxl)guiButton)._a(this.updateURL);
            }
        }
    }

    @Override
    public void onGuiClosed() {
        if (this.saveOptions) {
            for (GuiButton guiButton : this.optionPanel.buttonList) {
                if (guiButton instanceof GuiSlider) {
                    this.modOptions[((GuiSlider)guiButton).id].setValue(((GuiSlider)guiButton).getValue());
                    continue;
                }
                if (!(guiButton instanceof GuiOptionButton)) continue;
                this.modOptions[((GuiOptionButton)guiButton).id].setValue(((GuiOptionButton)guiButton).getValue());
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
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
        GuiButton guiButton = null;
        for (int i = 0; i < this.buttonList.size(); ++i) {
            net.minecraft.client.gui.GuiButton guiButton2 = (net.minecraft.client.gui.GuiButton)this.buttonList.get(i);
            guiButton2.drawButton(this.mc, n, n2);
            if (!(guiButton2 instanceof GuiButton) || ((GuiButton)guiButton2).mouseOver() == null) continue;
            guiButton = ((GuiButton)guiButton2).mouseOver();
        }
        this.guiToolTip.setButton(this.mc, guiButton);
        this.guiToolTip.draw(this.mc, n, n2);
    }
}

