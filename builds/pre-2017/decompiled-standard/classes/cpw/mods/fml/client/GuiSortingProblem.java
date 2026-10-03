/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.toposort.ModSortingException;

public class GuiSortingProblem
extends gqjz {
    private ModSortingException modSorting;
    private ModSortingException.SortingExceptionData<ModContainer> failedList;

    public GuiSortingProblem(ModSortingException modSortingException) {
        this.modSorting = modSortingException;
        this.failedList = modSortingException.getExceptionData();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = Math.max(85 - (this.failedList.getVisitedNodes().size() + 3) * 10, 10);
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader has found a problem with your minecraft installation", this.field_73880_f / 2, n3, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "A mod sorting cycle was detected and loading cannot continue", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, String.format("The first mod in the cycle is %s", this.failedList.getFirstBadNode()), this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "The remainder of the cycle involves these mods", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (ModContainer modContainer : this.failedList.getVisitedNodes()) {
            this.func_73732_a(this.field_73886_k, String.format("%s : before: %s, after: %s", modContainer.toString(), modContainer.getDependants(), modContainer.getDependencies()), this.field_73880_f / 2, n3 += 10, 0xEEEEEE);
        }
        this.func_73732_a(this.field_73886_k, "The file 'ForgeModLoader-client-0.log' contains more information", this.field_73880_f / 2, n3 += 20, 0xFFFFFF);
    }
}

