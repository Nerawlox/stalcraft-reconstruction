/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
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
extends zybc {
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

    public GuiContainerNPCInterface2(EntityNPCInterface entityNPCInterface, jjgc jjgc2) {
        this(entityNPCInterface, jjgc2, -1);
    }

    public GuiContainerNPCInterface2(EntityNPCInterface entityNPCInterface, jjgc jjgc2, int n) {
        super(jjgc2);
        this.background = new ResourceLocation("customnpcs", "textures/gui/menubg.png");
        this.defaultBackground = new ResourceLocation("customnpcs", "textures/gui/menubg.png");
        this.player = xpzm._E()._t;
        this.npc = entityNPCInterface;
        this.field_74194_b = 420;
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
    public void func_73866_w_() {
        super.func_73866_w_();
        if (this.subgui != null) {
            this.subgui.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
            this.subgui.func_73866_w_();
        }
        this.field_73887_h.clear();
        this.guiTop = (this.field_73880_f - this.field_74194_b) / 2;
        this.guiLeft = (this.field_73881_g - 200) / 2;
        this.menu.initGui(this.guiTop, this.guiLeft, this.field_74194_b);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        this.menu.updateScreen();
        super.func_73876_c();
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (this.subgui != null) {
            this.subgui.func_73864_a(n, n2, n3);
        } else {
            this.menu.mouseClicked(n, n2, n3);
            this.mouseEvent(n, n2, n3);
            super.func_73864_a(n, n2, n3);
        }
    }

    public void mouseEvent(int n, int n2, int n3) {
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (this.subgui != null) {
            this.subgui.buttonEvent(jiok2);
        } else {
            this.buttonEvent(jiok2);
        }
    }

    public void buttonEvent(jiok jiok2) {
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl) {
            NoppesUtil.sendData(EnumPacketType.Delete, new Object[0]);
            this.field_73882_e._a((gqjz)null);
            this.field_73882_e._o();
        } else {
            NoppesUtil.openGUI(this.player, this);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (this.subgui != null) {
            this.subgui.func_73869_a(c, n);
        } else {
            this.menu.keyTyped(c, n);
        }
    }

    public void close() {
        GuiNpcTextField.unfocus();
        this.save();
        this.field_73882_e._t.func_71053_j();
        this.field_73882_e._a((gqjz)null);
        this.field_73882_e._o();
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.menu.addButton(guiNpcButton);
        this.field_73887_h.add(guiNpcButton);
    }

    public GuiNpcButton getButton(int n) {
        return this.menu.getButton(n);
    }

    public void addSlider(GuiNpcSlider guiNpcSlider) {
        this.menu.addSlider(guiNpcSlider);
        this.field_73887_h.add(guiNpcSlider);
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
        this.field_73882_e._a((gqjz)null);
        this.field_73882_e._o();
    }

    @Override
    public void func_73873_v_() {
        if (this.drawDefaultBackground && this.subgui == null) {
            this.func_73859_b(0);
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        this.func_73873_v_();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.defaultBackground);
        this.func_73729_b(this.guiTop + this.field_74194_b - 200, this.guiLeft, 26, 0, 200, 220);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.background);
        qozx._a(this.guiTop, this.guiLeft, this.backgroundSize.width, this.backgroundSize.height, 0.0, 0.0, this.backgroundSize.width, this.backgroundSize.height, this.textureSize.width, this.textureSize.height);
        this.menu.drawElements(this.field_73886_k, n, n2, this.field_73882_e, f);
    }

    public abstract void save();

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.subgui != null) {
            qnon._a();
            this.subgui.func_73863_a(n, n2, f);
        }
    }

    @Override
    protected void func_74192_a(yeso yeso2) {
        if (this.subgui == null) {
            super.func_74192_a(yeso2);
        }
    }

    public qncw getFontRenderer() {
        return this.field_73886_k;
    }

    public void closeSubGui(SubGuiInterface subGuiInterface) {
        this.subgui = null;
    }

    public boolean hasSubGui() {
        return this.subgui != null;
    }

    public void setSubGuiData(qoac qoac2) {
        ((IGuiData)((Object)this.subgui)).setGuiData(qoac2);
    }

    public SubGuiInterface getSubGui() {
        return this.subgui;
    }

    public void setSubGui(SubGuiInterface subGuiInterface) {
        this.subgui = subGuiInterface;
        this.subgui.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
        this.subgui.parent = this;
        this.func_73866_w_();
    }
}

