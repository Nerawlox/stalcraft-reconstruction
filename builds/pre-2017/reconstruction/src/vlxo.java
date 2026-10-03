/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.mco.ExceptionMcoService;

public class vlxo
extends Thread {
    public final /* synthetic */ nvce _a;

    public vlxo(nvce nvce2) {
        this._a = nvce2;
    }

    @Override
    public void run() {
        rqmi rqmi2 = new rqmi(nvce._a(this._a)._P());
        try {
            nvce._a(this._a, rqmi2._g()._a);
        }
        catch (ExceptionMcoService exceptionMcoService) {
            nvce._b(this._a)._O()._c(exceptionMcoService.toString());
        }
    }
}

