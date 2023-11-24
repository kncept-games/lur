package com.kncept.lur.util;

public class SerializationUtils {

    public static String intsToString(int... values) {
        if (values == null) return null;
        if (values.length == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(values[0]);
        for(int i = 1; i < values.length; i++) {
            sb.append(",");
            sb.append(values[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[] stringToInts(String value) {
        if (value.startsWith("[") && value.endsWith("]")) try {
            String[] parts = value.substring(1, value.length() - 1).split(",");
            int[] values = new int[parts.length];
            for(int i = 0; i < parts.length; i++) {
                values[i] = Integer.parseInt(parts[i]);
            }
            return values;
        } catch (NumberFormatException e) { }
        throw new IllegalArgumentException("Unable to parse ints: " + value);
    }
}
