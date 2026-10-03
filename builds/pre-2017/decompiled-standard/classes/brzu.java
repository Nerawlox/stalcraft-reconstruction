/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class brzu
extends gqjz {
    public final gqjz _a;
    public final rqmh _b;
    public final int _c = 0;
    public final int _d = 1;
    public int _e;
    public String _f;

    public brzu(gqjz gqjz2, rqmh rqmh2) {
        this._a = gqjz2;
        this._b = rqmh2;
    }

    @Override
    public void func_73876_c() {
    }

    @Override
    public void func_73866_w_() {
        this._a(this._b._a);
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel")));
    }

    public void _a(long l) {
        rqmi rqmi2 = new rqmi(this.field_73882_e._P());
        try {
            nedg nedg2 = rqmi2._g(l);
            this._e = nedg2._b;
            this._f = this._b(nedg2._a);
        }
        catch (twsl twsl2) {
            xpzm._E()._O()._c(twsl2.toString());
        }
        catch (IOException iOException) {
            xpzm._E()._O()._b("Realms: could not parse response");
        }
    }

    public String _b(long l) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
        gregorianCalendar.setTimeInMillis(l);
        return SimpleDateFormat.getDateTimeInstance().format(gregorianCalendar.getTime());
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 1) {
            // empty if block
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.configure.world.subscription.title"), this.field_73880_f / 2, 17, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.subscription.start"), this.field_73880_f / 2 - 100, 53, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, this._f, this.field_73880_f / 2 - 100, 66, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.subscription.daysleft"), this.field_73880_f / 2 - 100, 85, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, String.valueOf(this._e), this.field_73880_f / 2 - 100, 98, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

