package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 10:21 AM
 */
public class Program {

	public static void main(String[] args) {

        if (args[0].equals("gps")) {
            Gps[] gpsPoints = new Gps[args.length - 1];

            /** Get latitude and longitude. */
            for(int i = 1; i < args.length; i++) {
                String[] temp = args[i].split(",");
                gpsPoints[i - 1] = new Gps(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]));
            }

            System.out.println(PolylineEncoder.encodePolyline(gpsPoints));
            return;

        }

        if (args[0].equals("annuity")) {
            if (args[1].equals("compound")) {
                /** compound */
                if (!isValidInput(args,2)) {
                    System.out.println("Invalid argument");
                    return;
                }

                if (args[4].equals("15")) {
                    System.out.println(AnnuityCalculator.computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(Double.parseDouble(args[2]), Double.parseDouble(args[3])));
                    return;
                } 
                        
                else if (args[4].equals("30")) {
                    System.out.println(AnnuityCalculator.computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(Double.parseDouble(args[2]), Double.parseDouble(args[3])));
                    return;
                }
                                        
                else {
                	System.out.println(AnnuityCalculator.computeMonthlyCompoundedFutureValueOfAnnuity(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Integer.parseInt(args[4])));
                    return;
                }
            }

            else {
                /** non-compound */
                if(!isValidInput(args,1)) {
                    System.out.println("Invalid argument");
                    return;
                }

                if (args[3].equals("15")) {
                    System.out.println(AnnuityCalculator.computeFutureValueOfAnnuityIn15Years(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
                    return;
                }
                
                else if (args[3].equals("30")) {
                    System.out.println(AnnuityCalculator.computeFutureValueOfAnnuityIn30Years(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
                    return;
                }
                
                else {
                	System.out.println(AnnuityCalculator.computeFutureValueOfAnnuity(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3])));
                    return;
                }
            }
        }
        
        System.out.println("Invalid argument");
        return;
    }

    /** Check if the input only contains numbers and decimal point. */
    private static boolean isNum(String s) {

        for(int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.') {
                return false;
            }
        }
        
        return true;
    }

    /** Check all inputs are valid.
     *  begin is the first location of Inputs.
     * */
    private static boolean isValidInput(String[] s, int begin) {

        /** Check the number of Input is correct. */
        if((s.length - begin) != 3) {
            return false;
        }

        /** Check all Input is non-negative numbers. */
        for(int i = begin; i < s.length; i++) {
            if(!isNum(s[i])) {
                return false;
            }
        }

        return true;
    }
}
