/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  lp
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class li {
    public static String a(Map par0Map) {
        StringBuilder stringbuilder = new StringBuilder();
        for (Map.Entry entry : par0Map.entrySet()) {
            if (stringbuilder.length() > 0) {
                stringbuilder.append('&');
            }
            try {
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) {
                unsupportedencodingexception.printStackTrace();
            }
            if (entry.getValue() == null) continue;
            stringbuilder.append('=');
            try {
                stringbuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception1) {
                unsupportedencodingexception1.printStackTrace();
            }
        }
        return stringbuilder.toString();
    }

    public static String a(lp par0ILogAgent, URL par1URL, Map par2Map, boolean par3) {
        return li.a(par0ILogAgent, par1URL, li.a(par2Map), par3);
    }

    private static String a(lp par0ILogAgent, URL par1URL, String par2Str, boolean par3) {
        try {
            String s1;
            Proxy proxy;
            Proxy proxy2 = proxy = MinecraftServer.F() == null ? null : MinecraftServer.F().ap();
            if (proxy == null) {
                proxy = Proxy.NO_PROXY;
            }
            HttpURLConnection httpurlconnection = (HttpURLConnection)par1URL.openConnection(proxy);
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Length", "" + par2Str.getBytes().length);
            httpurlconnection.setRequestProperty("Content-Language", "en-US");
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
            dataoutputstream.writeBytes(par2Str);
            dataoutputstream.flush();
            dataoutputstream.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
            StringBuffer stringbuffer = new StringBuffer();
            while ((s1 = bufferedreader.readLine()) != null) {
                stringbuffer.append(s1);
                stringbuffer.append('\r');
            }
            bufferedreader.close();
            return stringbuffer.toString();
        }
        catch (Exception exception) {
            if (!par3) {
                if (par0ILogAgent != null) {
                    par0ILogAgent.c("Could not post to " + par1URL, (Throwable)exception);
                } else {
                    Logger.getAnonymousLogger().log(Level.SEVERE, "Could not post to " + par1URL, exception);
                }
            }
            return "";
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @SideOnly(value=Side.CLIENT)
    public static int a() throws IOException {
        int i2;
        ServerSocket serversocket = null;
        boolean flag = true;
        try {
            serversocket = new ServerSocket(0);
            i2 = serversocket.getLocalPort();
        }
        finally {
            try {
                if (serversocket != null) {
                    serversocket.close();
                }
            }
            catch (IOException iOException) {}
        }
        return i2;
    }
}

