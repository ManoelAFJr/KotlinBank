

import Banco.Companion.criarConta
import java.util.*

object Main {
    var banco = Banco()
    var scan = Scanner(System.`in`)
    var status = true

    @JvmStatic
    fun main(args: Array<String>) {
        println("Informe o nome do Banco:")
        val nome = scan.next()
        banco.nome = nome
        render()
    }

    private fun render() {
        var opcao: Int
        while (status) {
            println(""" Banco ${banco.nome}""".trimIndent())
            println("1 - Criar conta     >>>")
            println("2 - Acessar conta   >>>")
            println("3 - Listar Clientes >>>")
            println("0 - Sair            >>>")
            opcao = scan.nextInt()
            when (opcao) {
                0 -> {
                    status = false
                }
                1 -> {
                    if (criarConta()) {
                        banco.acessarConta()
                        break
                    } else {
                        println("Já existe uma conta com esse CPF!")
                        break
                    }
                }
                2 -> {
                    banco.acessarConta()
                    break
                }
                3 -> {
                    banco.listarClientes()
                    break
                }
                0-> {
                    println("Operação indevida!!!")
                    status = false
                    break
                }
            }
        }
    }
}