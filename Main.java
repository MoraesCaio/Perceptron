import IA.Neuronio;
/**
 * Created by CaioMoraes on 03/04/2017.
 */
public class Main {
    public static void main(String[] args) {
		double entradas[][] = {{0,0}, {0,1}, {1,0}, {1,1}};
		double limiar = 0.2;
		double taxaAprendizado = 0.1;
		int iteracoes = 200;

		//AND
		Neuronio neuronio_AND = new Neuronio();
		int saidasDesejadasAND[] = {0,0,0,1};

		System.out.println("Treinando neurônio para operação AND");
		neuronio_AND.treinar(entradas, saidasDesejadasAND, limiar, taxaAprendizado, iteracoes);

		System.out.println("0 & 0 = " + neuronio_AND.Output(new double[]{0,0}));
		System.out.println("0 & 1 = " + neuronio_AND.Output(new double[]{0,1}));
		System.out.println("1 & 0 = " + neuronio_AND.Output(new double[]{1,0}));
		System.out.println("1 & 1 = " + neuronio_AND.Output(new double[]{1,1}));

		//OR
		Neuronio neuronio_OR = new Neuronio();
		int saidasDesejadasOR[] = {0,1,1,1};

		System.out.println("Treinando neurônio para operação OR");
		neuronio_OR.treinar(entradas, saidasDesejadasOR, limiar, taxaAprendizado, iteracoes);

		System.out.println("0 | 0 = " + neuronio_OR.Output(new double[]{0,0}));
		System.out.println("0 | 1 = " + neuronio_OR.Output(new double[]{0,1}));
		System.out.println("1 | 0 = " + neuronio_OR.Output(new double[]{1,0}));
		System.out.println("1 | 1 = " + neuronio_OR.Output(new double[]{1,1}));
    }
}
