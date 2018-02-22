package IA;

import java.util.Random;

/**
 * Created by CaioMoraes on 03/04/2017.
 */
public class Neuronio {

    double[] pesos;
    double limiar;

    public void treinar(double[][] entradas, int[] saidasDesejadas, double limiar, double taxaAprendizado, int iteracoes)
    {
        this.limiar = limiar;
        pesos = new double[entradas[0].length];


        //Inicialização de pesos: valores aleatórios
        Random random = new Random();
        for(int i = 0; i < entradas[0].length; i++)
        {
            pesos[i] = random.nextDouble();
        }


        //Treino
        for(int i = 0; i < iteracoes; i++)
        {
            int qtdErros = 0;

            for(int j = 0; j < saidasDesejadas.length; j++)
            {
                //Slide 9 pg 18
                int saidaReal = Output(entradas[j]);
                int erro = saidasDesejadas[j] - saidaReal;

                qtdErros += erro;

                //Evita atualizar pesos que já evitam erro
                if (qtdErros != 0)
                {
                    for(int k = 0; k < entradas[0].length; k++)
                    {
                        //Slide 9 pg 24
                        double delta = taxaAprendizado * entradas[j][k] * erro;
                        pesos[k] += delta;
                    }
                }
            }

            //Atingiu pesos sem erros
            if (qtdErros == 0) break;
        }

    }

    public int Output(double[] entrada)
    {
        //Junção aditiva
        double soma = 0.0;
        for(int i = 0; i < entrada.length; i++)
        {
            soma += pesos[i] * entrada[i];
        }

        //Função restritiva
        if (soma > limiar)
            return 1;
        else
            return 0;
    }

}