Class Abr{

    String data;
    Int hash;
    Abr gauche;
    Abr droit;

    Abr(String data) {
        hash = data.hashCode();
        gauche = null;
        droite = null;
    }

    private void inserer(String d, Int h) {
        //int dataHash = data.hashCode(); 
        if(h == this.hash){

        } else if (h > this.hash){
            if(droite == null){
                droite = new Abr(d);
            } else {
                droite.inserer(d);
            }
        } else {

        }
    }
    public void inserer(String d){
        Int h = d.hashCode();
        return inserer(d, h);
    }

    private boolean recherche(String d, Int h) {
        if(this.hash == h){
            return true;
        } else if(this.hash < h) {
            if(droite == null){
                return false;
            } else {
                return droite.recherche(d, h);
            }
        }
    }
    public boolean recherche(String d){
        Int h = d.hash();
        return recherche(d, h);
    }
    //Interface hashable{
    //    Int hash();
    //}
}