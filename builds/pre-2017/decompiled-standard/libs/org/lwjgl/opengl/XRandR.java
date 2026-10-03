/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.lwjgl.LWJGLUtil;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class XRandR {
    private static Screen[] current;
    private static Map<String, Screen[]> screens;
    private static final Pattern SCREEN_PATTERN1;
    private static final Pattern SCREEN_PATTERN2;

    private static void populate() {
        if (screens == null) {
            screens = new HashMap<String, Screen[]>();
            try {
                String line;
                Process p = Runtime.getRuntime().exec(new String[]{"xrandr", "-q"});
                ArrayList<Screen> currentList = new ArrayList<Screen>();
                ArrayList<Screen> possibles = new ArrayList<Screen>();
                String name2 = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((line = br.readLine()) != null) {
                    String[] sa = (line = line.trim()).split("\\s+");
                    if ("connected".equals(sa[1])) {
                        if (name2 != null) {
                            screens.put(name2, possibles.toArray(new Screen[possibles.size()]));
                            possibles.clear();
                        }
                        name2 = sa[0];
                        XRandR.parseScreen(currentList, name2, sa[2]);
                        continue;
                    }
                    if (!Pattern.matches("\\d*x\\d*", sa[0])) continue;
                    XRandR.parseScreen(possibles, name2, sa[0]);
                }
                screens.put(name2, possibles.toArray(new Screen[possibles.size()]));
                current = currentList.toArray(new Screen[currentList.size()]);
            }
            catch (Throwable e) {
                LWJGLUtil.log("Exception in XRandR.populate(): " + e.getMessage());
                screens.clear();
                current = new Screen[0];
            }
        }
    }

    public static Screen[] getConfiguration() {
        XRandR.populate();
        return (Screen[])current.clone();
    }

    public static void setConfiguration(Screen ... screens) {
        if (screens.length == 0) {
            throw new IllegalArgumentException("Must specify at least one screen");
        }
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("xrandr");
        for (Screen screen : current) {
            boolean found = false;
            for (Screen screen1 : screens) {
                if (!screen1.name.equals(screen.name)) continue;
                found = true;
                break;
            }
            if (found) continue;
            cmd.add("--output");
            cmd.add(screen.name);
            cmd.add("--off");
        }
        for (Screen screen : screens) {
            screen.getArgs(cmd);
        }
        try {
            String line;
            Process p = Runtime.getRuntime().exec(cmd.toArray(new String[cmd.size()]));
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = br.readLine()) != null) {
                LWJGLUtil.log("Unexpected output from xrandr process: " + line);
            }
            current = screens;
        }
        catch (IOException e) {
            LWJGLUtil.log("XRandR exception in setConfiguration(): " + e.getMessage());
        }
    }

    public static String[] getScreenNames() {
        XRandR.populate();
        return screens.keySet().toArray(new String[screens.size()]);
    }

    public static Screen[] getResolutions(String name2) {
        XRandR.populate();
        return (Screen[])screens.get(name2).clone();
    }

    private static void parseScreen(List<Screen> list, String name2, String what) {
        int ypos;
        int xpos;
        Matcher m = SCREEN_PATTERN1.matcher(what);
        if (!m.matches() && !(m = SCREEN_PATTERN2.matcher(what)).matches()) {
            LWJGLUtil.log("Did not match: " + what);
            return;
        }
        int width = Integer.parseInt(m.group(1));
        int height = Integer.parseInt(m.group(2));
        if (m.groupCount() > 3) {
            xpos = Integer.parseInt(m.group(3));
            ypos = Integer.parseInt(m.group(4));
        } else {
            xpos = 0;
            ypos = 0;
        }
        list.add(new Screen(name2, width, height, xpos, ypos));
    }

    static {
        SCREEN_PATTERN1 = Pattern.compile("^(\\d+)x(\\d+)\\+(\\d+)\\+(\\d+)$");
        SCREEN_PATTERN2 = Pattern.compile("^(\\d+)x(\\d+)$");
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Screen
    implements Cloneable {
        public final String name;
        public final int width;
        public final int height;
        public int xPos;
        public int yPos;

        private Screen(String name2, int width, int height, int xPos, int yPos) {
            this.name = name2;
            this.width = width;
            this.height = height;
            this.xPos = xPos;
            this.yPos = yPos;
        }

        private void getArgs(List<String> argList) {
            argList.add("--output");
            argList.add(this.name);
            argList.add("--mode");
            argList.add(this.width + "x" + this.height);
            argList.add("--pos");
            argList.add(this.xPos + "x" + this.yPos);
        }

        public String toString() {
            return this.name + " " + this.width + "x" + this.height + " @ " + this.xPos + "x" + this.yPos;
        }
    }
}

