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

public class GuiPerformanceSettingsOF
extends GuiScreen {
    private GuiScreen prevScreen;
    protected String title = "Performance Settings";
    private GameSettings settings;
    private static EnumOptions[] enumOptions = new EnumOptions[]{EnumOptions._M, EnumOptions.__an, EnumOptions._K, EnumOptions._L, EnumOptions.__aj, EnumOptions.__ak, EnumOptions.__aS, EnumOptions.__aQ};
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public GuiPerformanceSettingsOF(GuiScreen guiScreen, GameSettings gameSettings) {
        this.prevScreen = guiScreen;
        this.settings = gameSettings;
    }

    @Override
    public void initGui() {
        gomc gomc2 = gomc._a();
        int n = 0;
        for (EnumOptions enumOptions : GuiPerformanceSettingsOF.enumOptions) {
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
        if (string.equals("Smooth FPS")) {
            String[] stringArray2 = new String[5];
            stringArray2[0] = "Stabilizes FPS by flushing the graphic driver buffers";
            stringArray2[1] = "  OFF - no stabilization, FPS may fluctuate";
            stringArray2[2] = "  ON - FPS stabilization";
            stringArray2[3] = "This option is graphic driver dependant and its effect";
            stringArray = stringArray2;
            stringArray2[4] = "is not always visible";
        } else if (string.equals("Smooth World")) {
            String[] stringArray3 = new String[5];
            stringArray3[0] = "Removes lag spikes caused by the internal server.";
            stringArray3[1] = "  OFF - no stabilization, FPS may fluctuate";
            stringArray3[2] = "  ON - FPS stabilization";
            stringArray3[3] = "Stabilizes FPS by distributing the internal server load.";
            stringArray = stringArray3;
            stringArray3[4] = "Effective only for local worlds and single-core CPU.";
        } else if (string.equals("Load Far")) {
            String[] stringArray4 = new String[6];
            stringArray4[0] = "Loads the world chunks at distance Far.";
            stringArray4[1] = "Switching the render distance does not cause all chunks ";
            stringArray4[2] = "to be loaded again.";
            stringArray4[3] = "  OFF - world chunks loaded up to render distance";
            stringArray4[4] = "  ON - world chunks loaded at distance Far, allows";
            stringArray = stringArray4;
            stringArray4[5] = "       fast render distance switching";
        } else if (string.equals("Preloaded Chunks")) {
            String[] stringArray5 = new String[5];
            stringArray5[0] = "Defines an area in which no chunks will be loaded";
            stringArray5[1] = "  OFF - after 5m new chunks will be loaded";
            stringArray5[2] = "  2 - after 32m  new chunks will be loaded";
            stringArray5[3] = "  8 - after 128m new chunks will be loaded";
            stringArray = stringArray5;
            stringArray5[4] = "Higher values need more time to load all the chunks";
        } else if (string.equals("Chunk Updates")) {
            String[] stringArray6 = new String[4];
            stringArray6[0] = "Chunk updates per frame";
            stringArray6[1] = " 1 - (default) slower world loading, higher FPS";
            stringArray6[2] = " 3 - faster world loading, lower FPS";
            stringArray = stringArray6;
            stringArray6[3] = " 5 - fastest world loading, lowest FPS";
        } else if (string.equals("Dynamic Updates")) {
            String[] stringArray7 = new String[5];
            stringArray7[0] = "Dynamic chunk updates";
            stringArray7[1] = " OFF - (default) standard chunk updates per frame";
            stringArray7[2] = " ON - more updates while the player is standing still";
            stringArray7[3] = "Dynamic updates force more chunk updates while";
            stringArray = stringArray7;
            stringArray7[4] = "the player is standing still to load the world faster.";
        } else if (string.equals("Lazy Chunk Loading")) {
            String[] stringArray8 = new String[7];
            stringArray8[0] = "Lazy Chunk Loading";
            stringArray8[1] = " OFF - default server chunk loading";
            stringArray8[2] = " ON - lazy server chunk loading (smoother)";
            stringArray8[3] = "Smooths the integrated server chunk loading by";
            stringArray8[4] = "distributing the chunks over several ticks.";
            stringArray8[5] = "Turn it OFF if parts of the world do not load correctly.";
            stringArray = stringArray8;
            stringArray8[6] = "Effective only for local worlds and single-core CPU.";
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

