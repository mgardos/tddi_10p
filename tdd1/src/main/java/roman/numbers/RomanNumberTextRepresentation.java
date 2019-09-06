package roman.numbers;

public class RomanNumberTextRepresentation {
    public static String of(Integer aNumber) {
        if (aNumber.equals(0)) {
            throw new IllegalArgumentException("Zero not allowed.");
        }

        StringBuilder aStringBuilder = new StringBuilder();

        Integer tens = (aNumber % 100) / 10;
        convertTens(tens, aStringBuilder);

        /*if (tens >= 1 && tens <= 3) {
            for (int i = 0; i < tens; i++) {
                aStringBuilder.append("X");
            }
        }

        if (tens == 4) {
            aStringBuilder.append("XL");
        }
        if (tens >= 5 && tens <= 8) {
            aStringBuilder.append("L");
            for (int i = 1; i <= tens-5; i++) {
                aStringBuilder.append("X");
            }
        }
        if (tens == 9) {
            aStringBuilder.append("XC");
        }*/

        Integer units = aNumber % 10;
        convertUnit(units, aStringBuilder);

        return aStringBuilder.toString();




        /*
        switch (aNumber) {
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
        }
         */
    }

    private static void convertUnit(Integer aNumber, StringBuilder aStringBuilder) {
        if (aNumber >= 1 && aNumber <= 3) {
            for (int i = 0; i < aNumber; i++) {
                aStringBuilder.append("I");
            }
        }
        if (aNumber == 4) {
            aStringBuilder.append("IV");
        }
        if (aNumber >= 5 && aNumber <= 8) {
            aStringBuilder.append("V");
            for (int i = 1; i <= aNumber-5; i++) {
                aStringBuilder.append("I");
            }
        }
        if (aNumber == 9) {
            aStringBuilder.append("IX");
        }
    }

    private static void convertTens(Integer aNumber, StringBuilder aStringBuilder) {
        if (aNumber >= 1 && aNumber <= 3) {
            for (int i = 0; i < aNumber; i++) {
                aStringBuilder.append("X");
            }
        }
        if (aNumber == 4) {
            aStringBuilder.append("XL");
        }
        if (aNumber >= 5 && aNumber <= 8) {
            aStringBuilder.append("L");
            for (int i = 1; i <= aNumber-5; i++) {
                aStringBuilder.append("X");
            }
        }
        if (aNumber == 9) {
            aStringBuilder.append("XC");
        }
    }
}
