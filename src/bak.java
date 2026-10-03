/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  argo.jdom.JdomParser
 *  argo.jdom.JsonNode
 *  argo.saj.InvalidSyntaxException
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.apache.commons.lang3.builder.EqualsBuilder
 *  org.apache.commons.lang3.builder.HashCodeBuilder
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@SideOnly(value=Side.CLIENT)
public class bak {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public List f;
    public String g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m = "";
    public boolean n;
    public boolean o;
    public long p;
    private String q;
    private String r;

    public String a() {
        if (this.q == null) {
            try {
                this.q = URLDecoder.decode(this.c, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) {
                this.q = this.c;
            }
        }
        return this.q;
    }

    public String b() {
        if (this.r == null) {
            try {
                this.r = URLDecoder.decode(this.b, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) {
                this.r = this.b;
            }
        }
        return this.r;
    }

    public void a(String par1Str) {
        this.b = par1Str;
        this.r = null;
    }

    public void b(String par1Str) {
        this.c = par1Str;
        this.q = null;
    }

    public void a(bak par1McoServer) {
        this.m = par1McoServer.m;
        this.p = par1McoServer.p;
        this.n = par1McoServer.n;
        this.l = par1McoServer.l;
        this.o = true;
    }

    public static bak a(JsonNode par0JsonNode) {
        bak mcoserver = new bak();
        try {
            mcoserver.a = Long.parseLong(par0JsonNode.getNumberValue(new Object[]{"id"}));
            mcoserver.b = par0JsonNode.getStringValue(new Object[]{"name"});
            mcoserver.c = par0JsonNode.getStringValue(new Object[]{"motd"});
            mcoserver.d = par0JsonNode.getStringValue(new Object[]{"state"});
            mcoserver.e = par0JsonNode.getStringValue(new Object[]{"owner"});
            mcoserver.f = par0JsonNode.isArrayNode(new Object[]{"invited"}) ? bak.a(par0JsonNode.getArrayNode(new Object[]{"invited"})) : new ArrayList();
            mcoserver.k = Integer.parseInt(par0JsonNode.getNumberValue(new Object[]{"daysLeft"}));
            mcoserver.g = par0JsonNode.getStringValue(new Object[]{"ip"});
            mcoserver.h = par0JsonNode.getBooleanValue(new Object[]{"expired"});
            mcoserver.i = Integer.parseInt(par0JsonNode.getNumberValue(new Object[]{"difficulty"}));
            mcoserver.j = Integer.parseInt(par0JsonNode.getNumberValue(new Object[]{"gameMode"}));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return mcoserver;
    }

    private static List a(List par0List) {
        ArrayList<String> arraylist = new ArrayList<String>();
        for (JsonNode jsonnode : par0List) {
            arraylist.add(jsonnode.getStringValue(new Object[0]));
        }
        return arraylist;
    }

    public static bak c(String par0Str) {
        bak mcoserver = new bak();
        try {
            mcoserver = bak.a((JsonNode)new JdomParser().parse(par0Str));
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
        return mcoserver;
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(this.a).append((Object)this.b).append((Object)this.c).append((Object)this.d).append((Object)this.e).append(this.h).toHashCode();
    }

    public boolean equals(Object par1Obj) {
        if (par1Obj == null) {
            return false;
        }
        if (par1Obj == this) {
            return true;
        }
        if (par1Obj.getClass() != this.getClass()) {
            return false;
        }
        bak mcoserver = (bak)par1Obj;
        return new EqualsBuilder().append(this.a, mcoserver.a).append((Object)this.b, (Object)mcoserver.b).append((Object)this.c, (Object)mcoserver.c).append((Object)this.d, (Object)mcoserver.d).append((Object)this.e, (Object)mcoserver.e).append(this.h, mcoserver.h).isEquals();
    }
}

