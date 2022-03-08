package leet_code_205

fun main() {
    Solution().isIsomorphic("badc", "baba")
}

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {


        /*

        split t,

        foreach letter replace it in s

        check equality


        s = "badc"
        t = "baba"

        /step 1
        "badc".replace("b", "b") -> add to map

        /step 2
        "badc".replace("a", "a") -> add to map

        /step 3
        "badc".replace("d", "b") -> "babc"

        /step 4
        "babc".replace("c", "a") -> "baba"

        true
        */

        val lettersInS = s.split("") // O(s) space
        val lettersInT = t.split("") // O(s) space

        val usedMappingsStoT = mutableMapOf<String, String>() // O(s)
        val usedMappingsTtoS = mutableMapOf<String, String>() // O(s)


        lettersInT.forEachIndexed { i, tletter -> // O(s) time
            val sletter = lettersInS[i]
            println("checking $sletter and $tletter")
            if (sletter != "" && tletter != "") {
                if (usedMappingsStoT.contains(sletter) && usedMappingsStoT[sletter] != tletter) {
                    println("used s mapping key found ${usedMappingsStoT[sletter]} and $tletter")
                    return false
                }
                if (usedMappingsTtoS.contains(tletter) && usedMappingsTtoS[tletter] != sletter) {
                    println("used t mapping key found ${usedMappingsTtoS[tletter]} and $sletter")
                    return false
                }
                usedMappingsStoT[sletter] = tletter
                usedMappingsTtoS[tletter] = sletter
            }
        }

        return usedMappingsStoT.keys.size == usedMappingsTtoS.keys.size

    }
}