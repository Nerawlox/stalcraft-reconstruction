/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.jxtc;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;

public class FakePlayer
extends EntityPlayerMP {
    public FakePlayer(ozlu ozlu2, String string) {
        super(FMLCommonHandler.instance().getMinecraftServerInstance(), ozlu2, string, new mbsl(ozlu2));
    }

    public void sendChatToPlayer(String string) {
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return false;
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(0, 0, 0);
    }

    @Override
    public void func_70006_a(zwat zwat2) {
    }

    @Override
    public void func_71064_a(rann rann2, int n) {
    }

    @Override
    public void openGui(Object object, int n, ozlu ozlu2, int n2, int n3, int n4) {
    }

    @Override
    public boolean func_85032_ar() {
        return true;
    }

    @Override
    public boolean func_96122_a(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
    }

    @Override
    public void func_70071_h_() {
    }

    @Override
    public void func_71027_c(int n) {
    }

    @Override
    public void func_71125_a(grje grje2) {
    }
}

