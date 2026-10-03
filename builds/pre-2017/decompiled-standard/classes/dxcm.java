/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\t\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"vertShaderSrc", "", "generateBlurShader", "kernelSize", "", "generateSeparableGaussKernel", "", "", "sigma", "(DI)[Ljava/lang/Double;", "getAppropriateSeparableGauss", "", "", "minecraft"})
public final class dxcm {
    private static final String _a = "\n        #version 120\n        varying vec2 textureCoord;\n        void main(){\n            gl_Position = gl_ProjectionMatrix * gl_ModelViewMatrix * gl_Vertex;\n            gl_FrontColor = gl_Color;\n\t        textureCoord = gl_MultiTexCoord0.st;\n        }";

    private static final Double[] _a(double d, int n) {
        if (n % 2 != 1) {
            throw (Throwable)new IllegalArgumentException("kernel size must be odd number");
        }
        int n2 = n / 2;
        Double[] doubleArray = new Double[n];
        int n3 = 0;
        int n4 = n - 1;
        if (n3 <= n4) {
            do {
                Double d2;
                int n5 = ++n3;
                int n6 = n3;
                Double[] doubleArray2 = doubleArray;
                doubleArray2[n6] = d2 = Double.valueOf(0.0);
            } while (n3 != n4);
        }
        Double[] doubleArray3 = doubleArray;
        double d3 = Math.PI;
        n4 = n2;
        double d4 = 0.0;
        int n7 = 0;
        int n8 = n - 1;
        if (n7 <= n8) {
            while (true) {
                doubleArray3[n7] = Math.sqrt(Math.exp(-0.5 * (Math.pow((double)(n7 - n4) / d, 2.0) + Math.pow((double)n4 / d, 2.0))) / ((double)2 * d3 * d * d));
                d4 += doubleArray3[n7].doubleValue();
                if (n7 == n8) break;
                ++n7;
            }
        }
        if ((n7 = 0) <= (n8 = n - 1)) {
            do {
                int n9 = ++n7;
                doubleArray3[n9] = doubleArray3[n9] / d4;
            } while (n7 != n8);
        }
        return doubleArray3;
    }

    private static final List<Float> _b(int n) {
        if (n % 2 != 1) {
            throw (Throwable)new IllegalArgumentException("kernel size must be odd number");
        }
        float f = 0.02f / (float)n;
        double d = 1.0;
        double d2 = 1.0;
        while (true) {
            Double[] doubleArray;
            if ((doubleArray = dxcm._a(d2, n))[0] > (double)f) {
                Iterable iterable;
                if (d > 0.02) {
                    d2 -= d;
                    d2 += (d *= 0.1);
                    continue;
                }
                int n2 = 0;
                Iterable iterable2 = iterable = (Iterable)new IntRange(n2, n - 1);
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator iterator2 = iterable2.iterator();
                while (iterator2.hasNext()) {
                    int n3;
                    int n4 = n3 = ((IntIterator)iterator2).nextInt();
                    Collection collection2 = collection;
                    Float f2 = Float.valueOf((float)doubleArray[n4].doubleValue());
                    collection2.add(f2);
                }
                List list = (List)collection;
                return list;
            }
            if (!((d2 += d) > 1000.0)) continue;
            boolean bl = false;
            if (_Assertions.ENABLED) break;
        }
        String string = "Assertion failed";
        throw (Throwable)((Object)new AssertionError((Object)string));
    }

    private static final String _c(int n) {
        List<Float> list = dxcm._b(n);
        ArrayList<Float> arrayList = new ArrayList<Float>();
        int n2 = n / 2;
        boolean bl = false;
        if (n2 >= 0) {
            while (true) {
                if (n2 == n / 2) {
                    arrayList.add(Float.valueOf(((Number)list.get(n2)).floatValue() * 0.5f));
                } else {
                    arrayList.add(list.get(n2));
                }
                if (n2 == 0) break;
                --n2;
            }
        }
        n2 = arrayList.size() / 2;
        ArrayList<Float> arrayList2 = new ArrayList<Float>();
        ArrayList<Float> arrayList3 = new ArrayList<Float>();
        int n3 = 0;
        int n4 = n2 - 1;
        if (n3 <= n4) {
            while (true) {
                float f = ((Number)arrayList.get(n3 * 2 + 0)).floatValue();
                Object e = arrayList.get(n3 * 2 + 1);
                Intrinsics.checkExpressionValueIsNotNull(e, "oneSideInputs[i * 2 + 1]");
                float f2 = f + ((Number)e).floatValue();
                arrayList2.add(Float.valueOf(f2));
                float f3 = (float)n3 * 2.0f;
                float f4 = ((Number)arrayList.get(n3 * 2 + 1)).floatValue();
                Object e2 = arrayList2.get(n3);
                Intrinsics.checkExpressionValueIsNotNull(e2, "weights[i]");
                arrayList3.add(Float.valueOf(f3 + f4 / ((Number)e2).floatValue()));
                if (n3 == n4) break;
                ++n3;
            }
        }
        String string = CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, pidb._a, 30, null);
        String string2 = CollectionsKt.joinToString$default(arrayList3, ",", null, null, 0, null, kjui._a, 30, null);
        int n5 = arrayList2.size();
        String string3 = "";
        string3 = string3 + "#version 120 \n";
        string3 = string3 + "uniform sampler2D image; \n";
        string3 = string3 + "uniform vec2 pixelOffset; \n";
        string3 = string3 + "\n";
        string3 = string3 + "varying vec2 textureCoord;\n";
        string3 = string3 + "\n";
        string3 = string3 + "void main() {\n";
        string3 = string3 + "\tvec2 uv = vec2(textureCoord);\n";
        string3 = string3 + "\tvec2 offset = vec2(0.0);\n";
        string3 = string3 + "\tvec3 color = vec3(0.0);\n";
        int n6 = 0;
        int n7 = n5 - 1;
        if (n6 <= n7) {
            while (true) {
                string3 = string3 + "\toffset = " + (Float)arrayList3.get(n6) + " * pixelOffset; \n";
                string3 = string3 + "\tcolor += (texture2D(image, uv + offset).xyz + texture2D(image, uv - offset).xyz) * " + (Float)arrayList2.get(n6) + ";\n";
                if (n6 == n7) break;
                ++n6;
            }
        }
        string3 = string3 + "\tgl_FragColor = vec4(color, 1.0);\n";
        string3 = string3 + "}\n";
        return string3;
    }

    static {
        _a = _a;
    }

    @NotNull
    public static final /* synthetic */ String _a() {
        return _a;
    }

    @NotNull
    public static final /* synthetic */ String _a(int n) {
        return dxcm._c(n);
    }
}

