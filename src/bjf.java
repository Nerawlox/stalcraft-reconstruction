/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bjr
 *  bkg
 *  bki
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  lp
 *  org.apache.commons.io.IOUtils
 */
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;

@SideOnly(value=Side.CLIENT)
public abstract class bjf
implements bjr {
    protected static final lp a = atv.w().an();
    protected final File b;

    public bjf(File par1File) {
        this.b = par1File;
    }

    private static String c(bjo par0ResourceLocation) {
        return String.format("%s/%s/%s", "assets", par0ResourceLocation.b(), par0ResourceLocation.a());
    }

    protected static String a(File par0File, File par1File) {
        return par0File.toURI().relativize(par1File.toURI()).getPath();
    }

    public InputStream a(bjo par1ResourceLocation) throws IOException {
        return this.a(bjf.c(par1ResourceLocation));
    }

    public boolean b(bjo par1ResourceLocation) {
        return this.b(bjf.c(par1ResourceLocation));
    }

    protected abstract InputStream a(String var1) throws IOException;

    protected abstract boolean b(String var1);

    protected void c(String par1Str) {
        a.b("ResourcePack: ignored non-lowercase namespace: %s in %s", new Object[]{par1Str, this.b});
    }

    public bkg a(bki par1MetadataSerializer, String par2Str) throws IOException {
        return bjf.a(par1MetadataSerializer, this.a("pack.mcmeta"), par2Str);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static bkg a(bki par0MetadataSerializer, InputStream par1InputStream, String par2Str) {
        JsonObject jsonobject = null;
        BufferedReader bufferedreader = null;
        try {
            bufferedreader = new BufferedReader(new InputStreamReader(par1InputStream));
            jsonobject = new JsonParser().parse((Reader)bufferedreader).getAsJsonObject();
        }
        catch (Throwable throwable) {
            IOUtils.closeQuietly(bufferedreader);
            throw throwable;
        }
        IOUtils.closeQuietly((Reader)bufferedreader);
        return par0MetadataSerializer.a(par2Str, jsonobject);
    }

    public BufferedImage a() throws IOException {
        return ImageIO.read(this.a("pack.png"));
    }

    public String b() {
        return this.b.getName();
    }
}

