/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class scss
implements xbbs {
    public int[] _a;
    public int _b;
    public int _c;

    @Override
    public BufferedImage _a(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return null;
        }
        this._b = 64;
        this._c = 32;
        BufferedImage bufferedImage2 = bufferedImage;
        while (this._b < bufferedImage2.getWidth() || this._c < bufferedImage2.getHeight()) {
            this._b *= 2;
            this._c *= 2;
        }
        bufferedImage2 = new BufferedImage(this._b, this._c, 2);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.dispose();
        this._a = ((DataBufferInt)bufferedImage2.getRaster().getDataBuffer()).getData();
        int n = this._b;
        int n2 = this._c;
        this._b(0, 0, n / 2, n2 / 2);
        this._a(n / 2, 0, n, n2);
        this._b(0, n2 / 2, n, n2);
        return bufferedImage2;
    }

    public void _a(int n, int n2, int n3, int n4) {
        if (!this._c(n, n2, n3, n4)) {
            for (int i = n; i < n3; ++i) {
                for (int j = n2; j < n4; ++j) {
                    int n5 = i + j * this._b;
                    this._a[n5] = this._a[n5] & 0xFFFFFF;
                }
            }
        }
    }

    public void _b(int n, int n2, int n3, int n4) {
        for (int i = n; i < n3; ++i) {
            for (int j = n2; j < n4; ++j) {
                int n5 = i + j * this._b;
                this._a[n5] = this._a[n5] | 0xFF000000;
            }
        }
    }

    public boolean _c(int n, int n2, int n3, int n4) {
        for (int i = n; i < n3; ++i) {
            for (int j = n2; j < n4; ++j) {
                int n5 = this._a[i + j * this._b];
                if ((n5 >> 24 & 0xFF) >= 128) continue;
                return true;
            }
        }
        return false;
    }
}

