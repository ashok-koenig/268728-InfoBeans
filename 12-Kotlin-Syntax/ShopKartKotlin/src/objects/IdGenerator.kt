package objects

object IdGenerator {
    private var last = 0L;
    fun next(): Long {
        last = last + 2;
        return last;
    }
}