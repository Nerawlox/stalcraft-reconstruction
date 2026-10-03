/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AchievementPage {
    private String name;
    private LinkedList<nfcl> achievements;
    private static LinkedList<AchievementPage> achievementPages = new LinkedList();

    public AchievementPage(String string, nfcl ... nfclArray) {
        this.name = string;
        this.achievements = new LinkedList<nfcl>(Arrays.asList(nfclArray));
    }

    public String getName() {
        return this.name;
    }

    public List<nfcl> getAchievements() {
        return this.achievements;
    }

    public static void registerAchievementPage(AchievementPage achievementPage) {
        if (AchievementPage.getAchievementPage(achievementPage.getName()) != null) {
            throw new RuntimeException("Duplicate achievement page name \"" + achievementPage.getName() + "\"!");
        }
        achievementPages.add(achievementPage);
    }

    public static AchievementPage getAchievementPage(int n) {
        return achievementPages.get(n);
    }

    public static AchievementPage getAchievementPage(String string) {
        for (AchievementPage achievementPage : achievementPages) {
            if (!achievementPage.getName().equals(string)) continue;
            return achievementPage;
        }
        return null;
    }

    public static Set<AchievementPage> getAchievementPages() {
        return new HashSet<AchievementPage>(achievementPages);
    }

    public static boolean isAchievementInPages(nfcl nfcl2) {
        for (AchievementPage achievementPage : achievementPages) {
            if (!achievementPage.getAchievements().contains(nfcl2)) continue;
            return true;
        }
        return false;
    }

    public static String getTitle(int n) {
        return n == -1 ? "Minecraft" : AchievementPage.getAchievementPage(n).getName();
    }
}

