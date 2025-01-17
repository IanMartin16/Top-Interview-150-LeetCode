public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string in the array as the prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Adjust the prefix until it matches the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs1));  // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs2));  // Output: ""
    }
}


//Write a function to find the longest common prefix string amongst an array of strings.

//If there is no common prefix, return an empty string "".