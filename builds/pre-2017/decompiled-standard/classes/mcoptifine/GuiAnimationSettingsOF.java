/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;
import net.minecraft.util.gomc;

public class GuiAnimationSettingsOF
extends gqjz {
    private gqjz prevScreen;
    protected String title = "Animation Settings";
    private GameSettings settings;
    private static kjui[] enumOptions = new kjui[]{kjui._T, kjui._U, kjui._V, kjui._W, kjui.__ab, kjui.__ac, kjui.__ad, kjui.__ae, kjui.__ap, kjui.__aq, kjui.__ar, kjui.__as, kjui.__at, kjui.__av, kjui.__ay, kjui.__az, kjui.__aK, kjui._q};

    public GuiAnimationSettingsOF(gqjz gqjz2, GameSettings gameSettings) {
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
        this.field_73887_h.add(new jiok(210, this.field_73880_f / 2 - 155, this.field_73881_g / 6 + 168 + 11, 70, 20, "All ON"));
        this.field_73887_h.add(new jiok(211, this.field_73880_f / 2 - 155 + 80, this.field_73881_g / 6 + 168 + 11, 70, 20, "All OFF"));
        this.field_73887_h.add(new baxz(200, this.field_73880_f / 2 + 5, this.field_73881_g / 6 + 168 + 11, gomc2._a("gui.done")));
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
            if (jiok2.field_73741_f == 210) {
                this.field_73882_e._M.setAllAnimations(true);
            }
            if (jiok2.field_73741_f == 211) {
                this.field_73882_e._M.setAllAnimations(false);
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
    }
}

