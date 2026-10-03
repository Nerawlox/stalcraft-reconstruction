/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.blocks.BlockTransparentContainer;
import noppes.npcs.blocks.TileWaypoint;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;

public class BlockWaypoint
extends BlockTransparentContainer {
    public BlockWaypoint(int n) {
        super(n, GloomyCore.fakeAir);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return false;
        }
        if (entityPlayer.field_71075_bZ._d) {
            hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
            qoac qoac2 = new qoac();
            hurg2.func_70310_b(qoac2);
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.WaypointSave, qoac2);
            return true;
        }
        return false;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (entityLivingBase instanceof EntityPlayer && ozlu2.field_72995_K) {
            CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.Waypoint, (EntityPlayer)entityLivingBase);
        }
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new TileWaypoint();
    }
}

