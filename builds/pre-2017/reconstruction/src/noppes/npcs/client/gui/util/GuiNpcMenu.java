/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.Collection;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiYesNo;
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
    private GuiScreen parent;
    private HashMap buttons = new HashMap();
    private HashMap sliders = new HashMap();
    private HashMap textfields = new HashMap();
    private HashMap labels = new HashMap();
    private HashMap scrolls = new HashMap();
    private GuiMenuTopButton[] topButtons;
    private int activeMenu;
    private EntityNPCInterface npc;

    public GuiNpcMenu(GuiScreen guiScreen, int n, EntityNPCInterface entityNPCInterface) {
        this.parent = guiScreen;
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
        GuiMenuTopButton guiMenuTopButton2 = new GuiMenuTopButton(2, guiMenuTopButton.xPosition + guiMenuTopButton.getWidth(), n2 - 17, "menu.stats");
        GuiMenuTopButton guiMenuTopButton3 = new GuiMenuTopButton(6, guiMenuTopButton2.xPosition + guiMenuTopButton2.getWidth(), n2 - 17, "menu.ai");
        GuiMenuTopButton guiMenuTopButton4 = new GuiMenuTopButton(3, guiMenuTopButton3.xPosition + guiMenuTopButton3.getWidth(), n2 - 17, "npc.inventory");
        GuiMenuTopButton guiMenuTopButton5 = new GuiMenuTopButton(4, guiMenuTopButton4.xPosition + guiMenuTopButton4.getWidth(), n2 - 17, "menu.advanced");
        GuiMenuTopButton guiMenuTopButton6 = new GuiMenuTopButton(5, guiMenuTopButton5.xPosition + guiMenuTopButton5.getWidth(), n2 - 17, "menu.global");
        GuiMenuTopButton guiMenuTopButton7 = new GuiMenuTopButton(0, n + n3 - 22, n2 - 17, "X");
        GuiMenuTopButton guiMenuTopButton8 = new GuiMenuTopButton(66, n + n3 - 72, n2 - 17, "selectWorld.deleteButton");
        guiMenuTopButton8.xPosition = guiMenuTopButton7.xPosition - guiMenuTopButton8.getWidth();
        for (GuiMenuTopButton guiMenuTopButton9 : this.topButtons = new GuiMenuTopButton[]{guiMenuTopButton, guiMenuTopButton2, guiMenuTopButton3, guiMenuTopButton4, guiMenuTopButton5, guiMenuTopButton6, guiMenuTopButton7, guiMenuTopButton8}) {
            guiMenuTopButton9.active = guiMenuTopButton9.id == this.activeMenu;
        }
    }

    private void topButtonPressed(GuiMenuTopButton guiMenuTopButton) {
        if (!guiMenuTopButton.displayString.equals(this.activeMenu)) {
            Minecraft minecraft = Minecraft._E();
            minecraft._N._a("random.click", 1.0f, 1.0f);
            if (guiMenuTopButton.id == 0) {
                this.close();
            } else if (guiMenuTopButton.id == 66) {
                GuiYesNo guiYesNo = new GuiYesNo(this.parent, "Confirm", tdpx._a("gui.delete"), 0);
                minecraft._a(guiYesNo);
            } else {
                this.save();
                if (guiMenuTopButton.id == 1) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuDisplay);
                } else if (guiMenuTopButton.id == 2) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuStats);
                } else if (guiMenuTopButton.id == 3) {
                    NoppesUtil.requestOpenGUI(EnumGuiType.MainMenuInv);
                } else if (guiMenuTopButton.id == 4) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuAdvanced);
                } else if (guiMenuTopButton.id == 5) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuGlobal);
                } else if (guiMenuTopButton.id == 6) {
                    CustomNpcs.proxy.openGui(this.npc, EnumGuiType.MainMenuAI);
                }
                this.activeMenu = guiMenuTopButton.id;
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
            NoppesUtil.sendData(EnumPacketType.RemoteReset, this.npc.entityId);
        }
    }

    public void updateScreen() {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            if (!guiNpcTextField.enabled) continue;
            guiNpcTextField.updateCursorCounter();
        }
    }

    public void mouseClicked(int n, int n2, int n3) {
        for (Object object : this.textfields.values()) {
            if (!((GuiNpcTextField)object).enabled) continue;
            ((GuiNpcTextField)object).mouseClicked(n, n2, n3);
        }
        if (n3 == 0) {
            Object object;
            object = Minecraft._E();
            for (GuiMenuTopButton gui : this.topButtons) {
                if (!gui.mousePressed((Minecraft)object, n, n2)) continue;
                this.topButtonPressed(gui);
            }
            for (GuiCustomScroll guiCustomScroll : this.scrolls.values()) {
                guiCustomScroll.mouseClicked(n, n2, n3);
            }
        }
    }

    public void keyTyped(char c, int n) {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.textboxKeyTyped(c, n);
        }
        if (n == 1) {
            this.close();
        }
    }

    public void addButton(GuiNpcButton guiNpcButton) {
        this.buttons.put(guiNpcButton.id, guiNpcButton);
    }

    public GuiNpcButton getButton(int n) {
        return (GuiNpcButton)this.buttons.get(n);
    }

    public void addSlider(GuiNpcSlider guiNpcSlider) {
        this.sliders.put(guiNpcSlider.id, guiNpcSlider);
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

    public void addScroll(GuiCustomScroll guiCustomScroll, Minecraft minecraft) {
        guiCustomScroll.setWorldAndResolution(minecraft, 350, 250);
        this.scrolls.put(guiCustomScroll.id, guiCustomScroll);
    }

    public void drawElements(FontRenderer fontRenderer, int n, int n2, Minecraft minecraft, float f) {
        for (Object object : this.labels.values()) {
            ((GuiNpcLabel)object).drawLabel(this.parent, fontRenderer);
        }
        for (Object object : this.textfields.values()) {
            ((GuiTextField)object).drawTextBox();
        }
        for (GuiMenuTopButton guiMenuTopButton : this.topButtons) {
            guiMenuTopButton.drawButton(minecraft, n, n2);
        }
        for (GuiCustomScroll guiCustomScroll : this.scrolls.values()) {
            guiCustomScroll.drawScreen(n, n2, f);
        }
    }

    public Collection<GuiNpcTextField> getAllTextfields() {
        return this.textfields.values();
    }

    public void clearAllTextFields() {
        for (GuiNpcTextField guiNpcTextField : this.textfields.values()) {
            guiNpcTextField.setText("0");
        }
    }
}

