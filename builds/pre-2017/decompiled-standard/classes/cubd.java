/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.util.Random;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.minecraft.util.ResourceLocation;

public class cubd
extends temw {
    private static final String _f = "1234567890WtFIsThIsStRiNgUsEdFoR!@#$%^&*()_+";
    private static final Random _g = new Random(1666330927L);
    public static final boolean _d = false;
    public static final String _e = cubd._f();
    private wnyq _h;

    public cubd(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    protected hbmu _a(ByteBuffer byteBuffer) {
        try {
            this._h = new wnyq(new terj(byteBuffer));
            return new hbmu(this._h._a(), this._h._b(), this._h._c(), this._h._d(), this._h._e());
        }
        catch (Exception exception) {
            throw new RuntimeException("Can not read texture header", exception);
        }
    }

    private static String _f() {
        StringBuilder stringBuilder = new StringBuilder(_f);
        for (int i = 0; i < 128; ++i) {
            stringBuilder.append((char)((i % 2 == 0 ? 65 : 97) + _g.nextInt(26)));
        }
        return stringBuilder.toString();
    }

    @Override
    protected temw.kjui[] _a(ByteBuffer byteBuffer, int n, int n2) {
        LZ4FastDecompressor lZ4FastDecompressor = LZ4Factory.fastestInstance().fastDecompressor();
        temw.kjui[] kjuiArray = new temw.kjui[n2 * this._c()._b()];
        int n3 = this._h._i();
        for (int i = 0; i < n + n2; ++i) {
            for (int j = 0; j < this._c()._b(); ++j) {
                int n4 = i * this._c()._b() + j;
                int n5 = this._h._h()[n4];
                int n6 = this._h._g()[n4];
                if (i >= n) {
                    ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(n6);
                    lZ4FastDecompressor.decompress(byteBuffer, n3, byteBuffer2, 0, n6);
                    tvqg tvqg2 = new tvqg(byteBuffer2, 0, n6);
                    int n7 = i - n;
                    kjuiArray[n7 * this._c()._b() + j] = new temw.kjui(this, i, j, tvqg2);
                }
                n3 += n5;
            }
        }
        this._h = null;
        return kjuiArray;
    }
}

