public class Autovettura {
    private String tipologia = "undefined";
    private double costo =0;
    private String proprietario = "undefined";
    private int chilometri = 0;

    public Autovettura(){};
    public Autovettura(String tipologia, double costo, String proprietario, int chilometri){
        setChilometri(chilometri);
        setTipologia(tipologia);
        setProprietario(proprietario);
        setCosto(costo);
    }
    public Autovettura(Autovettura a){
        this(a.tipologia, a.costo, a.proprietario, a.chilometri);
    }


    public double getCosto() {
        return costo;
    }

    public int getChilometri() {
        return chilometri;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setChilometri(int chilometri) {
        if(chilometri>=0)
            this.chilometri = chilometri;
    }

    public void setCosto(double costo) {
        if(costo >=0)
            this.costo = costo;
    }



    public String toString(){
        String s="";
        s+=String.format("tipologia di vettura: %s; \n",tipologia);
        s+=String.format("proprietario della vettura: %s; \n",proprietario);
        s+=String.format("costo della vettura: %.2f; \n",costo);
        s+=String.format("chilometri fatti: %d; \n",chilometri);
        return s;
    }


    public boolean equals(Object obj){
        boolean verifica=false;
        if(this== obj)
            verifica=true;
        else{
            if(obj instanceof Autovettura){
                Autovettura a = (Autovettura) obj;
                if(this.tipologia.equalsIgnoreCase(a.tipologia)){
                    if(this.proprietario.equalsIgnoreCase(a.proprietario)){
                        if(this.costo == a.costo && this.chilometri == a.chilometri)
                            verifica=true;
                    }
                }
            }
        }

        return verifica;
    }
}

