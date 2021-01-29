val livros = mutableListOf<Book>()
fun main() {

    loop@ while (true) {
        println("a - Cadastrar um novo livro | b - consultar livro | c - vender um livro | Outro comando para o programa")
        when (readLine()) {
            "a" -> escolhaA()
            "b" -> escolhaB()
            "c" -> escolhaC()
            else -> break@loop
        }
    }
}

private fun escolhaC() {
    val livroEncontrado = encontraLivro()
    if (livroEncontrado != null) {
        println("Digite a quantidade")
        val quantidade = readLine()!!.toInt()
        if (livroEncontrado.quantidade >= quantidade) {
            livroEncontrado.quantidade -= quantidade
            println(" $quantidade exemplares de ${livroEncontrado.nome} vendidos!")
        } else {
            println("Não há exemplares suficientes!")
        }
    } else {
        println("Código inexistente")
    }
}

private fun escolhaB() {
    val livroEncontrado = encontraLivro()
    if (livroEncontrado != null) {
        println(livroEncontrado.toString())
    } else {
        println("Código inexistente")
    }
}

private fun encontraLivro(): Book? {
    println("Digite o código do livro:")
    val codigoDigitado = readLine().toString()
    var livroEncontrado: Book? = null
    for (livro in livros) {
        if (codigoDigitado == livro.codigo) {
            livroEncontrado = livro
        }
    }
    return livroEncontrado
}

private fun escolhaA() {
    println("Digite o código:")
    val codigo = readLine().toString()
    println("Digite o nome:")
    val nome = readLine().toString()
    println("Digite o preço:")
    val preco = readLine()!!.toDouble()
    println("Digite a quantidade:")
    val quantidade = readLine()!!.toInt()
    val livro = Book(codigo, nome, preco, quantidade)
    livros.add(livro)
}