package defang_ip;

public class DefangIP {
    public static void main(String[] args) {
        Solution s = new Solution();

        String ip = "1.1.1.1";

        System.out.println(s.defangIPaddr(ip));
    }
}

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}