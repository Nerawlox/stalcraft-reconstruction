/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiMenuSideButton;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcSlider;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class GuiNPCInterface
extends GuiScreen {
    public EntityPlayer player;
    public boolean drawDefaultBackground = true;
    public EntityNPCInterface npc;
    public String title;
    public boolean closeOnEsc = false;
    public int guiLeft;
    public int guiTop;
    public int xSize;
    public int ySize;
    private HashMap buttons = new HashMap();
    private HashMap topbuttons = new HashMap();
    private HashMap sidebuttons = new HashMap();
    private HashMap textfields = new HashMap();
    private HashMap labels = new HashMap();
    private HashMap scrolls = new HashMap();
    private HashMap sliders = new HashMap();
    private ResourceLocation background = null;

    public GuiNPCInterface(EntityNPCInterface entityNPCInterface) {
        this.player = Minecraft._E()._t;
        this.npc = entityNPCInterface;
        this.title = "";
        this.xSize = 200;
        this.ySize = 222;
    }

    public GuiNPCInterface() {
        this(null);
    }

    public void setBackground(String string) {
        this.background = new ResourceLocation("customnpcs", "textures/gui/" + string);
    }

    public ResourceLocation getResource(String string) {
        return new ResourceLocation("customnpcs", "textures/gui/" + string);
    }

    @Override
    public void initGui() {
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.buttonList.clear();
        this.labels.clear();
        this.textfields.clear();
        this.buttons.clear();
        this.sidebuttons.clear();
        this.topbuttons.clear();
        this.scrolls.clear();
        this.sliders.clear();
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    public void updateScreen() {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.updateCursorCounter();
        }
        super.updateScreen();
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        for (GuiNpcTextField gui : this.textfields.values().toArray(new GuiNpcTextField[this.textfields.size()])) {
            if (!gui.enabled) continue;
            gui.mouseClicked(n, n2, n3);
        }
        if (n3 == 0) {
            for (GuiCustomScroll guiCustomScroll : this.scrolls.values()) {
                guiCustomScroll.mouseClicked(n, n2, n3);
            }
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        this.buttonEvent(guiButton);
    }

    public void buttonEvent(GuiButton guiButton) {
    }

    @Override
    public void keyTyped(char c, int n) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.textboxKeyTyped(c, n);
        }
        if (this.closeOnEsc && n == 1) {
            this.close();
        }
    }

    public void close() {
        this.mc._a((GuiScreen)null);
        this.mc._o();
        this.save();
    }

    public void addButton(int n, GuiNpcButton guiNpcButton) {
        this.buttons.put(n, guiNpcButton);
        this.buttonList.add(guiNpcButton);
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.buttons.put(guiNpcButton.id, guiNpcButton);
        this.buttonList.add(guiNpcButton);
    }

    public void addTopButton(GuiMenuTopButton guiMenuTopButton) {
        this.topbuttons.put(guiMenuTopButton.id, guiMenuTopButton);
        this.buttonList.add(guiMenuTopButton);
    }

    public void addSideButton(GuiMenuSideButton guiMenuSideButton) {
        this.sidebuttons.put(guiMenuSideButton.id, guiMenuSideButton);
        this.buttonList.add(guiMenuSideButton);
    }

    public GuiNpcButton getButton(int n) {
        return (GuiNpcButton)this.buttons.get(n);
    }

    public GuiMenuSideButton getSideButton(int n) {
        return (GuiMenuSideButton)this.sidebuttons.get(n);
    }

    public void addTextField(int n, GuiNpcTextField guiNpcTextField) {
        this.textfields.put(n, guiNpcTextField);
    }

    public void addTextField(GuiNpcTextField guiNpcTextField) {
        this.textfields.put(guiNpcTextField.id, guiNpcTextField);
    }

    public GuiNpcTextField getTextField(int n) {
        return (GuiNpcTextField)this.textfields.get(n);
    }

    public void addLabel(GuiNpcLabel guiNpcLabel) {
        this.labels.put(guiNpcLabel.id, guiNpcLabel);
    }

    public GuiNpcLabel getLabel(int n) {
        return (GuiNpcLabel)this.labels.get(n);
    }

    public void addScroll(GuiCustomScroll guiCustomScroll, Minecraft minecraft) {
        guiCustomScroll.setWorldAndResolution(minecraft, 350, 250);
        this.scrolls.put(guiCustomScroll.id, guiCustomScroll);
    }

    public void addSlider(GuiNpcSlider guiNpcSlider) {
        this.sliders.put(guiNpcSlider.id, guiNpcSlider);
        this.buttonList.add(guiNpcSlider);
    }

    public GuiNpcSlider getSlider(int n) {
        return (GuiNpcSlider)this.sliders.get(n);
    }

    public GuiCustomScroll getScroll(int n) {
        return (GuiCustomScroll)this.scrolls.get(n);
    }

    public abstract void save();

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.drawDefaultBackground) {
            this.drawDefaultBackground();
        }
        if (this.background != null && this.mc._h != null) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc._h._a(this.background);
            this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        }
        this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
        for (Object object : this.labels.values()) {
            ((GuiNpcLabel)object).drawLabel(this, this.fontRenderer);
        }
        for (Object object : this.textfields.values()) {
            ((GuiTextField)object).drawTextBox();
        }
        for (Object object : this.scrolls.values()) {
            ((GuiCustomScroll)object).drawScreen(n, n2, f);
        }
        super.drawScreen(n, n2, f);
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }

    public boolean drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator, String string) {
        return false;
    }

    public void elementClicked() {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void doubleClicked() {
    }
}

