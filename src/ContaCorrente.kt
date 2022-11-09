class ContaCorrente(cliente: Cliente?) : Conta(cliente!!) {
    override fun imprimirExtrato() {
        println("=== Extrato Conta Corrente ===")
        super.imprimirInformacoes()
    }
}