/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ru.stalcraft.Logger;

public class SmartMovingHelper {
    public final boolean isSmartmovingEnabled;
    private Class smartMovingFactoryClazz;
    private Method getInstanceMethod;
    private Class smartMovingClazz;
    private Field isFastField;

    public SmartMovingHelper() {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            boolean classNotFound = false;
            try {
                this.checkSmClasses();
                Logger.console("SmartMoving found");
            }
            catch (Exception var3) {
                classNotFound = true;
                Logger.console("SmartMoving not found");
            }
            this.isSmartmovingEnabled = !classNotFound;
        } else {
            this.isSmartmovingEnabled = false;
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void checkSmClasses() throws Exception {
        this.smartMovingFactoryClazz = Class.forName("net.smart.moving.SmartMovingFactory", true, this.getClass().getClassLoader());
        this.smartMovingClazz = Class.forName("net.smart.moving.SmartMoving", true, this.getClass().getClassLoader());
        this.getInstanceMethod = this.smartMovingFactoryClazz.getDeclaredMethod("getInstance", uf.class);
        this.isFastField = this.smartMovingClazz.getDeclaredField("isFast");
    }

    public boolean isPlayerRunning(uf player) {
        if (!this.isSmartmovingEnabled) {
            return player.ai();
        }
        boolean isSmartmovingRunner = false;
        try {
            Object e2 = this.getInstanceMethod.invoke(null, player);
            isSmartmovingRunner = this.isFastField.getBoolean(e2);
        }
        catch (Exception var4) {
            var4.printStackTrace();
        }
        return isSmartmovingRunner || player.ai();
    }
}

