/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.lang;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;

public class LangUtil {
    public static LangUtil instance = new LangUtil(null);
    public String prefix;

    public LangUtil(String string) {
        this.prefix = string;
    }

    public static String translateG(String string, Object ... objectArray) {
        return instance.translate(string, objectArray);
    }

    public String translate(String string, Object ... objectArray) {
        String string2;
        if (this.prefix != null && !string.startsWith(this.prefix + ".")) {
            string = this.prefix + "." + string;
        }
        if ((string2 = LanguageRegistry.instance().getStringLocalization(string)).length() == 0) {
            string2 = LanguageRegistry.instance().getStringLocalization(string, "en_US");
        }
        if (string2.length() == 0) {
            string2 = tdpx._a(string);
        }
        if (string2.length() == 0) {
            return string;
        }
        if (objectArray.length > 0) {
            string2 = String.format(string2, objectArray);
        }
        return string2;
    }

    public void addLangFile(InputStream inputStream, String string) throws IOException {
        String string2;
        LanguageRegistry languageRegistry = LanguageRegistry.instance();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((string2 = bufferedReader.readLine()) != null) {
            int n = string2.indexOf(61);
            if (n == -1) continue;
            String string3 = string2.substring(0, n);
            String string4 = string2.substring(n + 1);
            if (this.prefix != null) {
                string3 = this.prefix + "." + string3;
            }
            languageRegistry.addStringLocalization(string3, string, string4);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static LangUtil loadLangDir(String string) {
        return new LangUtil(string).addLangDir(new ResourceLocation(string, "lang"));
    }

    @SideOnly(value=Side.CLIENT)
    public LangUtil addLangDir(ResourceLocation resourceLocation) {
        xsfs xsfs2 = xpzm._E()._S();
        for (zhkm zhkm2 : xpzm._E()._U()._d()) {
            htyg htyg2;
            String string = zhkm2._a();
            try {
                htyg2 = xsfs2._a(new ResourceLocation(resourceLocation.func_110624_b(), resourceLocation.func_110623_a() + '/' + string + ".lang"));
            }
            catch (Exception exception) {
                continue;
            }
            try {
                this.addLangFile(htyg2._a(), string);
            }
            catch (IOException iOException) {
                System.err.println("Failed to load lang resource. domain=" + this.prefix + ", resource=" + htyg2);
                iOException.printStackTrace();
            }
        }
        return this;
    }
}

