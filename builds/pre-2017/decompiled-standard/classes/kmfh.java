/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;

public class kmfh
extends ohnk {
    @Override
    public String func_71517_b() {
        return "tp";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.tp.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1) {
            EntityPlayerMP entityPlayerMP;
            if (stringArray.length == 2 || stringArray.length == 4) {
                entityPlayerMP = kmfh.func_82359_c(nemo2, stringArray[0]);
                if (entityPlayerMP == null) {
                    throw new mskk();
                }
            } else {
                entityPlayerMP = kmfh.func_71521_c(nemo2);
            }
            if (stringArray.length == 3 || stringArray.length == 4) {
                if (entityPlayerMP.field_70170_p != null) {
                    int n = stringArray.length - 3;
                    double d = kmfh.func_110666_a(nemo2, entityPlayerMP.field_70165_t, stringArray[n++]);
                    double d2 = kmfh.func_110665_a(nemo2, entityPlayerMP.field_70163_u, stringArray[n++], 0, 0);
                    double d3 = kmfh.func_110666_a(nemo2, entityPlayerMP.field_70161_v, stringArray[n++]);
                    entityPlayerMP.func_70078_a(null);
                    entityPlayerMP.func_70634_a(d, d2, d3);
                    kmfh.func_71522_a(nemo2, "commands.tp.success.coordinates", entityPlayerMP.func_70023_ak(), d, d2, d3);
                }
            } else if (stringArray.length == 1 || stringArray.length == 2) {
                EntityPlayerMP entityPlayerMP2 = kmfh.func_82359_c(nemo2, stringArray[stringArray.length - 1]);
                if (entityPlayerMP2 == null) {
                    throw new mskk();
                }
                if (entityPlayerMP2.field_70170_p != entityPlayerMP.field_70170_p) {
                    kmfh.func_71522_a(nemo2, "commands.tp.notSameDimension", new Object[0]);
                    return;
                }
                entityPlayerMP.func_70078_a(null);
                entityPlayerMP.field_71135_a.func_72569_a(entityPlayerMP2.field_70165_t, entityPlayerMP2.field_70163_u, entityPlayerMP2.field_70161_v, entityPlayerMP2.field_70177_z, entityPlayerMP2.field_70125_A);
                kmfh.func_71522_a(nemo2, "commands.tp.success", entityPlayerMP.func_70023_ak(), entityPlayerMP2.func_70023_ak());
            }
            return;
        }
        throw new pksd("commands.tp.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1 || stringArray.length == 2) {
            return kmfh.func_71530_a(stringArray, dzfd._I()._i());
        }
        return null;
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 0;
    }
}

