import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CofreManager {

    private Map<Integer, Usuario> usuarios;
    private Scanner scanner;

    public CofreManager() {
        this.usuarios = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarSistema() {
        System.out.println("Bem-vindo ao Sistema de Cofres Seguros!");
        System.out.println("Por favor, escolha uma das opções:");
        System.out.println("1. Abrir um novo cofre digital");
        System.out.println("2. Abrir um novo cofre físico");
        System.out.println("3. Já tenho uma conta - Acessar cofre digital");
        System.out.println("4. Já tenho uma conta - Acessar cofre físico");
        System.out.print("Digite a opção desejada: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada
        
        switch (opcao) {
            case 1:
                criarNovoCofreDigital();
                break;
            case 2:
                criarNovoCofreFisico();
                break;
            case 3:
                acessarCofreDigital();
                break;
            case 4:
                acessarCofreFisico();
                break;
            default:
                System.out.println("Opção inválida. Encerrando o programa.");
                break;
        }
    }

    private void criarNovoCofreDigital() {
        System.out.println("\nVocê escolheu abrir um novo Cofre Digital.");

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        if (usuarios.containsKey(email.hashCode())) {
            System.out.println("Já existe um usuário registrado com este email.");
            System.out.println("Encerrando o programa.");
            return;
        }

        System.out.print("Digite a nova senha numérica (apenas números): ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(email, senha);
        usuarios.put(email.hashCode(), novoUsuario);

        System.out.println("Cofre Digital criado com sucesso!\n");
    }

    private void criarNovoCofreFisico() {
        System.out.println("\nVocê escolheu abrir um novo Cofre Físico.");
        System.out.println("Este cofre não requer registro de usuário.\n");

        CofreFisico cofreFisico = new CofreFisico();
        cofreFisico.mostrarMetodoAbertura();
    }

    private void acessarCofreDigital() {
        System.out.println("\nVocê escolheu acessar um Cofre Digital existente.");

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha numérica: ");
        String senha = scanner.nextLine();

        Usuario usuario = usuarios.get(email.hashCode());

        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Cofre Digital aberto!\n");
        } else {
            System.out.println("Senha incorreta! Você possui mais duas tentativas.\n");

            for (int i = 0; i < 2; i++) {
                System.out.print("Digite novamente a senha numérica: ");
                senha = scanner.nextLine();

                if (usuario != null && usuario.getSenha().equals(senha)) {
                    System.out.println("Cofre Digital aberto após três tentativas!\n");
                    return;
                }
            }

            System.out.println("Três tentativas de senha incorreta. Enviando senha para o email cadastrado.\n");
            // Aqui poderia ser implementado o envio da senha para o email cadastrado do usuário
        }
    }

    private void acessarCofreFisico() {
        System.out.println("\nVocê escolheu acessar um Cofre Físico.");
        System.out.println("Este cofre não requer registro de usuário.\n");

        CofreFisico cofreFisico = new CofreFisico();
        cofreFisico.mostrarMetodoAbertura();
    }

    public void encerrarSistema() {
        scanner.close();
        System.out.println("Sistema encerrado.");
    }

    public static void main(String[] args) {
        CofreManager cofreManager = new CofreManager();
        cofreManager.iniciarSistema();
        cofreManager.encerrarSistema();
    }
}
