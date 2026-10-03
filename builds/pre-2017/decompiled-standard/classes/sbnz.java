/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.mods.asm.PathModifier;
import gr.zdimensions.jsquish.Squish;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.activation.UnsupportedDataTypeException;
import mcoptifine.Config;
import me.nallar.jdds.JDDS;
import me.nallar.jdds.internal.ddsutil.ByteBufferedImage;
import me.nallar.jdds.internal.ddsutil.PixelFormats;
import me.nallar.jdds.internal.model.AbstractTextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.io.FileUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class sbnz {
    public static boolean _a = System.getProperty("obf.gloomyfolken.prestitcher.dump", "false").equals("true");
    public static boolean _b = System.getProperty("usePrestitchedAtlas", "false").equals("true") && !_a;
    private static HashSet<Integer> _c = new HashSet(2);

    public static boolean _a(scvi scvi2, List list) {
        return false;
    }

    public static void _a() {
    }

    public static boolean _a(sctd sctd2, xsfs xsfs2) {
        if (!_c.contains(sctd2._m) && sctd2._m != 2) {
            System.out.println("Skipping loading map " + sctd2._n);
            _c.add(sctd2._m);
            return true;
        }
        if (sctd._u && sctd2._d()) {
            System.out.println("Skipping dump stitching" + sctd2._n);
            return true;
        }
        if (!_b || !sctd2._d()) {
            System.out.println("Loading vanilla atlas " + sctd2._n);
            return false;
        }
        try {
            long l = System.currentTimeMillis();
            sctd2._c();
            sctd2._l.clear();
            sctd2._j.clear();
            MinecraftForge.EVENT_BUS.post(new TextureStitchEvent.Pre(sctd2));
            ResourceLocation resourceLocation = new ResourceLocation("stalker", sctd2._n + "_" + sctd2._r + ".dds");
            String string = PathModifier._b ? ".m" : ".map";
            ResourceLocation resourceLocation2 = new ResourceLocation("stalker", sctd2._n + "_" + sctd2._r + string);
            temw temw2 = (temw)sbnz._a(resourceLocation);
            try {
                temw2.load(false);
            }
            catch (Exception exception) {
                FMLRelaunchLog.fine("Stitched texture map " + sctd2._n + " not found", new Object[0]);
                return false;
            }
            FMLRelaunchLog.fine("Pre stitched texture uploaded in " + (System.currentTimeMillis() - l) + " ms", new Object[0]);
            InputStream inputStream = PathModifier._b ? new ByteArrayInputStream(telk._a(resourceLocation2)) : xsfs2._a(resourceLocation2)._a();
            if (inputStream == null) {
                FMLRelaunchLog.fine("Stitch mapping for " + sctd2._n + " not found", new Object[0]);
                return false;
            }
            FMLRelaunchLog.fine("Loading pre stitched map " + sctd2._n, new Object[0]);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            sctd2._p = n;
            sctd2._q = n2;
            if (sctd2._h >= 0) {
                GL11.glDeleteTextures(sctd2._h);
                sctd2._h = -1;
            }
            sctd2._h = temw2.func_110552_b();
            GL11.glBindTexture(3553, sctd2._h);
            sctd2._g();
            for (int i = 0; i < n3; ++i) {
                try {
                    String string2 = dataInputStream.readUTF();
                    dhji dhji2 = sctd2._k.get(string2);
                    if (dhji2 == null) {
                        dhji2 = new dhji(string2);
                    }
                    dhji2.func_110966_b(dataInputStream.readInt());
                    dhji2.func_110969_c(dataInputStream.readInt());
                    dhji2.func_110971_a(n, n2, dataInputStream.readInt(), dataInputStream.readInt(), true);
                    dhji2.field_110979_l = dataInputStream.readFloat();
                    dhji2.field_110980_m = dataInputStream.readFloat();
                    dhji2.field_110977_n = dataInputStream.readFloat();
                    dhji2.field_110978_o = dataInputStream.readFloat();
                    dhji2.baseU = Math.min(dhji2.field_110979_l, dhji2.field_110980_m);
                    dhji2.baseV = Math.min(dhji2.field_110977_n, dhji2.field_110978_o);
                    dhji2.padded = dataInputStream.readBoolean();
                    dataInputStream.readBoolean();
                    sctd2._k.put(dhji2.func_94215_i(), dhji2);
                    sctd2._l.put(dhji2.func_94215_i(), dhji2);
                    if (dhji2.func_130098_m()) {
                        sctd2._j.add(dhji2);
                        continue;
                    }
                    dhji2.func_130103_l();
                    continue;
                }
                catch (IOException iOException) {
                    throw new RuntimeException(iOException);
                }
            }
            dataInputStream.close();
            FMLRelaunchLog.fine("Texture map loaded in " + (System.currentTimeMillis() - l) + " ms", new Object[0]);
            MinecraftForge.EVENT_BUS.post(new TextureStitchEvent.Post(sctd2));
            if (sctd2._m == 0) {
                sctd._e().func_110551_a(xsfs2);
                sctd._e()._r = sctd2._r;
            }
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    private static sctg _a(ResourceLocation resourceLocation) {
        try {
            Class.forName("mqyc");
            return sbnz._b(resourceLocation);
        }
        catch (ClassNotFoundException classNotFoundException) {
            FMLRelaunchLog.fine("Using default texture loader", new Object[0]);
            return new cegk(resourceLocation);
        }
    }

    private static sctg _b(ResourceLocation resourceLocation) {
        if (resourceLocation.func_110623_a().toLowerCase().endsWith(".ol")) {
            return new cubd(resourceLocation);
        }
        if (resourceLocation.func_110623_a().toLowerCase().endsWith(".dds")) {
            return new ssnn(resourceLocation);
        }
        return new ejeo(resourceLocation);
    }

    public static void _a(sctd sctd2) {
        try {
            boolean bl;
            boolean bl2;
            Object bl3;
            long l = System.currentTimeMillis();
            if (!_a || !sctd2._d()) {
                return;
            }
            GL11.glBindTexture(3553, sctd2._h);
            int n = GL11.glGetTexLevelParameteri(3553, 0, 4096);
            int n2 = GL11.glGetTexLevelParameteri(3553, 0, 4097);
            File file = new File(String.format(uyvo._b + "/assets/stalker/%s_%d.map", sctd2._n, sctd2._r));
            file.getParentFile().mkdirs();
            byte[] byArray = null;
            if (file.exists()) {
                byArray = FileUtils.readFileToByteArray(file);
            }
            sctd2._k.put(sctd2._o.func_94215_i(), sctd2._o);
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeInt(n);
            dataOutputStream.writeInt(n2);
            dataOutputStream.writeInt(sctd2._k.size());
            for (dhji bufferedImageArray2 : sctd2._k.values()) {
                dataOutputStream.writeUTF(bufferedImageArray2.func_94215_i());
                dataOutputStream.writeInt(bufferedImageArray2.func_94211_a());
                dataOutputStream.writeInt(bufferedImageArray2.func_94216_b());
                dataOutputStream.writeInt(bufferedImageArray2.func_130010_a());
                dataOutputStream.writeInt(bufferedImageArray2.func_110967_i());
                dataOutputStream.writeFloat(bufferedImageArray2.field_110979_l);
                dataOutputStream.writeFloat(bufferedImageArray2.field_110980_m);
                dataOutputStream.writeFloat(bufferedImageArray2.field_110977_n);
                dataOutputStream.writeFloat(bufferedImageArray2.field_110978_o);
                dataOutputStream.writeBoolean(bufferedImageArray2.padded);
                dataOutputStream.writeBoolean(bufferedImageArray2.func_130098_m());
            }
            dataOutputStream.close();
            Object object2 = FileUtils.readFileToByteArray(file);
            BufferedImage[] bufferedImageArray = new BufferedImage[Config.getMipmapLevel()];
            FMLRelaunchLog.fine("Dumping block texture map of resolution %dx%d", n, n2);
            int n3 = Config.getMipmapLevel();
            for (int file2 = 0; file2 < n3; ++file2) {
                FMLRelaunchLog.fine("Processing mipmap level %d", file2);
                int file3 = GL11.glGetTexLevelParameteri(3553, file2, 4096);
                int nArray = GL11.glGetTexLevelParameteri(3553, file2, 4097);
                IntBuffer bl22 = BufferUtils.createIntBuffer(file3 * nArray);
                GL11.glGetTexImage(3553, file2, 32993, 33639, bl22);
                bl3 = new BufferedImage(file3, nArray, 6);
                int[] i = new int[file3 * nArray];
                bl22.get(i);
                ((BufferedImage)bl3).setRGB(0, 0, file3, nArray, i, 0, file3);
                bufferedImageArray[file2] = bl3;
            }
            File file2 = new File(String.format(uyvo._b + "/assets/stalker/%s_%d.dds", sctd2._n, sctd2._r));
            File file3 = new File(String.format(uyvo._b + "/assets/stalker/%s_%d.inf", sctd2._n, sctd2._r));
            int[] nArray = Arrays.stream(bufferedImageArray).mapToInt(bufferedImage -> Arrays.hashCode(((DataBufferByte)bufferedImage.getRaster().getDataBuffer()).getData())).toArray();
            boolean bl4 = bl2 = !file3.exists();
            if (file3.exists()) {
                bl3 = new DataInputStream(new FileInputStream(file3));
                for (int kjui2 = 0; kjui2 < n3; ++kjui2) {
                    bl2 |= ((DataInputStream)bl3).readInt() != nArray[kjui2];
                }
                ((FilterInputStream)bl3).close();
            }
            boolean bl5 = bl = !file2.exists() || byArray == null || bl2;
            if (bl) {
                kjui dataOutputStream2 = new kjui(bufferedImageArray);
                new JDDS().write(file2, dataOutputStream2, 894720068);
            }
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file3));
            for (int i = 0; i < n3; ++i) {
                dataOutputStream2.writeInt(nArray[i]);
            }
            dataOutputStream2.close();
            long l2 = (System.currentTimeMillis() - l) / 100L;
            System.out.println(String.format("[PRESTITCHER] time consumed: %.2fs", (double)l2 / 10.0));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Hook(injectOnExit=true, priority=HookPriority.LOW)
    public static void _a(FMLClientHandler fMLClientHandler) {
        if (_a) {
            sctd._u = false;
            for (int i = 0; i < 4; ++i) {
                sctd._f._r = uhip._a._b(i);
                sctd._f._b(Config.getResourceManager());
            }
        }
    }

    private static class kjui
    extends AbstractTextureMap {
        private final BufferedImage[] _a;
        private ByteBuffer[] _b;
        private AtomicInteger _c = new AtomicInteger(0);

        private kjui(BufferedImage[] bufferedImageArray) {
            this._a = bufferedImageArray;
            this._b = new ByteBuffer[bufferedImageArray.length];
            for (int i = 0; i < bufferedImageArray.length; ++i) {
                this._a(i);
            }
        }

        private void _a(int n) {
            try {
                System.out.println("compressing mipmap " + n);
                this._b[n] = this.compress(this._a[n], PixelFormats.getSquishCompressionFormat(894720068));
                this._c.incrementAndGet();
            }
            catch (UnsupportedDataTypeException unsupportedDataTypeException) {
                unsupportedDataTypeException.printStackTrace();
            }
        }

        @Override
        public int getWidth() {
            return this._a[0].getWidth();
        }

        @Override
        public int getHeight() {
            return this._a[0].getHeight();
        }

        @Override
        public ByteBuffer[] getDXTCompressedBuffer(Squish.CompressionType compressionType) {
            while (this._c.get() < this._a.length) {
                try {
                    Thread.sleep(50L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            return this._b;
        }

        @Override
        public ByteBuffer[] getUncompressedBuffer() {
            ByteBuffer[] byteBufferArray = new ByteBuffer[this._a.length];
            for (int i = 0; i < this._a.length; ++i) {
                byteBufferArray[i] = ByteBuffer.wrap(ByteBufferedImage.convertBIintoARGBArray(this._a[i]));
            }
            return byteBufferArray;
        }
    }
}

