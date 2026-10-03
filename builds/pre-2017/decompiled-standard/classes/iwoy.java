/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.zwat;

public class iwoy
extends gqjz {
    public final gqjz _a;
    public jiok _b;
    public jiok _c;
    public String _d = "survival";
    public boolean _e;

    public iwoy(gqjz gqjz2) {
        this._a = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(101, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, wpcz._a("lanServer.start")));
        this.field_73887_h.add(new jiok(102, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, wpcz._a("gui.cancel")));
        this._c = new jiok(104, this.field_73880_f / 2 - 155, 100, 150, 20, wpcz._a("selectWorld.gameMode"));
        this.field_73887_h.add(this._c);
        this._b = new jiok(103, this.field_73880_f / 2 + 5, 100, 150, 20, wpcz._a("selectWorld.allowCommands"));
        this.field_73887_h.add(this._b);
        this._a();
    }

    public void _a() {
        this._c.field_73744_e = wpcz._a("selectWorld.gameMode") + " " + wpcz._a("selectWorld.gameMode." + this._d);
        this._b.field_73744_e = wpcz._a("selectWorld.allowCommands") + " ";
        this._b.field_73744_e = this._e ? this._b.field_73744_e + wpcz._a("options.on") : this._b.field_73744_e + wpcz._a("options.off");
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 102) {
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 104) {
            this._d = this._d.equals("survival") ? "creative" : (this._d.equals("creative") ? "adventure" : "survival");
            this._a();
        } else if (jiok2.field_73741_f == 103) {
            this._e = !this._e;
            this._a();
        } else if (jiok2.field_73741_f == 101) {
            this.field_73882_e._a((gqjz)null);
            String string = this.field_73882_e._J()._a(xtby._a(this._d), this._e);
            zwat zwat2 = string != null ? zwat._b("commands.publish.started", string) : zwat._d("commands.publish.failed");
            this.field_73882_e._J.func_73827_b()._a(zwat2._a(true));
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("lanServer.title"), this.field_73880_f / 2, 50, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, wpcz._a("lanServer.otherPlayers"), this.field_73880_f / 2, 82, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

