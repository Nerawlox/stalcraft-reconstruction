/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import mods.regions.RegionsMod;
import mods.regions.client.RegionsGameHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@ezey(_a={eidj.CLIENT})
public class KeyboardListener {
    public static boolean _a;

    public static void listen() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B != null && !minecraft._B.allowUserInput) {
            return;
        }
        if (minecraft._B != null) {
            minecraft._B.handleInput();
        }
        while (Keyboard.next()) {
            int n;
            KeyBinding._a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
            if (Keyboard.getEventKeyState()) {
                KeyBinding._a(Keyboard.getEventKey());
            }
            if (!Keyboard.getEventKeyState()) continue;
            if (Keyboard.getEventKey() == 87) {
                minecraft._r();
                continue;
            }
            if (minecraft._B != null) {
                minecraft._B.handleKeyboardInput();
                continue;
            }
            if (Keyboard.getEventKey() == 1) {
                minecraft._q();
            }
            if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                minecraft._c();
            }
            if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61)) {
                minecraft._c();
            }
            if (Keyboard.getEventKey() == 45 && Keyboard.isKeyDown(61)) {
                GloomyCore.instance.itemsLoader._e();
            }
            if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown(61)) {
                minecraft._M.advancedItemTooltips = !minecraft._M.advancedItemTooltips;
                minecraft._M.saveOptions();
            }
            if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown(61) && minecraft._t.capabilities._d) {
                boolean bl = RenderManager._r = !RenderManager._r;
            }
            if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown(61)) {
                minecraft._M.pauseOnLostFocus = !minecraft._M.pauseOnLostFocus;
                minecraft._M.saveOptions();
            }
            if (Keyboard.getEventKey() == 59) {
                minecraft._M.hideGUI = !minecraft._M.hideGUI;
                boolean bl = _a = !Keyboard.isKeyDown(29);
            }
            if (Keyboard.getEventKey() == 61) {
                minecraft._M.showDebugInfo = !minecraft._M.showDebugInfo;
                minecraft._M.showDebugProfilerChart = GuiScreen.isShiftKeyDown();
            }
            if (Keyboard.getEventKey() == 63) {
                ++minecraft._M.thirdPersonView;
                if (minecraft._M.thirdPersonView > 2) {
                    minecraft._M.thirdPersonView = 0;
                }
            }
            if (Keyboard.getEventKey() == 66) {
                minecraft._M.smoothCamera = !minecraft._M.smoothCamera;
            }
            for (n = 0; n < GloomyCore.instance.containerFactory._b(); ++n) {
                if (Keyboard.getEventKey() != 2 + n || MinecraftForge.EVENT_BUS.post(new anrg(minecraft._t.inventory._c, n, true))) continue;
                minecraft._t.inventory._c = n;
            }
            if (minecraft._M.showDebugInfo && minecraft._M.showDebugProfilerChart) {
                if (Keyboard.getEventKey() == 11) {
                    minecraft._a(0);
                }
                for (n = 0; n < 9; ++n) {
                    if (Keyboard.getEventKey() != 2 + n) continue;
                    minecraft._a(n + 1);
                }
            }
            EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
            boolean bl = Keyboard.isKeyDown(42);
            boolean bl2 = Keyboard.isKeyDown(29);
            if (!entityClientPlayerMP.capabilities._d || !bl2 || Keyboard.getEventKey() != 46) continue;
            String string = null;
            if (bl) {
                RegionsGameHandler regionsGameHandler = RegionsMod.regionsClient;
                if (regionsGameHandler.min != null && regionsGameHandler.max != null) {
                    einh einh2 = regionsGameHandler.min;
                    einh einh3 = regionsGameHandler.max;
                    string = einh2._c() + ", " + einh2._d() + ", " + einh2._e() + ", " + einh3._c() + ", " + einh3._d() + ", " + einh3._e();
                }
            } else {
                int n2 = (int)entityClientPlayerMP.posX;
                int n3 = (int)entityClientPlayerMP.boundingBox._c;
                int n4 = (int)entityClientPlayerMP.posZ;
                string = n2 + ".5, " + n3 + ", " + n4 + ".5";
            }
            if (string == null) continue;
            ClientProxy.publishScreenCenterMessage(new ntsy("\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u043d\u043e: " + string, -1, 30));
            GuiScreen.setClipboardString(string);
        }
    }
}

