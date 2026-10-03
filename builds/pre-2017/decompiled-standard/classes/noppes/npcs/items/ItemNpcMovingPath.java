/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;

public class ItemNpcMovingPath
extends tgdv {
    public ItemNpcMovingPath(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.field_77777_bU = 1;
        this.func_77637_a(CustomItems.tab);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        EntityNPCInterface entityNPCInterface = this.getNpc(cvzo2, ozlu2);
        if (entityNPCInterface != null) {
            NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.MovingPath, entityNPCInterface);
        }
        return cvzo2;
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        EntityNPCInterface entityNPCInterface = this.getNpc(cvzo2, ozlu2);
        if (entityNPCInterface == null) {
            return true;
        }
        List list2 = entityNPCInterface.aiData.getMovingPath();
        list2.add(new int[]{n, n2, n3});
        entityPlayer.func_71035_c("Added point x:" + n + " y:" + n2 + " z:" + n3 + " to npc " + entityNPCInterface.func_70023_ak());
        return true;
    }

    private EntityNPCInterface getNpc(cvzo cvzo2, ozlu ozlu2) {
        if (!ozlu2.field_72995_K && cvzo2._e != null) {
            Entity entity = ozlu2.func_73045_a(cvzo2._e._f("NPCID"));
            return entity != null && entity instanceof EntityNPCInterface ? (EntityNPCInterface)entity : null;
        }
        return null;
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        return 9127187;
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = tgdv.field_77716_q.func_77617_a(0);
    }

    @Override
    public tgdv func_77655_b(String string) {
        GameRegistry.registerItem(this, string);
        return super.func_77655_b(string);
    }
}

