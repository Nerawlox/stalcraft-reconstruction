/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class pkae
extends GuiButton {
    public final boolean _a;

    public pkae(int n, int n2, int n3, boolean bl) {
        super(n, n2, n3, 12, 19, "");
        this._a = bl;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (!this.drawButton) {
            return;
        }
        minecraft._R()._a(xayk._b());
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
        int n3 = 0;
        int n4 = 176;
        if (!this.enabled) {
            n4 += this.width * 2;
        } else if (bl) {
            n4 += this.width;
        }
        if (!this._a) {
            n3 += this.height;
        }
        this.drawTexturedModalRect(this.xPosition, this.yPosition, n4, n3, this.width, this.height);
    }
}

