/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.ugqx;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class qowq
extends ukcj {
    public boolean[] _e = new boolean[4];
    public static final vjvn[] _f = new vjvn[]{new vjvn(tgdv.field_77702_n.field_77779_bT, 0, 1, 3, 3), new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 5, 10), new vjvn(tgdv.field_77717_p.field_77779_bT, 0, 2, 7, 15), new vjvn(tgdv.field_77817_bH.field_77779_bT, 0, 1, 3, 2), new vjvn(tgdv.field_77755_aX.field_77779_bT, 0, 4, 6, 20), new vjvn(tgdv.field_77737_bm.field_77779_bT, 0, 3, 7, 16), new vjvn(tgdv.field_77765_aA.field_77779_bT, 0, 1, 1, 3), new vjvn(tgdv.field_111215_ce.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111216_cf.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111213_cg.field_77779_bT, 0, 1, 1, 1)};

    public qowq() {
    }

    public qowq(Random random, int n, int n2) {
        super(random, n, 64, n2, 21, 15, 21);
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("hasPlacedChest0", this._e[0]);
        qoac2._a("hasPlacedChest1", this._e[1]);
        qoac2._a("hasPlacedChest2", this._e[2]);
        qoac2._a("hasPlacedChest3", this._e[3]);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._e[0] = qoac2._o("hasPlacedChest0");
        this._e[1] = qoac2._o("hasPlacedChest1");
        this._e[2] = qoac2._o("hasPlacedChest2");
        this._e[3] = qoac2._o("hasPlacedChest3");
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        this._a(ozlu2, uken2, 0, -4, 0, this._a - 1, 0, this._c - 1, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        for (n3 = 1; n3 <= 9; ++n3) {
            this._a(ozlu2, uken2, n3, n3, n3, this._a - 1 - n3, n3, this._c - 1 - n3, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
            this._a(ozlu2, uken2, n3 + 1, n3, n3 + 1, this._a - 2 - n3, n3, this._c - 2 - n3, 0, 0, false);
        }
        for (n3 = 0; n3 < this._a; ++n3) {
            for (n2 = 0; n2 < this._c; ++n2) {
                this._b(ozlu2, twgu.field_71957_Q.field_71990_ca, 0, n3, -5, n2, uken2);
            }
        }
        n3 = this._e(twgu.field_72088_bQ.field_71990_ca, 3);
        n2 = this._e(twgu.field_72088_bQ.field_71990_ca, 2);
        int n4 = this._e(twgu.field_72088_bQ.field_71990_ca, 0);
        int n5 = this._e(twgu.field_72088_bQ.field_71990_ca, 1);
        int n6 = 1;
        int n7 = 11;
        this._a(ozlu2, uken2, 0, 0, 0, 4, 9, 4, twgu.field_71957_Q.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, 1, 10, 1, 3, 10, 3, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n3, 2, 10, 0, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n2, 2, 10, 4, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n4, 0, 10, 2, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n5, 4, 10, 2, uken2);
        this._a(ozlu2, uken2, this._a - 5, 0, 0, this._a - 1, 9, 4, twgu.field_71957_Q.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, this._a - 4, 10, 1, this._a - 2, 10, 3, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n3, this._a - 3, 10, 0, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n2, this._a - 3, 10, 4, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n4, this._a - 5, 10, 2, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n5, this._a - 1, 10, 2, uken2);
        this._a(ozlu2, uken2, 8, 0, 0, 12, 4, 4, twgu.field_71957_Q.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, 9, 1, 0, 11, 3, 4, 0, 0, false);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 9, 1, 1, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 9, 2, 1, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 9, 3, 1, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 10, 3, 1, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 11, 3, 1, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 11, 2, 1, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 11, 1, 1, uken2);
        this._a(ozlu2, uken2, 4, 1, 1, 8, 3, 3, twgu.field_71957_Q.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, 4, 1, 2, 8, 2, 2, 0, 0, false);
        this._a(ozlu2, uken2, 12, 1, 1, 16, 3, 3, twgu.field_71957_Q.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, 12, 1, 2, 16, 2, 2, 0, 0, false);
        this._a(ozlu2, uken2, 5, 4, 5, this._a - 6, 4, this._c - 6, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 4, 9, 11, 4, 11, 0, 0, false);
        this._a(ozlu2, uken2, 8, 1, 8, 8, 3, 8, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, 12, 1, 8, 12, 3, 8, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, 8, 1, 12, 8, 3, 12, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, 12, 1, 12, 12, 3, 12, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, 1, 1, 5, 4, 4, 11, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, this._a - 5, 1, 5, this._a - 2, 4, 11, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 7, 9, 6, 7, 11, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, this._a - 7, 7, 9, this._a - 7, 7, 11, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 5, 9, 5, 7, 11, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, this._a - 6, 5, 9, this._a - 6, 7, 11, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, 0, 0, 5, 5, 10, uken2);
        this._a(ozlu2, 0, 0, 5, 6, 10, uken2);
        this._a(ozlu2, 0, 0, 6, 6, 10, uken2);
        this._a(ozlu2, 0, 0, this._a - 6, 5, 10, uken2);
        this._a(ozlu2, 0, 0, this._a - 6, 6, 10, uken2);
        this._a(ozlu2, 0, 0, this._a - 7, 6, 10, uken2);
        this._a(ozlu2, uken2, 2, 4, 4, 2, 6, 4, 0, 0, false);
        this._a(ozlu2, uken2, this._a - 3, 4, 4, this._a - 3, 6, 4, 0, 0, false);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n3, 2, 4, 5, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n3, 2, 3, 4, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n3, this._a - 3, 4, 5, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n3, this._a - 3, 3, 4, uken2);
        this._a(ozlu2, uken2, 1, 1, 3, 2, 2, 3, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, this._a - 3, 1, 3, this._a - 2, 2, 3, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, 0, 1, 1, 2, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, 0, this._a - 2, 1, 2, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 1, 1, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 1, this._a - 2, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n5, 2, 1, 2, uken2);
        this._a(ozlu2, twgu.field_72088_bQ.field_71990_ca, n4, this._a - 3, 1, 2, uken2);
        this._a(ozlu2, uken2, 4, 3, 5, 4, 3, 18, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, this._a - 5, 3, 5, this._a - 5, 3, 17, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 5, 4, 2, 16, 0, 0, false);
        this._a(ozlu2, uken2, this._a - 6, 1, 5, this._a - 5, 2, 16, 0, 0, false);
        for (n = 5; n <= 17; n += 2) {
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 4, 1, n, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, 4, 2, n, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, this._a - 5, 1, n, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, this._a - 5, 2, n, uken2);
        }
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 10, 0, 7, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 10, 0, 8, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 9, 0, 9, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 11, 0, 9, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 8, 0, 10, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 12, 0, 10, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 7, 0, 10, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 13, 0, 10, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 9, 0, 11, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 11, 0, 11, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 10, 0, 12, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 10, 0, 13, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n7, 10, 0, 10, uken2);
        for (n = 0; n <= this._a - 1; n += this._a - 1) {
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 2, 1, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 2, 2, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 2, 3, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 3, 1, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 3, 2, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 3, 3, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 4, 1, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, n, 4, 2, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 4, 3, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 5, 1, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 5, 2, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 5, 3, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 6, 1, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, n, 6, 2, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 6, 3, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 7, 1, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 7, 2, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 7, 3, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 8, 1, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 8, 2, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 8, 3, uken2);
        }
        for (n = 2; n <= this._a - 3; n += this._a - 3 - 2) {
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n - 1, 2, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 2, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n + 1, 2, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n - 1, 3, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 3, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n + 1, 3, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n - 1, 4, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, n, 4, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n + 1, 4, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n - 1, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 5, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n + 1, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n - 1, 6, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, n, 6, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n + 1, 6, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n - 1, 7, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n, 7, 0, uken2);
            this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, n + 1, 7, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n - 1, 8, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n, 8, 0, uken2);
            this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, n + 1, 8, 0, uken2);
        }
        this._a(ozlu2, uken2, 8, 4, 0, 12, 6, 0, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, 0, 0, 8, 6, 0, uken2);
        this._a(ozlu2, 0, 0, 12, 6, 0, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 9, 5, 0, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, 10, 5, 0, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, n6, 11, 5, 0, uken2);
        this._a(ozlu2, uken2, 8, -14, 8, 12, -11, 12, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, 8, -10, 8, 12, -10, 12, twgu.field_71957_Q.field_71990_ca, 1, twgu.field_71957_Q.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 8, -9, 8, 12, -9, 12, twgu.field_71957_Q.field_71990_ca, 2, twgu.field_71957_Q.field_71990_ca, 2, false);
        this._a(ozlu2, uken2, 8, -8, 8, 12, -1, 12, twgu.field_71957_Q.field_71990_ca, twgu.field_71957_Q.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, -11, 9, 11, -1, 11, 0, 0, false);
        this._a(ozlu2, twgu.field_72044_aK.field_71990_ca, 0, 10, -11, 10, uken2);
        this._a(ozlu2, uken2, 9, -13, 9, 11, -13, 11, twgu.field_72091_am.field_71990_ca, 0, false);
        this._a(ozlu2, 0, 0, 8, -11, 10, uken2);
        this._a(ozlu2, 0, 0, 8, -10, 10, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, 7, -10, 10, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 7, -11, 10, uken2);
        this._a(ozlu2, 0, 0, 12, -11, 10, uken2);
        this._a(ozlu2, 0, 0, 12, -10, 10, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, 13, -10, 10, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 13, -11, 10, uken2);
        this._a(ozlu2, 0, 0, 10, -11, 8, uken2);
        this._a(ozlu2, 0, 0, 10, -10, 8, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, 10, -10, 7, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 10, -11, 7, uken2);
        this._a(ozlu2, 0, 0, 10, -11, 12, uken2);
        this._a(ozlu2, 0, 0, 10, -10, 12, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 1, 10, -10, 13, uken2);
        this._a(ozlu2, twgu.field_71957_Q.field_71990_ca, 2, 10, -11, 13, uken2);
        ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("pyramidDesertyChest");
        for (n = 0; n < 4; ++n) {
            if (this._e[n]) continue;
            int n8 = ugqx._a[n] * 2;
            int n9 = ugqx._b[n] * 2;
            this._e[n] = this._a(ozlu2, uken2, random, 10 + n8, -11, 10 + n9, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        }
        return true;
    }
}

