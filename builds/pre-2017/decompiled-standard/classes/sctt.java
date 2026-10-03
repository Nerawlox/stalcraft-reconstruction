/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;

public class sctt
extends zhix {
    public final int[] _a;
    public final int _b;
    public final int _c;

    public sctt(BufferedImage bufferedImage) {
        this(bufferedImage.getWidth(), bufferedImage.getHeight());
        bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this._a, 0, bufferedImage.getWidth());
        this._a();
    }

    public sctt(int n, int n2) {
        this._b = n;
        this._c = n2;
        this._a = new int[n * n2];
        bsfn._a(this.func_110552_b(), n, n2);
    }

    @Override
    public void func_110551_a(xsfs xsfs2) {
    }

    public void _a() {
        bsfn._a(this.func_110552_b(), this._a, this._b, this._c);
    }

    public int[] _b() {
        return this._a;
    }
}

