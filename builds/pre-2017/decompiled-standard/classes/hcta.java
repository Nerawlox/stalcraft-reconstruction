/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.client.xpzm;

public class hcta
extends Thread {
    public final /* synthetic */ rqrn _a;

    public hcta(rqrn rqrn2) {
        this._a = rqrn2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection)new URL(rqrn._a(this._a)).openConnection(xpzm._E()._Q());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                return;
            }
            BufferedImage bufferedImage = ImageIO.read(httpURLConnection.getInputStream());
            if (rqrn._b(this._a) != null) {
                bufferedImage = rqrn._b(this._a)._a(bufferedImage);
            }
            this._a._a(bufferedImage);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}

