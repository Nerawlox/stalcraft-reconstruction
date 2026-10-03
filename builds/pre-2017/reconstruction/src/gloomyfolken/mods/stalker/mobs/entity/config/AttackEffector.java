/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\bM\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001e\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001e\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001e\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\b\u00a8\u0006Q"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/AttackEffector;", "", "()V", "camAmplitude", "", "getCamAmplitude", "()D", "setCamAmplitude", "(D)V", "camPeriodNumber", "getCamPeriodNumber", "setCamPeriodNumber", "camPower", "getCamPower", "setCamPower", "camTime", "getCamTime", "setCamTime", "colorAddB", "getColorAddB", "setColorAddB", "colorAddG", "getColorAddG", "setColorAddG", "colorAddR", "getColorAddR", "setColorAddR", "colorFlashB", "getColorFlashB", "setColorFlashB", "colorFlashG", "getColorFlashG", "setColorFlashG", "colorFlashR", "getColorFlashR", "setColorFlashR", "colorGrayB", "getColorGrayB", "setColorGrayB", "colorGrayG", "getColorGrayG", "setColorGrayG", "colorGrayR", "getColorGrayR", "setColorGrayR", "colorScreenB", "getColorScreenB", "setColorScreenB", "colorScreenG", "getColorScreenG", "setColorScreenG", "colorScreenR", "getColorScreenR", "setColorScreenR", "diplopiaAdd", "getDiplopiaAdd", "setDiplopiaAdd", "diplopiaAddTime", "getDiplopiaAddTime", "setDiplopiaAddTime", "diplopiaBase", "getDiplopiaBase", "setDiplopiaBase", "fadeIn", "getFadeIn", "setFadeIn", "fadeOut", "getFadeOut", "setFadeOut", "grayAmount", "getGrayAmount", "setGrayAmount", "heartBeatSpeed", "getHeartBeatSpeed", "setHeartBeatSpeed", "heartBeathStrength", "getHeartBeathStrength", "setHeartBeathStrength", "time", "getTime", "setTime", "minecraft"})
public final class AttackEffector {
    @SerializedName(value="diplopiaBase")
    private double diplopiaBase = 5.0;
    @SerializedName(value="diplopiaAdd")
    private double diplopiaAdd = 2.25;
    @SerializedName(value="diplopiaAddTime")
    private double diplopiaAddTime = 3.5;
    @SerializedName(value="grayAmount")
    private double grayAmount;
    @SerializedName(value="heartBeatSpeed")
    private double heartBeatSpeed;
    @SerializedName(value="heartBeathStrength")
    private double heartBeathStrength;
    @SerializedName(value="colorScreenR")
    private double colorScreenR = 1.0;
    @SerializedName(value="colorScreenG")
    private double colorScreenG = 1.0;
    @SerializedName(value="colorScreenB")
    private double colorScreenB = 1.0;
    @SerializedName(value="colorGrayR")
    private double colorGrayR = 0.333;
    @SerializedName(value="colorGrayG")
    private double colorGrayG = 0.333;
    @SerializedName(value="colorGrayB")
    private double colorGrayB = 0.333;
    @SerializedName(value="colorFlashR")
    private double colorFlashR;
    @SerializedName(value="colorFlashG")
    private double colorFlashG;
    @SerializedName(value="colorFlashB")
    private double colorFlashB;
    @SerializedName(value="colorAddR")
    private double colorAddR;
    @SerializedName(value="colorAddG")
    private double colorAddG;
    @SerializedName(value="colorAddB")
    private double colorAddB;
    @SerializedName(value="time")
    private double time = 0.15;
    @SerializedName(value="fadeIn")
    private double fadeIn = 0.05;
    @SerializedName(value="fadeOut")
    private double fadeOut = 0.05;
    @SerializedName(value="camTime")
    private double camTime = 0.35;
    @SerializedName(value="camAmplitude")
    private double camAmplitude = 5.0;
    @SerializedName(value="camPeriodNumber")
    private double camPeriodNumber = 2.0;
    @SerializedName(value="camPower")
    private double camPower = 0.7;

    public final double getDiplopiaBase() {
        return this.diplopiaBase;
    }

    public final void setDiplopiaBase(double d) {
        this.diplopiaBase = d;
    }

    public final double getDiplopiaAdd() {
        return this.diplopiaAdd;
    }

    public final void setDiplopiaAdd(double d) {
        this.diplopiaAdd = d;
    }

    public final double getDiplopiaAddTime() {
        return this.diplopiaAddTime;
    }

    public final void setDiplopiaAddTime(double d) {
        this.diplopiaAddTime = d;
    }

    public final double getGrayAmount() {
        return this.grayAmount;
    }

    public final void setGrayAmount(double d) {
        this.grayAmount = d;
    }

    public final double getHeartBeatSpeed() {
        return this.heartBeatSpeed;
    }

    public final void setHeartBeatSpeed(double d) {
        this.heartBeatSpeed = d;
    }

    public final double getHeartBeathStrength() {
        return this.heartBeathStrength;
    }

    public final void setHeartBeathStrength(double d) {
        this.heartBeathStrength = d;
    }

    public final double getColorScreenR() {
        return this.colorScreenR;
    }

    public final void setColorScreenR(double d) {
        this.colorScreenR = d;
    }

    public final double getColorScreenG() {
        return this.colorScreenG;
    }

    public final void setColorScreenG(double d) {
        this.colorScreenG = d;
    }

    public final double getColorScreenB() {
        return this.colorScreenB;
    }

    public final void setColorScreenB(double d) {
        this.colorScreenB = d;
    }

    public final double getColorGrayR() {
        return this.colorGrayR;
    }

    public final void setColorGrayR(double d) {
        this.colorGrayR = d;
    }

    public final double getColorGrayG() {
        return this.colorGrayG;
    }

    public final void setColorGrayG(double d) {
        this.colorGrayG = d;
    }

    public final double getColorGrayB() {
        return this.colorGrayB;
    }

    public final void setColorGrayB(double d) {
        this.colorGrayB = d;
    }

    public final double getColorFlashR() {
        return this.colorFlashR;
    }

    public final void setColorFlashR(double d) {
        this.colorFlashR = d;
    }

    public final double getColorFlashG() {
        return this.colorFlashG;
    }

    public final void setColorFlashG(double d) {
        this.colorFlashG = d;
    }

    public final double getColorFlashB() {
        return this.colorFlashB;
    }

    public final void setColorFlashB(double d) {
        this.colorFlashB = d;
    }

    public final double getColorAddR() {
        return this.colorAddR;
    }

    public final void setColorAddR(double d) {
        this.colorAddR = d;
    }

    public final double getColorAddG() {
        return this.colorAddG;
    }

    public final void setColorAddG(double d) {
        this.colorAddG = d;
    }

    public final double getColorAddB() {
        return this.colorAddB;
    }

    public final void setColorAddB(double d) {
        this.colorAddB = d;
    }

    public final double getTime() {
        return this.time;
    }

    public final void setTime(double d) {
        this.time = d;
    }

    public final double getFadeIn() {
        return this.fadeIn;
    }

    public final void setFadeIn(double d) {
        this.fadeIn = d;
    }

    public final double getFadeOut() {
        return this.fadeOut;
    }

    public final void setFadeOut(double d) {
        this.fadeOut = d;
    }

    public final double getCamTime() {
        return this.camTime;
    }

    public final void setCamTime(double d) {
        this.camTime = d;
    }

    public final double getCamAmplitude() {
        return this.camAmplitude;
    }

    public final void setCamAmplitude(double d) {
        this.camAmplitude = d;
    }

    public final double getCamPeriodNumber() {
        return this.camPeriodNumber;
    }

    public final void setCamPeriodNumber(double d) {
        this.camPeriodNumber = d;
    }

    public final double getCamPower() {
        return this.camPower;
    }

    public final void setCamPower(double d) {
        this.camPower = d;
    }
}

