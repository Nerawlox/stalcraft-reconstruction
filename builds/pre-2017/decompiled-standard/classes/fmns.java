/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class fmns
extends GuiItem {
    public final EntityPlayer _a;
    public final brhe _b;
    private final int _c;

    public fmns(gqjz gqjz2, EntityPlayer entityPlayer, int n) {
        super(gqjz2, entityPlayer.field_71070_bA.func_75139_a(n).func_75211_c(), anoq._a(entityPlayer.field_71070_bA.func_75139_a(n).func_75211_c()._a()));
        this._a = entityPlayer;
        this._c = n;
        this._b = (brhe)this.getStack()._a();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Point point = new Point(this.screenWidth / 2 - this._b._d * 40 + 4, this.screenHeight - 80);
        for (int i = 0; i < this._b._d; ++i) {
            kjui kjui2 = new kjui(this, point, i, this._b._c(this.getStack(), Integer.valueOf(i)));
            this.addElement(kjui2);
            point = point.add(80, 0);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        cvzo cvzo2 = this._a.field_71070_bA.func_75139_a(this._c).func_75211_c();
        if (this.getStack() != cvzo2) {
            if (this.getStack() != null && cvzo2 != null && this.getStack()._d == cvzo2._d) {
                this.setStack(cvzo2);
            } else {
                this.closeScreen();
            }
        }
    }

    protected void _a(int n, cvzo cvzo2) {
        int n2 = ncwh._a(this._a.field_71071_by, cvzo2);
        new kkpg(this._c, n2, n).sendToServer();
        brhe._a(this._a, this._c, n2, n);
    }

    @Override
    protected List<cvzo> getAvailableStacks() {
        return Lists.newArrayList(this._a.field_71071_by._a);
    }

    protected static class kjui
    extends GuiItem.McSelectSlot {
        final fmns _a;
        final int _b;

        kjui(fmns fmns2, Point point, int n, cvzo cvzo3) {
            super(fmns2, cvzo3, (cvzo cvzo2) -> cvzo2._a() instanceof cdit && ((cdit)cvzo2._a())._a((cvzo)cvzo2));
            this._a = fmns2;
            this._b = n;
            this.setLocation(point);
        }

        @Override
        protected void onChange(cvzo cvzo2) {
            this._a._a(this._b, cvzo2);
            xpzm._E()._N._a("stalker:inv_backpack", 1.0f, 1.0f);
        }
    }
}

