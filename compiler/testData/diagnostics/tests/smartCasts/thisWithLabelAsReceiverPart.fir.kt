package foo

class C(val i: Int?) {}

class A(val c: C) {
    fun test1() {
        if (this@A.c.i != null) {
            useInt(this.c.i)
            <!INAPPLICABLE_CANDIDATE!>useInt<!>(c.i)
        }
    }

    inner class B {
        fun test2() {
            if (c.i != null) {
                <!INAPPLICABLE_CANDIDATE!>useInt<!>(this@A.c.i)
            }
        }
    }
}

fun A.foo() {
    if (this@foo.c.i != null) {
        useInt(this.c.i)
        <!INAPPLICABLE_CANDIDATE!>useInt<!>(c.i)
    }
}

fun test3() {
    useFunction {
        if(c.i != null) {
            <!INAPPLICABLE_CANDIDATE!>useInt<!>(this.c.i)
        }
    }
}

fun useInt(i: Int) = i
fun useFunction(f: A.() -> Unit) = f

