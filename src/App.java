public class App {
    public static void main(String[] args) throws Exception {
        TableDeHachage<String,String> tabHash = new TableDeHachage<>();
        tabHash.entreValeur("un","Bonjour");
        tabHash.entreValeur("deux","Salut!");
        System.out.println(tabHash.getValeur("deux"));
    }
}
