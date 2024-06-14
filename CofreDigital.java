import java.util.Scanner;

public class CofreDigital {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Cofre Digital!");

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a nova senha numérica (apenas números): ");
        int senha = scanner.nextInt();

        System.out.println("\nCofre Digital criado com sucesso para o email: " + email);
        System.out.println("Senha numérica definida.");

        scanner.close();
    }
}
