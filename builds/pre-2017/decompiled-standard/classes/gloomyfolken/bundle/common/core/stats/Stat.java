/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core.stats;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.StatsDisplayer;
import gloomyfolken.bundle.common.core.stats.StatsType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;

public class Stat {
    public static final Map<String, Stat> statRegistry = new LinkedHashMap<String, Stat>();
    public static final Map<Stat, BiPredicate<EntityPlayer, jxtc>> playerDeathIncrementProcessor = new HashMap<Stat, BiPredicate<EntityPlayer, jxtc>>();
    public static final Map<Stat, BiConsumer<EntityPlayer, jxtc>> playerDeathProcessor = new HashMap<Stat, BiConsumer<EntityPlayer, jxtc>>();
    public static final Map<Stat, BiPredicate<EntityLivingBase, jxtc>> playerKillIncrementProcessor = new HashMap<Stat, BiPredicate<EntityLivingBase, jxtc>>();
    public static final Map<Class<? extends EntityLivingBase>, Stat> incrementOnEntityKilled = new HashMap<Class<? extends EntityLivingBase>, Stat>();
    public static final Map<Stat, Predicate<EntityPlayer>> timeCounterProcess = new HashMap<Stat, Predicate<EntityPlayer>>();
    public static final Map<Stat, BiPredicate<EntityPlayer, cvzo>> craftIncrementProcessor = new HashMap<Stat, BiPredicate<EntityPlayer, cvzo>>();
    public static final Map<jxtc, Stat> incrementOnDamageSource = new HashMap<jxtc, Stat>();
    public static final Stat DUNGEONS_PASSED = Stat.register("dun-pas", "\u0414\u0430\u043d\u0436\u0435\u0439 \u043f\u0440\u043e\u0439\u0434\u0435\u043d\u043e", StatsCategory.EXPLORATION, StatsType.INTEGER);
    public final String id;
    public final String title;
    public final StatsCategory category;
    public final StatsType type;
    public final StatsDisplayer displayer;
    private boolean preserveOnReset = false;
    private boolean displayOnDeath = false;

    public static Stat register(String string, String string2, StatsCategory statsCategory, StatsType statsType) {
        Stat stat = new Stat(string, string2, statsCategory, statsType);
        statRegistry.put(string, stat);
        return stat;
    }

    public static Stat register(String string, String string2, StatsCategory statsCategory, StatsType statsType, StatsDisplayer statsDisplayer) {
        Stat stat = new Stat(string, string2, statsCategory, statsType, statsDisplayer);
        statRegistry.put(string, stat);
        return stat;
    }

    public static Stat getById(String string) {
        return statRegistry.get(string);
    }

    public static Collection<Stat> getAll() {
        return Collections.unmodifiableCollection(statRegistry.values());
    }

    Stat(String string, String string2, StatsCategory statsCategory, StatsType statsType) {
        this(string, string2, statsCategory, statsType, StatsDisplayer.basic());
    }

    Stat(String string, String string2, StatsCategory statsCategory, StatsType statsType, StatsDisplayer statsDisplayer) {
        this.id = string;
        this.title = string2;
        this.category = statsCategory;
        this.type = statsType;
        this.displayer = statsDisplayer;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Stat stat = (Stat)object;
        return Objects.equals(this.id, stat.id) && Objects.equals(this.title, stat.title) && this.category == stat.category && this.type == stat.type;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat incOnPlayerDeathIf(BiPredicate<EntityPlayer, jxtc> biPredicate) {
        playerDeathIncrementProcessor.put(this, biPredicate);
        return this;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat onPlayerDeath(BiConsumer<EntityPlayer, jxtc> biConsumer) {
        playerDeathProcessor.put(this, biConsumer);
        return this;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat incOnPlayerKillIf(BiPredicate<EntityLivingBase, jxtc> biPredicate) {
        playerKillIncrementProcessor.put(this, biPredicate);
        return this;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat incOnEntityKilled(Class<? extends EntityLivingBase> clazz) {
        incrementOnEntityKilled.put(clazz, this);
        return this;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat incOnDamageSource(jxtc jxtc2) {
        incrementOnDamageSource.put(jxtc2, this);
        return this;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat incTimeCounter(Predicate<EntityPlayer> predicate) {
        timeCounterProcess.put(this, predicate);
        return this;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Stat incOnCraftIf(BiPredicate<EntityPlayer, cvzo> biPredicate) {
        craftIncrementProcessor.put(this, biPredicate);
        return this;
    }

    public boolean isDisplayOnDeath() {
        return this.displayOnDeath;
    }

    public Stat setDisplayOnDeath(boolean bl) {
        this.displayOnDeath = bl;
        return this;
    }

    public boolean isPreserveOnReset() {
        return this.preserveOnReset;
    }

    public Stat setPreserveOnReset(boolean bl) {
        this.preserveOnReset = bl;
        return this;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.title, this.category, this.type});
    }

    public static enum StatsCategory {
        SURVIVAL("\u0432\u044b\u0436\u0438\u0432\u0430\u043d\u0438\u0435"),
        COMBAT("\u0431\u043e\u0439"),
        EXPLORATION("\u0438\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u043d\u0438\u0435 \u0437\u043e\u043d\u044b"),
        ECONOMY("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u043a\u0430"),
        NONE("");

        public final String title;

        private StatsCategory(String string2) {
            this.title = string2;
        }
    }
}

