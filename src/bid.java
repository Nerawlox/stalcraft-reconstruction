/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bic
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

@SideOnly(value=Side.CLIENT)
class bid
extends Thread {
    final bic a;

    bid(bic par1ThreadDownloadImageData) {
        this.a = par1ThreadDownloadImageData;
    }

    @Override
    public void run() {
        HttpURLConnection httpurlconnection = null;
        try {
            httpurlconnection = (HttpURLConnection)new URL(bic.a((bic)this.a)).openConnection(atv.w().I());
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(false);
            httpurlconnection.connect();
            if (httpurlconnection.getResponseCode() / 100 == 2) {
                BufferedImage bufferedimage = ImageIO.read(httpurlconnection.getInputStream());
                if (bic.b((bic)this.a) != null) {
                    bufferedimage = bic.b((bic)this.a).a(bufferedimage);
                }
                this.a.a(bufferedimage);
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        finally {
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
    }
}

