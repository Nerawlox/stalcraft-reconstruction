/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.item.Item;

public class gqdg
extends uilx {
    public gqdg(int n) {
        super(n);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        if (n2 > 3) {
            n2 = 3;
        }
        if (random.nextInt(10 - n2 * 3) == 0) {
            return Item.flint.itemID;
        }
        return this.blockID;
    }
}

