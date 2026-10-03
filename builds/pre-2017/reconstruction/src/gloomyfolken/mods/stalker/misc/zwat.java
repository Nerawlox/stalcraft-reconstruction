/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class zwat
extends iuww {
    public zwat() {
        super("\u041e\u043f\u0430\u0441\u043d\u0430\u044f \u0437\u043e\u043d\u0430", "sick_reg_warning", TimeUnit.MINUTES.toMillis(1L));
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        String string = "\u041d\u0430\u0434\u0435\u043d\u044c\u0442\u0435 \u043b\u044e\u0431\u043e\u0439 \u0438\u0437 \u0437\u0430\u0449\u0438\u0442\u043d\u044b\u0445 \u043a\u043e\u043c\u043f\u043b\u0435\u043a\u0442\u043e\u0432: ";
        int[] nArray = bqdo2._d()._l("items");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int n : nArray) {
            Item item = Item.itemsList[n];
            if (item == null) continue;
            arrayList.add(new ItemStack(item)._s());
        }
        return string + String.join((CharSequence)", ", arrayList);
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return iuww.kjui._c;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
    }
}

