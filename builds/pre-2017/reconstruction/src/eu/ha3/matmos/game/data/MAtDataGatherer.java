/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.easy.TimeStatistic;
import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.conv.Processor;
import eu.ha3.matmos.conv.ProcessorModel;
import eu.ha3.matmos.engine.implem.GenericSheet;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.engine.interfaces.Data;
import eu.ha3.matmos.game.data.MAtPipelineIDAccumulator;
import eu.ha3.matmos.game.data.MAtProcessorCVARS;
import eu.ha3.matmos.game.data.MAtProcessorContact;
import eu.ha3.matmos.game.data.MAtProcessorEnchantments;
import eu.ha3.matmos.game.data.MAtProcessorEntityDetector;
import eu.ha3.matmos.game.data.MAtProcessorFrequent;
import eu.ha3.matmos.game.data.MAtProcessorOptions;
import eu.ha3.matmos.game.data.MAtProcessorPotionQuality;
import eu.ha3.matmos.game.data.MAtProcessorRelaxed;
import eu.ha3.matmos.game.data.MAtScanCoordsPipeline;
import eu.ha3.matmos.game.data.MAtScanVolumetricModel;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.matmos.requirem.Requirements;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class MAtDataGatherer {
    static final String INSTANTS = "Instants";
    static final String DELTAS = "Deltas";
    static final String LARGESCAN = "LargeScan";
    static final String SMALLSCAN = "SmallScan";
    static final String LARGESCAN_THOUSAND = "LargeScanPerMil";
    static final String SMALLSCAN_THOUSAND = "SmallScanPerMil";
    static final String SPECIAL_LARGE = "SpecialLarge";
    static final String SPECIAL_SMALL = "SpecialSmall";
    static final String CONTACTSCAN = "ContactScan";
    static final String CONFIGVARS = "ConfigVars";
    static final String POTIONPOWER = "PotionEffectsPower";
    static final String POTIONDURATION = "PotionEffectsDuration";
    static final String CURRENTITEM_E = "CurrentItemEnchantments";
    static final String ARMOR1_E = "Armor1Enchantments";
    static final String ARMOR2_E = "Armor2Enchantments";
    static final String ARMOR3_E = "Armor3Enchantments";
    static final String ARMOR4_E = "Armor4Enchantments";
    static final String OPTIONS = "Options";
    static final int COUNT_WORLD_BLOCKS = 4096;
    static final int COUNT_INSTANTS = 128;
    static final int COUNT_CONFIGVARS = 256;
    static final int COUNT_POTIONEFFECTS = 32;
    static final int COUNT_ENCHANTMENTS = 64;
    static final int MAX_LARGESCAN_PASS = 10;
    private static final int ENTITYIDS_MAX = 256;
    private MAtMod mod;
    private MAtScanVolumetricModel largeScanner;
    private MAtScanVolumetricModel smallScanner;
    private MAtScanCoordsPipeline largePipeline;
    private MAtScanCoordsPipeline smallPipeline;
    private Set<Processor> frequent;
    private ProcessorModel relaxedProcessor;
    private ProcessorModel configVarsProcessor;
    private ProcessorModel optionsProcessor;
    private ProcessorModel weatherpony_seasons_api_Processor;
    private IntegerData data;
    private int ticksPassed;
    private long lastLargeScanX;
    private long lastLargeScanY;
    private long lastLargeScanZ;
    private int lastLargeScanPassed;
    private boolean anticrash = true;

    public MAtDataGatherer(MAtMod mAtMod) {
        this.mod = mAtMod;
        this.frequent = new LinkedHashSet<Processor>();
    }

    private void resetRegulators() {
        this.lastLargeScanPassed = 10;
        this.ticksPassed = 0;
    }

    public void load(Requirements requirements) {
        this.resetRegulators();
        this.data = new IntegerData(requirements);
        this.prepareSheets();
        this.largeScanner = new MAtScanVolumetricModel(this.mod);
        this.smallScanner = new MAtScanVolumetricModel(this.mod);
        this.largePipeline = new MAtPipelineIDAccumulator(this.mod, this.data, LARGESCAN, LARGESCAN_THOUSAND, 1000);
        this.smallPipeline = new MAtPipelineIDAccumulator(this.mod, this.data, SMALLSCAN, SMALLSCAN_THOUSAND, 1000);
        this.largeScanner.setPipeline(this.largePipeline);
        this.smallScanner.setPipeline(this.smallPipeline);
        this.relaxedProcessor = new MAtProcessorRelaxed(this.mod, this.data, INSTANTS, DELTAS);
        this.configVarsProcessor = new MAtProcessorCVARS(this.mod, this.data, CONFIGVARS, null);
        this.optionsProcessor = new MAtProcessorOptions(this.mod, this.data, OPTIONS, null);
        this.frequent.add(new MAtProcessorFrequent(this.mod, this.data, INSTANTS, DELTAS));
        this.frequent.add(new MAtProcessorContact(this.mod, this.data, CONTACTSCAN, null));
        this.frequent.add(new MAtProcessorEnchantments(this.mod, this.data, CURRENTITEM_E, null){

            @Override
            protected ItemStack getItem(EntityPlayer entityPlayer) {
                return entityPlayer.inventory._a();
            }
        });
        this.frequent.add(new MAtProcessorEnchantments(this.mod, this.data, ARMOR1_E, null){

            @Override
            protected ItemStack getItem(EntityPlayer entityPlayer) {
                return entityPlayer.inventory._b[0];
            }
        });
        this.frequent.add(new MAtProcessorEnchantments(this.mod, this.data, ARMOR2_E, null){

            @Override
            protected ItemStack getItem(EntityPlayer entityPlayer) {
                return entityPlayer.inventory._b[1];
            }
        });
        this.frequent.add(new MAtProcessorEnchantments(this.mod, this.data, ARMOR3_E, null){

            @Override
            protected ItemStack getItem(EntityPlayer entityPlayer) {
                return entityPlayer.inventory._b[2];
            }
        });
        this.frequent.add(new MAtProcessorEnchantments(this.mod, this.data, ARMOR4_E, null){

            @Override
            protected ItemStack getItem(EntityPlayer entityPlayer) {
                return entityPlayer.inventory._b[3];
            }
        });
        this.frequent.add(new MAtProcessorPotionQuality(this.mod, this.data, POTIONPOWER, null){

            @Override
            protected int getQuality(PotionEffect potionEffect) {
                return potionEffect._c() + 1;
            }
        });
        this.frequent.add(new MAtProcessorPotionQuality(this.mod, this.data, POTIONDURATION, null){

            @Override
            protected int getQuality(PotionEffect potionEffect) {
                return potionEffect._b();
            }
        });
        this.frequent.add(new MAtProcessorEntityDetector(this.mod, this.data, "DetectMinDist", "Detect", "_Deltas", 256, 2, 5, 10, 20, 50));
    }

    public Data getData() {
        return this.data;
    }

    public void tickRoutine() {
        block4: {
            try {
                this.tickRoutineThrowsStupidProgrammingErrors();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                if (!this.anticrash) break block4;
                this.anticrash = false;
                this.mod.getChatter().printChat("\u00a7c", "MAtmos is crashing: ", "\u00a7f", exception.getClass().getName(), ": ", exception.getCause());
                int n = 0;
                for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                    if (n <= 5 || stackTraceElement.toString().contains("MAt") || stackTraceElement.toString().contains("eu.ha3.matmos.")) {
                        this.mod.getChatter().printChat("\u00a7f", stackTraceElement.toString());
                    }
                    ++n;
                }
                this.mod.getChatter().printChat("\u00a7c", "Please report this issue :(");
            }
        }
    }

    public void tickRoutineThrowsStupidProgrammingErrors() {
        if (this.ticksPassed % 64 == 0) {
            EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
            long l = (long)Math.floor(entityClientPlayerMP.posX);
            long l2 = (long)Math.floor(entityClientPlayerMP.posY);
            long l3 = (long)Math.floor(entityClientPlayerMP.posZ);
            if (this.ticksPassed % 256 == 0 && (this.data.getRequirements().isRequired(LARGESCAN) || this.data.getRequirements().isRequired(LARGESCAN_THOUSAND))) {
                if (this.lastLargeScanPassed >= 10 || Math.abs(l - this.lastLargeScanX) > 16L || Math.abs(l2 - this.lastLargeScanY) > 8L || Math.abs(l3 - this.lastLargeScanZ) > 16L) {
                    this.lastLargeScanX = l;
                    this.lastLargeScanY = l2;
                    this.lastLargeScanZ = l3;
                    this.lastLargeScanPassed = 0;
                    this.largeScanner.startScan(l, l2, l3, 64L, 32L, 64L, 8192L, null);
                } else {
                    ++this.lastLargeScanPassed;
                }
            }
            if (this.data.getRequirements().isRequired(SMALLSCAN) || this.data.getRequirements().isRequired(SMALLSCAN_THOUSAND)) {
                this.smallScanner.startScan(l, l2, l3, 16L, 8L, 16L, 2048L, null);
            }
            this.relaxedProcessor.process();
            if (this.weatherpony_seasons_api_Processor != null) {
                this.weatherpony_seasons_api_Processor.process();
            }
            this.optionsProcessor.process();
            this.data.flagUpdate();
        }
        for (Processor processor : this.frequent) {
            processor.process();
        }
        this.data.flagUpdate();
        if (this.ticksPassed % 2048 == 0) {
            this.configVarsProcessor.process();
        }
        this.largeScanner.routine();
        this.smallScanner.routine();
        ++this.ticksPassed;
    }

    private void prepareSheets() {
        this.createSheet(LARGESCAN, 4096);
        this.createSheet(LARGESCAN_THOUSAND, 4096);
        this.createSheet(SMALLSCAN, 4096);
        this.createSheet(SMALLSCAN_THOUSAND, 4096);
        this.createSheet(CONTACTSCAN, 4096);
        this.createSheet(INSTANTS, 128);
        this.createSheet(DELTAS, 128);
        this.createSheet(POTIONPOWER, 32);
        this.createSheet(POTIONDURATION, 32);
        this.createSheet(CURRENTITEM_E, 64);
        this.createSheet(ARMOR1_E, 64);
        this.createSheet(ARMOR2_E, 64);
        this.createSheet(ARMOR3_E, 64);
        this.createSheet(ARMOR4_E, 64);
        this.createSheet(SPECIAL_LARGE, 2);
        this.createSheet(SPECIAL_SMALL, 1);
        this.createSheet(CONFIGVARS, 256);
        this.createSheet("DetectMinDist", 256);
        this.createSheet("Detect2", 256);
        this.createSheet("Detect5", 256);
        this.createSheet("Detect10", 256);
        this.createSheet("Detect20", 256);
        this.createSheet("Detect50", 256);
        this.createSheet("DetectMinDist_Deltas", 256);
        this.createSheet("Detect2_Deltas", 256);
        this.createSheet("Detect5_Deltas", 256);
        this.createSheet("Detect10_Deltas", 256);
        this.createSheet("Detect20_Deltas", 256);
        this.createSheet("Detect50_Deltas", 256);
        this.createSheet("weatherpony_seasons_api", 4);
        this.createSheet(OPTIONS, 16);
    }

    private void createSheet(String string, int n) {
        this.data.setSheet(string, new GenericSheet<Integer>(n, 0));
    }

    public void dataRoll() {
        TimeStatistic timeStatistic = new TimeStatistic(Locale.ENGLISH);
        this.tickRoutine();
        MAtmosConvLogger.info("Took " + timeStatistic.getSecondsAsString(3) + " seconds to perform delta tick routine.");
        timeStatistic = new TimeStatistic(Locale.ENGLISH);
        while (this.largeScanner.routine()) {
        }
        this.smallScanner.routine();
        MAtmosConvLogger.info("Took " + timeStatistic.getSecondsAsString(3) + " seconds to perform data roll.");
    }
}

