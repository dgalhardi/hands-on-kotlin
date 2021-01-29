/*
Exercio 1. Crie uma função para realizar cada uma das seguintes operações matemáticas:
soma, subtração, divisão e multiplicação e retorne o resultado da respectiva operação.

Exercicio 2. Peça para o usuário digitar um número e print na tela o número ao quadrado
e sua raiz quadrada.

Exercicio 3. Peça para o usuário digitar as 3 notas do semestre e calcule sua média (soma
das notas dividido pela quantidade das notas). A nota digitada não pode ser menor do que
zero ou maior que 10. Se a média for maior ou igual a 6 o aluno passou, do contrário está
reprovado. Printe na tela a nota com apenas dois digitos apos a virgula e a situação do aluno.

Exercicio 4. Faça uma função que recebe uma palavra digitada pelo usuario e printe na tela apenas as
ultimas 3 letras da palavra. Exemplo: "cinco". Saída: "nco".

Exercicio 5. Crie uma função que recebe uma string e a inverte. Ex: amor -> roma. Depois disso, retorne
esta string com uma letra acima no alfabeto. Ex: roma -> spnb.

Exercicio 6 (Desafio): Calculadora automatizada: Peça para o usuário digitar um número, depois uma operação matemática
(+,-,/,*), depois um segundo numero. Agora printe o resultado.
 */

/**
 * Funcao principal que pede a escolha do exercicio a ser validado
 * https://github.com/diegowsu/kotlin/tree/master/SimpleCalculator
 */
fun main(args:Array<String>) {

    println("Escolha o exercicio [1],[2],[3],[4],[5],[6]")

    when (readLine()) {
        "1" -> {
            println("Entre com o primeiro valor:")
            val a = readLine()?.toInt()
            println("Entre com o segundo valor:")
            val b = readLine()?.toInt()

            if (a == null || b == null) {
                println("Entre com os dois valores")
                return
            }

            leituraOperacao()

            when (readLine()) {

                "1" -> {
                    val resultado = soma(a,b)
                    println("Valor de $a + $b = $resultado")
                }

                "2" -> {
                    if (b < a)
                        println("valor de b não pode ser menor que valor de a")
                    else {
                        val resultado = subtracao(a,b)
                        println("Valor de $a - $b = $resultado")
                    }
                }

                "3" -> {

                    val resultado = multiplicao(a,b)
                    println("Valor de $a * $b = $resultado")
                }

                "4" -> {
                    if (b == 0 || b < a) {
                        val resultado = divisao(a,b)
                        println("Valor de $a / $b = $resultado")
                    }
                }

                else -> {
                    println("Não entrou com nenhuma opção válida.")
                    return
                }
            }
        }

        "2" -> {
            println("Entre com um numero")
            val number = readLine()
            if (number != null) {
                numeroaoquadrado(number)
                raizquadrada(number.toInt())
            } else {
                println("Valor nao pode ser nulo")
            }
        }

        "3" -> {
                // todo melhoria -- passar check de validacao para func booeleano
                println("Entre com 3 notas do semestre")
                val nota1 = readLine()
                if (nota1 != null && nota1.toInt() > 0 && nota1.toInt() <= 10) {
                    val nota2 = readLine()
                    if (nota2 != null && nota2.toInt() > 0 && nota2.toInt() <= 10) {
                        val nota3 = readLine()
                        if (nota3 != null && nota3.toInt() > 0 && nota3.toInt() <= 10) {
                            val resultadoMedia = mediaritmetica(nota1.toInt(), nota2.toInt(), nota3.toInt())
                            println("Resultado é: $resultadoMedia")
                            when {
                                resultadoMedia <= 5 -> println("Você está reprovado.")
                                resultadoMedia >= 6 -> println("Você está aprovado.")
                            }
                        } else {
                            println("Nota com valor invalido.")
                        }
                    } else {
                        println("Nota com valor invalido.")
                    }
                } else {
                    println("Nota com valor invalido.")
                }
        }

        "4" -> {
            println("Entre com uma palavra:")
            val palavra = readLine()
            if (palavra != null) {
                println("Ultimas 3 letras da palavra digitada é: ")
                println(palavra.takeLast(3))
            } else {
                println("Nao pode ser nulo")
            }
        }

        "5" -> {
            println("Entre com uma palavra:")
            val palavra = readLine()
            if (palavra != null) {
                println("Palavra original: $palavra")
                println("Palavra invertida : " + invertePalavra(palavra))
            } else {
                println("Nao pode ser nulo")
            }
        }

        "6" -> {
            println("Digite um numero:")
            val a = readLine()
            val op = leituraOperacao()
            println("Digite um segundo numero:")
            val b = readLine()
            if(a != null && b != null) {
                if (op.equals("1")) soma(a.toInt(), b.toInt())
                if (op.equals("2")) subtracao(a.toInt(), b.toInt())
                if (op.equals("3")) multiplicao(a.toInt(), b.toInt())
                if (op.equals("4")) divisao(a.toInt(), b.toInt())
            } else {
                println("Valor nao pode ser nulo")
            }
        }
    }
}

/**
 * Funcao que faz a inversao de palavra. Exemplo:
 * Entrada: palavra
 * Saida: arvalap
 */
fun invertePalavra(palavra: String) : String {

    val palavras = palavra.split(" ".toRegex()).dropLastWhile {
        palavra.isEmpty()
    }.toTypedArray()
    var stringInvertida = ""
    for (i in palavras.indices) {
        val word = palavras[i]
        var palavraInvertida = ""
        for (j in word.length - 1 downTo 0) {
            palavraInvertida += word[j]
        }
        stringInvertida = "$stringInvertida$palavraInvertida "
    }
    return stringInvertida
}

/*fun validaNota(nota: Int): Boolean {
    if(nota < 0 || nota > 10) {

    }
}*/

/**
 * Funcao que faz o exponencial do numero passaso por parametro
 */
fun numeroaoquadrado(number: String?) {

    val square = { number: Int -> number* number }
    println("O quadrado do numero $number é: $square")
}

/**
 * Funcao que faz o calculo da raiz quadrada
 */
fun raizquadrada(number: Int): Int {
    for (n in 1..number) {
        if (n * n == number)
            println("A raiz quadrada do numero $number é: $n")
    }
    throw IllegalArgumentException("Não há raiz quadrada para o numero $number")
}

/**
 * Funcao que faz a media aritmetica dos numeros passados por parametro
 */
fun mediaritmetica(nota1: Int, nota2: Int, nota3: Int): Int {
    val soma = nota1 + nota2 + nota3
    return soma.div(3)
}

/**
 * Dado dois numeros funcao faz a soma deles
 */
fun soma(a: Int, b: Int) {
    b.let {
        a.plus(it)
    }
}

/**
 * Dado dois numeros funcao faz a subtracao deles
 */
fun subtracao(a: Int, b: Int) {
    b.let { a.minus(it) }
}

/**
 * Dados dois numeros funcao faz a multiplicao deles
 */
fun multiplicao(a: Int, b: Int) {
    b.let { a.times(it) }
}

/**
 * Dados dois numeros funcao faz a divisao deles
 */
fun divisao(a: Int, b: Int) {
    a.div(b)
}

/** Funcao que faz a leitura da operacao entrada pelo usuario. Opcoes:
 * soma
 * subtracao
 * multiplicao
 * divisao
 */
fun leituraOperacao() {
    println("Entre com a operação [1] soma [2] subtração [3] multiplicação [4] divisão")
    readLine()
}






