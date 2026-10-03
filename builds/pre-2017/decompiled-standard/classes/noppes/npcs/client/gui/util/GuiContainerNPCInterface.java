/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.HashMap;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import org.lwjgl.input.Keyboard;

public abstract class GuiContainerNPCInterface
extends zybc {
    public EntityClientPlayerMP player;
    public EntityNPCInterface npc;
    public String title;
    public boolean closeOnEsc = false;
    private HashMap buttons = new HashMap();
    private HashMap textfields = new HashMap();
    private HashMap labels = new HashMap();

    public GuiContainerNPCInterface(EntityNPCInterface entityNPCInterface, jjgc jjgc2) {
        super(jjgc2);
        this.player = xpzm._E()._t;
        this.npc = entityNPCInterface;
        this.title = "Npc Mainmenu";
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.clear();
        this.buttons.clear();
        this.textfields.clear();
        Keyboard.enableRepeatEvents(true);
    }

    public ResourceLocation getResource(String string) {
        return new ResourceLocation("customnpcs", "textures/gui/" + string);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.func_73780_a();
        }
        super.func_73876_c();
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.func_73793_a(n, n2, n3);
        }
        super.func_73864_a(n, n2, n3);
    }

    @Override
    protected void func_73869_a(char c, int n) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.func_73802_a(c, n);
        }
        if (this.closeOnEsc && (n == 1 || n == this.field_73882_e._M.field_74315_B._d)) {
            this.close();
        }
    }

    public void close() {
        this.save();
        this.player.func_71053_j();
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.buttons.put(guiNpcButton.field_73741_f, guiNpcButton);
        this.field_73887_h.add(guiNpcButton);
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
    protected void func_74189_g(int n, int n2) {
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        this.func_73732_a(this.field_73886_k, this.title, this.field_73880_f / 2, 10, 0xFFFFFF);
        for (Object object : this.labels.values()) {
            ((GuiNpcLabel)object).drawLabel(this, this.field_73886_k);
        }
        for (Object object : this.textfields.values()) {
            ((ifms)object).func_73795_f();
        }
    }

    public abstract void save();

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    public qncw getFontRenderer() {
        return this.field_73886_k;
    }
}

