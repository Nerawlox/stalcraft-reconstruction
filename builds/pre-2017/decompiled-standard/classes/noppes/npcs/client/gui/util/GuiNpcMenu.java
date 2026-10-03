/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.Collection;
import java.util.HashMap;
import net.minecraft.client.xpzm;
import net.minecraft.util.tdpx;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcSlider;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import org.lwjgl.input.Keyboard;

public class GuiNpcMenu {
    private gqjz parent;
    private HashMap buttons = new HashMap();
    private HashMap sliders = new HashMap();
    private HashMap textfields = new HashMap();
    private HashMap labels = new HashMap();
    private HashMap scrolls = new HashMap();
    private GuiMenuTopButton[] topButtons;
    private int activeMenu;
    private EntityNPCInterface npc;

    public GuiNpcMenu(gqjz gqjz2, int n, EntityNPCInterface entityNPCInterface) {
        this.parent = gqjz2;
        this.activeMenu = n;
        this.npc = entityNPCInterface;
    }

    public void initGui(int n, int n2, int n3) {
        this.labels.clear();
        this.textfields.clear();
        this.buttons.clear();
        this.sliders.clear();
        this.scrolls.clear();
        Keyboard.enableRepeatEvents(true);
        GuiMenuTopButton guiMenuTopButton = new GuiMenuTopButton(1, n + 4, n2 - 17, "menu.display");
        GuiMenuTopButton guiMenuTopButton2 = new GuiMenuTopButton(2, guiMenuTopButton.field_73746_c + guiMenuTopButton.getWidth(), n2 - 17, "menu.stats");
        GuiMenuTopButton guiMenuTopButton3 = new GuiMenuTopButton(6, guiMenuTopButton2.field_73746_c + guiMenuTopButton2.getWidth(), n2 - 17, "menu.ai");
        GuiMenuTopButton guiMenuTopButton4 = new GuiMenuTopButton(3, guiMenuTopButton3.field_73746_c + guiMenuTopButton3.getWidth(), n2 - 17, "npc.inventory");
        GuiMenuTopButton guiMenuTopButton5 = new GuiMenuTopButton(4, guiMenuTopButton4.field_73746_c + guiMenuTopButton4.getWidth(), n2 - 17, "menu.advanced");
        GuiMenuTopButton guiMenuTopButton6 = new GuiMenuTopButton(5, guiMenuTopButton5.field_73746_c + guiMenuTopButton5.getWidth(), n2 - 17, "menu.global");
        GuiMenuTopButton guiMenuTopButton7 = new GuiMenuTopButton(0, n + n3 - 22, n2 - 17, "X");
        GuiMenuTopButton guiMenuTopButton8 = new GuiMenuTopButton(66, n + n3 - 72, n2 - 17, "selectWorld.deleteButton");
        guiMenuTopButton8.field_73746_c = guiMenuTopButton7.field_73746_c - guiMenuTopButton8.getWidth();
        for (GuiMenuTopButton guiMenuTopButton9 : this.topButtons = new GuiMenuTopButton[]{guiMenuTopButton, guiMenuTopButton2, guiMenuTopButton3, guiMenuTopButton4, guiMenuTopButton5, guiMenuTopButton6, guiMenuTopButton7, guiMenuTopButton8}) {
            guiMenuTopButton9.active = guiMenuTopButton9.field_73741_f == this.activeMenu;
        }
    }

    private void topButtonPressed(GuiMenuTopButton guiMenuTopButton) {
        if (!guiMenuTopButton.field_73744_e.equals(this.activeMenu)) {
            xpzm xpzm2 = xpzm._E();
            xpzm2._N._a("random.click", 1.0f, 1.0f);
            if (guiMenuTopButton.field_73741_f == 0) {
                this.close();
            } else if (guiMenuTopButton.field_73741_f == 66) {
                lowa lowa2 = new lowa(this.parent, "Confirm", tdpx._a("gui.delete"), 0);
                xpzm2._a(lowa2);
            } else {
                this.save();
                if (guiMenuTopButton.field_73741_f == 1) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuDisplay);
                } else if (guiMenuTopButton.field_73741_f == 2) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuStats);
                } else if (guiMenuTopButton.field_73741_f == 3) {
                    NoppesUtil.requestOpenGUI(EnumGuiType.MainMenuInv);
                } else if (guiMenuTopButton.field_73741_f == 4) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuAdvanced);
                } else if (guiMenuTopButton.field_73741_f == 5) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuGlobal);
                } else if (guiMenuTopButton.field_73741_f == 6) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuAI);
                }
                this.activeMenu = guiMenuTopButton.field_73741_f;
            }
        }
    }

    private void save() {
        GuiNpcTextField.unfocus();
        if (this.parent instanceof GuiContainerNPCInterface2) {
            ((GuiContainerNPCInterface2)this.parent).save();
        }
        if (this.parent instanceof GuiNPCInterface2) {
            ((GuiNPCInterface2)this.parent).save();
        }
    }

    private void close() {
        if (this.parent instanceof GuiContainerNPCInterface2) {
            ((GuiContainerNPCInterface2)this.parent).close();
        }
        if (this.parent instanceof GuiNPCInterface2) {
            ((GuiNPCInterface2)this.parent).close();
        }
        if (this.npc != null) {
            this.npc.reset();
            NoppesUtil.sendData(EnumPacketType.RemoteReset, this.npc.field_70157_k);
        }
    }

    public void updateScreen() {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.func_73780_a();
        }
    }

    public void mouseClicked(int n, int n2, int n3) {
        for (Object object : this.textfields.values()) {
            if (!((GuiNpcTextField)object).enabled) continue;
            ((GuiNpcTextField)object).func_73793_a(n, n2, n3);
        }
        if (n3 == 0) {
            Object object;
            object = xpzm._E();
            for (GuiMenuTopButton bawa2 : this.topButtons) {
                if (!bawa2.func_73736_c((xpzm)object, n, n2)) continue;
                this.topButtonPressed(bawa2);
            }
            for (GuiCustomScroll guiCustomScroll : this.scrolls.values()) {
                guiCustomScroll.func_73864_a(n, n2, n3);
            }
        }
    }

    public void keyTyped(char c, int n) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.func_73802_a(c, n);
        }
        if (n == 1) {
            this.close();
        }
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.buttons.put(guiNpcButton.field_73741_f, guiNpcButton);
    }

    public GuiNpcButton getButton(int n) {
        return (GuiNpcButton)this.buttons.get(n);
    }

    public void addSlider(GuiNpcSlider guiNpcSlider) {
        this.sliders.put(guiNpcSlider.field_73741_f, guiNpcSlider);
    }

    public GuiNpcSlider getSlider(int n) {
        return (GuiNpcSlider)this.sliders.get(n);
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

    public void drawElements(qncw qncw2, int n, int n2, xpzm xpzm2, float f) {
        for (Object object : this.labels.values()) {
            ((GuiNpcLabel)object).drawLabel(this.parent, qncw2);
        }
        for (Object object : this.textfields.values()) {
            ((ifms)object).func_73795_f();
        }
        for (GuiMenuTopButton guiMenuTopButton : this.topButtons) {
            guiMenuTopButton.func_73737_a(xpzm2, n, n2);
        }
        for (GuiCustomScroll guiCustomScroll : this.scrolls.values()) {
            guiCustomScroll.func_73863_a(n, n2, f);
        }
    }

    public Collection<GuiNpcTextField> getAllTextfields() {
        return this.textfields.values();
    }

    public void clearAllTextFields() {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.func_73782_a("0");
        }
    }
}

