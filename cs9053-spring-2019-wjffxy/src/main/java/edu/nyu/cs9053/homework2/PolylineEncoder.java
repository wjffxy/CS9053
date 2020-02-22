package edu.nyu.cs9053.homework2;

import java.math.*;
/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:02 AM
 *
 * Implements the Polyline Algorithm defined here
 * {@literal https://developers.google.com/maps/documentation/utilities/polylinealgorithm}
 */
public class PolylineEncoder {

    public static String encodePolyline(Gps[] gpsPoints) {

        int lastLat = 0;
        int lastLng = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < gpsPoints.length; i++) {
            int lat = (int) Math.round(gpsPoints[i].getLatitude() * 1e5);
            int lng = (int) Math.round(gpsPoints[i].getLongitude() * 1e5);

            int dLat = lat - lastLat;
            int dLng = lng - lastLng;

            encode(dLat, result);
            encode(dLng, result);

            lastLat = lat;
            lastLng = lng;
        }
        return result.toString();
    }

    private static void encode(int value, StringBuilder result) {
        int num = value < 0 ? ~(value << 1) : value << 1;
        while (num >= 0x20) {
            result.append(Character.toChars((int) ((0x20 | (num & 0x1f)) + 63)));
            num >>= 5;
        }
        result.append(Character.toChars((int) (num + 63)));
    }
}
