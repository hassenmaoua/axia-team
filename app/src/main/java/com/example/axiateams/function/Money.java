package com.example.axiateams.function;

import java.util.Locale;

public class Money {
    public static String[] ones = {
            "", "un", "deux", "trois", "quatre",
            "cinq", "six", "sept", "huit",
            "neuf", "dix", "onze", "douze",
            "treize", "quatorze", "quinze",
            "seize", "dix-sept", "dix-huit",
            "dix-neuf"
    };

    public static String[] tens = {
            "",          // 0
            "",          // 1
            "vingt",    // 2
            "trente",    // 3
            "quarante",     // 4
            "cinquante",     // 5
            "soixante",     // 6
            "soixante-dix",   // 7
            "quatre-vingt",    // 8
            "quatre-vingt-dix"     // 9
    };


    private static String convert(long n){


        if (n < 20) {
            return ones[(int) n];
        }

        if (n < 100) {
            return tens[(int) n / 10]
                    + ((n % 10 != 0) ? " " : "")
                    + ones[(int) n % 10];
        }

        if (n < 1000) {
            return ((n / 100 != 1) ? convert(n / 100) : "") + " cent" + ((n % 100 != 0) ? " " : "")
                    + convert(n % 100);
        }

        if (n < 1_000_000) {
            return convert(n / 1000) + " mille" + ((n % 1000 != 0) ? " " : "")
                    + convert(n % 1000);
        }
        return "";
    }

    public static String getMoneyIntoWords(double money, String type) {
        long dinars = (long) money;
        long cents = Math.round((money - dinars) * 100);

        if (money == 0D) {
            return "";
        }
        if (money < 0) {
            return "INVALID_INPUT_GIVEN";
        }
        String dinarPart = "";
        if (dinars > 0) {
            dinarPart = convert(dinars)
                    + " " + type
                    + (dinars == 1 ? "" : "(s)");
        }
        String centsPart = "";
        if (cents > 0) {
            if (dinarPart.length() > 0) {
                centsPart = " et ";
            }
            centsPart += convert(cents) + " centime" + (cents == 1 ? "" : "(s)");
        }
        return dinarPart + centsPart;
    }

}
