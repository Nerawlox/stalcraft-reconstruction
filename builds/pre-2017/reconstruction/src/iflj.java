/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class iflj
extends GuiButton {
    public iflj(int n, int n2, int n3) {
        super(n, n2, n3, 20, 20, "");
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (!this.drawButton) {
            return;
        }
        minecraft._R()._a(GuiButton.buttonTextures);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
        int n3 = 106;
        if (bl) {
            n3 += this.height;
        }
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, n3, this.width, this.height);
    }
}

