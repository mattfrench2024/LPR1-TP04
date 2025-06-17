import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    Scanner sc = new Scanner(System.in);

    private static final String[] MESES = {
        "", "janeiro", "fevereiro", "março", "abril", "maio", "junho",
        "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
    };

    // Construtor com entrada via teclado e validação
    public Data() {
        entraDia();
        entraMes();
        entraAno();
    }

    // Construtor com parâmetros e validação
    public Data(int d, int m, int a) {
        if (validaData(d, m, a)) {
            dia = d;
            mes = m;
            ano = a;
        } else {
            System.out.println("Data inválida. Valores padrões definidos.");
            dia = 1;
            mes = 1;
            ano = 2000;
        }
    }

    public void entraDia(int d) {
        if (validaData(d, this.mes, this.ano)) {
            this.dia = d;
        } else {
            System.out.println("Dia inválido.");
        }
    }

    public void entraMes(int m) {
        if (validaData(this.dia, m, this.ano)) {
            this.mes = m;
        } else {
            System.out.println("Mês inválido.");
        }
    }

    public void entraAno(int a) {
        if (validaData(this.dia, this.mes, a)) {
            this.ano = a;
        } else {
            System.out.println("Ano inválido.");
        }
    }

    public void entraDia() {
        int d;
        do {
            System.out.print("Digite o dia: ");
            d = sc.nextInt();
        } while (!validaData(d, this.mes, this.ano));
        this.dia = d;
    }

    public void entraMes() {
        int m;
        do {
            System.out.print("Digite o mês: ");
            m = sc.nextInt();
        } while (!validaData(this.dia, m, this.ano));
        this.mes = m;
    }

    public void entraAno() {
        int a;
        do {
            System.out.print("Digite o ano: ");
            a = sc.nextInt();
        } while (!validaData(this.dia, this.mes, a));
        this.ano = a;
    }

    public int retDia() {
        return dia;
    }

    public int retMes() {
        return mes;
    }

    public int retAno() {
        return ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {
        return String.format("%02d/%s/%04d", dia, MESES[mes], ano);
    }

    public boolean bissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasPorMes = {0, 31, (bissexto() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = 0;
        for (int i = 1; i < mes; i++) {
            total += diasPorMes[i];
        }
        return total + dia;
    }

    public void apresentaDataAtual() {
        Date hoje = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + df.format(hoje));
    }

    private boolean validaData(int d, int m, int a) {
        if (a < 1 || m < 1 || m > 12) return false;

        int[] diasPorMes = {0, 31, (bissextoAno(a) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return d >= 1 && d <= diasPorMes[m];
    }

    private boolean bissextoAno(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
