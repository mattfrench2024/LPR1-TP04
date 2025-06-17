import java.util.Scanner;

public class TesteData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Data data = null;

        int opcao;
        do {
            System.out.println("\n===== MENU TESTE CLASSE DATA =====");
            System.out.println("1 - Criar data com valores digitados");
            System.out.println("2 - Mostrar data formato dd/mm/aaaa");
            System.out.println("3 - Mostrar data formato dd/mês/aaaa");
            System.out.println("4 - Verificar se o ano é bissexto");
            System.out.println("5 - Mostrar dias transcorridos no ano");
            System.out.println("6 - Apresentar data atual");
            System.out.println("7 - Alterar dia");
            System.out.println("8 - Alterar mês");
            System.out.println("9 - Alterar ano");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    data = new Data();
                    break;

                case 2:
                    if (data != null)
                        System.out.println("Data: " + data.mostra1());
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 3:
                    if (data != null)
                        System.out.println("Data: " + data.mostra2());
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 4:
                    if (data != null)
                        System.out.println("Ano bissexto? " + (data.bissexto() ? "Sim" : "Não"));
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 5:
                    if (data != null)
                        System.out.println("Dias transcorridos no ano: " + data.diasTranscorridos());
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 6:
                    if (data != null)
                        data.apresentaDataAtual();
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 7:
                    if (data != null)
                        data.entraDia();
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 8:
                    if (data != null)
                        data.entraMes();
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 9:
                    if (data != null)
                        data.entraAno();
                    else
                        System.out.println("Data ainda não criada.");
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
