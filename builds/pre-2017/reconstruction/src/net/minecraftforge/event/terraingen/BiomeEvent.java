/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class BiomeEvent
extends Event {
    public final BiomeGenBase biome;
    private static ListenerList LISTENER_LIST;

    public BiomeEvent(BiomeGenBase biomeGenBase) {
        this.biome = biomeGenBase;
    }

    public BiomeEvent() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (LISTENER_LIST != null) {
            return;
        }
        LISTENER_LIST = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return LISTENER_LIST;
    }

    public static class GetWaterColor
    extends BiomeColor {
        private static ListenerList LISTENER_LIST;

        public GetWaterColor(BiomeGenBase biomeGenBase, int n) {
            super(biomeGenBase, n);
        }

        public GetWaterColor() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class GetFoliageColor
    extends BiomeColor {
        private static ListenerList LISTENER_LIST;

        public GetFoliageColor(BiomeGenBase biomeGenBase, int n) {
            super(biomeGenBase, n);
        }

        public GetFoliageColor() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class GetGrassColor
    extends BiomeColor {
        private static ListenerList LISTENER_LIST;

        public GetGrassColor(BiomeGenBase biomeGenBase, int n) {
            super(biomeGenBase, n);
        }

        public GetGrassColor() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    @Event.HasResult
    public static class GetVillageBlockMeta
    extends BlockReplacement {
        private static ListenerList LISTENER_LIST;

        public GetVillageBlockMeta(BiomeGenBase biomeGenBase, int n, int n2) {
            super(biomeGenBase, n, n2);
        }

        public GetVillageBlockMeta() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    @Event.HasResult
    public static class GetVillageBlockID
    extends BlockReplacement {
        private static ListenerList LISTENER_LIST;

        public GetVillageBlockID(BiomeGenBase biomeGenBase, int n, int n2) {
            super(biomeGenBase, n, n2);
        }

        public GetVillageBlockID() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class BiomeColor
    extends BiomeEvent {
        public final int originalColor;
        public int newColor;
        private static ListenerList LISTENER_LIST;

        public BiomeColor(BiomeGenBase biomeGenBase, int n) {
            super(biomeGenBase);
            this.originalColor = n;
            this.newColor = n;
        }

        public BiomeColor() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class BlockReplacement
    extends BiomeEvent {
        public final int original;
        public int replacement;
        private static ListenerList LISTENER_LIST;

        public BlockReplacement(BiomeGenBase biomeGenBase, int n, int n2) {
            super(biomeGenBase);
            this.original = n;
            this.replacement = n2;
        }

        public BlockReplacement() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }

    public static class CreateDecorator
    extends BiomeEvent {
        public final BiomeDecorator originalBiomeDecorator;
        public BiomeDecorator newBiomeDecorator;
        private static ListenerList LISTENER_LIST;

        public CreateDecorator(BiomeGenBase biomeGenBase, BiomeDecorator biomeDecorator) {
            super(biomeGenBase);
            this.originalBiomeDecorator = biomeDecorator;
            this.newBiomeDecorator = biomeDecorator;
        }

        public CreateDecorator() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }
}

