/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;

public class ejeo
extends temw {
    private oxdc _d;

    public ejeo(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    protected hbmu _a(ByteBuffer byteBuffer) {
        try {
            terj terj2 = new terj(byteBuffer);
            this._d = this._a._f ? new jhtb(terj2) : new oxdc(terj2);
            return new hbmu(this._d._r, this._d._s, 1, qmig._a, false);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Can not read texture header", iOException);
        }
    }

    @Override
    protected temw.kjui[] _a(ByteBuffer byteBuffer, int n, int n2) {
        try {
            int n3 = this._c()._a(0);
            ByteBuffer byteBuffer2 = BufferUtils.createByteBuffer(n3);
            this._d._a(byteBuffer2, ivqx._e);
            tvqg tvqg2 = new tvqg(byteBuffer2, 0, n3);
            temw.kjui kjui2 = new temw.kjui(this, 0, 0, tvqg2);
            temw.kjui[] kjuiArray = new temw.kjui[]{kjui2};
            return kjuiArray;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Can not read texture data", iOException);
        }
        finally {
            this._d = null;
        }
    }
}

