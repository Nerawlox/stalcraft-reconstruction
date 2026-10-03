/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.PrivateAccessException;
import eu.ha3.mc.haddon.Utility;
import eu.ha3.mc.haddon.implem.HaddonPrivateEntry;
import eu.ha3.mc.haddon.implem.HaddonUtilitySingleton;
import eu.ha3.mc.haddon.implem.PrivateEntry;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public abstract class HaddonUtilityImpl
implements Utility {
    private static final int WORLD_HEIGHT = 256;
    private Map<String, PrivateEntry> getters = new HashMap<String, PrivateEntry>();
    private Map<String, PrivateEntry> setters = new HashMap<String, PrivateEntry>();
    protected long ticksRan;
    protected File modsFolder;
    private htou drawString_scaledRes = null;
    private int drawString_screenWidth;
    private int drawString_screenHeight;
    private int drawString_textHeight;

    public HaddonUtilityImpl() {
        HaddonUtilitySingleton.getInstance();
    }

    @Override
    public void registerPrivateGetter(String string, Class clazz, int n, String ... stringArray) {
        this.getters.put(string, new HaddonPrivateEntry(string, clazz, n, stringArray));
    }

    @Override
    public void registerPrivateSetter(String string, Class clazz, int n, String ... stringArray) {
        this.setters.put(string, new HaddonPrivateEntry(string, clazz, n, stringArray));
    }

    @Override
    public Object getPrivate(Object object, String string) throws PrivateAccessException {
        return this.getters.get(string).get(object);
    }

    @Override
    public void setPrivate(Object object, String string, Object object2) throws PrivateAccessException {
        this.setters.get(string).set(object, object2);
    }

    @Override
    public Object getPrivateValue(Class clazz, Object object, int n) throws PrivateAccessException {
        return HaddonUtilitySingleton.getInstance().getPrivateValue(clazz, object, n);
    }

    @Override
    public void setPrivateValue(Class clazz, Object object, int n, Object object2) throws PrivateAccessException {
        HaddonUtilitySingleton.getInstance().setPrivateValue(clazz, object, n, object2);
    }

    @Override
    public Object getPrivateValueLiteral(Class clazz, Object object, String string, int n) throws PrivateAccessException {
        Object object2;
        try {
            object2 = HaddonUtilitySingleton.getInstance().getPrivateValueViaName(clazz, object, string);
        }
        catch (Exception exception) {
            object2 = HaddonUtilitySingleton.getInstance().getPrivateValue(clazz, object, n);
        }
        return object2;
    }

    @Override
    public void setPrivateValueLiteral(Class clazz, Object object, String string, int n, Object object2) throws PrivateAccessException {
        try {
            HaddonUtilitySingleton.getInstance().setPrivateValueViaName(clazz, object, string, object2);
        }
        catch (PrivateAccessException privateAccessException) {
            HaddonUtilitySingleton.getInstance().setPrivateValue(clazz, object, n, object2);
        }
    }

    @Override
    public int getWorldHeight() {
        return 256;
    }

    @Override
    public Object getCurrentScreen() {
        return Minecraft._E()._B;
    }

    @Override
    public boolean isCurrentScreen(Class clazz) {
        Object object = this.getCurrentScreen();
        if (clazz == null) {
            return object == null;
        }
        if (object == null) {
            return false;
        }
        return clazz.isInstance(object);
    }

    @Override
    public void closeCurrentScreen() {
        Minecraft._E()._a((GuiScreen)null);
    }

    @Override
    public void printChat(Object ... objectArray) {
        if (Minecraft._E()._t == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : objectArray) {
            stringBuilder.append(object);
        }
        Minecraft._E()._t.addChatMessage(stringBuilder.toString());
    }

    @Override
    public boolean areKeysDown(int ... nArray) {
        for (int n : nArray) {
            if (Keyboard.isKeyDown(n)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void prepareDrawString() {
        Minecraft minecraft = Minecraft._E();
        this.drawString_scaledRes = new htou(minecraft._M, minecraft._n, minecraft._o);
        this.drawString_screenWidth = this.drawString_scaledRes._a();
        this.drawString_screenHeight = this.drawString_scaledRes._b();
        this.drawString_textHeight = minecraft._z._c;
    }

    @Override
    public void drawString(String string, float f, float f2, int n, int n2, char c, int n3, int n4, int n5, int n6, boolean bl) {
        if (this.drawString_scaledRes == null) {
            this.prepareDrawString();
        }
        Minecraft minecraft = Minecraft._E();
        int n7 = (int)Math.floor(f * (float)this.drawString_screenWidth) + n;
        int n8 = (int)Math.floor(f2 * (float)this.drawString_screenHeight) + n2;
        if (c == '2' || c == '5' || c == '8') {
            n7 -= minecraft._z._b(string) / 2;
        } else if (c == '3' || c == '6' || c == '9') {
            n7 -= minecraft._z._b(string);
        }
        if (c == '4' || c == '5' || c == '6') {
            n8 -= this.drawString_textHeight / 2;
        } else if (c == '1' || c == '2' || c == '3') {
            n8 -= this.drawString_textHeight;
        }
        int n9 = n6 << 24 | n3 << 16 | n4 << 8 | n5;
        if (bl) {
            Minecraft._E()._z._a(string, n7, n8, n9);
        } else {
            Minecraft._E()._z._b(string, n7, n8, n9);
        }
    }

    @Override
    public File getModsFolder() {
        if (this.modsFolder != null) {
            return this.modsFolder;
        }
        this.modsFolder = new File(Minecraft._E()._P, "mods");
        return this.modsFolder;
    }
}

