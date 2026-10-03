/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;

public class ohmz
implements zyqp {
    public final Map field_71562_a = new HashMap();
    public final Set field_71561_b = new HashSet();

    @Override
    public int func_71556_a(nemo nemo2, String string) {
        if ((string = string.trim()).startsWith("/")) {
            string = string.substring(1);
        }
        String[] stringArray = string.split(" ");
        String string2 = stringArray[0];
        stringArray = ohmz.func_71559_a(stringArray);
        kmew kmew2 = (kmew)this.field_71562_a.get(string2);
        int n = this.func_82370_a(kmew2, stringArray);
        int n2 = 0;
        try {
            if (kmew2 == null) {
                throw new dhob();
            }
            if (kmew2.func_71519_b(nemo2)) {
                CommandEvent commandEvent = new CommandEvent(kmew2, nemo2, stringArray);
                if (MinecraftForge.EVENT_BUS.post(commandEvent)) {
                    if (commandEvent.exception != null) {
                        throw commandEvent.exception;
                    }
                    return 1;
                }
                if (n > -1) {
                    EntityPlayerMP[] entityPlayerMPArray = zhop._c(nemo2, stringArray[n]);
                    String string3 = stringArray[n];
                    EntityPlayerMP[] entityPlayerMPArray2 = entityPlayerMPArray;
                    int n3 = entityPlayerMPArray.length;
                    for (int i = 0; i < n3; ++i) {
                        EntityPlayerMP entityPlayerMP = entityPlayerMPArray2[i];
                        stringArray[n] = entityPlayerMP.func_70023_ak();
                        try {
                            kmew2.func_71515_b(nemo2, stringArray);
                            ++n2;
                            continue;
                        }
                        catch (cekk cekk2) {
                            nemo2.func_70006_a(zwat._b(cekk2.getMessage(), cekk2._a())._a(ezfc._m));
                        }
                    }
                    stringArray[n] = string3;
                } else {
                    kmew2.func_71515_b(nemo2, stringArray);
                    ++n2;
                }
            } else {
                nemo2.func_70006_a(zwat._e("commands.generic.permission")._a(ezfc._m));
            }
        }
        catch (pksd pksd2) {
            nemo2.func_70006_a(zwat._b("commands.generic.usage", zwat._b(pksd2.getMessage(), pksd2._a()))._a(ezfc._m));
        }
        catch (cekk cekk3) {
            nemo2.func_70006_a(zwat._b(cekk3.getMessage(), cekk3._a())._a(ezfc._m));
        }
        catch (Throwable throwable) {
            nemo2.func_70006_a(zwat._e("commands.generic.exception")._a(ezfc._m));
            throwable.printStackTrace();
        }
        return n2;
    }

    public kmew func_71560_a(kmew kmew2) {
        List list2 = kmew2.func_71514_a();
        this.field_71562_a.put(kmew2.func_71517_b(), kmew2);
        this.field_71561_b.add(kmew2);
        if (list2 != null) {
            for (String string : list2) {
                kmew kmew3 = (kmew)this.field_71562_a.get(string);
                if (kmew3 != null && kmew3.func_71517_b().equals(string)) continue;
                this.field_71562_a.put(string, kmew2);
            }
        }
        return kmew2;
    }

    public static String[] func_71559_a(String[] stringArray) {
        String[] stringArray2 = new String[stringArray.length - 1];
        for (int i = 1; i < stringArray.length; ++i) {
            stringArray2[i - 1] = stringArray[i];
        }
        return stringArray2;
    }

    @Override
    public List func_71558_b(nemo nemo2, String string) {
        kmew kmew2;
        String[] stringArray = string.split(" ", -1);
        String string2 = stringArray[0];
        if (stringArray.length == 1) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.field_71562_a.entrySet()) {
                if (!ohnk.func_71523_a(string2, (String)entry.getKey()) || !((kmew)entry.getValue()).func_71519_b(nemo2)) continue;
                arrayList.add(entry.getKey());
            }
            return arrayList;
        }
        if (stringArray.length > 1 && (kmew2 = (kmew)this.field_71562_a.get(string2)) != null) {
            return kmew2.func_71516_a(nemo2, ohmz.func_71559_a(stringArray));
        }
        return null;
    }

    @Override
    public List func_71557_a(nemo nemo2) {
        ArrayList<kmew> arrayList = new ArrayList<kmew>();
        for (kmew kmew2 : this.field_71561_b) {
            if (!kmew2.func_71519_b(nemo2)) continue;
            arrayList.add(kmew2);
        }
        return arrayList;
    }

    @Override
    public Map func_71555_a() {
        return this.field_71562_a;
    }

    public int func_82370_a(kmew kmew2, String[] stringArray) {
        if (kmew2 == null) {
            return -1;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            if (!kmew2.func_82358_a(stringArray, i) || !zhop._a(stringArray[i])) continue;
            return i;
        }
        return -1;
    }
}

