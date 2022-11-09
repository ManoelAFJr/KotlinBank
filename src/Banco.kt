import java.util.*

class Banco {
    var nome: String? = null
    var scan = Scanner(System.`in`)

    private val contas: List<Conta> = ArrayList()
    private val clientes: List<Cliente> = ArrayList()

    fun Banco() {}

    @JvmName("getNome1")
    fun getNome(): String? {
        return nome
    }

    @JvmName("setNome1")
    fun setNome(nome: String?) {
        this.nome = nome
    }

    fun getContas(): List<Conta?> {
        return contas
    }

    fun setContas(contas: Conta?) {
        this.contas.add(contas)
    }

    fun getClientes(): List<Cliente?> {
        return clientes
    }

    fun setClientes(cliente: Cliente?) {
        this.clientes.add(cliente)
    }
    fun acessarMenuConta(cpf: Int) {
        for (conta in contas) {
            if (conta.cliente.cpf == cpf) {
                conta.menuConta()
            }
        }
    }

    fun getConta(numConta: Int): Conta? {
        for (conta in contas) {
            if (conta.numero == numConta) {
                return conta
            }
        }
        return null
    }

    fun listarClientes() {
        if (clientes.isEmpty()) {
            println("Nenhum Cliente cadastrado.")
        } else {
            for (cliente in clientes) {
                cliente.imprimirInformacoes()
            }
        }
    }

    fun criarConta(): Boolean {
        val opcao: Int
        var status = false
        println("|############################|")
        println("| Informe o tipo de Conta:   |")
        println("|                            |")
        println("|   1 - Conta Corrente       |")
        println("|   2 - Conta Poupança       |")
        println("|   0 - Retornar ao menu     |")
        println("|                            |")
        println("|############################|")
        opcao = scan.nextInt()
        if (opcao == 1) {
            println("Informe seu Nome:")
            val nome: String = scan.next()
            println("Informe seu CPF:")
            val cpf: Int = scan.nextInt()
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
            val nome: String = scan.next()
            println("Informe seu CPF:")
            val cpf: Int = scan.nextInt()
            status = if (!verificarCpf(cpf)) {
                val cliente = Cliente(nome, cpf)
                clientes.add(cliente)
                val contaPoupanca: Conta = ContaPoupanca(cliente)
                contas?.add(contaPoupanca)
                true
            } else {
                false
            }
        } else if (opcao == 0) {
        } else {
            println("Opção escolhida invalida!!!")
            status = false
        }
        return status
    }

    fun verificarCpf(cpf: Int): Boolean {
        var existe = false
        for (cliente in Main.banco.getClientes()) {
            existe = cliente?.cpf == cpf
        }
        return existe
    }

    fun acessarConta() {
        println("\n\nInforme seu CPF:")
        val cpf = scan.nextInt()
        acessarMenuConta(cpf)
    }
}

private fun <E> List<E>.add(Conta: E) {}
