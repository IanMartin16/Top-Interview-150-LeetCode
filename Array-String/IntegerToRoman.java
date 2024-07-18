public class IntegerToRoman {
    public String intToRoman(int num) {
        // Array of integer values and corresponding Roman numeral symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();

        // Loop through each value and symbol pair
        for (int i = 0; i < values.length; i++) {
            // Append the symbol to the result string while the input number is greater or equal to the value
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman converter = new IntegerToRoman();
        System.out.println(converter.intToRoman(1994));  // Output: MCMXCIV
    }
}


//Seven different symbols represent Roman numerals with the following values:

//Symbol	Value
//I	1
//V	5
//X	10
//L	50
//C	100
//D	500
//M	1000
//Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. 
//Converting a decimal place value into a Roman numeral has the following rules:

//If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, 
//append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
//If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, 
//for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 
//4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
//Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. 
//You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
//Given an integer, convert it to a Roman numeral.