/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.weapon.tupg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class jibd
extends majr {
    private List<cvzo> _i = new ArrayList<cvzo>();

    public jibd(gqjz gqjz2, cvzo cvzo2) {
        super(gqjz2, cvzo2);
        for (tgdv tgdv2 : tgdv.field_77698_e) {
            if (!(tgdv2 instanceof dxwc) && !(tgdv2 instanceof stap) && !(tgdv2 instanceof xroo)) continue;
            this._i.add(new cvzo(tgdv2));
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addLabel((IAdvancedGui)this, "\u0412\u044b \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0435\u0441\u044c \u0432 \u0434\u0435\u043c\u043e\u043d\u0441\u0442\u0440\u0430\u0446\u0438\u043e\u043d\u043d\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435.", new Point(this.guiWidth / 2, 20), 0xFF0000).setCentered(this.screenWidth / 2, 30);
        GuiHelper.addLabel((IAdvancedGui)this, "\u0417\u0434\u0435\u0441\u044c \u0432\u0430\u043c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b \u0432\u0441\u0435 \u043c\u043e\u0434\u0443\u043b\u0438, \u043f\u043e\u0434\u0445\u043e\u0434\u044f\u0449\u0438\u0435 \u0434\u043b\u044f \u0434\u0430\u043d\u043d\u043e\u0433\u043e \u043e\u0440\u0443\u0436\u0438\u044f.", new Point(this.guiWidth / 2, 40), 0xFF0000).setCentered(this.screenWidth / 2, 50);
    }

    @Override
    protected List<cvzo> getAvailableStacks() {
        return this._i;
    }

    @Override
    protected void _b(cvzo cvzo2) {
    }

    @Override
    protected void _d() {
    }

    @Override
    protected void _a(dxwc.pidb pidb2, cvzo cvzo2) {
        if (cvzo2 == null) {
            new tupg((EntityPlayer)GuiItem.mc._t, this.getStack())._a(pidb2);
        } else {
            new tupg((EntityPlayer)GuiItem.mc._t, this.getStack())._a(pidb2, cvzo2);
        }
    }

    @Override
    protected void _d(cvzo cvzo2) {
    }

    @Override
    protected void _c(cvzo cvzo2) {
    }
}

