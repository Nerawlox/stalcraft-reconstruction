/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bjr
 *  bkg
 *  bki
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.Maps
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;

@SideOnly(value=Side.CLIENT)
public class bjg
implements bjr {
    public static final Set a = ImmutableSet.of((Object)"minecraft");
    private final Map b = Maps.newHashMap();
    private final File c;

    public bjg(File par1File) {
        this.c = par1File;
        this.a(this.c);
    }

    public InputStream a(bjo par1ResourceLocation) throws IOException {
        InputStream inputstream = this.c(par1ResourceLocation);
        if (inputstream != null) {
            return inputstream;
        }
        File file1 = (File)this.b.get(par1ResourceLocation.toString());
        if (file1 != null) {
            return new FileInputStream(file1);
        }
        throw new FileNotFoundException(par1ResourceLocation.a());
    }

    private InputStream c(bjo par1ResourceLocation) {
        return bjg.class.getResourceAsStream("/assets/minecraft/" + par1ResourceLocation.a());
    }

    public void a(String par1Str, File par2File) {
        this.b.put(new bjo(par1Str).toString(), par2File);
    }

    public boolean b(bjo par1ResourceLocation) {
        return this.c(par1ResourceLocation) != null || this.b.containsKey(par1ResourceLocation.toString());
    }

    public Set c() {
        return a;
    }

    public void a(File par1File) {
        if (par1File.isDirectory()) {
            for (File file2 : par1File.listFiles()) {
                this.a(file2);
            }
        } else {
            this.a(bjf.a(this.c, par1File), par1File);
        }
    }

    public bkg a(bki par1MetadataSerializer, String par2Str) throws IOException {
        return bjf.a(par1MetadataSerializer, bjg.class.getResourceAsStream("/" + new bjo("pack.mcmeta").a()), par2Str);
    }

    public BufferedImage a() throws IOException {
        return ImageIO.read(bjg.class.getResourceAsStream("/" + new bjo("pack.png").a()));
    }

    public String b() {
        return "Default";
    }
}

