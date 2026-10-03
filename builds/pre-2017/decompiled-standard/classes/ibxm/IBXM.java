/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Channel;
import ibxm.Module;
import ibxm.Pattern;

public class IBXM {
    public static final String VERSION = "ibxm alpha 51 (c)2008 mumart@gmail.com";
    public static final int FP_SHIFT = 15;
    public static final int FP_ONE = 32768;
    public static final int FP_MASK = Short.MAX_VALUE;
    private int sampling_rate;
    private int resampling_quality;
    private int volume_ramp_length;
    private int tick_length_samples;
    private int current_tick_samples;
    private int[] mixing_buffer;
    private int[] volume_ramp_buffer;
    private Module module;
    private Channel[] channels;
    private int[] global_volume;
    private int[] note;
    private int current_sequence_index;
    private int next_sequence_index;
    private int current_row;
    private int next_row;
    private int tick_counter;
    private int ticks_per_row;
    private int pattern_loop_count;
    private int pattern_loop_channel;

    public IBXM(int n) {
        if (n < 8000) {
            n = 8000;
        }
        this.sampling_rate = n;
        this.volume_ramp_length = this.sampling_rate >> 10;
        this.volume_ramp_buffer = new int[this.volume_ramp_length * 2];
        this.mixing_buffer = new int[this.sampling_rate / 6];
        this.global_volume = new int[1];
        this.note = new int[5];
        this.set_module(new Module());
        this.set_resampling_quality(1);
    }

    public void set_module(Module module) {
        this.module = module;
        this.channels = new Channel[this.module.get_num_channels()];
        for (int i = 0; i < this.channels.length; ++i) {
            this.channels[i] = new Channel(this.module, this.sampling_rate, this.global_volume);
        }
        this.set_sequence_index(0, 0);
    }

    public void set_resampling_quality(int n) {
        this.resampling_quality = n;
    }

    public int calculate_song_duration() {
        this.set_sequence_index(0, 0);
        this.next_tick();
        int n = this.tick_length_samples;
        while (!this.next_tick()) {
            n += this.tick_length_samples;
        }
        this.set_sequence_index(0, 0);
        return n;
    }

    public void set_sequence_index(int n, int n2) {
        this.global_volume[0] = 64;
        for (int i = 0; i < this.channels.length; ++i) {
            this.channels[i].reset();
            this.channels[i].set_panning(this.module.get_initial_panning(i));
        }
        this.set_global_volume(this.module.global_volume);
        this.set_speed(6);
        this.set_speed(this.module.default_speed);
        this.set_tempo(125);
        this.set_tempo(this.module.default_tempo);
        this.pattern_loop_count = -1;
        this.next_sequence_index = n;
        this.next_row = n2;
        this.tick_counter = 0;
        this.current_tick_samples = this.tick_length_samples;
        this.clear_vol_ramp_buffer();
    }

    public void seek(int n) {
        this.set_sequence_index(0, 0);
        this.next_tick();
        while (n > this.tick_length_samples) {
            n -= this.tick_length_samples;
            this.next_tick();
        }
        this.mix_tick();
        this.current_tick_samples = n;
    }

    public void get_audio(byte[] byArray, int n) {
        int n2 = 0;
        while (n > 0) {
            int n3;
            int n4 = this.tick_length_samples - this.current_tick_samples;
            if (n4 > n) {
                n4 = n;
            }
            int n5 = n3 + (n4 << 1) - 1;
            for (n3 = this.current_tick_samples << 1; n3 <= n5; ++n3) {
                int n6 = this.mixing_buffer[n3];
                if (n6 > Short.MAX_VALUE) {
                    n6 = Short.MAX_VALUE;
                }
                if (n6 < Short.MIN_VALUE) {
                    n6 = Short.MIN_VALUE;
                }
                byArray[n2] = (byte)(n6 >> 8);
                byArray[n2 + 1] = (byte)(n6 & 0xFF);
                n2 += 2;
            }
            this.current_tick_samples = n3 >> 1;
            if ((n -= n4) <= 0) continue;
            this.next_tick();
            this.mix_tick();
            this.current_tick_samples = 0;
        }
    }

    private void mix_tick() {
        int n = this.tick_length_samples + this.volume_ramp_length << 1;
        for (int i = 0; i < n; ++i) {
            this.mixing_buffer[i] = 0;
        }
        for (int i = 0; i < this.channels.length; ++i) {
            n = this.tick_length_samples + this.volume_ramp_length;
            this.channels[i].resample(this.mixing_buffer, 0, n, this.resampling_quality);
        }
        this.volume_ramp();
    }

    private boolean next_tick() {
        boolean bl;
        int n;
        for (n = 0; n < this.channels.length; ++n) {
            this.channels[n].update_sample_idx(this.tick_length_samples);
        }
        --this.tick_counter;
        if (this.tick_counter <= 0) {
            this.tick_counter = this.ticks_per_row;
            bl = this.next_row();
        } else {
            for (n = 0; n < this.channels.length; ++n) {
                this.channels[n].tick();
            }
            bl = false;
        }
        return bl;
    }

    private boolean next_row() {
        boolean bl = false;
        if (this.next_sequence_index < 0) {
            this.next_sequence_index = 0;
            this.next_row = 0;
        }
        if (this.next_sequence_index >= this.module.get_sequence_length()) {
            bl = true;
            this.next_sequence_index = this.module.restart_sequence_index;
            if (this.next_sequence_index < 0) {
                this.next_sequence_index = 0;
            }
            if (this.next_sequence_index >= this.module.get_sequence_length()) {
                this.next_sequence_index = 0;
            }
            this.next_row = 0;
        }
        if (this.next_sequence_index < this.current_sequence_index) {
            bl = true;
        }
        if (this.next_sequence_index == this.current_sequence_index && this.next_row <= this.current_row && this.pattern_loop_count < 0) {
            bl = true;
        }
        this.current_sequence_index = this.next_sequence_index;
        Pattern pattern = this.module.get_pattern_from_sequence(this.current_sequence_index);
        if (this.next_row < 0 || this.next_row >= pattern.num_rows) {
            this.next_row = 0;
        }
        this.current_row = this.next_row;
        this.next_row = this.current_row + 1;
        if (this.next_row >= pattern.num_rows) {
            this.next_sequence_index = this.current_sequence_index + 1;
            this.next_row = 0;
        }
        block11: for (int i = 0; i < this.channels.length; ++i) {
            pattern.get_note(this.note, this.current_row * this.channels.length + i);
            int n = this.note[3];
            int n2 = this.note[4];
            this.channels[i].row(this.note[0], this.note[1], this.note[2], n, n2);
            switch (n) {
                case 11: {
                    if (this.pattern_loop_count >= 0) continue block11;
                    this.next_sequence_index = n2;
                    this.next_row = 0;
                    continue block11;
                }
                case 13: {
                    if (this.pattern_loop_count >= 0) continue block11;
                    this.next_sequence_index = this.current_sequence_index + 1;
                    this.next_row = (n2 >> 4) * 10 + (n2 & 0xF);
                    continue block11;
                }
                case 14: {
                    switch (n2 & 0xF0) {
                        case 96: {
                            if ((n2 & 0xF) == 0) {
                                this.channels[i].pattern_loop_row = this.current_row;
                            }
                            if (this.channels[i].pattern_loop_row >= this.current_row) break;
                            if (this.pattern_loop_count < 0) {
                                this.pattern_loop_count = n2 & 0xF;
                                this.pattern_loop_channel = i;
                            }
                            if (this.pattern_loop_channel != i) break;
                            if (this.pattern_loop_count == 0) {
                                this.channels[i].pattern_loop_row = this.current_row + 1;
                            } else {
                                this.next_row = this.channels[i].pattern_loop_row;
                                this.next_sequence_index = this.current_sequence_index;
                            }
                            --this.pattern_loop_count;
                            break;
                        }
                        case 224: {
                            this.tick_counter += this.ticks_per_row * (n2 & 0xF);
                        }
                    }
                    continue block11;
                }
                case 15: {
                    if (n2 < 32) {
                        this.set_speed(n2);
                        this.tick_counter = this.ticks_per_row;
                        continue block11;
                    }
                    this.set_tempo(n2);
                    continue block11;
                }
                case 37: {
                    this.set_speed(n2);
                    this.tick_counter = this.ticks_per_row;
                }
            }
        }
        return bl;
    }

    private void set_global_volume(int n) {
        if (n < 0) {
            n = 0;
        }
        if (n > 64) {
            n = 64;
        }
        this.global_volume[0] = n;
    }

    private void set_speed(int n) {
        if (n > 0 && n < 256) {
            this.ticks_per_row = n;
        }
    }

    private void set_tempo(int n) {
        if (n > 31 && n < 256) {
            this.tick_length_samples = this.sampling_rate * 5 / (n * 2);
        }
    }

    private void volume_ramp() {
        int n = 0;
        int n2 = 32768 / this.volume_ramp_length;
        int n3 = 0;
        int n4 = 2 * this.tick_length_samples;
        int n5 = this.volume_ramp_length * 2 - 1;
        for (int i = 0; i <= n5; i += 2) {
            n = this.volume_ramp_buffer[i] * (32768 - n3) >> 15;
            this.mixing_buffer[i] = n + (this.mixing_buffer[i] * n3 >> 15);
            this.volume_ramp_buffer[i] = this.mixing_buffer[n4 + i];
            n = this.volume_ramp_buffer[i + 1] * (32768 - n3) >> 15;
            this.mixing_buffer[i + 1] = n + (this.mixing_buffer[i + 1] * n3 >> 15);
            this.volume_ramp_buffer[i + 1] = this.mixing_buffer[n4 + i + 1];
            n3 += n2;
        }
    }

    private void clear_vol_ramp_buffer() {
        int n = this.volume_ramp_length * 2 - 1;
        for (int i = 0; i <= n; ++i) {
            this.volume_ramp_buffer[i] = 0;
        }
    }
}

