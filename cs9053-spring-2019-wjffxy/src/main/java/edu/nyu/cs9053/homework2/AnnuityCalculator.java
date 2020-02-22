package edu.nyu.cs9053.homework2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: blangel
 * Date: 9/5/15
 * Time: 10:24 AM
 *
 * Hint, to compute the future value of an annuity
 * FVa = P * [ (((1 + r)^t) - 1) / r ]
 *  where P is the payment amount
 *  where r is the interest rate
 *  and where t is the time in years (e.g., 6 months t=0.5)
 *
 * Hint, to compute the future value of an annuity with compounding
 * FVac = P * [ (((1 + (r / m))^(m * t)) - 1) / (r / m) ]
 *  where P is the payment amount
 *  where r is the interest rate
 *  where m is the number of compounding periods in a year (e.g., annually m=1, semiannually m=2, quarterly m=4, monthly m=12)
 *  and where t is the time in years (e.g., 6 months t=0.5)
 */
public class AnnuityCalculator {

    /**
     * Use this scale when doing BigDecimal division.
     */
    private static final int DEFAULT_SCALE = 10;

    /**
     * Use this rounding mode when doing BigDecimal division.
     */
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static BigDecimal computeFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {
        
        BigDecimal futureValueOfAnnuity;
        BigDecimal annualInterestRate = new BigDecimal(Double.toString(annualInterestRateInPercent/100));  
        
        futureValueOfAnnuity = new BigDecimal(1).add(annualInterestRate);
        futureValueOfAnnuity = futureValueOfAnnuity.pow(15);
        futureValueOfAnnuity = futureValueOfAnnuity.subtract(new BigDecimal(1));
        futureValueOfAnnuity = futureValueOfAnnuity.divide(annualInterestRate, DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        futureValueOfAnnuity = new BigDecimal(Double.toString(annuityAmount)).multiply(futureValueOfAnnuity);
        
        return futureValueOfAnnuity;
    }

    public static BigDecimal computeFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {
        
        BigDecimal futureValueOfAnnuity;
        BigDecimal annualInterestRate = new BigDecimal(Double.toString(annualInterestRateInPercent/100));  
        
        futureValueOfAnnuity = new BigDecimal(1).add(annualInterestRate);
        futureValueOfAnnuity = futureValueOfAnnuity.pow(30);
        futureValueOfAnnuity = futureValueOfAnnuity.subtract(new BigDecimal(1));
        futureValueOfAnnuity = futureValueOfAnnuity.divide(annualInterestRate, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        futureValueOfAnnuity = new BigDecimal(Double.toString(annuityAmount)).multiply(futureValueOfAnnuity);
        
        return futureValueOfAnnuity;
    }

    public static BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {
        
        BigDecimal monthlyCompoundedFutureValueOfAnnuity;
        BigDecimal annualInterestRate = new BigDecimal(Double.toString(annualInterestRateInPercent/100)); 
        
        monthlyCompoundedFutureValueOfAnnuity = annualInterestRate.divide(new BigDecimal(12), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE); 
        monthlyCompoundedFutureValueOfAnnuity = new BigDecimal(1).add(monthlyCompoundedFutureValueOfAnnuity);
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.pow(12 * 15);
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.subtract(new BigDecimal(1));
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.divide(annualInterestRate.divide(new BigDecimal(12), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        monthlyCompoundedFutureValueOfAnnuity = new BigDecimal(Double.toString(annuityAmount)).multiply(monthlyCompoundedFutureValueOfAnnuity);
        
        return monthlyCompoundedFutureValueOfAnnuity;
    }

    public static BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {
        
        BigDecimal monthlyCompoundedFutureValueOfAnnuity;
        BigDecimal annualInterestRate = new BigDecimal(Double.toString(annualInterestRateInPercent/100)); 
        
        monthlyCompoundedFutureValueOfAnnuity = annualInterestRate.divide(new BigDecimal(12), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE); 
        monthlyCompoundedFutureValueOfAnnuity = new BigDecimal(1).add(monthlyCompoundedFutureValueOfAnnuity);
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.pow(12 * 30);
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.subtract(new BigDecimal(1));
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.divide(annualInterestRate.divide(new BigDecimal(12), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        monthlyCompoundedFutureValueOfAnnuity = new BigDecimal(Double.toString(annuityAmount)).multiply(monthlyCompoundedFutureValueOfAnnuity);
        
        return monthlyCompoundedFutureValueOfAnnuity;
    }

    public static BigDecimal computeFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {
        
        BigDecimal futureValueOfAnnuity;
        BigDecimal annualInterestRate = new BigDecimal(Double.toString(annualInterestRateInPercent/100));  
        
        futureValueOfAnnuity = new BigDecimal(1).add(annualInterestRate);
        futureValueOfAnnuity = futureValueOfAnnuity.pow(years);
        futureValueOfAnnuity = futureValueOfAnnuity.subtract(new BigDecimal(1));
        futureValueOfAnnuity = futureValueOfAnnuity.divide(annualInterestRate, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        futureValueOfAnnuity = new BigDecimal(Double.toString(annuityAmount)).multiply(futureValueOfAnnuity);
        
        return futureValueOfAnnuity;
    }

    public static BigDecimal computeMonthlyCompoundedFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {
        
        BigDecimal monthlyCompoundedFutureValueOfAnnuity;
        BigDecimal annualInterestRate = new BigDecimal(Double.toString(annualInterestRateInPercent/100)); 
        
        monthlyCompoundedFutureValueOfAnnuity = annualInterestRate.divide(new BigDecimal(12), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE); 
        monthlyCompoundedFutureValueOfAnnuity = new BigDecimal(1).add(monthlyCompoundedFutureValueOfAnnuity);
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.pow(12 * years);
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.subtract(new BigDecimal(1));
        monthlyCompoundedFutureValueOfAnnuity = monthlyCompoundedFutureValueOfAnnuity.divide(annualInterestRate.divide(new BigDecimal(12), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        monthlyCompoundedFutureValueOfAnnuity = new BigDecimal(Double.toString(annuityAmount)).multiply(monthlyCompoundedFutureValueOfAnnuity);
        
        return monthlyCompoundedFutureValueOfAnnuity;
    }

}