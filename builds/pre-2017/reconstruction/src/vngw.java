/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;

public class vngw
extends yfoy {
    public vngw() {
    }

    @Override
    public void _a(Random random, int n, int n2, int n3, boolean bl) {
        if (bl) {
            this._a = Block.stoneBrick.blockID;
            float f = random.nextFloat();
            if (f < 0.2f) {
                this._b = 2;
            } else if (f < 0.5f) {
                this._b = 1;
            } else if (f < 0.55f) {
                this._a = Block.silverfish.blockID;
                this._b = 2;
            } else {
                this._b = 0;
            }
        } else {
            this._a = 0;
            this._b = 0;
        }
    }

    public /* synthetic */ vngw(lqkn lqkn2) {
        this();
    }
}

