/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomNpcs;
import noppes.npcs.constants.EnumGuiType;

public class PacketOpenCustomGui
extends wnsd {
    private EnumGuiType type;
    private int x;
    private int y;
    private int z;

    public PacketOpenCustomGui(EnumGuiType enumGuiType, int n, int n2, int n3) {
        this.type = enumGuiType;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    @Override
    protected GuiContainer createGuiContainer(EntityPlayer entityPlayer) {
        Object object = CustomNpcs.proxy.getClientGuiElement(this.type.ordinal(), entityPlayer, entityPlayer.worldObj, this.x, this.y, this.z);
        if (object instanceof GuiContainer) {
            return (GuiContainer)object;
        }
        return null;
    }

    public PacketOpenCustomGui() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.type = EnumGuiType.values()[dataInput.readInt()];
        this.x = dataInput.readInt();
        this.y = dataInput.readInt();
        this.z = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this.type.ordinal());
        dataOutput.writeInt(this.x);
        dataOutput.writeInt(this.y);
        dataOutput.writeInt(this.z);
    }
}

