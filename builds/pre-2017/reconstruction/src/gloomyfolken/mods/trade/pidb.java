/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.money.zwat;
import gloomyfolken.mods.trade.qlgf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class pidb
extends GuiContainerAdvanced {
    protected int _a = 176;
    protected int _b = 222;
    public qlgf _c = qlgf._a;
    public qlgf _d = qlgf._a;
    public long _e;
    public final String _f;
    public static final ResourceLocation _g = new ResourceLocation("trade", "textures/gui/trade.png");
    private McNumberField _h;
    private GuiButton _i;

    public pidb(Container container, String string) {
        super(container);
        this.mc = Minecraft._E();
        this._f = string;
    }

    @Override
    public void initGui() {
        super.initGui();
        this._i = new GuiButton(0, this.width / 2 - 50, this.height / 2 + 101, 48, 20, "");
        this.buttonList.add(this._i);
        this._a();
        this.buttonList.add(new GuiButton(1, this.width / 2 + 2, this.height / 2 + 101, 48, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        this._h = new McNumberField(this, new Point(this.width - this._a + 16, this.height - this._b + 208), new Dimension(142, 22));
        this.addElement(this._h);
        this._h.setMaxStringLength(16);
        this._h.setMaxValue(zwat._a(this.mc._t)._a());
        this._h.setMinValue(0L);
    }

    private void _a() {
        if (this._c == qlgf._a) {
            this._i.displayString = "\u041f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c";
            this._i.enabled = true;
        }
        if (this._c == qlgf._b) {
            this._i.enabled = this._d != qlgf._a;
            this._i.displayString = "\u0421\u043e\u0433\u043b\u0430\u0441\u0438\u0442\u044c\u0441\u044f";
        }
        if (this._c == qlgf._c) {
            this._i.enabled = false;
            this._i.displayString = "\u0421\u043e\u0433\u043b\u0430\u0441\u0438\u0442\u044c\u0441\u044f";
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft minecraft = Minecraft._E();
        htou htou2 = new htou(minecraft._M, minecraft._n, minecraft._o);
        minecraft._h._a(_g);
        this.drawTexturedModalRect(htou2._a() / 2 - this._a / 2, htou2._b() / 2 - this._b / 2 - 8, 0, 0, this._a, this._b);
        this.drawCenteredString(this.fontRenderer, "\u0412\u044b", this.width / 2 - this._a / 2 + 43, this.height / 2 - 114, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this._f, this.width / 2 - this._a / 2 + 133, this.height / 2 - 114, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this._e + " \u0440\u0443\u0431.", this.width / 2 - this._a / 2 + 133, this.height / 2 - this._b / 2 + 112, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "\u0421\u0447\u0435\u0442: " + zwat._a(minecraft._t)._b(), this.width / 2 - this._a / 2 + 43, this.height / 2 - this._b / 2 + 119, 0xFFFFFF);
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }

    @Override
    public void drawDefaultBackground() {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void keyTyped(char c, int n) {
        long l = this._h.getValue();
        super.keyTyped(c, n);
        long l2 = this._h.getValue();
        if (l2 != l) {
            new aoid(l2).sendToServer();
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            if (this._c == qlgf._a) {
                new ydlr(qlgf._b).sendToServer();
            } else if (this._c == qlgf._b) {
                new ydlr(qlgf._c).sendToServer();
            }
        } else {
            Minecraft._E()._t.closeScreen();
            this.mc._a((GuiScreen)null);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(_g);
        GL11.glEnable(3042);
        this._a(8, -32, this._c);
        this._a(98, -32, this._d);
        GL11.glDisable(3042);
    }

    private void _a(int n, int n2, qlgf qlgf2) {
        this.drawTexturedModalRect(n, n2, 244, qlgf2.ordinal() * 12, 12, 12);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this._a();
    }
}

