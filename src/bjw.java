/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjm
 *  bjn
 *  bjo
 *  bjp
 *  bjq
 *  bjr
 *  bjx
 *  bki
 *  com.google.common.base.Function
 *  com.google.common.base.Joiner
 *  com.google.common.collect.Iterables
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Sets
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SideOnly(value=Side.CLIENT)
public class bjw
implements bjm {
    private static final Joiner a = Joiner.on((String)", ");
    private final Map b = Maps.newHashMap();
    private final List c = Lists.newArrayList();
    private final Set d = Sets.newLinkedHashSet();
    private final bki e;

    public bjw(bki par1MetadataSerializer) {
        this.e = par1MetadataSerializer;
    }

    public void a(bjr par1ResourcePack) {
        for (String s2 : par1ResourcePack.c()) {
            this.d.add(s2);
            bjh fallbackresourcemanager = (bjh)this.b.get(s2);
            if (fallbackresourcemanager == null) {
                fallbackresourcemanager = new bjh(this.e);
                this.b.put(s2, fallbackresourcemanager);
            }
            fallbackresourcemanager.a(par1ResourcePack);
        }
    }

    public Set a() {
        return this.d;
    }

    public bjn a(bjo par1ResourceLocation) throws IOException {
        bjp resourcemanager = (bjp)this.b.get(par1ResourceLocation.b());
        if (resourcemanager != null) {
            return resourcemanager.a(par1ResourceLocation);
        }
        throw new FileNotFoundException(par1ResourceLocation.toString());
    }

    public List b(bjo par1ResourceLocation) throws IOException {
        bjp resourcemanager = (bjp)this.b.get(par1ResourceLocation.b());
        if (resourcemanager != null) {
            return resourcemanager.b(par1ResourceLocation);
        }
        throw new FileNotFoundException(par1ResourceLocation.toString());
    }

    private void b() {
        this.b.clear();
        this.d.clear();
    }

    public void a(List par1List) {
        this.b();
        atv.w().an().a("Reloading ResourceManager: " + a.join(Iterables.transform((Iterable)par1List, (Function)new bjx(this))));
        for (bjr resourcepack : par1List) {
            this.a(resourcepack);
        }
        this.c();
    }

    public void a(bjq par1ResourceManagerReloadListener) {
        this.c.add(par1ResourceManagerReloadListener);
        par1ResourceManagerReloadListener.a((bjp)this);
    }

    private void c() {
        for (bjq resourcemanagerreloadlistener : this.c) {
            resourcemanagerreloadlistener.a((bjp)this);
        }
    }
}

