/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import com.google.common.collect.Ordering;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.money.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import noppes.npcs.packet.PacketBuyTradepack;
import noppes.npcs.packet.PacketSellTradepack;
import org.apache.commons.lang3.tuple.Pair;

public class GuiTradepacks
extends GuiScreenAdvanced {
    private static final ResourceLocation background = new ResourceLocation("customnpcs", "textures/gui/tradepacks.png");
    private final int supplierId;
    private final Map<Integer, Pair<Integer, cvzo>> avaialableTradepacks;
    private int sellPrice;
    private double sat = -1.0;
    private GuiComponentsList<McToolTip> tooltips;
    private McScrollPane tradepacksPane;
    private boolean hasTradepack = false;
    private boolean validArmor = true;
    private String currentTradepack = null;
    private McLabel warningLabel;

    public GuiTradepacks(int n, Map<Integer, Pair<Integer, cvzo>> map, int n2, double d) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).create());
        this.supplierId = n;
        this.avaialableTradepacks = map;
        this.sellPrice = n2;
        this.sat = d;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.tooltips = new GuiComponentsList(this);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        this.initSoldTradepacks(point);
        this.initCurrentTradepack(point);
        this.initMoneyLabel(point);
        this.initSaturation(point);
        this.warningLabel = new McLabel((IAdvancedGui)this, "", Point.zeroPoint, -65536);
        this.addElement(this.warningLabel);
        this.addElement(this.tradepacksPane);
        this.addElement(this.tooltips);
    }

    private void initSaturation(Point point) {
        if (this.sat >= 0.0) {
            String string = "\u041f\u043e\u0442\u0440\u0435\u0431\u043d\u043e\u0441\u0442\u044c: " + (int)(this.sat * 100.0) + "%";
            float f = (float)(1.0 - this.sat);
            float f2 = (float)this.sat;
            int n = (int)(f * 255.0f) << 16 | (int)(f2 * 255.0f) << 8 | 0xFF000000;
            McLabel mcLabel = new McLabel((IAdvancedGui)this, string, point.add(210, 28), n).setCentered();
            mcLabel.noMouseInteraction = false;
            this.addElement(mcLabel);
            String string2 = "\u041f\u043e\u0442\u0440\u0435\u0431\u043d\u043e\u0441\u0442\u044c \u043e\u0442\u0440\u0430\u0436\u0430\u0435\u0442 \u0437\u0430\u0438\u043d\u0442\u0435\u0440\u0435\u0441\u043e\u0432\u0430\u043d\u043d\u043e\u0441\u0442\u044c \u0442\u043e\u0440\u0433\u043e\u0432\u0446\u0430 \u0432 \u043f\u0440\u0438\u043e\u0431\u0440\u0435\u0442\u0435\u043d\u0438\u0438 \u043f\u043e\u0441\u044b\u043b\u043e\u043a. \u0427\u0435\u043c \u043e\u043d\u043e \u0432\u044b\u0448\u0435, \u0442\u0435\u043c \u0431\u043e\u043b\u044c\u0448\u0435 \u043e\u043d \u0433\u043e\u0442\u043e\u0432 \u0432\u0430\u043c \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c \u0437\u0430 \u043f\u043e\u0441\u0442\u0430\u0432\u043a\u0438.";
            List<String> list2 = this.renderer.wrapString(string2, 200);
            this.tooltips.addElement(new McToolTip((IAdvancedGui)this, list2, mcLabel));
        }
    }

    private void initMoneyLabel(Point point) {
        String string = "\u0421\u0447\u0435\u0442: " + zwat._a(this.field_73882_e._t)._b();
        this.addElement(new McLabel((IAdvancedGui)this, string, point.add(310 - this.renderer.getStringWidth(string), 65)));
    }

    private void initCurrentTradepack(Point point) {
        tupg tupg2 = tupg._a(this.field_73882_e._t);
        if (tupg2._g()) {
            cvzo cvzo2 = tupg2._c._e();
            SellTradepackComponent sellTradepackComponent = new SellTradepackComponent(this, point.add(112, -55), cvzo2, this.sellPrice);
            this.addElement(sellTradepackComponent);
            this.hasTradepack = true;
            this.currentTradepack = cvzo2._s();
        } else {
            this.currentTradepack = null;
            this.hasTradepack = false;
        }
    }

    private void initSoldTradepacks(Point point) {
        int n = this.avaialableTradepacks.size();
        int n2 = n % 2 == 0 ? n / 2 : n / 2 + 1;
        this.tradepacksPane = GuiHelper.createScrollPane(this, point.add(-314, -82), new Dimension(403, 171), new Dimension(400, n2 * 85), true);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(this.avaialableTradepacks.keySet());
        arrayList.sort(Ordering.natural());
        for (int i = 0; i < arrayList.size(); ++i) {
            int n3 = (Integer)arrayList.get(i);
            Pair<Integer, cvzo> pair = this.avaialableTradepacks.get(n3);
            int n4 = pair.getLeft();
            cvzo cvzo2 = pair.getRight();
            Point point2 = new Point(i % 2 * 195, i / 2 * 85);
            TradepackComponent tradepackComponent = new TradepackComponent(this, point2, n3, cvzo2, n4);
            this.tradepacksPane.getViewport().addElement(tradepackComponent);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.drawBackground();
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        this.checkValidTradepack();
        this.checkValidArmor();
        if (!this.validArmor) {
            this.warningLabel.setText("\u0422\u043e\u0440\u0433\u043e\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a \u043d\u0435\u0441\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c \u0441 \u0432\u0430\u0448\u0435\u0439 \u0431\u0440\u043e\u043d\u0435\u0439.");
        } else if (this.hasTradepack) {
            this.warningLabel.setText("\u0412\u043d\u0438\u043c\u0430\u043d\u0438\u0435! \u041f\u0440\u0438 \u043f\u043e\u043a\u0443\u043f\u043a\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \"" + this.currentTradepack + "\" \u0431\u0443\u0434\u0435\u0442 \u043f\u0435\u0440\u0435\u043c\u0435\u0449\u0435\u043d \u0432 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c.");
        } else {
            this.warningLabel.setText("");
        }
        if (!this.avaialableTradepacks.isEmpty() && !this.warningLabel.getText().isEmpty()) {
            this.warningLabel.setCentered(this.screenWidth / 2, this.screenHeight / 2 + 110);
        }
    }

    private void drawBackground() {
        this.func_73873_v_();
        this.renderer.bindTexture(background);
        this.renderer.drawTexturedModalRect(this.screenWidth / 2 - 324, this.screenHeight / 2 - 97, 0, 0, 649, 194);
    }

    private void checkValidTradepack() {
        if (this.hasTradepack && tupg._a((EntityPlayer)this.field_73882_e._t)._c._e() == null) {
            this.closeScreen();
        }
    }

    private void checkValidArmor() {
        this.validArmor = tupg._a(this.field_73882_e._t)._h();
    }

    private void sell() {
        new PacketSellTradepack(this.supplierId).sendToServer();
    }

    private void buyTradepack(int n) {
        new PacketBuyTradepack(this.supplierId, n).sendToServer();
        this.closeScreen();
    }

    private class SellTradepackComponent
    extends TradepackComponent {
        public SellTradepackComponent(IAdvancedGui iAdvancedGui, Point point, cvzo cvzo2, int n) {
            super(iAdvancedGui, point, -1, cvzo2, n);
        }

        @Override
        protected String getPriceLabel() {
            return this.cost > 0 ? super.getPriceLabel() : (Object)((Object)ezfc._m) + "\u2014 \u0440\u0443\u0431.";
        }

        @Override
        protected String getButtonLabel() {
            return (this.cost > 0 ? "" : ezfc._m) + "\u041f\u0440\u043e\u0434\u0430\u0442\u044c";
        }

        @Override
        protected boolean checkArmor() {
            return false;
        }

        @Override
        protected boolean isButtonEnabled() {
            return this.cost > 0;
        }

        @Override
        protected void onAction() {
            GuiTradepacks.this.sell();
        }
    }

    private class TradepackComponent
    extends GuiComponentsList {
        private final int id;
        protected final cvzo stack;
        protected final int cost;

        public TradepackComponent(IAdvancedGui iAdvancedGui, Point point, int n, cvzo cvzo2, int n2) {
            super(iAdvancedGui, point, new Dimension(189, 78));
            this.id = n;
            this.stack = cvzo2;
            this.cost = n2;
            this.setup();
        }

        private void setup() {
            this.addElement(new McImage(this.parent, 0, 0, 832, 44, 189, 78, background));
            this.addElement(new McLabel(this.parent, this.renderer.trimToWidth(this.stack._s(), 180, true), new Point(10, 1)));
            this.addElement(new McLabel(this.parent, this.getPriceLabel(), new Point(75, 25)));
            McDummySlot mcDummySlot = new McDummySlot(this.parent, this.stack, new Point(10, 25), 1.5f);
            this.addElement(mcDummySlot);
            McButton mcButton = new McButton(this.parent, new Point(72, 45), GuiHelper.mcButtonStyle, this.getButtonLabel()){

                @Override
                public boolean getEnabled() {
                    return super.getEnabled() && (!TradepackComponent.this.checkArmor() || GuiTradepacks.this.validArmor);
                }
            };
            mcButton.setSize(new Dimension(110, 25));
            mcButton.onClick(guiActionButtonClick -> this.onAction());
            mcButton.setEnabled(this.isButtonEnabled());
            mcButton.setRenderer(GuiHelper.mcWidgetsRenderer);
            this.addElement(mcButton);
            McToolTip mcToolTip = mcDummySlot.createToolTip();
            mcToolTip.setRenderer(GuiHelper.widgetsRenderer);
            GuiTradepacks.this.tooltips.addElement(mcToolTip);
        }

        protected String getPriceLabel() {
            return this.cost + " \u0440\u0443\u0431.";
        }

        protected String getButtonLabel() {
            return "\u041a\u0443\u043f\u0438\u0442\u044c";
        }

        protected boolean isButtonEnabled() {
            return (long)this.cost <= zwat._a(GuiTradepacks.this.field_73882_e._t)._a();
        }

        protected boolean checkArmor() {
            return true;
        }

        protected void onAction() {
            GuiTradepacks.this.buyTradepack(this.id);
        }
    }
}

