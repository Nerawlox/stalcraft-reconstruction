/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.IContainerSyncVar;
import codechicken.lib.packet.PacketCustom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public abstract class ContainerSynchronised
extends ContainerExtended {
    private ArrayList<IContainerSyncVar> syncVars = new ArrayList();

    public abstract PacketCustom createSyncPacket();

    @Override
    public final void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.syncVars.size(); ++i) {
            IContainerSyncVar iContainerSyncVar = this.syncVars.get(i);
            if (!iContainerSyncVar.changed()) continue;
            PacketCustom packetCustom = this.createSyncPacket();
            packetCustom.writeByte(i);
            iContainerSyncVar.writeChange(packetCustom);
            this.sendContainerPacket(packetCustom);
            iContainerSyncVar.reset();
        }
    }

    @Override
    public void sendContainerAndContentsToPlayer(Container container, List<ItemStack> list2, List<EntityPlayerMP> list3) {
        super.sendContainerAndContentsToPlayer(container, list2, list3);
        for (int i = 0; i < this.syncVars.size(); ++i) {
            IContainerSyncVar iContainerSyncVar = this.syncVars.get(i);
            PacketCustom packetCustom = this.createSyncPacket();
            packetCustom.writeByte(i);
            iContainerSyncVar.writeChange(packetCustom);
            iContainerSyncVar.reset();
            for (EntityPlayerMP entityPlayerMP : list3) {
                packetCustom.sendToPlayer(entityPlayerMP);
            }
        }
    }

    public void addSyncVar(IContainerSyncVar iContainerSyncVar) {
        this.syncVars.add(iContainerSyncVar);
    }

    @Override
    public final void handleOutputPacket(PacketCustom packetCustom) {
        this.syncVars.get(packetCustom.readUByte()).readChange(packetCustom);
    }

    public List<IContainerSyncVar> getSyncedVars() {
        return Collections.unmodifiableList(this.syncVars);
    }
}

