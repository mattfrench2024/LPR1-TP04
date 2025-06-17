public class TesteData {
    public static void main(String[] args) {
        System.out.println("### Testando Data com entrada manual ###");
        Data data1 = new Data();

        System.out.println("\nData (mostra1): " + data1.mostra1());
        System.out.println("Data (mostra2): " + data1.mostra2());
        System.out.println("Ano bissexto? " + data1.bissexto());
        System.out.println("Dias transcorridos no ano: " + data1.diasTranscorridos());
        data1.apresentaDataAtual();

        System.out.println("\n### Testando Data com valores fixos ###");
        Data data2 = new Data(29, 2, 2024);
        System.out.println("Data (mostra1): " + data2.mostra1());
        System.out.println("Data (mostra2): " + data2.mostra2());
        System.out.println("Ano bissexto? " + data2.bissexto());
        System.out.println("Dias transcorridos no ano: " + data2.diasTranscorridos());
    }
}
