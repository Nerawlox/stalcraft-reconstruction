/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui;

import com.mcf.davidee.paintinggui.PaintingSelectionMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandPainting
extends ohnk {
    @Override
    public String func_71517_b() {
        return "painting";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/painting";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP)nemo2;
        entityPlayerMP.field_71135_a.func_72567_b(PaintingSelectionMod.createPacket(-1, new String[0]));
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return nemo2 instanceof EntityPlayer;
    }
}

