package objects

class Voucher private constructor(val code: String, val percent: Int ) {

    companion object {
        const val MAX_PERCENT = 50

        fun welcome() = Voucher("WELCOME10", 10)
        fun student() = Voucher("STUDENT5", 5)
    }
}