/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButtonNextPage
extends GuiButton {
    private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
    private final boolean nextPage;

    public GuiButtonNextPage(int n, int n2, int n3, boolean bl) {
        super(n, n2, n3, 23, 13, "");
        this.nextPage = bl;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            boolean bl = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            minecraft._h._a(bookGuiTextures);
            int n3 = 0;
            int n4 = 192;
            if (bl) {
                n3 += 23;
            }
            if (!this.nextPage) {
                n4 += 13;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, n3, n4, 23, 13);
        }
    }
}

