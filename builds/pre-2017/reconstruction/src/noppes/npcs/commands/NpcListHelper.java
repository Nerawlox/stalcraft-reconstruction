/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.commands;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import noppes.npcs.EntityNPCInterface;

public class NpcListHelper {
    public static List<EntityNPCInterface> getAllNPCs() {
        WorldServer worldServer = MinecraftServer._I()._j[0];
        ArrayList<EntityNPCInterface> arrayList = new ArrayList<EntityNPCInterface>();
        for (Chunk chunk : worldServer.theChunkProviderServer._g) {
            for (List list2 : chunk._m) {
                for (Entity entity : list2) {
                    if (!(entity instanceof EntityNPCInterface)) continue;
                    arrayList.add((EntityNPCInterface)entity);
                }
            }
        }
        return arrayList;
    }
}

