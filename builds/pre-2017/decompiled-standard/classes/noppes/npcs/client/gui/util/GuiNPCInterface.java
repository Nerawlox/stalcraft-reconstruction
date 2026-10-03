/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.HashMap;
import net.minecraft.client.xpzm;
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
extends gqjz {
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
        this.player = xpzm._E()._t;
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
    public void func_73866_w_() {
        this.guiLeft = (this.field_73880_f - this.xSize) / 2;
        this.guiTop = (this.field_73881_g - this.ySize) / 2;
        this.field_73887_h.clear();
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
    public void func_73876_c() {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.func_73780_a();
        }
        super.func_73876_c();
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        for (GuiNpcTextField bawa2 : this.textfields.values().toArray(new GuiNpcTextField[this.textfields.size()])) {
            if (!bawa2.enabled) continue;
            bawa2.func_73793_a(n, n2, n3);
        }
        if (n3 == 0) {
            for (GuiCustomScroll guiCustomScroll : this.scrolls.values()) {
                guiCustomScroll.func_73864_a(n, n2, n3);
            }
        }
        super.func_73864_a(n, n2, n3);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        this.buttonEvent(jiok2);
    }

    public void buttonEvent(jiok jiok2) {
    }

    @Override
    public void func_73869_a(char c, int n) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.func_73802_a(c, n);
        }
        if (this.closeOnEsc && n == 1) {
            this.close();
        }
    }

    public void close() {
        this.field_73882_e._a((gqjz)null);
        this.field_73882_e._o();
        this.save();
    }

    public void addButton(int n, GuiNpcButton guiNpcButton) {
        this.buttons.put(n, guiNpcButton);
        this.field_73887_h.add(guiNpcButton);
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.buttons.put(guiNpcButton.field_73741_f, guiNpcButton);
        this.field_73887_h.add(guiNpcButton);
    }

    public void addTopButton(GuiMenuTopButton guiMenuTopButton) {
        this.topbuttons.put(guiMenuTopButton.field_73741_f, guiMenuTopButton);
        this.field_73887_h.add(guiMenuTopButton);
    }

    public void addSideButton(GuiMenuSideButton guiMenuSideButton) {
        this.sidebuttons.put(guiMenuSideButton.field_73741_f, guiMenuSideButton);
        this.field_73887_h.add(guiMenuSideButton);
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

    public void addScroll(GuiCustomScroll guiCustomScroll, xpzm xpzm2) {
        guiCustomScroll.func_73872_a(xpzm2, 350, 250);
        this.scrolls.put(guiCustomScroll.id, guiCustomScroll);
    }

    public void addSlider(GuiNpcSlider guiNpcSlider) {
        this.sliders.put(guiNpcSlider.field_73741_f, guiNpcSlider);
        this.field_73887_h.add(guiNpcSlider);
    }

    public GuiNpcSlider getSlider(int n) {
        return (GuiNpcSlider)this.sliders.get(n);
    }

    public GuiCustomScroll getScroll(int n) {
        return (GuiCustomScroll)this.scrolls.get(n);
    }

    public abstract void save();

    @Override
    public void func_73863_a(int n, int n2, float f) {
        if (this.drawDefaultBackground) {
            this.func_73873_v_();
        }
        if (this.background != null && this.field_73882_e._h != null) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_73882_e._h._a(this.background);
            this.func_73729_b(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        }
        this.func_73732_a(this.field_73886_k, this.title, this.field_73880_f / 2, 10, 0xFFFFFF);
        for (Object object : this.labels.values()) {
            ((GuiNpcLabel)object).drawLabel(this, this.field_73886_k);
        }
        for (Object object : this.textfields.values()) {
            ((ifms)object).func_73795_f();
        }
        for (Object object : this.scrolls.values()) {
            ((GuiCustomScroll)object).func_73863_a(n, n2, f);
        }
        super.func_73863_a(n, n2, f);
    }

    public qncw getFontRenderer() {
        return this.field_73886_k;
    }

    public boolean drawSlot(int n, int n2, int n3, int n4, htvf htvf2, String string) {
        return false;
    }

    public void elementClicked() {
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    public void doubleClicked() {
    }
}

