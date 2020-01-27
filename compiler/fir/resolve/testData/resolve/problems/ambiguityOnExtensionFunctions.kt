interface A

interface B : A

val A.name: String?
    get() = ""

val B?.name: String?
    get() = ""

fun test(b: B) {
    // NB: in old FE, we also have ambiguity here
    val id = b.<!AMBIGUITY!>name<!>
}
