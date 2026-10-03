/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class xsgn
implements ResourceManager {
    public final List _a = new ArrayList();
    public final MetadataSerializer _b;

    public xsgn(MetadataSerializer metadataSerializer) {
        this._b = metadataSerializer;
    }

    public void _a(fnrl fnrl2) {
        this._a.add(fnrl2);
    }

    @Override
    public Set _a() {
        return null;
    }

    @Override
    public htyg _a(ResourceLocation resourceLocation) {
        fnrl fnrl2 = null;
        ResourceLocation resourceLocation2 = xsgn._c(resourceLocation);
        for (int i = this._a.size() - 1; i >= 0; --i) {
            fnrl fnrl3 = (fnrl)this._a.get(i);
            if (fnrl2 == null && fnrl3.resourceExists(resourceLocation2)) {
                fnrl2 = fnrl3;
            }
            if (!fnrl3.resourceExists(resourceLocation)) continue;
            InputStream inputStream = null;
            if (fnrl2 != null) {
                inputStream = fnrl2.getInputStream(resourceLocation2);
            }
            return new dynm(resourceLocation, fnrl3.getInputStream(resourceLocation), inputStream, this._b);
        }
        throw new FileNotFoundException(resourceLocation.toString());
    }

    @Override
    public List _b(ResourceLocation resourceLocation) {
        ArrayList<dynm> arrayList = Lists.newArrayList();
        ResourceLocation resourceLocation2 = xsgn._c(resourceLocation);
        for (fnrl fnrl2 : this._a) {
            if (!fnrl2.resourceExists(resourceLocation)) continue;
            InputStream inputStream = fnrl2.resourceExists(resourceLocation2) ? fnrl2.getInputStream(resourceLocation2) : null;
            arrayList.add(new dynm(resourceLocation, fnrl2.getInputStream(resourceLocation), inputStream, this._b));
        }
        if (arrayList.isEmpty()) {
            throw new FileNotFoundException(resourceLocation.toString());
        }
        return arrayList;
    }

    public static ResourceLocation _c(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getResourceDomain(), resourceLocation.getResourcePath() + ".mcmeta");
    }
}

