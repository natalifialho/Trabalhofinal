package barbeariatrabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class barbeariatrabalho {

    static Scanner digitar = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Servicos> servicos = new ArrayList<>();
    static ArrayList<Agendamento> agendamentos = new ArrayList<>();
    static double faturamento = 0;

    public static void main(String[] args) {
        servicos.add(new Servicos("Corte de Cabelo", 30.0));
        servicos.add(new Servicos("Pigmentação", 50.0));

        int opcao;
        do {
            System.out.println("\n===== BARBEARIA =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Cadastrar Serviço");
            System.out.println("6 - Listar Serviços");
            System.out.println("7 - Editar Serviço");
            System.out.println("8 - Excluir Serviço");
            System.out.println("9 - Marcar Horário");
            System.out.println("10 - Ver Agendamentos");
            System.out.println("11 - Ver Faturamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = digitar.nextInt();
            digitar.nextLine();

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: editarCliente(); break;
                case 4: excluirCliente(); break;
                case 5: cadastrarServico(); break;
                case 6: listarServicos(); break;
                case 7: editarServico(); break;
                case 8: excluirServico(); break;
                case 9: marcarHorario(); break;
                case 10: listarAgendamentos(); break;
                case 11: mostrarFaturamento(); break;
                case 0: System.out.println("Sistema encerrado."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

 
    public static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = digitar.nextLine();
        clientes.add(new Cliente(nome));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n===== CLIENTES =====");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }
    }

    public static void editarCliente() {
        listarClientes();
        if (clientes.isEmpty()) return;

        System.out.print("Número do cliente: ");
        int posicao = digitar.nextInt();
        digitar.nextLine();

        if (posicao < 1 || posicao > clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        System.out.print("Novo nome: ");
        String novoNome = digitar.nextLine();
        clientes.get(posicao - 1).setNome(novoNome);
        System.out.println("Cliente atualizado.");
    }

    public static void excluirCliente() {
        listarClientes();
        if (clientes.isEmpty()) return;

        System.out.print("Número do cliente: ");
        int posicao = digitar.nextInt();

        if (posicao < 1 || posicao > clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        clientes.remove(posicao - 1);
        System.out.println("Cliente removido.");
    }

    public static void cadastrarServico() {
        System.out.print("Nome do serviço: ");
        String nome = digitar.nextLine();
        System.out.print("Preço do serviço: R$ ");
        double preco = digitar.nextDouble();
        digitar.nextLine();
        servicos.add(new Servicos(nome, preco));
        System.out.println("Serviço cadastrado com sucesso!");
    }

    public static void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return;
        }
        System.out.println("\n===== SERVIÇOS =====");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + " - " + servicos.get(i).getNome() + " (R$ " + servicos.get(i).getPreco() + ")");
        }
    }

    public static void editarServico() {
        listarServicos();
        if (servicos.isEmpty()) return;

        System.out.print("Número do serviço: ");
        int posicao = digitar.nextInt();
        digitar.nextLine();

        if (posicao < 1 || posicao > servicos.size()) {
            System.out.println("Serviço inválido.");
            return;
        }
        System.out.print("Novo nome do serviço: ");
        String novoNome = digitar.nextLine();
        System.out.print("Novo preço: R$ ");
        double novoPreco = digitar.nextDouble();
        digitar.nextLine();

        servicos.get(posicao - 1).setNome(novoNome);
        servicos.get(posicao - 1).setPreco(novoPreco);
        System.out.println("Serviço atualizado.");
    }

    public static void excluirServico() {
        listarServicos();
        if (servicos.isEmpty()) return;

        System.out.print("Número do serviço: ");
        int posicao = digitar.nextInt();

        if (posicao < 1 || posicao > servicos.size()) {
            System.out.println("Serviço inválido.");
            return;
        }
        servicos.remove(posicao - 1);
        System.out.println("Serviço removido.");
    }

    // --- AGENDAMENTOS E FINANCEIRO ---
    public static void marcarHorario() {
        if (clientes.isEmpty()) {
            System.out.println("Cadastre um cliente primeiro.");
            return;
        }
        if (servicos.isEmpty()) {
            System.out.println("Cadastre um serviço primeiro.");
            return;
        }

        listarClientes();
        System.out.print("Escolha o cliente: ");
        int clienteEscolhido = digitar.nextInt();
        if (clienteEscolhido < 1 || clienteEscolhido > clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        Cliente cliente = clientes.get(clienteEscolhido - 1);

        System.out.println("\nDias disponíveis:");
        System.out.println("1 - Terça\n2 - Quarta\n3 - Quinta\n4 - Sexta\n5 - Sábado");
        int dia = digitar.nextInt();
        digitar.nextLine();

        String diaEscolhido = switch (dia) {
            case 1 -> "Terça";
            case 2 -> "Quarta";
            case 3 -> "Quinta";
            case 4 -> "Sexta";
            case 5 -> "Sábado";
            default -> null;
        };

        if (diaEscolhido == null) {
            System.out.println("Dia inválido.");
            return;
        }

        listarServicos();
        System.out.print("Escolha o serviço: ");
        int servicoEscolhido = digitar.nextInt();
        digitar.nextLine();

        if (servicoEscolhido < 1 || servicoEscolhido > servicos.size()) {
            System.out.println("Serviço inválido.");
            return;
        }
        Servicos servico = servicos.get(servicoEscolhido - 1);

        System.out.print("Horário (Ex: 14:00): ");
        String horario = digitar.nextLine();

        Agendamento novoAgendamento = new Agendamento(cliente, servico, diaEscolhido, horario);
        agendamentos.add(novoAgendamento);

        faturamento += servico.getPreco();
        System.out.println("Agendamento realizado com sucesso!");
    }

    public static void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento.");
            return;
        }
        System.out.println("\n===== AGENDAMENTOS =====");
        for (int i = 0; i < agendamentos.size(); i++) {
            System.out.println((i + 1) + " - " + agendamentos.get(i).mostrarAgendamento());
        }
    }

    public static void mostrarFaturamento() {
        System.out.println("\n===== FATURAMENTO =====");
        System.out.println("Total arrecadado: R$ " + faturamento);
    }
}