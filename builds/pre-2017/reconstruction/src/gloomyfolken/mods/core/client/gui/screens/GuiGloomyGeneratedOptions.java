/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiYesNoCancel;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public abstract class GuiGloomyGeneratedOptions
extends GuiScreen {
    protected GuiScreen parentGuiScreen;
    protected String screenTitle = "";
    protected HashMap<GuiButton, anpn> buttonsMap = new HashMap();
    private HashMap<anpn, String> initialValues = new HashMap();
    private boolean escExit;
    private GuiButton applyButton;

    public abstract List<anpn> options();

    public GuiGloomyGeneratedOptions(GuiScreen guiScreen) {
        this.parentGuiScreen = guiScreen;
        this.saveOptionValues();
    }

    protected void saveOptionValues() {
        for (anpn anpn2 : this.options()) {
            this.initialValues.put(anpn2, anpn2.getName());
        }
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonsMap.clear();
        int n = 0;
        int n2 = 0;
        int n3 = this.options().size() / 2 * 24;
        boolean bl = this.options().size() % 2 != 0;
        for (anpn anpn2 : this.options()) {
            int n4 = this.width / 2 + ((n2 + 1) % 2 == 0 ? 2 : -152);
            int n5 = (this.height - n3) / 3 + n2 / 2 * 24;
            GuiButton guiButton = anpn2.createButton(n2++, n4, n5);
            if (this.options().indexOf(anpn2) == this.options().size() - 1 && bl) {
                guiButton.width *= 2;
            }
            this.buttonList.add(guiButton);
            this.buttonsMap.put(guiButton, anpn2);
            if (n5 <= n) continue;
            n = n5;
        }
        this.buttonList.add(new GuiButton(100, this.width / 2 - 205, n + 24, 200, 20, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        this.applyButton = new GuiButton(101, this.width / 2 + 5, n + 24, 200, 20, "\u041f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c");
        this.buttonList.add(this.applyButton);
        this.updateButtonNames();
    }

    protected boolean hasChanges() {
        for (Map.Entry<anpn, String> entry : this.initialValues.entrySet()) {
            if (Objects.equals(entry.getValue(), entry.getKey().getName())) continue;
            return true;
        }
        return false;
    }

    public void updateButtonNames() {
        for (Map.Entry<GuiButton, anpn> entry : this.buttonsMap.entrySet()) {
            entry.getKey().displayString = entry.getValue().getName();
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1) {
            this.escExit = true;
            this.quitOptions();
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        anpn anpn3 = this.buttonsMap.get(guiButton);
        if (anpn3 != null) {
            anpn3.onButtonPressed();
            guiButton.displayString = anpn3.getName();
        }
        if (guiButton.id == 100) {
            this.quitOptions();
        } else if (guiButton.id == 101) {
            this.options().forEach(anpn2 -> anpn2.onChanged(false));
            this.saveOptionValues();
            this.options().forEach(anpn2 -> anpn2.save(GloomyCore.mcconfig));
            GloomyCore.mcconfig.save();
            this.applyButton.enabled = false;
        } else {
            this.applyButton.enabled = true;
        }
    }

    private void quitOptions() {
        if (this.hasChanges()) {
            this.mc._a(new GuiYesNoCancel(this, "\u0418\u043c\u0435\u044e\u0442\u0441\u044f \u043d\u0435\u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f.", "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0438 \u043f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c \u0443\u043a\u0430\u0437\u0430\u043d\u043d\u044b\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438?", -1));
        } else {
            this.mc._a(this.parentGuiScreen);
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (n == 2) {
            this.mc._a(this);
        } else {
            if (n == 0) {
                this.options().forEach(anpn2 -> anpn2.save(GloomyCore.mcconfig));
                GloomyCore.mcconfig.save();
            } else if (n == 1) {
                this.options().forEach(anpn2 -> anpn2.load(GloomyCore.mcconfig));
            }
            this.options().forEach(anpn2 -> anpn2.onChanged(false));
            if (this.escExit) {
                this.mc._a((GuiScreen)null);
                this.mc._o();
            } else {
                this.mc._a(this.parentGuiScreen);
            }
        }
        this.escExit = false;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = this.options().size() / 2 * 24;
        int n4 = (this.height - n3) / 3;
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, n4 - 15, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

