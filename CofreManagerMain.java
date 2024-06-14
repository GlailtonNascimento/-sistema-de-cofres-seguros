import java.util.Scanner;

public class CofreManagerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Cofres Seguros!");
        System.out.println("Por favor, escolha o tipo de cofre que deseja abrir:");
        System.out.println("1. Cofre Digital");
        System.out.println("2. Cofre Físico");
        System.out.print("Digite '1' para Cofre Digital ou '2' para Cofre Físico: ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        if (escolha == 1) {
            abrirCofreDigital(scanner);
        } else if (escolha == 2) {
            abrirCofreFisico();
        } else {
            System.out.println("Escolha inválida. Encerrando o programa.");
        }

        scanner.close();
    }

    private static void abrirCofreDigital(Scanner scanner) {
        System.out.println("\nVocê escolheu abrir um Cofre Digital.");

        // Criar um novo cofre digital e gerenciar a senha
        CofreDigital cofreDigital = new CofreDigital();
        cofreDigital.criarOuRecuperarSenha(scanner);
    }

    private static void abrirCofreFisico() {
        System.out.println("\nVocê escolheu abrir um Cofre Físico.");

        // Criar um novo cofre físico
        CofreFisico cofreFisico = new CofreFisico();
        cofreFisico.mostrarMetodoAbertura();
    }
}
