package edu.nyu.cs9053.homework5;
import java.math.*;

public class Baguette implements Recipe {

    private static final int DEFAULT_BAGUETTE_VOLUME_CUBIC_INCHES = 2000;

    private static final Double FINISH_PERCENT = 1d;

    private static final Double MINUTE_TO_SECOND = 60d;

    private static final Double DEFAULT_MINUTE = 20d;

    private static final Double DEFAULT_TEMPERATURE = 300d;

    private final Double recipeConstant;

    private Double percentOfFinish;

    private Double remainingSecondsUntilDone;

    public Baguette(Double recipeConstant) {
        this.recipeConstant = recipeConstant;
    }

    @Override public void initializeFromOven(Oven oven) {
        percentOfFinish = 0d;
        remainingSecondsUntilDone = DEFAULT_MINUTE * Math.pow(Math.E, recipeConstant * (Double.valueOf(oven.getSetTemperature()) - DEFAULT_TEMPERATURE)) * MINUTE_TO_SECOND;
    }

    @Override public int getVolumeCubicInches() {
        return DEFAULT_BAGUETTE_VOLUME_CUBIC_INCHES;
    }

    @Override public Double getRemainingSecondsUntilDone() {
        return remainingSecondsUntilDone;
    }

    @Override public void adjust(Time unit, int amount, int ovenTemperature) {
        if (unit == Time.Minutes) {
            percentOfFinish = ((Double.valueOf(amount) * MINUTE_TO_SECOND) / remainingSecondsUntilDone) + percentOfFinish;
            remainingSecondsUntilDone = (FINISH_PERCENT - percentOfFinish) * DEFAULT_MINUTE * Math.pow(Math.E, recipeConstant * (Double.valueOf(ovenTemperature) - DEFAULT_TEMPERATURE)) * MINUTE_TO_SECOND;
        }
        else {
            percentOfFinish = (Double.valueOf(amount) / remainingSecondsUntilDone) + percentOfFinish;
            remainingSecondsUntilDone = (FINISH_PERCENT - percentOfFinish) * DEFAULT_MINUTE * Math.pow(Math.E, recipeConstant * (Double.valueOf(ovenTemperature) - DEFAULT_TEMPERATURE)) * MINUTE_TO_SECOND;
        }
    }

    @Override public boolean isRecipeDone() {
        if (percentOfFinish >= FINISH_PERCENT) {
            return true;
        }
        else {
            return false;
        }
    }
}
