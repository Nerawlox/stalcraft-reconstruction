/*
 * Decompiled with CFR 0.152.
 */
package mods.pda;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.client.gui.achievement.GuiAchievement;

public class AchievementHooks {
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void updateAchievementWindow(GuiAchievement guiAchievement) {
    }
}

