/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class wnbr {
    public static bsyv _a(double ... dArray) {
        bsyv bsyv2 = new bsyv();
        for (double d : dArray) {
            bsyv2._a(new qoae(null, d));
        }
        return bsyv2;
    }

    public static bsyv _a(float ... fArray) {
        bsyv bsyv2 = new bsyv();
        for (float f : fArray) {
            bsyv2._a(new jjly(null, f));
        }
        return bsyv2;
    }

    public static bsyv _a(Collection<String> collection) {
        bsyv bsyv2 = new bsyv();
        for (String string : collection) {
            bsyv2._a(new xsxy(null, string));
        }
        return bsyv2;
    }

    public static List<String> _a(bsyv bsyv2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            arrayList.add(((xsxy)bsyv2._b((int)i))._c);
        }
        return arrayList;
    }

    public static void _a(qoac qoac2, String string, UUID uUID) {
        if (uUID != null) {
            qoac2._a(string + "M", uUID.getMostSignificantBits());
            qoac2._a(string + "L", uUID.getLeastSignificantBits());
        }
    }

    public static UUID _a(qoac qoac2, String string) {
        if (qoac2._c(string + "M")) {
            return new UUID(qoac2._g(string + "M"), qoac2._g(string + "L"));
        }
        return null;
    }
}

