// !CHECK_TYPE

fun whileLoop(x: Int?) {
    outer@ while (x != 0) {
        while (x != 1) {
            if (x == 2) continue@outer
        }
        <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
    }
    <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
}

fun doWhileLoop(x: Int?) {
    outer@ while (x != 0) {
        do {
            if (x == 2) continue@outer
        } while (x == null)
        <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
    }
    <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
}

fun whileLoopContinueInnerOuter(x: Int?) {
    outer@ while (x != 0) {
        inner@ while (x != 1) {
            while (x != 2) {
                if (x == 3) continue@inner
            }
            <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
        }
        <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
    }
    <!INAPPLICABLE_CANDIDATE!>checkSubtype<!><Int>(x)
}
