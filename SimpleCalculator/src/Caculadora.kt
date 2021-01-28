fun main(args:Array<String>) {

    //Exercicio 1
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
            val resultado = b.let { a.plus(it) }
            println("Valor de $a + $b = $resultado")
        }

        "2" -> {
                if (b < a)
                    println("valor de b não pode ser menor que valor de a")
                else {
                    val resultado = b.let { a.minus(it) }
                    println("Valor de $a - $b = $resultado")
                }
        }

        "3" -> {

            val resultado = b.let { a.times(it) }
            println("Valor de $a * $b = $resultado")
        }

        "4" -> {
                if (b == 0 || b < a) {
                    val resultado = a.div(b)
                    println("Valor de $a / $b = $resultado")
                }
        }

        else -> {
            println("Não entrou com nenhuma opção válida.")
        }
    }

    // Exercicio 2
    println("Entre com um numero")
    val number = readLine()
    if (number != null) {
        numeroaoquadrado(number)
        raizquadrada(number.toInt())
    }

    // Exercicio 3
    println("Entre com 3 notas do semestre")
    val nota1 = readLine()
    //if (nota1 != null && validaNota(nota1.toInt())) {


    //}
    val nota2 = readLine()
    val nota3 = readLine()
    val resultadoMedia = nota2?.let {
        if (nota1 != null) {
            if (nota3 != null) {
                mediaritmetica(nota1.toInt(), it.toInt(), nota3.toInt())
            }
        }
    }
    println("Resultado é: $resultadoMedia")

}

fun validaNota(nota: Int) {
    if(nota < 0 || nota > 10) {

    }
}

fun numeroaoquadrado(number: String?) {

    val square = { number: Int -> number* number }
    println("O quadrado do numero $number é: $square")
}

fun raizquadrada(number: Int): Int {
    for (n in 1..number) {
        if (n * n == number)
            println("A raiz quadrada do numero $number é: $n")
    }
    throw IllegalArgumentException("Não há raiz quadrada para o numero $number")
}

fun mediaritmetica(nota1: Int, nota2: Int, nota3: Int): Int {
    val soma = nota1 + nota2 + nota3
    return soma.div(3)
}







