/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;

public class hcta
extends Thread {
    public final /* synthetic */ ThreadDownloadImageData _a;

    public hcta(ThreadDownloadImageData threadDownloadImageData) {
        this._a = threadDownloadImageData;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection)new URL(ThreadDownloadImageData._a(this._a)).openConnection(Minecraft._E()._Q());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                return;
            }
            BufferedImage bufferedImage = ImageIO.read(httpURLConnection.getInputStream());
            if (ThreadDownloadImageData._b(this._a) != null) {
                bufferedImage = ThreadDownloadImageData._b(this._a)._a(bufferedImage);
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

