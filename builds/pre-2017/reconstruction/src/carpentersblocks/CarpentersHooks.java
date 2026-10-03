/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.PacketCarpenterMapChunks;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkWatchEvent;

public class CarpentersHooks {
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void onUpdate(EntityPlayerMP entityPlayerMP) {
        Object object;
        Object object2;
        entityPlayerMP.theItemInWorldManager._c();
        --entityPlayerMP.field_71145_cl;
        entityPlayerMP.openContainer.detectAndSendChanges();
        if (!entityPlayerMP.worldObj.isRemote && !entityPlayerMP.openContainer.canInteractWith(entityPlayerMP)) {
            entityPlayerMP.closeScreen();
            entityPlayerMP.openContainer = entityPlayerMP.inventoryContainer;
        }
        if (entityPlayerMP.hurtResistantTime > 0) {
            --entityPlayerMP.hurtResistantTime;
        }
        while (!entityPlayerMP.destroyedItemsNetCache.isEmpty()) {
            int n = Math.min(entityPlayerMP.destroyedItemsNetCache.size(), 127);
            object2 = new int[n];
            object = entityPlayerMP.destroyedItemsNetCache.iterator();
            int n2 = 0;
            while (object.hasNext() && n2 < n) {
                object2[n2++] = (Integer)object.next();
                object.remove();
            }
            entityPlayerMP.playerNetServerHandler.func_72567_b(new ixod((int[])object2));
        }
        if (!entityPlayerMP.loadedChunks.isEmpty()) {
            Object object3;
            ArrayList<Chunk> arrayList = new ArrayList<Chunk>();
            object2 = entityPlayerMP.loadedChunks.iterator();
            object = new ArrayList();
            ArrayList<TECarpentersBlock> arrayList2 = new ArrayList<TECarpentersBlock>();
            while (object2.hasNext() && arrayList.size() < 5) {
                jjym jjym2 = (jjym)object2.next();
                object2.remove();
                if (jjym2 == null || !entityPlayerMP.worldObj.blockExists(jjym2._a << 4, 0, jjym2._b << 4)) continue;
                object3 = entityPlayerMP.worldObj.getChunkFromChunkCoords(jjym2._a, jjym2._b);
                arrayList.add((Chunk)object3);
                for (Object object4 : ((Chunk)object3)._l.values()) {
                    TileEntity tileEntity = (TileEntity)object4;
                    if (tileEntity.isInvalid()) continue;
                    if (tileEntity instanceof TECarpentersBlock) {
                        arrayList2.add((TECarpentersBlock)tileEntity);
                        continue;
                    }
                    ((ArrayList)object).add(tileEntity);
                }
            }
            if (!arrayList.isEmpty()) {
                boolean bl = entityPlayerMP.playerNetServerHandler.netManager instanceof tgls;
                object3 = new PacketCarpenterMapChunks(arrayList, arrayList2, bl);
                entityPlayerMP.playerNetServerHandler.func_72567_b((Packet)object3);
                Iterator<Object> iterator2 = ((ArrayList)object).iterator();
                while (iterator2.hasNext()) {
                    TileEntity tileEntity = (TileEntity)iterator2.next();
                    entityPlayerMP.func_71119_a(tileEntity);
                }
                for (Chunk chunk : arrayList) {
                    entityPlayerMP.getServerForPlayer().getEntityTracker()._a(entityPlayerMP, chunk);
                    MinecraftForge.EVENT_BUS.post(new ChunkWatchEvent.Watch(chunk._k(), entityPlayerMP));
                }
            }
        }
        if (entityPlayerMP.field_143005_bX > 0L && entityPlayerMP.mcServer.__ar() > 0 && MinecraftServer.__aq() - entityPlayerMP.field_143005_bX > (long)(entityPlayerMP.mcServer.__ar() * 1000 * 60)) {
            entityPlayerMP.playerNetServerHandler.func_72565_c("You have been idle for too long!");
        }
    }
}

