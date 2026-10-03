/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.packet;

import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketOpenCorpseContainer
extends wnsd {
    private int entityId;

    public PacketOpenCorpseContainer(CorpseInventoryProvider corpseInventoryProvider) {
        this.entityId = corpseInventoryProvider.getEntityId();
    }

    @Override
    protected GuiContainer createGuiContainer(EntityPlayer entityPlayer) {
        Entity entity = entityPlayer.worldObj.getEntityByID(this.entityId);
        if (entity instanceof CorpseInventoryProvider) {
            entityPlayer.openContainer = RagdollsMod.createCorpseContainer((CorpseInventoryProvider)((Object)entity));
            return new hsxd((jzak)entityPlayer.openContainer);
        }
        return null;
    }

    public PacketOpenCorpseContainer() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.entityId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this.entityId);
    }
}

