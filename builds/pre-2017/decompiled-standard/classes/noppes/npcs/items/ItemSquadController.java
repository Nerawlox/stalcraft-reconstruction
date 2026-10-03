/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import noppes.npcs.CustomNpcs;
import noppes.npcs.controllers.PlayerData;

public class ItemSquadController
extends tgdv {
    public ItemSquadController(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.field_77777_bU = 1;
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        return -256;
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    @Override
    public boolean onItemUseFirst(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            PlayerData playerData = PlayerData.getData(entityPlayer);
            if (playerData.targetNpcUUID != null) {
                playerData.targetNpcUUID = null;
                entityPlayer.func_71035_c((Object)((Object)ezfc._l) + "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0439 \u043d\u043f\u0441 \u0443\u0434\u0430\u043b\u0435\u043d");
            }
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = tgdv.field_77682_J.func_77617_a(0);
    }
}

