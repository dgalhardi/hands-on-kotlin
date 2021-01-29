data class Book(
    val codigo : String,
    val nome : String,
    val preco : Double,
    var quantidade : Int
){

    init {
        println("Livro $nome cadastrado com sucesso!")
    }
}

