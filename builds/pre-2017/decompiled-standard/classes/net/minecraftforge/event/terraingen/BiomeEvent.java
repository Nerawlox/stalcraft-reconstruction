/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class BiomeEvent
extends Event {
    public final foqh biome;
    private static ListenerList LISTENER_LIST;

    public BiomeEvent(foqh foqh2) {
        this.biome = foqh2;
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

        public GetWaterColor(foqh foqh2, int n) {
            super(foqh2, n);
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

        public GetFoliageColor(foqh foqh2, int n) {
            super(foqh2, n);
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

        public GetGrassColor(foqh foqh2, int n) {
            super(foqh2, n);
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

        public GetVillageBlockMeta(foqh foqh2, int n, int n2) {
            super(foqh2, n, n2);
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

        public GetVillageBlockID(foqh foqh2, int n, int n2) {
            super(foqh2, n, n2);
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

        public BiomeColor(foqh foqh2, int n) {
            super(foqh2);
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

        public BlockReplacement(foqh foqh2, int n, int n2) {
            super(foqh2);
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
        public final qoqn originalBiomeDecorator;
        public qoqn newBiomeDecorator;
        private static ListenerList LISTENER_LIST;

        public CreateDecorator(foqh foqh2, qoqn qoqn2) {
            super(foqh2);
            this.originalBiomeDecorator = qoqn2;
            this.newBiomeDecorator = qoqn2;
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

