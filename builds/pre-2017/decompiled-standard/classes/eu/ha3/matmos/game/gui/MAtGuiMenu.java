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

public class MAtGuiMenu
extends gqjz {
    private gqjz parentScreen;
    protected String screenTitle = "MAtmos Expansions";
    private MAtMod mod;
    private int buttonId = -1;
    private int pageFromZero;
    private final int IDS_PER_PAGE = 5;
    private List<Expansion> expansionList;
    private static int in_memory_page = 0;

    public MAtGuiMenu(gqjz gqjz2, MAtMod mAtMod) {
        this(gqjz2, mAtMod, in_memory_page);
    }

    public MAtGuiMenu(gqjz gqjz2, MAtMod mAtMod, int n) {
        this.parentScreen = gqjz2;
        this.mod = mAtMod;
        this.pageFromZero = n;
        this.expansionList = new ArrayList<Expansion>();
        in_memory_page = this.pageFromZero;
    }

    @Override
    public void func_73866_w_() {
        int n;
        int n2 = 2;
        int n3 = 20;
        int n4 = 310;
        int n5 = 22;
        int n6 = this.field_73880_f / 2 - 155;
        int n7 = this.field_73880_f / 2 + 155;
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
        this.field_73887_h.add(hGuiSliderControl);
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
            this.field_73887_h.add(hGuiSliderControl2);
            this.field_73887_h.add(new jiok(400 + n8 - 1, n7 - 20, 22 * (n8 + 1), 20, 20, "?"));
            ++n8;
        }
        this.field_73887_h.add(new jiok(220, n7 - 20, 22 * (this.IDS_PER_PAGE + 2), 20, 20, this.mod.getConfig().getBoolean("sound.autopreview") ? "^o^" : "^_^"));
        n = 103;
        if (this.pageFromZero != 0) {
            this.field_73887_h.add(new jiok(201, n6 + 22, 22 * (this.IDS_PER_PAGE + 2), 103, 20, "Previous"));
        }
        if (this.pageFromZero * this.IDS_PER_PAGE + this.IDS_PER_PAGE < object.size()) {
            this.field_73887_h.add(new jiok(202, n7 - 22 - 103, 22 * (this.IDS_PER_PAGE + 2), 103, 20, "Next"));
        }
        int n9 = 2;
        int n10 = 154;
        int n11 = 10;
        this.field_73887_h.add(new jiok(210, n6, 10 + 22 * (this.IDS_PER_PAGE + 3), 154, 20, this.mod.getConfig().getBoolean("start.enabled") ? "Start Enabled: ON" : "Start Enabled: OFF"));
        this.field_73887_h.add(new jiok(211, n6 + 154 + 2, 10 + 22 * (this.IDS_PER_PAGE + 3), 154, 20, "Advanced options..."));
        int n12 = 62;
        this.field_73887_h.add(new jiok(200, n6 + 22, 10 + 22 * (this.IDS_PER_PAGE + 4), 202, 20, "Done"));
        this.field_73887_h.add(new jiok(212, n7 - 62 - 22, 10 + 22 * (this.IDS_PER_PAGE + 4), 62, 20, "Turn Off"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        int n;
        Expansion expansion;
        if (jiok2.field_73741_f == 200) {
            this.field_73882_e._a(this.parentScreen);
        } else if (jiok2.field_73741_f == 201) {
            this.field_73882_e._a(new MAtGuiMenu(this.parentScreen, this.mod, this.pageFromZero - 1));
        } else if (jiok2.field_73741_f == 202) {
            this.field_73882_e._a(new MAtGuiMenu(this.parentScreen, this.mod, this.pageFromZero + 1));
        } else if (jiok2.field_73741_f == 210) {
            boolean bl = !this.mod.getConfig().getBoolean("start.enabled");
            this.mod.getConfig().setProperty("start.enabled", bl);
            jiok2.field_73744_e = bl ? "Start Enabled: ON" : "Start Enabled: OFF";
            this.mod.saveConfig();
        } else if (jiok2.field_73741_f == 211) {
            this.field_73882_e._a(new MAtGuiMore(this, this.mod));
        } else if (jiok2.field_73741_f == 212) {
            this.field_73882_e._a(this.parentScreen);
            this.mod.stopRunning();
        } else if (jiok2.field_73741_f == 220) {
            this.mod.getConfig().setProperty("sound.autopreview", !this.mod.getConfig().getBoolean("sound.autopreview"));
            jiok2.field_73744_e = this.mod.getConfig().getBoolean("sound.autopreview") ? "^o^" : "^_^";
            this.mod.saveConfig();
        } else if (jiok2.field_73741_f >= 400 && (expansion = this.expansionList.get(n = jiok2.field_73741_f - 400)).isRunning()) {
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
    public void func_73874_b() {
        this.aboutToClose();
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (this.buttonId < 0) {
            super.func_73864_a(n, n2, n3);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.screenTitle, this.field_73880_f / 2, 8, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

