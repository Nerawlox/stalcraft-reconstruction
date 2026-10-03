/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;

public abstract class ohnk
implements kmew {
    public static pksi field_71533_a;

    public int func_82362_a() {
        return 4;
    }

    @Override
    public List func_71514_a() {
        return null;
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return nemo2.func_70003_b(this.func_82362_a(), this.func_71517_b());
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        return null;
    }

    public static int func_71526_a(nemo nemo2, String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new jjcb("commands.generic.num.invalid", string);
        }
    }

    public static int func_71528_a(nemo nemo2, String string, int n) {
        return ohnk.func_71532_a(nemo2, string, n, Integer.MAX_VALUE);
    }

    public static int func_71532_a(nemo nemo2, String string, int n, int n2) {
        int n3 = ohnk.func_71526_a(nemo2, string);
        if (n3 < n) {
            throw new jjcb("commands.generic.num.tooSmall", n3, n);
        }
        if (n3 > n2) {
            throw new jjcb("commands.generic.num.tooBig", n3, n2);
        }
        return n3;
    }

    public static double func_82363_b(nemo nemo2, String string) {
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

    public static double func_110664_a(nemo nemo2, String string, double d) {
        return ohnk.func_110661_a(nemo2, string, d, Double.MAX_VALUE);
    }

    public static double func_110661_a(nemo nemo2, String string, double d, double d2) {
        double d3 = ohnk.func_82363_b(nemo2, string);
        if (d3 < d) {
            throw new jjcb("commands.generic.double.tooSmall", d3, d);
        }
        if (d3 > d2) {
            throw new jjcb("commands.generic.double.tooBig", d3, d2);
        }
        return d3;
    }

    public static boolean func_110662_c(nemo nemo2, String string) {
        if (string.equals("true") || string.equals("1")) {
            return true;
        }
        if (string.equals("false") || string.equals("0")) {
            return false;
        }
        throw new cekk("commands.generic.boolean.invalid", string);
    }

    public static EntityPlayerMP func_71521_c(nemo nemo2) {
        if (nemo2 instanceof EntityPlayerMP) {
            return (EntityPlayerMP)nemo2;
        }
        throw new mskk("You must specify which player you wish to perform this action on.", new Object[0]);
    }

    public static EntityPlayerMP func_82359_c(nemo nemo2, String string) {
        EntityPlayerMP entityPlayerMP = zhop._a(nemo2, string);
        if (entityPlayerMP != null) {
            return entityPlayerMP;
        }
        entityPlayerMP = dzfd._I().__ag()._h(string);
        if (entityPlayerMP == null) {
            throw new mskk();
        }
        return entityPlayerMP;
    }

    public static String func_96332_d(nemo nemo2, String string) {
        EntityPlayerMP entityPlayerMP = zhop._a(nemo2, string);
        if (entityPlayerMP != null) {
            return entityPlayerMP.func_70023_ak();
        }
        if (zhop._b(string)) {
            throw new mskk();
        }
        return string;
    }

    public static String func_82360_a(nemo nemo2, String[] stringArray, int n) {
        return ohnk.func_82361_a(nemo2, stringArray, n, false);
    }

    public static String func_82361_a(nemo nemo2, String[] stringArray, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < stringArray.length; ++i) {
            if (i > n) {
                stringBuilder.append(" ");
            }
            String string = stringArray[i];
            if (bl) {
                String string2 = zhop._b(nemo2, string);
                if (string2 != null) {
                    string = string2;
                } else if (zhop._b(string)) {
                    throw new mskk();
                }
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static double func_110666_a(nemo nemo2, double d, String string) {
        return ohnk.func_110665_a(nemo2, d, string, -30000000, 30000000);
    }

    public static double func_110665_a(nemo nemo2, double d, String string, int n, int n2) {
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
            d2 += ohnk.func_82363_b(nemo2, string);
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

    public static String func_71527_a(Object[] objectArray) {
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
        return ohnk.func_71527_a(collection.toArray(new String[collection.size()]));
    }

    public static String func_110663_b(Collection collection) {
        Object[] objectArray = new String[collection.size()];
        int n = 0;
        for (EntityLivingBase entityLivingBase : collection) {
            objectArray[n++] = entityLivingBase.func_96090_ax();
        }
        return ohnk.func_71527_a(objectArray);
    }

    public static boolean func_71523_a(String string, String string2) {
        return string2.regionMatches(true, 0, string, 0, string.length());
    }

    public static List func_71530_a(String[] stringArray, String ... stringArray2) {
        String string = stringArray[stringArray.length - 1];
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : stringArray2) {
            if (!ohnk.func_71523_a(string, string2)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static List func_71531_a(String[] stringArray, Iterable iterable) {
        String string = stringArray[stringArray.length - 1];
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : iterable) {
            if (!ohnk.func_71523_a(string, string2)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return false;
    }

    public static void func_71522_a(nemo nemo2, String string, Object ... objectArray) {
        ohnk.func_71524_a(nemo2, 0, string, objectArray);
    }

    public static void func_71524_a(nemo nemo2, int n, String string, Object ... objectArray) {
        if (field_71533_a != null) {
            field_71533_a._a(nemo2, n, string, objectArray);
        }
    }

    public static void func_71529_a(pksi pksi2) {
        field_71533_a = pksi2;
    }

    public int func_71525_a(kmew kmew2) {
        return this.func_71517_b().compareTo(kmew2.func_71517_b());
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.func_71525_a((kmew)object);
    }
}

