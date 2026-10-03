/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aus
 *  baa
 *  bap
 *  baq
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@SideOnly(value=Side.CLIENT)
public class azz {
    private final String a;
    private final String b;
    private static String c = "https://mcoapi.minecraft.net/";

    public azz(aus par1Session) {
        this.a = par1Session.b();
        this.b = par1Session.a();
    }

    public bam a() throws bap, IOException {
        String s2 = this.a(bab.a(c + "worlds"));
        return bam.a(s2);
    }

    public bak a(long par1) throws bap, IOException {
        String s2 = this.a(bab.a(c + "worlds" + "/$ID".replace("$ID", String.valueOf(par1))));
        return bak.c(s2);
    }

    public bal b(long par1) throws bap, IOException {
        String s2 = c + "worlds" + "/$ID/join".replace("$ID", "" + par1);
        String s1 = this.a(bab.a(s2));
        return bal.a(s1);
    }

    public void a(String par1Str, String par2Str, String par3Str, String par4Str) throws bap, UnsupportedEncodingException {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(c).append("worlds").append("/$NAME/$LOCATION_ID".replace("$NAME", this.c(par1Str)));
        HashMap<String, String> hashmap = new HashMap<String, String>();
        if (par2Str != null && !par2Str.trim().equals("")) {
            hashmap.put("motd", par2Str);
        }
        if (par3Str != null && !par3Str.equals("")) {
            hashmap.put("seed", par3Str);
        }
        hashmap.put("template", par4Str);
        if (!hashmap.isEmpty()) {
            boolean flag = true;
            for (Map.Entry entry : hashmap.entrySet()) {
                if (flag) {
                    stringbuilder.append("?");
                    flag = false;
                } else {
                    stringbuilder.append("&");
                }
                stringbuilder.append((String)entry.getKey()).append("=").append(this.c((String)entry.getValue()));
            }
        }
        this.a(bab.a(stringbuilder.toString(), "", 5000, 30000));
    }

    public Boolean b() throws bap, IOException {
        String s2 = c + "mco/available";
        String s1 = this.a(bab.a(s2));
        return Boolean.valueOf(s1);
    }

    public Boolean c() throws bap, IOException {
        String s2 = c + "mco/client/outdated";
        String s1 = this.a(bab.a(s2));
        return Boolean.valueOf(s1);
    }

    public int d() throws bap {
        String s2 = c + "payments/unused";
        String s1 = this.a(bab.a(s2));
        return Integer.valueOf(s1);
    }

    public void a(long par1, String par3Str) throws bap {
        String s1 = c + "invites" + "/$WORLD_ID/invite/$USER_NAME".replace("$WORLD_ID", String.valueOf(par1)).replace("$USER_NAME", par3Str);
        this.a(bab.b(s1));
    }

    public void c(long par1) throws bap {
        String s2 = c + "invites" + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(par1));
        this.a(bab.b(s2));
    }

    public bak b(long par1, String par3Str) throws bap, IOException {
        String s1 = c + "invites" + "/$WORLD_ID/invite/$USER_NAME".replace("$WORLD_ID", String.valueOf(par1)).replace("$USER_NAME", par3Str);
        String s2 = this.a(bab.c(s1, ""));
        return bak.c(s2);
    }

    public bah d(long par1) throws bap {
        String s2 = c + "worlds" + "/$WORLD_ID/backups".replace("$WORLD_ID", String.valueOf(par1));
        String s1 = this.a(bab.a(s2));
        return bah.a(s1);
    }

    public void a(long par1, String par3Str, String par4Str, int par5, int par6) throws bap, UnsupportedEncodingException {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(c).append("worlds").append("/$WORLD_ID/$NAME".replace("$WORLD_ID", String.valueOf(par1)).replace("$NAME", this.c(par3Str)));
        if (par4Str != null && !par4Str.trim().equals("")) {
            stringbuilder.append("?motd=").append(this.c(par4Str));
        } else {
            stringbuilder.append("?motd=");
        }
        stringbuilder.append("&difficulty=").append(par5).append("&gameMode=").append(par6);
        this.a(bab.d(stringbuilder.toString(), ""));
    }

    public void c(long par1, String par3Str) throws bap {
        String s1 = c + "worlds" + "/$WORLD_ID/backups".replace("$WORLD_ID", String.valueOf(par1)) + "?backupId=" + par3Str;
        this.a(bab.d(s1, ""));
    }

    public bau e() throws bap {
        String s2 = c + "worlds/templates";
        String s1 = this.a(bab.a(s2));
        return bau.a(s1);
    }

    public Boolean e(long par1) throws bap, IOException {
        String s2 = c + "worlds" + "/$WORLD_ID/open".replace("$WORLD_ID", String.valueOf(par1));
        String s1 = this.a(bab.d(s2, ""));
        return Boolean.valueOf(s1);
    }

    public Boolean f(long par1) throws bap, IOException {
        String s2 = c + "worlds" + "/$WORLD_ID/close".replace("$WORLD_ID", String.valueOf(par1));
        String s1 = this.a(bab.d(s2, ""));
        return Boolean.valueOf(s1);
    }

    public Boolean d(long par1, String par3Str) throws bap, UnsupportedEncodingException {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(c).append("worlds").append("/$WORLD_ID/reset".replace("$WORLD_ID", String.valueOf(par1)));
        if (par3Str != null && par3Str.length() > 0) {
            stringbuilder.append("?seed=").append(this.c(par3Str));
        }
        String s1 = this.a(bab.b(stringbuilder.toString(), "", 30000, 80000));
        return Boolean.valueOf(s1);
    }

    public Boolean e(long par1, String par3Str) throws bap {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(c).append("worlds").append("/$WORLD_ID/reset".replace("$WORLD_ID", String.valueOf(par1)));
        if (par3Str != null) {
            stringbuilder.append("?template=").append(par3Str);
        }
        String s1 = this.a(bab.b(stringbuilder.toString(), "", 30000, 80000));
        return Boolean.valueOf(s1);
    }

    public bar g(long par1) throws bap, IOException {
        String s2 = this.a(bab.a(c + "subscriptions" + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(par1))));
        return bar.a(s2);
    }

    public int f() throws bap {
        String s2 = this.a(bab.a(c + "invites/count/pending"));
        return Integer.parseInt(s2);
    }

    public bao g() throws bap {
        String s2 = this.a(bab.a(c + "invites/pending"));
        return bao.a(s2);
    }

    public void a(String par1Str) throws bap {
        this.a(bab.d(c + "invites" + "/accept/$INVITATION_ID".replace("$INVITATION_ID", par1Str), ""));
    }

    public void b(String par1Str) throws bap {
        this.a(bab.d(c + "invites" + "/reject/$INVITATION_ID".replace("$INVITATION_ID", par1Str), ""));
    }

    private String c(String par1Str) throws UnsupportedEncodingException {
        return URLEncoder.encode(par1Str, "UTF-8");
    }

    private String a(bab par1Request) throws bap {
        par1Request.a("sid", this.a);
        par1Request.a("user", this.b);
        par1Request.a("version", "1.6.4");
        try {
            int i = par1Request.a();
            if (i == 503) {
                int j2 = par1Request.b();
                throw new baq(j2);
            }
            if (i >= 200 && i < 300) {
                return par1Request.d();
            }
            throw new bap(par1Request.a(), par1Request.d(), par1Request.g());
        }
        catch (baa exceptionmcohttp) {
            throw new bap(500, "Server not available!", -1);
        }
    }
}

