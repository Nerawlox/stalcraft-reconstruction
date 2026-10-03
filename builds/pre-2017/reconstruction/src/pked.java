/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class pked
extends GuiButton {
    public final ResourceLocation _a;
    public final int _b;
    public final int _c;
    public boolean _d;

    public pked(int n, int n2, int n3, ResourceLocation resourceLocation, int n4, int n5) {
        super(n, n2, n3, 22, 22, "");
        this._a = resourceLocation;
        this._b = n4;
        this._c = n5;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (!this.drawButton) {
            return;
        }
        minecraft._R()._a(GuiBeacon._a());
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_82253_i = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
        int n3 = 219;
        int n4 = 0;
        if (!this.enabled) {
            n4 += this.width * 2;
        } else if (this._d) {
            n4 += this.width * 1;
        } else if (this.field_82253_i) {
            n4 += this.width * 3;
        }
        this.drawTexturedModalRect(this.xPosition, this.yPosition, n4, n3, this.width, this.height);
        if (!GuiBeacon._a().equals(this._a)) {
            minecraft._R()._a(this._a);
        }
        this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, this._b, this._c, 18, 18);
    }

    public boolean _a() {
        return this._d;
    }

    public void _a(boolean bl) {
        this._d = bl;
    }
}

