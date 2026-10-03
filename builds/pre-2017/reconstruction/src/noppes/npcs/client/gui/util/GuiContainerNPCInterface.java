/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import org.lwjgl.input.Keyboard;

public abstract class GuiContainerNPCInterface
extends GuiContainer {
    public EntityClientPlayerMP player;
    public EntityNPCInterface npc;
    public String title;
    public boolean closeOnEsc = false;
    private HashMap buttons = new HashMap();
    private HashMap textfields = new HashMap();
    private HashMap labels = new HashMap();

    public GuiContainerNPCInterface(EntityNPCInterface entityNPCInterface, Container container) {
        super(container);
        this.player = Minecraft._E()._t;
        this.npc = entityNPCInterface;
        this.title = "Npc Mainmenu";
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.buttons.clear();
        this.textfields.clear();
        Keyboard.enableRepeatEvents(true);
    }

    public ResourceLocation getResource(String string) {
        return new ResourceLocation("customnpcs", "textures/gui/" + string);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.updateCursorCounter();
        }
        super.updateScreen();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.mouseClicked(n, n2, n3);
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void keyTyped(char c, int n) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.textboxKeyTyped(c, n);
        }
        if (this.closeOnEsc && (n == 1 || n == this.mc._M.keyBindInventory._d)) {
            this.close();
        }
    }

    public void close() {
        this.save();
        this.player.closeScreen();
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.buttons.put(guiNpcButton.id, guiNpcButton);
        this.buttonList.add(guiNpcButton);
    }

    public GuiNpcButton getButton(int n) {
        return (GuiNpcButton)this.buttons.get(n);
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

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
        for (Object object : this.labels.values()) {
            ((GuiNpcLabel)object).drawLabel(this, this.fontRenderer);
        }
        for (Object object : this.textfields.values()) {
            ((GuiTextField)object).drawTextBox();
        }
    }

    public abstract void save();

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
}

