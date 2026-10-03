/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class fmns
extends GuiItem {
    public final EntityPlayer _a;
    public final brhe _b;
    private final int _c;

    public fmns(GuiScreen guiScreen, EntityPlayer entityPlayer, int n) {
        super(guiScreen, entityPlayer.openContainer.getSlot(n).getStack(), anoq._a(entityPlayer.openContainer.getSlot(n).getStack()._a()));
        this._a = entityPlayer;
        this._c = n;
        this._b = (brhe)this.getStack()._a();
    }

    @Override
    public void initGui() {
        super.initGui();
        Point point = new Point(this.screenWidth / 2 - this._b._d * 40 + 4, this.screenHeight - 80);
        for (int i = 0; i < this._b._d; ++i) {
            kjui kjui2 = new kjui(this, point, i, this._b._c(this.getStack(), Integer.valueOf(i)));
            this.addElement(kjui2);
            point = point.add(80, 0);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ItemStack itemStack = this._a.openContainer.getSlot(this._c).getStack();
        if (this.getStack() != itemStack) {
            if (this.getStack() != null && itemStack != null && this.getStack()._d == itemStack._d) {
                this.setStack(itemStack);
            } else {
                this.closeScreen();
            }
        }
    }

    protected void _a(int n, ItemStack itemStack) {
        int n2 = ncwh._a(this._a.inventory, itemStack);
        new kkpg(this._c, n2, n).sendToServer();
        brhe._a(this._a, this._c, n2, n);
    }

    @Override
    protected List<ItemStack> getAvailableStacks() {
        return Lists.newArrayList(this._a.inventory._a);
    }

    protected static class kjui
    extends GuiItem.McSelectSlot {
        final fmns _a;
        final int _b;

        kjui(fmns fmns2, Point point, int n, ItemStack itemStack2) {
            super(fmns2, itemStack2, (ItemStack itemStack) -> itemStack._a() instanceof cdit && ((cdit)itemStack._a())._a((ItemStack)itemStack));
            this._a = fmns2;
            this._b = n;
            this.setLocation(point);
        }

        @Override
        protected void onChange(ItemStack itemStack) {
            this._a._a(this._b, itemStack);
            Minecraft._E()._N._a("stalker:inv_backpack", 1.0f, 1.0f);
        }
    }
}

