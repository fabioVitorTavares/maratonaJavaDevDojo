class  Posicao {
    int x;
    int y;

    public Posicao(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class ArrayBiDimensional {



    static Posicao getPosicao(int[][] array, int valor){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(array[i][j] == valor){
                    return new Posicao(i,j);
                }
            }
        }
        return new Posicao(0,0);
    }

    public static void main(String[] args) {
        int[][] dias = new int[2][2];
        dias[0][0] = 0;
        dias[0][1] = 1;
        dias[1][0] = 2;
        dias[1][1] = 3;
        for(int[] dia : dias ){
            for(int d : dia){
                System.out.println(d);
                Posicao p = getPosicao(dias, d);
                dias[p.x][p.y] += 50;
            }
        }

        for(int i=0; i<dias.length; i++){
            for(int j=0; j<dias[i].length; j++){
                System.out.println(dias[i][j]);
            }
        }
    }

}
