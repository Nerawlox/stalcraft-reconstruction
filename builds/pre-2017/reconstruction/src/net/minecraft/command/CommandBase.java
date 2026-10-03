/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.command.IAdminCommand;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public abstract class CommandBase
implements ICommand {
    public static IAdminCommand theAdmin;

    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public List getCommandAliases() {
        return null;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return iCommandSender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        return null;
    }

    public static int parseInt(ICommandSender iCommandSender, String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new jjcb("commands.generic.num.invalid", string);
        }
    }

    public static int parseIntWithMin(ICommandSender iCommandSender, String string, int n) {
        return CommandBase.parseIntBounded(iCommandSender, string, n, Integer.MAX_VALUE);
    }

    public static int parseIntBounded(ICommandSender iCommandSender, String string, int n, int n2) {
        int n3 = CommandBase.parseInt(iCommandSender, string);
        if (n3 < n) {
            throw new jjcb("commands.generic.num.tooSmall", n3, n);
        }
        if (n3 > n2) {
            throw new jjcb("commands.generic.num.tooBig", n3, n2);
        }
        return n3;
    }

    public static double parseDouble(ICommandSender iCommandSender, String string) {
        try {
            double d = Double.parseDouble(string);
            if (!Doubles.isFinite(d)) {
                throw new jjcb("commands.generic.double.invalid", string);
            }
            return d;
        }
        catch (NumberFormatException numberFormatException) {
            throw new jjcb("commands.generic.double.invalid", string);
        }
    }

    public static double func_110664_a(ICommandSender iCommandSender, String string, double d) {
        return CommandBase.func_110661_a(iCommandSender, string, d, Double.MAX_VALUE);
    }

    public static double func_110661_a(ICommandSender iCommandSender, String string, double d, double d2) {
        double d3 = CommandBase.parseDouble(iCommandSender, string);
        if (d3 < d) {
            throw new jjcb("commands.generic.double.tooSmall", d3, d);
        }
        if (d3 > d2) {
            throw new jjcb("commands.generic.double.tooBig", d3, d2);
        }
        return d3;
    }

    public static boolean func_110662_c(ICommandSender iCommandSender, String string) {
        if (string.equals("true") || string.equals("1")) {
            return true;
        }
        if (string.equals("false") || string.equals("0")) {
            return false;
        }
        throw new cekk("commands.generic.boolean.invalid", string);
    }

    public static EntityPlayerMP getCommandSenderAsPlayer(ICommandSender iCommandSender) {
        if (iCommandSender instanceof EntityPlayerMP) {
            return (EntityPlayerMP)iCommandSender;
        }
        throw new mskk("You must specify which player you wish to perform this action on.", new Object[0]);
    }

    public static EntityPlayerMP getPlayer(ICommandSender iCommandSender, String string) {
        EntityPlayerMP entityPlayerMP = PlayerSelector._a(iCommandSender, string);
        if (entityPlayerMP != null) {
            return entityPlayerMP;
        }
        entityPlayerMP = MinecraftServer._I().__ag()._h(string);
        if (entityPlayerMP == null) {
            throw new mskk();
        }
        return entityPlayerMP;
    }

    public static String func_96332_d(ICommandSender iCommandSender, String string) {
        EntityPlayerMP entityPlayerMP = PlayerSelector._a(iCommandSender, string);
        if (entityPlayerMP != null) {
            return entityPlayerMP.getEntityName();
        }
        if (PlayerSelector._b(string)) {
            throw new mskk();
        }
        return string;
    }

    public static String func_82360_a(ICommandSender iCommandSender, String[] stringArray, int n) {
        return CommandBase.func_82361_a(iCommandSender, stringArray, n, false);
    }

    public static String func_82361_a(ICommandSender iCommandSender, String[] stringArray, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < stringArray.length; ++i) {
            if (i > n) {
                stringBuilder.append(" ");
            }
            String string = stringArray[i];
            if (bl) {
                String string2 = PlayerSelector._b(iCommandSender, string);
                if (string2 != null) {
                    string = string2;
                } else if (PlayerSelector._b(string)) {
                    throw new mskk();
                }
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static double func_110666_a(ICommandSender iCommandSender, double d, String string) {
        return CommandBase.func_110665_a(iCommandSender, d, string, -30000000, 30000000);
    }

    public static double func_110665_a(ICommandSender iCommandSender, double d, String string, int n, int n2) {
        double d2;
        boolean bl = string.startsWith("~");
        if (bl && Double.isNaN(d)) {
            throw new jjcb("commands.generic.num.invalid", d);
        }
        double d3 = d2 = bl ? d : 0.0;
        if (!bl || string.length() > 1) {
            boolean bl2 = string.contains(".");
            if (bl) {
                string = string.substring(1);
            }
            d2 += CommandBase.parseDouble(iCommandSender, string);
            if (!bl2 && !bl) {
                d2 += 0.5;
            }
        }
        if (n != 0 || n2 != 0) {
            if (d2 < (double)n) {
                throw new jjcb("commands.generic.double.tooSmall", d2, n);
            }
            if (d2 > (double)n2) {
                throw new jjcb("commands.generic.double.tooBig", d2, n2);
            }
        }
        return d2;
    }

    public static String joinNiceString(Object[] objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objectArray.length; ++i) {
            String string = objectArray[i].toString();
            if (i > 0) {
                if (i == objectArray.length - 1) {
                    stringBuilder.append(" and ");
                } else {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static String func_96333_a(Collection collection) {
        return CommandBase.joinNiceString(collection.toArray(new String[collection.size()]));
    }

    public static String func_110663_b(Collection collection) {
        Object[] objectArray = new String[collection.size()];
        int n = 0;
        for (EntityLivingBase entityLivingBase : collection) {
            objectArray[n++] = entityLivingBase.getTranslatedEntityName();
        }
        return CommandBase.joinNiceString(objectArray);
    }

    public static boolean doesStringStartWith(String string, String string2) {
        return string2.regionMatches(true, 0, string, 0, string.length());
    }

    public static List getListOfStringsMatchingLastWord(String[] stringArray, String ... stringArray2) {
        String string = stringArray[stringArray.length - 1];
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : stringArray2) {
            if (!CommandBase.doesStringStartWith(string, string2)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static List getListOfStringsFromIterableMatchingLastWord(String[] stringArray, Iterable iterable) {
        String string = stringArray[stringArray.length - 1];
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : iterable) {
            if (!CommandBase.doesStringStartWith(string, string2)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return false;
    }

    public static void notifyAdmins(ICommandSender iCommandSender, String string, Object ... objectArray) {
        CommandBase.notifyAdmins(iCommandSender, 0, string, objectArray);
    }

    public static void notifyAdmins(ICommandSender iCommandSender, int n, String string, Object ... objectArray) {
        if (theAdmin != null) {
            theAdmin._a(iCommandSender, n, string, objectArray);
        }
    }

    public static void setAdminCommander(IAdminCommand iAdminCommand) {
        theAdmin = iAdminCommand;
    }

    public int compareTo(ICommand iCommand) {
        return this.getCommandName().compareTo(iCommand.getCommandName());
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.compareTo((ICommand)object);
    }
}

