import java.util.LinkedList;
public class TableDeHachage<C,V> {
    private static final int capInitiale = 16;
    private LinkedList<Entry<C,V>>[] tab;
    private int size;

    private static class Entry<C,V> {
        final C cle;
        V valeur;
        public Entry(C cle, V valeur){
            this.cle = cle;
            this.valeur = valeur;
        } 
    }

    public TableDeHachage(){
        tab = new LinkedList[capInitiale];
        size = 0;
    }

    private int hash(C cle){
        return cle == null ? 0 : Math.abs(cle.hashCode())% tab.length;
    }

    public void entreValeur(C cle, V valeur){
        int index = hash(cle);
        if(tab[index]==null){
            tab[index] = new LinkedList<>();
        }
        for(Entry<C,V> entry : tab[index]){
            if(entry.cle.equals(cle)){
                entry.valeur = valeur;
                return;
            }
        }
        tab[index].add(new Entry<>(cle,valeur));
        size++;
    }
    public V getValeur(C cle){
        int index = hash(cle);
        if(tab[index]==null){
            return null;
        }
        for(Entry<C,V> entry : tab[index]){
            if (entry.cle.equals(cle)) {
                return entry.valeur;
            }
        }
        return null;
    }
    public V removeValeur(C cle){
         int index = hash(cle);
         if(tab[index]==null){
            return null;
         }
         for (Entry<C,V> entry : tab[index]) {
            if (entry.cle.equals(cle)) {
                V valeur = entry.valeur;
                tab[index].remove(entry);
                size--;
            }
         }
         return null;
    }
    public int getTaille(){
        return size;
    }
    public void afficherTable(){
        for(int i = 0; i < tab.length; i++){
            if (tab[i]!=null) {
                System.out.print("Indice"+i+" :");
                for (Entry<C,V> entry : tab[i]) {
                    System.out.print("["+entry.cle+"] = "+entry.valeur);
                }
                System.out.println();
            }
        }
    }
}
