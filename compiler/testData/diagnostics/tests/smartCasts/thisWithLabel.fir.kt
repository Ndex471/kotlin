package foo

class A(val i: Int?) {
    fun test1() {
        if (this@A.i != null) {
            useInt(this.i)
            <!INAPPLICABLE_CANDIDATE!>useInt<!>(i)
        }
    }

    inner class B {
        fun test2() {
            if (i != null) {
                <!INAPPLICABLE_CANDIDATE!>useInt<!>(this@A.i)
            }
        }
    }
}

fun A.foo() {
    if (this@foo.i != null) {
        useInt(this.i)
        <!INAPPLICABLE_CANDIDATE!>useInt<!>(i)
    }
}

fun test3() {
    useFunction {
        if(i != null) {
            <!INAPPLICABLE_CANDIDATE!>useInt<!>(this.i)
        }
    }
}

fun useInt(i: Int) = i
fun useFunction(f: A.() -> Unit) = f