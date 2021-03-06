import java.lang.NumberFormatException

fun main() {

    try {
        val opcao = menu()
        resultado(opcaoEscolhida = opcao, entradaValores(opcao))
        println(opcao)

    } catch (nfe: NumberFormatException) {
        println("Erro na entrada de dados. Motivo : ${nfe.localizedMessage} ")
    }
}

fun menu(): Int {
    var opcao: Int
    do {
        println("Opções")
        println("0 - SAIR")
        println("1 - ADIÇÃO")
        println("2 - SUBTRAÇÃO")
        println("3 - MULTIPLICAÇÃO")
        println("4 - DIVISÃO")
        println("5 - POTENCIAÇÃO")
        println("6 - RADICIAÇÃO")
        print("Digite a opção desejada : ")
        opcao = readLine()?.toInt() ?: -1
        if (opcao == 0) return 0
        if (opcao == -1) println("Digite uma opção válida.")
    } while (opcao !in 1..6)
    return opcao
}

fun resultado(opcaoEscolhida: Int, valor: MutableList<Int>) {

    when (opcaoEscolhida) {
        OperadoresMatematicos.opSoma -> println(valor[0].plus(valor[1]))
        OperadoresMatematicos.opSubtracao -> println(valor[0].minus(valor[1]))
        OperadoresMatematicos.opMultiplicacao -> println(valor[0].minus(valor[1]))
        OperadoresMatematicos.opDivisao -> println(valor[0].div(valor[1]))
        OperadoresMatematicos.opPotenciacao -> println(Math.pow(valor[0].toDouble(), valor[1].toDouble()))
        OperadoresMatematicos.opRadiciacao -> println(Math.sqrt(valor[0].toDouble()))
    }
}


fun entradaValores(opcaoEscolhida: Int): MutableList<Int> {

    val valor = mutableListOf<Int>()

    if (opcaoEscolhida < OperadoresMatematicos.opRadiciacao) {
        print("Digite o 1º valor: ")
        valor.add(readLine()!!.toInt())
        print("Digite o 2º valor: ")
        valor.add(readLine()!!.toInt())
    } else {
        print("Digite o valor: ")
        valor.add(readLine()!!.toInt())
    }
    return valor
}