/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcMenu;
import noppes.npcs.client.gui.util.GuiNpcSlider;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumPacketType;
import org.lwjgl.opengl.GL11;

public abstract class GuiNPCInterface2
extends GuiScreen {
    public int guiLeft;
    public int guiTop;
    public int guiWidth;
    public EntityPlayer player;
    public boolean drawDefaultBackground = true;
    public EntityNPCInterface npc;
    private ResourceLocation background = new ResourceLocation("customnpcs:textures/gui/menubg.png");
    private GuiNpcMenu menu;
    private SubGuiInterface subgui;
    protected boolean npcAccess = false;

    public GuiNPCInterface2(EntityNPCInterface entityNPCInterface) {
        this(entityNPCInterface, -1);
    }

    public GuiNPCInterface2(EntityNPCInterface entityNPCInterface, int n) {
        this.player = Minecraft._E()._t;
        this.npc = entityNPCInterface;
        this.guiWidth = 420;
        this.menu = new GuiNpcMenu(this, n, entityNPCInterface);
    }

    @Override
    public void initGui() {
        super.initGui();
        if (this.subgui != null) {
            this.subgui.setWorldAndResolution(this.mc, this.width, this.height);
            this.subgui.initGui();
        }
        this.buttonList.clear();
        this.guiLeft = (this.width - this.guiWidth) / 2;
        this.guiTop = (this.height - 200) / 2;
        this.menu.initGui(this.guiLeft, this.guiTop, this.guiWidth);
    }

    protected void disableAll(Predicate<GuiButton> predicate) {
        for (GuiButton gui : this.buttonList) {
            if (predicate != null && !predicate.test(gui)) continue;
            gui.enabled = false;
        }
        for (GuiNpcTextField guiNpcTextField : this.menu.getAllTextfields()) {
            guiNpcTextField.enabled = false;
        }
    }

    @Override
    public void updateScreen() {
        this.menu.updateScreen();
        if (this.subgui != null) {
            this.subgui.updateScreen();
        }
        super.updateScreen();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        if (this.subgui != null) {
            this.subgui.mouseClicked(n, n2, n3);
        } else {
            this.menu.mouseClicked(n, n2, n3);
            this.mouseEvent(n, n2, n3);
            super.mouseClicked(n, n2, n3);
        }
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        super.mouseMovedOrUp(n, n2, n3);
        if (this.subgui != null) {
            this.subgui.mouseMovedOrUp(n, n2, n3);
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
    }

    public void mouseEvent(int n, int n2, int n3) {
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (this.subgui != null) {
            this.subgui.buttonEvent(guiButton);
        } else {
            this.buttonEvent(guiButton);
        }
    }

    public void buttonEvent(GuiButton guiButton) {
    }

    public void clearAllTextFields() {
        this.menu.clearAllTextFields();
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl) {
            NoppesUtil.sendData(EnumPacketType.Delete, new Object[0]);
            this.mc._a((GuiScreen)null);
            this.mc._o();
        } else {
            this.mc._a(this);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this.subgui != null) {
            this.subgui.keyTyped(c, n);
        } else {
            this.menu.keyTyped(c, n);
        }
    }

    public void close() {
        GuiNpcTextField.unfocus();
        this.save();
        this.mc._a((GuiScreen)null);
        this.mc._o();
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.menu.addButton(guiNpcButton);
        this.buttonList.add(guiNpcButton);
    }

    public void addScroll(GuiCustomScroll guiCustomScroll) {
        this.menu.addScroll(guiCustomScroll, this.mc);
    }

    public GuiNpcButton getButton(int n) {
        return this.menu.getButton(n);
    }

    public void addSlider(GuiNpcSlider guiNpcSlider) {
        this.menu.addSlider(guiNpcSlider);
        this.buttonList.add(guiNpcSlider);
    }

    public GuiNpcSlider getSlider(int n) {
        return this.menu.getSlider(n);
    }

    public void addTextField(GuiNpcTextField guiNpcTextField) {
        this.menu.addTextField(guiNpcTextField);
    }

    public GuiNpcTextField getTextField(int n) {
        return this.menu.getTextField(n);
    }

    public void addLabel(GuiNpcLabel guiNpcLabel) {
        this.menu.addLabel(guiNpcLabel);
    }

    public GuiNpcLabel getLabel(int n) {
        return this.menu.getLabel(n);
    }

    public void delete() {
        this.npc.delete();
        this.mc._a((GuiScreen)null);
        this.mc._o();
    }

    public abstract void save();

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.drawDefaultBackground && this.subgui == null) {
            this.drawDefaultBackground();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.background);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 200, 220);
        this.drawTexturedModalRect(this.guiLeft + this.guiWidth - 230, this.guiTop, 26, 0, 230, 220);
        this.menu.drawElements(this.fontRenderer, n, n2, this.mc, f);
        super.drawScreen(n, n2, f);
        if (this.subgui != null) {
            this.subgui.drawScreen(n, n2, f);
        }
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }

    public boolean drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator, String string) {
        return false;
    }

    public void elementClicked() {
        if (this.subgui != null) {
            this.subgui.elementClicked();
        }
    }

    public void doubleClicked() {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void closeSubGui(SubGuiInterface subGuiInterface) {
        this.subgui = null;
    }

    public boolean hasSubGui() {
        return this.subgui != null;
    }

    public void setSubGuiData(NBTTagCompound nBTTagCompound) {
        ((IGuiData)((Object)this.subgui)).setGuiData(nBTTagCompound);
    }

    public SubGuiInterface getSubGui() {
        return this.subgui;
    }

    public void setSubGui(SubGuiInterface subGuiInterface) {
        this.subgui = subGuiInterface;
        this.subgui.setWorldAndResolution(this.mc, this.width, this.height);
        this.subgui.parent = this;
        this.initGui();
    }
}

