/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.xpzm;

public class mtbo
implements Callable {
    public final /* synthetic */ yfci _a;

    public mtbo(yfci yfci2) {
        this._a = yfci2;
    }

    public String _a() {
        String string = ClientBrandRetriever.getClientModName();
        if (!string.equals("vanilla")) {
            return "Definitely; Client brand changed to '" + string + "'";
        }
        string = this._a._H();
        if (!string.equals("vanilla")) {
            return "Definitely; Server brand changed to '" + string + "'";
        }
        if (xpzm.class.getSigners() == null) {
            return "Very likely; Jar signature invalidated";
        }
        return "Probably not. Jar signature remains and both client + server brands are untouched.";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

