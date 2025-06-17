import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    Scanner input = new Scanner(System.in);

    // Construtor sem parâmetros com entrada via teclado
    public Data() {
        entraDia();
        entraMes();
        entraAno();
    }

    // Construtor com parâmetros
    public Data(int d, int m, int a) {
        if (validaData(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            System.out.println("Data inválida. Atribuindo valores padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    // Métodos entraDia, entraMes, entraAno com input
    public void entraDia() {
        int d;
        while (true) {
            try {
                System.out.print("Digite o dia: ");
                d = input.nextInt();
                if (validaData(d, this.mes, this.ano)) {
                    this.dia = d;
                    break;
                } else {
                    System.out.println("Dia inválido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                input.next(); // limpa buffer
            }
        }
    }

    public void entraMes() {
        int m;
        while (true) {
            try {
                System.out.print("Digite o mês: ");
                m = input.nextInt();
                if (m >= 1 && m <= 12) {
                    this.mes = m;
                    break;
                } else {
                    System.out.println("Mês inválido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                input.next(); // limpa buffer
            }
        }
    }

    public void entraAno() {
        int a;
        while (true) {
            try {
                System.out.print("Digite o ano: ");
                a = input.nextInt();
                if (a > 0) {
                    this.ano = a;
                    break;
                } else {
                    System.out.println("Ano inválido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                input.next(); // limpa buffer
            }
        }
    }

    // Métodos entra com parâmetros
    public void entraDia(int d) {
        if (validaData(d, this.mes, this.ano)) {
            this.dia = d;
        } else {
            System.out.println("Dia inválido.");
        }
    }

    public void entraMes(int m) {
        if (m >= 1 && m <= 12) {
            this.mes = m;
        } else {
            System.out.println("Mês inválido.");
        }
    }

    public void entraAno(int a) {
        if (a > 0) {
            this.ano = a;
        } else {
            System.out.println("Ano inválido.");
        }
    }

    // Getters
    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    // mostra1
    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    // mostra2
    public String mostra2() {
        String[] meses = {
            "janeiro", "fevereiro", "março", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
        };
        return String.format("%02d/%s/%04d", dia, meses[mes - 1], ano);
    }

    // Verifica se é bissexto
    public boolean bissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Retorna dias transcorridos
    public int diasTranscorridos() {
        int[] diasPorMes = {31, bissexto() ? 29 : 28, 31, 30, 31, 30,
                            31, 31, 30, 31, 30, 31};
        int total = 0;
        for (int i = 0; i < mes - 1; i++) {
            total += diasPorMes[i];
        }
        total += dia;
        return total;
    }

    // Mostra data atual
    public void apresentaDataAtual() {
        Date hoje = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
        System.out.println("Data atual: " + formato.format(hoje));
    }

    // Validação da data
    private boolean validaData(int d, int m, int a) {
        if (m < 1 || m > 12 || d < 1 || a < 1)
            return false;

        int[] diasPorMes = {31, (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0) ? 29 : 28,
                            31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return d <= diasPorMes[m - 1];
    }
}
