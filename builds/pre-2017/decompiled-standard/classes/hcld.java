/*
 * Decompiled with CFR 0.152.
 */
public class hcld
extends gqjz {
    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new baxz(0, this.field_73880_f / 2 - 155, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.toMenu")));
        this.field_73887_h.add(new baxz(1, this.field_73880_f / 2 - 155 + 160, this.field_73881_g / 4 + 120 + 12, wpcz._a("menu.quit")));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(new fngq());
        } else if (jiok2.field_73741_f == 1) {
            this.field_73882_e._n();
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, "Out of memory!", this.field_73880_f / 2, this.field_73881_g / 4 - 60 + 20, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "Minecraft has run out of memory.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 0, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "This could be caused by a bug in the game or by the", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 18, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "Java Virtual Machine not being allocated enough", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 27, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "memory. If you are playing in a web browser, try", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 36, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "downloading the game and playing it offline.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 45, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "To prevent level corruption, the current game has quit.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 63, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "We've tried to free up enough memory to let you go back to", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 81, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "the main menu and back to playing, but this may not have worked.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 90, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, "Please restart the game if you see this message again.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 99, 0xA0A0A0);
        super.func_73863_a(n, n2, f);
    }
}

