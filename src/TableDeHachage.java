import java.util.LinkedList;

import javax.swing.RowFilter.Entry;
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
        
    }
}
