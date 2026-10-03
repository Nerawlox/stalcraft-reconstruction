/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;
import net.minecraft.util.gomc;

public class GuiOtherSettingsOF
extends gqjz {
    private gqjz prevScreen;
    protected String title = "Other Settings";
    private GameSettings settings;
    private static kjui[] enumOptions = new kjui[]{kjui._Y, kjui.__au, kjui.__af, kjui.__al, kjui._y, kjui.__ax, kjui._i, kjui._Z};
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public GuiOtherSettingsOF(gqjz gqjz2, GameSettings gameSettings) {
        this.prevScreen = gqjz2;
        this.settings = gameSettings;
    }

    @Override
    public void func_73866_w_() {
        gomc gomc2 = gomc._a();
        int n = 0;
        for (kjui kjui2 : enumOptions) {
            int n2 = this.field_73880_f / 2 - 155 + n % 2 * 160;
            int n3 = this.field_73881_g / 6 + 21 * (n / 2) - 10;
            if (!kjui2._a()) {
                this.field_73887_h.add(new baxz(kjui2._c(), n2, n3, kjui2, this.settings.func_74297_c(kjui2)));
            } else {
                this.field_73887_h.add(new dyaq(kjui2._c(), n2, n3, kjui2, this.settings.func_74297_c(kjui2), this.settings.func_74296_a(kjui2)));
            }
            ++n;
        }
        this.field_73887_h.add(new jiok(210, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168 + 11 - 22, "Reset Video Settings..."));
        this.field_73887_h.add(new jiok(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168 + 11, gomc2._a("gui.done")));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73742_g) {
            Object object;
            if (jiok2.field_73741_f < 100 && jiok2 instanceof baxz) {
                this.settings.func_74306_a(((baxz)jiok2).func_73753_a(), 1);
                jiok2.field_73744_e = this.settings.func_74297_c(kjui._a(jiok2.field_73741_f));
            }
            if (jiok2.field_73741_f == 200) {
                this.field_73882_e._M.func_74303_b();
                this.field_73882_e._a(this.prevScreen);
            }
            if (jiok2.field_73741_f == 210) {
                this.field_73882_e._M.func_74303_b();
                object = new lowa(this, "Reset all video settings to their default values?", "", 9999);
                this.field_73882_e._a((gqjz)object);
            }
            if (jiok2.field_73741_f != kjui._O.ordinal()) {
                object = new htou(this.field_73882_e._M, this.field_73882_e._n, this.field_73882_e._o);
                int n = ((htou)object)._a();
                int n2 = ((htou)object)._b();
                this.func_73872_a(this.field_73882_e, n, n2);
            }
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl) {
            this.field_73882_e._M.resetSettings();
        }
        this.field_73882_e._a(this);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.title, this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
        if (Math.abs(n - this.lastMouseX) <= 5 && Math.abs(n2 - this.lastMouseY) <= 5) {
            int n3 = 700;
            if (System.currentTimeMillis() >= this.mouseStillTime + (long)n3) {
                int n4 = this.field_73880_f / 2 - 150;
                int n5 = this.field_73881_g / 6 - 5;
                if (n2 <= n5 + 98) {
                    n5 += 105;
                }
                int n6 = n4 + 150 + 150;
                int n7 = n5 + 84 + 10;
                jiok jiok2 = this.getSelectedButton(n, n2);
                if (jiok2 != null) {
                    String string = this.getButtonName(jiok2.field_73744_e);
                    String[] stringArray = this.getTooltipLines(string);
                    if (stringArray == null) {
                        return;
                    }
                    this.func_73733_a(n4, n5, n6, n7, -536870912, -536870912);
                    for (int i = 0; i < stringArray.length; ++i) {
                        String string2 = stringArray[i];
                        this.field_73886_k._a(string2, n4 + 5, n5 + 5 + i * 11, 0xDDDDDD);
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

    private jiok getSelectedButton(int n, int n2) {
        for (int i = 0; i < this.field_73887_h.size(); ++i) {
            boolean bl;
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            boolean bl2 = bl = n >= jiok2.field_73746_c && n2 >= jiok2.field_73743_d && n < jiok2.field_73746_c + jiok2.field_73747_a && n2 < jiok2.field_73743_d + jiok2.field_73745_b;
            if (!bl) continue;
            return jiok2;
        }
        return null;
    }
}

