/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.eifc;

public class wots {
    public static final Pattern _a = Pattern.compile("^(?:(https?)://)?([-\\w_\\.]{2,}\\.[a-z]{2,4})(/\\S*)?$");
    public final FontRenderer _b;
    public final uzpa _c;
    public final int _d;
    public final int _e;
    public final String _f;
    public final String _g;

    public wots(FontRenderer fontRenderer, uzpa uzpa2, int n, int n2) {
        this._b = fontRenderer;
        this._c = uzpa2;
        this._d = n;
        this._e = n2;
        this._f = fontRenderer._a(uzpa2._a(), n);
        this._g = this._c();
    }

    public String _a() {
        return this._g;
    }

    public URI _b() {
        String string = this._a();
        if (string == null) {
            return null;
        }
        Matcher matcher = _a.matcher(string);
        if (matcher.matches()) {
            try {
                String string2 = matcher.group(0);
                if (matcher.group(1) == null) {
                    string2 = "http://" + string2;
                }
                return new URI(string2);
            }
            catch (URISyntaxException uRISyntaxException) {
                Minecraft._E()._O()._b("Couldn't create URI from chat", uRISyntaxException);
            }
        }
        return null;
    }

    public String _c() {
        int n;
        int n2 = this._f.lastIndexOf(" ", this._f.length()) + 1;
        if (n2 < 0) {
            n2 = 0;
        }
        if ((n = this._c._a().indexOf(" ", n2)) < 0) {
            n = this._c._a().length();
        }
        return eifc._a(this._c._a().substring(n2, n));
    }
}

