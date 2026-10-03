/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNPCBankInterface;
import org.lwjgl.opengl.GL11;

public class GuiNPCBankChest
extends GuiContainerNPCInterface
implements IGuiData {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/bankchest.png");
    private ContainerNPCBankInterface container;
    private int availableSlots = 0;
    private int maxSlots = 1;
    private int unlockedSlots = 1;
    private cvzo currency;

    public GuiNPCBankChest(EntityNPCInterface entityNPCInterface, ContainerNPCBankInterface containerNPCBankInterface) {
        super(entityNPCInterface, containerNPCBankInterface);
        this.container = containerNPCBankInterface;
        this.title = "";
        this.field_73885_j = false;
        this.field_74195_c = 235;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.availableSlots = 0;
        if (this.maxSlots > 1) {
            for (int i = 0; i < this.maxSlots; ++i) {
                GuiNpcButton guiNpcButton = new GuiNpcButton(i, this.field_74198_m - 60, this.field_74197_n + 10 + i * 24, 60, 20, "\u041f\u043e\u043b\u043a\u0430 #" + (i + 1));
                if (i > this.unlockedSlots) {
                    guiNpcButton.field_73742_g = false;
                }
                this.addButton(guiNpcButton);
                ++this.availableSlots;
            }
            if (this.availableSlots == 1) {
                this.field_73887_h.clear();
            }
        }
        if (!this.container.isAvailable()) {
            this.addButton(new GuiNpcButton(8, this.field_74198_m + 48, this.field_74197_n + 48, 80, 20, tdpx._a("bank.unlock")));
        } else if (this.container.canBeUpgraded()) {
            this.addButton(new GuiNpcButton(9, this.field_74198_m + 48, this.field_74197_n + 48, 80, 20, tdpx._a("bank.upgrade")));
        }
        if (this.maxSlots > 1) {
            this.getButton((int)this.container.slot).field_73742_g = false;
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f < 6) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.BankSlotOpen, jiok2.field_73741_f, this.container.bankid);
        }
        if (jiok2.field_73741_f == 8) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.BankUnlock, new Object[0]);
        }
        if (jiok2.field_73741_f == 9) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.BankUpgrade, new Object[0]);
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        int n3;
        int n4;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        int n5 = (this.field_73880_f - this.field_74194_b) / 2;
        int n6 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n5, n6, 0, 0, this.field_74194_b, 6);
        if (!this.container.isAvailable()) {
            this.func_73729_b(n5, n6 + 6, 0, 6, this.field_74194_b, 64);
            this.func_73729_b(n5, n6 + 70, 0, 124, this.field_74194_b, 98);
            n4 = this.field_74198_m + 30;
            n3 = this.field_74197_n + 8;
            this.field_73886_k._b(tdpx._a("bank.unlockCosts") + ":", n4, n3 + 4, 0x404040);
            this.drawItem(n4 + 90, n3, this.currency, n, n2);
        } else if (this.container.isUpgraded()) {
            this.func_73729_b(n5, n6 + 60, 0, 60, this.field_74194_b, 162);
            this.func_73729_b(n5, n6 + 6, 0, 60, this.field_74194_b, 64);
        } else if (this.container.canBeUpgraded()) {
            this.func_73729_b(n5, n6 + 6, 0, 6, this.field_74194_b, 216);
            n4 = this.field_74198_m + 30;
            n3 = this.field_74197_n + 8;
            this.field_73886_k._b(tdpx._a("bank.upgradeCosts") + ":", n4, n3 + 4, 0x404040);
            this.drawItem(n4 + 90, n3, this.currency, n, n2);
        } else {
            this.func_73729_b(n5, n6 + 6, 0, 60, this.field_74194_b, 162);
        }
        if (this.maxSlots > 1) {
            for (n4 = 0; n4 < this.maxSlots && this.availableSlots != n4; ++n4) {
                this.field_73886_k._b("\u041f\u043e\u043b\u043a\u0430 #" + (n4 + 1), this.field_74198_m - 40, this.field_74197_n + 16 + n4 * 24, 0xFFFFFF);
            }
        }
        super.func_74185_a(f, n, n2);
    }

    private void drawItem(int n, int n2, cvzo cvzo2, int n3, int n4) {
        if (cvzo2 != null) {
            GL11.glEnable(32826);
            qnon._c();
            zybc.field_74196_a.func_77015_a(this.field_73886_k, this.field_73882_e._h, cvzo2, n, n2);
            zybc.field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._h, cvzo2, n, n2);
            qnon._a();
            GL11.glDisable(32826);
            if (this.func_74188_c(n - this.field_74198_m, n2 - this.field_74197_n, 16, 16, n3, n4)) {
                this.func_74184_a(cvzo2, n3, n4);
            }
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setGuiData(qoac qoac2) {
        this.maxSlots = qoac2._f("MaxSlots");
        this.unlockedSlots = qoac2._f("UnlockedSlots");
        this.currency = qoac2._c("Currency") ? cvzo._a(qoac2._m("Currency")) : null;
        if (this.container.currency != null) {
            this.container.currency.item = this.currency;
        }
        this.func_73866_w_();
    }
}

