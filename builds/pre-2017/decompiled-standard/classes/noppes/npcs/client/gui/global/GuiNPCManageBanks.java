/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import java.util.HashMap;
import java.util.Vector;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerManageBanks;
import noppes.npcs.controllers.Bank;

public class GuiNPCManageBanks
extends GuiContainerNPCInterface2
implements GuiCustomScrollActionListener,
IGuiData,
IScrollData,
ITextfieldListener {
    private GuiCustomScroll scroll;
    private HashMap data = new HashMap();
    private ContainerManageBanks container;
    private Bank bank = new Bank();
    private String selected = null;

    public GuiNPCManageBanks(EntityNPCInterface entityNPCInterface, ContainerManageBanks containerManageBanks) {
        super(entityNPCInterface, containerManageBanks);
        this.container = containerManageBanks;
        this.drawDefaultBackground = false;
        NoppesUtil.sendData(EnumPacketType.BanksGet, new Object[0]);
        this.setBackground("npcbanksetup.png");
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(6, this.guiTop + 340, this.guiLeft + 10, 45, 20, "gui.add"));
        this.addButton(new GuiNpcButton(7, this.guiTop + 340, this.guiLeft + 32, 45, 20, "gui.remove"));
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.func_73872_a(this.field_73882_e, 350, 250);
        this.scroll.setSize(160, 180);
        this.scroll.guiLeft = this.guiTop + 174;
        this.scroll.guiTop = this.guiLeft + 8;
        for (int i = 0; i < 6; ++i) {
            int n = this.guiTop + 6;
            int n2 = this.guiLeft + 36 + i * 22;
            this.addButton(new GuiNpcButton(i, n + 50, n2, 80, 20, new String[]{"Can Upgrade", "Can't Upgrade", "Upgraded"}, 0));
            this.getButton((int)i).field_73742_g = false;
        }
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiTop + 8, this.guiLeft + 8, 160, 16, ""));
        this.getTextField(0).func_73804_f(20);
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiTop + 10, this.guiLeft + 80, 16, 16, ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).func_73804_f(1);
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiTop + 10, this.guiLeft + 110, 16, 16, ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).func_73804_f(1);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f == 6) {
            this.save();
            this.scroll.clear();
            String string = "New";
            while (this.data.containsKey(string)) {
                string = string + "_";
            }
            Bank bank = new Bank();
            bank.name = string;
            qoac qoac2 = new qoac();
            bank.writeEntityToNBT(qoac2);
            NoppesUtil.sendData(EnumPacketType.BankSave, qoac2);
        } else if (jiok2.field_73741_f == 7) {
            if (this.data.containsKey(this.scroll.getSelected())) {
                NoppesUtil.sendData(EnumPacketType.BankRemove, this.data.get(this.selected));
            }
        } else if (jiok2.field_73741_f >= 0 && jiok2.field_73741_f < 6) {
            this.bank.slotTypes.put(jiok2.field_73741_f, guiNpcButton.getValue());
        }
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b("Tab Cost", 23, 10, 0x404040);
        this.field_73886_k._b("Upg. Cost", 123, 10, 0x404040);
        this.field_73886_k._b("Start", 6, 52, 0x404040);
        this.field_73886_k._b("Max", 9, 82, 0x404040);
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        super.func_74185_a(f, n, n2);
        this.scroll.func_73863_a(n, n2, f);
    }

    @Override
    public void setGuiData(qoac qoac2) {
        Bank bank = new Bank();
        bank.readEntityFromNBT(qoac2);
        this.bank = bank;
        if (bank.id == -1) {
            this.getTextField(0).func_73782_a("");
            this.getTextField(1).func_73782_a("");
            this.getTextField(2).func_73782_a("");
            for (int i = 0; i < 6; ++i) {
                this.getButton(i).setDisplay(0);
                this.getButton((int)i).field_73742_g = false;
            }
        } else {
            this.getTextField(0).func_73782_a(bank.name);
            this.getTextField(1).func_73782_a(Integer.toString(bank.startSlots));
            this.getTextField(2).func_73782_a(Integer.toString(bank.maxSlots));
            for (int i = 0; i < 6; ++i) {
                int n = 0;
                if (bank.slotTypes.containsKey(i)) {
                    n = (Integer)bank.slotTypes.get(i);
                }
                this.getButton(i).setDisplay(n);
                this.getButton((int)i).field_73742_g = true;
            }
        }
        this.setSelected(bank.name);
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        String string = this.scroll.getSelected();
        this.data = hashMap;
        this.scroll.setList(vector);
        if (string != null) {
            this.scroll.setSelected(string);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (n3 == 0 && this.scroll != null) {
            this.scroll.func_73864_a(n, n2, n3);
        }
    }

    @Override
    public void setSelected(String string) {
        this.selected = string;
        this.scroll.setSelected(string);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.id == 0) {
            this.save();
            this.selected = this.scroll.getSelected();
            NoppesUtil.sendData(EnumPacketType.BankGet, this.data.get(this.selected));
        }
    }

    @Override
    public void save() {
        if (this.selected != null && this.data.containsKey(this.selected) && this.bank != null) {
            qoac qoac2 = new qoac();
            this.bank.currencyInventory = this.container.bank.currencyInventory;
            this.bank.upgradeInventory = this.container.bank.upgradeInventory;
            this.bank.writeEntityToNBT(qoac2);
            NoppesUtil.sendData(EnumPacketType.BankSave, qoac2);
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (this.bank.id != -1) {
            if (guiNpcTextField.id == 0) {
                String string = guiNpcTextField.func_73781_b();
                if (!string.isEmpty() && !this.data.containsKey(string)) {
                    String string2 = this.bank.name;
                    this.data.remove(this.bank.name);
                    this.bank.name = string;
                    this.data.put(this.bank.name, this.bank.id);
                    this.selected = string;
                    this.scroll.replace(string2, this.bank.name);
                }
            } else if (guiNpcTextField.id == 1 || guiNpcTextField.id == 2) {
                int n = 1;
                if (!guiNpcTextField.isEmpty()) {
                    n = guiNpcTextField.getInteger();
                }
                if (n > 6) {
                    n = 6;
                }
                if (n < 0) {
                    n = 0;
                }
                if (guiNpcTextField.id == 1) {
                    this.bank.startSlots = n;
                } else if (guiNpcTextField.id == 2) {
                    this.bank.maxSlots = n;
                }
                if (this.bank.startSlots > this.bank.maxSlots) {
                    this.bank.maxSlots = this.bank.startSlots;
                }
                guiNpcTextField.func_73782_a(Integer.toString(n));
            }
        }
    }
}

