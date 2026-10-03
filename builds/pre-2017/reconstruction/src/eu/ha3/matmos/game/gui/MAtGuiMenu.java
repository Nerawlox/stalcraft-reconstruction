/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.gui;

import eu.ha3.matmos.conv.CustomVolume;
import eu.ha3.matmos.conv.Expansion;
import eu.ha3.matmos.game.gui.MAtGuiMore;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.gui.HDisplayStringProvider;
import eu.ha3.mc.gui.HGuiSliderControl;
import eu.ha3.mc.gui.HSliderListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class MAtGuiMenu
extends GuiScreen {
    private GuiScreen parentScreen;
    protected String screenTitle = "MAtmos Expansions";
    private MAtMod mod;
    private int buttonId = -1;
    private int pageFromZero;
    private final int IDS_PER_PAGE = 5;
    private List<Expansion> expansionList;
    private static int in_memory_page = 0;

    public MAtGuiMenu(GuiScreen guiScreen, MAtMod mAtMod) {
        this(guiScreen, mAtMod, in_memory_page);
    }

    public MAtGuiMenu(GuiScreen guiScreen, MAtMod mAtMod, int n) {
        this.parentScreen = guiScreen;
        this.mod = mAtMod;
        this.pageFromZero = n;
        this.expansionList = new ArrayList<Expansion>();
        in_memory_page = this.pageFromZero;
    }

    @Override
    public void initGui() {
        int n;
        int n2 = 2;
        int n3 = 20;
        int n4 = 310;
        int n5 = 22;
        int n6 = this.width / 2 - 155;
        int n7 = this.width / 2 + 155;
        Map<String, Expansion> map = this.mod.getExpansionList();
        int n8 = 0;
        Object object = this.mod.getGlobalVolumeControl();
        HGuiSliderControl hGuiSliderControl = new HGuiSliderControl(n8, n6, 22, 310, 20, "", object.getVolume() * 0.5f);
        hGuiSliderControl.setListener(new HSliderListener((CustomVolume)object){
            final /* synthetic */ CustomVolume val$globalVolumeControl;
            {
                this.val$globalVolumeControl = customVolume;
            }

            @Override
            public void sliderValueChanged(HGuiSliderControl hGuiSliderControl, float f) {
                this.val$globalVolumeControl.setVolume(f * 2.0f);
                hGuiSliderControl.updateDisplayString();
                MAtGuiMenu.this.mod.getConfig().setProperty("globalvolume.scale", Float.valueOf(this.val$globalVolumeControl.getVolume()));
            }

            @Override
            public void sliderPressed(HGuiSliderControl hGuiSliderControl) {
            }

            @Override
            public void sliderReleased(HGuiSliderControl hGuiSliderControl) {
            }
        });
        hGuiSliderControl.setDisplayStringProvider(new HDisplayStringProvider((CustomVolume)object){
            final /* synthetic */ CustomVolume val$globalVolumeControl;
            {
                this.val$globalVolumeControl = customVolume;
            }

            @Override
            public String provideDisplayString() {
                return "Global Volume Control: " + (int)Math.floor(this.val$globalVolumeControl.getVolume() * 100.0f) + "%";
            }
        });
        hGuiSliderControl.updateDisplayString();
        this.buttonList.add(hGuiSliderControl);
        ++n8;
        object = new ArrayList<String>(map.keySet());
        Collections.sort(object);
        for (n = this.pageFromZero * this.IDS_PER_PAGE; n < this.pageFromZero * this.IDS_PER_PAGE + this.IDS_PER_PAGE && n < object.size(); ++n) {
            String string = (String)object.get(n);
            final Expansion expansion = map.get(string);
            this.expansionList.add(expansion);
            HGuiSliderControl hGuiSliderControl2 = new HGuiSliderControl(n8, n6 + 22, 22 * (n8 + 1), 266, 20, "", expansion.getVolume() * 0.5f);
            hGuiSliderControl2.setListener(new HSliderListener(){

                @Override
                public void sliderValueChanged(HGuiSliderControl hGuiSliderControl, float f) {
                    expansion.setVolume(f * 2.0f);
                    if (f != 0.0f && !expansion.isRunning()) {
                        expansion.turnOn();
                    }
                    hGuiSliderControl.updateDisplayString();
                }

                @Override
                public void sliderPressed(HGuiSliderControl hGuiSliderControl) {
                }

                @Override
                public void sliderReleased(HGuiSliderControl hGuiSliderControl) {
                    if (MAtGuiMenu.this.mod.getConfig().getBoolean("sound.autopreview")) {
                        expansion.playSample();
                    }
                }
            });
            hGuiSliderControl2.setDisplayStringProvider(new HDisplayStringProvider(){

                @Override
                public String provideDisplayString() {
                    String string = expansion.getFriendlyName() + ": ";
                    string = expansion.getVolume() == 0.0f ? (expansion.isRunning() ? string + "Will be disabled" : string + "Disabled") : string + (int)Math.floor(expansion.getVolume() * 100.0f) + "%";
                    return string;
                }
            });
            hGuiSliderControl2.updateDisplayString();
            this.buttonList.add(hGuiSliderControl2);
            this.buttonList.add(new GuiButton(400 + n8 - 1, n7 - 20, 22 * (n8 + 1), 20, 20, "?"));
            ++n8;
        }
        this.buttonList.add(new GuiButton(220, n7 - 20, 22 * (this.IDS_PER_PAGE + 2), 20, 20, this.mod.getConfig().getBoolean("sound.autopreview") ? "^o^" : "^_^"));
        n = 103;
        if (this.pageFromZero != 0) {
            this.buttonList.add(new GuiButton(201, n6 + 22, 22 * (this.IDS_PER_PAGE + 2), 103, 20, "Previous"));
        }
        if (this.pageFromZero * this.IDS_PER_PAGE + this.IDS_PER_PAGE < object.size()) {
            this.buttonList.add(new GuiButton(202, n7 - 22 - 103, 22 * (this.IDS_PER_PAGE + 2), 103, 20, "Next"));
        }
        int n9 = 2;
        int n10 = 154;
        int n11 = 10;
        this.buttonList.add(new GuiButton(210, n6, 10 + 22 * (this.IDS_PER_PAGE + 3), 154, 20, this.mod.getConfig().getBoolean("start.enabled") ? "Start Enabled: ON" : "Start Enabled: OFF"));
        this.buttonList.add(new GuiButton(211, n6 + 154 + 2, 10 + 22 * (this.IDS_PER_PAGE + 3), 154, 20, "Advanced options..."));
        int n12 = 62;
        this.buttonList.add(new GuiButton(200, n6 + 22, 10 + 22 * (this.IDS_PER_PAGE + 4), 202, 20, "Done"));
        this.buttonList.add(new GuiButton(212, n7 - 62 - 22, 10 + 22 * (this.IDS_PER_PAGE + 4), 62, 20, "Turn Off"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        int n;
        Expansion expansion;
        if (guiButton.id == 200) {
            this.mc._a(this.parentScreen);
        } else if (guiButton.id == 201) {
            this.mc._a(new MAtGuiMenu(this.parentScreen, this.mod, this.pageFromZero - 1));
        } else if (guiButton.id == 202) {
            this.mc._a(new MAtGuiMenu(this.parentScreen, this.mod, this.pageFromZero + 1));
        } else if (guiButton.id == 210) {
            boolean bl = !this.mod.getConfig().getBoolean("start.enabled");
            this.mod.getConfig().setProperty("start.enabled", bl);
            guiButton.displayString = bl ? "Start Enabled: ON" : "Start Enabled: OFF";
            this.mod.saveConfig();
        } else if (guiButton.id == 211) {
            this.mc._a(new MAtGuiMore(this, this.mod));
        } else if (guiButton.id == 212) {
            this.mc._a(this.parentScreen);
            this.mod.stopRunning();
        } else if (guiButton.id == 220) {
            this.mod.getConfig().setProperty("sound.autopreview", !this.mod.getConfig().getBoolean("sound.autopreview"));
            guiButton.displayString = this.mod.getConfig().getBoolean("sound.autopreview") ? "^o^" : "^_^";
            this.mod.saveConfig();
        } else if (guiButton.id >= 400 && (expansion = this.expansionList.get(n = guiButton.id - 400)).isRunning()) {
            expansion.playSample();
        }
    }

    private void aboutToClose() {
        Map<String, Expansion> map = this.mod.getExpansionList();
        for (Expansion expansion : map.values()) {
            if (expansion.getVolume() != 0.0f || !expansion.isRunning()) continue;
            expansion.turnOff();
        }
        this.mod.saveConfig();
        for (Expansion expansion : map.values()) {
            expansion.saveConfig();
        }
    }

    @Override
    public void onGuiClosed() {
        this.aboutToClose();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        if (this.buttonId < 0) {
            super.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 8, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

