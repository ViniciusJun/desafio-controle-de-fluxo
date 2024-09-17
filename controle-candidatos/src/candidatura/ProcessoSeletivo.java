package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");

        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }  
    }

    public static void entrandoEmContato(String candidato) {
        int tentativasrealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atender();
            if (continuarTentando) {
                tentativasrealizadas++;
            }else {
                System.out.println("Contato realizado com sucesso.");
            };

        } while(continuarTentando && tentativasrealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasrealizadas + " tentativa.");
        }else {
            System.out.println("Não conseguimos contato com " + candidato + " número máximo de tentativas " + tentativasrealizadas + " realizadas.");
        }
    }

        //Método auxiliar
        public static boolean atender() {
            return new Random().nextInt(3)==1;
        }



    public static void imprimirSelecionados() {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento.");

        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número de nº " + (indice+1) + " é o " + candidatos[indice]);
        }
    }

    public static void selecaoCandidatos() {
        String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: R$" + salarioPretendido);
            
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    public static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato.");
        }else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com uma contra proposta.");
        }else {
            System.out.println("Aguardando o Resultado dos demais candidatos.");
        }
    }
}
