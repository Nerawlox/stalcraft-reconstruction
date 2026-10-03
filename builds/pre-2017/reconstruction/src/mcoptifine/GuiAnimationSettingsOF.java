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

public class GuiAnimationSettingsOF
extends GuiScreen {
    private GuiScreen prevScreen;
    protected String title = "Animation Settings";
    private GameSettings settings;
    private static EnumOptions[] enumOptions = new EnumOptions[]{EnumOptions._T, EnumOptions._U, EnumOptions._V, EnumOptions._W, EnumOptions.__ab, EnumOptions.__ac, EnumOptions.__ad, EnumOptions.__ae, EnumOptions.__ap, EnumOptions.__aq, EnumOptions.__ar, EnumOptions.__as, EnumOptions.__at, EnumOptions.__av, EnumOptions.__ay, EnumOptions.__az, EnumOptions.__aK, EnumOptions._q};

    public GuiAnimationSettingsOF(GuiScreen guiScreen, GameSettings gameSettings) {
        this.prevScreen = guiScreen;
        this.settings = gameSettings;
    }

    @Override
    public void initGui() {
        gomc gomc2 = gomc._a();
        int n = 0;
        for (EnumOptions enumOptions : GuiAnimationSettingsOF.enumOptions) {
            int n2 = this.width / 2 - 155 + n % 2 * 160;
            int n3 = this.height / 6 + 21 * (n / 2) - 10;
            if (!enumOptions._a()) {
                this.buttonList.add(new baxz(enumOptions._c(), n2, n3, enumOptions, this.settings.getKeyBinding(enumOptions)));
            } else {
                this.buttonList.add(new GuiSlider(enumOptions._c(), n2, n3, enumOptions, this.settings.getKeyBinding(enumOptions), this.settings.getOptionFloatValue(enumOptions)));
            }
            ++n;
        }
        this.buttonList.add(new GuiButton(210, this.width / 2 - 155, this.height / 6 + 168 + 11, 70, 20, "All ON"));
        this.buttonList.add(new GuiButton(211, this.width / 2 - 155 + 80, this.height / 6 + 168 + 11, 70, 20, "All OFF"));
        this.buttonList.add(new baxz(200, this.width / 2 + 5, this.height / 6 + 168 + 11, gomc2._a("gui.done")));
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
            if (guiButton.id == 210) {
                this.mc._M.setAllAnimations(true);
            }
            if (guiButton.id == 211) {
                this.mc._M.setAllAnimations(false);
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
    }
}

