/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class hsxd
extends InventoryEffectRenderer {
    private float _d;
    private float _e;
    private static final int _f = 227;
    private static final int _g = 181;
    public static final ResourceLocation _a = new ResourceLocation("stalker", "textures/gui/inventory.png");
    public static final ResourceLocation _b = new ResourceLocation("stalker", "textures/gui/backpack.png");
    public jzak _c;

    public hsxd(jzak jzak2) {
        super(jzak2);
        this._c = jzak2;
        this.allowUserInput = true;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.xSize = 227;
        this.ySize = 181;
        this.guiLeft = this.width / 2 - this.xSize / 2;
        this.guiTop = this.height / 2 - this.ySize / 2;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this._d = n;
        this._e = n2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        Minecraft._E()._h._a(_a);
        this.drawTexturedModalRect(this.width / 2 - 113, this.height / 2 - 90, 0, 0, 227, 181);
        if (this._c.hasBackpack()) {
            this.drawTexturedModalRect(this.width / 2 - 113 + 199, this.height / 2 - 90 + 14, 228, 0, 20, 153);
        }
        for (int i = n3 = this._c.getArtefaktSlots(); i < 5; ++i) {
            this.drawTexturedModalRect(this.width / 2 - 113 + 7 + i * 18, this.height / 2 - 90 + 107, 228, 154, 18, 18);
        }
        this.drawCenteredString(this.fontRenderer, "\u0427\u0442\u043e\u0431\u044b \u0437\u0430\u0431\u0440\u0430\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043b\u0438\u043a\u043d\u0438\u0442\u0435 \u043f\u043e \u043d\u0435\u043c\u0443 \u041f\u041a\u041c", this.width / 2, this.height / 2 - 90 - 20, 0xFFFFFF);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.mc._a(new ohbq(this.mc._X));
        }
        if (guiButton.id == 1) {
            this.mc._a(new uzta(this, this.mc._X));
        }
    }
}

