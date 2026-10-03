/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.misc.hanr;
import net.minecraft.item.ItemStack;

public class rplo
extends GuiComponentsList {
    public final ItemStack _a;
    protected final McDummySlot _b;
    private int _c = -1;

    public rplo(GuiScreenAdvanced guiScreenAdvanced, ItemStack itemStack, int n, int n2) {
        super(guiScreenAdvanced);
        this._a = itemStack;
        hanr hanr2 = hanr._b(itemStack);
        if (hanr2 != hanr._a) {
            this._c = hanr2._l;
        }
        Point point = new Point(n, n2);
        Dimension dimension = new Dimension(72, 72);
        Point point2 = new Point(147, 0);
        McImage mcImage = new McImage((IAdvancedGui)guiScreenAdvanced, point, point2, dimension, GuiHelper.widgets);
        mcImage.setRenderer(GuiHelper.widgetsRenderer);
        this.addElement(mcImage);
        this._b = new McDummySlot(guiScreenAdvanced, this._a, n + 4, n2 + 4, 2.0f);
        this.addElement(this._b);
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        if (this._c != -1) {
            Point point2 = this._b.getAbsoluteLocation();
            Dimension dimension = new Dimension(72, 72);
            int n = -1442840576;
            this.renderer.drawGradientRect(point2.x - 2, point2.y - 4 + dimension.height - 10, dimension.width - 2, 10.0, this._c, this._c | n);
        }
    }

    public McToolTip _a() {
        return this._b.createToolTip();
    }
}

