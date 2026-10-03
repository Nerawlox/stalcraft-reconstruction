/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.util.ResourceLocation;

public class uiog {
    public final Random _a = new Random();
    public final Map _b = Maps.newHashMap();
    public final xsfs _c;
    public final String _d;
    public final boolean _e;

    public uiog(xsfs xsfs2, String string, boolean bl) {
        this._c = xsfs2;
        this._d = string;
        this._e = bl;
    }

    public void _a(String string) {
        try {
            ArrayList<xavs> arrayList;
            String string2 = string;
            string = string.substring(0, string.indexOf("."));
            if (this._e) {
                while (Character.isDigit(string.charAt(string.length() - 1))) {
                    string = string.substring(0, string.length() - 1);
                }
            }
            if ((arrayList = (ArrayList<xavs>)this._b.get(string = string.replaceAll("/", "."))) == null) {
                arrayList = Lists.newArrayList();
                this._b.put(string, arrayList);
            }
            arrayList.add(new xavs(string2, this._b(string2)));
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
            throw new RuntimeException(malformedURLException);
        }
    }

    public URL _b(String string) {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        String string2 = String.format("%s:%s:%s/%s", "mcsounddomain", resourceLocation.func_110624_b(), this._d, resourceLocation.func_110623_a());
        bryy bryy2 = new bryy(this);
        return new URL(null, string2, bryy2);
    }

    public xavs _c(String string) {
        List list2 = (List)this._b.get(string);
        if (list2 == null) {
            return null;
        }
        return (xavs)list2.get(this._a.nextInt(list2.size()));
    }

    public xavs _a() {
        if (this._b.isEmpty()) {
            return null;
        }
        ArrayList arrayList = Lists.newArrayList(this._b.keySet());
        return this._c((String)arrayList.get(this._a.nextInt(arrayList.size())));
    }

    public static /* synthetic */ xsfs _a(uiog uiog2) {
        return uiog2._c;
    }
}

