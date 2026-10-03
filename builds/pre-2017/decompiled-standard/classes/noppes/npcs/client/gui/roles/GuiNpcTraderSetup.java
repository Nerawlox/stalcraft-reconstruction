/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerNPCTraderSetup;
import noppes.npcs.packet.PacketSortTrader;
import noppes.npcs.roles.RoleTrader;
import org.lwjgl.opengl.GL11;

public class GuiNpcTraderSetup
extends GuiContainerNPCInterface2
implements ITextfieldListener {
    private static final ResourceLocation field_110422_t = new ResourceLocation("customnpcs", "textures/gui/npctradersetup2.png");
    private GuiNpcTextField[] inputs = new GuiNpcTextField[21];
    private int page;
    private jiok leftButton;
    private jiok rightButton;

    public GuiNpcTraderSetup(EntityNPCInterface entityNPCInterface, ContainerNPCTraderSetup containerNPCTraderSetup) {
        super(entityNPCInterface, containerNPCTraderSetup);
    }

    @Override
    public void func_73866_w_() {
        int n;
        super.func_73866_w_();
        this.field_73887_h.clear();
        this.setBackground("npctradersetup.png");
        for (n = 0; n < 21; ++n) {
            int n2 = 187;
            int n3 = 8;
            this.inputs[n] = new GuiNpcTextField(n, this, this.field_73882_e._z, this.field_73880_f / 2 - this.field_74194_b / 2 + (n2 += n / 7 * 59) - 5, this.field_73881_g / 2 - this.field_74195_c / 2 + (n3 += n % 7 * 22), 35, 11, "");
            this.addTextField(this.inputs[n]);
        }
        this.loadPage();
        this.leftButton = new jiok(42, this.field_73880_f / 2 + 40, this.field_73881_g / 2 + 80, 20, 20, "<-");
        this.rightButton = new jiok(43, this.field_73880_f / 2 + 64, this.field_73881_g / 2 + 80, 20, 20, "->");
        this.field_73887_h.add(this.leftButton);
        this.field_73887_h.add(this.rightButton);
        this.leftButton.field_73742_g = false;
        n = ((RoleTrader)this.npc.roleInterface).checkNbtOnBuy ? 1 : 0;
        this.addButton(new GuiNpcButton(100, this.field_73880_f / 2 - 200, this.field_73881_g / 2 - 75, 150, 20, new String[]{"\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0442\u044c NBT \u043f\u0440\u0438 \u043f\u043e\u043a\u0443\u043f\u043a\u0435: \u0414\u0430", "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0442\u044c NBT \u043f\u0440\u0438 \u043f\u043e\u043a\u0443\u043f\u043a\u0435: \u041d\u0435\u0442"}, n != 0 ? 0 : 1));
        this.addButton(new GuiNpcButton(101, this.field_73880_f / 2 - 200, this.field_73881_g / 2 - 50, 70, 20, "Sort"));
        this.addButton(new GuiNpcButton(102, this.field_73880_f / 2 - 120, this.field_73881_g / 2 - 50, 70, 20, "Sort (Reversed)"));
    }

    public void sort(boolean bl) {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
        RoleTrader roleTrader = (RoleTrader)this.npc.roleInterface;
        roleTrader.sort(bl, false);
        this.loadPage();
        new PacketSortTrader(bl).sendToServer();
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        super.func_74185_a(f, n, n2);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(field_110422_t);
        this.func_73729_b(this.field_73880_f / 2 - 20, this.field_73881_g / 2 - 80, 0, 0, 167, 156);
        for (GuiNpcTextField guiNpcTextField : this.inputs) {
            guiNpcTextField.func_73795_f();
        }
        String string = (this.page < 3 ? "\u041f\u0440\u043e\u0434\u0430\u0436\u0430" : "\u0421\u043a\u0443\u043f\u043a\u0430") + ", \u0441\u0442\u0440\u0430\u043d\u0438\u0446\u0430 " + (this.page >= 3 ? this.page - 3 + 1 : this.page + 1);
        this.func_73732_a(this.field_73886_k, string, this.field_73880_f / 2 + 70, this.field_73881_g / 2 - 92, 0xFFFFFF);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 42) {
            this.page = Math.max(0, this.page - 1);
        } else if (jiok2.field_73741_f == 43) {
            this.page = Math.min(12, this.page + 1);
        }
        if (jiok2.field_73741_f == 42 || jiok2.field_73741_f == 43) {
            this.leftButton.field_73742_g = this.page > 0;
            this.rightButton.field_73742_g = this.page < 12;
            this.loadPage();
        }
        if (jiok2.field_73741_f == 100 && jiok2 instanceof GuiNpcButton) {
            ((RoleTrader)this.npc.roleInterface).checkNbtOnBuy = ((GuiNpcButton)jiok2).getValue() == 0;
        } else if (jiok2.field_73741_f == 101) {
            this.sort(false);
        } else if (jiok2.field_73741_f == 102) {
            this.sort(true);
        }
    }

    private void loadPage() {
        ((ContainerNPCTraderSetup)this.field_74193_d).setupSlotsForPage(this.page);
        RoleTrader roleTrader = (RoleTrader)this.npc.roleInterface;
        boolean bl = this.page < 3;
        int[] nArray = bl ? roleTrader.sellPrices : roleTrader.buyPrices;
        for (int i = 0; i < 21; ++i) {
            int n = bl ? this.page : this.page - 3;
            this.inputs[i].func_73782_a(String.valueOf(nArray[i + n * 21]));
            this.inputs[i].func_73794_g(-2039584);
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        int n = guiNpcTextField.id;
        if (n >= 0 && n < 21) {
            try {
                int n2 = Integer.parseInt(guiNpcTextField.func_73781_b());
                if (n2 >= 0) {
                    guiNpcTextField.func_73794_g(-2039584);
                    RoleTrader roleTrader = (RoleTrader)this.npc.roleInterface;
                    if (this.page < 3) {
                        roleTrader.sellPrices[n + this.page * 21] = n2;
                    } else {
                        roleTrader.buyPrices[n + (this.page - 3) * 21] = n2;
                    }
                } else {
                    guiNpcTextField.func_73794_g(-65536);
                }
            }
            catch (NumberFormatException numberFormatException) {
                guiNpcTextField.func_73794_g(-65536);
            }
        }
    }
}

