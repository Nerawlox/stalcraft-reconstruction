/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Instrument;
import ibxm.Pattern;

public class Module {
    public String song_title = "ibxm alpha 51 (c)2008 mumart@gmail.com";
    public boolean linear_periods;
    public boolean fast_volume_slides;
    public boolean pal;
    public int global_volume;
    public int channel_gain;
    public int default_speed;
    public int default_tempo;
    public int restart_sequence_index;
    private int[] initial_panning;
    private int[] sequence;
    private Pattern[] patterns;
    private Instrument[] instruments;
    private Pattern default_pattern;
    private Instrument default_instrument;

    public Module() {
        this.set_num_channels(1);
        this.set_sequence_length(1);
        this.set_num_patterns(0);
        this.set_num_instruments(0);
        this.default_pattern = new Pattern();
        this.default_instrument = new Instrument();
    }

    public int get_num_channels() {
        return this.initial_panning.length;
    }

    public void set_num_channels(int n) {
        if (n < 1) {
            n = 1;
        }
        this.initial_panning = new int[n];
    }

    public int get_initial_panning(int n) {
        int n2 = 128;
        if (n >= 0 && n < this.initial_panning.length) {
            n2 = this.initial_panning[n];
        }
        return n2;
    }

    public void set_initial_panning(int n, int n2) {
        if (n >= 0 && n < this.initial_panning.length) {
            this.initial_panning[n] = n2;
        }
    }

    public int get_sequence_length() {
        return this.sequence.length;
    }

    public void set_sequence_length(int n) {
        if (n < 0) {
            n = 0;
        }
        this.sequence = new int[n];
    }

    public void set_sequence(int n, int n2) {
        if (n >= 0 && n < this.sequence.length) {
            this.sequence[n] = n2;
        }
    }

    public int get_num_patterns() {
        return this.patterns.length;
    }

    public void set_num_patterns(int n) {
        if (n < 0) {
            n = 0;
        }
        this.patterns = new Pattern[n];
    }

    public Pattern get_pattern_from_sequence(int n) {
        Pattern pattern = this.default_pattern;
        if (n >= 0 && n < this.sequence.length) {
            pattern = this.get_pattern(this.sequence[n]);
        }
        return pattern;
    }

    public Pattern get_pattern(int n) {
        Pattern pattern = null;
        if (n >= 0 && n < this.patterns.length) {
            pattern = this.patterns[n];
        }
        if (pattern == null) {
            pattern = this.default_pattern;
        }
        return pattern;
    }

    public void set_pattern(int n, Pattern pattern) {
        if (n >= 0 && n < this.patterns.length) {
            this.patterns[n] = pattern;
        }
    }

    public int get_num_instruments() {
        return this.instruments.length;
    }

    public void set_num_instruments(int n) {
        if (n < 0) {
            n = 0;
        }
        this.instruments = new Instrument[n];
    }

    public Instrument get_instrument(int n) {
        Instrument instrument = null;
        if (n > 0 && n <= this.instruments.length) {
            instrument = this.instruments[n - 1];
        }
        if (instrument == null) {
            instrument = this.default_instrument;
        }
        return instrument;
    }

    public void set_instrument(int n, Instrument instrument) {
        if (n > 0 && n <= this.instruments.length) {
            this.instruments[n - 1] = instrument;
        }
    }
}

