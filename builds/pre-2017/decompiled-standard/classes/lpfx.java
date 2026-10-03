/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class lpfx
extends ohnk {
    public long _a;
    public int _b;

    @Override
    public String func_71517_b() {
        return "debug";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.debug.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            if (stringArray[0].equals("start")) {
                lpfx.func_71522_a(nemo2, "commands.debug.start", new Object[0]);
                dzfd._I().__al();
                this._a = dzfd.__aq();
                this._b = dzfd._I().__ak();
                return;
            }
            if (stringArray[0].equals("stop")) {
                if (!dzfd._I()._g._c) {
                    throw new cekk("commands.debug.notStarted", new Object[0]);
                }
                long l = dzfd.__aq();
                int n = dzfd._I().__ak();
                long l2 = l - this._a;
                int n2 = n - this._b;
                this._a(l2, n2);
                dzfd._I()._g._c = false;
                lpfx.func_71522_a(nemo2, "commands.debug.stop", Float.valueOf((float)l2 / 1000.0f), n2);
                return;
            }
        }
        throw new pksd("commands.debug.usage", new Object[0]);
    }

    public void _a(long l, int n) {
        File file = new File(dzfd._I()._i("debug"), "profile-results-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + ".txt");
        file.getParentFile().mkdirs();
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(this._b(l, n));
            fileWriter.close();
        }
        catch (Throwable throwable) {
            dzfd._I()._O()._b("Could not save profiler results to " + file, throwable);
        }
    }

    public String _b(long l, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---- Minecraft Profiler Results ----\n");
        stringBuilder.append("// ");
        stringBuilder.append(lpfx._a());
        stringBuilder.append("\n\n");
        stringBuilder.append("Time span: ").append(l).append(" ms\n");
        stringBuilder.append("Tick span: ").append(n).append(" ticks\n");
        stringBuilder.append("// This is approximately ").append(String.format("%.2f", Float.valueOf((float)n / ((float)l / 1000.0f)))).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
        stringBuilder.append("--- BEGIN PROFILE DUMP ---\n\n");
        this._a(0, "root", stringBuilder);
        stringBuilder.append("--- END PROFILE DUMP ---\n\n");
        return stringBuilder.toString();
    }

    public void _a(int n, String string, StringBuilder stringBuilder) {
        List list2 = dzfd._I()._g._b(string);
        if (list2 == null || list2.size() < 3) {
            return;
        }
        for (int i = 1; i < list2.size(); ++i) {
            qojt qojt2 = (qojt)list2.get(i);
            stringBuilder.append(String.format("[%02d] ", n));
            for (int j = 0; j < n; ++j) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(qojt2._c);
            stringBuilder.append(" - ");
            stringBuilder.append(String.format("%.2f", qojt2._a));
            stringBuilder.append("%/");
            stringBuilder.append(String.format("%.2f", qojt2._b));
            stringBuilder.append("%\n");
            if (qojt2._c.equals("unspecified")) continue;
            try {
                this._a(n + 1, string + "." + qojt2._c, stringBuilder);
                continue;
            }
            catch (Exception exception) {
                stringBuilder.append("[[ EXCEPTION " + exception + " ]]");
            }
        }
    }

    public static String _a() {
        String[] stringArray = new String[]{"Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server."};
        try {
            return stringArray[(int)(System.nanoTime() % (long)stringArray.length)];
        }
        catch (Throwable throwable) {
            return "Witty comment unavailable :(";
        }
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return lpfx.func_71530_a(stringArray, "start", "stop");
        }
        return null;
    }
}

