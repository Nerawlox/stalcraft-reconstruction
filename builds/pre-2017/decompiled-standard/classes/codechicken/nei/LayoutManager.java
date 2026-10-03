/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Button;
import codechicken.nei.ButtonCycled;
import codechicken.nei.DropDownWidget;
import codechicken.nei.GuiExtendedCreativeInv;
import codechicken.nei.Image;
import codechicken.nei.ItemList;
import codechicken.nei.ItemPanel;
import codechicken.nei.ItemQuantityField;
import codechicken.nei.KeyManager;
import codechicken.nei.Label;
import codechicken.nei.LayoutStyleMinecraft;
import codechicken.nei.LayoutStyleTMIOld;
import codechicken.nei.NEIActions;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIController;
import codechicken.nei.SaveLoadButton;
import codechicken.nei.SearchField;
import codechicken.nei.TextField;
import codechicken.nei.VisiblityData;
import codechicken.nei.Widget;
import codechicken.nei.WidgetZOrder;
import codechicken.nei.api.API;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.api.LayoutStyle;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.forge.IContainerDrawHandler;
import codechicken.nei.forge.IContainerInputHandler;
import codechicken.nei.forge.IContainerObjectHandler;
import codechicken.nei.forge.IContainerTooltipHandler;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class LayoutManager
implements KeyManager.IKeyStateTracker,
IContainerDrawHandler,
IContainerInputHandler,
IContainerObjectHandler,
IContainerTooltipHandler {
    private static LayoutManager instance;
    private static Widget inputFocused;
    private static TreeSet<Widget> drawWidgets;
    private static TreeSet<Widget> controlWidgets;
    public static ItemPanel itemPanel;
    public static DropDownWidget dropDown;
    public static TextField searchField;
    public static Button options;
    public static Button prev;
    public static Button next;
    public static Label pageLabel;
    public static Button more;
    public static Button less;
    public static ItemQuantityField quantity;
    public static SaveLoadButton[] stateButtons;
    public static Button[] deleteButtons;
    public static Button delete;
    public static ButtonCycled gamemode;
    public static Button rain;
    public static Button magnet;
    public static Button[] timeButtons;
    public static Button heal;
    public static IRecipeOverlayRenderer overlayRenderer;
    public static HashMap<Integer, LayoutStyle> layoutStyles;

    public static void load() {
        API.addLayoutStyle(0, new LayoutStyleMinecraft());
        API.addLayoutStyle(1, new LayoutStyleTMIOld());
        instance = new LayoutManager();
        KeyManager.trackers.add(instance);
        GuiContainerManager.addInputHandler(instance);
        GuiContainerManager.addTooltipHandler(instance);
        GuiContainerManager.addDrawHandler(instance);
        GuiContainerManager.addObjectHandler(instance);
        LayoutManager.init();
    }

    @Override
    public void onPreDraw(zybc zybc2) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled() && zybc2 instanceof lpaq) {
            zybc2.field_74198_m = (zybc2.field_73880_f - zybc2.field_74194_b) / 2;
            zybc2.field_74197_n = (zybc2.field_73881_g - zybc2.field_74195_c) / 2;
            if (zybc2 instanceof qngy && zybc2.field_73887_h.size() >= 2) {
                jiok jiok2 = (jiok)zybc2.field_73887_h.get(0);
                jiok jiok3 = (jiok)zybc2.field_73887_h.get(1);
                jiok2.field_73746_c = zybc2.field_74198_m;
                jiok3.field_73746_c = zybc2.field_74198_m + zybc2.field_74194_b - 20;
            }
        }
    }

    @Override
    public void onMouseClicked(zybc zybc2, int n, int n2, int n3) {
        if (NEIClientConfig.isHidden()) {
            return;
        }
        for (Widget widget : controlWidgets) {
            widget.onGuiClick(n, n2);
        }
    }

    @Override
    public boolean mouseClicked(zybc zybc2, int n, int n2, int n3) {
        if (NEIClientConfig.isHidden()) {
            return false;
        }
        if (!NEIClientConfig.isEnabled()) {
            return options.contains(n, n2) && options.handleClick(n, n2, n3);
        }
        for (Widget widget : controlWidgets) {
            widget.onGuiClick(n, n2);
            if (!(widget.contains(n, n2) ? widget.handleClick(n, n2, n3) : widget.handleClickExt(n, n2, n3))) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean objectUnderMouse(zybc zybc2, int n, int n2) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled()) {
            for (Widget widget : controlWidgets) {
                if (!widget.contains(n, n2)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean keyTyped(zybc zybc2, char c, int n) {
        if (NEIClientConfig.isEnabled() && !NEIClientConfig.isHidden()) {
            if (inputFocused != null) {
                return inputFocused.handleKeyPress(n, c);
            }
            for (Widget widget : controlWidgets) {
                if (!widget.handleKeyPress(n, c)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void onKeyTyped(zybc zybc2, char c, int n) {
    }

    @Override
    public boolean lastKeyTyped(zybc zybc2, char c, int n) {
        if (n == NEIClientConfig.getKeyBinding("gui.hide")) {
            NEIClientConfig.toggleBooleanSetting("inventory.hidden");
            return true;
        }
        if (NEIClientConfig.isEnabled() && !NEIClientConfig.isHidden()) {
            for (Widget widget : controlWidgets) {
                if (inputFocused != null) continue;
                widget.lastKeyTyped(n, c);
            }
        }
        return false;
    }

    @Override
    public void onMouseUp(zybc zybc2, int n, int n2, int n3) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled()) {
            for (Widget widget : controlWidgets) {
                widget.mouseUp(n, n2, n3);
            }
        }
    }

    @Override
    public void onMouseDragged(zybc zybc2, int n, int n2, int n3, long l) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled()) {
            for (Widget widget : controlWidgets) {
                widget.mouseDragged(n, n2, n3, l);
            }
        }
    }

    @Override
    public cvzo getStackUnderMouse(zybc zybc2, int n, int n2) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled()) {
            for (Widget widget : controlWidgets) {
                cvzo cvzo2 = widget.getStackMouseOver(n, n2);
                if (cvzo2 == null) continue;
                return cvzo2;
            }
        }
        return null;
    }

    @Override
    public void renderObjects(zybc zybc2, int n, int n2) {
        if (!NEIClientConfig.isHidden()) {
            LayoutManager.layout(zybc2);
            if (NEIClientConfig.isEnabled()) {
                LayoutManager.getLayoutStyle().drawBackground(zybc2.manager);
                for (Widget widget : drawWidgets) {
                    widget.draw(n, n2);
                }
            } else {
                options.draw(n, n2);
            }
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
    }

    @Override
    public void postRenderObjects(zybc zybc2, int n, int n2) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled()) {
            for (Widget widget : drawWidgets) {
                widget.postDraw(n, n2);
            }
        }
    }

    @Override
    public List<String> handleTooltipFirst(zybc zybc2, int n, int n2, List<String> list2) {
        if (!NEIClientConfig.isHidden() && NEIClientConfig.isEnabled() && zybc2.manager.shouldShowTooltip()) {
            for (Widget widget : controlWidgets) {
                list2 = widget.handleTooltip(n, n2, list2);
            }
        }
        return list2;
    }

    @Override
    public List<String> handleItemTooltip(zybc zybc2, cvzo cvzo2, List<String> list2) {
        String string = ItemInfo.getOverrideName(cvzo2._d, cvzo2._j());
        if (string != null) {
            list2.set(0, string);
        }
        String string2 = list2.get(0);
        if (NEIClientConfig.showIDs()) {
            string2 = string2 + " " + cvzo2._d;
            if (cvzo2._j() != 0) {
                string2 = string2 + ":" + cvzo2._j();
            }
            list2.set(0, string2);
        }
        return list2;
    }

    public static void layout(zybc zybc2) {
        VisiblityData visiblityData = new VisiblityData();
        if (NEIClientConfig.isHidden()) {
            visiblityData.showNEI = false;
        }
        if (zybc2.field_73881_g - zybc2.field_74195_c <= 40) {
            visiblityData.showSearchSection = false;
        }
        if (zybc2.field_74198_m - 4 < 76) {
            visiblityData.showWidgets = false;
        }
        for (INEIGuiHandler iNEIGuiHandler : GuiInfo.guiHandlers) {
            iNEIGuiHandler.modifyVisiblity(zybc2, visiblityData);
        }
        visiblityData.translateDependancies();
        LayoutManager.getLayoutStyle().layout(zybc2, visiblityData);
        LayoutManager.updateWidgetVisiblities(zybc2, visiblityData);
    }

    private static void init() {
        int n;
        int n2;
        itemPanel = new ItemPanel();
        dropDown = new DropDownWidget();
        searchField = new SearchField("search");
        options = new Button("Options"){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (!bl) {
                    NEIClientConfig.getOptionList().showGui(NEIClientUtils.getGuiContainer());
                    return true;
                }
                return false;
            }

            @Override
            public String getRenderLabel() {
                return NEIClientUtils.translate("inventory.options", new Object[0]);
            }
        };
        prev = new Button("Prev"){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (!bl) {
                    itemPanel.scroll(-1);
                    return true;
                }
                return false;
            }

            @Override
            public String getRenderLabel() {
                return NEIClientUtils.translate("inventory.prev", new Object[0]);
            }
        };
        next = new Button("Next"){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (!bl) {
                    itemPanel.scroll(1);
                    return true;
                }
                return false;
            }

            @Override
            public String getRenderLabel() {
                return NEIClientUtils.translate("inventory.next", new Object[0]);
            }
        };
        pageLabel = new Label("(0/0)", true);
        more = new Button("+"){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (bl) {
                    return false;
                }
                int n = NEIClientUtils.controlKey() ? 64 : (NEIClientUtils.shiftKey() ? 10 : 1);
                int n2 = NEIClientConfig.getItemQuantity() + n;
                if (n2 < 0) {
                    n2 = 0;
                }
                NEIClientUtils.setItemQuantity(n2);
                return true;
            }
        };
        less = new Button("-"){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (bl) {
                    return false;
                }
                int n = NEIClientUtils.controlKey() ? -64 : (NEIClientUtils.shiftKey() ? -10 : -1);
                int n2 = NEIClientConfig.getItemQuantity() + n;
                if (n2 < 0) {
                    n2 = 0;
                }
                NEIClientUtils.setItemQuantity(n2);
                return true;
            }
        };
        quantity = new ItemQuantityField("quantity");
        stateButtons = new SaveLoadButton[7];
        deleteButtons = new Button[7];
        for (n2 = 0; n2 < 7; ++n2) {
            n = n2;
            LayoutManager.stateButtons[n2] = new SaveLoadButton(""){

                @Override
                public boolean onButtonPress(boolean bl) {
                    if (NEIClientConfig.isStateSaved(n)) {
                        NEIClientConfig.loadState(n);
                    } else {
                        NEIClientConfig.saveState(n);
                    }
                    return true;
                }

                @Override
                public void onTextChange() {
                    qoac qoac2 = NEIClientConfig.global.nbt._m("statename");
                    NEIClientConfig.global.nbt._a("statename", (huhy)qoac2);
                    qoac2._a("" + n, this.label);
                    NEIClientConfig.global.saveNBT();
                }
            };
            LayoutManager.deleteButtons[n2] = new Button("x"){

                @Override
                public boolean onButtonPress(boolean bl) {
                    if (!bl) {
                        NEIClientConfig.clearState(n);
                        return true;
                    }
                    return false;
                }
            };
        }
        delete = new Button(){

            @Override
            public boolean onButtonPress(boolean bl) {
                if ((this.state & 3) == 2) {
                    return false;
                }
                cvzo cvzo2 = NEIClientUtils.getHeldItem();
                if (cvzo2 != null) {
                    if (NEIClientUtils.shiftKey()) {
                        NEIClientUtils.deleteHeldItem();
                        NEIClientUtils.deleteItemsOfType(cvzo2);
                    } else if (bl) {
                        NEIClientUtils.decreaseSlotStack(-999);
                    } else {
                        NEIClientUtils.deleteHeldItem();
                    }
                } else if (NEIClientUtils.shiftKey()) {
                    NEIClientUtils.deleteEverything();
                } else {
                    NEIController.deleteMode = !NEIController.deleteMode;
                }
                return true;
            }

            @Override
            public String getButtonTip() {
                if ((this.state & 3) == 2) {
                    return null;
                }
                cvzo cvzo2 = NEIClientUtils.getHeldItem();
                if (cvzo2 == null) {
                    if (NEIClientUtils.shiftKey()) {
                        return NEIClientUtils.translate("inventory.delete.all", new Object[0]);
                    }
                    return LayoutManager.getStateTip("delete", this.state);
                }
                return NEIClientUtils.translate("delete." + (NEIClientUtils.shiftKey() ? "allof" : "oneof"), GuiContainerManager.itemDisplayNameShort(cvzo2));
            }
        };
        gamemode = new ButtonCycled(){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (!bl) {
                    NEIClientUtils.cycleGamemode();
                    return true;
                }
                return false;
            }

            @Override
            public String getButtonTip() {
                return NEIClientUtils.translate("inventory.gamemode." + NEIClientUtils.getNextGamemode(), new Object[0]);
            }
        };
        LayoutManager.gamemode.icons = new Image[3];
        rain = new Button(){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (LayoutManager.handleDisabledButtonPress("rain", bl)) {
                    return true;
                }
                if (!bl) {
                    NEIClientUtils.toggleRaining();
                    return true;
                }
                return false;
            }

            @Override
            public String getButtonTip() {
                return LayoutManager.getStateTip("rain", this.state);
            }
        };
        magnet = new Button(){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (!bl) {
                    NEIClientUtils.toggleMagnetMode();
                    return true;
                }
                return false;
            }

            @Override
            public String getButtonTip() {
                return LayoutManager.getStateTip("magnet", this.state);
            }
        };
        for (n2 = 0; n2 < 4; ++n2) {
            n = n2;
            LayoutManager.timeButtons[n2] = new Button(){

                @Override
                public boolean onButtonPress(boolean bl) {
                    if (LayoutManager.handleDisabledButtonPress(NEIActions.timeZones[n], bl)) {
                        return true;
                    }
                    if (!bl) {
                        NEIClientUtils.setHourForward(n * 6);
                        return true;
                    }
                    return false;
                }

                @Override
                public String getButtonTip() {
                    return LayoutManager.getTimeTip(NEIActions.timeZones[n], this.state);
                }
            };
        }
        heal = new Button(){

            @Override
            public boolean onButtonPress(boolean bl) {
                if (!bl) {
                    NEIClientUtils.healPlayer();
                    return true;
                }
                return false;
            }

            @Override
            public String getButtonTip() {
                return NEIClientUtils.translate("inventory.heal", new Object[0]);
            }
        };
        LayoutManager.delete.state |= 4;
        LayoutManager.gamemode.state |= 4;
        LayoutManager.rain.state |= 4;
        LayoutManager.magnet.state |= 4;
    }

    private static String getStateTip(String string, int n) {
        String string2 = (n & 3) == 2 ? "enable" : ((n & 3) == 1 ? "0" : "1");
        return NEIClientUtils.translate("inventory." + string + "." + string2, new Object[0]);
    }

    private static String getTimeTip(String string, int n) {
        String string2 = (n & 3) == 2 ? "enable" : "set";
        return NEIClientUtils.translate("inventory." + string + "." + string2, new Object[0]);
    }

    private static boolean handleDisabledButtonPress(String string, boolean bl) {
        if (!NEIActions.canDisable.contains(string)) {
            return false;
        }
        if (bl != NEIClientConfig.disabledActions.contains(string)) {
            return LayoutManager.setPropertyDisabled(string, bl);
        }
        return false;
    }

    private static boolean setPropertyDisabled(String string, boolean bl) {
        if (bl && NEIActions.base(string).equals("time")) {
            int n = 0;
            for (int i = 0; i < 4; ++i) {
                if (!NEIClientConfig.disabledActions.contains(NEIActions.timeZones[i])) continue;
                ++n;
            }
            if (n == 3) {
                return false;
            }
        }
        if (NEIClientConfig.hasSMPCounterPart()) {
            NEICPH.sendSetPropertyDisabled(string, bl);
        }
        return true;
    }

    @Override
    public void load(zybc zybc2) {
        if (NEIClientConfig.isEnabled()) {
            LayoutManager.setInputFocused(null);
            ItemList.loadItems();
            overlayRenderer = null;
            LayoutManager.getLayoutStyle().init();
            LayoutManager.layout(zybc2);
        }
        NEIController.load(zybc2);
        if (this.checkCreativeInv(zybc2)) {
            if (zybc2.field_73882_e._B instanceof qngy) {
                zybc2.field_73882_e._a((gqjz)null);
            }
            return;
        }
    }

    @Override
    public void refresh(zybc zybc2) {
    }

    public boolean checkCreativeInv(zybc zybc2) {
        if (zybc2 instanceof qngy && NEIClientConfig.invCreativeMode()) {
            NEICPH.sendCreativeInv(true);
            return true;
        }
        if (zybc2 instanceof GuiExtendedCreativeInv && !NEIClientConfig.invCreativeMode()) {
            NEICPH.sendCreativeInv(false);
            return true;
        }
        return false;
    }

    public static void updateWidgetVisiblities(zybc zybc2, VisiblityData visiblityData) {
        int n;
        drawWidgets = new TreeSet<Widget>(new WidgetZOrder(false));
        controlWidgets = new TreeSet<Widget>(new WidgetZOrder(true));
        if (!visiblityData.showNEI) {
            return;
        }
        LayoutManager.addWidget(options);
        if (visiblityData.showItemPanel) {
            LayoutManager.addWidget(itemPanel);
            LayoutManager.addWidget(prev);
            LayoutManager.addWidget(next);
            LayoutManager.addWidget(pageLabel);
            if (NEIClientConfig.canPerformAction("item")) {
                LayoutManager.addWidget(more);
                LayoutManager.addWidget(less);
                LayoutManager.addWidget(quantity);
            }
        }
        if (visiblityData.showSearchSection) {
            LayoutManager.addWidget(dropDown);
            LayoutManager.addWidget(searchField);
        }
        if (NEIClientConfig.canPerformAction("item") && visiblityData.showStateButtons) {
            for (n = 0; n < 7; ++n) {
                LayoutManager.addWidget(stateButtons[n]);
                if (!NEIClientConfig.isStateSaved(n)) continue;
                LayoutManager.addWidget(deleteButtons[n]);
            }
        }
        if (visiblityData.showUtilityButtons) {
            if (NEIClientConfig.canPerformAction("time")) {
                for (n = 0; n < 4; ++n) {
                    LayoutManager.addWidget(timeButtons[n]);
                }
            }
            if (NEIClientConfig.canPerformAction("rain")) {
                LayoutManager.addWidget(rain);
            }
            if (NEIClientConfig.canPerformAction("heal")) {
                LayoutManager.addWidget(heal);
            }
            if (NEIClientConfig.canPerformAction("magnet")) {
                LayoutManager.addWidget(magnet);
            }
            if (NEIClientUtils.isValidGamemode("creative") || NEIClientUtils.isValidGamemode("creative+") || NEIClientUtils.isValidGamemode("adventure")) {
                LayoutManager.addWidget(gamemode);
            }
            if (NEIClientConfig.canPerformAction("delete")) {
                LayoutManager.addWidget(delete);
            }
        }
    }

    public static LayoutStyle getLayoutStyle(int n) {
        LayoutStyle layoutStyle = layoutStyles.get(n);
        if (layoutStyle == null) {
            layoutStyle = layoutStyles.get(0);
        }
        return layoutStyle;
    }

    public static LayoutStyle getLayoutStyle() {
        return LayoutManager.getLayoutStyle(NEIClientConfig.getLayoutStyle());
    }

    private static void addWidget(Widget widget) {
        drawWidgets.add(widget);
        controlWidgets.add(widget);
    }

    @Override
    public void guiTick(zybc zybc2) {
        if (this.checkCreativeInv(zybc2)) {
            return;
        }
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        for (Widget widget : controlWidgets) {
            widget.update();
        }
    }

    @Override
    public boolean mouseScrolled(zybc zybc2, int n, int n2, int n3) {
        if (NEIClientConfig.isHidden() || !NEIClientConfig.isEnabled()) {
            return false;
        }
        for (Widget widget : controlWidgets) {
            if (!widget.onMouseWheel(n3, n, n2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onMouseScrolled(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public boolean shouldShowTooltip(zybc zybc2) {
        return LayoutManager.itemPanel.draggedStack == null;
    }

    public static Widget getInputFocused() {
        return inputFocused;
    }

    public static void setInputFocused(Widget widget) {
        if (inputFocused != null) {
            inputFocused.loseFocus();
        }
        if ((inputFocused = widget) != null) {
            inputFocused.gainFocus();
        }
    }

    @Override
    public void renderSlotUnderlay(zybc zybc2, yeso yeso2) {
        if (overlayRenderer != null) {
            overlayRenderer.renderOverlay(zybc2.manager, yeso2);
        }
    }

    @Override
    public void renderSlotOverlay(zybc zybc2, yeso yeso2) {
        cvzo cvzo2 = yeso2.func_75211_c();
        if (NEIClientConfig.world.nbt._o("searchinventories") && (cvzo2 == null ? !NEIClientConfig.getSearchExpression().equals("") : !ItemList.itemMatchesSearch(cvzo2))) {
            GL11.glDisable(2896);
            GL11.glTranslatef(0.0f, 0.0f, 150.0f);
            GuiDraw.drawRect(yeso2.field_75223_e, yeso2.field_75221_f, 16, 16, Integer.MIN_VALUE);
            GL11.glTranslatef(0.0f, 0.0f, -150.0f);
            GL11.glEnable(2896);
        }
    }

    public static void drawIcon(int n, int n2, Image image) {
        GuiDraw.changeTexture("nei:textures/nei_sprites.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GuiDraw.drawTexturedModalRect(n, n2, image.x, image.y, image.width, image.height);
        GL11.glDisable(3042);
    }

    public static void drawButtonBackground(int n, int n2, int n3, int n4, boolean bl, int n5) {
        int n6 = 0;
        int n7 = n3;
        if (n3 / 2 > 100) {
            n6 = (n3 - 200) / 50 + 1;
            n7 = 200;
        }
        int n8 = n7 / 2;
        int n9 = n4 / 2;
        int n10 = (n7 + 1) / 2;
        int n11 = (n4 + 1) / 2;
        int n12 = n + n3 - n10;
        int n13 = n2 + n4 - n11;
        int n14 = 46 + n5 * 20;
        int n15 = bl ? 0 : 1;
        int n16 = n14 + n15;
        int n17 = n15;
        int n18 = 75;
        int n19 = n14 + 20 - n11 - n15;
        int n20 = 200 - n10 - n15;
        GuiDraw.changeTexture("textures/gui/widgets.png");
        GuiDraw.drawTexturedModalRect(n, n2, n17, n16, n8, n9);
        GuiDraw.drawTexturedModalRect(n, n13, n17, n19, n8, n11);
        for (int i = 0; i < n6; ++i) {
            int n21 = n + n8 + 50 * i;
            GuiDraw.drawTexturedModalRect(n21, n2, n18, n16, 50, n9);
            GuiDraw.drawTexturedModalRect(n21, n13, n18, n19, 50, n11);
        }
        GuiDraw.drawTexturedModalRect(n12, n2, n20, n16, n10, n9);
        GuiDraw.drawTexturedModalRect(n12, n13, n20, n19, n10, n11);
    }

    public static LayoutManager instance() {
        return instance;
    }

    @Override
    public void tickKeyStates() {
        if (xpzm._E()._B != null) {
            return;
        }
        if (KeyManager.keyStates.get((Object)"world.dawn").down) {
            timeButtons[0].onButtonPress(false);
        }
        if (KeyManager.keyStates.get((Object)"world.noon").down) {
            timeButtons[1].onButtonPress(false);
        }
        if (KeyManager.keyStates.get((Object)"world.dusk").down) {
            timeButtons[2].onButtonPress(false);
        }
        if (KeyManager.keyStates.get((Object)"world.midnight").down) {
            timeButtons[3].onButtonPress(false);
        }
        if (KeyManager.keyStates.get((Object)"world.rain").down) {
            rain.onButtonPress(false);
        }
        if (KeyManager.keyStates.get((Object)"world.heal").down) {
            heal.onButtonPress(false);
        }
        if (KeyManager.keyStates.get((Object)"world.creative").down) {
            gamemode.onButtonPress(false);
        }
    }

    static {
        timeButtons = new Button[4];
        layoutStyles = new HashMap();
    }
}

