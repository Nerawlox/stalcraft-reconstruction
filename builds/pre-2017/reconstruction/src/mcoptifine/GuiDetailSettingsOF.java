/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.gomc;

public class GuiDetailSettingsOF
extends GuiScreen {
    private GuiScreen prevScreen;
    protected String title = "Detail Settings";
    private GameSettings settings;
    private static EnumOptions[] enumOptions = new EnumOptions[]{EnumOptions._N, EnumOptions._O, EnumOptions._P, EnumOptions._Q, EnumOptions._S, EnumOptions._R, EnumOptions.__ag, EnumOptions.__ah, EnumOptions.__ai, EnumOptions.__aF, EnumOptions.__ao, EnumOptions.__aO, EnumOptions.__aP};
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public GuiDetailSettingsOF(GuiScreen guiScreen, GameSettings gameSettings) {
        this.prevScreen = guiScreen;
        this.settings = gameSettings;
    }

    @Override
    public void initGui() {
        gomc gomc2 = gomc._a();
        int n = 0;
        for (EnumOptions enumOptions : GuiDetailSettingsOF.enumOptions) {
            int n2 = this.width / 2 - 155 + n % 2 * 160;
            int n3 = this.height / 6 + 21 * (n / 2) - 10;
            if (!enumOptions._a()) {
                this.buttonList.add(new baxz(enumOptions._c(), n2, n3, enumOptions, this.settings.getKeyBinding(enumOptions)));
            } else {
                this.buttonList.add(new GuiSlider(enumOptions._c(), n2, n3, enumOptions, this.settings.getKeyBinding(enumOptions), this.settings.getOptionFloatValue(enumOptions)));
            }
            ++n;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, gomc2._a("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id < 100 && guiButton instanceof baxz) {
                this.settings.setOptionValue(((baxz)guiButton).returnEnumOptions(), 1);
                guiButton.displayString = this.settings.getKeyBinding(EnumOptions._a(guiButton.id));
            }
            if (guiButton.id == 200) {
                this.mc._M.saveOptions();
                this.mc._a(this.prevScreen);
            }
            if (guiButton.id != EnumOptions._O.ordinal()) {
                htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
                int n = htou2._a();
                int n2 = htou2._b();
                this.setWorldAndResolution(this.mc, n, n2);
            }
        }
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
        if (string.equals("Clouds")) {
            String[] stringArray2 = new String[7];
            stringArray2[0] = "Clouds";
            stringArray2[1] = "  Default - as set by setting Graphics";
            stringArray2[2] = "  Fast - lower quality, faster";
            stringArray2[3] = "  Fancy - higher quality, slower";
            stringArray2[4] = "  OFF - no clouds, fastest";
            stringArray2[5] = "Fast clouds are rendered 2D.";
            stringArray = stringArray2;
            stringArray2[6] = "Fancy clouds are rendered 3D.";
        } else if (string.equals("Cloud Height")) {
            String[] stringArray3 = new String[3];
            stringArray3[0] = "Cloud Height";
            stringArray3[1] = "  OFF - default height";
            stringArray = stringArray3;
            stringArray3[2] = "  100% - above world height limit";
        } else if (string.equals("Trees")) {
            String[] stringArray4 = new String[6];
            stringArray4[0] = "Trees";
            stringArray4[1] = "  Default - as set by setting Graphics";
            stringArray4[2] = "  Fast - lower quality, faster";
            stringArray4[3] = "  Fancy - higher quality, slower";
            stringArray4[4] = "Fast trees have opaque leaves.";
            stringArray = stringArray4;
            stringArray4[5] = "Fancy trees have transparent leaves.";
        } else if (string.equals("Grass")) {
            String[] stringArray5 = new String[6];
            stringArray5[0] = "Grass";
            stringArray5[1] = "  Default - as set by setting Graphics";
            stringArray5[2] = "  Fast - lower quality, faster";
            stringArray5[3] = "  Fancy - higher quality, slower";
            stringArray5[4] = "Fast grass uses default side texture.";
            stringArray = stringArray5;
            stringArray5[5] = "Fancy grass uses biome side texture.";
        } else if (string.equals("Dropped Items")) {
            String[] stringArray6 = new String[4];
            stringArray6[0] = "Dropped Items";
            stringArray6[1] = "  Default - as set by setting Graphics";
            stringArray6[2] = "  Fast - 2D dropped items, faster";
            stringArray = stringArray6;
            stringArray6[3] = "  Fancy - 3D dropped items, slower";
        } else if (string.equals("Water")) {
            String[] stringArray7 = new String[6];
            stringArray7[0] = "Water";
            stringArray7[1] = "  Default - as set by setting Graphics";
            stringArray7[2] = "  Fast  - lower quality, faster";
            stringArray7[3] = "  Fancy - higher quality, slower";
            stringArray7[4] = "Fast water (1 pass) has some visual artifacts";
            stringArray = stringArray7;
            stringArray7[5] = "Fancy water (2 pass) has no visual artifacts";
        } else if (string.equals("Rain & Snow")) {
            String[] stringArray8 = new String[7];
            stringArray8[0] = "Rain & Snow";
            stringArray8[1] = "  Default - as set by setting Graphics";
            stringArray8[2] = "  Fast  - light rain/snow, faster";
            stringArray8[3] = "  Fancy - heavy rain/snow, slower";
            stringArray8[4] = "  OFF - no rain/snow, fastest";
            stringArray8[5] = "When rain is OFF the splashes and rain sounds";
            stringArray = stringArray8;
            stringArray8[6] = "are still active.";
        } else if (string.equals("Sky")) {
            String[] stringArray9 = new String[4];
            stringArray9[0] = "Sky";
            stringArray9[1] = "  ON - sky is visible, slower";
            stringArray9[2] = "  OFF  - sky is not visible, faster";
            stringArray = stringArray9;
            stringArray9[3] = "When sky is OFF the moon and sun are still visible.";
        } else if (string.equals("Stars")) {
            String[] stringArray10 = new String[3];
            stringArray10[0] = "Stars";
            stringArray10[1] = "  ON - stars are visible, slower";
            stringArray = stringArray10;
            stringArray10[2] = "  OFF  - stars are not visible, faster";
        } else if (string.equals("Depth Fog")) {
            String[] stringArray11 = new String[3];
            stringArray11[0] = "Depth Fog";
            stringArray11[1] = "  ON - fog moves closer at bedrock levels (default)";
            stringArray = stringArray11;
            stringArray11[2] = "  OFF - same fog at all levels";
        } else if (string.equals("Show Capes")) {
            String[] stringArray12 = new String[3];
            stringArray12[0] = "Show Capes";
            stringArray12[1] = "  ON - show player capes (default)";
            stringArray = stringArray12;
            stringArray12[2] = "  OFF - do not show player capes";
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

