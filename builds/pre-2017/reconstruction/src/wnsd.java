/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public abstract class wnsd
extends zwat {
    public int windowId;

    @Override
    public final void processClient(boolean bl) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        GuiContainer guiContainer = this.createGuiContainer(entityClientPlayerMP);
        if (guiContainer == null) {
            ((EntityPlayerSP)entityClientPlayerMP).closeScreen();
        } else {
            guiContainer.inventorySlots.windowId = this.windowId;
            entityClientPlayerMP.openContainer = guiContainer.inventorySlots;
            Minecraft._E()._a(guiContainer);
        }
    }

    @ezey(_a={eidj.CLIENT})
    protected abstract GuiContainer createGuiContainer(EntityPlayer var1);

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.windowId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.windowId);
    }
}

