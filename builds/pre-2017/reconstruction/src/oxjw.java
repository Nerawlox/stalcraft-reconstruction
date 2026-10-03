/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiPlayer;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.stalker.clans.ClansMod;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.packet.PacketInteractClosestNpc;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL20;

public class oxjw
extends GuiScreenAdvanced {
    private McGuiPlayer _a;
    private boolean _b = false;
    private boolean _c = false;
    private boolean _d = false;
    private boolean _e = false;

    public oxjw(GuiScreen guiScreen) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this.parentScreen = guiScreen;
    }

    @Override
    public void initGui() {
        super.initGui();
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        int n = 872;
        int n2 = 500;
        this.addElement(new McBackground(this, point.add(-n / 2, -n2 / 2), new Dimension(n, n2)).setTexture(iedw._a).setTextureSize(new Dimension(64, 64)).setTextureCoords(new Point(128, 959)).setResizeBorder(20));
        this.addElement(new kjui(this));
        this.addElement(new McRect(this, point.add(-n / 2 + 10, -n2 / 2 + 36), new Dimension(n - 20, 1), 0x43939393));
        GuiHelper.addButton(this, point.add(-90, n2 / 2 - 45), new Dimension(180, 30), iedw._l, "\u041d\u0430\u0437\u0430\u0434").onClick(guiActionButtonClick -> this.closeScreen());
        this._a = new McGuiPlayer(this, point.add(-100, -200), new Dimension(200, 400), 80.0f);
        this.addElement(this._a);
        this._a.setRotation(-20.0f);
        this._a(point);
        this._d();
    }

    private void _a(Point point) {
        List<Pair> list = Arrays.asList(Pair.of("\u0421\u043a\u043b\u0430\u0434 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438", () -> this.mc._a(new zghn(this, 0, 0, 0))), Pair.of("\u041a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0438\u043f\u0430\u0441\u044b", this::_b), Pair.of("\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435", this::_c), Pair.of("\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c", this::_e), Pair.of("\u041f\u0435\u0440\u0441. \u0441\u043a\u043b\u0430\u0434", this::_a), Pair.of("\u041c\u0430\u0433\u0430\u0437\u0438\u043d", () -> this.mc._a(new ivwa(this))), Pair.of("\u041a\u0435\u0439\u0441\u044b", () -> this.mc._a(new oxhq(this))));
        int n = list.size();
        double d = 0.7853981633974483;
        double d2 = -0.7853981633974483;
        double d3 = (d2 - d) / (double)(n - 1);
        int n2 = 250;
        for (int i = 0; i < list.size(); ++i) {
            int n3 = (int)(Math.cos(-(d + d3 * (double)i)) * (double)n2);
            int n4 = (int)(Math.sin(-(d + d3 * (double)i)) * (double)n2);
            Pair pair = list.get(i);
            GuiHelper.addButton(this, point.add(n3 - 50, n4 - 15), new Dimension(180, 30), iedw._l, (String)pair.getLeft()).onClick(guiActionButtonClick -> ((Runnable)pair.getRight()).run());
        }
    }

    private void _a() {
        ClientProxy.containerScreenParent = this;
        new nudp().sendToServer();
    }

    private void _b() {
        ClientProxy.containerScreenParent = this;
        new PacketInteractClosestNpc(EnumRoleType.Trader).sendToServer();
    }

    private void _c() {
        ClientProxy.containerScreenParent = this;
        new PacketInteractClosestNpc(EnumRoleType.Bank).sendToServer();
    }

    private void _d() {
        tupg tupg2 = tupg._a(this.mc._t);
        ydir ydir2 = tupg2._c;
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        arrayList.addAll(Arrays.asList(ydir2._a));
        arrayList.addAll(Arrays.asList(this.mc._t.inventory._a));
        arrayList.addAll(Arrays.asList(this.mc._t.inventory._b));
        this._b = false;
        this._d = false;
        this._c = false;
        this._e = false;
        for (ItemStack itemStack : arrayList) {
            if (itemStack == null) continue;
            Item item = itemStack._a();
            if (item instanceof wolf || item instanceof cdse) {
                this._b = true;
            }
            if (item instanceof sbvk && !((sbvk)item)._a()) {
                this._d = true;
            }
            if (item instanceof nusq) {
                this._e = true;
            }
            if (!(item instanceof dgmz)) continue;
            this._c = true;
        }
    }

    private void _e() {
        ClientProxy.containerScreenParent = this;
        this.mc._a(new cebg(this.mc._t));
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.mc._t == null) {
            return;
        }
        ((EntityPlayerSP)this._a.getEntity()).inventory = this.mc._t.inventory;
        this._d();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        int n3 = 0;
        if (!this._b) {
            this._a("\u041d\u0435\u0442 \u043e\u0440\u0443\u0436\u0438\u044f", n3++);
        }
        if (!this._c) {
            this._a("\u041d\u0435\u0442 \u0431\u0440\u043e\u043d\u0438", n3++);
        }
        if (!this._e) {
            this._a("\u041d\u0435\u0442 \u043f\u0430\u0442\u0440\u043e\u043d\u043e\u0432", n3++);
        }
        if (!this._d) {
            this._a("\u041d\u0435\u0442 \u043c\u0435\u0434\u0438\u043a\u0430\u043c\u0435\u043d\u0442\u043e\u0432", n3++);
        }
    }

    private void _a(String string, int n) {
        Point point = new Point(this.screenWidth / 2 - 350, this.screenHeight / 2 - 115 + 20 + n * 46);
        this.renderer.bindTexture(iedw._a);
        this.renderer.drawTiledRect(point, new Point(128, 931), new Dimension(202, 36), new Dimension(64, 27), 4);
        ExternalFont.tahomaBold17.renderCenteredString("!", (point.x + 18) / 2, (point.y + 18) / 2, -65536);
        ExternalFont.tahoma14.renderString(string, (point.x + 30) / 2, (point.y + 6) / 2, -7105645);
    }

    private class kjui
    extends GuiComponent {
        protected kjui(IAdvancedGui iAdvancedGui) {
            super(iAdvancedGui);
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            ClansMod._E._e();
            jxtc jxtc2 = ClansMod._E;
            jxtc2._a("center", (float)(oxjw.this.screenWidth / 2), (float)(oxjw.this.screenHeight / 2));
            jxtc2._a("transform", 0.7f, 1.0f);
            jxtc2._a("radius", (float)(290.0 + 10.0 * Math.sin((float)ntte._b / 10.0f)));
            this.renderer.drawRect(0.0, 0.0, oxjw.this.screenWidth, oxjw.this.screenHeight, 0x30FFFFFF);
            GL20.glUseProgram(0);
        }
    }
}

