/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.gomc;

public class GuiOtherSettingsOF
extends GuiScreen {
    private GuiScreen prevScreen;
    protected String title = "Other Settings";
    private GameSettings settings;
    private static EnumOptions[] enumOptions = new EnumOptions[]{EnumOptions._Y, EnumOptions.__au, EnumOptions.__af, EnumOptions.__al, EnumOptions._y, EnumOptions.__ax, EnumOptions._i, EnumOptions._Z};
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public GuiOtherSettingsOF(GuiScreen guiScreen, GameSettings gameSettings) {
        this.prevScreen = guiScreen;
        this.settings = gameSettings;
    }

    @Override
    public void initGui() {
        gomc gomc2 = gomc._a();
        int n = 0;
        for (EnumOptions enumOptions : GuiOtherSettingsOF.enumOptions) {
            int n2 = this.width / 2 - 155 + n % 2 * 160;
            int n3 = this.height / 6 + 21 * (n / 2) - 10;
            if (!enumOptions._a()) {
                this.buttonList.add(new baxz(enumOptions._c(), n2, n3, enumOptions, this.settings.getKeyBinding(enumOptions)));
            } else {
                this.buttonList.add(new GuiSlider(enumOptions._c(), n2, n3, enumOptions, this.settings.getKeyBinding(enumOptions), this.settings.getOptionFloatValue(enumOptions)));
            }
            ++n;
        }
        this.buttonList.add(new GuiButton(210, this.width / 2 - 100, this.height / 6 + 168 + 11 - 22, "Reset Video Settings..."));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, gomc2._a("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            Object object;
            if (guiButton.id < 100 && guiButton instanceof baxz) {
                this.settings.setOptionValue(((baxz)guiButton).returnEnumOptions(), 1);
                guiButton.displayString = this.settings.getKeyBinding(EnumOptions._a(guiButton.id));
            }
            if (guiButton.id == 200) {
                this.mc._M.saveOptions();
                this.mc._a(this.prevScreen);
            }
            if (guiButton.id == 210) {
                this.mc._M.saveOptions();
                object = new GuiYesNo(this, "Reset all video settings to their default values?", "", 9999);
                this.mc._a((GuiScreen)object);
            }
            if (guiButton.id != EnumOptions._O.ordinal()) {
                object = new htou(this.mc._M, this.mc._n, this.mc._o);
                int n = ((htou)object)._a();
                int n2 = ((htou)object)._b();
                this.setWorldAndResolution(this.mc, n, n2);
            }
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl) {
            this.mc._M.resetSettings();
        }
        this.mc._a(this);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
        if (Math.abs(n - this.lastMouseX) <= 5 && Math.abs(n2 - this.lastMouseY) <= 5) {
            int n3 = 700;
            if (System.currentTimeMillis() >= this.mouseStillTime + (long)n3) {
                int n4 = this.width / 2 - 150;
                int n5 = this.height / 6 - 5;
                if (n2 <= n5 + 98) {
                    n5 += 105;
                }
                int n6 = n4 + 150 + 150;
                int n7 = n5 + 84 + 10;
                GuiButton guiButton = this.getSelectedButton(n, n2);
                if (guiButton != null) {
                    String string = this.getButtonName(guiButton.displayString);
                    String[] stringArray = this.getTooltipLines(string);
                    if (stringArray == null) {
                        return;
                    }
                    this.drawGradientRect(n4, n5, n6, n7, -536870912, -536870912);
                    for (int i = 0; i < stringArray.length; ++i) {
                        String string2 = stringArray[i];
                        this.fontRenderer._a(string2, n4 + 5, n5 + 5 + i * 11, 0xDDDDDD);
                    }
                }
            }
        } else {
            this.lastMouseX = n;
            this.lastMouseY = n2;
            this.mouseStillTime = System.currentTimeMillis();
        }
    }

    private String[] getTooltipLines(String string) {
        String[] stringArray;
        if (string.equals("Autosave")) {
            String[] stringArray2 = new String[3];
            stringArray2[0] = "Autosave interval";
            stringArray2[1] = "Default autosave interval (2s) is NOT RECOMMENDED.";
            stringArray = stringArray2;
            stringArray2[2] = "Autosave causes the famous Lag Spike of Death.";
        } else if (string.equals("Lagometer")) {
            String[] stringArray3 = new String[7];
            stringArray3[0] = "Lagometer";
            stringArray3[1] = " OFF - no lagometer, faster";
            stringArray3[2] = " ON - debug screen with lagometer, slower";
            stringArray3[3] = "Shows the lagometer on the debug screen (F3).";
            stringArray3[4] = "* White - tick";
            stringArray3[5] = "* Red - chunk loading";
            stringArray = stringArray3;
            stringArray3[6] = "* Green - frame rendering + internal server";
        } else if (string.equals("Debug Profiler")) {
            String[] stringArray4 = new String[5];
            stringArray4[0] = "Debug Profiler";
            stringArray4[1] = "  ON - debug profiler is active, slower";
            stringArray4[2] = "  OFF - debug profiler is not active, faster";
            stringArray4[3] = "The debug profiler collects and shows debug information";
            stringArray = stringArray4;
            stringArray4[4] = "when the debug screen is open (F3)";
        } else if (string.equals("Time")) {
            String[] stringArray5 = new String[5];
            stringArray5[0] = "Time";
            stringArray5[1] = " Default - normal day/night cycles";
            stringArray5[2] = " Day Only - day only";
            stringArray5[3] = " Night Only - night only";
            stringArray = stringArray5;
            stringArray5[4] = "The time setting is only effective in CREATIVE mode.";
        } else if (string.equals("Weather")) {
            String[] stringArray6 = new String[4];
            stringArray6[0] = "Weather";
            stringArray6[1] = "  ON - weather is active, slower";
            stringArray6[2] = "  OFF - weather is not active, faster";
            stringArray = stringArray6;
            stringArray6[3] = "The weather controls rain, snow and thunderstorms.";
        } else if (string.equals("Fullscreen")) {
            String[] stringArray7 = new String[4];
            stringArray7[0] = "Fullscreen resolution";
            stringArray7[1] = "  Default - use desktop screen resolution, slower";
            stringArray7[2] = "  WxH - use custom screen resolution, may be faster";
            stringArray = stringArray7;
            stringArray7[3] = "The selected resolution is used in fullscreen mode (F11).";
        } else {
            stringArray = null;
        }
        return stringArray;
    }

    private String getButtonName(String string) {
        int n = string.indexOf(58);
        return n < 0 ? string : string.substring(0, n);
    }

    private GuiButton getSelectedButton(int n, int n2) {
        for (int i = 0; i < this.buttonList.size(); ++i) {
            boolean bl;
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            boolean bl2 = bl = n >= guiButton.xPosition && n2 >= guiButton.yPosition && n < guiButton.xPosition + guiButton.width && n2 < guiButton.yPosition + guiButton.height;
            if (!bl) continue;
            return guiButton;
        }
        return null;
    }
}

