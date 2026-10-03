/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.blocks.TileRedstoneBlock;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.SubGuiNpcAvailability;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcRedstoneBlock
extends GuiNPCInterface {
    private TileRedstoneBlock tile;

    public GuiNpcRedstoneBlock(int n, int n2, int n3) {
        this.tile = (TileRedstoneBlock)this.player.worldObj.getBlockTileEntity(n, n2, n3);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(4, this.guiLeft + 40, this.guiTop + 40, 120, 20, "Availability Options"));
        this.addLabel(new GuiNpcLabel(0, "On Range X:", this.guiLeft + 1, this.guiTop + 76, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 60, this.guiTop + 71, 20, 20, this.tile.onRangeX + ""));
        this.getTextField((int)0).numbersOnly = true;
        this.getTextField(0).setMinMaxDefault(0, 50, 6);
        this.addLabel(new GuiNpcLabel(1, "Y:", this.guiLeft + 83, this.guiTop + 76, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 92, this.guiTop + 71, 20, 20, this.tile.onRangeY + ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(0, 50, 6);
        this.addLabel(new GuiNpcLabel(2, "Z:", this.guiLeft + 115, this.guiTop + 76, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft + 124, this.guiTop + 71, 20, 20, this.tile.onRangeZ + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(0, 50, 6);
        this.addLabel(new GuiNpcLabel(3, "Off Range X:", this.guiLeft - 3, this.guiTop + 99, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(3, this, this.fontRenderer, this.guiLeft + 60, this.guiTop + 94, 20, 20, this.tile.offRangeX + ""));
        this.getTextField((int)3).numbersOnly = true;
        this.getTextField(3).setMinMaxDefault(0, 50, 10);
        this.addLabel(new GuiNpcLabel(4, "Y:", this.guiLeft + 83, this.guiTop + 99, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(4, this, this.fontRenderer, this.guiLeft + 92, this.guiTop + 94, 20, 20, this.tile.offRangeY + ""));
        this.getTextField((int)4).numbersOnly = true;
        this.getTextField(4).setMinMaxDefault(0, 50, 10);
        this.addLabel(new GuiNpcLabel(5, "Z:", this.guiLeft + 115, this.guiTop + 99, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(5, this, this.fontRenderer, this.guiLeft + 124, this.guiTop + 94, 20, 20, this.tile.offRangeZ + ""));
        this.getTextField((int)5).numbersOnly = true;
        this.getTextField(5).setMinMaxDefault(0, 50, 10);
        this.addButton(new GuiNpcButton(0, this.guiLeft + 40, this.guiTop + 190, 120, 20, "Done"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.close();
        }
        if (guiButton.id == 4) {
            this.save();
            SubGuiNpcAvailability subGuiNpcAvailability = new SubGuiNpcAvailability(this.tile.availability);
            subGuiNpcAvailability.parent2 = this;
            subGuiNpcAvailability.parent = subGuiNpcAvailability;
            NoppesUtil.openGUI(this.player, subGuiNpcAvailability);
        }
    }

    @Override
    public void save() {
        if (this.tile != null) {
            this.tile.onRangeX = this.getTextField(0).getInteger();
            this.tile.onRangeY = this.getTextField(1).getInteger();
            this.tile.onRangeZ = this.getTextField(2).getInteger();
            this.tile.offRangeX = this.getTextField(3).getInteger();
            this.tile.offRangeY = this.getTextField(4).getInteger();
            this.tile.offRangeZ = this.getTextField(5).getInteger();
            if (this.tile.onRangeX > this.tile.offRangeX) {
                this.tile.offRangeX = this.tile.onRangeX;
            }
            if (this.tile.onRangeY > this.tile.offRangeY) {
                this.tile.offRangeY = this.tile.onRangeY;
            }
            if (this.tile.onRangeZ > this.tile.offRangeZ) {
                this.tile.offRangeZ = this.tile.onRangeZ;
            }
            this.tile.isActivated = false;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            this.tile.writeToNBT(nBTTagCompound);
            NoppesUtil.sendData(EnumPacketType.SaveTileEntity, nBTTagCompound);
        }
    }
}

