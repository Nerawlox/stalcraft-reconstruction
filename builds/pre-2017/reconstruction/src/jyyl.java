/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import gloomyfolken.mods.shop.ShopMod;
import gloomyfolken.mods.shop.data.ShopEntry;
import gloomyfolken.mods.shop.data.ShopKit;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class jyyl
extends dggk<ShopKit> {
    private static final int _a = 496;
    private static final ResourceLocation _b = new ResourceLocation("shop", "textures/gui/kit.png");
    private static final GuiRenderer _c = new GuiRendererBuilder().setTextureSize(512, 256).create();
    private static final ComponentSliderBarStyle _d = new ComponentSliderBarStyle(){
        {
            this.horizontalBarStyle = new ComponentButtonStyle(){
                {
                    this.setTexture(_b);
                    this.setSize(18, 7);
                    this.setDefaultUv(1, 157);
                    this.setActiveUv(this.getDefaultUv());
                    this.setMouseOverUv(this.getDefaultUv());
                }
            };
        }
    };
    private ShopKit _e;
    private McButton _f;
    private McScrollPane _g;
    private boolean _h = false;
    private boolean _i = true;
    private int _j = 15;
    private int _k = 0;
    private boolean _l = false;

    public jyyl(ivwa ivwa2, ShopKit shopKit, int n, int n2) {
        super(ivwa2, shopKit, n, n2);
    }

    @Override
    protected void _a(ivwa ivwa2, ShopKit shopKit, int n, int n2) {
        this._e = shopKit;
        this._a(this, Point.zeroPoint, new Point(1, 82), new Dimension(496, 74));
        boolean bl = this._e.discount != 0;
        String string = ShopMod._a().currencyName;
        String string2 = String.valueOf(shopKit.price);
        if (bl) {
            string2 = (Object)((Object)EnumChatFormatting._m) + (Object)((Object)EnumChatFormatting._s) + string2 + (Object)((Object)EnumChatFormatting._v) + " " + this._e._c();
        }
        string2 = string2 + " " + string;
        this.addElement(new McLabel((IAdvancedGui)ivwa2, string2, new Point(416, 20)).setCentered());
        this._a(ivwa2);
        this._f = GuiHelper.addButton(this, 339, 38, 154, 32, "\u041a\u0443\u043f\u0438\u0442\u044c").onClick(guiActionButtonClick -> this._g());
        if (this._e._a() != null) {
            this._a(this, new Point(120, -9), new Point(241, 64), new Dimension(256, 17));
            this.addElement(new McLabel((IAdvancedGui)ivwa2, this._e._a(), new Point(248, -8)).setCentered());
        }
    }

    private void _g() {
        new pjid(this._e.entryId).sendToServer();
        this._k = 15;
    }

    private void _a(ivwa ivwa2) {
        int n = 0;
        Dimension dimension = new Dimension(54, 54);
        this._g = GuiHelper.createScrollPane((IAdvancedGui)ivwa2, new Point(0, 8), new Dimension(340, 63), new Dimension(this._e.stacks.size() * (dimension.width + 2) + 10, 60), true, _d, new ComponentScrollButtonStyle());
        for (wnce wnce2 : this._e.stacks) {
            Point point = new Point(n * (dimension.width + 2) + 2 + 10, 0);
            this._a(this._g.getViewport(), point, new Point(260, 202), dimension);
            McDummySlot mcDummySlot = new McDummySlot(ivwa2, wnce2._a(), point.x + 3, point.y + 3, (float)dimension.width / 36.0f);
            this._g.getViewport().addElement(mcDummySlot);
            ivwa2._k.addElement(mcDummySlot.createToolTip());
            ++n;
        }
        this._g.initControls();
        McScrollBar mcScrollBar = this._g.getHorizontalScrollBar();
        if (mcScrollBar != null) {
            mcScrollBar.setBackgroundImage(_b, new Point(21, 159), new Dimension(221, 5), 0);
            mcScrollBar.setSize(mcScrollBar.getSize().add(0, -2));
            mcScrollBar.setSliderLength(17);
            mcScrollBar.setRenderer(_c);
            mcScrollBar.move(6, 0);
        }
        this.addElement(this._g);
    }

    private void _a(GuiComponentsList guiComponentsList, Point point, Point point2, Dimension dimension) {
        McImage mcImage = new McImage(this.parent, point, point2, dimension, _b);
        guiComponentsList.addElement(mcImage);
        mcImage.setRenderer(_c);
        mcImage.noMouseInteraction = true;
    }

    @Override
    public void tick() {
        super.tick();
        --this._k;
        Point point = this.getAbsoluteLocation();
        Point point2 = GuiHelper.getCursorPos(this.parent);
        McScrollBar mcScrollBar = this._g.getHorizontalScrollBar();
        if (mcScrollBar != null && !mcScrollBar.mouseDown && Mouse.isButtonDown(0) && jyyl.isMouseInBounds(point2, point, point.add(340, 70))) {
            int n = point.x + 170;
            float f = (float)(point2.x - n) / 1500.0f;
            mcScrollBar.pos = sajh._a(mcScrollBar.pos + f, 0.0f, 1.0f);
            this._l = true;
        } else {
            this._l = false;
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        Point point2 = this.getAbsoluteLocation();
        Point point3 = GuiHelper.getCursorPos(this.parent);
        this._h = jyyl.isMouseInBounds(point3, point2, point2.add(496, 80));
        if (this._h == this._i) {
            this._i = !this._i;
            this._j = 0;
        }
        ++this._j;
        float f2 = Math.min((float)this._j / 15.0f, 1.0f);
        float f3 = this._k > 0 ? (float)Math.abs(Math.cos((double)(((float)this._k - f) / 15.0f) * Math.PI)) : (this._i ? 1.0f - f2 : f2);
        this._a(point2.add(-5, -10), 1.0f, 1.0f, 1.0f, f3);
        if (this._l) {
            this.parent.getElementsList().updateElementMouseOver(Point.zeroPoint);
        }
    }

    private void _a(Point point, float f, float f2, float f3, float f4) {
        _c.bindTexture(_b);
        GL11.glColor4f(f, f2, f3, 1.0f);
        _c.drawTexturedModalRect(point.x + 336, point.y + 14, 30, 1, 166, 64);
        _c.drawTexturedModalRect(point.x, point.y + 12, 1, 1, 18, 74);
        GL11.glColor4f(f, f2, f3, f4);
        _c.drawTexturedModalRect(point.x + 336, point.y + 14, 30, 169, 166, 64);
        _c.drawTexturedModalRect(point.x, point.y + 12, 1, 167, 18, 74);
    }

    public ShopKit _e() {
        return this._e;
    }

    @Override
    public Map<Integer, ItemStack> _c() {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        for (wnce wnce2 : this._e.stacks) {
            ItemStack itemStack = wnce2._a();
            Item item = itemStack._a();
            if (item instanceof ItemArmor) {
                hashMap.put(39 - ((ItemArmor)item).armorType, itemStack);
                continue;
            }
            hashMap.put(0, itemStack);
        }
        return hashMap;
    }

    @Override
    public void _a(boolean bl) {
    }

    @Override
    public McToolTip _d() {
        return null;
    }

    @Override
    public boolean _b() {
        return true;
    }

    @Override
    public void setEnabled(boolean bl) {
        this._f.setEnabled(bl);
    }

    @Override
    public /* synthetic */ ShopEntry _a() {
        return this._e();
    }
}

