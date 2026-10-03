/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayerMP;

public class nvlm
extends ohnk {
    @Override
    public String func_71517_b() {
        return "playsound";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.playsound.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length < 2) {
            throw new pksd(this.func_71518_a(nemo2), new Object[0]);
        }
        int n = 0;
        String string = stringArray[n++];
        EntityPlayerMP entityPlayerMP = nvlm.func_82359_c(nemo2, stringArray[n++]);
        double d = entityPlayerMP.func_82114_b()._a;
        double d2 = entityPlayerMP.func_82114_b()._b;
        double d3 = entityPlayerMP.func_82114_b()._c;
        double d4 = 1.0;
        double d5 = 1.0;
        double d6 = 0.0;
        if (stringArray.length > n) {
            d = nvlm.func_110666_a(nemo2, d, stringArray[n++]);
        }
        if (stringArray.length > n) {
            d2 = nvlm.func_110665_a(nemo2, d2, stringArray[n++], 0, 0);
        }
        if (stringArray.length > n) {
            d3 = nvlm.func_110666_a(nemo2, d3, stringArray[n++]);
        }
        if (stringArray.length > n) {
            d4 = nvlm.func_110661_a(nemo2, stringArray[n++], 0.0, 3.4028234663852886E38);
        }
        if (stringArray.length > n) {
            d5 = nvlm.func_110661_a(nemo2, stringArray[n++], 0.0, 2.0);
        }
        if (stringArray.length > n) {
            d6 = nvlm.func_110661_a(nemo2, stringArray[n++], 0.0, 1.0);
        }
        double d7 = d4 > 1.0 ? d4 * 16.0 : 16.0;
        double d8 = entityPlayerMP.func_70011_f(d, d2, d3);
        if (d8 > d7) {
            if (!(d6 > 0.0)) throw new cekk("commands.playsound.playerTooFar", entityPlayerMP.func_70023_ak());
            double d9 = d - entityPlayerMP.field_70165_t;
            double d10 = d2 - entityPlayerMP.field_70163_u;
            double d11 = d3 - entityPlayerMP.field_70161_v;
            double d12 = Math.sqrt(d9 * d9 + d10 * d10 + d11 * d11);
            double d13 = entityPlayerMP.field_70165_t;
            double d14 = entityPlayerMP.field_70163_u;
            double d15 = entityPlayerMP.field_70161_v;
            if (d12 > 0.0) {
                d13 += d9 / d12 * 2.0;
                d14 += d10 / d12 * 2.0;
                d15 += d11 / d12 * 2.0;
            }
            entityPlayerMP.field_71135_a.func_72567_b(new lpza(string, d13, d14, d15, (float)d6, (float)d5));
        } else {
            entityPlayerMP.field_71135_a.func_72567_b(new lpza(string, d, d2, d3, (float)d4, (float)d5));
        }
        nvlm.func_71522_a(nemo2, "commands.playsound.success", string, entityPlayerMP.func_70023_ak());
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 1;
    }
}

