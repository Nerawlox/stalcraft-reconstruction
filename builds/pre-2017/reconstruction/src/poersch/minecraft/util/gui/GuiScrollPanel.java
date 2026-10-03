/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.util.gui.GuiButton;

public class GuiScrollPanel
extends GuiButton {
    List<GuiButton> buttonList = new ArrayList<GuiButton>();
    public GuiButton selectedButton;
    protected float sliderValue = 0.0f;
    protected float sliderSize = 1.0f;
    protected float distToMouse = 0.0f;
    protected boolean dragged = false;
    protected int padding;
    protected int right;
    protected int bottom;

    public GuiScrollPanel(int n, int n2, int n3, int n4, int n5, int n6) {
        super(n, n2, n3, n4, n5, "");
        this.padding = n6;
        this.right = n2 + n4;
        this.bottom = n3 + n5;
    }

    @Override
    protected int getHoverState(boolean bl) {
        return 0;
    }

    protected int getButtonHeight(GuiButton guiButton) {
        try {
            return (Integer)ReflectionHelper.getPrivateValue(GuiButton.class, guiButton, 2);
        }
        catch (Exception exception) {
            return 20;
        }
    }

    public void updateSliderSize() {
        int n = this.height;
        int n2 = this.padding * 2;
        for (int i = 0; i < this.buttonList.size(); ++i) {
            GuiButton guiButton = this.buttonList.get(i);
            if (guiButton.yPosition + guiButton.getHeight() + n2 <= n) continue;
            n = guiButton.yPosition + guiButton.getHeight() + n2;
        }
        this.sliderSize = (float)this.height / (float)n;
        if (this.sliderSize > 1.0f) {
            this.sliderSize = 1.0f;
        }
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            int n3;
            int n4;
            int n5;
            this.mouseDragged(minecraft, n, n2);
            this.mouseScrolled(minecraft, n, n2);
            this.drawGradientRect(this.xPosition, this.yPosition, this.right, this.bottom, -1072689136, -804253680);
            float f = (float)minecraft._n / (float)minecraft._B.width;
            float f2 = (float)minecraft._o / (float)minecraft._B.height;
            GL11.glEnable(3089);
            GL11.glScissor((int)((float)this.xPosition * f), (int)((float)(minecraft._B.height - this.bottom) * f2), (int)((float)this.width * f), (int)((float)this.height * f2));
            int n6 = this.xPosition;
            int n7 = this.yPosition + this.padding - (int)(this.sliderValue * (float)this.height / this.sliderSize + 0.5f);
            for (n5 = 0; n5 < this.buttonList.size(); ++n5) {
                GuiButton guiButton = this.buttonList.get(n5);
                if (guiButton.yPosition + n7 + guiButton.getHeight() < this.yPosition || guiButton.yPosition + n7 > this.bottom) continue;
                n4 = guiButton.xPosition;
                n3 = guiButton.yPosition;
                guiButton.xPosition += n6;
                guiButton.yPosition += n7;
                guiButton.drawButton(minecraft, n, n2);
                guiButton.xPosition = n4;
                guiButton.yPosition = n3;
            }
            GL11.glDisable(3089);
            this.drawGradientRect(this.xPosition, this.yPosition, this.right, this.yPosition + 4, -16777216, 0);
            this.drawGradientRect(this.xPosition, this.bottom - 4, this.right, this.bottom, 0, -16777216);
            GuiScrollPanel.drawRect(this.right - 6, this.yPosition, this.right, this.bottom, -16777216);
            n5 = this.yPosition + (int)(this.sliderValue * (float)this.height);
            int n8 = this.yPosition + (int)((this.sliderValue + this.sliderSize) * (float)this.height);
            n4 = -11250604;
            n3 = -8487298;
            if (n >= this.right - 6 && n <= this.right && n2 >= this.yPosition && n2 <= this.bottom) {
                n4 = -10721635;
                n3 = -8484673;
            }
            if (this.dragged) {
                int n9 = n4;
                n4 = n3;
                n3 = n9;
            }
            GuiScrollPanel.drawRect(this.right - 6, n5, this.right, n8, n4);
            GuiScrollPanel.drawRect(this.right - 6, n5, this.right - 1, n8 - 1, n3);
        }
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        if (super.mousePressed(minecraft, n, n2)) {
            if (n >= this.right - 6) {
                float f = (float)(n2 - this.yPosition) / (float)this.height;
                if (f < this.sliderValue) {
                    this.sliderValue = f;
                    this.distToMouse = 0.0f;
                } else if (f > this.sliderValue + this.sliderSize) {
                    this.sliderValue = f + this.sliderSize;
                    this.distToMouse = this.sliderSize;
                } else {
                    this.distToMouse = f - this.sliderValue;
                }
                this.dragged = true;
                return true;
            }
            int n3 = this.xPosition;
            int n4 = this.yPosition + this.padding - (int)(this.sliderValue * (float)this.height / this.sliderSize + 0.5f);
            for (int i = 0; i < this.buttonList.size(); ++i) {
                GuiButton guiButton = this.buttonList.get(i);
                if (guiButton.yPosition + n4 + 20 < this.yPosition || guiButton.yPosition + n4 > this.bottom) continue;
                int n5 = guiButton.xPosition;
                int n6 = guiButton.yPosition;
                guiButton.xPosition += n3;
                guiButton.yPosition += n4;
                if (guiButton.mousePressed(minecraft, n, n2)) {
                    this.selectedButton = guiButton;
                    guiButton.xPosition = n5;
                    guiButton.yPosition = n6;
                    return true;
                }
                guiButton.xPosition = n5;
                guiButton.yPosition = n6;
            }
        }
        return false;
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int n, int n2) {
        if (this.dragged) {
            this.sliderValue = (float)(n2 - this.yPosition) / (float)this.height - this.distToMouse;
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            } else if (this.sliderValue > 1.0f - this.sliderSize) {
                this.sliderValue = 1.0f - this.sliderSize;
            }
        }
    }

    protected void mouseScrolled(Minecraft minecraft, int n, int n2) {
        int n3 = Mouse.getDWheel();
        if (!this.dragged && n3 != 0 && n >= this.xPosition && n <= this.right && n2 >= this.yPosition && n2 <= this.bottom) {
            this.sliderValue += n3 > 0 ? -0.06f : 0.06f;
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            } else if (this.sliderValue > 1.0f - this.sliderSize) {
                this.sliderValue = 1.0f - this.sliderSize;
            }
        }
    }

    @Override
    public void mouseReleased(int n, int n2) {
        if (this.selectedButton != null) {
            this.selectedButton.mouseReleased(n, n2);
            this.selectedButton = null;
        }
        this.dragged = false;
    }

    @Override
    public GuiButton mouseOver() {
        if (this.selectedButton == null) {
            for (int i = 0; i < this.buttonList.size(); ++i) {
                GuiButton guiButton = this.buttonList.get(i).mouseOver();
                if (guiButton == null) continue;
                return guiButton;
            }
        }
        return null;
    }
}

