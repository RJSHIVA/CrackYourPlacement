

class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "-1";
        
        HashMap<Character, Integer> mapP = new HashMap<>();
        for (char ch : p.toCharArray()) {
            mapP.put(ch, mapP.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        int start = 0, minLen = Integer.MAX_VALUE, count = 0;
        int minStart = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
            
            if (mapP.containsKey(ch) && mapS.get(ch) <= mapP.get(ch)) {
                count++;
            }
            
            while (count == p.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                
                char startChar = s.charAt(start);
                mapS.put(startChar, mapS.get(startChar) - 1);
                if (mapP.containsKey(startChar) && mapS.get(startChar) < mapP.get(startChar)) {
                    count--;
                }
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLen);
    }
    
   
}
