/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.client.gui.screens.GuiScreenRadial;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class oxlc
extends GuiScreenRadial {
    private ItemStack[] _a;
    private GuiRenderer.RenderItemHD _b;

    public oxlc(EntityPlayer entityPlayer) {
        super(StalkerMiscMod.instance.__aw._d, 4);
        this._b = this.renderer.createItemRender(4.0f);
        this._a = new ItemStack[4];
        ydir ydir2 = tupg._a((EntityPlayer)entityPlayer)._c;
        System.arraycopy(ydir2._a, 8, this._a, 0, 4);
    }

    @Override
    public void initGui() {
        super.initGui();
        GuiHelper.addLabel((IAdvancedGui)this, "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0434\u043b\u044f \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u044f", this.screenWidth / 2, this.screenHeight / 2 - 400).setFontRenderer(ExternalFont.tahoma16).setCentered();
    }

    @Override
    protected String getSelectedTitle(int n) {
        ItemStack itemStack = this._a[n];
        return itemStack != null ? itemStack._s() : "";
    }

    @Override
    protected void drawIcon(int n, int n2, int n3) {
        ItemStack itemStack = this._a[n];
        if (itemStack != null) {
            GL11.glEnable(3042);
            this._b.renderStack(itemStack, n2 - 32, n3 - 32);
            GL11.glDisable(2896);
            tupg tupg2 = tupg._a(this.mc._t);
            float f = (float)(System.currentTimeMillis() - tupg2._i) / (float)tupg2._h;
            int n4 = (int)(72.0f - Math.min(1.0f, f) * 72.0f);
            this.renderer.drawRect(n2 - 32, n3 + 32 - n4, 72.0, n4, -1427050256);
        }
    }

    @Override
    protected void runAction(int n) {
        if (this._a[n] != null) {
            boolean bl = StalkerMiscMod.instance.__at.enabled;
            new numa((byte)(8 + n), bl).sendToServer();
        }
    }
}

