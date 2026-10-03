/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcMenu;
import noppes.npcs.client.gui.util.GuiNpcSlider;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumPacketType;
import org.lwjgl.opengl.GL11;

public abstract class GuiContainerNPCInterface2
extends GuiContainer {
    private final ResourceLocation defaultBackground;
    public int guiTop;
    public int guiLeft;
    public EntityPlayer player;
    public boolean drawDefaultBackground = false;
    public EntityNPCInterface npc;
    private ResourceLocation background;
    protected GuiNpcMenu menu;
    private SubGuiInterface subgui;
    private Dimension backgroundSize = new Dimension(256, 256);
    private Dimension textureSize = new Dimension(256, 256);

    public GuiContainerNPCInterface2(EntityNPCInterface entityNPCInterface, Container container) {
        this(entityNPCInterface, container, -1);
    }

    public GuiContainerNPCInterface2(EntityNPCInterface entityNPCInterface, Container container, int n) {
        super(container);
        this.background = new ResourceLocation("customnpcs", "textures/gui/menubg.png");
        this.defaultBackground = new ResourceLocation("customnpcs", "textures/gui/menubg.png");
        this.player = Minecraft._E()._t;
        this.npc = entityNPCInterface;
        this.xSize = 420;
        this.menu = new GuiNpcMenu(this, n, entityNPCInterface);
    }

    public void setBackground(String string) {
        this.background = new ResourceLocation("customnpcs", "textures/gui/" + string);
    }

    public void setBackgroundSize(Dimension dimension, Dimension dimension2) {
        this.backgroundSize = dimension;
        this.textureSize = dimension2;
    }

    public ResourceLocation getResource(String string) {
        return new ResourceLocation("customnpcs", "textures/gui/" + string);
    }

    @Override
    public void initGui() {
        super.initGui();
        if (this.subgui != null) {
            this.subgui.setWorldAndResolution(this.mc, this.width, this.height);
            this.subgui.initGui();
        }
        this.buttonList.clear();
        this.guiTop = (this.width - this.xSize) / 2;
        this.guiLeft = (this.height - 200) / 2;
        this.menu.initGui(this.guiTop, this.guiLeft, this.xSize);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.menu.updateScreen();
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

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl) {
            NoppesUtil.sendData(EnumPacketType.Delete, new Object[0]);
            this.mc._a((GuiScreen)null);
            this.mc._o();
        } else {
            NoppesUtil.openGUI(this.player, this);
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
        this.mc._t.closeScreen();
        this.mc._a((GuiScreen)null);
        this.mc._o();
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.menu.addButton(guiNpcButton);
        this.buttonList.add(guiNpcButton);
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

    @Override
    public void drawDefaultBackground() {
        if (this.drawDefaultBackground && this.subgui == null) {
            this.drawWorldBackground(0);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.defaultBackground);
        this.drawTexturedModalRect(this.guiTop + this.xSize - 200, this.guiLeft, 26, 0, 200, 220);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.background);
        qozx._a(this.guiTop, this.guiLeft, this.backgroundSize.width, this.backgroundSize.height, 0.0, 0.0, this.backgroundSize.width, this.backgroundSize.height, this.textureSize.width, this.textureSize.height);
        this.menu.drawElements(this.fontRenderer, n, n2, this.mc, f);
    }

    public abstract void save();

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.subgui != null) {
            qnon._a();
            this.subgui.drawScreen(n, n2, f);
        }
    }

    @Override
    protected void drawSlotInventory(Slot slot) {
        if (this.subgui == null) {
            super.drawSlotInventory(slot);
        }
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
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

