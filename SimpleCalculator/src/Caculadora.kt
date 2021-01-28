import kotlin.time.times


fun main(args:Array<String>) {

    println("Entre com o primeiro valor:")
    val a = readLine()?.toInt()
    println("Entre com o segundo valor:")
    val b = readLine()?.toInt()

    if (a == null || b == null) {
        println("Entre com os dois valores")
        return
    }

    println("Entre com a operação [1] soma [2] subtração [3] multiplicação [4] divisão")

    when (readLine()) {

        "1" -> {
            val resultado = b?.let { a?.plus(it) }
            println("Valor de $a + $b = $resultado")
        }

        "2" -> {
            if (b != null) {
                if (b < a!!)
                    println("valor de b não pode ser menor que valor de a")
                else {
                    val resultado = b?.let { a?.minus(it) }
                    println("Valor de $a - $b = $resultado")
                }
            }
        }

        "3" -> {
            val resultado = b?.let { a?.times(it) }
            println("Valor de $a * $b = $resultado")
        }

        "4" -> {
            if (b != null) {
                if (b == 0 || b < a!!) {
                    val resultado = a?.div(b)
                    println("Valor de $a / $b = $resultado")
                }
            }
        }

        else -> {
            println("Não entrou com nenhuma opção válida.")
        }

    }
}

