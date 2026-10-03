/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.ClientHandler;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.config.Option;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public abstract class DataDumper
extends Option {
    public DataDumper(String string) {
        super(string);
    }

    public abstract String[] header();

    public abstract Iterable<String[]> dump(int var1);

    public String renderName() {
        return this.translateN(this.name + "s", new Object[0]);
    }

    public void dumpFile() {
        try {
            File file = new File(xpzm._E()._P, "dumps/" + this.getFileName(this.name.replaceFirst(".+\\.", "")));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            this.dumpTo(file);
            NEIClientUtils.addChatMessage(this.dumpMessage(file));
        }
        catch (Exception exception) {
            System.err.println("Error dumping " + this.renderName() + " mode: " + this.getMode());
            exception.printStackTrace();
        }
    }

    public String getFileName(String string) {
        return string + ".csv";
    }

    public String dumpMessage(File file) {
        return ClientHandler.lang.translate("options.tools.dump.dumped", this.translateN(this.name, new Object[0]), "dumps/" + file.getName());
    }

    public void dumpTo(File file) throws IOException {
        int n = this.getMode();
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(DataDumper.concat(this.header()));
        for (String[] stringArray : this.dump(n)) {
            printWriter.println(DataDumper.concat(stringArray));
        }
        printWriter.close();
    }

    public static String concat(String[] stringArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : stringArray) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(',');
            }
            if (string == null) {
                string = "null";
            }
            if (string.indexOf(44) > 0 || string.indexOf(34) > 0) {
                string = '\"' + string.replace("\"", "\"\"") + '\"';
            }
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    @Override
    public void draw(int n, int n2, float f) {
        this.drawPrefix();
        this.drawModeButton(n, n2);
        this.drawDumpButton(n, n2);
    }

    public void drawPrefix() {
        GuiDraw.drawString(this.renderName(), 10, 8, -1);
    }

    public Rectangle4i dumpButtonSize() {
        int n = 80;
        return new Rectangle4i(this.slot.contentWidth() - n, 2, n, 20);
    }

    public Rectangle4i modeButtonSize() {
        int n = 60;
        return new Rectangle4i(this.slot.contentWidth() - n - 10 - this.dumpButtonSize().w, 2, n, 20);
    }

    public String dumpButtonText() {
        return ClientHandler.lang.translate("options.tools.dump.dump", new Object[0]);
    }

    public String modeButtonText() {
        return ClientHandler.lang.translate("options.tools.dump.mode." + this.getMode(), new Object[0]);
    }

    public int getMode() {
        return this.getTag().getIntValue(0);
    }

    public void drawModeButton(int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Rectangle4i rectangle4i = this.modeButtonSize();
        boolean bl = rectangle4i.contains(n, n2);
        LayoutManager.drawButtonBackground(rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, true, this.getButtonTex(bl));
        GuiDraw.drawStringC(this.modeButtonText(), rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, this.getTextColour(bl));
    }

    public void drawDumpButton(int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Rectangle4i rectangle4i = this.dumpButtonSize();
        boolean bl = rectangle4i.contains(n, n2);
        LayoutManager.drawButtonBackground(rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, true, this.getButtonTex(bl));
        GuiDraw.drawStringC(this.dumpButtonText(), rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, this.getTextColour(bl));
    }

    public int getButtonTex(boolean bl) {
        return bl ? 2 : 1;
    }

    public int getTextColour(boolean bl) {
        return bl ? -96 : -2039584;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.modeButtonSize().contains(n, n2)) {
            xpzm._E()._N._a("random.click", 1.0f, 1.0f);
            this.getTag().setIntValue((this.getMode() + 1) % this.modeCount());
        } else if (this.dumpButtonSize().contains(n, n2)) {
            xpzm._E()._N._a("random.click", 1.0f, 1.0f);
            this.dumpFile();
        }
    }

    public int modeCount() {
        return 3;
    }
}

