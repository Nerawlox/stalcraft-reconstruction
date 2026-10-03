/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.commands;

import codechicken.core.commands.CoreCommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldServer;

public abstract class PlayerCommand
extends CoreCommand {
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        if (!super.canCommandSenderUseCommand(iCommandSender)) {
            return false;
        }
        return iCommandSender instanceof EntityPlayer;
    }

    @Override
    public void handleCommand(String string, String string2, String[] stringArray, CoreCommand.WCommandSender wCommandSender) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP)wCommandSender.wrapped;
        this.handleCommand(this.getWorld(entityPlayerMP), entityPlayerMP, stringArray);
    }

    public abstract void handleCommand(WorldServer var1, EntityPlayerMP var2, String[] var3);

    public xtcd getPlayerLookingAtBlock(EntityPlayerMP entityPlayerMP, float f) {
        Vec3 vec3 = Vec3._a(entityPlayerMP.posX, entityPlayerMP.posY + 1.62 - (double)entityPlayerMP.yOffset, entityPlayerMP.posZ);
        Vec3 vec32 = entityPlayerMP.getLook(1.0f);
        Vec3 vec33 = vec3._c(vec32._c * (double)f, vec32._d * (double)f, vec32._e * (double)f);
        MovingObjectPosition movingObjectPosition = entityPlayerMP.worldObj.func_72933_a(vec3, vec33);
        if (movingObjectPosition == null || movingObjectPosition._c != EnumMovingObjectType._a) {
            return null;
        }
        return new xtcd(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f);
    }

    public Entity getPlayerLookingAtEntity(EntityPlayerMP entityPlayerMP, float f) {
        Vec3 vec3 = Vec3._a(entityPlayerMP.posX, entityPlayerMP.posY + 1.62 - (double)entityPlayerMP.yOffset, entityPlayerMP.posZ);
        Vec3 vec32 = entityPlayerMP.getLook(1.0f);
        Vec3 vec33 = vec3._c(vec32._c * (double)f, vec32._d * (double)f, vec32._e * (double)f);
        MovingObjectPosition movingObjectPosition = entityPlayerMP.worldObj.func_72933_a(vec3, vec33);
        if (movingObjectPosition == null || movingObjectPosition._c != EnumMovingObjectType._b) {
            return null;
        }
        return movingObjectPosition._i;
    }
}

