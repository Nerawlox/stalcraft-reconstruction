/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjn
 *  bjo
 *  bkg
 *  bki
 *  com.google.common.collect.Maps
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.apache.commons.io.IOUtils
 */
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import org.apache.commons.io.IOUtils;

@SideOnly(value=Side.CLIENT)
public class bjy
implements bjn {
    private final Map a = Maps.newHashMap();
    private final bjo b;
    private final InputStream c;
    private final InputStream d;
    private final bki e;
    private boolean f;
    private JsonObject g;

    public bjy(bjo par1ResourceLocation, InputStream par2InputStream, InputStream par3InputStream, bki par4MetadataSerializer) {
        this.b = par1ResourceLocation;
        this.c = par2InputStream;
        this.d = par3InputStream;
        this.e = par4MetadataSerializer;
    }

    public InputStream b() {
        return this.c;
    }

    public boolean c() {
        return this.d != null;
    }

    public bkg a(String par1Str) {
        bkg metadatasection;
        if (!this.c()) {
            return null;
        }
        if (this.g == null && !this.f) {
            this.f = true;
            BufferedReader bufferedreader = null;
            try {
                bufferedreader = new BufferedReader(new InputStreamReader(this.d));
                this.g = new JsonParser().parse((Reader)bufferedreader).getAsJsonObject();
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(bufferedreader);
                throw throwable;
            }
            IOUtils.closeQuietly((Reader)bufferedreader);
        }
        if ((metadatasection = (bkg)this.a.get(par1Str)) == null) {
            metadatasection = this.e.a(par1Str, this.g);
        }
        return metadatasection;
    }

    public boolean equals(Object par1Obj) {
        if (this == par1Obj) {
            return true;
        }
        if (par1Obj instanceof bjy) {
            bjy simpleresource = (bjy)par1Obj;
            return this.b != null ? this.b.equals((Object)simpleresource.b) : simpleresource.b == null;
        }
        return false;
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }
}

