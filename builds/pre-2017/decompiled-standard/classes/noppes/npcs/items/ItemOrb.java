/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import java.awt.Color;
import java.util.List;
import net.minecraft.entity.passive.EntitySheep;
import noppes.npcs.items.ItemNpcInterface;

public class ItemOrb
extends ItemNpcInterface {
    public ItemOrb(int n) {
        super(n);
        this.func_77627_a(true);
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        float[] fArray = EntitySheep.field_70898_d[cvzo2._j()];
        return new Color(fArray[0], fArray[1], fArray[2]).getRGB();
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    @Override
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        for (int i = 0; i < 16; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }
}

