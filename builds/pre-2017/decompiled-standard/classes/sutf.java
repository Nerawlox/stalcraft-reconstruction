/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class sutf
implements Callable {
    public final /* synthetic */ ozlu _a;

    public sutf(ozlu ozlu2) {
        this._a = ozlu2;
    }

    public String _a() {
        return this._a.field_73010_i.size() + " total; " + this._a.field_73010_i.toString();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

