/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.function.Predicate;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
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
extends gqjz {
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
        this.player = xpzm._E()._t;
        this.npc = entityNPCInterface;
        this.guiWidth = 420;
        this.menu = new GuiNpcMenu(this, n, entityNPCInterface);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        if (this.subgui != null) {
            this.subgui.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
            this.subgui.func_73866_w_();
        }
        this.field_73887_h.clear();
        this.guiLeft = (this.field_73880_f - this.guiWidth) / 2;
        this.guiTop = (this.field_73881_g - 200) / 2;
        this.menu.initGui(this.guiLeft, this.guiTop, this.guiWidth);
    }

    protected void disableAll(Predicate<jiok> predicate) {
        for (jiok bawa2 : this.field_73887_h) {
            if (predicate != null && !predicate.test(bawa2)) continue;
            bawa2.field_73742_g = false;
        }
        for (GuiNpcTextField guiNpcTextField : this.menu.getAllTextfields()) {
            guiNpcTextField.enabled = false;
        }
    }

    @Override
    public void func_73876_c() {
        this.menu.updateScreen();
        if (this.subgui != null) {
            this.subgui.func_73876_c();
        }
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

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
        if (this.subgui != null) {
            this.subgui.func_73879_b(n, n2, n3);
        }
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
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

    public void clearAllTextFields() {
        this.menu.clearAllTextFields();
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl) {
            NoppesUtil.sendData(EnumPacketType.Delete, new Object[0]);
            this.field_73882_e._a((gqjz)null);
            this.field_73882_e._o();
        } else {
            this.field_73882_e._a(this);
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
        this.field_73882_e._a((gqjz)null);
        this.field_73882_e._o();
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.menu.addButton(guiNpcButton);
        this.field_73887_h.add(guiNpcButton);
    }

    public void addScroll(GuiCustomScroll guiCustomScroll) {
        this.menu.addScroll(guiCustomScroll, this.field_73882_e);
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

    public abstract void save();

    @Override
    public void func_73863_a(int n, int n2, float f) {
        if (this.drawDefaultBackground && this.subgui == null) {
            this.func_73873_v_();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.background);
        this.func_73729_b(this.guiLeft, this.guiTop, 0, 0, 200, 220);
        this.func_73729_b(this.guiLeft + this.guiWidth - 230, this.guiTop, 26, 0, 230, 220);
        this.menu.drawElements(this.field_73886_k, n, n2, this.field_73882_e, f);
        super.func_73863_a(n, n2, f);
        if (this.subgui != null) {
            this.subgui.func_73863_a(n, n2, f);
        }
    }

    public qncw getFontRenderer() {
        return this.field_73886_k;
    }

    public boolean drawSlot(int n, int n2, int n3, int n4, htvf htvf2, String string) {
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
    public boolean func_73868_f() {
        return false;
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

