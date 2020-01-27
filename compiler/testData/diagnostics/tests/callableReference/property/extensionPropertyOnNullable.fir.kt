// !CHECK_TYPE

val Any?.meaning: Int
    get() = 42

fun test() {
    val f = Any?::meaning
    <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(f.<!INAPPLICABLE_CANDIDATE!>get<!>(null))
    checkSubtype<Int>(f.get(""))
}
