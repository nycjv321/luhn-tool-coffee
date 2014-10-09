package com.nycjv321.luhn;

import com.nycjv321.utilities.NumberUtilities;

/**
 * Checks and validates account numbers that contain Luhn checksums
 * Created by Javier L. Velasquez on 9/20/2014.
 */
public final class Luhn {

    /**
     * Checks to see if an account number is valid
     * @param accountNumber an account number that should be validated with a Luhn checksum
     * @return a boolean indicating if the account number was valid
     */
    public static boolean isValid(long accountNumber) {
        return getCheckSum(accountNumber, false) == 0;
    }

    private static long getCheckSum(long accountNumber, boolean hasCheckDigit) {
        String numberAsString = String.valueOf(accountNumber);

        if (hasCheckDigit) {
            numberAsString = numberAsString.substring(0, numberAsString.length() - 1);
        }

        // Create an array of numbers that constitutes each digit in the account number
        int[] numbers = NumberUtilities.convertStringToIntegerArray(numberAsString);
        for (int i = numbers.length - 2; i >= 0; i -= 2) {
            int operation = numbers[i] * 2;
            if (operation > 9) {
                numbers[i] = 0;
                String operationAsString = String.valueOf(operation);
                for (int j = 0; j < operationAsString.length(); ++j) {
                    numbers[i] += Integer.valueOf(operationAsString.substring(j, j + 1));
                }
            } else {
                numbers[i] = operation;
            }
        }
        // Calculate a summation of all the digits
        int total = NumberUtilities.summarizeIntegerArray(numbers);
        return total % 10;
    }

    /**
     * Calculates a checkdigit associated with an account number
     * @param accountNumber an account number that should be validated with a Luhn checksum
     * @param hasCheckDigit boolean indicating if the provided account number already has
     *                      a calculated check digit
     * @return a Luhn check digit
     */
    public static long getCheckDigit(long accountNumber, boolean hasCheckDigit) {
        long checkDigit = getCheckSum(accountNumber * 10, hasCheckDigit);
        if (checkDigit == 0) {
            return checkDigit;
        } else {
            return 10 - checkDigit;
        }

    }

    /**
     * Calculates a checkdigit associated with an account number
     * @param accountNumber an account number that should be validated with a Luhn checksum
     * @return a Luhn check digit
     */
    public static long getCheckDigit(long accountNumber) {
        return getCheckDigit(accountNumber, false);
    }

    public static long getCheckDigit(String accountNumber) {
        return getCheckDigit(Long.valueOf(accountNumber), false);
    }

}
