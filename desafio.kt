// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { FACIL, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel = Nivel.FACIL)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel = Nivel.FACIL) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        println("")
        for (usuario in usuarios) {
            if (inscritos.contains(usuario)) {
                println("${usuario.nome} já está matriculado(a) na formação \"$nome\"\n")
                continue
            }
            inscritos.add(usuario)
            println("${usuario.nome} acabou de ser matriculado(a) na formação \"$nome\"")
        }
        println("")
    }

    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
        println("\n${usuario.nome} cancelou sua matrícula na formação \"$nome\"\n")
    }

    fun listarMatriculados() {
        println("Lista de alunos matriculados na formação \"$nome\"")
        for (usuario in inscritos) {
            val index = inscritos.indexOf(usuario) + 1
            println("$index - ${usuario.nome}")
        }
    }

    fun informacoes() {
        println("\nInformações sobre a formação \"$nome\"")
        println("Nível: $nivel")
        println("CONTEÚDOS:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} - ${conteudo.duracao} minutos (${conteudo.nivel}))")
        }
        println("")
    }
}


fun main() {
    val usuario1 = Usuario("Joathan")
    val usuario2 = Usuario("Paula")
    val usuario3 = Usuario("Maria")
    val usuario4 = Usuario("João")
    val usuario5 = Usuario("José")

    val conteudo1 = ConteudoEducacional("Conhecendo a documentação", 10, Nivel.FACIL)
    val conteudo2 = ConteudoEducacional("Faça seu primeiro 'Olá, Mundo'", 15, Nivel.FACIL)
    val conteudo3 = ConteudoEducacional("Todos os tipos da linguagem", 22, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("Conhecendo o IntelliJ IDEA", 30, Nivel.INTERMEDIARIO)
    val conteudo5 = ConteudoEducacional("Conhecendo o Kotlin Playground", 40, Nivel.FACIL)

    val conteudos = listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo5)

    val formacao_kotlin = Formacao("Introdução a Kotlin", conteudos, Nivel.FACIL)

    formacao_kotlin.matricular(usuario1, usuario2, usuario3, usuario4, usuario5)
    formacao_kotlin.listarMatriculados()

    formacao_kotlin.desmatricular(usuario3)
    formacao_kotlin.listarMatriculados()

    formacao_kotlin.informacoes()
}
