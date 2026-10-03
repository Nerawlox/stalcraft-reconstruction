/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;

public class ThreadDownloadImage
extends Thread {
    private ThreadDownloadImageData parent;
    private String urlStr;
    private xbbs imageBuffer;

    public ThreadDownloadImage(ThreadDownloadImageData threadDownloadImageData, String string, xbbs xbbs2) {
        this.parent = threadDownloadImageData;
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
            httpURLConnection = (HttpURLConnection)uRL.openConnection(Minecraft._E()._Q());
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

