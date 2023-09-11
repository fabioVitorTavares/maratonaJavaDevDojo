public class BreakContinue {


    public static void main(String[] args) {
        double valorTotal = 30000;

//        for(int parcela = 1; parcela <= valorTotal; parcela++){
//            double valorParcela = valorTotal / parcela;
//            if(valorParcela < 1000){
//                break;
//            }
//
//                System.out.println( parcela + " parcelas de " + valorParcela);
//                System.out.println( parcela + " parcelas de " + valorParcela);
//
//        }
        metodo();
    }

    private static void metodo(){
        double valorTotal = 30000;
        long inicio = System.currentTimeMillis();
        for (int parcela = (int) valorTotal; parcela >= 1; parcela--){
            double valorParcela = valorTotal / parcela;
            if(valorParcela <=1000){
                continue;
            }
            System.out.println(parcela + " parcels de " + valorParcela);
        }
        System.out.println(System.currentTimeMillis() - inicio);
    }

}
