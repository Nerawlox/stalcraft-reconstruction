/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baa
 *  bac
 *  bad
 *  bae
 *  baf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SideOnly(value=Side.CLIENT)
public abstract class bab {
    protected HttpURLConnection a;
    private boolean c;
    protected String b;

    public bab(String par1Str, int par2, int par3) {
        try {
            this.b = par1Str;
            this.a = (HttpURLConnection)new URL(par1Str).openConnection(atv.w().I());
            this.a.setConnectTimeout(par2);
            this.a.setReadTimeout(par3);
        }
        catch (Exception exception) {
            throw new baa("Failed URL: " + par1Str, exception);
        }
    }

    public void a(String par1Str, String par2Str) {
        String s2 = this.a.getRequestProperty("Cookie");
        if (s2 == null) {
            this.a.setRequestProperty("Cookie", par1Str + "=" + par2Str);
        } else {
            this.a.setRequestProperty("Cookie", s2 + ";" + par1Str + "=" + par2Str);
        }
    }

    public int a() {
        try {
            this.e();
            return this.a.getResponseCode();
        }
        catch (Exception exception) {
            throw new baa("Failed URL: " + this.b, exception);
        }
    }

    public int b() {
        String s2 = this.a.getHeaderField("Retry-After");
        try {
            return Integer.valueOf(s2);
        }
        catch (Exception exception) {
            return 5;
        }
    }

    public String d() {
        try {
            this.e();
            String s2 = this.a() >= 400 ? this.a(this.a.getErrorStream()) : this.a(this.a.getInputStream());
            this.h();
            return s2;
        }
        catch (IOException ioexception) {
            throw new baa("Failed URL: " + this.b, (Exception)ioexception);
        }
    }

    private String a(InputStream par1InputStream) throws IOException {
        if (par1InputStream == null) {
            throw new IOException("No response (null)");
        }
        StringBuilder stringbuilder = new StringBuilder();
        int i2 = par1InputStream.read();
        while (i2 != -1) {
            stringbuilder.append((char)i2);
            i2 = par1InputStream.read();
        }
        return stringbuilder.toString();
    }

    private void h() {
        byte[] abyte = new byte[1024];
        try {
            boolean flag = false;
            InputStream inputstream = this.a.getInputStream();
            while (inputstream.read(abyte) > 0) {
            }
            inputstream.close();
        }
        catch (Exception exception) {
            try {
                InputStream inputstream = this.a.getErrorStream();
                boolean flag1 = false;
                while (inputstream.read(abyte) > 0) {
                }
                inputstream.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    protected bab e() {
        if (!this.c) {
            bab request = this.f();
            this.c = true;
            return request;
        }
        return this;
    }

    protected abstract bab f();

    public static bab a(String par0Str) {
        return new bad(par0Str, 5000, 10000);
    }

    public static bab c(String par0Str, String par1Str) {
        return new bae(par0Str, par1Str.getBytes(), 5000, 10000);
    }

    public static bab a(String par0Str, String par1Str, int par2, int par3) {
        return new bae(par0Str, par1Str.getBytes(), par2, par3);
    }

    public static bab b(String par0Str) {
        return new bac(par0Str, 5000, 10000);
    }

    public static bab d(String par0Str, String par1Str) {
        return new baf(par0Str, par1Str.getBytes(), 5000, 10000);
    }

    public static bab b(String par0Str, String par1Str, int par2, int par3) {
        return new baf(par0Str, par1Str.getBytes(), par2, par3);
    }

    public int g() {
        String s2 = this.a.getHeaderField("Error-Code");
        try {
            return Integer.valueOf(s2);
        }
        catch (Exception exception) {
            return -1;
        }
    }
}

