/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.stalkerguide;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import java.io.DataInputStream;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.player.GuiDialogTalk;
import noppes.npcs.client.gui.player.GuiQuestCompleted;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;
import znw.mods.stalkerguide.StalkerguideMod;

public class pidb {
    private static float _a = 0.0f;

    @ezey(_a={eidj.CLIENT})
    @Hook
    public static void _a(gloomyfolken.mods.weapon.pidb pidb2, Entity entity, EntityTracer.kjui kjui2, Vec3 vec3, float f) {
        if (entity instanceof EntityNPCInterface && entity.getEntityName().equalsIgnoreCase(mcne._f)) {
            StalkerguideMod._b._a();
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean _a() {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        return entityClientPlayerMP != null && !entityClientPlayerMP.capabilities._d && StalkerguideMod._b._d;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook
    public static void _a(GuiQuestCompleted guiQuestCompleted) {
        StalkerguideMod._b._a(6);
    }

    @ezey(_a={eidj.CLIENT})
    @Hook
    public static void _a(EntityRenderer entityRenderer, float f, long l) {
        _a = f;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook
    public static void _a(fokl fokl2, String string) {
        if ("camera".equals(string) && ihco._b != null) {
            ihco._b._a(_a);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(KeyBinding keyBinding, int n, boolean bl) {
        KeyBinding keyBinding2 = (KeyBinding)KeyBinding._b._b(n);
        if (keyBinding2 != null && bl) {
            ihfz._c._b(keyBinding2);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(GuiContainer guiContainer, int n, int n2, float f) {
        if (pidb._a() && guiContainer instanceof nuis) {
            StalkerguideMod._b._a((nuis)guiContainer, n, n2, f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void _a(loij loij2, int n, int n2, int n3) {
        if (pidb._a()) {
            StalkerguideMod._b._a(5);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE, targetMethod="<init>")
    public static boolean _b(loij loij2, int n, int n2, int n3) {
        if (pidb._a()) {
            thfd thfd2 = StalkerguideMod._b._b._i();
            return thfd2 == null || !"ejection".equalsIgnoreCase(thfd2._b());
        }
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean _a(NoppesUtil noppesUtil, EntityPlayer entityPlayer, NBTTagCompound nBTTagCompound) {
        if (pidb._a()) {
            thfd thfd2 = StalkerguideMod._b._b._i();
            return thfd2 == null || !thfd2._b().equalsIgnoreCase("questEnd");
        }
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean _a(NoppesUtil noppesUtil, DataInputStream dataInputStream, EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) throws IOException {
        if (pidb._a()) {
            thfd thfd2 = StalkerguideMod._b._b._i();
            if (DialogController.instance == null) {
                DialogController.instance = new DialogController();
            }
            NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
            Dialog dialog = new Dialog();
            dialog.readNBT(nBTTagCompound);
            mcqq mcqq2 = StalkerguideMod._b._c;
            if (dialog.title.equals(mcqq2._c) && (thfd2 == null || !"questLog".equalsIgnoreCase(thfd2._b()) && !"waypoints".equalsIgnoreCase(thfd2._b()))) {
                return true;
            }
            if (dialog.title.equals(mcqq2._d) && (thfd2 == null || !"waypoints".equalsIgnoreCase(thfd2._b()))) {
                return true;
            }
            Minecraft minecraft = Minecraft._E();
            if (minecraft._B instanceof GuiDialogTalk) {
                ((GuiDialogTalk)minecraft._B).handleDialog(dialog);
            } else {
                NoppesUtil.openChainedGUI(new GuiDialogTalk(entityNPCInterface, dialog));
            }
            return true;
        }
        return false;
    }
}

