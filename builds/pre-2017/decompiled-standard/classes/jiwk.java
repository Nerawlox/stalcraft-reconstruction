/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class jiwk
implements Callable {
    public final /* synthetic */ pkix _a;

    public jiwk(pkix pkix2) {
        this._a = pkix2;
    }

    public String _a() {
        return pkix._c(this._a)._J() == null ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

