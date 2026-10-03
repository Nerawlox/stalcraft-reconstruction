/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.Hook;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class owtc {
    @Hook(targetMethod="<init>", injectOnExit=true)
    public static void _a(tgdv tgdv2, int n) {
        tgdv2.func_77625_d(100);
    }

    @Hook(injectOnExit=true)
    public static void _a(cvzo cvzo2, qoac qoac2) {
        qoac2._p("Count");
        qoac2._a("Count_i", cvzo2._b);
    }

    @Hook(injectOnExit=true)
    public static void _b(cvzo cvzo2, qoac qoac2) {
        if (qoac2._c("Count_i")) {
            cvzo2._b = qoac2._f("Count_i");
        }
    }

    @Hook(injectOnExit=true)
    public static void _a(cezg cezg2, cvzo cvzo2, DataOutput dataOutput) throws IOException {
        if (cvzo2 != null) {
            dataOutput.writeInt(cvzo2._b);
        }
    }

    @Hook(injectOnExit=true)
    public static void _a(cezg cezg2, DataInput dataInput, @Hook.ReturnValue cvzo cvzo2) throws IOException {
        if (cvzo2 != null) {
            cvzo2._b = dataInput.readInt();
        }
    }
}

