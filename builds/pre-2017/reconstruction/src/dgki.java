/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class dgki
extends GuiScreen {
    private List<ItemStack> _a = new ArrayList<ItemStack>();
    private int _b;
    private static RenderItem _c = new RenderItem();
    private static final ResourceLocation _d = new ResourceLocation("stalker", "textures/gui/repair.png");
    private nujd _e;

    public dgki(nujd nujd2) {
        this._e = nujd2;
    }

    @Override
    public void initGui() {
        for (int i = 0; i < 6; ++i) {
            GuiButton guiButton = new GuiButton(i, this.width / 2 - 40, this.height / 2 - 83 + i * 24, 106, 20, "");
            guiButton.drawButton = true;
            this.buttonList.add(guiButton);
        }
        this.buttonList.add(new GuiButton(-1, this.width / 2 - 40, this.height / 2 + 95, 80, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        this.buttonList.add(new GuiButton(7, this.width / 2 - 22, this.height / 2 + 61, 20, 20, "<-"));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 2, this.height / 2 + 61, 20, 20, "->"));
        this.updateScreen();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0434\u043b\u044f \u043f\u043e\u0447\u0438\u043d\u043a\u0438", this.width / 2, this.height / 2 - 105, 0xFFFFFF);
        Minecraft._E()._h._a(_d);
        this.drawTexturedModalRect(this.width / 2 - 80, this.height / 2 - 90, 0, 0, 160, 180);
        for (int i = 0; i < this.buttonList.size(); ++i) {
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            guiButton.drawButton(this.mc, n, n2);
        }
        ItemStack itemStack = null;
        for (int i = 0; i < 6 && (n3 = this._b * 6 + i) < this._a.size(); ++i) {
            ItemStack itemStack2 = this._a.get(n3);
            int n4 = this.width / 2 - 67;
            int n5 = this.height / 2 - 82 + i * 24;
            this._b(itemStack2, n4, n5);
            if (n <= n4 || n2 <= n5 || n >= n4 + 18 || n2 >= n5 + 18) continue;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            this.drawGradientRect(n4, n5, n4 + 17, n5 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            itemStack = itemStack2;
        }
        if (itemStack != null) {
            this._a(itemStack, n, n2);
        }
    }

    protected void _a(ItemStack itemStack, int n, int n2) {
        List list2 = itemStack._a((EntityPlayer)this.mc._t, this.mc._M.advancedItemTooltips);
        for (int i = 0; i < list2.size(); ++i) {
            if (i == 0) {
                list2.set(i, "\u00a7" + Integer.toHexString(itemStack._w()._e) + (String)list2.get(i));
                continue;
            }
            list2.set(i, (Object)((Object)EnumChatFormatting._h) + (String)list2.get(i));
        }
        FontRenderer fontRenderer = itemStack._a().getFontRenderer(itemStack);
        this._a(list2, n, n2, fontRenderer == null ? this.fontRenderer : fontRenderer);
    }

    protected void _a(List list2, int n, int n2, FontRenderer fontRenderer) {
        if (!list2.isEmpty()) {
            int n3;
            GL11.glDisable(32826);
            qnon._a();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n4 = 0;
            for (String string : list2) {
                n3 = fontRenderer._b(string);
                if (n3 <= n4) continue;
                n4 = n3;
            }
            int n5 = n + 12;
            n3 = n2 - 12;
            int n6 = 8;
            if (list2.size() > 1) {
                n6 += 2 + (list2.size() - 1) * 10;
            }
            if (n5 + n4 > this.width) {
                n5 -= 28 + n4;
            }
            if (n3 + n6 + 6 > this.height) {
                n3 = this.height - n6 - 6;
            }
            this.zLevel = 300.0f;
            dgki._c.zLevel = 300.0f;
            int n7 = -267386864;
            this.drawGradientRect(n5 - 3, n3 - 4, n5 + n4 + 3, n3 - 3, n7, n7);
            this.drawGradientRect(n5 - 3, n3 + n6 + 3, n5 + n4 + 3, n3 + n6 + 4, n7, n7);
            this.drawGradientRect(n5 - 3, n3 - 3, n5 + n4 + 3, n3 + n6 + 3, n7, n7);
            this.drawGradientRect(n5 - 4, n3 - 3, n5 - 3, n3 + n6 + 3, n7, n7);
            this.drawGradientRect(n5 + n4 + 3, n3 - 3, n5 + n4 + 4, n3 + n6 + 3, n7, n7);
            int n8 = 0x505000FF;
            int n9 = (n8 & 0xFEFEFE) >> 1 | n8 & 0xFF000000;
            this.drawGradientRect(n5 - 3, n3 - 3 + 1, n5 - 3 + 1, n3 + n6 + 3 - 1, n8, n9);
            this.drawGradientRect(n5 + n4 + 2, n3 - 3 + 1, n5 + n4 + 3, n3 + n6 + 3 - 1, n8, n9);
            this.drawGradientRect(n5 - 3, n3 - 3, n5 + n4 + 3, n3 - 3 + 1, n8, n8);
            this.drawGradientRect(n5 - 3, n3 + n6 + 2, n5 + n4 + 3, n3 + n6 + 3, n9, n9);
            for (int i = 0; i < list2.size(); ++i) {
                String string = (String)list2.get(i);
                fontRenderer._a(string, n5, n3, -1);
                if (i == 0) {
                    n3 += 2;
                }
                n3 += 10;
            }
            this.zLevel = 0.0f;
            dgki._c.zLevel = 0.0f;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
            GL11.glEnable(32826);
        }
    }

    @Override
    public void updateScreen() {
        this._a.clear();
        if (this.mc._t == null) {
            return;
        }
        for (ItemStack itemStack : this.mc._t.inventoryContainer.getInventory()) {
            if (itemStack == null || !itemStack._h() || !this._e._b(itemStack)) continue;
            this._a.add(itemStack);
        }
        int n = Math.max((this._a.size() - 1) / 6, 0);
        this._b = Math.min(this._b, n);
        for (int i = 0; i < 6; ++i) {
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            int n2 = this._b * 6 + i;
            if (n2 < this._a.size()) {
                guiButton.displayString = this._a.get(n2)._s();
                guiButton.drawButton = true;
                continue;
            }
            guiButton.drawButton = false;
        }
        ((GuiButton)this.buttonList.get((int)7)).enabled = this._b > 0;
        ((GuiButton)this.buttonList.get((int)8)).enabled = this._b < n;
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        switch (guiButton.id) {
            case -1: {
                this.mc._a((GuiScreen)null);
                break;
            }
            case 7: {
                --this._b;
                break;
            }
            case 8: {
                ++this._b;
                break;
            }
            default: {
                int n = this._b * 6 + guiButton.id;
                if (n < this._a.size()) {
                    ItemStack itemStack = this._a.get(n);
                    for (int i = 0; i < this.mc._t.inventoryContainer.getInventory().size(); ++i) {
                        if (itemStack != this.mc._t.inventoryContainer.getInventory().get(i)) continue;
                        new rpxd(i).sendToServer();
                        break;
                    }
                }
                this.mc._a((GuiScreen)null);
            }
        }
    }

    protected void _b(ItemStack itemStack, int n, int n2) {
        this.zLevel = 100.0f;
        dgki._c.zLevel = 100.0f;
        GL11.glEnable(2929);
        _c.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n, n2);
        _c.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n, n2, null);
        dgki._c.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
}

