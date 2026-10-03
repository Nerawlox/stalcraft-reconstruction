/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.shop.data.CaseType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaseData {
    @SerializedName(value="case_types")
    public List<CaseType> typeList = new ArrayList<CaseType>();

    public CaseType _a(int n) {
        for (CaseType caseType : this.typeList) {
            if (caseType.case_id != n) continue;
            return caseType;
        }
        return null;
    }

    public void _a() {
        for (CaseType caseType : this.typeList) {
            for (flpm flpm2 : caseType._d()) {
                Iterator<pzne> iterator2 = flpm2._b.iterator();
                while (iterator2.hasNext()) {
                    pzne pzne2 = iterator2.next();
                    if (!pzne2._a()) continue;
                    Logger.warning("Found invalid item in case config: " + pzne2._c(), new Object[0]);
                    iterator2.remove();
                }
            }
        }
    }
}

