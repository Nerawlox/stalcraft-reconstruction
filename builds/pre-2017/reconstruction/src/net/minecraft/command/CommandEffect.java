/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandEffect
extends CommandBase {
    @Override
    public String getCommandName() {
        return "effect";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.effect.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length < 2) throw new pksd("commands.effect.usage", new Object[0]);
        EntityPlayerMP entityPlayerMP = CommandEffect.getPlayer(iCommandSender, stringArray[0]);
        if (stringArray[1].equals("clear")) {
            if (entityPlayerMP.getActivePotionEffects().isEmpty()) {
                throw new cekk("commands.effect.failure.notActive.all", entityPlayerMP.getEntityName());
            }
            entityPlayerMP.clearActivePotions();
            CommandEffect.notifyAdmins(iCommandSender, "commands.effect.success.removed.all", entityPlayerMP.getEntityName());
            return;
        } else {
            int n = CommandEffect.parseIntWithMin(iCommandSender, stringArray[1], 1);
            int n2 = 600;
            int n3 = 30;
            int n4 = 0;
            if (n < 0 || n >= Potion._a.length || Potion._a[n] == null) {
                throw new jjcb("commands.effect.notFound", n);
            }
            if (stringArray.length >= 3) {
                n3 = CommandEffect.parseIntBounded(iCommandSender, stringArray[2], 0, 1000000);
                n2 = Potion._a[n]._b() ? n3 : n3 * 20;
            } else if (Potion._a[n]._b()) {
                n2 = 1;
            }
            if (stringArray.length >= 4) {
                n4 = CommandEffect.parseIntBounded(iCommandSender, stringArray[3], 0, 255);
            }
            if (n3 == 0) {
                if (!entityPlayerMP.isPotionActive(n)) throw new cekk("commands.effect.failure.notActive", ChatMessageComponent._e(Potion._a[n]._c()), entityPlayerMP.getEntityName());
                entityPlayerMP.removePotionEffect(n);
                CommandEffect.notifyAdmins(iCommandSender, "commands.effect.success.removed", ChatMessageComponent._e(Potion._a[n]._c()), entityPlayerMP.getEntityName());
                return;
            } else {
                PotionEffect potionEffect = new PotionEffect(n, n2, n4);
                entityPlayerMP.addPotionEffect(potionEffect);
                CommandEffect.notifyAdmins(iCommandSender, "commands.effect.success", ChatMessageComponent._e(potionEffect._g()), n, n4, entityPlayerMP.getEntityName(), n3);
            }
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandEffect.getListOfStringsMatchingLastWord(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return MinecraftServer._I()._i();
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 0;
    }
}

