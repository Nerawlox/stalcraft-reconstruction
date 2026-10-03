/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.achievement.GuiSlotStatsBlock;
import net.minecraft.client.gui.achievement.GuiSlotStatsItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatFileWriter;
import org.lwjgl.opengl.GL11;

public class uzta
extends GuiScreen {
    public static RenderItem _a = new RenderItem();
    public GuiScreen _b;
    public String _c = "Select world";
    public htnw _d;
    public GuiSlotStatsItem _e;
    public GuiSlotStatsBlock _f;
    public StatFileWriter _g;
    public GuiSlot _h;

    public uzta(GuiScreen guiScreen, StatFileWriter statFileWriter) {
        this._b = guiScreen;
        this._g = statFileWriter;
    }

    @Override
    public void initGui() {
        this._c = wpcz._a("gui.stats");
        this._d = new htnw(this);
        this._d.registerScrollButtons(1, 1);
        this._e = new GuiSlotStatsItem(this);
        this._e.registerScrollButtons(1, 1);
        this._f = new GuiSlotStatsBlock(this);
        this._f.registerScrollButtons(1, 1);
        this._h = this._d;
        this._a();
    }

    public void _a() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, wpcz._a("gui.done")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 154, this.height - 52, 100, 20, wpcz._a("stat.generalButton")));
        GuiButton guiButton = new GuiButton(2, this.width / 2 - 46, this.height - 52, 100, 20, wpcz._a("stat.blocksButton"));
        this.buttonList.add(guiButton);
        GuiButton guiButton2 = new GuiButton(3, this.width / 2 + 62, this.height - 52, 100, 20, wpcz._a("stat.itemsButton"));
        this.buttonList.add(guiButton2);
        if (this._f.getSize() == 0) {
            guiButton.enabled = false;
        }
        if (this._e.getSize() == 0) {
            guiButton2.enabled = false;
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 0) {
            this.mc._a(this._b);
        } else if (guiButton.id == 1) {
            this._h = this._d;
        } else if (guiButton.id == 3) {
            this._h = this._e;
        } else if (guiButton.id == 2) {
            this._h = this._f;
        } else {
            this._h.actionPerformed(guiButton);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._h.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, this._c, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public void _a(int n, int n2, int n3) {
        this._a(n + 1, n2 + 1);
        GL11.glEnable(32826);
        qnon._c();
        _a.renderItemIntoGUI(this.fontRenderer, this.mc._R(), new ItemStack(n3, 1, 0), n + 2, n2 + 2);
        qnon._a();
        GL11.glDisable(32826);
    }

    public void _a(int n, int n2) {
        this._a(n, n2, 0, 0);
    }

    public void _a(int n, int n2, int n3, int n4) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(statIcons);
        float f = 0.0078125f;
        float f2 = 0.0078125f;
        int n5 = 18;
        int n6 = 18;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(n + 0, n2 + 18, this.zLevel, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        tessellator.addVertexWithUV(n + 18, n2 + 18, this.zLevel, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        tessellator.addVertexWithUV(n + 18, n2 + 0, this.zLevel, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        tessellator.addVertexWithUV(n + 0, n2 + 0, this.zLevel, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        tessellator.draw();
    }

    public static /* synthetic */ Minecraft _a(uzta uzta2) {
        return uzta2.mc;
    }

    public static /* synthetic */ FontRenderer _b(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ StatFileWriter _c(uzta uzta2) {
        return uzta2._g;
    }

    public static /* synthetic */ FontRenderer _d(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _e(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ Minecraft _f(uzta uzta2) {
        return uzta2.mc;
    }

    public static /* synthetic */ void _a(uzta uzta2, int n, int n2, int n3, int n4) {
        uzta2._a(n, n2, n3, n4);
    }

    public static /* synthetic */ Minecraft _g(uzta uzta2) {
        return uzta2.mc;
    }

    public static /* synthetic */ FontRenderer _h(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _i(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _j(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _k(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _l(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ void _a(uzta uzta2, int n, int n2, int n3, int n4, int n5, int n6) {
        uzta2.drawGradientRect(n, n2, n3, n4, n5, n6);
    }

    public static /* synthetic */ FontRenderer _m(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _n(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ void _b(uzta uzta2, int n, int n2, int n3, int n4, int n5, int n6) {
        uzta2.drawGradientRect(n, n2, n3, n4, n5, n6);
    }

    public static /* synthetic */ FontRenderer _o(uzta uzta2) {
        return uzta2.fontRenderer;
    }

    public static /* synthetic */ void _a(uzta uzta2, int n, int n2, int n3) {
        uzta2._a(n, n2, n3);
    }
}

