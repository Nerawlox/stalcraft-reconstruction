/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.ItemData;
import java.util.List;
import java.util.Map;

public class GuiIdMismatchScreen
extends lowa {
    private List<String> missingIds = Lists.newArrayList();
    private List<String> mismatchedIds = Lists.newArrayList();
    private boolean allowContinue;

    public GuiIdMismatchScreen(MapDifference<Integer, ItemData> mapDifference, boolean bl) {
        super(null, "ID mismatch", "Should I continue?", 1);
        this.field_73942_a = this;
        for (Map.Entry<Integer, ItemData> entry : mapDifference.entriesOnlyOnLeft().entrySet()) {
            this.missingIds.add(String.format("ID %d from Mod %s is missing", entry.getValue().getItemId(), entry.getValue().getModId(), entry.getValue().getItemType()));
        }
        for (Map.Entry<Integer, Object> entry : mapDifference.entriesDiffering().entrySet()) {
            ItemData itemData = (ItemData)((MapDifference.ValueDifference)entry.getValue()).leftValue();
            ItemData itemData2 = (ItemData)((MapDifference.ValueDifference)entry.getValue()).rightValue();
            this.mismatchedIds.add(String.format("ID %d is mismatched between world and game", itemData.getItemId()));
        }
        this.allowContinue = bl;
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        FMLClientHandler.instance().callbackIdDifferenceResponse(bl);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        if (!this.allowContinue && this.field_73887_h.size() == 2) {
            this.field_73887_h.remove(0);
        }
        int n3 = Math.max(85 - (this.missingIds.size() + this.mismatchedIds.size()) * 10, 30);
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader has found ID mismatches", this.field_73880_f / 2, 10, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "Complete details are in the log file", this.field_73880_f / 2, 20, 0xFFFFFF);
        int n4 = 20;
        for (String object : this.missingIds) {
            this.func_73732_a(this.field_73886_k, object, this.field_73880_f / 2, n3, 0xEEEEEE);
            if (--n4 >= 0 && (n3 += 10) < this.field_73881_g - 30) continue;
            break;
        }
        if (n4 > 0 && n3 < this.field_73881_g - 30) {
            for (String string : this.mismatchedIds) {
                this.func_73732_a(this.field_73886_k, string, this.field_73880_f / 2, n3, 0xEEEEEE);
                if (--n4 >= 0 && (n3 += 10) < this.field_73881_g - 30) continue;
                break;
            }
        }
        if (this.allowContinue) {
            this.func_73732_a(this.field_73886_k, "Do you wish to continue loading?", this.field_73880_f / 2, this.field_73881_g - 30, 0xFFFFFF);
        } else {
            this.func_73732_a(this.field_73886_k, "You cannot connect to this server", this.field_73880_f / 2, this.field_73881_g - 30, 0xFFFFFF);
        }
        for (int i = 0; i < this.field_73887_h.size(); ++i) {
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            jiok2.field_73743_d = this.field_73881_g - 20;
            if (!this.allowContinue) {
                jiok2.field_73746_c = this.field_73880_f / 2 - 75;
                jiok2.field_73744_e = wpcz._a("gui.done");
            }
            jiok2.func_73737_a(this.field_73882_e, n, n2);
        }
    }
}

