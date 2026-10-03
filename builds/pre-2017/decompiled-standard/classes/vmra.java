/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.turb;

public abstract class vmra {
    public final dzfd _a;
    public final List _b = Collections.synchronizedList(new ArrayList());
    public volatile boolean _c;

    public vmra(dzfd dzfd2) throws IOException {
        this._a = dzfd2;
        this._c = true;
    }

    public void _a(xbvu xbvu2) {
        this._b.add(xbvu2);
    }

    public void _a() {
        this._c = false;
    }

    public void _b() {
        for (int i = 0; i < this._b.size(); ++i) {
            xbvu xbvu2 = (xbvu)this._b.get(i);
            try {
                xbvu2.func_72570_d();
            }
            catch (Exception exception) {
                if (xbvu2.field_72575_b instanceof tgls) {
                    CrashReport crashReport = CrashReport.func_85055_a(exception, "Ticking memory connection");
                    jxsn jxsn2 = crashReport.func_85058_a("Ticking connection");
                    jxsn2._a("Connection", new rrgz(this, xbvu2));
                    throw new turb(crashReport);
                }
                FMLLog.log(Level.SEVERE, exception, "A critical server error occured handling a packet, kicking %s", xbvu2.getPlayer().field_70157_k);
                this._a._O()._a("Failed to handle packet for " + xbvu2.field_72574_e.func_70023_ak() + "/" + xbvu2.field_72574_e.func_71114_r() + ": " + exception, exception);
                xbvu2.func_72565_c("Internal server error");
            }
            if (xbvu2.field_72576_c) {
                this._b.remove(i--);
            }
            xbvu2.field_72575_b._a();
        }
    }

    public dzfd _c() {
        return this._a;
    }
}

