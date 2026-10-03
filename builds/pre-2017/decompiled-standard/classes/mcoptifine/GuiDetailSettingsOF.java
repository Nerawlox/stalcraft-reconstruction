/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;
import net.minecraft.util.gomc;

public class GuiDetailSettingsOF
extends gqjz {
    private gqjz prevScreen;
    protected String title = "Detail Settings";
    private GameSettings settings;
    private static kjui[] enumOptions = new kjui[]{kjui._N, kjui._O, kjui._P, kjui._Q, kjui._S, kjui._R, kjui.__ag, kjui.__ah, kjui.__ai, kjui.__aF, kjui.__ao, kjui.__aO, kjui.__aP};
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public GuiDetailSettingsOF(gqjz gqjz2, GameSettings gameSettings) {
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
        this.field_73887_h.add(new jiok(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168 + 11, gomc2._a("gui.done")));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73742_g) {
            if (jiok2.field_73741_f < 100 && jiok2 instanceof baxz) {
                this.settings.func_74306_a(((baxz)jiok2).func_73753_a(), 1);
                jiok2.field_73744_e = this.settings.func_74297_c(kjui._a(jiok2.field_73741_f));
            }
            if (jiok2.field_73741_f == 200) {
                this.field_73882_e._M.func_74303_b();
                this.field_73882_e._a(this.prevScreen);
            }
            if (jiok2.field_73741_f != kjui._O.ordinal()) {
                htou htou2 = new htou(this.field_73882_e._M, this.field_73882_e._n, this.field_73882_e._o);
                int n = htou2._a();
                int n2 = htou2._b();
                this.func_73872_a(this.field_73882_e, n, n2);
            }
        }
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

