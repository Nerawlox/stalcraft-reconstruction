/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.money.zwat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.item.ItemStack;
import noppes.npcs.constants.EnumQuestType;

public class QuestLogUnit {
    private static final Pattern localKeysPattern = Pattern.compile("\\{(.*?)\\}");
    private int questId;
    private String questTitle;
    private String questText;
    private EnumQuestType type;
    private List<String> statuses;
    private boolean completed;
    private boolean primary;
    private List<Long> reward = new ArrayList<Long>();
    private transient List<String> localizedStatuses;
    private transient List<ItemStack> rewardItems;
    private transient long rewardMoney = -1L;

    public QuestLogUnit(int n, String string, String string2, EnumQuestType enumQuestType, List<String> list2, boolean bl, boolean bl2) {
        this.questId = n;
        this.questTitle = string;
        this.questText = string2;
        this.type = enumQuestType;
        this.statuses = list2;
        this.completed = bl;
        this.primary = bl2;
    }

    @ezey(_a={eidj.CLIENT})
    public List<String> getLocalizedStatuses() {
        if (this.localizedStatuses == null) {
            this.localizedStatuses = new ArrayList<String>();
            for (String string : this.statuses) {
                Matcher matcher = localKeysPattern.matcher(string);
                StringBuilder stringBuilder = new StringBuilder(string);
                int n = 0;
                while (matcher.find()) {
                    String string2 = string.substring(matcher.start(), matcher.end());
                    String string3 = wpcz._a(string2.substring(1, string2.length() - 1)).trim();
                    int n2 = matcher.start() + n;
                    int n3 = matcher.end() + n;
                    int n4 = stringBuilder.length();
                    stringBuilder.replace(n2, n3, string3);
                    n += stringBuilder.length() - n4;
                }
                this.localizedStatuses.add(stringBuilder.toString());
            }
        }
        return this.localizedStatuses;
    }

    public List<ItemStack> getRewardItems() {
        if (this.rewardItems == null) {
            this.rewardItems = new ArrayList<ItemStack>();
            this.rewardMoney = 0L;
            for (Long l : this.reward) {
                int n;
                int n2 = (int)(l >>> 32);
                int n3 = (int)(l >>> 16 & 0xFFFFL);
                ItemStack itemStack = new ItemStack(n3, n2, n = (int)(l & 0xFFFFL));
                long l2 = zwat._a(itemStack);
                if (l2 > 0L) {
                    this.rewardMoney += l2;
                    continue;
                }
                this.rewardItems.add(itemStack);
            }
        }
        return this.rewardItems;
    }

    public long getRewardMoney() {
        if (this.rewardMoney == -1L) {
            this.getRewardItems();
        }
        return this.rewardMoney;
    }

    public List<Long> getReward() {
        return this.reward;
    }

    public void setReward(List<Long> list2) {
        this.reward = list2;
    }

    public EnumQuestType getType() {
        return this.type;
    }

    public String getQuestText() {
        return this.questText;
    }

    public int getQuestId() {
        return this.questId;
    }

    public String getQuestTitle() {
        return this.questTitle;
    }

    public List<String> getStatuses() {
        return this.statuses;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean isPrimary() {
        return this.primary;
    }
}

