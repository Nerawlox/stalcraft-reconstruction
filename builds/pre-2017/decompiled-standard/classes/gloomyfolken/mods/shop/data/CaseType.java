/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.hanr;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.ResourceLocation;

public class CaseType {
    @SerializedName(value="case_id")
    public int case_id;
    @SerializedName(value="price")
    public int price;
    @SerializedName(value="name")
    public String name;
    @SerializedName(value="icon")
    public String icon;
    @SerializedName(value="groups")
    public satl loot;
    @SerializedName(value="amount")
    public int amount = 0;
    @SerializedName(value="discount")
    public int discount = 0;
    @SerializedName(value="listable")
    public boolean isListable = true;
    @SerializedName(value="rarity")
    public Map<hanr, Float> rarityDist = new LinkedHashMap<hanr, Float>();
    public transient int casesLeft = 0;
    private transient Object location;

    public void _a() {
        if (this.rarityDist == null) {
            return;
        }
        for (flpm flpm2 : this.loot._a) {
            float f = 0.0f;
            for (pzne pzne2 : flpm2._b) {
                f += pzne2._b;
            }
            for (pzne pzne2 : flpm2._b) {
                float f2 = pzne2._b / f;
                hanr hanr2 = null;
                for (Map.Entry<hanr, Float> entry : this.rarityDist.entrySet()) {
                    if (!(f2 <= entry.getValue().floatValue())) continue;
                    hanr2 = entry.getKey();
                    break;
                }
                if (hanr2 == null) continue;
                Object object = pzne2._f();
                if (object == null) {
                    object = new qoac();
                }
                object = hanr._a((qoac)object, hanr2);
                pzne2._a((qoac)object);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public boolean _b() {
        return this.icon != null && !this.icon.equals("");
    }

    @ezey(_a={eidj.CLIENT})
    public ResourceLocation _c() {
        if (this.location == null) {
            this.location = new ResourceLocation("shop", "textures/cases/" + this.icon + ".png");
        }
        return (ResourceLocation)this.location;
    }

    public List<flpm> _d() {
        return this.loot._a;
    }

    public int _e() {
        return (int)((double)this.price * (1.0 - (double)this.discount / 100.0));
    }
}

