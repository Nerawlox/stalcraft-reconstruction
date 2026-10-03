/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
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
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("customnpcs", "textures/gui/npctradersetup2.png");
    private GuiNpcTextField[] inputs = new GuiNpcTextField[21];
    private int page;
    private GuiButton leftButton;
    private GuiButton rightButton;

    public GuiNpcTraderSetup(EntityNPCInterface entityNPCInterface, ContainerNPCTraderSetup containerNPCTraderSetup) {
        super(entityNPCInterface, containerNPCTraderSetup);
    }

    @Override
    public void initGui() {
        int n;
        super.initGui();
        this.buttonList.clear();
        this.setBackground("npctradersetup.png");
        for (n = 0; n < 21; ++n) {
            int n2 = 187;
            int n3 = 8;
            this.inputs[n] = new GuiNpcTextField(n, this, this.mc._z, this.width / 2 - this.xSize / 2 + (n2 += n / 7 * 59) - 5, this.height / 2 - this.ySize / 2 + (n3 += n % 7 * 22), 35, 11, "");
            this.addTextField(this.inputs[n]);
        }
        this.loadPage();
        this.leftButton = new GuiButton(42, this.width / 2 + 40, this.height / 2 + 80, 20, 20, "<-");
        this.rightButton = new GuiButton(43, this.width / 2 + 64, this.height / 2 + 80, 20, 20, "->");
        this.buttonList.add(this.leftButton);
        this.buttonList.add(this.rightButton);
        this.leftButton.enabled = false;
        n = ((RoleTrader)this.npc.roleInterface).checkNbtOnBuy ? 1 : 0;
        this.addButton(new GuiNpcButton(100, this.width / 2 - 200, this.height / 2 - 75, 150, 20, new String[]{"\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0442\u044c NBT \u043f\u0440\u0438 \u043f\u043e\u043a\u0443\u043f\u043a\u0435: \u0414\u0430", "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0442\u044c NBT \u043f\u0440\u0438 \u043f\u043e\u043a\u0443\u043f\u043a\u0435: \u041d\u0435\u0442"}, n != 0 ? 0 : 1));
        this.addButton(new GuiNpcButton(101, this.width / 2 - 200, this.height / 2 - 50, 70, 20, "Sort"));
        this.addButton(new GuiNpcButton(102, this.width / 2 - 120, this.height / 2 - 50, 70, 20, "Sort (Reversed)"));
    }

    public void sort(boolean bl) {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
        RoleTrader roleTrader = (RoleTrader)this.npc.roleInterface;
        roleTrader.sort(bl, false);
        this.loadPage();
        new PacketSortTrader(bl).sendToServer();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        super.drawGuiContainerBackgroundLayer(f, n, n2);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(craftingTableGuiTextures);
        this.drawTexturedModalRect(this.width / 2 - 20, this.height / 2 - 80, 0, 0, 167, 156);
        for (GuiNpcTextField guiNpcTextField : this.inputs) {
            guiNpcTextField.drawTextBox();
        }
        String string = (this.page < 3 ? "\u041f\u0440\u043e\u0434\u0430\u0436\u0430" : "\u0421\u043a\u0443\u043f\u043a\u0430") + ", \u0441\u0442\u0440\u0430\u043d\u0438\u0446\u0430 " + (this.page >= 3 ? this.page - 3 + 1 : this.page + 1);
        this.drawCenteredString(this.fontRenderer, string, this.width / 2 + 70, this.height / 2 - 92, 0xFFFFFF);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id == 42) {
            this.page = Math.max(0, this.page - 1);
        } else if (guiButton.id == 43) {
            this.page = Math.min(12, this.page + 1);
        }
        if (guiButton.id == 42 || guiButton.id == 43) {
            this.leftButton.enabled = this.page > 0;
            this.rightButton.enabled = this.page < 12;
            this.loadPage();
        }
        if (guiButton.id == 100 && guiButton instanceof GuiNpcButton) {
            ((RoleTrader)this.npc.roleInterface).checkNbtOnBuy = ((GuiNpcButton)guiButton).getValue() == 0;
        } else if (guiButton.id == 101) {
            this.sort(false);
        } else if (guiButton.id == 102) {
            this.sort(true);
        }
    }

    private void loadPage() {
        ((ContainerNPCTraderSetup)this.inventorySlots).setupSlotsForPage(this.page);
        RoleTrader roleTrader = (RoleTrader)this.npc.roleInterface;
        boolean bl = this.page < 3;
        int[] nArray = bl ? roleTrader.sellPrices : roleTrader.buyPrices;
        for (int i = 0; i < 21; ++i) {
            int n = bl ? this.page : this.page - 3;
            this.inputs[i].setText(String.valueOf(nArray[i + n * 21]));
            this.inputs[i].setTextColor(-2039584);
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        int n = guiNpcTextField.id;
        if (n >= 0 && n < 21) {
            try {
                int n2 = Integer.parseInt(guiNpcTextField.getText());
                if (n2 >= 0) {
                    guiNpcTextField.setTextColor(-2039584);
                    RoleTrader roleTrader = (RoleTrader)this.npc.roleInterface;
                    if (this.page < 3) {
                        roleTrader.sellPrices[n + this.page * 21] = n2;
                    } else {
                        roleTrader.buyPrices[n + (this.page - 3) * 21] = n2;
                    }
                } else {
                    guiNpcTextField.setTextColor(-65536);
                }
            }
            catch (NumberFormatException numberFormatException) {
                guiNpcTextField.setTextColor(-65536);
            }
        }
    }
}

