public class Parcheggio {
    private Autovettura [] parcheggio;
    private int spazioMax = 100;
    


    public Parcheggio(){
        parcheggio= new Autovettura[spazioMax];
    }

    public Parcheggio(int max){
        if(max>0){
            parcheggio= new Autovettura[max];
            spazioMax=max;
        }else
            parcheggio= new Autovettura[spazioMax];
            
    }

    public Parcheggio (Parcheggio p){
        this(p.parcheggio.length);
        for (int i = 0; i < parcheggio.length; i++) {
            if(p.parcheggio[i]!=null)
                this.parcheggio[i]=new Autovettura (p.parcheggio[i]);
        }
    }

    

    public int setVeicolo(int pos, Autovettura a){
        int result=pos;
        if(pos>=0 && pos<spazioMax && a!=null){
            if(this.parcheggio[pos]==null)
                this.parcheggio[pos]= new Autovettura(a);
            else
                result=-2;
        }else
            result=-1;

        return result;
    }



    public int cercaVettura(String tipologia, String proprietario){
        int result=-1;
        int i=0;
        boolean trovato = false;
        while (!trovato && i < parcheggio.length){
            if(this.parcheggio[i]!=null){
                String tipologiaCorrente = parcheggio[i].getTipologia();
                String proprietarioCorrenre = parcheggio[i].getProprietario();
                if(tipologia.equalsIgnoreCase(tipologiaCorrente) && proprietario.equalsIgnoreCase(proprietarioCorrenre)){
                    trovato=true;
                    result=i;
                }
            }
            i++;
        }

        return result;

    }

    public int setVeicoloEvoluted(int pos, Autovettura a){
        int result=pos;
        if(pos>=0 && pos<spazioMax && a!=null && cercaVettura(a.getTipologia(), a.getProprietario())==-1){
            if(this.parcheggio[pos]==null)
                this.parcheggio[pos]= new Autovettura(a);
            else
                result=-2;
        }else
            result=-1;

        return result;
    }


    public Autovettura getAutovettura(int pos){
        Autovettura result = null;
        if(pos>=0 && pos<spazioMax){
            if(this.parcheggio[pos]!=null)
                result=new Autovettura(parcheggio[pos]);
        }
        return result;
    }


    public int vetturePresenti(){
        int cont=0;
        for (int i = 0; i < parcheggio.length; i++) {
            if(parcheggio[i]!=null)
                cont++;
        }
        return cont;
    }


    public Parcheggio presentiOrdinati(){
        Parcheggio result = new Parcheggio (spazioMax);
        int cont=0;
        for (int i = 0; i < parcheggio.length; i++) {
            if(this.parcheggio[i]!=null){
                result.setVeicoloEvoluted(cont, parcheggio[i]);
                cont++;
            }
        }

        result.ordina();
        return result;
    }


    //NON FUNZIONANTE
    // private void ordina2(){
    //     int i=0;
    //     int n=parcheggio.length;
    //     boolean trovato=false;
    //     while (!trovato && i<n-1){
    //         if(this.parcheggio[i]!=null && this.parcheggio[i+1]!=null){
    //             double costo1 = parcheggio[i].getCosto();
    //             double costo2 = parcheggio[i+1].getCosto();
    //             if(costo1>costo2){
    //                 Autovettura temp = parcheggio[i];
    //                 parcheggio[i]=parcheggio[i+1];
    //                 parcheggio[i+1]=temp;
    //                 temp=null;
    //                 n--;
    //             }
    //         }else
    //             trovato=true;
    //         i++;
    //     }

    // }


    private void ordina(){
        boolean scambiato=true;
        int n = parcheggio.length;
        while(scambiato){
            scambiato=false;
            for (int i = 0; i < n-1; i++) {
                if(parcheggio[i]!=null && parcheggio[i+1]!=null){
                    double costo1= parcheggio[i].getCosto();
                    double costo2=parcheggio[i+1].getCosto();
                    if(costo1>costo2){
                        Autovettura temp= parcheggio[i];
                        parcheggio[i]=parcheggio[i+1];
                        parcheggio[i+1]= temp;
                        temp=null;
                        scambiato=true;
                    }
                }
            }
        }
    }




    public Parcheggio costoInferiore(double costo){
        Parcheggio result = new Parcheggio(this.parcheggio.length);
        if(costo>=0){
            int cont=0;
            for (int i = 0; i < parcheggio.length; i++) {
                if(this.parcheggio[i]!=null){
                 double costoCorrente = parcheggio[i].getCosto();
                    if(costoCorrente<costo){
                        result.setVeicoloEvoluted(cont, parcheggio[i]);
                        cont++;
                    }
                }
            }

            result.ordina();
        }
        
        return result;
    }


    public Parcheggio costoSuperiore(double costo){
        Parcheggio result = new Parcheggio(this.parcheggio.length);
        if(costo>=0){
            int cont=0;
            for (int i = 0; i < parcheggio.length; i++) {
                if(this.parcheggio[i]!=null){
                 double costoCorrente = parcheggio[i].getCosto();
                    if(costoCorrente>costo){
                        result.setVeicoloEvoluted(cont, parcheggio[i]);
                        cont++;
                    }
                }
            }

            result.ordina();
        }
        
        return result;
    }







    @Override
    public String toString() {
        String s="";
        for (int i = 0; i < parcheggio.length; i++) {
            s+=String.format("Spazioe %d \n", (i+1));
            if(parcheggio[i]!=null)
                s+=parcheggio[i].toString();
            else
                s+="vuoto \n";
            s+="\n";
        }

        return s;
    }

    @Override
    public boolean equals(Object obj){
        boolean verifica=false;
        if(this==obj)
            verifica=true;
        else{
            if(obj instanceof Parcheggio){
                Parcheggio p = (Parcheggio) obj;
                if(vetturePresenti() == p.vetturePresenti()){
                    int i=0;
                    boolean diversi =false;
                    while (!diversi && i <parcheggio.length){
                        if(parcheggio[i]!=null){
                            int posCorrente = p.cercaVettura(parcheggio[i].getTipologia(), parcheggio[i].getProprietario());
                            if(posCorrente!=-1){
                                if(!(p.parcheggio[posCorrente].equals(parcheggio[i])))
                                diversi=true;
                            }
                        }
                        i++;
                        
                    }

                    if(!diversi)
                        verifica=true;
                }
            }
        }

        return verifica;
        
    }

}
