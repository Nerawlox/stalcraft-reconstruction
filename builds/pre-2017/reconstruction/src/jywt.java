/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class jywt {
    public static byte[] _a(rpms rpms2, float f) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            jywt._a(rpms2, new ogdi(byteArrayOutputStream), f);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void _a(rpms rpms2, ogdi ogdi2, float f) throws IOException {
        if (f != 6.0f && f != 7.0f) {
            throw new IllegalArgumentException("Invalid model format!");
        }
        jywt._a("MCSA", f, ogdi2);
        ogdi2.writeBoolean(rpms2.animated);
        ogdi2.writeBoolean(rpms2.hasUvs());
        ogdi2.writeBoolean(rpms2.hasNormals());
        ogdi2.writeBoolean(rpms2.hasTangents());
        ogdi2.writeFloat(rpms2.getQuantization()._a);
        if (rpms2.hasUvs()) {
            ogdi2.writeFloat(rpms2.getQuantization()._b);
        }
        ogdi2.writeInt(rpms2.getMeshes().size());
        for (Object object : rpms2.getMeshes()) {
            if (f == 6.0f) {
                jywt._b((zxep)object, ogdi2);
                continue;
            }
            jywt._a((zxep)object, ogdi2);
        }
        if (rpms2.animated) {
            Object object;
            jywt._a(rpms2.getSkeleton(), ogdi2);
            List<wnxc> list2 = rpms2.getAllAnimations();
            ogdi2.writeInt(list2.size());
            object = list2.iterator();
            while (object.hasNext()) {
                wnxc wnxc2 = (wnxc)object.next();
                jywt._a(wnxc2, ogdi2);
            }
        }
    }

    public static void _a(zxep zxep2, ogdi ogdi2) throws IOException {
        ogdi2.writeUTF(zxep2._l);
        ogdi2.writeUTF(zxep2._m);
        if (zxep2._a.animated) {
            ogdi2.writeByte(zxep2._s);
            ogdi2.writeByte(zxep2._o);
            for (short n : zxep2._t) {
                ogdi2.writeByte(n);
            }
        }
        ogdi2.writeInt(zxep2._n);
        ogdi2.writeInt(zxep2._p);
        if (zxep2._a.hasUvs()) {
            ogdi2.writeFloat(zxep2._a());
        }
        float f = zxep2._a.getQuantization()._a;
        float f2 = zxep2._a.getQuantization()._b;
        for (zxep.kjui kjui2 : zxep2._b) {
            ogdi2._a(kjui2._a.x, f);
            ogdi2._a(kjui2._a.y, f);
            ogdi2._a(kjui2._a.z, f);
            if (zxep2._a.hasTangents()) {
                ogdi2._a(kjui2._e.x, 1.0f);
                continue;
            }
            ogdi2.writeShort(0);
        }
        if (zxep2._a.hasUvs()) {
            for (zxep.kjui kjui2 : zxep2._b) {
                ogdi2._a(kjui2._b.x, f2);
                ogdi2._a(kjui2._b.y, f2);
            }
        }
        if (zxep2._a.hasNormals()) {
            for (zxep.kjui kjui2 : zxep2._b) {
                ogdi2._c(kjui2._c.x, 1.0f);
                ogdi2._c(kjui2._c.y, 1.0f);
                ogdi2._c(kjui2._c.z, 1.0f);
                if (zxep2._a.hasTangents()) {
                    ogdi2._c(kjui2._e.y, 1.0f);
                    continue;
                }
                ogdi2.writeByte(0);
            }
        }
        if (zxep2._a.hasTangents()) {
            for (zxep.kjui kjui2 : zxep2._b) {
                ogdi2._c(kjui2._d.x, 1.0f);
                ogdi2._c(kjui2._d.y, 1.0f);
                ogdi2._c(kjui2._d.z, 1.0f);
                ogdi2._c(kjui2._e.z, 1.0f);
            }
        }
        if (zxep2._r) {
            int n;
            if (zxep2._s <= 2) {
                for (zxep.kjui kjui2 : zxep2._b) {
                    for (n = 0; n < 2; ++n) {
                        if (n < zxep2._s) {
                            ogdi2.writeByte(kjui2._g[n]);
                            continue;
                        }
                        ogdi2.writeByte(0);
                    }
                    for (n = 0; n < 2; ++n) {
                        if (n < zxep2._s) {
                            ogdi2._d(kjui2._f[n], 1.0f);
                            continue;
                        }
                        ogdi2.writeByte(0);
                    }
                }
            } else {
                for (zxep.kjui kjui2 : zxep2._b) {
                    for (n = 0; n < 4; ++n) {
                        if (n < zxep2._s) {
                            ogdi2.writeByte(kjui2._g[n]);
                            continue;
                        }
                        ogdi2.writeByte(0);
                    }
                }
                for (zxep.kjui kjui2 : zxep2._b) {
                    for (n = 0; n < 4; ++n) {
                        if (n < zxep2._s) {
                            ogdi2._d(kjui2._f[n], 1.0f);
                            continue;
                        }
                        ogdi2.writeByte(0);
                    }
                }
            }
        }
        for (int i = 0; i < zxep2._q; ++i) {
            int n = zxep2._c[i];
            if (zxep2._p * 3 > 65535) {
                ogdi2.writeInt(n);
                continue;
            }
            ogdi2.writeShort(n);
        }
    }

    public static void _b(zxep zxep2, ogdi ogdi2) throws IOException {
        int n;
        ogdi2.writeUTF(zxep2._l);
        ogdi2.writeUTF(zxep2._m);
        if (zxep2._a.animated) {
            ogdi2.writeByte(zxep2._s);
            ogdi2.writeByte(zxep2._o);
            short[] sArray = zxep2._t;
            int n2 = sArray.length;
            for (n = 0; n < n2; ++n) {
                short s = sArray[n];
                ogdi2.writeByte(s);
            }
        }
        ogdi2.writeInt(zxep2._n);
        ogdi2.writeInt(zxep2._p);
        float f = zxep2._a.getQuantization()._a;
        float f2 = zxep2._a.getQuantization()._b;
        for (n = 0; n < zxep2._n; ++n) {
            int n3;
            zxep.kjui kjui2 = zxep2._b[n];
            ogdi2._a(kjui2._a.x, f);
            ogdi2._a(kjui2._a.y, f);
            ogdi2._a(kjui2._a.z, f);
            if (zxep2._a.hasUvs()) {
                ogdi2._a(kjui2._b.x, f2);
                ogdi2._a(kjui2._b.y, f2);
            }
            if (zxep2._a.hasNormals()) {
                ogdi2._c(kjui2._c.x, 1.0f);
                ogdi2._c(kjui2._c.y, 1.0f);
                ogdi2._c(kjui2._c.z, 1.0f);
            }
            if (zxep2._a.hasTangents()) {
                ogdi2._c(kjui2._d.x, 1.0f);
                ogdi2._c(kjui2._d.y, 1.0f);
                ogdi2._c(kjui2._d.z, 1.0f);
                ogdi2._c(kjui2._e.x, 1.0f);
                ogdi2._c(kjui2._e.y, 1.0f);
                ogdi2._c(kjui2._e.z, 1.0f);
            }
            if (!zxep2._r) continue;
            for (n3 = 0; n3 < zxep2._s; ++n3) {
                ogdi2.writeByte(kjui2._g[n3]);
            }
            for (n3 = 0; n3 < zxep2._s - 1; ++n3) {
                ogdi2._c(kjui2._f[n3], 1.0f);
            }
        }
        for (n = 0; n < zxep2._q; ++n) {
            int n4 = zxep2._c[n];
            if (zxep2._p * 3 > 65535) {
                ogdi2.writeInt(n4);
                continue;
            }
            ogdi2.writeShort(n4);
        }
    }

    public static void _a(wnxc wnxc2, ogdi ogdi2) throws IOException {
        String string = wnxc2._a;
        if (wnxc2._e != 1.0f) {
            string = string + (37.0f + wnxc2._e);
        }
        ogdi2.writeUTF(string);
        ogdi2.writeInt(wnxc2._b);
        ogdi2.writeFloat(wnxc2._d);
        for (int i = 0; i < wnxc2._b; ++i) {
            wnxc.kjui kjui2 = wnxc2._f[i];
            int n = kjui2._b.length / 4;
            for (int j = 0; j < n; ++j) {
                int n2;
                for (n2 = 0; n2 < 4; ++n2) {
                    ogdi2._a(kjui2._b[j * 4 + n2], 1.0f);
                }
                for (n2 = 0; n2 < 3; ++n2) {
                    ogdi2.writeShort(kjui2._a[j * 3 + n2]);
                }
            }
        }
    }

    public static void _a(jywl jywl2, ogdi ogdi2) throws IOException {
        ogdi2.writeByte(jywl2._a);
        for (int i = 0; i < jywl2._a; ++i) {
            jywl.kjui kjui2 = jywl2._a(i);
            ogdi2.writeUTF(kjui2._d);
            if (kjui2._a == null) {
                ogdi2.writeByte(i);
            } else {
                ogdi2.writeByte(kjui2._a._c);
            }
            ogdi2.writeFloat(kjui2._e.x);
            ogdi2.writeFloat(kjui2._e.y);
            ogdi2.writeFloat(kjui2._e.z);
            ogdi2.writeFloat(kjui2._f.x);
            ogdi2.writeFloat(kjui2._f.y);
            ogdi2.writeFloat(kjui2._f.z);
        }
    }

    private static void _a(String string, float f, ogdi ogdi2) throws IOException {
        ogdi2.writeBytes(string);
        ogdi2.writeFloat(f);
    }
}

