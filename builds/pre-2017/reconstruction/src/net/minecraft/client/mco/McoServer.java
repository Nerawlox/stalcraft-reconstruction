/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.mco;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.saj.InvalidSyntaxException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class McoServer {
    public long _a;
    public String _b;
    public String _c;
    public String _d;
    public String _e;
    public List _f;
    public String _g;
    public boolean _h;
    public int _i;
    public int _j;
    public int _k;
    public int _l;
    public String _m = "";
    public boolean _n;
    public boolean _o;
    public long _p;
    public String _q;
    public String _r;

    public String _a() {
        if (this._q == null) {
            try {
                this._q = URLDecoder.decode(this._c, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this._q = this._c;
            }
        }
        return this._q;
    }

    public String _b() {
        if (this._r == null) {
            try {
                this._r = URLDecoder.decode(this._b, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this._r = this._b;
            }
        }
        return this._r;
    }

    public void _a(String string) {
        this._b = string;
        this._r = null;
    }

    public void _b(String string) {
        this._c = string;
        this._q = null;
    }

    public void _a(McoServer mcoServer) {
        this._m = mcoServer._m;
        this._p = mcoServer._p;
        this._n = mcoServer._n;
        this._l = mcoServer._l;
        this._o = true;
    }

    public static McoServer _a(JsonNode jsonNode) {
        McoServer mcoServer = new McoServer();
        try {
            mcoServer._a = Long.parseLong(jsonNode.getNumberValue("id"));
            mcoServer._b = jsonNode.getStringValue("name");
            mcoServer._c = jsonNode.getStringValue("motd");
            mcoServer._d = jsonNode.getStringValue("state");
            mcoServer._e = jsonNode.getStringValue("owner");
            mcoServer._f = jsonNode.isArrayNode("invited") ? McoServer._a(jsonNode.getArrayNode("invited")) : new ArrayList();
            mcoServer._k = Integer.parseInt(jsonNode.getNumberValue("daysLeft"));
            mcoServer._g = jsonNode.getStringValue("ip");
            mcoServer._h = jsonNode.getBooleanValue("expired");
            mcoServer._i = Integer.parseInt(jsonNode.getNumberValue("difficulty"));
            mcoServer._j = Integer.parseInt(jsonNode.getNumberValue("gameMode"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return mcoServer;
    }

    public static List _a(List list2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (JsonNode jsonNode : list2) {
            arrayList.add(jsonNode.getStringValue(new Object[0]));
        }
        return arrayList;
    }

    public static McoServer _c(String string) {
        McoServer mcoServer = new McoServer();
        try {
            mcoServer = McoServer._a(new JdomParser().parse(string));
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
        return mcoServer;
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(this._a).append(this._b).append(this._c).append(this._d).append(this._e).append(this._h).toHashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        McoServer mcoServer = (McoServer)object;
        return new EqualsBuilder().append(this._a, mcoServer._a).append(this._b, mcoServer._b).append(this._c, mcoServer._c).append(this._d, mcoServer._d).append(this._e, mcoServer._e).append(this._h, mcoServer._h).isEquals();
    }
}

