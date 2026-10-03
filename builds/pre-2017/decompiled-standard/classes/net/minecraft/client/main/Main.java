/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.main;

import gloomyfolken.mods.asm.GloomyStartHooks;
import java.io.File;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.minecraft.client.main.kjui;
import net.minecraft.client.main.pidb;
import net.minecraft.client.xpzm;
import net.minecraft.util.hanr;

public class Main {
    public static void main(String[] stringArray) {
        GloomyStartHooks.main(null, stringArray);
        System.setProperty("java.net.preferIPv4Stack", "true");
        OptionParser optionParser = new OptionParser();
        optionParser.allowsUnrecognizedOptions();
        optionParser.accepts("demo");
        optionParser.accepts("fullscreen");
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec = optionParser.accepts("server").withRequiredArg();
        ArgumentAcceptingOptionSpec<Integer> argumentAcceptingOptionSpec2 = optionParser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(25565, (Integer[])new Integer[0]);
        ArgumentAcceptingOptionSpec<File> argumentAcceptingOptionSpec3 = optionParser.accepts("gameDir").withRequiredArg().ofType(File.class).defaultsTo(new File("."), (File[])new File[0]);
        ArgumentAcceptingOptionSpec<File> argumentAcceptingOptionSpec4 = optionParser.accepts("assetsDir").withRequiredArg().ofType(File.class);
        ArgumentAcceptingOptionSpec<File> argumentAcceptingOptionSpec5 = optionParser.accepts("resourcePackDir").withRequiredArg().ofType(File.class);
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec6 = optionParser.accepts("proxyHost").withRequiredArg();
        ArgumentAcceptingOptionSpec<Integer> argumentAcceptingOptionSpec7 = optionParser.accepts("proxyPort").withRequiredArg().defaultsTo("8080", (String[])new String[0]).ofType(Integer.class);
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec8 = optionParser.accepts("proxyUser").withRequiredArg();
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec9 = optionParser.accepts("proxyPass").withRequiredArg();
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec10 = optionParser.accepts("username").withRequiredArg().defaultsTo("Player" + xpzm._M() % 1000L, (String[])new String[0]);
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec11 = optionParser.accepts("session").withRequiredArg();
        ArgumentAcceptingOptionSpec<String> argumentAcceptingOptionSpec12 = optionParser.accepts("version").withRequiredArg().required();
        ArgumentAcceptingOptionSpec<Integer> argumentAcceptingOptionSpec13 = optionParser.accepts("width").withRequiredArg().ofType(Integer.class).defaultsTo(854, (Integer[])new Integer[0]);
        ArgumentAcceptingOptionSpec<Integer> argumentAcceptingOptionSpec14 = optionParser.accepts("height").withRequiredArg().ofType(Integer.class).defaultsTo(480, (Integer[])new Integer[0]);
        NonOptionArgumentSpec<String> nonOptionArgumentSpec = optionParser.nonOptions();
        OptionSet optionSet = optionParser.parse(stringArray);
        List<String> list2 = optionSet.valuesOf(nonOptionArgumentSpec);
        String string = optionSet.valueOf(argumentAcceptingOptionSpec6);
        Proxy proxy = Proxy.NO_PROXY;
        if (string != null) {
            try {
                proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(string, (int)optionSet.valueOf(argumentAcceptingOptionSpec7)));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        String string2 = optionSet.valueOf(argumentAcceptingOptionSpec8);
        String string3 = optionSet.valueOf(argumentAcceptingOptionSpec9);
        if (!proxy.equals(Proxy.NO_PROXY) && Main.func_110121_a(string2) && Main.func_110121_a(string3)) {
            Authenticator.setDefault(new kjui(string2, string3));
        }
        int n = optionSet.valueOf(argumentAcceptingOptionSpec13);
        int n2 = optionSet.valueOf(argumentAcceptingOptionSpec14);
        boolean bl = optionSet.has("fullscreen");
        boolean bl2 = optionSet.has("demo");
        String string4 = optionSet.valueOf(argumentAcceptingOptionSpec12);
        File file = optionSet.valueOf(argumentAcceptingOptionSpec3);
        File file2 = optionSet.has(argumentAcceptingOptionSpec4) ? optionSet.valueOf(argumentAcceptingOptionSpec4) : new File(file, "assets/");
        File file3 = optionSet.has(argumentAcceptingOptionSpec5) ? optionSet.valueOf(argumentAcceptingOptionSpec5) : new File(file, "resourcepacks/");
        hanr hanr2 = new hanr((String)argumentAcceptingOptionSpec10.value(optionSet), (String)argumentAcceptingOptionSpec11.value(optionSet));
        xpzm xpzm2 = new xpzm(hanr2, n, n2, bl, bl2, file, file2, file3, proxy, string4);
        String string5 = optionSet.valueOf(argumentAcceptingOptionSpec);
        if (string5 != null) {
            xpzm2._a(string5, (int)optionSet.valueOf(argumentAcceptingOptionSpec2));
        }
        Runtime.getRuntime().addShutdownHook(new pidb());
        if (!list2.isEmpty()) {
            System.out.println("Completely ignored arguments: " + list2);
        }
        Thread.currentThread().setName("Minecraft main thread");
        xpzm2._i();
    }

    public static boolean func_110121_a(String string) {
        return string != null && !string.isEmpty();
    }
}

