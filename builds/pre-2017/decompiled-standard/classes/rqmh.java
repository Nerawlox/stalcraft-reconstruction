/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.saj.InvalidSyntaxException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class rqmh {
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

    public void _a(rqmh rqmh2) {
        this._m = rqmh2._m;
        this._p = rqmh2._p;
        this._n = rqmh2._n;
        this._l = rqmh2._l;
        this._o = true;
    }

    public static rqmh _a(JsonNode jsonNode) {
        rqmh rqmh2 = new rqmh();
        try {
            rqmh2._a = Long.parseLong(jsonNode.getNumberValue("id"));
            rqmh2._b = jsonNode.getStringValue("name");
            rqmh2._c = jsonNode.getStringValue("motd");
            rqmh2._d = jsonNode.getStringValue("state");
            rqmh2._e = jsonNode.getStringValue("owner");
            rqmh2._f = jsonNode.isArrayNode("invited") ? rqmh._a(jsonNode.getArrayNode("invited")) : new ArrayList();
            rqmh2._k = Integer.parseInt(jsonNode.getNumberValue("daysLeft"));
            rqmh2._g = jsonNode.getStringValue("ip");
            rqmh2._h = jsonNode.getBooleanValue("expired");
            rqmh2._i = Integer.parseInt(jsonNode.getNumberValue("difficulty"));
            rqmh2._j = Integer.parseInt(jsonNode.getNumberValue("gameMode"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return rqmh2;
    }

    public static List _a(List list2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (JsonNode jsonNode : list2) {
            arrayList.add(jsonNode.getStringValue(new Object[0]));
        }
        return arrayList;
    }

    public static rqmh _c(String string) {
        rqmh rqmh2 = new rqmh();
        try {
            rqmh2 = rqmh._a(new JdomParser().parse(string));
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
        return rqmh2;
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
        rqmh rqmh2 = (rqmh)object;
        return new EqualsBuilder().append(this._a, rqmh2._a).append(this._b, rqmh2._b).append(this._c, rqmh2._c).append(this._d, rqmh2._d).append(this._e, rqmh2._e).append(this._h, rqmh2._h).isEquals();
    }
}

