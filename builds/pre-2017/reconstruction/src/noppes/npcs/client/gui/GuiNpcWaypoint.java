/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.blocks.TileWaypoint;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcWaypoint
extends GuiNPCInterface {
    private TileWaypoint tile;

    public GuiNpcWaypoint(int n, int n2, int n3) {
        this.tile = (TileWaypoint)this.player.worldObj.getBlockTileEntity(n, n2, n3);
        this.xSize = 265;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(0, "gui.name", this.guiLeft + 1, this.guiTop + 76, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 60, this.guiTop + 71, 200, 20, this.tile.name));
        this.addLabel(new GuiNpcLabel(1, "gui.range", this.guiLeft + 1, this.guiTop + 97, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 60, this.guiTop + 92, 200, 20, this.tile.range + ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(2, 60, 10);
        this.addButton(new GuiNpcButton(0, this.guiLeft + 40, this.guiTop + 190, 120, 20, "Done"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.close();
        }
    }

    @Override
    public void save() {
        if (this.tile != null) {
            this.tile.name = this.getTextField(0).getText();
            this.tile.range = this.getTextField(1).getInteger();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            this.tile.writeToNBT(nBTTagCompound);
            NoppesUtil.sendData(EnumPacketType.SaveTileEntity, nBTTagCompound);
        }
    }
}

