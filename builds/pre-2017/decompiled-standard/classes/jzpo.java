/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;

public class jzpo
extends gqjz {
    public int _b;

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        if (this.field_73882_e._r.func_72912_H()._t()) {
            if (this.field_73882_e._H()) {
                this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96, wpcz._a("deathScreen.deleteWorld")));
            } else {
                this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96, wpcz._a("deathScreen.leaveServer")));
            }
        } else {
            this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 72, wpcz._a("deathScreen.respawn")));
            this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96, wpcz._a("deathScreen.titleScreen")));
            if (this.field_73882_e._P() == null) {
                ((jiok)this.field_73887_h.get((int)1)).field_73742_g = false;
            }
        }
        for (jiok jiok2 : this.field_73887_h) {
            jiok2.field_73742_g = false;
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        switch (jiok2.field_73741_f) {
            case 1: {
                this.field_73882_e._t.func_71004_bE();
                this.field_73882_e._a((gqjz)null);
                break;
            }
            case 2: {
                this.field_73882_e._r.func_72882_A();
                this.field_73882_e._a((pkix)null);
                this.field_73882_e._a(new fngq());
            }
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, 0x60500000, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        boolean bl = this.field_73882_e._r.func_72912_H()._t();
        String string = bl ? wpcz._a("deathScreen.title.hardcore") : wpcz._a("deathScreen.title");
        this.func_73732_a(this.field_73886_k, string, this.field_73880_f / 2 / 2, 30, 0xFFFFFF);
        GL11.glPopMatrix();
        if (bl) {
            this.func_73732_a(this.field_73886_k, wpcz._a("deathScreen.hardcoreInfo"), this.field_73880_f / 2, 144, 0xFFFFFF);
        }
        this.func_73732_a(this.field_73886_k, wpcz._a("deathScreen.score") + ": " + (Object)((Object)ezfc._o) + this.field_73882_e._t.func_71037_bA(), this.field_73880_f / 2, 100, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._b;
        if (this._b == 20) {
            for (jiok jiok2 : this.field_73887_h) {
                jiok2.field_73742_g = true;
            }
        }
    }
}

