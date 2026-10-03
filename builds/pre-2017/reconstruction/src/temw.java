/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public abstract class temw
extends uytm
implements ejfb {
    protected ssnu _a;
    protected hbmw _b = new hbmw(this, null, 0);
    protected tvrb _c;
    private hbmu _d;
    private kjui[] _e;
    private ByteBuffer[] _f;
    private ByteBuffer _g;

    public temw(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    public void loadTexture(ResourceManager resourceManager) throws IOException {
        qmdg._a();
        this.load(false);
    }

    @Override
    protected void load() {
        if (this._b._a()) {
            this.ioTask(this::_f);
        } else {
            temw temw2 = this._b._d();
            this._d = temw2._d;
            this._a = temw2._a;
            this.glTaskDelayed(this::_h);
        }
    }

    private void _f() {
        this._a = this._k();
        try {
            this._g = uyvo._a(this.location);
            this._d = this._a(this._g);
            this._b._b();
            int n = Math.max(0, this._b._a(this._d));
            this._e = this._a(this._g, this._b._c(), n);
            if (this._e.length != n * this._d._b()) {
                this._e = null;
                throw new RuntimeException("Invalid number of read levels");
            }
            this.glTaskFast(this::_h);
        }
        catch (Exception exception) {
            this.mcTask(this::setBroken);
            this._a();
            gpmu._b("Can not load texture at " + this.location, new Object[0]);
            exception.printStackTrace();
        }
    }

    private void _h() {
        this._c = this._b._d() == null ? new tvrb(this._d, this._a, this._b._c()) : tvrb._a(this._b._d()._c, this._b._c());
        if (this._b._a()) {
            if (this.shouldUseAsyncIO()) {
                int n = this._b._a(this._d);
                this._f = new ByteBuffer[n * this._d._b()];
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < this._d._b(); ++j) {
                        this._f[i * this._d._b() + j] = this._c._a(i, j, false);
                    }
                }
                this.ioTask(this::_i);
            } else {
                this._c._a(this._e);
                this._a();
                this.mcFenceTask(this::setLoaded);
            }
        } else {
            this.mcFenceTask(this::setLoaded);
        }
    }

    private void _i() {
        for (int i = 0; i < this._b._a(this._d); ++i) {
            for (int j = 0; j < this._d._b(); ++j) {
                int n = i * this._d._b() + j;
                kjui kjui2 = this._e[n];
                ByteBuffer byteBuffer = this._f[n];
                byteBuffer.put(kjui2._c._a());
            }
        }
        this._a();
        this.glTaskFast(this::_j);
    }

    private void _j() {
        for (int i = 0; i < this._b._a(this._d); ++i) {
            for (int j = 0; j < this._d._b(); ++j) {
                this._c._a(i, j);
            }
        }
        this.mcFenceTask(this::setLoaded);
    }

    protected void _a() {
        if (this._e != null) {
            for (int i = 0; i < this._e.length; ++i) {
                kjui kjui2 = this._e[i];
                if (kjui2 == null || kjui2._c._a == this._g) continue;
                hspu._a(kjui2._c._a);
            }
        }
        if (this._g != null) {
            hspu._a(this._g);
            this._g = null;
        }
        this._f = null;
        this._e = null;
    }

    protected abstract hbmu _a(ByteBuffer var1);

    protected abstract kjui[] _a(ByteBuffer var1, int var2, int var3);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ssnu _k() {
        this._a = new ssnu();
        tvoe tvoe2 = null;
        InputStream inputStream = null;
        try {
            ResourceLocation resourceLocation = new ResourceLocation(this.location.getResourceDomain(), this.location.getResourcePath() + ".mcmeta");
            htyg htyg2 = fmib._c._a(resourceLocation);
            inputStream = htyg2._a();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            JsonObject jsonObject = new JsonParser().parse(bufferedReader).getAsJsonObject();
            tvoe2 = (tvoe)fmib._b._d._a("texture", jsonObject);
            IOUtils.closeQuietly(inputStream);
        }
        catch (Exception exception) {
            if (!(exception instanceof IOException)) {
                exception.printStackTrace();
            }
        }
        finally {
            IOUtils.closeQuietly(inputStream);
        }
        this._a._a(this.location, tvoe2);
        return this._a;
    }

    @Override
    public void release() {
        if (this._c != null) {
            this._c._b();
        }
    }

    @Override
    public int getGlTextureId() {
        if (this.getState() == oxca.kjui._c) {
            return this._c._g;
        }
        if (this.getState() == oxca.kjui._d) {
            return fmib._b(this._e());
        }
        return fmib._a(this._e());
    }

    public int _b() {
        return this._b._c();
    }

    public hbmu _c() {
        if (this._d == null) {
            throw new IllegalStateException("Texture is not initialized yet");
        }
        return this._d;
    }

    public qmig _d() {
        return this._c()._d;
    }

    @Override
    public int _e() {
        if (this._d == null) {
            return 3553;
        }
        return this._d._a();
    }

    @Override
    public String toString() {
        return this.location + "#" + this._b._c();
    }

    static {
        fmib._b._d._a(new ivob(), tvoe.class);
    }

    protected class kjui {
        public final int _a;
        public final int _b;
        public final tvqg _c;

        public kjui(int n, int n2, tvqg tvqg2) {
            this._a = n;
            this._b = n2;
            this._c = tvqg2;
        }
    }
}

