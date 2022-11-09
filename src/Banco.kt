import java.util.*

class Banco {
    var nome: String? = null
    val contas: List<Conta>
        get() = Companion.contas

    fun setContas(contas: Conta?) {
        this.contas.add(contas)
    }

    val clientes: List<Cliente>
        get() = Companion.clientes

    fun setClientes(cliente: Cliente?) {
        this.clientes.add(cliente)
    }

    fun getConta(numConta: Int): Conta? {
        for (conta in Companion.contas) {
            if (conta.numero == numConta) {
                return conta
            }
        }
        return null
    }

    fun listarClientes() {
        if (Companion.clientes.isEmpty()) {
            println("Nenhum Cliente cadastrado.")
        } else {
            for (cliente in Companion.clientes) {
                cliente.imprimirInformacoes()
            }
        }
    }

    companion object {
        var scan = Scanner(System.`in`)
        private val contas: MutableList<Conta> = ArrayList()
        private val clientes: MutableList<Cliente> = ArrayList()
        fun acessarMenuConta(cpf: Int) {
            for (conta in contas) {
                if (conta.cliente.cpf == cpf) {
                    conta.menuConta()
                }
            }
        }

        @JvmStatic
        fun criarConta(): Boolean {
            val opcao: Int
            var status = false
            println("|############################|")
            println("| Informe o tipo de Conta:   |")
            println("|                            |")
            println("|   1 - Conta Corrente       |")
            println("|   2 - Conta Poupan�a       |")
            println("|   0 - Retornar ao menu     |")
            println("|                            |")
            println("|############################|")
            opcao = scan.nextInt()
            if (opcao == 1) {
                println("Informe seu Nome:")
                val nome = scan.next()
                println("Informe seu CPF:")
                val cpf = scan.nextInt()
                status = if (!verificarCpf(cpf)) {
                    val cliente = Cliente(nome, cpf)
                    clientes.add(cliente)
                    val contaCorrente: Conta = ContaCorrente(cliente)
                    contas.add(contaCorrente)
                    true
                } else {
                    false
                }
            } else if (opcao == 2) {
                println("Informe seu Nome:")
                val nome = scan.next()
                println("Informe seu CPF:")
                val cpf = scan.nextInt()
                status = if (!verificarCpf(cpf)) {
                    val cliente = Cliente(nome, cpf)
                    clientes.add(cliente)
                    val contaPoupanca: Conta = ContaPoupanca(cliente)
                    contas.add(contaPoupanca)
                    true
                } else {
                    false
                }
            } else if (opcao == 0) {
            } else {
                println("Op��o escolhida invalida!!!")
                status = false
            }
            return status
        }

        fun verificarCpf(cpf: Int): Boolean {
            var existe = false
            for (cliente in Main.banco.clientes) {
                existe = if (cliente.cpf == cpf) {
                    true
                } else {
                    false
                }
            }
            return existe
        }

        @JvmStatic
        fun acessarConta() {
            println("\n\nInforme seu CPF:")
            val cpf = scan.nextInt()
            acessarMenuConta(cpf)
        }
    }
}

private fun Any.add(contas: Conta?) { }
private fun Any.add(cliente: Cliente?) {}
