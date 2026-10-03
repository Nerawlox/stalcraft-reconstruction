/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class ssps {
    private ByteBuffer _a;
    private hbom _b;
    private float _c;

    public <T extends iess> void _a(jhuw<T> jhuw2) throws IOException {
        try {
            this._a(jhuw2.location, "MCSA", 6.0f);
            this._a(this._b, jhuw2);
        }
        catch (IOException iOException) {
            hspu._a(this._a);
            throw iOException;
        }
        finally {
            this._a = null;
        }
    }

    public void _a(iest iest2) throws IOException {
        try {
            this._a(iest2.location, "MCAL", 6.0f);
            this._a(this._b, iest2);
        }
        catch (IOException iOException) {
            throw iOException;
        }
        finally {
            hspu._a(this._a);
            this._a = null;
        }
    }

    private void _a(ResourceLocation resourceLocation, String string, float f) throws IOException {
        if (resourceLocation == null) {
            throw new IOException("Can't open resource: " + resourceLocation);
        }
        this._a = uyvo._a(resourceLocation);
        this._b = new hbom(new terj(this._a));
        byte[] byArray = new byte[string.length()];
        this._b.read(byArray);
        String string2 = new String(byArray, "UTF-8");
        this._c = this._b.readFloat();
        if (!string.equals(string2) || this._c < f) {
            throw new IOException("Invalid " + string + " file: " + resourceLocation);
        }
    }

    private <T extends iess> void _a(hbom hbom2, jhuw<T> jhuw2) throws IOException {
        Object object;
        int n;
        jhuw2.fileVersion = this._c;
        jhuw2.animated = hbom2.readBoolean();
        jhuw2.hasUvs = hbom2.readBoolean();
        jhuw2.hasNormals = hbom2.readBoolean();
        jhuw2.hasTangents = hbom2.readBoolean();
        float f = hbom2.readFloat();
        float f2 = jhuw2.hasUvs ? hbom2.readFloat() : 8.0f;
        jhuw2.quantization = uyvu._a(f, f2);
        int n2 = hbom2.readInt();
        for (n = 0; n < n2; ++n) {
            object = this._b(hbom2, jhuw2);
            jhuw2.addObject(object);
        }
        if (jhuw2.animated) {
            jhuw2.skeleton = this._a(hbom2);
            jhuw2.numBones = jhuw2.skeleton._a;
            n = hbom2.readInt();
            if (n > 0) {
                object = new gpnv();
                this._a(hbom2, n, jhuw2.numBones, jhuw2.quantization._a, (gpnv)object);
                jhuw2.inbuiltAnimationLibrary = object;
            }
        }
        jhuw2.onModelLoaded(this._a);
    }

    private void _a(hbom hbom2, iest iest2) throws IOException {
        int n = hbom2.readUnsignedByte();
        float f = hbom2.readFloat();
        int n2 = hbom2.readInt();
        this._a(hbom2, n2, n, f, iest2._a);
    }

    private void _a(hbom hbom2, int n, int n2, float f, gpnv gpnv2) throws IOException {
        for (int i = 0; i < n; ++i) {
            gpnv2._a(this._a(hbom2, n2, f));
        }
    }

    private wnxc _a(hbom hbom2, int n, float f) throws IOException {
        String string = hbom2.readUTF();
        float f2 = 1.0f;
        int n2 = string.lastIndexOf(37);
        if (n2 > -1) {
            String string2 = string.substring(n2 + 1, string.length());
            string = string.substring(0, n2);
            try {
                f2 = Float.parseFloat(string2);
            }
            catch (NumberFormatException numberFormatException) {
                gpmu._b("Can not parse animation weight in animation %s", string);
            }
        }
        int n3 = hbom2.readInt();
        float f3 = hbom2.readFloat();
        wnxc wnxc2 = new wnxc(string, n3, f3, f, f2);
        wnxc2._a(hbom2, n);
        return wnxc2;
    }

    private <T extends iess> T _b(hbom hbom2, jhuw<T> jhuw2) throws IOException {
        int n;
        String string = hbom2.readUTF();
        String string2 = hbom2.readUTF();
        int n2 = 0;
        int n3 = 0;
        short[] sArray = null;
        if (jhuw2.animated) {
            n2 = hbom2.readUnsignedByte();
            n3 = hbom2.readUnsignedByte();
            sArray = new short[n3];
            for (n = 0; n < n3; ++n) {
                sArray[n] = (short)hbom2.readUnsignedByte();
            }
        }
        n = hbom2.readInt();
        int n4 = hbom2.readInt();
        float f = -1.0f;
        if (jhuw2.hasUvs() && this._c >= 7.0f) {
            f = hbom2.readFloat();
        }
        T t = jhuw2.createMesh(string, string2, n2, sArray, n, n4, f);
        ((iess)t)._a(this._a, hbom2);
        return t;
    }

    private jywl _a(hbom hbom2) throws IOException {
        int n;
        int n2 = hbom2.readUnsignedByte();
        jywl.kjui[] kjuiArray = new jywl.kjui[n2];
        int[] nArray = new int[n2];
        int n3 = 0;
        ivtm ivtm2 = new ivtm(n2);
        for (int i = 0; i < n2; ++i) {
            jywl.kjui kjui2 = new jywl.kjui();
            kjui2._d = hbom2.readUTF();
            kjui2._c = i;
            n = hbom2.readUnsignedByte();
            if (n == i) {
                n = -1;
            }
            nArray[i] = n;
            if (n == -1) {
                ++n3;
            }
            kjui2._e = new Vector3f(hbom2.readFloat(), hbom2.readFloat(), hbom2.readFloat());
            kjui2._f = new Vector3f(hbom2.readFloat(), hbom2.readFloat(), hbom2.readFloat());
            kjuiArray[i] = kjui2;
            ivtm2._b[i] = new Quaternion();
            ivtm2._a[i] = kjui2._e;
        }
        jywl.kjui[] kjuiArray2 = new jywl.kjui[n3];
        int n4 = 0;
        for (n = 0; n < n2; ++n) {
            jywl.kjui kjui3 = kjuiArray[n];
            int n5 = nArray[n];
            if (n5 == -1) {
                kjuiArray2[n4++] = kjui3;
                continue;
            }
            kjuiArray[n5]._b.add(kjui3);
            kjui3._a = kjuiArray[n5];
        }
        jywl jywl2 = new jywl(kjuiArray, kjuiArray2);
        jywl2._e = ivtm2;
        return jywl2;
    }
}

