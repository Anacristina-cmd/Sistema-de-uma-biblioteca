package sistema_biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Sistema_Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Livro> livros = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n========== SISTEMA BIBLIOTECA ==========");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Listar Alunos");
            System.out.println("5 - Emprestar Livro");
            System.out.println("6 - Devolver Livro");
            System.out.println("7 - Mostrar Empréstimos do Aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRO DE LIVRO ---");

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("ISBN (13 caracteres): ");
                    String isbn = scanner.nextLine();

                    try {

                        Livro livro = new Livro(titulo, autor, isbn);

                        livros.add(livro);

                        System.out.println("Livro cadastrado com sucesso!");

                    } catch (Exception e) {

                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;
                case 2:

                    System.out.println("\n--- CADASTRO DE ALUNO ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Número da matrícula: ");
                    String matricula = scanner.nextLine();

                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();

                    try {

                        Aluno aluno = new Aluno(nome, matricula, curso);

                        alunos.add(aluno);

                        System.out.println("Aluno cadastrado com sucesso!");

                    } catch (Exception e) {

                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 3:

                    System.out.println("\n--- LISTA DE LIVROS ---");

                    if (livros.isEmpty()) {

                        System.out.println("Nenhum livro cadastrado.");

                    } else {

                        for (int i = 0; i < livros.size(); i++) {

                            System.out.println(
                                i + " - " + livros.get(i).info()
                            );
                        }
                    }

                    break;

                case 4:

                    System.out.println("\n--- LISTA DE ALUNOS ---");

                    if (alunos.isEmpty()) {

                        System.out.println("Nenhum aluno cadastrado.");

                    } else {

                        for (int i = 0; i < alunos.size(); i++) {

                            System.out.println(
                                i + " - " + alunos.get(i)
                            );
                        }
                    }

                    break;

                case 5:

                    System.out.println("\n--- EMPRÉSTIMO DE LIVRO ---");

                    if (livros.isEmpty() || alunos.isEmpty()) {

                        System.out.println(
                            "Cadastre livros e alunos primeiro."
                        );

                        break;
                    }

                    System.out.println("\nAlunos:");
                    for (int i = 0; i < alunos.size(); i++) {

                        System.out.println(
                            i + " - " + alunos.get(i)
                        );
                    }

                    System.out.print("Escolha o aluno: ");
                    int alunoIndex = scanner.nextInt();

                    System.out.println("\nLivros:");
                    for (int i = 0; i < livros.size(); i++) {

                        System.out.println(
                            i + " - " + livros.get(i).info()
                        );
                    }

                    System.out.print("Escolha o livro: ");
                    int livroIndex = scanner.nextInt();

                    scanner.nextLine();

                    try {

                        Aluno aluno = alunos.get(alunoIndex);
                        Livro livro = livros.get(livroIndex);

                        boolean sucesso =
                            aluno.matricularLivro(livro);

                        if (sucesso) {

                            System.out.println(
                                "Livro emprestado com sucesso!"
                            );

                        } else {

                            System.out.println(
                                "Livro indisponível."
                            );
                        }

                    } catch (Exception e) {

                        System.out.println(
                            "Erro ao realizar empréstimo."
                        );
                    }

                    break;

                case 6:

                    System.out.println("\n--- DEVOLUÇÃO DE LIVRO ---");

                    if (alunos.isEmpty()) {

                        System.out.println(
                            "Nenhum aluno cadastrado."
                        );

                        break;
                    }

                    for (int i = 0; i < alunos.size(); i++) {

                        System.out.println(
                            i + " - " + alunos.get(i)
                        );
                    }

                    System.out.print("Escolha o aluno: ");
                    int alunoDev = scanner.nextInt();

                    scanner.nextLine();

                    try {

                        Aluno aluno = alunos.get(alunoDev);

                        List<Livro> emprestimos =
                            aluno.getEmprestimos();

                        if (emprestimos.isEmpty()) {

                            System.out.println(
                                "Este aluno não possui livros."
                            );

                            break;
                        }

                        for (int i = 0; i < emprestimos.size(); i++) {

                            System.out.println(
                                i + " - " +
                                emprestimos.get(i).info()
                            );
                        }

                        System.out.print(
                            "Escolha o livro para devolver: "
                        );

                        int livroDev = scanner.nextInt();

                        scanner.nextLine();

                        boolean devolvido =
                            aluno.devolverLivro(
                                emprestimos.get(livroDev)
                            );

                        if (devolvido) {

                            System.out.println(
                                "Livro devolvido com sucesso!"
                            );

                        } else {

                            System.out.println(
                                "Erro na devolução."
                            );
                        }

                    } catch (Exception e) {

                        System.out.println(
                            "Erro ao devolver livro."
                        );
                    }

                    break;

                case 7:

                    System.out.println(
                        "\n--- EMPRÉSTIMOS DO ALUNO ---"
                    );

                    if (alunos.isEmpty()) {

                        System.out.println(
                            "Nenhum aluno cadastrado."
                        );

                        break;
                    }

                    for (int i = 0; i < alunos.size(); i++) {

                        System.out.println(
                            i + " - " + alunos.get(i)
                        );
                    }

                    System.out.print(
                        "Escolha o aluno: "
                    );

                    int alunoEmp = scanner.nextInt();

                    scanner.nextLine();

                    try {

                        System.out.println(
                            alunos.get(alunoEmp)
                                  .mostrarEmprestimos()
                        );

                    } catch (Exception e) {

                        System.out.println(
                            "Aluno inválido."
                        );
                    }

                    break;

                case 0:

                    System.out.println(
                        "\nEncerrando sistema..."
                    );

                    break;
                default:

                    System.out.println(
                        "\nOpção inválida."
                    );
            }

        } while (opcao != 0);

        scanner.close();
    } 
}
