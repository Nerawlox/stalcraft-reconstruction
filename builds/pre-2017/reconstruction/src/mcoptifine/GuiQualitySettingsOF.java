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

public class GuiQualitySettingsOF
extends GuiScreen {
    private GuiScreen prevScreen;
    protected String title = "Quality Settings";
    private GameSettings settings;
    private static EnumOptions[] enumOptions = new EnumOptions[]{EnumOptions._I, EnumOptions._J, EnumOptions.__aI, EnumOptions.__aH, EnumOptions.__am, EnumOptions.__aB, EnumOptions.__aa, EnumOptions.__aw, EnumOptions.__aD, EnumOptions.__aE, EnumOptions.__aA, EnumOptions.__aC, EnumOptions.__aG, EnumOptions.__aL, EnumOptions.__aR};
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public GuiQualitySettingsOF(GuiScreen guiScreen, GameSettings gameSettings) {
        this.prevScreen = guiScreen;
        this.settings = gameSettings;
    }

    @Override
    public void initGui() {
        gomc gomc2 = gomc._a();
        int n = 0;
        for (EnumOptions enumOptions : GuiQualitySettingsOF.enumOptions) {
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
                        int n8 = 0xDDDDDD;
                        if (string2.endsWith("!")) {
                            n8 = 0xFF2020;
                        }
                        this.fontRenderer._a(string2, n4 + 5, n5 + 5 + i * 11, n8);
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
        if (string.equals("Mipmap Level")) {
            String[] stringArray2 = new String[6];
            stringArray2[0] = "Visual effect which makes distant objects look better";
            stringArray2[1] = "by smoothing the texture details";
            stringArray2[2] = "  OFF - no smoothing";
            stringArray2[3] = "  1 - minimum smoothing";
            stringArray2[4] = "  4 - maximum smoothing";
            stringArray = stringArray2;
            stringArray2[5] = "This option usually does not affect the performance.";
        } else if (string.equals("Mipmap Type")) {
            String[] stringArray3 = new String[5];
            stringArray3[0] = "Visual effect which makes distant objects look better";
            stringArray3[1] = "by smoothing the texture details";
            stringArray3[2] = "  Nearest - rough smoothing";
            stringArray3[3] = "  Linear - fine smoothing";
            stringArray = stringArray3;
            stringArray3[4] = "This option usually does not affect the performance.";
        } else if (string.equals("Anisotropic Filtering")) {
            String[] stringArray4 = new String[5];
            stringArray4[0] = "Anisotropic Filtering";
            stringArray4[1] = " OFF - (default) standard texture detail (faster)";
            stringArray4[2] = " 2-16 - finer details in mipmapped textures (slower)";
            stringArray4[3] = "The Anisotropic Filtering restores details in mipmapped";
            stringArray = stringArray4;
            stringArray4[4] = "textures. Higher values may decrease the FPS.";
        } else if (string.equals("Antialiasing")) {
            String[] stringArray5 = new String[8];
            stringArray5[0] = "Antialiasing";
            stringArray5[1] = " OFF - (default) no antialiasing (faster)";
            stringArray5[2] = " 2-16 - antialiased lines and edges (slower)";
            stringArray5[3] = "The Antialiasing smooths jagged lines and ";
            stringArray5[4] = "sharp color transitions.";
            stringArray5[5] = "Higher values may substantially decrease the FPS.";
            stringArray5[6] = "Not all levels are supported by all graphics cards.";
            stringArray = stringArray5;
            stringArray5[7] = "Effective after a RESTART!";
        } else if (string.equals("Clear Water")) {
            String[] stringArray6 = new String[3];
            stringArray6[0] = "Clear Water";
            stringArray6[1] = "  ON - clear, transparent water";
            stringArray = stringArray6;
            stringArray6[2] = "  OFF - default water";
        } else if (string.equals("Better Grass")) {
            String[] stringArray7 = new String[4];
            stringArray7[0] = "Better Grass";
            stringArray7[1] = "  OFF - default side grass texture, fastest";
            stringArray7[2] = "  Fast - full side grass texture, slower";
            stringArray = stringArray7;
            stringArray7[3] = "  Fancy - dynamic side grass texture, slowest";
        } else if (string.equals("Better Snow")) {
            String[] stringArray8 = new String[5];
            stringArray8[0] = "Better Snow";
            stringArray8[1] = "  OFF - default snow, faster";
            stringArray8[2] = "  ON - better snow, slower";
            stringArray8[3] = "Shows snow under transparent blocks (fence, tall grass)";
            stringArray = stringArray8;
            stringArray8[4] = "when bordering with snow blocks";
        } else if (string.equals("Random Mobs")) {
            String[] stringArray9 = new String[5];
            stringArray9[0] = "Random Mobs";
            stringArray9[1] = "  OFF - no random mobs, faster";
            stringArray9[2] = "  ON - random mobs, slower";
            stringArray9[3] = "Random mobs uses random textures for the game creatures.";
            stringArray = stringArray9;
            stringArray9[4] = "It needs a texture pack which has multiple mob textures.";
        } else if (string.equals("Swamp Colors")) {
            String[] stringArray10 = new String[4];
            stringArray10[0] = "Swamp Colors";
            stringArray10[1] = "  ON - use swamp colors (default), slower";
            stringArray10[2] = "  OFF - do not use swamp colors, faster";
            stringArray = stringArray10;
            stringArray10[3] = "The swamp colors affect grass, leaves, vines and water.";
        } else if (string.equals("Smooth Biomes")) {
            String[] stringArray11 = new String[6];
            stringArray11[0] = "Smooth Biomes";
            stringArray11[1] = "  ON - smoothing of biome borders (default), slower";
            stringArray11[2] = "  OFF - no smoothing of biome borders, faster";
            stringArray11[3] = "The smoothing of biome borders is done by sampling and";
            stringArray11[4] = "averaging the color of all surrounding blocks.";
            stringArray = stringArray11;
            stringArray11[5] = "Affected are grass, leaves, vines and water.";
        } else if (string.equals("Custom Fonts")) {
            String[] stringArray12 = new String[5];
            stringArray12[0] = "Custom Fonts";
            stringArray12[1] = "  ON - uses custom fonts (default), slower";
            stringArray12[2] = "  OFF - uses default font, faster";
            stringArray12[3] = "The custom fonts are supplied by the current";
            stringArray = stringArray12;
            stringArray12[4] = "texture pack";
        } else if (string.equals("Custom Colors")) {
            String[] stringArray13 = new String[5];
            stringArray13[0] = "Custom Colors";
            stringArray13[1] = "  ON - uses custom colors (default), slower";
            stringArray13[2] = "  OFF - uses default colors, faster";
            stringArray13[3] = "The custom colors are supplied by the current";
            stringArray = stringArray13;
            stringArray13[4] = "texture pack";
        } else if (string.equals("Show Capes")) {
            String[] stringArray14 = new String[3];
            stringArray14[0] = "Show Capes";
            stringArray14[1] = "  ON - show player capes (default)";
            stringArray = stringArray14;
            stringArray14[2] = "  OFF - do not show player capes";
        } else if (string.equals("Connected Textures")) {
            String[] stringArray15 = new String[8];
            stringArray15[0] = "Connected Textures";
            stringArray15[1] = "  OFF - no connected textures (default)";
            stringArray15[2] = "  Fast - fast connected textures";
            stringArray15[3] = "  Fancy - fancy connected textures";
            stringArray15[4] = "Connected textures joins the textures of glass,";
            stringArray15[5] = "sandstone and bookshelves when placed next to";
            stringArray15[6] = "each other. The connected textures are supplied";
            stringArray = stringArray15;
            stringArray15[7] = "by the current texture pack.";
        } else if (string.equals("Far View")) {
            String[] stringArray16 = new String[7];
            stringArray16[0] = "Far View";
            stringArray16[1] = " OFF - (default) standard view distance";
            stringArray16[2] = " ON - 3x view distance";
            stringArray16[3] = "Far View is very resource demanding!";
            stringArray16[4] = "3x view distance => 9x chunks to be loaded => FPS / 9";
            stringArray16[5] = "Standard view distances: 32, 64, 128, 256";
            stringArray = stringArray16;
            stringArray16[6] = "Far view distances: 96, 192, 384, 512";
        } else if (string.equals("Natural Textures")) {
            String[] stringArray17 = new String[8];
            stringArray17[0] = "Natural Textures";
            stringArray17[1] = "  OFF - no natural textures (default)";
            stringArray17[2] = "  ON - use natural textures";
            stringArray17[3] = "Natural textures remove the gridlike pattern";
            stringArray17[4] = "created by repeating blocks of the same type.";
            stringArray17[5] = "It uses rotated and flipped variants of the base";
            stringArray17[6] = "block texture. The configuration for the natural";
            stringArray = stringArray17;
            stringArray17[7] = "textures is supplied by the current texture pack";
        } else if (string.equals("Custom Sky")) {
            String[] stringArray18 = new String[5];
            stringArray18[0] = "Custom Sky";
            stringArray18[1] = "  ON - custom sky textures (default), slow";
            stringArray18[2] = "  OFF - default sky, faster";
            stringArray18[3] = "The custom sky textures are supplied by the current";
            stringArray = stringArray18;
            stringArray18[4] = "texture pack";
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

