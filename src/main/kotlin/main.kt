/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/
//Prática Kotlin: Funções

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) == null
}

fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]
    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}

fun mostrarNotas(materia: String) {
    val listaNotas = materiasENotas[materia]
    if (listaNotas == null) {
        println("Matéria $materia não encontrada")
    } else {
        println("Matéria: $materia")
        listaNotas.forEachIndexed { index, nota ->
            println("Nota ${index + 1}: $nota")
        }
        val media = listaNotas.average()
        println("Média: $media\n")
    }
}

fun calcularMedia(notas: List<Double>): Double {
    return if (notas.isNotEmpty()) notas.average() else 0.0
}

fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val listaNotas = materiasENotas[materia]
    return if (listaNotas != null) {
        listaNotas.addAll(notas.toList())  // Converte o vararg para List<Double>
        true
    } else {
        false
    }
}

fun main() {
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição posicional
    adicionarDisciplina("Matemática", mutableListOf(8.0, 7.5))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia = "História", notas = mutableListOf(9.0, 6.5))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    adicionarDisciplina("Geografia")

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Ciências")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Matemática", 9.0)
    adicionarNota("História", 7.5)
    adicionarNota("Geografia", 8.5)
    adicionarNota("Ciências", 6.0)
    adicionarNota("Ciências", 8.0)
    adicionarNota("Ciências", 7.0)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("História")
    mostrarNotas("Geografia")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Física")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    //ok

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Física", 7.0, 8.0, 9.5)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Física")

    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)

    // 11: calcularMedia -> Implemente a função calcularMedia()
    //ok

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    val mediaMatematica = calcularMedia(materiasENotas["Matemática"] ?: listOf())
    val mediaHistoria = calcularMedia(materiasENotas["História"] ?: listOf())
    println("Média de Matemática: $mediaMatematica")
    println("Média de História: $mediaHistoria")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    //ok

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("Ciências")
}


