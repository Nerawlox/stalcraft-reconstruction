/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.Language;

public class jiqn
extends GuiSlot {
    public final List _a;
    public final Map _b;
    public final /* synthetic */ twpa _c;

    public jiqn(twpa twpa2) {
        this._c = twpa2;
        super(twpa2.mc, twpa2.width, twpa2.height, 32, twpa2.height - 65 + 4, 18);
        this._a = Lists.newArrayList();
        this._b = Maps.newHashMap();
        for (Language language : twpa._a(twpa2)._d()) {
            this._b.put(language._a(), language);
            this._a.add(language._a());
        }
    }

    @Override
    public int getSize() {
        return this._a.size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
        Language language = (Language)this._b.get(this._a.get(n));
        twpa._a(this._c)._a(language);
        twpa._b((twpa)this._c).language = language._a();
        this._c.mc._c();
        this._c.fontRenderer._a(twpa._a(this._c)._a());
        this._c.fontRenderer._b(twpa._a(this._c)._b());
        twpa._c((twpa)this._c).displayString = wpcz._a("gui.done");
        twpa._b(this._c).saveOptions();
    }

    @Override
    public boolean isSelected(int n) {
        return ((String)this._a.get(n)).equals(twpa._a(this._c)._c()._a());
    }

    @Override
    public int getContentHeight() {
        return this.getSize() * 18;
    }

    @Override
    public void drawBackground() {
        this._c.drawDefaultBackground();
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        this._c.fontRenderer._b(true);
        this._c.drawCenteredString(this._c.fontRenderer, ((Language)this._b.get(this._a.get(n))).toString(), this._c.width / 2, n3 + 1, 0xFFFFFF);
        this._c.fontRenderer._b(twpa._a(this._c)._c()._b());
    }
}

