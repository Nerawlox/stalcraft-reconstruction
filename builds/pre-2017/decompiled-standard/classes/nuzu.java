/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.GuiControlsScrollPanel;

@SideOnly(value=Side.CLIENT)
public class nuzu
extends gqjz {
    public gqjz _a;
    public String _b = "Controls";
    public GameSettings _c;
    public int _d = -1;
    public GuiControlsScrollPanel _e;

    public nuzu(gqjz gqjz2, GameSettings gameSettings) {
        this._a = gqjz2;
        this._c = gameSettings;
    }

    public int _a() {
        return this.field_73880_f / 2 - 155;
    }

    @Override
    public void func_73866_w_() {
        this._e = new GuiControlsScrollPanel(this, this._c, this.field_73882_e);
        this.field_73887_h.add(new jiok(200, this.field_73880_f / 2 - 100, this.field_73881_g - 28, wpcz._a("gui.done")));
        this._e.func_77220_a(7, 8);
        this._b = wpcz._a("controls.title");
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 200) {
            this.field_73882_e._a(this._a);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (this._e.keyTyped(c, n)) {
            super.func_73869_a(c, n);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._e.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, this._b, this.field_73880_f / 2, 4, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

