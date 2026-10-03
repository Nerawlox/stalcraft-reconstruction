/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.Locale;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.gomc;

@SideOnly(value=Side.CLIENT)
public class LanguageManager
implements cvkw {
    public final MetadataSerializer _a;
    public String _b;
    public static final Locale _c = new Locale();
    public Map _d = Maps.newHashMap();

    public LanguageManager(MetadataSerializer metadataSerializer, String string) {
        this._a = metadataSerializer;
        this._b = string;
        wpcz._a(_c);
    }

    public void _a(List list2) {
        this._d.clear();
        for (fnrl fnrl2 : list2) {
            try {
                bbim bbim2 = (bbim)fnrl2.getPackMetadata(this._a, "language");
                if (bbim2 == null) continue;
                for (Language language : bbim2._a()) {
                    if (this._d.containsKey(language._a())) continue;
                    this._d.put(language._a(), language);
                }
            }
            catch (RuntimeException runtimeException) {
                Minecraft._E()._O()._a("Unable to parse metadata section of resourcepack: " + fnrl2.getPackName(), runtimeException);
            }
            catch (IOException iOException) {
                Minecraft._E()._O()._a("Unable to parse metadata section of resourcepack: " + fnrl2.getPackName(), iOException);
            }
        }
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        ArrayList<String> arrayList = Lists.newArrayList("en_US");
        if (!"en_US".equals(this._b)) {
            arrayList.add(this._b);
        }
        _c._a(resourceManager, arrayList);
        LanguageRegistry.instance().loadLanguageTable(LanguageManager._c._c, this._b);
        gomc._a(LanguageManager._c._c);
    }

    public boolean _a() {
        return _c._a();
    }

    public boolean _b() {
        return this._c()._b();
    }

    public void _a(Language language) {
        this._b = language._a();
    }

    public Language _c() {
        return this._d.containsKey(this._b) ? (Language)this._d.get(this._b) : (Language)this._d.get("en_US");
    }

    public SortedSet _d() {
        return Sets.newTreeSet(this._d.values());
    }
}

