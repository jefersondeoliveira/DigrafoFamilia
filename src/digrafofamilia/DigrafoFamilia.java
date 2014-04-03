package digrafofamilia;

public class DigrafoFamilia {

    static String[] nome = {"Emerson", "Isadora", "Alfredo", "Renata", "Antonio", "Cecilia"};
    static final int ORDEM = 6;
    static int[][] grafo = new int[ORDEM][ORDEM];

    public static void inicializa() {
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                grafo[i][j] = 0;
            }
        }
    }

    public static void imprime() {
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void conecta(int v, int w, int temp) {
        grafo[v][w] = temp; //parte de v e chega em w
    }

    public static void desconecta(int v, int w) {
        grafo[v][w] = 0;
    }

    public static int grauEmissao(int v) //ponto de partida ou seja sai de v
    {
        int qtde = 0;
        for (int j = 0; j < ORDEM; j++) {
            if (grafo[v][j] != 0) //vai de v e cheja em j
            {
                qtde++;
            }
        }
        return qtde;
    }

    public static int grauRecepcao(int v) //ponto de partida ou seja sai de v
    {
        int qtde = 0;
        for (int j = 0; j < ORDEM; j++) {
            if (grafo[j][v] != 0) //vai de v e cheja em j
            {
                qtde++;
            }
        }
        return qtde;
    }

    public static String sucessor(int v) //ponto de partida ou seja sai de v
    {
        String resposta = "";
        for (int j = 0; j < ORDEM; j++) {
            if (grafo[v][j] != 0) //vai de v e cheja em j
            {
                resposta += " " + nome[j];
            }
        }
        return resposta;
    }

    public static String antecessor(int v) //ponto de partida ou seja sai de v
    {
        String resposta = "";
        for (int j = 0; j < ORDEM; j++) {
            if (grafo[j][v] != 0) //vai de v e cheja em j
            {
                resposta += " " + nome[j];
            }
        }
        return resposta;
    }

    public static Boolean fonte(int v) //ponto de partida ou seja sai de v
    {
        return grauRecepcao(v) == 0;
    }
    
    public static Boolean sumidouro(int v) //ponto de partida ou seja sai de v
    {
        return grauEmissao(v) == 0;
    }

    public static String vizinhos(int v) {
        String vizinho = "";
        for (int j = 0; j < ORDEM; j++) {
            if (grafo[v][j] != 0) {
                vizinho = vizinho + " " + nome[j];
            }
        }
        return vizinho;
    }

    public static void main(String[] args) {
        inicializa();
        imprime();
        conecta(1, 0);
        conecta(2, 0);
        conecta(2, 4);
        conecta(5, 4);
        conecta(4, 3);
        imprime();
        int v = 2;
        System.out.println("GrauEmissao    ( " + nome[v] + " ) = " + grauEmissao(v));
        System.out.println("GrauRecepcao   ( " + nome[v] + " ) = " + grauRecepcao(v));
        System.out.println("Sucessor        ( " + nome[v] + " ) = " + sucessor(v));
        System.out.println("Antecessor        ( " + nome[v] + " ) = " + antecessor(v));
        System.out.println("Fonte        ( " + nome[v] + " ) = " + fonte(v));
        System.out.println("Sumidouro        ( " + nome[v] + " ) = " + sumidouro(v));
        /*        System.out.println("Vizinhos( " + nome[v] + " ) = " + vizinhos(v) );        
         desconecta(0,1);
         imprime();
         System.out.println("Grau    ( " + nome[v] + " ) = " + grau(v)     );
         System.out.println("Vizinhos( " + nome[v] + " ) = " + vizinhos(v) );        */
    }

}
