/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiActionHandler;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionRadiopanelSwitch;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTabSwitch;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiPlayer;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.shop.ShopMod;
import gloomyfolken.mods.shop.data.ShopCategory;
import gloomyfolken.mods.shop.data.ShopData;
import gloomyfolken.mods.shop.data.ShopEntry;
import gloomyfolken.mods.shop.data.ShopItem;
import gloomyfolken.mods.shop.data.ShopKit;
import gloomyfolken.mods.shop.data.ShopSubCategory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ivwa
extends GuiScreenAdvanced
implements zxgf.kjui {
    protected static final ResourceLocation _a = new ResourceLocation("shop", "textures/gui/shop_background.png");
    protected static final ResourceLocation _b = new ResourceLocation("shop", "textures/gui/shop_widgets.png");
    protected static final GuiRenderer _c = new GuiRendererBuilder().setTextureSize(1024, 512).create();
    protected static final GuiRenderer _d = new GuiRendererBuilder().setTextureSize(256, 256).create();
    public static final ComponentCheckboxStyle _e = new ComponentCheckboxStyle(){
        {
            this.setTexture(_b);
            this.setSize(246, 80);
            this.setDefaultUv(0, 160);
            this.setActiveUv(0, 80);
            this.setMouseOverUv(0, 0);
            this.setBorderSizeX(99);
            this.setBorderSizeY(25);
        }
    };
    protected McTabPane _f;
    protected GuiComponentsList _g;
    protected McRadioGroup _h;
    protected McGuiPlayer _i;
    protected McScrollPane _j;
    protected GuiComponentsList<McToolTip> _k;
    protected McTextField _l;
    protected McLabel _m;
    protected McRadioGroup _n;
    protected McLabel _o;
    protected int _p = -1;
    protected kjui _q = kjui._a;

    public ivwa(GuiScreen guiScreen) {
        super(GuiHelper.widgetsRenderer, 800, 496, guiScreen);
    }

    @Override
    public void initGui() {
        int n = this._f == null ? 0 : this._f.getActiveTabIndex();
        int n2 = this._h == null ? 0 : this._h.getActiveElementIndex();
        McBackground mcBackground = new McBackground(this, new Point(this.guiLeft, this.guiTop + 32), new Dimension(800, 456));
        mcBackground.setHasBackground(true).setTexture(_a).setRenderer(_c);
        this._i = new McGuiPlayer(this, this.guiLeft + 20, this.guiTop + 84, 238, 304, 60.0f);
        this._o = new McLabel((IAdvancedGui)this, this._e(), this.guiLeft + 52, this.guiTop + 412);
        this.setBalance(this._p);
        this.elementsList.addAll(new GuiComponent[]{mcBackground, this._i, this._o});
        this._c();
        this._a();
        this._a(n, n2);
        new braz().sendToServer();
    }

    protected void _a() {
        this._l = new McTextField(this, this.guiLeft + 276, this.guiTop + 442, 250, 32);
        this._l.setMaxStringLength(64);
        this._l.tipText = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435...";
        this.addElement(this._l);
        this.actionManager.registerActionHandler(this._l, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this._d());
        this._m = new McLabel((IAdvancedGui)this, "\u041d\u0438\u0447\u0435\u0433\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e", this.guiLeft + 312, this.guiTop + 412);
        this.addElement(this._m);
        this._n = new McRadioGroup(this);
        this.addElement(this._n);
        ComponentCheckboxStyle componentCheckboxStyle = new ComponentCheckboxStyle(){
            {
                this.setSize(16, 16);
                this.setTexture(GuiHelper.widgets);
                this.setDefaultUv(16, 192);
                this.setDisabledUv(16, 208);
                this.setMouseOverUv(16, 224);
                this.setActiveUv(16, 240);
            }
        };
        this._n.addElement(new McRadioButton(this._n, "\u0413\u043b\u043e\u0431\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u043e\u0438\u0441\u043a", this.guiLeft + 534, this.guiTop + 412, componentCheckboxStyle));
        this._n.addElement(new McRadioButton(this._n, "\u041f\u043e\u0438\u0441\u043a \u043f\u043e \u0440\u0430\u0437\u0434\u0435\u043b\u0443", this.guiLeft + 534, this.guiTop + 432, componentCheckboxStyle));
        this._n.addElement(new McRadioButton(this._n, "\u041f\u043e\u0438\u0441\u043a \u043f\u043e \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0443", this.guiLeft + 534, this.guiTop + 452, componentCheckboxStyle));
        this._n.setActiveButton(this._n.getRadioElement(0));
        this.actionManager.registerActionHandler(this._n, GuiActionRadiopanelSwitch.class, new IActionHandler<GuiActionRadiopanelSwitch>(){

            public void _a(GuiActionRadiopanelSwitch guiActionRadiopanelSwitch) {
                ivwa.this._q = kjui.values()[((McRadioGroup)guiActionRadiopanelSwitch.component).getActiveElementIndex()];
                ivwa.this._d();
            }

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionRadiopanelSwitch)guiAction);
            }
        });
    }

    protected void _b() {
        List<ShopEntry> list = new ArrayList<ShopEntry>();
        ShopData shopData = ShopMod._a();
        String string = this._l.getText().toLowerCase();
        if (!string.isEmpty()) {
            switch (this._q) {
                case _a: {
                    list = this._a(string);
                    break;
                }
                case _b: {
                    int n = this._f.getActiveTabIndex();
                    if (n == -1) break;
                    list = this._a(string, shopData.categories.get(n));
                    break;
                }
                case _c: {
                    if (this._h == null) break;
                    int n = this._f.getActiveTabIndex();
                    int n2 = this._h.getActiveElementIndex();
                    if (n == -1 || n2 == -1) break;
                    list = this._a(string, shopData.categories.get((int)n).subCategories.get(n2));
                }
            }
        }
        this._a(list);
        this._m.setText(list.size() == 0 ? "\u041d\u0438\u0447\u0435\u0433\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e" : "\u041d\u0430\u0439\u0434\u0435\u043d\u043e: " + list.size());
    }

    protected List<ShopEntry> _a(String string) {
        ArrayList<ShopEntry> arrayList = new ArrayList<ShopEntry>();
        for (ShopCategory shopCategory : ShopMod._a().categories) {
            arrayList.addAll(this._a(string, shopCategory));
        }
        return arrayList;
    }

    protected List<ShopEntry> _a(String string, ShopCategory shopCategory) {
        ArrayList<ShopEntry> arrayList = new ArrayList<ShopEntry>();
        for (ShopSubCategory shopSubCategory : shopCategory.subCategories) {
            arrayList.addAll(this._a(string, shopSubCategory));
        }
        return arrayList;
    }

    protected List<ShopEntry> _a(String string, ShopSubCategory shopSubCategory) {
        ArrayList<ShopEntry> arrayList = new ArrayList<ShopEntry>();
        for (ShopEntry shopEntry : shopSubCategory.entries) {
            if (!shopEntry._a().toLowerCase().contains(string)) continue;
            arrayList.add(shopEntry);
        }
        return arrayList;
    }

    protected void _c() {
        McButton mcButton = GuiHelper.addButton(this, this.guiLeft + 14, this.guiTop + 440, 250, 36, "\u041f\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u0441\u0447\u0435\u0442");
        this.actionManager.registerActionHandler(mcButton, GuiActionButtonClick.class, new IActionHandler(){

            public void processAction(GuiAction guiAction) {
                ivwa.this.mc._a(new mrbt(ivwa.this));
            }
        });
    }

    protected void _a(int n, int n2) {
        ShopData shopData = ShopMod._a();
        ArrayList<String> arrayList = new ArrayList<String>(shopData.categories.size());
        for (ShopCategory shopCategory : shopData.categories) {
            arrayList.add(shopCategory.name);
        }
        this._f = shopData.scrollableTabPane ? GuiHelper.createScrollableTabPane(this, new Point(this.guiLeft + 20, this.guiTop), arrayList, shopData.resizeTabs, shopData.tabResizeBorder, 760) : GuiHelper.createTabPane(this, new Point(this.guiLeft + 20, this.guiTop), arrayList, shopData.resizeTabs, shopData.tabResizeBorder);
        if (this._f.getNumTabs() > 0) {
            this._f.setActiveTab(this._f.getTab(n));
            this._a(n2);
        }
        this.addElement(this._f);
    }

    @GuiActionHandler
    public void _a(GuiActionTabSwitch guiActionTabSwitch) {
        int n = this._f.getActiveTabIndex();
        if (n >= 0 && n < this._f.getNumTabs()) {
            this._a(0);
        }
    }

    protected void _a(int n) {
        if (this._g != null) {
            this.removeElement(this._g);
        }
        this._g = new GuiComponentsList(this);
        this._h = new McRadioGroup(this);
        int n2 = this.guiLeft + 32;
        int n3 = this.guiTop + 44;
        int n4 = this._f.getActiveTabIndex();
        ShopCategory shopCategory = ShopMod._a().categories.get(n4);
        for (ShopSubCategory shopSubCategory : shopCategory.subCategories) {
            McRadioLabel mcRadioLabel = new McRadioLabel(this._h, shopSubCategory.name, new Point(n2, n3));
            this._h.addElement(mcRadioLabel);
            n2 += mcRadioLabel.getSize().width + 4;
            if (shopSubCategory == shopCategory.subCategories.get(shopCategory.subCategories.size() - 1)) continue;
            McImage mcImage = new McImage((IAdvancedGui)this, new Point(n2, n3), new Point(246, 0), new Dimension(4, 20), _b);
            mcImage.setRenderer(_d);
            mcImage.blending = true;
            n2 += 10;
            this._g.addElement(mcImage);
        }
        this._g.addElement(this._h);
        this.addElement(this._g);
        if (this._h.getElements().size() > 0) {
            this._h.setActiveButton(n);
        }
        this._d();
        this.actionManager.registerActionHandler(this._h, GuiActionRadiopanelSwitch.class, new IActionHandler(){

            public void processAction(GuiAction guiAction) {
                ivwa.this._d();
            }
        });
    }

    private void _d() {
        if (this._l != null && !this._l.getText().isEmpty()) {
            this._b();
        } else {
            int n = this._f.getActiveTabIndex();
            int n2 = this._h.getActiveElementIndex();
            if (n != -1 && n2 != -1) {
                this._a(new ArrayList<ShopEntry>(ShopMod._a().categories.get((int)n).subCategories.get((int)n2).entries));
            } else {
                this._a((List<ShopEntry>)null);
            }
            if (this._m != null) {
                this._m.setText("\u041d\u0438\u0447\u0435\u0433\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e");
            }
        }
    }

    private void _a(List<ShopEntry> list) {
        if (this._j != null) {
            this.removeElement(this._j);
            this._j = null;
        }
        if (this._k != null) {
            this.removeElement(this._k);
            this._k = null;
        }
        if (this._i != null) {
            this._i.clearPreviewItems();
        }
        if (list == null) {
            return;
        }
        list.sort(Comparator.comparing(shopEntry -> shopEntry instanceof ShopItem));
        int n = list.size() / 2 + list.size() % 2;
        this._j = GuiHelper.addScrollPane(this, this.guiLeft + 272, this.guiTop + 74, 522, 324, 522, 83 * n);
        this._k = new GuiComponentsList(this);
        int n2 = 0;
        for (int i = 0; i < list.size(); ++i) {
            ShopEntry shopEntry2 = list.get(i);
            dggk dggk2 = null;
            int n3 = n2 % 2 * 256;
            int n4 = n2 / 2 * 83;
            if (shopEntry2 instanceof ShopItem) {
                dggk2 = new zgfl(this, (ShopItem)shopEntry2, n3, n4);
                ++n2;
            } else {
                if (!(shopEntry2 instanceof ShopKit)) continue;
                dggk2 = new jyyl(this, (ShopKit)shopEntry2, n3 + 5, n4 + 10);
                n2 += 2;
            }
            this._j.getViewport().addElement(dggk2);
            McToolTip mcToolTip = dggk2._d();
            if (mcToolTip == null) continue;
            this._k.addElement(mcToolTip);
        }
        this.addElement(this._k);
    }

    public void _a(dggk dggk2) {
        this._i.clearPreviewItems();
        if (dggk2._b()) {
            for (Object object : this._j.getViewport().getElements()) {
                if (!(object instanceof dggk) || object == dggk2) continue;
                dggk object2 = (dggk)object;
                object2._a(false);
            }
            Map<Integer, ItemStack> map = dggk2._c();
            for (Map.Entry entry : map.entrySet()) {
                this._i.setPreviewItem((Integer)entry.getKey(), (ItemStack)entry.getValue());
            }
        }
    }

    @Override
    public void setBalance(int n) {
        this._p = n;
        this._o.setText(this._e());
        if (this._j != null) {
            for (GuiComponent guiComponent : this._j.getViewport().getElements()) {
                dggk dggk2;
                if (!(guiComponent instanceof dggk)) continue;
                dggk2.setEnabled(n >= ((ShopEntry)(dggk2 = (dggk)guiComponent)._a())._c());
            }
        }
    }

    private String _e() {
        if (this._p != -1) {
            return this._p + " " + ShopMod._a().currencyName;
        }
        return "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430...";
    }

    protected static enum kjui {
        _a,
        _b,
        _c;

    }
}

