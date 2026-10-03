/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.util.vector.Vector3f;

public abstract class majr
extends GuiItem {
    protected final wolf _a;
    protected final pjux _b;
    protected McButton _c;
    protected McButton _d;
    protected GuiItem.McSelectSlot _e;
    protected ezey _f;
    protected McButton _g;
    protected String _h;

    public majr(GuiScreen guiScreen, ItemStack itemStack) {
        super(guiScreen, itemStack, pjux._a(itemStack._d));
        this._a = (wolf)itemStack._a();
        this._b = (pjux)this.renderItem;
        this.setStack(itemStack);
    }

    @Override
    public void initGui() {
        super.initGui();
        this._e = new zwat(this, new Point(20, this.screenHeight - 224));
        this.addElement(this._e);
        this._d = GuiHelper.addButton(this, 20, this.screenHeight - 104, 200, 40, this._b());
        this._c = GuiHelper.addButton(this, 20, this.screenHeight - 148, 200, 40, "\u0423\u043b\u0443\u0447\u0448\u0438\u0442\u044c");
        this._c();
        this._f = new ezey(this, new Point(20, this.screenHeight - 364));
        this.addElement(this._f);
        this._f.setEnabled(this._a());
        this._f.setVisible(this._a());
        this._g = GuiHelper.addButton(this, 20, this.screenHeight - 285, 200, 40, "\u041f\u043e\u043a\u0440\u0430\u0441\u0438\u0442\u044c").onClick(guiActionButtonClick -> this._c(this._f.selectedStack));
        this._g.setEnabled(false);
        this._g.setVisible(this._a());
        this._d.setEnabled(wolf._E(this.getStack()) > 0);
        this.actionManager.registerActionHandler(this._d, GuiActionButtonClick.class, guiActionButtonClick -> {
            this._d();
            this._d.setEnabled(false);
        });
        this._c.setEnabled(false);
        this.actionManager.registerActionHandler(this._c, GuiActionButtonClick.class, guiActionButtonClick -> this._b(this._e.selectedStack));
    }

    protected boolean _a() {
        return false;
    }

    @Override
    protected GuiItem.McGuiItem initGuiItem() {
        return new pidb(this, new Point(0, 0), new Dimension(GuiItem.mc._n, GuiItem.mc._o));
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this._c.setEnabled(this._e.selectedStack != null);
        this._d.text = this._b();
        this._g.setEnabled(this._f.selectedStack != null);
    }

    @Override
    public void setStack(ItemStack itemStack) {
        super.setStack(itemStack);
        this._h = this._a._i_(itemStack);
    }

    protected void _a(ItemStack itemStack) {
        this._a(itemStack != null ? ((xroo)itemStack._a())._b() : null);
    }

    protected String _b() {
        return "\u0418\u0437\u0432\u043b\u0435\u0447\u044c \u043f\u0430\u0442\u0440\u043e\u043d\u044b (" + wolf._E(this.getStack()) + "/" + this._a._r(this.getStack()) + ")";
    }

    protected void _c() {
        this._a(this._h);
    }

    private void _a(String string) {
        if (string == null) {
            ncwh._b(this.getStack())._p("material");
        } else {
            this._a._a(this.getStack(), string);
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        this._c();
    }

    private boolean _a(dxwc.pidb pidb2, dxwc dxwc2) {
        if (dxwc2 == null || dxwc2._e == null) {
            return true;
        }
        if (!this._b._d._i()) {
            return false;
        }
        jywl jywl2 = ((jxtc)this._b._d._u_()).getSkeleton();
        if (jywl2 == null) {
            return false;
        }
        Vector3f vector3f = pjux._a(this.getStack(), jywl2._e, pidb2);
        if (vector3f == null) {
            return false;
        }
        AxisAlignedBB axisAlignedBB = dxwc2._e._c();
        this._a(axisAlignedBB, dxwc2, pidb2);
        axisAlignedBB._d(vector3f.x, vector3f.y, vector3f.z);
        for (dxwc.pidb pidb3 : dxwc.pidb._x) {
            Object object;
            if (pidb3 == pidb2) continue;
            dxwc dxwc3 = (dxwc)this._a._d(this.getStack(), pidb3);
            if (pidb3._p == pidb2 && (object = (dxwc)this._a._d(this.getStack(), pidb3._p)) instanceof yusn && !((yusn)object)._a(dxwc2, pidb2) || dxwc3 == null || dxwc3._e == null || (object = pjux._a(this.getStack(), jywl2._e, pidb3)) == null) continue;
            AxisAlignedBB axisAlignedBB2 = dxwc3._e._c();
            this._a(axisAlignedBB2, dxwc3, pidb3);
            axisAlignedBB2._d(((Vector3f)object).x, ((Vector3f)object).y, ((Vector3f)object).z);
            if (!axisAlignedBB2._b(axisAlignedBB)) continue;
            return false;
        }
        return true;
    }

    private void _a(AxisAlignedBB axisAlignedBB, dxwc dxwc2, dxwc.pidb pidb2) {
        if (dxwc2._b == dxwc.eidj._e && pidb2._w != 0.0f) {
            jywc._a(axisAlignedBB, pidb2._w, 0.0f, 0.0f, 1.0f);
        }
    }

    protected abstract void _b(ItemStack var1);

    protected abstract void _c(ItemStack var1);

    protected abstract void _d();

    protected abstract void _a(dxwc.pidb var1, ItemStack var2);

    protected abstract void _d(ItemStack var1);

    protected static class kjui
    extends GuiItem.SlotRotator {
        final dxwc.pidb _a;

        public kjui(dxwc.pidb pidb2, zwaw zwaw2) {
            super(pidb2._r, zwaw2);
            this._a = pidb2;
        }

        @Override
        public String getLocalizedName() {
            return this._a._a(((zwaw)this.gui)._b._a);
        }
    }

    protected static class pidb
    extends GuiItem.McGuiItem {
        final majr _a;
        private ItemStack _b;

        public pidb(majr majr2, Point point, Dimension dimension) {
            super(majr2, point, dimension);
            this._a = majr2;
            this.xRotationLimit = 10.0f;
        }

        @Override
        protected void loadSlotPositions(jywl jywl2, ivtm ivtm2) {
            if (!ItemStack._b(this._b, this._a.getStack()) && this._a()) {
                this.resetSlots();
                this._b = this._a.getStack()._l();
            }
            super.loadSlotPositions(jywl2, ivtm2);
        }

        private boolean _a() {
            boolean bl = true;
            for (dxwc.pidb pidb2 : dxwc.pidb._x) {
                dxwc dxwc2 = (dxwc)this._a._a._d(this._a.getStack(), pidb2);
                if (dxwc2 == null) continue;
                bl &= dxwc2._f();
            }
            return bl;
        }

        @Override
        protected void initializeSlots(jywl jywl2, ivtm ivtm2) {
            for (dxwc.pidb pidb2 : dxwc.pidb._x) {
                if (pjux._a(this._a.getStack(), ivtm2, pidb2) == null || !this._a._a._a(this._a.getStack(), pidb2)) continue;
                eidj eidj2 = new eidj(this._a, pidb2, this._a._a._c(this._a.getStack(), pidb2), itemStack -> this._a._a._b(this._a.getStack(), itemStack, pidb2));
                kjui kjui2 = new kjui(pidb2, eidj2);
                this.slots.add(kjui2);
                this._a.addElement(eidj2);
            }
        }

        @Override
        protected jywl getSkeleton() {
            return this._a._b._e(this._a.getStack())._c();
        }

        @Override
        protected Vector3f getSlotPos3D(jywl jywl2, ivtm ivtm2, GuiItem.SlotRotator slotRotator) {
            return pjux._a(this._a.getStack(), ivtm2, ((kjui)slotRotator)._a);
        }

        @Override
        protected void drawModel(ItemStack itemStack, float f) {
            this._a._b._a(null, this._a.getStack(), false, false);
        }
    }

    public static class ezey
    extends zwaw {
        ezey(majr majr2, Point point) {
            super(majr2, null, (ItemStack itemStack) -> false);
            this.stackSelector = itemStack -> itemStack._a() instanceof xroo && ((xroo)itemStack._a())._a().contains(majr2._a.itemID) && !Objects.equals(((xroo)itemStack._a())._b(), majr2._h);
            this.updateStacks();
            this.setLocation(point);
        }

        @Override
        public void drawComponent(Point point, float f) {
            ItemStack itemStack = this.selectedStack;
            if (itemStack != null && itemStack._a() instanceof xroo) {
                this.renderer.drawString((Object)((Object)EnumChatFormatting._r) + itemStack._s(), this.getLocation().x + 76, this.getLocation().y, -1);
            }
            super.drawComponent(point, f);
        }

        @Override
        protected void onChange(ItemStack itemStack) {
            this._b._a(this.selectedStack);
        }
    }

    protected static class zwat
    extends zwaw {
        zwat(majr majr2, Point point) {
            super(majr2, null, (ItemStack itemStack) -> itemStack._a() instanceof stap);
            this.setLocation(point);
        }

        @Override
        protected void onChange(ItemStack itemStack) {
            this._b._d(itemStack);
        }

        @Override
        public void tick() {
            super.tick();
        }

        @Override
        public void drawComponent(Point point, float f) {
            ItemStack itemStack = this.selectedStack;
            if (itemStack != null && itemStack._a() instanceof stap) {
                stap stap2 = (stap)itemStack._a();
                stap stap3 = wolf._b(this._b.getStack(), stap2._b);
                Point point2 = this.getLocation();
                int n = 76;
                int n2 = -18;
                if (stap3 != null && stap3 != stap2) {
                    this.renderer.drawString("\u0423\u0436\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0434\u0440\u0443\u0433\u043e\u0439", point2.add(n, n2 += 18), 0xBB0000);
                    this.renderer.drawString("\u0443\u0441\u0438\u043b\u0438\u0442\u0435\u043b\u044c \u044d\u0442\u043e\u0433\u043e \u0442\u0438\u043f\u0430!", point2.add(n, n2 += 18), 0xBB0000);
                } else {
                    int n3 = wolf._a(this._b.getStack(), stap2);
                    double d = Math.pow(stap2._d, n3) * 100.0;
                    Formatter formatter = new Formatter(Locale.ENGLISH);
                    this.renderer.drawString((Object)((Object)EnumChatFormatting._r) + itemStack._s(), point2.add(n, n2 += 18), 0xFFFFFF);
                    this.renderer.drawString("\u0422\u0435\u043a\u0443\u0449\u0438\u0439 \u0443\u0440\u043e\u0432\u0435\u043d\u044c: " + n3, point2.add(n, n2 += 18), 0xFFFFFF);
                    this.renderer.drawString("\u0428\u0430\u043d\u0441 \u0443\u0441\u043f\u0435\u0445\u0430: " + formatter.format("%.2f", d) + "%", point2.add(n, n2 += 18), 0xFFFFFF);
                    int n4 = itemStack._j();
                    if (n4 > 0) {
                        this.renderer.drawString("\u041f\u0440\u0438 \u043d\u0435\u0443\u0434\u0430\u0447\u0435: -" + n4 + " " + (n4 == 1 ? "\u0443\u0440\u043e\u0432\u0435\u043d\u044c" : "\u0443\u0440\u043e\u0432\u043d\u044f"), point2.add(n, n2 += 18), 0xFFFFFF);
                    }
                }
            }
            super.drawComponent(point, f);
        }
    }

    protected static class eidj
    extends zwaw {
        final dxwc.pidb _a;

        eidj(majr majr2, dxwc.pidb pidb2, ItemStack itemStack, Predicate<ItemStack> predicate) {
            super(majr2, itemStack, predicate);
            this._a = pidb2;
        }

        @Override
        protected void onChange(ItemStack itemStack) {
            this._b._a(this._a, this.selectedStack);
            Minecraft._E()._N._a("weapons:attachment", 1.0f, 1.0f);
        }

        @Override
        public boolean canStackBeSelected(ItemStack itemStack) {
            if (itemStack != null && itemStack._a() instanceof dxwc) {
                return this._b._a(this._a, (dxwc)itemStack._a());
            }
            return true;
        }
    }

    protected static abstract class zwaw
    extends GuiItem.McSelectSlot {
        protected final majr _b;

        zwaw(majr majr2, ItemStack itemStack, Predicate<ItemStack> predicate) {
            super(majr2, itemStack, predicate);
            this._b = majr2;
        }
    }
}

