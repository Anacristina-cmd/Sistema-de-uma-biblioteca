package sistema_biblioteca;
import java.util.ArrayList;
import java.util.List;
public class Aluno {
    // ATRIBUTOS
    private String nome;
    private String numeroMatricula;
    private String curso;

    private List<Livro> emprestimos = new ArrayList<>();

    public Aluno(String nome, String numeroMatricula, String curso) {

        setNome(nome);
        setNumeroMatricula(numeroMatricula);
        setCurso(curso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {

        if (numeroMatricula == null || numeroMatricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula inválida");
        }

        this.numeroMatricula = numeroMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {

        if (curso == null) {
            curso = "";
        }

        this.curso = curso;
    }

    public List<Livro> getEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    public boolean matricularLivro(Livro livro) {

        if (livro == null) {
            throw new IllegalArgumentException("Livro nulo");
        }

        if (!livro.emprestar()) {
            return false;
        }

        emprestimos.add(livro);

        return true;
    }

    public boolean devolverLivro(Livro livro) {

        if (livro == null) {
            throw new IllegalArgumentException("Livro nulo");
        }

        boolean removido = emprestimos.remove(livro);

        if (removido) {
            livro.devolver();
        }

        return removido;
    }

    public String mostrarEmprestimos() {

        if (emprestimos.isEmpty()) {
            return nome + " não tem empréstimos.";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(nome)
          .append(" tem os seguintes livros:\n");

        for (Livro livro : emprestimos) {

            sb.append(" - ")
              .append(livro.info())
              .append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {

        return nome +
               " (" + numeroMatricula + ")" +
               " - " + curso;
    }
}
