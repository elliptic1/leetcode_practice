package leet_code_230.items_match_rule;

import java.util.ArrayList;
import java.util.List;

public class ItemsMatchRule {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> items = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("phone");
        item1.add("blue");
        item1.add("pixel");
        items.add(item1);

        List<String> item2 = new ArrayList<>();
        item2.add("computer");
        item2.add("silver");
        item2.add("lenovo");
        items.add(item2);

        List<String> item3 = new ArrayList<>();
        item3.add("phone");
        item3.add("gold");
        item3.add("iphone");
        items.add(item3);

        String ruleKey = "color";
        String ruleValue = "silver";

        System.out.println(s.countMatches(items, ruleKey, ruleValue));
    }
}

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int matches = 0;

        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (item.get(0).equals(ruleValue)) {
                        matches++;
                    }
                    break;
                case "color":
                    if (item.get(1).equals(ruleValue)) {
                        matches++;
                    }
                    break;
                case "name":
                    if (item.get(2).equals(ruleValue)) {
                        matches++;
                    }
                    break;
            }
        }

        return matches;

    }
}
