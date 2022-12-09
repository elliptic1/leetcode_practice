package leet_code_392

fun main() {
    println(IsSubstring().check("bc", "ahbgdc"))
}

class IsSubstring {
    fun check(s: String, t: String): Boolean {

        val regex = s.toCharArray().joinToString(".*")

        return t.matches(Regex(regex))

    }
}