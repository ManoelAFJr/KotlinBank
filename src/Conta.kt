import java.util.*

abstract class Conta(cliente: Cliente) : IConta {
    var agencia: Int
        protected set
    var numero: Int
        protected set
    var saldo = 0.0
        protected set
    var cliente: Cliente
        protected set

    init { //
        agencia = AGENCIA_PADRAO
        numero = SEQUENCIAL++
        this.cliente = cliente
    }

    override fun sacar(valor: Double) {
        saldo -= valor
    }

    override fun depositar(valor: Double) {
        saldo += valor
    }

    override fun transferir(valor: Double, contaDestino: Conta?) {
        sacar(valor)
        contaDestino?.depositar(valor)
    }

    fun imprimirInformacoes() {
        println(String.format("Titular: %s", cliente.nome))
        println(String.format("CPF: %s", cliente.cpf))
        println(String.format("Agencia: %d", agencia))
        println(String.format("Numero: %d", numero))
        println(String.format("Saldo: %.2f", saldo))
    }

    fun menuConta() {
        val scan = Scanner(System.`in`)
        val opcao: Int
        println("|############################|")
        println("|         Menu Conta:        |")
        println("|                            |")
        println("|    1 - Deposito            |")
        println("|    2 - Saque               |")
        println("|    3 - Transferencia       |")
        println("|    4 - Extrato             |")
        println("|                            |")
        println("|############################|")
        opcao = scan.nextInt()
        val valor: Double
        val numContadestino: Int
        when (opcao) {
            1 -> {
                println("Informe o valor a ser depositado:")
                valor = scan.nextDouble()
                depositar(valor)
            }

            2 -> {
                println("Informe o valor que deseja sacar:")
                valor = scan.nextDouble()
                sacar(valor)
            }

            3 -> {
                println("Informe o valor que deseja Transferir:")
                valor = scan.nextDouble()
                println("Informe o numero da conta destino:")
                numContadestino = scan.nextInt()
                val contaDestino = Main.banco.getConta(numContadestino)
                if (contaDestino != null) {
                    transferir(valor, contaDestino)
                    println("Deposito realizado com sucesso!")
                } else {
                    println("O valor não foi depoisitado!")
                }
            }

            4 -> imprimirExtrato()
            else -> println("Opção invalida!!!")
        }
    }

    companion object {
        private const val AGENCIA_PADRAO = 1
        private var SEQUENCIAL = 1
    }
}