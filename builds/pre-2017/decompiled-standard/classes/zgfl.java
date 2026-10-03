/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.shop.ShopMod;
import gloomyfolken.mods.shop.data.ShopEntry;
import gloomyfolken.mods.shop.data.ShopItem;
import java.util.Collections;
import java.util.Map;
import net.minecraft.util.ezfc;

public class zgfl
extends dggk<ShopItem> {
    private ShopItem _d;
    protected McCheckBox _a;
    protected McDummySlot _b;
    protected McButton _c;

    public zgfl(ivwa ivwa2, ShopItem shopItem, int n, int n2) {
        super(ivwa2, shopItem, n, n2);
    }

    @Override
    protected void _a(ivwa ivwa2, ShopItem shopItem, int n, int n2) {
        this._d = shopItem;
        this._a = new McCheckBox(ivwa2, null, 0, 0, ivwa._e);
        this.addElement(this._a);
        this._a.setRenderer(ivwa._d);
        ivwa2.getActionManager().registerActionHandler(this._a, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> ivwa2._a(this));
        Point point = new Point(4, 6);
        Dimension dimension = new Dimension(72, 72);
        Point point2 = new Point(148, 0);
        this.addElement(new McImage((IAdvancedGui)ivwa2, point, point2, dimension, GuiHelper.widgets));
        this.addElement(new McLabel((IAdvancedGui)ivwa2, shopItem._a(), 82, 4).setMaxWidth(164));
        boolean bl = shopItem.discount != 0;
        String string = shopItem.price + " " + ShopMod._a().currencyName;
        if (bl) {
            string = (Object)((Object)ezfc._m) + (Object)((Object)ezfc._s) + string;
            this.addElement(new McLabel((IAdvancedGui)ivwa2, shopItem._c() + " " + ShopMod._a().currencyName, 92 + GuiComponent.hdRenderer.getStringWidth(string), 8 + GuiComponent.hdRenderer.getFontHeight()));
        }
        this.addElement(new McLabel((IAdvancedGui)ivwa2, string, 82, 8 + GuiComponent.hdRenderer.getFontHeight()));
        this._c = GuiHelper.addButton(this, 82, 10 + GuiComponent.hdRenderer.getFontHeight() * 2, 156, 30, "\u041a\u0443\u043f\u0438\u0442\u044c");
        this._c.setEnabled(ivwa2._p >= shopItem._c());
        ivwa2.getActionManager().registerActionHandler(this._c, GuiActionButtonClick.class, guiActionButtonClick -> new pjid(shopItem.entryId).sendToServer());
        this._b = new McDummySlot(ivwa2, shopItem.stack._a(), 8, 8, 2.0f);
        this.addElement(this._b);
    }

    public ShopItem _e() {
        return this._d;
    }

    @Override
    public Map<Integer, cvzo> _c() {
        return Collections.singletonMap(this._d._e(), this._d.stack._a());
    }

    @Override
    public McToolTip _d() {
        return this._b.createToolTip();
    }

    @Override
    public void _a(boolean bl) {
        this._a.setActive(bl);
    }

    @Override
    public boolean _b() {
        return this._a.getActive();
    }

    @Override
    public void setEnabled(boolean bl) {
        this._c.setEnabled(bl);
    }

    @Override
    public /* synthetic */ ShopEntry _a() {
        return this._e();
    }
}

