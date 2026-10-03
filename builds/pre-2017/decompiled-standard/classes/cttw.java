/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import java.lang.reflect.Method;
import net.minecraft.client.xpzm;

public class cttw {
    private boolean _a;
    private Method _b;

    public cttw() {
        try {
            Class<?> clazz = Class.forName("codechicken.nei.NEIClientConfig", false, this.getClass().getClassLoader());
            this._b = clazz.getDeclaredMethod("setInternalEnabled", Boolean.TYPE);
            this._a = true;
            Logger.finest("NEI found", new Object[0]);
        }
        catch (Exception exception) {
            Logger.finest("NEI not found", new Object[0]);
        }
    }

    public void _a() {
        if (this._a && xpzm._E()._t != null) {
            boolean bl = xpzm._E()._t.field_71075_bZ._d;
            try {
                this._b.invoke(null, bl);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

