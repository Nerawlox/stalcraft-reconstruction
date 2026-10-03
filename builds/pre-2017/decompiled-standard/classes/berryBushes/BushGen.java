/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

public class BushGen
implements IWorldGenerator {
    @Override
    public void generate(Random random, int n, int n2, ozlu ozlu2, mccn mccn2, mccn mccn3) {
        this.generateOverWorld(ozlu2, random, n * 16, n2 * 16);
    }

    private void generateOverWorld(ozlu ozlu2, Random random, int n, int n2) {
        int n3;
        int n4 = random.nextInt(10);
        switch (n4) {
            case 0: {
                n3 = Base.bushII.field_71990_ca;
                break;
            }
            case 1: {
                n3 = Base.bushII.field_71990_ca;
                break;
            }
            case 2: {
                n3 = Base.bushII.field_71990_ca;
                break;
            }
            case 3: {
                n3 = Base.bushIII.field_71990_ca;
                break;
            }
            case 4: {
                n3 = Base.bushIII.field_71990_ca;
                break;
            }
            case 5: {
                n3 = Base.bushIV.field_71990_ca;
                break;
            }
            default: {
                n3 = Base.bushI.field_71990_ca;
            }
        }
        for (int i = 0; i < 100; ++i) {
            int n5;
            int n6;
            int n7 = n + random.nextInt(16);
            if (ozlu2.func_72799_c(n7, n6 = random.nextInt(128), n5 = n2 + random.nextInt(16)) || ozlu2.func_72798_a(n7, n6, n5) == twgu.field_71943_B.field_71990_ca || ozlu2.func_72798_a(n7, n6, n5) != twgu.field_71979_v.field_71990_ca && ozlu2.func_72798_a(n7, n6, n5) != twgu.field_71980_u.field_71990_ca || ozlu2.func_72798_a(n7, n6 + 1, n5) != twgu.field_72037_aS.field_71990_ca && !ozlu2.func_72799_c(n7, n6 + 1, n5)) continue;
            ozlu2.func_94575_c(n7, n6 + 1, n5, n3);
        }
    }
}

