public class App {
    public static void main(String[] args) throws Exception {
 Autovettura a1= new Autovettura("seconda mano", 10000, "Marco", 35);
        Autovettura a2= new Autovettura("prima mano", 27000, "Pietro", 1000);
        Autovettura a3= new Autovettura("lusso", 3000000, "Manuel", 155);
        Autovettura a4= new Autovettura("moto", 5700, "Salvatore", 347);
        Autovettura a5= new Autovettura(a1);

        Parcheggio p1 = new Parcheggio(30);
        p1.setVeicoloEvoluted(2, a1);
        p1.setVeicoloEvoluted(5, a5);
        p1.setVeicoloEvoluted(0, a2);
        p1.setVeicoloEvoluted(7, a3);
        p1.setVeicoloEvoluted(10,a4 );
        System.out.println(p1);


        Parcheggio p3 = new Parcheggio (p1);
        System.out.println(p1==p3);
        System.out.println(p1.equals(p3));

        Parcheggio p2 = p1.presentiOrdinati();
        System.out.println(p2);
    }
}
