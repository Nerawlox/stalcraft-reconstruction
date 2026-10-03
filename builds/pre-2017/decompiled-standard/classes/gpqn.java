/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.misc.vjta;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import net.minecraft.util.hanr;
import net.minecraft.util.kjwj;
import org.lwjgl.opengl.GL11;

public class gpqn
extends GuiItem {
    private dgmz _f;
    private gqjz _g;
    protected McButton _a;
    protected GuiItem.McSelectSlot _b;
    protected pidb _c;
    protected McButton _d;
    private List<cvzo> _h = new ArrayList<cvzo>();
    protected String _e;

    public gpqn(gqjz gqjz2, cvzo cvzo2) {
        super(gqjz2, cvzo2, null, null);
        this._f = (dgmz)cvzo2._a();
        this._g = gqjz2;
        this.previewConfig = new uhib(0.0f, 0.2f, 0.0f, 0.3f, 0.2f, 0.4f);
        this._e = ((vjta)((Object)cvzo2._a()))._i_(cvzo2);
        for (tgdv tgdv2 : tgdv.field_77698_e) {
            if (!(tgdv2 instanceof xroo) && !(tgdv2 instanceof bafv)) continue;
            this._h.add(new cvzo(tgdv2));
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this._c = new pidb(this, new Point(20, this.screenHeight - 324));
        this.addElement(this._c);
        this._c.setEnabled(this._a());
        this._c.setVisible(this._a());
        this._d = GuiHelper.addButton(this, 20, this.screenHeight - 245, 200, 40, "\u041f\u043e\u043a\u0440\u0430\u0441\u0438\u0442\u044c").onClick(guiActionButtonClick -> this._d(this._c.selectedStack));
        this._d.setEnabled(false);
        this._d.setVisible(this._a());
        this._b = new eidj(this, new Point(20, this.screenHeight - 184));
        this.addElement(this._b);
        this._a = GuiHelper.addButton(this, 20, this.screenHeight - 108, 200, 40, "\u0423\u043b\u0443\u0447\u0448\u0438\u0442\u044c").onClick(guiActionButtonClick -> this._c(this._b.selectedStack));
        this._a.setEnabled(false);
        if (this.getClass() == gpqn.class) {
            GuiHelper.addLabel((IAdvancedGui)this, "\u0412\u044b \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0435\u0441\u044c \u0432 \u0434\u0435\u043c\u043e\u043d\u0441\u0442\u0440\u0430\u0446\u0438\u043e\u043d\u043d\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435.", new Point(this.guiWidth / 2, 20), 0xFF0000).setCentered(this.screenWidth / 2, 30);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        this._a.setEnabled(this._b.selectedStack != null);
        this._d.setEnabled(this._c.selectedStack != null);
    }

    protected boolean _a() {
        return false;
    }

    @Override
    protected GuiItem.McGuiItem initGuiItem() {
        return new kjui(this, new Point(0, 0), new Dimension(GuiItem.mc._n, GuiItem.mc._o));
    }

    @Override
    protected List<cvzo> getAvailableStacks() {
        return this._h;
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        if (this._e != null) {
            this._f._a(this.getStack(), this._e);
        } else {
            ncwh._b(this.getStack())._p("material");
        }
    }

    protected void _a(cvzo cvzo2) {
        String string;
        String string2 = string = cvzo2 != null ? ((xroo)cvzo2._a())._b() : null;
        if (string != null) {
            this._f._a(this.getStack(), string);
        } else {
            ncwh._b(this.getStack())._p("material");
        }
    }

    protected void _b(cvzo cvzo2) {
    }

    protected void _c(cvzo cvzo2) {
    }

    protected void _d(cvzo cvzo2) {
    }

    private class kjui
    extends GuiItem.McGuiItem {
        private EntityPlayerSP _b;

        public kjui(GuiItem guiItem, Point point, Dimension dimension) {
            super(guiItem, point, dimension);
            xpzm xpzm2 = xpzm._E();
            this._b = new EntityPlayerSP(xpzm2, xpzm2._r, new hanr("Fake", ""), 0);
            this._b.field_71158_b = new kjwj();
            this.xRotationLimit = 0.0f;
            this.zRotationLimit = 0.0f;
            this.rotationY = 60.0f;
        }

        @Override
        public void tick() {
            super.tick();
            ++this._b.field_70173_aa;
        }

        @Override
        protected void drawModel(cvzo cvzo2, float f) {
            this._b.field_71071_by.func_70299_a(38, cvzo2);
            GL11.glTranslatef(0.0f, this._b.field_70131_O / 2.0f, 0.0f);
            gqqu._b._a(this._b, 0.0, 0.0, 0.0, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -this._b.field_70131_O / 2.0f, 0.0f);
        }
    }

    protected class pidb
    extends GuiItem.McSelectSlot {
        pidb(gpqn gpqn3, Point point) {
            super(gpqn3, null, (cvzo cvzo2) -> false);
            this.stackSelector = cvzo2 -> cvzo2._a() instanceof xroo && ((xroo)cvzo2._a())._a().contains(((gpqn)gpqn.this)._f.field_77779_bT) && !Objects.equals(((xroo)cvzo2._a())._b(), gpqn.this._e);
            this.updateStacks();
            this.setLocation(point);
        }

        @Override
        public void drawComponent(Point point, float f) {
            cvzo cvzo2 = this.selectedStack;
            if (cvzo2 != null && cvzo2._a() instanceof xroo) {
                this.renderer.drawString((Object)((Object)ezfc._r) + cvzo2._s(), this.getLocation().x + 76, this.getLocation().y, -1);
            }
            super.drawComponent(point, f);
        }

        @Override
        protected void onChange(cvzo cvzo2) {
            gpqn.this._a(this.selectedStack);
        }
    }

    protected class eidj
    extends GuiItem.McSelectSlot {
        eidj(gpqn gpqn3, Point point) {
            super(gpqn3, null, (cvzo cvzo2) -> cvzo2._a() instanceof bafv);
            this.setLocation(point);
        }

        @Override
        protected void onChange(cvzo cvzo2) {
            gpqn.this._b(cvzo2);
        }

        @Override
        public void drawComponent(Point point, float f) {
            cvzo cvzo2 = this.selectedStack;
            if (cvzo2 != null && cvzo2._a() instanceof bafv) {
                bafv bafv2 = (bafv)cvzo2._a();
                int n = dgmz._a(gpqn.this.getStack(), bafv2);
                Point point2 = this.getLocation();
                int n2 = 76;
                int n3 = -18;
                double d = Math.pow(bafv2._c, n) * 100.0;
                Formatter formatter = new Formatter(Locale.ENGLISH);
                this.renderer.drawString((Object)((Object)ezfc._r) + cvzo2._s(), point2.add(n2, n3 += 18), 0xFFFFFF);
                this.renderer.drawString("\u0422\u0435\u043a\u0443\u0449\u0438\u0439 \u0443\u0440\u043e\u0432\u0435\u043d\u044c: " + n, point2.add(n2, n3 += 18), 0xFFFFFF);
                this.renderer.drawString("\u0428\u0430\u043d\u0441 \u0443\u0441\u043f\u0435\u0445\u0430: " + formatter.format("%.2f", d) + "%", point2.add(n2, n3 += 18), 0xFFFFFF);
                int n4 = cvzo2._j();
                if (n4 > 0) {
                    this.renderer.drawString("\u041f\u0440\u0438 \u043d\u0435\u0443\u0434\u0430\u0447\u0435: -" + n4 + " " + (n4 == 1 ? "\u0443\u0440\u043e\u0432\u0435\u043d\u044c" : "\u0443\u0440\u043e\u0432\u043d\u044f"), point2.add(n2, n3 += 18), 0xFFFFFF);
                }
            }
            super.drawComponent(point, f);
        }
    }
}

