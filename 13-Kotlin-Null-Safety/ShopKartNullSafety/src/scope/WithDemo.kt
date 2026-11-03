package scope

class Person(var name: String="", var age: Int=0){
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun main() {
    val person = Person("John", 30)
    println(person)

    with(person) {
        println("Name ${this.name}")
        println("Age $age")
        name = "John Smith"
    }
    println(person)
}

