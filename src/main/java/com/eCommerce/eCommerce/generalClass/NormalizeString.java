package com.eCommerce.eCommerce.generalClass;

public class NormalizeString {
    public static String normalizeString(String arg) {
        if (arg == null) {
            return null;
        }
        return arg.toLowerCase().replaceAll("[\\s,.-]", "");
    }
}
