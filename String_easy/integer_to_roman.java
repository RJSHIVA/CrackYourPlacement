class Solution {
  
    public  String intToRoman(int num) {
String M[] = {"", "M", "MM", "MMM"};
String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}


}






// class Solution {
//     public String intToRoman(int num) {
//         StringBuilder sb = new StringBuilder();
//         while (num >= 1000) {
//             sb.append('M');
//             num -= 1000;
//         }
//         if (num >= 900) {
//             sb.append("CM");
//             num -= 900;
//         }
//         if (num >= 500) {
//             sb.append('D');
//             num -= 500;
//         }
//         if (num >= 400) {
//             sb.append("CD");
//             num -= 400;
//         }
//         while (num >= 100) {
//             sb.append('C');
//             num -= 100;
//         }
//         if (num >= 90) {
//             sb.append("XC");
//             num -= 90;
//         }
//         if (num >= 50) {
//             sb.append('L');
//             num -= 50;
//         }
//         if (num >= 40) {
//             sb.append("XL");
//             num -= 40;
//         }
//         while (num >= 10) {
//             sb.append('X');
//             num -= 10;
//         }
//         if (num >= 9) {
//             sb.append("IX");
//             num -= 9;
//         }
//         if (num >= 5) {
//             sb.append('V');
//             num -= 5;
//         }
//         if (num >= 4) {
//             sb.append("IV");
//             num -= 4;
//         }
//         while (num > 0) {
//             sb.append('I');
//             num--;
//         }
//         return sb.toString();
//     }
// }



