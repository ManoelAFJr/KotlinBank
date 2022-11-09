class Cliente {
    var nome: String? = null
    var cpf = 0

    constructor(nome: String?, cpf: Int) {
        this.nome = nome
        this.cpf = cpf
    }

    constructor() {}

    fun getConta(cpf: Int): Conta? {
        for (conta in Main.banco.contas) {
            conta.imprimirInformacoes()
            if (conta.cliente.cpf == cpf) {
                return conta
            }
        }
        return null
    }

    fun imprimirInformacoes() {
        println(String.format("Titular: %s", nome))
        println(String.format("CPF: %s", cpf))
    }
}