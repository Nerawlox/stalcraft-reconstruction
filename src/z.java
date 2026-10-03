/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ab
 *  ad
 *  ay
 *  az
 *  bb
 *  com.google.common.primitives.Doubles
 *  net.minecraft.server.MinecraftServer
 *  y
 */
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public abstract class z
implements ab {
    private static y a;

    public int a() {
        return 4;
    }

    public List b() {
        return null;
    }

    public boolean a(ad par1ICommandSender) {
        return par1ICommandSender.a(this.a(), this.c());
    }

    public List a(ad par1ICommandSender, String[] par2ArrayOfStr) {
        return null;
    }

    public static int a(ad par0ICommandSender, String par1Str) {
        try {
            return Integer.parseInt(par1Str);
        }
        catch (NumberFormatException numberformatexception) {
            throw new az("commands.generic.num.invalid", new Object[]{par1Str});
        }
    }

    public static int a(ad par0ICommandSender, String par1Str, int par2) {
        return z.a(par0ICommandSender, par1Str, par2, Integer.MAX_VALUE);
    }

    public static int a(ad par0ICommandSender, String par1Str, int par2, int par3) {
        int k2 = z.a(par0ICommandSender, par1Str);
        if (k2 < par2) {
            throw new az("commands.generic.num.tooSmall", new Object[]{k2, par2});
        }
        if (k2 > par3) {
            throw new az("commands.generic.num.tooBig", new Object[]{k2, par3});
        }
        return k2;
    }

    public static double b(ad par0ICommandSender, String par1Str) {
        try {
            double d0 = Double.parseDouble(par1Str);
            if (!Doubles.isFinite((double)d0)) {
                throw new az("commands.generic.double.invalid", new Object[]{par1Str});
            }
            return d0;
        }
        catch (NumberFormatException numberformatexception) {
            throw new az("commands.generic.double.invalid", new Object[]{par1Str});
        }
    }

    public static double a(ad par0ICommandSender, String par1Str, double par2) {
        return z.a(par0ICommandSender, par1Str, par2, Double.MAX_VALUE);
    }

    public static double a(ad par0ICommandSender, String par1Str, double par2, double par4) {
        double d2 = z.b(par0ICommandSender, par1Str);
        if (d2 < par2) {
            throw new az("commands.generic.double.tooSmall", new Object[]{d2, par2});
        }
        if (d2 > par4) {
            throw new az("commands.generic.double.tooBig", new Object[]{d2, par4});
        }
        return d2;
    }

    public static boolean c(ad par0ICommandSender, String par1Str) {
        if (!par1Str.equals("true") && !par1Str.equals("1")) {
            if (!par1Str.equals("false") && !par1Str.equals("0")) {
                throw new ay("commands.generic.boolean.invalid", new Object[]{par1Str});
            }
            return false;
        }
        return true;
    }

    public static jv b(ad par0ICommandSender) {
        if (par0ICommandSender instanceof jv) {
            return (jv)par0ICommandSender;
        }
        throw new bb("You must specify which player you wish to perform this action on.", new Object[0]);
    }

    public static jv d(ad par0ICommandSender, String par1Str) {
        jv entityplayermp = ae.a(par0ICommandSender, par1Str);
        if (entityplayermp != null) {
            return entityplayermp;
        }
        entityplayermp = MinecraftServer.F().af().f(par1Str);
        if (entityplayermp == null) {
            throw new bb();
        }
        return entityplayermp;
    }

    public static String e(ad par0ICommandSender, String par1Str) {
        jv entityplayermp = ae.a(par0ICommandSender, par1Str);
        if (entityplayermp != null) {
            return entityplayermp.an();
        }
        if (ae.b(par1Str)) {
            throw new bb();
        }
        return par1Str;
    }

    public static String a(ad par0ICommandSender, String[] par1ArrayOfStr, int par2) {
        return z.a(par0ICommandSender, par1ArrayOfStr, par2, false);
    }

    public static String a(ad par0ICommandSender, String[] par1ArrayOfStr, int par2, boolean par3) {
        StringBuilder stringbuilder = new StringBuilder();
        for (int j2 = par2; j2 < par1ArrayOfStr.length; ++j2) {
            if (j2 > par2) {
                stringbuilder.append(" ");
            }
            String s2 = par1ArrayOfStr[j2];
            if (par3) {
                String s1 = ae.b(par0ICommandSender, s2);
                if (s1 != null) {
                    s2 = s1;
                } else if (ae.b(s2)) {
                    throw new bb();
                }
            }
            stringbuilder.append(s2);
        }
        return stringbuilder.toString();
    }

    public static double a(ad par0ICommandSender, double par1, String par3Str) {
        return z.a(par0ICommandSender, par1, par3Str, -30000000, 30000000);
    }

    public static double a(ad par0ICommandSender, double par1, String par3Str, int par4, int par5) {
        double d1;
        boolean flag = par3Str.startsWith("~");
        if (flag && Double.isNaN(par1)) {
            throw new az("commands.generic.num.invalid", new Object[]{par1});
        }
        double d2 = d1 = flag ? par1 : 0.0;
        if (!flag || par3Str.length() > 1) {
            boolean flag1 = par3Str.contains(".");
            if (flag) {
                par3Str = par3Str.substring(1);
            }
            d1 += z.b(par0ICommandSender, par3Str);
            if (!flag1 && !flag) {
                d1 += 0.5;
            }
        }
        if (par4 != 0 || par5 != 0) {
            if (d1 < (double)par4) {
                throw new az("commands.generic.double.tooSmall", new Object[]{d1, par4});
            }
            if (d1 > (double)par5) {
                throw new az("commands.generic.double.tooBig", new Object[]{d1, par5});
            }
        }
        return d1;
    }

    public static String a(Object[] par0ArrayOfObj) {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i2 = 0; i2 < par0ArrayOfObj.length; ++i2) {
            String s2 = par0ArrayOfObj[i2].toString();
            if (i2 > 0) {
                if (i2 == par0ArrayOfObj.length - 1) {
                    stringbuilder.append(" and ");
                } else {
                    stringbuilder.append(", ");
                }
            }
            stringbuilder.append(s2);
        }
        return stringbuilder.toString();
    }

    public static String a(Collection par0Collection) {
        return z.a(par0Collection.toArray(new String[par0Collection.size()]));
    }

    public static String b(Collection par0Collection) {
        Object[] astring = new String[par0Collection.size()];
        int i2 = 0;
        for (of entitylivingbase : par0Collection) {
            astring[i2++] = entitylivingbase.ay();
        }
        return z.a(astring);
    }

    public static boolean a(String par0Str, String par1Str) {
        return par1Str.regionMatches(true, 0, par0Str, 0, par0Str.length());
    }

    public static List a(String[] par0ArrayOfStr, String ... par1ArrayOfStr) {
        String s1 = par0ArrayOfStr[par0ArrayOfStr.length - 1];
        ArrayList<String> arraylist = new ArrayList<String>();
        String[] astring1 = par1ArrayOfStr;
        int i2 = par1ArrayOfStr.length;
        for (int j2 = 0; j2 < i2; ++j2) {
            String s2 = astring1[j2];
            if (!z.a(s1, s2)) continue;
            arraylist.add(s2);
        }
        return arraylist;
    }

    public static List a(String[] par0ArrayOfStr, Iterable par1Iterable) {
        String s2 = par0ArrayOfStr[par0ArrayOfStr.length - 1];
        ArrayList<String> arraylist = new ArrayList<String>();
        for (String s1 : par1Iterable) {
            if (!z.a(s2, s1)) continue;
            arraylist.add(s1);
        }
        return arraylist;
    }

    public boolean a(String[] par1ArrayOfStr, int par2) {
        return false;
    }

    public static void a(ad par0ICommandSender, String par1Str, Object ... par2ArrayOfObj) {
        z.a(par0ICommandSender, 0, par1Str, par2ArrayOfObj);
    }

    public static void a(ad par0ICommandSender, int par1, String par2Str, Object ... par3ArrayOfObj) {
        if (a != null) {
            a.a(par0ICommandSender, par1, par2Str, par3ArrayOfObj);
        }
    }

    public static void a(y par0IAdminCommand) {
        a = par0IAdminCommand;
    }

    public int a(ab par1ICommand) {
        return this.c().compareTo(par1ICommand.c());
    }

    public int compareTo(Object par1Obj) {
        return this.a((ab)par1Obj);
    }
}

