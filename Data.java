import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    Scanner input = new Scanner(System.in);

    public Data() {
        entraDia();
        entraMes();
        entraAno();
    }

    public Data(int d, int m, int a) {
        if (dataValida(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            System.out.println("Data inválida. Atribuindo valores padrão (1/1/2000).");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public void entraDia(int d) {
        if (dataValida(d, this.mes, this.ano)) {
            this.dia = d;
        } else {
            System.out.println("Dia inválido.");
        }
    }

    public void entraMes(int m) {
        if (dataValida(this.dia, m, this.ano)) {
            this.mes = m;
        } else {
            System.out.println("Mês inválido.");
        }
    }

    public void entraAno(int a) {
        if (dataValida(this.dia, this.mes, a)) {
            this.ano = a;
        } else {
            System.out.println("Ano inválido.");
        }
    }

    public void entraDia() {
        while (true) {
            try {
                System.out.print("Digite o dia: ");
                int d = Integer.parseInt(input.nextLine());
                if (dataValida(d, this.mes, this.ano)) {
                    this.dia = d;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro! Digite um número inteiro válido para o dia.");
            }
        }
    }

    public void entraMes() {
        while (true) {
            try {
                System.out.print("Digite o mês: ");
                int m = Integer.parseInt(input.nextLine());
                if (dataValida(this.dia, m, this.ano)) {
                    this.mes = m;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro! Digite um número inteiro válido para o mês.");
            }
        }
    }

    public void entraAno() {
        while (true) {
            try {
                System.out.print("Digite o ano: ");
                int a = Integer.parseInt(input.nextLine());
                if (dataValida(this.dia, this.mes, a)) {
                    this.ano = a;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro! Digite um número inteiro válido para o ano.");
            }
        }
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
        String[] meses = {"janeiro", "fevereiro", "março", "abril", "maio", "junho",
                          "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
        return String.format("%02d/%s/%04d", dia, meses[mes - 1], ano);
    }

    public boolean bissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasMes = {31, (bissexto() ? 29 : 28), 31, 30, 31, 30,
                         31, 31, 30, 31, 30, 31};
        int total = 0;
        for (int i = 0; i < mes - 1; i++) {
            total += diasMes[i];
        }
        total += dia;
        return total;
    }

    public void apresentaDataAtual() {
        Date hoje = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + formato.format(hoje));
    }

    private boolean dataValida(int d, int m, int a) {
        if (m < 1 || m > 12) return false;
        if (a < 1) return false;

        int[] diasMes = {31, (bissexto() ? 29 : 28), 31, 30, 31, 30,
                         31, 31, 30, 31, 30, 31};

        return d >= 1 && d <= diasMes[m - 1];
    }
}
