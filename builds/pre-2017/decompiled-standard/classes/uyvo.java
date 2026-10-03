/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class uyvo {
    public static boolean _a = false;
    public static final File _b = new File(System.getProperty("mod_assets_dir", "modassets"));
    public static kjui _c;

    public static ByteBuffer _a(ResourceLocation resourceLocation) throws IOException {
        if (resourceLocation == null) {
            throw new IOException("Null ResourceLocation");
        }
        String string = "assets/" + resourceLocation.func_110624_b() + "/" + resourceLocation.func_110623_a();
        File file = new File(_b, string);
        if (_a && file.exists()) {
            try (FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();){
                MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size());
                return mappedByteBuffer;
            }
        }
        try (InputStream inputStream = uyvo._e(resourceLocation);){
            byte[] byArray = IOUtils.toByteArray(inputStream);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byArray.length).order(ByteOrder.nativeOrder());
            byteBuffer.put(byArray);
            byteBuffer.flip();
            ByteBuffer byteBuffer2 = byteBuffer;
            return byteBuffer2;
        }
    }

    public static ResourceLocation _a(String string) {
        if (!string.startsWith("/assets/")) {
            throw new IllegalArgumentException("Resource name " + string + " is invalid, resource files should be stored in assets directory!");
        }
        string = string.substring(8);
        string = StringUtils.replaceOnce(string, "/", ":");
        return new ResourceLocation(string);
    }

    public static ResourceLocation _b(ResourceLocation resourceLocation) {
        int n = resourceLocation.func_110623_a().lastIndexOf(47);
        if (n == -1) {
            return new ResourceLocation(resourceLocation.func_110624_b(), "");
        }
        return new ResourceLocation(resourceLocation.func_110624_b(), resourceLocation.func_110623_a().substring(0, n + 1));
    }

    public static String _a(ResourceLocation resourceLocation, boolean bl) {
        int n = resourceLocation.func_110623_a().lastIndexOf(47);
        String string = n == -1 ? resourceLocation.func_110623_a() : resourceLocation.func_110623_a().substring(n + 1);
        if (!bl) {
            string = uyvo._b(string);
        }
        return string;
    }

    private static String _b(String string) {
        return StringUtils.substringBeforeLast(string, ".");
    }

    public static String _c(ResourceLocation resourceLocation) {
        int n = resourceLocation.func_110623_a().lastIndexOf(46);
        if (n == -1) {
            throw new IllegalArgumentException("Resource location " + resourceLocation + " contains no extension.");
        }
        return resourceLocation.func_110623_a().substring(n + 1);
    }

    public static ResourceLocation _a(ResourceLocation resourceLocation, String string, String string2) {
        return uyvo._a(resourceLocation, string + '.' + string2);
    }

    public static ResourceLocation _a(ResourceLocation resourceLocation, String string) {
        return new ResourceLocation(resourceLocation.func_110624_b(), resourceLocation.func_110623_a() + string);
    }

    public static boolean _d(ResourceLocation resourceLocation) {
        return uyvo.class.getResource(uyvo._i(resourceLocation)) != null;
    }

    public static InputStream _e(ResourceLocation resourceLocation) throws IOException {
        Object object;
        if (_c != null && (object = _c._a(resourceLocation)) != null) {
            return object;
        }
        object = uyvo.class.getResource(uyvo._i(resourceLocation));
        if (object == null) {
            throw new FileNotFoundException(resourceLocation.toString());
        }
        return new BufferedInputStream(((URL)object).openStream());
    }

    public static InputStream _f(ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return null;
        }
        try {
            return uyvo._e(resourceLocation);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] _g(ResourceLocation resourceLocation) {
        try (InputStream inputStream = uyvo._e(resourceLocation);){
            byte[] byArray = IOUtils.toByteArray(inputStream);
            return byArray;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static String _h(ResourceLocation resourceLocation) {
        String string;
        try (InputStream inputStream = uyvo._e(resourceLocation);){
            string = IOUtils.toString(inputStream, "UTF-8");
            if (string.startsWith("\ufeff")) {
                string = string.substring(1);
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return string;
    }

    public static String _i(ResourceLocation resourceLocation) {
        return "/assets/" + resourceLocation.func_110624_b() + "/" + resourceLocation.func_110623_a();
    }

    public static interface kjui {
        public InputStream _a(ResourceLocation var1) throws IOException;
    }
}

