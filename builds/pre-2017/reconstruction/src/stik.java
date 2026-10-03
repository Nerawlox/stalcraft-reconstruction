/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateFlatWorldListSlot;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;

public class stik
extends GuiScreen {
    public static RenderItem _a = new RenderItem();
    public final GuiCreateWorld _b;
    public elpk _c = elpk._e();
    public String _d;
    public String _e;
    public String _f;
    public GuiCreateFlatWorldListSlot _g;
    public GuiButton _h;
    public GuiButton _i;
    public GuiButton _j;

    public stik(GuiCreateWorld guiCreateWorld, String string) {
        this._b = guiCreateWorld;
        this._a(string);
    }

    public String _a() {
        return this._c.toString();
    }

    public void _a(String string) {
        this._c = elpk._b(string);
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this._d = wpcz._a("createWorld.customize.flat.title");
        this._e = wpcz._a("createWorld.customize.flat.tile");
        this._f = wpcz._a("createWorld.customize.flat.height");
        this._g = new GuiCreateFlatWorldListSlot(this);
        this._h = new GuiButton(2, this.width / 2 - 154, this.height - 52, 100, 20, wpcz._a("createWorld.customize.flat.addLayer") + " (NYI)");
        this.buttonList.add(this._h);
        this._i = new GuiButton(3, this.width / 2 - 50, this.height - 52, 100, 20, wpcz._a("createWorld.customize.flat.editLayer") + " (NYI)");
        this.buttonList.add(this._i);
        this._j = new GuiButton(4, this.width / 2 - 155, this.height - 52, 150, 20, wpcz._a("createWorld.customize.flat.removeLayer"));
        this.buttonList.add(this._j);
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, wpcz._a("gui.done")));
        this.buttonList.add(new GuiButton(5, this.width / 2 + 5, this.height - 52, 150, 20, wpcz._a("createWorld.customize.presets")));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, wpcz._a("gui.cancel")));
        this._i.drawButton = false;
        this._h.drawButton = false;
        this._c._d();
        this._b();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        int n = this._c._c().size() - this._g._a - 1;
        if (guiButton.id == 1) {
            this.mc._a(this._b);
        } else if (guiButton.id == 0) {
            this._b._y = this._a();
            this.mc._a(this._b);
        } else if (guiButton.id == 5) {
            this.mc._a(new tfkf(this));
        } else if (guiButton.id == 4 && this._c()) {
            this._c._c().remove(n);
            this._g._a = Math.min(this._g._a, this._c._c().size() - 1);
        }
        this._c._d();
        this._b();
    }

    public void _b() {
        boolean bl;
        this._j.enabled = bl = this._c();
        this._i.enabled = bl;
        this._i.enabled = false;
        this._h.enabled = false;
    }

    public boolean _c() {
        return this._g._a > -1 && this._g._a < this._c._c().size();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._g.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, this._d, this.width / 2, 8, 0xFFFFFF);
        int n3 = this.width / 2 - 92 - 16;
        this.drawString(this.fontRenderer, this._e, n3, 32, 0xFFFFFF);
        this.drawString(this.fontRenderer, this._f, n3 + 2 + 213 - this.fontRenderer._b(this._f), 32, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ RenderItem _d() {
        return _a;
    }

    public static /* synthetic */ elpk _a(stik stik2) {
        return stik2._c;
    }
}

