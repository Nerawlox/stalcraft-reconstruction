/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.haddon.PrivateAccessException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;

public class MAtProcessorRelaxed
extends MAtProcessorModel {
    private Map<String, Integer> deprecatedBiomeHash = new HashMap<String, Integer>();
    private Random random;
    private Map<String, Integer> serverAddresses;
    private Map<String, Integer> serverPorts;

    public MAtProcessorRelaxed(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
        this.deprecatedBiomeHash.put("Swampland", 2);
        this.deprecatedBiomeHash.put("Forest", 4);
        this.deprecatedBiomeHash.put("Taiga", 7);
        this.deprecatedBiomeHash.put("Desert", 8);
        this.deprecatedBiomeHash.put("Plains", 9);
        this.deprecatedBiomeHash.put("Hell", 12);
        this.deprecatedBiomeHash.put("Sky", 13);
        this.deprecatedBiomeHash.put("Ocean", 14);
        this.deprecatedBiomeHash.put("Extreme Hills", 15);
        this.deprecatedBiomeHash.put("River", 16);
        this.deprecatedBiomeHash.put("FrozenOcean", 17);
        this.deprecatedBiomeHash.put("FrozenRiver", 18);
        this.deprecatedBiomeHash.put("Ice Plains", 19);
        this.deprecatedBiomeHash.put("Ice Mountains", 20);
        this.deprecatedBiomeHash.put("MushroomIsland", 21);
        this.deprecatedBiomeHash.put("MushroomIslandShore", 22);
        this.deprecatedBiomeHash.put("Beach", 23);
        this.deprecatedBiomeHash.put("DesertHills", 24);
        this.deprecatedBiomeHash.put("ForestHills", 25);
        this.deprecatedBiomeHash.put("TaigaHills", 26);
        this.deprecatedBiomeHash.put("Extreme Hills Edge", 27);
        this.deprecatedBiomeHash.put("Jungle", 28);
        this.deprecatedBiomeHash.put("JungleHills", 29);
        this.random = new Random(System.nanoTime());
        this.serverAddresses = new HashMap<String, Integer>();
        this.serverPorts = new HashMap<String, Integer>();
    }

    @Override
    protected void doProcess() {
        Object object;
        xpzm xpzm2 = xpzm._E();
        pkix pkix2 = xpzm2._r;
        Set<Integer> set = this.getRequired();
        if (set.contains(75) || set.contains(76) || set.contains(77) || set.contains(78) || set.contains(79) || set.contains(80)) {
            Object object2 = null;
            try {
                object2 = (htsm)this.mod().util().getPrivate(xpzm._E(), "currentServerData");
            }
            catch (PrivateAccessException privateAccessException) {
                privateAccessException.printStackTrace();
            }
            if (object2 != null && ((htsm)object2)._b != null) {
                String object3 = ((htsm)object2)._b;
                this.computeServerIP(object3);
                String string = ((htsm)object2)._d;
                object = ((htsm)object2)._a;
                if (string == null) {
                    string = "";
                }
                if (object == null) {
                    object = "";
                }
                this.setValue(75, 1);
                this.setValue(76, ((htsm)object2)._b.toLowerCase(Locale.ENGLISH).hashCode());
                this.setValue(77, string.hashCode());
                this.setValue(78, ((String)object).hashCode());
                this.setValue(79, this.serverAddresses.get(object3));
                this.setValue(80, this.serverPorts.get(object3));
            } else {
                this.setValue(75, 0);
                this.setValue(76, 0);
                this.setValue(77, 0);
                this.setValue(78, 0);
                this.setValue(79, 0);
                this.setValue(80, 0);
            }
        }
        for (Integer n : set) {
            switch (n) {
                case 5: {
                    this.setValue(5, pkix2.field_73011_w._i);
                    break;
                }
                case 12: {
                    this.setValue(12, pkix2.field_72995_K ? 1 : 0);
                    break;
                }
                case 13: {
                    this.setValue(13, 1 + this.random.nextInt(100));
                    break;
                }
                case 14: {
                    this.setValue(14, 1 + this.random.nextInt(100));
                    break;
                }
                case 15: {
                    this.setValue(15, 1 + this.random.nextInt(100));
                    break;
                }
                case 16: {
                    this.setValue(16, 1 + this.random.nextInt(100));
                    break;
                }
                case 17: {
                    this.setValue(17, 1 + this.random.nextInt(100));
                    break;
                }
                case 18: {
                    this.setValue(18, 1 + this.random.nextInt(100));
                    break;
                }
                case 29: {
                    int n2 = this.mod().getConfig().getInteger("useroptions.biome.override");
                    if (n2 <= -1) {
                        object = this.deprecatedBiomeHash.get(this.calculateBiome()._y);
                        if (object == null) {
                            object = -1;
                        }
                        this.setValue(29, (Integer)object);
                        break;
                    }
                    this.setValue(29, n2);
                    break;
                }
                case 30: {
                    this.setValue(30, (int)(pkix2.func_72905_C() >> 32));
                    break;
                }
                case 31: {
                    this.setValue(31, (int)(pkix2.func_72905_C() & 0xFFFFFFFFFFFFFFFFL));
                    break;
                }
                case 88: {
                    this.setValue(88, pkix2.func_72853_d());
                    break;
                }
                case 93: {
                    int n3 = this.mod().getConfig().getInteger("useroptions.biome.override");
                    if (n3 <= -1) {
                        this.setValue(93, this.calculateBiome()._P);
                        break;
                    }
                    this.setValue(93, n3);
                    break;
                }
            }
        }
    }

    private void computeServerIP(String string) {
        int n;
        Object object;
        int n2;
        if (this.serverAddresses.containsKey(string)) {
            return;
        }
        String[] stringArray = string.split(":");
        if (string.startsWith("[") && (n2 = string.indexOf("]")) > 0) {
            String string2 = string.substring(1, n2);
            object = string.substring(n2 + 1).trim();
            if (object.startsWith(":") && object.length() > 0) {
                object = object.substring(1);
                stringArray = new String[]{string2, object};
            } else {
                stringArray = new String[]{string2};
            }
        }
        if (stringArray.length > 2) {
            stringArray = new String[]{string};
        }
        String string3 = stringArray[0];
        int n3 = n = stringArray.length > 1 ? MAtProcessorRelaxed.parseIntWithDefault(stringArray[1], 25565) : 25565;
        if (n == 25565) {
            object = MAtProcessorRelaxed.useDnsC(string3);
            string3 = object[0];
            n = MAtProcessorRelaxed.parseIntWithDefault(object[1], 25565);
        }
        object = string3;
        int n4 = n;
        String string4 = "<could not determine>";
        int n5 = 0;
        try {
            string4 = InetAddress.getByName((String)object).getHostAddress();
            n5 = string4.hashCode();
        }
        catch (UnknownHostException unknownHostException) {
            // empty catch block
        }
        this.serverAddresses.put(string, n5);
        this.serverPorts.put(string, n4);
        System.out.println("Computed server IP and hashed as (" + n5 + ") : " + n4);
    }

    private static String[] useDnsC(String string) {
        try {
            Hashtable<String, String> hashtable = new Hashtable<String, String>();
            hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            hashtable.put("java.naming.provider.url", "dns:");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            Attributes attributes = initialDirContext.getAttributes("_minecraft._tcp." + string, new String[]{"SRV"});
            String[] stringArray = attributes.get("srv").get().toString().split(" ", 4);
            return new String[]{stringArray[3], stringArray[2]};
        }
        catch (Throwable throwable) {
            return new String[]{string, Integer.toString(25565)};
        }
    }

    private static int parseIntWithDefault(String string, int n) {
        try {
            return Integer.parseInt(string.trim());
        }
        catch (Exception exception) {
            return n;
        }
    }

    private foqh calculateBiome() {
        xpzm xpzm2 = xpzm._E();
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        int n = sajh._c(entityClientPlayerMP.field_70165_t);
        int n2 = sajh._c(entityClientPlayerMP.field_70161_v);
        ixzi ixzi2 = xpzm2._r.func_72938_d(n, n2);
        return ixzi2._a(n & 0xF, n2 & 0xF, xpzm2._r.func_72959_q());
    }
}

