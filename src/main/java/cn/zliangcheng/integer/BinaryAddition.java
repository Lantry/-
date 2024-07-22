package cn.zliangcheng.integer;

public class BinaryAddition {
    public String addBinary(String a, String b) {
        int carry = 0;
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while (aLen >= 0 || bLen >= 0) {
            int j = aLen >= 0 ? a.charAt(aLen--) - '0' : 0;
            int k = bLen >= 0 ? b.charAt(bLen--) - '0' : 0;
            int sum = j + k + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            res.append(sum);
        }
        if (carry == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
