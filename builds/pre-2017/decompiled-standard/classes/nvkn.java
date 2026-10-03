/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public abstract class nvkn
implements fnrl {
    public static final jjmf field_110598_a = xpzm._E()._O();
    public final File field_110597_b;

    public nvkn(File file) {
        this.field_110597_b = file;
    }

    public static String func_110592_c(ResourceLocation resourceLocation) {
        return String.format("%s/%s/%s", "assets", resourceLocation.func_110624_b(), resourceLocation.func_110623_a());
    }

    public static String func_110595_a(File file, File file2) {
        return file.toURI().relativize(file2.toURI()).getPath();
    }

    @Override
    public InputStream func_110590_a(ResourceLocation resourceLocation) {
        return this.func_110591_a(nvkn.func_110592_c(resourceLocation));
    }

    @Override
    public boolean func_110589_b(ResourceLocation resourceLocation) {
        return this.func_110593_b(nvkn.func_110592_c(resourceLocation));
    }

    public abstract InputStream func_110591_a(String var1);

    public abstract boolean func_110593_b(String var1);

    public void func_110594_c(String string) {
        field_110598_a._a("ResourcePack: ignored non-lowercase namespace: %s in %s", string, this.field_110597_b);
    }

    @Override
    public gqyj func_135058_a(rqxe rqxe2, String string) {
        return nvkn.func_110596_a(rqxe2, this.func_110591_a("pack.mcmeta"), string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static gqyj func_110596_a(rqxe rqxe2, InputStream inputStream, String string) {
        JsonObject jsonObject = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            jsonObject = new JsonParser().parse(bufferedReader).getAsJsonObject();
        }
        catch (Throwable throwable) {
            IOUtils.closeQuietly(bufferedReader);
            throw throwable;
        }
        IOUtils.closeQuietly(bufferedReader);
        return rqxe2._a(string, jsonObject);
    }

    @Override
    public BufferedImage func_110586_a() {
        return ImageIO.read(this.func_110591_a("pack.png"));
    }

    @Override
    public String func_130077_b() {
        return this.field_110597_b.getName();
    }
}

