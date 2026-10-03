/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.entity.EntityNPCHumanMale;
import noppes.npcs.permissions.CustomNpcsPermissions;

public class ItemNpcWand
extends tgdv {
    public ItemNpcWand(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.field_77777_bU = 1;
        this.func_77637_a(CustomItems.tab);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!ozlu2.field_72995_K) {
            return cvzo2;
        }
        CustomNpcs.proxy.openGui((EntityNPCInterface)null, EnumGuiType.NpcRemote);
        return cvzo2;
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        if (CustomNpcs.OpsOnly && !dzfd._I().__ag()._p().contains(entityPlayer.field_71092_bJ.toLowerCase())) {
            dzfd._I()._c(entityPlayer.field_71092_bJ + ": tried to use custom npcs without being an op");
        } else if (CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.create")) {
            EntityNPCHumanMale entityNPCHumanMale = (EntityNPCHumanMale)jgro._a("npchumanmale", ozlu2);
            entityNPCHumanMale.startPos = new int[]{n, n2, n3};
            entityNPCHumanMale.func_70012_b((float)n + 0.5f, entityNPCHumanMale.getStartYPos(), (float)n3 + 0.5f, entityPlayer.field_70177_z, entityPlayer.field_70125_A);
            entityNPCHumanMale.status.onCreation(entityPlayer);
            entityNPCHumanMale.shuffleEquipment();
            ozlu2.func_72838_d(entityNPCHumanMale);
            entityNPCHumanMale.func_70606_j(entityNPCHumanMale.func_110138_aP());
            CustomNpcs.npcsLog.info(entityPlayer.field_71092_bJ + " created npc with name " + entityNPCHumanMale.display.name + " at (" + entityNPCHumanMale.field_70165_t + ", " + entityNPCHumanMale.field_70163_u + ", " + entityNPCHumanMale.field_70161_v + ")");
            NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.MainMenuDisplay, entityNPCHumanMale);
        }
        return true;
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
        this.field_77791_bV = tgdv.field_77689_P.func_77617_a(0);
    }

    @Override
    public tgdv func_77655_b(String string) {
        GameRegistry.registerItem(this, string);
        return super.func_77655_b(string);
    }
}

