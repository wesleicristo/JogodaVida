/**
 *
 * @author Weslei Cristo -> RA:14.1590-0
 */
public class JogoDaVida {
    int[][] geracaoAnterior = new int[3][3];
    int[][] novaGeracao;

    
    public void primeiraGeracao(){
//        this.geracaoAnterior[0][0] = 1;
//        this.geracaoAnterior[0][1] = 1;
//        this.geracaoAnterior[0][2] = 1;
//        this.geracaoAnterior[1][0] = 1;
//        this.geracaoAnterior[1][1] = 1;
//        this.geracaoAnterior[1][2] = 1;
//        this.geracaoAnterior[2][0] = 1;
//        this.geracaoAnterior[2][1] = 1;
//        this.geracaoAnterior[2][2] = 1;
        this.geracaoAnterior[0][0] = 0;
        this.geracaoAnterior[0][1] = 0;
        this.geracaoAnterior[0][2] = 0;
        this.geracaoAnterior[1][0] = 1;
        this.geracaoAnterior[1][1] = 1;
        this.geracaoAnterior[1][2] = 0;
        this.geracaoAnterior[2][0] = 1;
        this.geracaoAnterior[2][1] = 1;
        this.geracaoAnterior[2][2] = 0;
    }
    
    public void imprimirGeracao(){
        System.out.println("------------------");
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(this.geracaoAnterior[i][j] + " ");
            }
            System.out.println("\n");
            
        }
        System.out.println("------------------");
    
    }
    
    public void simularGeracoes(int qtde){
        for(int i = 0; i < qtde;i++){
            simularGeracao();
        }
        
    }
    
    public void simularGeracao(){
        int vizinhos = 0;
        this.novaGeracao = new int[3][3];
        for(int linha = 0; linha < 3; linha++){
            for (int coluna = 0; coluna < 3; coluna++){
                vizinhos = contarVizinhos(linha, coluna);
                aplicarRegras(vizinhos, coluna, linha);
            }
        }
        geracaoAnterior = novaGeracao;
        imprimirGeracao();
    }
    
    public  void  aplicarRegras(int vizinhos, int coluna, int linha){
        if(vizinhos > 3){
            this.novaGeracao[linha][coluna] = 0;
        } else if(vizinhos < 2){
            this.novaGeracao[linha][coluna] = 0;
        } else if(vizinhos == 3){
            this.novaGeracao[linha][coluna] = 1;
        } else{
            this.novaGeracao[linha][coluna] = this.geracaoAnterior[linha][coluna];
        }
    }
    
    public int contarVizinhos(int linha, int coluna){
        int qtdeVizinho = 0;
        if(coluna == 1){
            if(linha == 0){
                if (this.geracaoAnterior[linha][coluna - 1] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha][coluna + 1] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha+1][coluna + 1] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha+1][coluna - 1] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha+1][coluna] == 1) {
                    qtdeVizinho++;
                }
            }
            else if(linha == 1){
                if(this.geracaoAnterior[linha-1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha+1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha+1][coluna-1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[coluna+1][linha+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna-1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna-1] == 1){
                    qtdeVizinho++;
                }
            }
            else if(linha == 2){
                if(this.geracaoAnterior[linha-1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna-1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna-1] == 1){
                    qtdeVizinho++;
                }
            }
        }else if (coluna == 0){
            if(linha == 0){
                if (this.geracaoAnterior[linha][coluna + 1] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha + 1][coluna] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha + 1][coluna + 1] == 1) {
                    qtdeVizinho++;
                }
            }
            else if(linha == 1){
                if(this.geracaoAnterior[linha-1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha+1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha+1][coluna+1] == 1){
                    qtdeVizinho++;
                }
            }
            else if(linha == 2){
                if(this.geracaoAnterior[linha-1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna+1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna+1] == 1){
                    qtdeVizinho++;
                }
            }
        }else{
            if(linha == 0){
                if (this.geracaoAnterior[linha][coluna - 1] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha + 1][coluna] == 1) {
                    qtdeVizinho++;
                }
                if (this.geracaoAnterior[linha + 1][coluna - 1] == 1) {
                    qtdeVizinho++;
                }
            }
            else if(linha == 1){
                if(this.geracaoAnterior[linha-1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha+1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha+1][coluna-1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna-1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna-1] == 1){
                    qtdeVizinho++;
                }
            }
            else if(linha == 2){
                if(this.geracaoAnterior[linha-1][coluna] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha][coluna-1] == 1){
                    qtdeVizinho++;
                }
                if(this.geracaoAnterior[linha-1][coluna-1] == 1){
                    qtdeVizinho++;
                }
            }
        }
        
        return qtdeVizinho;
    }

        
    
    
    /**
     * Estado Inicial
     * [111
     *  111
     *  110]
     * @param args 
     */
    public static void main(String args[]){
        
        JogoDaVida jv = new JogoDaVida();
        
        jv.primeiraGeracao();
        
        jv.imprimirGeracao();
        
        jv.simularGeracoes(100);
        
        
    }
    
}
