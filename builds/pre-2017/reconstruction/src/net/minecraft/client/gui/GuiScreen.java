/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScreen
extends Gui {
    public Minecraft mc;
    public int width;
    public int height;
    public List buttonList = new ArrayList();
    public boolean allowUserInput;
    public FontRenderer fontRenderer;
    public GuiButton selectedButton;
    public int eventButton;
    public long lastMouseEvent;
    public int field_92018_d;

    public void drawScreen(int n, int n2, float f) {
        for (int i = 0; i < this.buttonList.size(); ++i) {
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            guiButton.drawButton(this.mc, n, n2);
        }
    }

    public void keyTyped(char c, int n) {
        if (n == 1) {
            this.mc._a((GuiScreen)null);
            this.mc._o();
        }
    }

    public static String getClipboardString() {
        try {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String)transferable.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "";
    }

    public static void setClipboardString(String string) {
        try {
            StringSelection stringSelection = new StringSelection(string);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void mouseClicked(int n, int n2, int n3) {
        if (n3 == 0) {
            for (int i = 0; i < this.buttonList.size(); ++i) {
                GuiButton guiButton = (GuiButton)this.buttonList.get(i);
                if (!guiButton.mousePressed(this.mc, n, n2)) continue;
                this.selectedButton = guiButton;
                this.mc._N._a("random.click", 1.0f, 1.0f);
                this.actionPerformed(guiButton);
            }
        }
    }

    public void mouseMovedOrUp(int n, int n2, int n3) {
        if (this.selectedButton != null && n3 == 0) {
            this.selectedButton.mouseReleased(n, n2);
            this.selectedButton = null;
        }
    }

    public void mouseClickMove(int n, int n2, int n3, long l) {
    }

    public void actionPerformed(GuiButton guiButton) {
    }

    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        this.mc = minecraft;
        this.fontRenderer = minecraft._z;
        this.width = n;
        this.height = n2;
        this.buttonList.clear();
        this.initGui();
    }

    public void initGui() {
    }

    public void handleInput() {
        while (Mouse.next()) {
            this.handleMouseInput();
        }
        while (Keyboard.next()) {
            this.handleKeyboardInput();
        }
    }

    public void handleMouseInput() {
        int n = Mouse.getEventX() * this.width / this.mc._n;
        int n2 = this.height - Mouse.getEventY() * this.height / this.mc._o - 1;
        int n3 = Mouse.getEventButton();
        if (Minecraft._b && n3 == 0 && (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157))) {
            n3 = 1;
        }
        if (Mouse.getEventButtonState()) {
            if (this.mc._M.touchscreen && this.field_92018_d++ > 0) {
                return;
            }
            this.eventButton = n3;
            this.lastMouseEvent = Minecraft._M();
            this.mouseClicked(n, n2, this.eventButton);
        } else if (n3 != -1) {
            if (this.mc._M.touchscreen && --this.field_92018_d > 0) {
                return;
            }
            this.eventButton = -1;
            this.mouseMovedOrUp(n, n2, n3);
        } else if (this.eventButton != -1 && this.lastMouseEvent > 0L) {
            long l = Minecraft._M() - this.lastMouseEvent;
            this.mouseClickMove(n, n2, this.eventButton, l);
        }
    }

    public void handleKeyboardInput() {
        if (Keyboard.getEventKeyState()) {
            int n = Keyboard.getEventKey();
            char c = Keyboard.getEventCharacter();
            if (n == 87) {
                this.mc._r();
                return;
            }
            this.keyTyped(c, n);
        }
    }

    public void updateScreen() {
    }

    public void onGuiClosed() {
    }

    public void drawDefaultBackground() {
        this.drawWorldBackground(0);
    }

    public void drawWorldBackground(int n) {
        if (this.mc._r != null) {
            this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
        } else {
            this.drawBackground(n);
        }
    }

    public void drawBackground(int n) {
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.instance;
        this.mc._R()._a(optionsBackground);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x404040);
        tessellator.addVertexWithUV(0.0, this.height, 0.0, 0.0, (float)this.height / f + (float)n);
        tessellator.addVertexWithUV(this.width, this.height, 0.0, (float)this.width / f, (float)this.height / f + (float)n);
        tessellator.addVertexWithUV(this.width, 0.0, 0.0, (float)this.width / f, n);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, 0.0, n);
        tessellator.draw();
    }

    public boolean doesGuiPauseGame() {
        return true;
    }

    public void confirmClicked(boolean bl, int n) {
    }

    public static boolean isCtrlKeyDown() {
        if (Minecraft._b) {
            return Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
        }
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
}

