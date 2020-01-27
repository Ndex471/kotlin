// !DIAGNOSTICS: -UNUSED_VARIABLE
// JAVAC_EXPECTED_FILE

import java.util.*;

// FILE: A.java
@kotlin.jvm.PurelyImplements("kotlin.collections.MutableList")
class A<T, V> extends AbstractList<T> {
    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

// FILE: b.kt

fun bar(): String? = null

fun foo() {
    var x = A<String, String>()
    x.<!INAPPLICABLE_CANDIDATE!>add<!>(null)
    x.<!INAPPLICABLE_CANDIDATE!>add<!>(bar())
    x.add("")

    <!INAPPLICABLE_CANDIDATE!>x[0] = null<!>
    <!INAPPLICABLE_CANDIDATE!>x[0] = bar()<!>
    x[0] = ""

    val b1: MutableList<String?> = x
    val b2: MutableList<String> = x
    val b3: List<String?> = x

    val b4: Collection<String?> = x
    val b6: MutableCollection<String?> = x
}
