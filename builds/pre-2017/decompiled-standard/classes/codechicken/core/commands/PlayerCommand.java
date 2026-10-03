/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.commands;

import codechicken.core.commands.CoreCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;

public abstract class PlayerCommand
extends CoreCommand {
    @Override
    public boolean func_71519_b(nemo nemo2) {
        if (!super.func_71519_b(nemo2)) {
            return false;
        }
        return nemo2 instanceof EntityPlayer;
    }

    @Override
    public void handleCommand(String string, String string2, String[] stringArray, CoreCommand.WCommandSender wCommandSender) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP)wCommandSender.wrapped;
        this.handleCommand(this.getWorld(entityPlayerMP), entityPlayerMP, stringArray);
    }

    public abstract void handleCommand(yfgy var1, EntityPlayerMP var2, String[] var3);

    public xtcd getPlayerLookingAtBlock(EntityPlayerMP entityPlayerMP, float f) {
        ofbx ofbx2 = ofbx._a(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u + 1.62 - (double)entityPlayerMP.field_70129_M, entityPlayerMP.field_70161_v);
        ofbx ofbx3 = entityPlayerMP.func_70676_i(1.0f);
        ofbx ofbx4 = ofbx2._c(ofbx3._c * (double)f, ofbx3._d * (double)f, ofbx3._e * (double)f);
        hank hank2 = entityPlayerMP.field_70170_p.func_72933_a(ofbx2, ofbx4);
        if (hank2 == null || hank2._c != amww._a) {
            return null;
        }
        return new xtcd(hank2._d, hank2._e, hank2._f);
    }

    public Entity getPlayerLookingAtEntity(EntityPlayerMP entityPlayerMP, float f) {
        ofbx ofbx2 = ofbx._a(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u + 1.62 - (double)entityPlayerMP.field_70129_M, entityPlayerMP.field_70161_v);
        ofbx ofbx3 = entityPlayerMP.func_70676_i(1.0f);
        ofbx ofbx4 = ofbx2._c(ofbx3._c * (double)f, ofbx3._d * (double)f, ofbx3._e * (double)f);
        hank hank2 = entityPlayerMP.field_70170_p.func_72933_a(ofbx2, ofbx4);
        if (hank2 == null || hank2._c != amww._b) {
            return null;
        }
        return hank2._i;
    }
}

