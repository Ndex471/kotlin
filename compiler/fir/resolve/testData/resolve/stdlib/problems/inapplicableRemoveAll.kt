fun foo(f: () -> Any) {}

fun foo(f: (String) -> Boolean) {}

fun test() {
    foo {
        it.isEmpty()
    }
}
