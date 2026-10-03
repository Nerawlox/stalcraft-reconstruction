/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CustomTeleporter
extends Teleporter {
    public CustomTeleporter(WorldServer worldServer) {
        super(worldServer);
    }

    @Override
    public void placeInPortal(Entity entity, double d, double d2, double d3, float f) {
    }
}

