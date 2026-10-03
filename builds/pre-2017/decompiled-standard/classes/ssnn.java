/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import net.minecraft.util.ResourceLocation;

public class ssnn
extends temw {
    public ssnn(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    protected hbmu _a(ByteBuffer byteBuffer) {
        try {
            hbom hbom2 = new hbom(new terj(byteBuffer));
            uytr uytr2 = new uytr(hbom2);
            return new hbmu(uytr2._d, uytr2._c, uytr2._a(), uytr2._B, uytr2._e());
        }
        catch (IOException iOException) {
            throw new RuntimeException("Can not read texture header", iOException);
        }
    }

    @Override
    protected temw.kjui[] _a(ByteBuffer byteBuffer, int n, int n2) {
        temw.kjui[] kjuiArray = new temw.kjui[n2 * this._c()._b()];
        int n3 = 128;
        for (int i = 0; i < this._c()._b(); ++i) {
            for (int j = 0; j < n + n2; ++j) {
                int n4 = this._c()._a(j);
                if (j >= n) {
                    tvqg tvqg2 = new tvqg(byteBuffer, n3, n4);
                    int n5 = j - n;
                    kjuiArray[n5 * this._c()._b() + i] = new temw.kjui(this, j, i, tvqg2);
                }
                n3 += n4;
            }
        }
        return kjuiArray;
    }
}

