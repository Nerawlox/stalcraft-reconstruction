/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.util.ResourceLocation;

public class vmay
implements fnrl {
    public static final Set _a = ImmutableSet.of("minecraft");
    public final Map _b = Maps.newHashMap();
    public final File _c;

    public vmay(File file) {
        this._c = file;
        this._a(this._c);
    }

    @Override
    public InputStream func_110590_a(ResourceLocation resourceLocation) {
        InputStream inputStream = this._a(resourceLocation);
        if (inputStream != null) {
            return inputStream;
        }
        File file = (File)this._b.get(resourceLocation.toString());
        if (file != null) {
            return new FileInputStream(file);
        }
        throw new FileNotFoundException(resourceLocation.func_110623_a());
    }

    public InputStream _a(ResourceLocation resourceLocation) {
        return vmay.class.getResourceAsStream("/assets/minecraft/" + resourceLocation.func_110623_a());
    }

    public void _a(String string, File file) {
        this._b.put(new ResourceLocation(string).toString(), file);
    }

    @Override
    public boolean func_110589_b(ResourceLocation resourceLocation) {
        return this._a(resourceLocation) != null || this._b.containsKey(resourceLocation.toString());
    }

    @Override
    public Set func_110587_b() {
        return _a;
    }

    public void _a(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                this._a(file2);
            }
        } else {
            this._a(nvkn.func_110595_a(this._c, file), file);
        }
    }

    @Override
    public gqyj func_135058_a(rqxe rqxe2, String string) {
        return nvkn.func_110596_a(rqxe2, vmay.class.getResourceAsStream("/" + new ResourceLocation("pack.mcmeta").func_110623_a()), string);
    }

    @Override
    public BufferedImage func_110586_a() {
        return ImageIO.read(vmay.class.getResourceAsStream("/" + new ResourceLocation("pack.png").func_110623_a()));
    }

    @Override
    public String func_130077_b() {
        return "Default";
    }
}

