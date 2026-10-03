/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import mods.pda.client.screens.tab.SelectablePdaTab;

public abstract class pjlq
extends SelectablePdaTab {
    public pjlq(IAdvancedGui iAdvancedGui, Class<? extends pjlq> clazz) {
        super(iAdvancedGui, clazz);
    }

    @Override
    protected void registerVerticalTabs() {
        if (yuch._a._a.equals("")) {
            this.tabs.put("\u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043a\u043b\u0430\u043d", dxjw.class);
        } else {
            this.tabs.put("\u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044f", mack.class);
            this.tabs.put("\u0441\u043e\u0441\u0442\u0430\u0432", ndep.class);
            if (yuch._a._c.contains((Object)amww._m)) {
                this.tabs.put("\u0430\u0440\u0445\u0438\u0432", macm.class);
            }
        }
        this.tabs.put("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438", cugv.class);
        this.tabs.put("\u0431\u0430\u0437\u044b", bret.class);
        this.tabs.put("\u0437\u0430\u0445\u0432\u0430\u0442\u044b", ndex.class);
    }
}

