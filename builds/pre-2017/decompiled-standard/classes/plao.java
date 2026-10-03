/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import net.minecraft.util.qlgf;

public class plao
extends Thread {
    public final /* synthetic */ yezc _a;

    public plao(yezc yezc2) {
        this._a = yezc2;
    }

    @Override
    public void run() {
        try {
            String string = new BigInteger(qlgf._a(yezc._a(this._a), yezc._b(this._a)._K().getPublic(), yezc._c(this._a))).toString(16);
            URL uRL = new URL("http://148.251.184.11:8080/checkserver.php?user=" + URLEncoder.encode(yezc._d(this._a), "UTF-8") + "&serverId=" + URLEncoder.encode(string, "UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openConnection(yezc._b(this._a).__ap()).getInputStream()));
            String string2 = bufferedReader.readLine();
            bufferedReader.close();
            if (!"YES".equals(string2)) {
                this._a._a("Failed to verify username!");
                return;
            }
            yezc._a(this._a, true);
        }
        catch (Exception exception) {
            this._a._a("Failed to verify username! [internal error " + exception + "]");
            exception.printStackTrace();
        }
    }
}

