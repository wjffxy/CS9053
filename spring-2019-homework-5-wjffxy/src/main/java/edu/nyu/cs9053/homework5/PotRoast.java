package edu.nyu.cs9053.homework5;

public class PotRoast implements Recipe {

    private static final int DEFAULT_POTROAST_VOLUME_CUBIC_INCHES = 10000;

    private static final Double DEFAULT_RECIPE_CONSTANT = 0.2;

    private static final Double FINISH_PERCENT = 1d;

    private static final Double MINUTE_TO_SECOND = 60d;

    private Double percentOfFinish;

    private Double remainingSecondsUntilDone;

    @Override public void initializeFromOven(Oven oven) {
        percentOfFinish = 0d;
        remainingSecondsUntilDone = DEFAULT_RECIPE_CONSTANT * Double.valueOf(oven.getSetTemperature()) * MINUTE_TO_SECOND;
    }

    @Override public int getVolumeCubicInches() {
        return DEFAULT_POTROAST_VOLUME_CUBIC_INCHES;
    }

    @Override public Double getRemainingSecondsUntilDone() {
        return remainingSecondsUntilDone;
    }

    @Override public void adjust(Time unit, int amount, int ovenTemperature) {
        if (unit == Time.Minutes) {
            percentOfFinish = ((Double.valueOf(amount) * MINUTE_TO_SECOND) / remainingSecondsUntilDone) + percentOfFinish;
            remainingSecondsUntilDone = (FINISH_PERCENT - percentOfFinish) * DEFAULT_RECIPE_CONSTANT * Double.valueOf(ovenTemperature) * MINUTE_TO_SECOND;
        }
        else {
            percentOfFinish = (Double.valueOf(amount) / remainingSecondsUntilDone) + percentOfFinish;
            remainingSecondsUntilDone = (FINISH_PERCENT - percentOfFinish) * DEFAULT_RECIPE_CONSTANT * Double.valueOf(ovenTemperature) * MINUTE_TO_SECOND;
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
