/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Decompressor;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;
import net.jpountz.lz4.LZ4UnknownSizeDecompressor;
import net.jpountz.util.Native;
import net.jpountz.util.Utils;

public final class LZ4Factory {
    private static LZ4Factory NATIVE_INSTANCE;
    private static LZ4Factory JAVA_UNSAFE_INSTANCE;
    private static LZ4Factory JAVA_SAFE_INSTANCE;
    private final String impl;
    private final LZ4Compressor fastCompressor;
    private final LZ4Compressor highCompressor;
    private final LZ4FastDecompressor fastDecompressor;
    private final LZ4SafeDecompressor safeDecompressor;
    private final LZ4Compressor[] highCompressors = new LZ4Compressor[18];

    private static LZ4Factory instance(String impl) {
        try {
            return new LZ4Factory(impl);
        }
        catch (Exception e) {
            throw new AssertionError((Object)e);
        }
    }

    public static synchronized LZ4Factory nativeInstance() {
        if (NATIVE_INSTANCE == null) {
            NATIVE_INSTANCE = LZ4Factory.instance("JNI");
        }
        return NATIVE_INSTANCE;
    }

    public static synchronized LZ4Factory safeInstance() {
        if (JAVA_SAFE_INSTANCE == null) {
            JAVA_SAFE_INSTANCE = LZ4Factory.instance("JavaSafe");
        }
        return JAVA_SAFE_INSTANCE;
    }

    public static synchronized LZ4Factory unsafeInstance() {
        if (JAVA_UNSAFE_INSTANCE == null) {
            JAVA_UNSAFE_INSTANCE = LZ4Factory.instance("JavaUnsafe");
        }
        return JAVA_UNSAFE_INSTANCE;
    }

    public static LZ4Factory fastestJavaInstance() {
        if (Utils.isUnalignedAccessAllowed()) {
            try {
                return LZ4Factory.unsafeInstance();
            }
            catch (Throwable t) {
                return LZ4Factory.safeInstance();
            }
        }
        return LZ4Factory.safeInstance();
    }

    public static LZ4Factory fastestInstance() {
        if (Native.isLoaded() || Native.class.getClassLoader() == ClassLoader.getSystemClassLoader()) {
            try {
                return LZ4Factory.nativeInstance();
            }
            catch (Throwable t) {
                return LZ4Factory.fastestJavaInstance();
            }
        }
        return LZ4Factory.fastestJavaInstance();
    }

    private static <T> T classInstance(String cls) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        ClassLoader loader = LZ4Factory.class.getClassLoader();
        loader = loader == null ? ClassLoader.getSystemClassLoader() : loader;
        Class<?> c = loader.loadClass(cls);
        Field f = c.getField("INSTANCE");
        return (T)f.get(null);
    }

    private LZ4Factory(String impl) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        this.impl = impl;
        this.fastCompressor = (LZ4Compressor)LZ4Factory.classInstance("net.jpountz.lz4.LZ4" + impl + "Compressor");
        this.highCompressor = (LZ4Compressor)LZ4Factory.classInstance("net.jpountz.lz4.LZ4HC" + impl + "Compressor");
        this.fastDecompressor = (LZ4FastDecompressor)LZ4Factory.classInstance("net.jpountz.lz4.LZ4" + impl + "FastDecompressor");
        this.safeDecompressor = (LZ4SafeDecompressor)LZ4Factory.classInstance("net.jpountz.lz4.LZ4" + impl + "SafeDecompressor");
        Constructor<?> highConstructor = this.highCompressor.getClass().getDeclaredConstructor(Integer.TYPE);
        this.highCompressors[9] = this.highCompressor;
        for (int level = 1; level <= 17; ++level) {
            if (level == 9) continue;
            this.highCompressors[level] = (LZ4Compressor)highConstructor.newInstance(level);
        }
        byte[] original = new byte[]{97, 98, 99, 100, 32, 32, 32, 32, 32, 32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106};
        for (LZ4Compressor compressor : Arrays.asList(this.fastCompressor, this.highCompressor)) {
            int maxCompressedLength = compressor.maxCompressedLength(original.length);
            byte[] compressed = new byte[maxCompressedLength];
            int compressedLength = compressor.compress(original, 0, original.length, compressed, 0, maxCompressedLength);
            byte[] restored = new byte[original.length];
            this.fastDecompressor.decompress(compressed, 0, restored, 0, original.length);
            if (!Arrays.equals(original, restored)) {
                throw new AssertionError();
            }
            Arrays.fill(restored, (byte)0);
            int decompressedLength = this.safeDecompressor.decompress(compressed, 0, compressedLength, restored, 0);
            if (decompressedLength != original.length || !Arrays.equals(original, restored)) {
                throw new AssertionError();
            }
        }
    }

    public LZ4Compressor fastCompressor() {
        return this.fastCompressor;
    }

    public LZ4Compressor highCompressor() {
        return this.highCompressor;
    }

    public LZ4Compressor highCompressor(int compressionLevel) {
        if (compressionLevel > 17) {
            compressionLevel = 17;
        } else if (compressionLevel < 1) {
            compressionLevel = 9;
        }
        return this.highCompressors[compressionLevel];
    }

    public LZ4FastDecompressor fastDecompressor() {
        return this.fastDecompressor;
    }

    public LZ4SafeDecompressor safeDecompressor() {
        return this.safeDecompressor;
    }

    public LZ4UnknownSizeDecompressor unknownSizeDecompressor() {
        return this.safeDecompressor();
    }

    public LZ4Decompressor decompressor() {
        return this.fastDecompressor();
    }

    public static void main(String[] args) {
        System.out.println("Fastest instance is " + LZ4Factory.fastestInstance());
        System.out.println("Fastest Java instance is " + LZ4Factory.fastestJavaInstance());
    }

    public String toString() {
        return this.getClass().getSimpleName() + ":" + this.impl;
    }
}

