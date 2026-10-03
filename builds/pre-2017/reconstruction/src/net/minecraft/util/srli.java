/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

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
import net.minecraft.logging.ILogAgent;
import net.minecraft.server.MinecraftServer;

public class srli {
    public static String _a(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('&');
            }
            try {
                stringBuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
            if (entry.getValue() == null) continue;
            stringBuilder.append('=');
            try {
                stringBuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static String _a(ILogAgent iLogAgent, URL uRL, Map map, boolean bl) {
        return srli._a(iLogAgent, uRL, srli._a(map), bl);
    }

    public static String _a(ILogAgent iLogAgent, URL uRL, String string, boolean bl) {
        try {
            String string2;
            Proxy proxy;
            Proxy proxy2 = proxy = MinecraftServer._I() == null ? null : MinecraftServer._I().__ap();
            if (proxy == null) {
                proxy = Proxy.NO_PROXY;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection(proxy);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", "" + string.getBytes().length);
            httpURLConnection.setRequestProperty("Content-Language", "en-US");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(string);
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while ((string2 = bufferedReader.readLine()) != null) {
                stringBuffer.append(string2);
                stringBuffer.append('\r');
            }
            bufferedReader.close();
            return stringBuffer.toString();
        }
        catch (Exception exception) {
            if (!bl) {
                if (iLogAgent != null) {
                    iLogAgent._b("Could not post to " + uRL, exception);
                } else {
                    Logger.getAnonymousLogger().log(Level.SEVERE, "Could not post to " + uRL, exception);
                }
            }
            return "";
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int _a() {
        ServerSocket serverSocket = null;
        int n = -1;
        try {
            serverSocket = new ServerSocket(0);
            n = serverSocket.getLocalPort();
        }
        finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            }
            catch (IOException iOException) {}
        }
        return n;
    }
}

