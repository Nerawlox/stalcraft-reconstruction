/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.trade.ezey;
import gloomyfolken.mods.trade.kjui;
import gloomyfolken.mods.trade.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class dxrm
extends wnsd {
    private int _a;

    public dxrm(EntityPlayer entityPlayer) {
        this._a = entityPlayer.entityId;
    }

    @Override
    protected GuiContainer createGuiContainer(EntityPlayer entityPlayer) {
        Entity entity = entityPlayer.worldObj.getEntityByID(this._a);
        if (entity instanceof EntityPlayer) {
            ezey ezey2 = new ezey(20, entityPlayer);
            ezey ezey3 = new ezey(20, (EntityPlayer)entity);
            kjui kjui2 = new kjui(entityPlayer, ezey2, ezey3);
            return new pidb((Container)kjui2, entity.getEntityName());
        }
        return null;
    }

    public dxrm() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._a);
    }
}

