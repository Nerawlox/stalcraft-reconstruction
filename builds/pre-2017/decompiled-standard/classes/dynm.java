/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gloomyfolken.mods.asm.MicInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class dynm
implements htyg {
    public final Map _a = Maps.newHashMap();
    public final ResourceLocation _b;
    public final InputStream _c;
    public final InputStream _d;
    public final rqxe _e;
    public boolean _f;
    public JsonObject _g;

    public dynm(ResourceLocation resourceLocation, InputStream inputStream, InputStream inputStream2, rqxe rqxe2) {
        this._b = resourceLocation;
        this._c = new MicInputStream(resourceLocation, inputStream);
        this._d = inputStream2;
        this._e = rqxe2;
    }

    @Override
    public InputStream _a() {
        return this._c;
    }

    @Override
    public boolean _b() {
        return this._d != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public gqyj _a(String string) {
        Object object;
        if (!this._b()) {
            return null;
        }
        if (this._g == null && !this._f) {
            this._f = true;
            object = null;
            try {
                object = new BufferedReader(new InputStreamReader(this._d));
                this._g = new JsonParser().parse((Reader)object).getAsJsonObject();
            }
            finally {
                IOUtils.closeQuietly((Reader)object);
            }
        }
        if ((object = (gqyj)this._a.get(string)) == null) {
            object = this._e._a(string, this._g);
        }
        return object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof dynm) {
            dynm dynm2 = (dynm)object;
            return this._b != null ? this._b.equals(dynm2._b) : dynm2._b == null;
        }
        return false;
    }

    public int hashCode() {
        if (this._b == null) {
            return 0;
        }
        return this._b.hashCode();
    }
}

