/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.client.xpzm;

public class ThreadDownloadImage
extends Thread {
    private rqrn parent;
    private String urlStr;
    private xbbs imageBuffer;

    public ThreadDownloadImage(rqrn rqrn2, String string, xbbs xbbs2) {
        this.parent = rqrn2;
        this.urlStr = string;
        this.imageBuffer = xbbs2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            URL uRL = new URL(this.urlStr);
            httpURLConnection = (HttpURLConnection)uRL.openConnection(xpzm._E()._Q());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                return;
            }
            BufferedImage bufferedImage = ImageIO.read(httpURLConnection.getInputStream());
            if (this.imageBuffer != null) {
                bufferedImage = this.imageBuffer._a(bufferedImage);
            }
            this.parent._a(bufferedImage);
            return;
        }
        catch (Exception exception) {
            System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}

