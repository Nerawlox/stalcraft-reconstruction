/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.sajh;
import net.minecraft.world.storage.SaveFormatComparator;

public class fnfc
extends GuiSlot {
    public final /* synthetic */ fnfu _a;

    public fnfc(fnfu fnfu2) {
        this._a = fnfu2;
        super(fnfu2.mc, fnfu2.width, fnfu2.height, 32, fnfu2.height - 64, 36);
    }

    @Override
    public int getSize() {
        return fnfu._a(this._a).size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
        boolean bl2;
        fnfu._a(this._a, n);
        fnfu._c((fnfu)this._a).enabled = bl2 = fnfu._b(this._a) >= 0 && fnfu._b(this._a) < this.getSize();
        fnfu._d((fnfu)this._a).enabled = bl2;
        fnfu._e((fnfu)this._a).enabled = bl2;
        fnfu._f((fnfu)this._a).enabled = bl2;
        if (bl && bl2) {
            this._a._c(n);
        }
    }

    @Override
    public boolean isSelected(int n) {
        return n == fnfu._b(this._a);
    }

    @Override
    public int getContentHeight() {
        return fnfu._a(this._a).size() * 36;
    }

    @Override
    public void drawBackground() {
        this._a.drawDefaultBackground();
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        SaveFormatComparator saveFormatComparator = (SaveFormatComparator)fnfu._a(this._a).get(n);
        String string = saveFormatComparator._b();
        if (string == null || sajh._a(string)) {
            string = fnfu._g(this._a) + " " + (n + 1);
        }
        String string2 = saveFormatComparator._a();
        string2 = string2 + " (" + fnfu._h(this._a).format(new Date(saveFormatComparator._d()));
        string2 = string2 + ")";
        String string3 = "";
        if (saveFormatComparator._c()) {
            string3 = fnfu._i(this._a) + " " + string3;
        } else {
            string3 = fnfu._j(this._a)[saveFormatComparator._e()._a()];
            if (saveFormatComparator._f()) {
                string3 = (Object)((Object)EnumChatFormatting._e) + wpcz._a("gameMode.hardcore") + (Object)((Object)EnumChatFormatting._v);
            }
            if (saveFormatComparator._g()) {
                string3 = string3 + ", " + wpcz._a("selectWorld.cheats");
            }
        }
        this._a.drawString(this._a.fontRenderer, string, n2 + 2, n3 + 1, 0xFFFFFF);
        this._a.drawString(this._a.fontRenderer, string2, n2 + 2, n3 + 12, 0x808080);
        this._a.drawString(this._a.fontRenderer, string3, n2 + 2, n3 + 12 + 10, 0x808080);
    }
}

