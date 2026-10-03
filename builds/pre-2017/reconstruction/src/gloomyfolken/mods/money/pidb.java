/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.money.ezey;
import gloomyfolken.mods.money.zwat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.event.ForgeSubscribe;

public class pidb {
    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b) {
            Minecraft minecraft = Minecraft._E();
            if (minecraft._t != null && minecraft._B instanceof cebg) {
                boolean bl = false;
                for (GuiButton guiButton : minecraft._B.buttonList) {
                    if (!(guiButton instanceof ezey)) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    String string = "\u0421\u0447\u0435\u0442: " + zwat._a(minecraft._t)._b();
                    int n = minecraft._B.width - minecraft._z._b(string) - 2;
                    int n2 = minecraft._B.height - minecraft._z._c - 2;
                    minecraft._B.buttonList.add(new ezey(n, n2, string));
                }
            }
        }
    }

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("money", new zwat(mquk2._a));
    }
}

