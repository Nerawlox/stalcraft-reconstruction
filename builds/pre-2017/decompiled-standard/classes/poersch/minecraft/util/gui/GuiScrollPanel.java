/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;
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
    protected int func_73738_a(boolean bl) {
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
        int n = this.field_73745_b;
        int n2 = this.padding * 2;
        for (int i = 0; i < this.buttonList.size(); ++i) {
            GuiButton guiButton = this.buttonList.get(i);
            if (guiButton.field_73743_d + guiButton.getHeight() + n2 <= n) continue;
            n = guiButton.field_73743_d + guiButton.getHeight() + n2;
        }
        this.sliderSize = (float)this.field_73745_b / (float)n;
        if (this.sliderSize > 1.0f) {
            this.sliderSize = 1.0f;
        }
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            int n3;
            int n4;
            int n5;
            this.func_73739_b(xpzm2, n, n2);
            this.mouseScrolled(xpzm2, n, n2);
            this.func_73733_a(this.field_73746_c, this.field_73743_d, this.right, this.bottom, -1072689136, -804253680);
            float f = (float)xpzm2._n / (float)xpzm2._B.field_73880_f;
            float f2 = (float)xpzm2._o / (float)xpzm2._B.field_73881_g;
            GL11.glEnable(3089);
            GL11.glScissor((int)((float)this.field_73746_c * f), (int)((float)(xpzm2._B.field_73881_g - this.bottom) * f2), (int)((float)this.field_73747_a * f), (int)((float)this.field_73745_b * f2));
            int n6 = this.field_73746_c;
            int n7 = this.field_73743_d + this.padding - (int)(this.sliderValue * (float)this.field_73745_b / this.sliderSize + 0.5f);
            for (n5 = 0; n5 < this.buttonList.size(); ++n5) {
                GuiButton guiButton = this.buttonList.get(n5);
                if (guiButton.field_73743_d + n7 + guiButton.getHeight() < this.field_73743_d || guiButton.field_73743_d + n7 > this.bottom) continue;
                n4 = guiButton.field_73746_c;
                n3 = guiButton.field_73743_d;
                guiButton.field_73746_c += n6;
                guiButton.field_73743_d += n7;
                guiButton.func_73737_a(xpzm2, n, n2);
                guiButton.field_73746_c = n4;
                guiButton.field_73743_d = n3;
            }
            GL11.glDisable(3089);
            this.func_73733_a(this.field_73746_c, this.field_73743_d, this.right, this.field_73743_d + 4, -16777216, 0);
            this.func_73733_a(this.field_73746_c, this.bottom - 4, this.right, this.bottom, 0, -16777216);
            GuiScrollPanel.func_73734_a(this.right - 6, this.field_73743_d, this.right, this.bottom, -16777216);
            n5 = this.field_73743_d + (int)(this.sliderValue * (float)this.field_73745_b);
            int n8 = this.field_73743_d + (int)((this.sliderValue + this.sliderSize) * (float)this.field_73745_b);
            n4 = -11250604;
            n3 = -8487298;
            if (n >= this.right - 6 && n <= this.right && n2 >= this.field_73743_d && n2 <= this.bottom) {
                n4 = -10721635;
                n3 = -8484673;
            }
            if (this.dragged) {
                int n9 = n4;
                n4 = n3;
                n3 = n9;
            }
            GuiScrollPanel.func_73734_a(this.right - 6, n5, this.right, n8, n4);
            GuiScrollPanel.func_73734_a(this.right - 6, n5, this.right - 1, n8 - 1, n3);
        }
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        if (super.func_73736_c(xpzm2, n, n2)) {
            if (n >= this.right - 6) {
                float f = (float)(n2 - this.field_73743_d) / (float)this.field_73745_b;
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
            int n3 = this.field_73746_c;
            int n4 = this.field_73743_d + this.padding - (int)(this.sliderValue * (float)this.field_73745_b / this.sliderSize + 0.5f);
            for (int i = 0; i < this.buttonList.size(); ++i) {
                GuiButton guiButton = this.buttonList.get(i);
                if (guiButton.field_73743_d + n4 + 20 < this.field_73743_d || guiButton.field_73743_d + n4 > this.bottom) continue;
                int n5 = guiButton.field_73746_c;
                int n6 = guiButton.field_73743_d;
                guiButton.field_73746_c += n3;
                guiButton.field_73743_d += n4;
                if (guiButton.func_73736_c(xpzm2, n, n2)) {
                    this.selectedButton = guiButton;
                    guiButton.field_73746_c = n5;
                    guiButton.field_73743_d = n6;
                    return true;
                }
                guiButton.field_73746_c = n5;
                guiButton.field_73743_d = n6;
            }
        }
        return false;
    }

    @Override
    protected void func_73739_b(xpzm xpzm2, int n, int n2) {
        if (this.dragged) {
            this.sliderValue = (float)(n2 - this.field_73743_d) / (float)this.field_73745_b - this.distToMouse;
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            } else if (this.sliderValue > 1.0f - this.sliderSize) {
                this.sliderValue = 1.0f - this.sliderSize;
            }
        }
    }

    protected void mouseScrolled(xpzm xpzm2, int n, int n2) {
        int n3 = Mouse.getDWheel();
        if (!this.dragged && n3 != 0 && n >= this.field_73746_c && n <= this.right && n2 >= this.field_73743_d && n2 <= this.bottom) {
            this.sliderValue += n3 > 0 ? -0.06f : 0.06f;
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            } else if (this.sliderValue > 1.0f - this.sliderSize) {
                this.sliderValue = 1.0f - this.sliderSize;
            }
        }
    }

    @Override
    public void func_73740_a(int n, int n2) {
        if (this.selectedButton != null) {
            this.selectedButton.func_73740_a(n, n2);
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

