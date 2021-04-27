public void readFromFile(BufferedReader br){
try  {
String line;
while((line = br.readLine()) != null){

            }

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file",e);
            }
        }


        public static void main(String[] args) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(""))){
        Corona c = new Corona();
        c.readFromFile(br);

        }catch (IOException e) {
                     throw new IllegalStateException("Can not find file",e);
                 }
          }

-----------------HA STRING A PARAMÉTER---------------------------------------

public int getNumberOfMales(String file){

    try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
        String line;
        while((line = br.readLine()) != null) {

        
        }
    } catch (IOException e) {
        throw new IllegalStateException("Can not read file", e);
    }
}

------------------HA INPUTSTREAM A PARAMÉTER------------------------

public static int getStopWithMax(InputStream is) {
try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
String line;
while ((line = br.readLine()) != null) {

            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return;
    }


    public static void main(String[] args) {
        InputStream is = Travel.class.getResourceAsStream("/utasadat.txt");
        System.out.println(Travel.getStopWithMax(is));

}

-------------------------------------EGYBE BEOLVAS-------------------------------------------------

public int encode(String fileName, char c) {

    try {
        String text = Files.readString(Path.of(fileName));

        if (text == "" || !containsCharacter(text, c)) {
            return 0;
        }
        for (char item : text.toCharArray()) {
            if (item == c) {
                count++;
            }
        }

    } catch (IOException e) {
        throw new IllegalStateException("Can not read file", e);
    }
    return count;
}

-------------------MEZŐ NEM LEHET ÜRES (null vagy üres string)------------------------

private boolean isEmpty(String str) {
return (str == null || str.isBlank());
}
------------------LISTA NEM LEHET ÜRES----------------

public boolean isEmpty(List items) {
return items == null || items.size() == 0;
}

-------------KONSTRUKTORNÁL_------------------

public Employee(String name, String job, int salary) {
if (isEmpty(name)) {
throw new IllegalArgumentException("Name cannot be empty");
}
if (isEmpty(job)) {
throw new IllegalArgumentException(("Job cannot be empty"));
}

------------------------COMPARABLE--------------------------------
Class implements Comparable<ClassName>{

String:
public int compareTo(Player p) {
return this.getName().compareTo(p.getName());
}
Int:
public int compareTo(Player p) {
return rank-p.rank;
}

------------------------COMPARATOR.COMPARING()-----------------------------
public List<String> getMostImportantTodosText() {
List<String> mostImportant = new ArrayList<>();
todos.sort(Comparator.comparing(Todo::getPriority));

int min = todos.get(0).getPriority();
for (Todo t : todos) {
if (t.getPriority() == min) {
mostImportant .add(t.getText());
}
}
return mostImportant;
}

-----COMPARATOR TÖBB SZEMPONT-------------------

persons.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

ha van null is, pl középső név szerint rendezés:
Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder()));


people.sort(Comparator.comparing(Person::getMiddleName, Comparator.reverseOrder()));

people.sort(Comparator.comparing(Person::getName, Comparator.comparingInt(String::length)).reversed());

---------------ITERÁTOR----------------------------
public void deleteCompleted(){
for (Iterator<Todo> iter = todos.iterator(); iter.hasNext();) {
Todo t = iter.next();
if (t.getState() == State.COMPLETED) {
iter.remove();
}
}
}
---------------------ITERÁTOR HELYETT------------------------------------------
public int cleanAll(){
int sum = 0;
for(Cleanable item :cleanables){
sum += item.clean();
}cleanables.clear();
return sum;
}

--------------------ITERÁTOR--------------------------

public int cleanAll(){
int sum = 0;
for(Iterator<Cleanable> iterator = cleanables.iterator();
iterator.hasNext();){
Cleanable c = iterator.next();
sum += c.clean();
iterator.remove();
}
return sum;
}

public int cleanOnlyOffices(){
int sum = 0;
for(Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext();){
Cleanable c = iterator.next();
if(c instanceof Office){
sum += c.clean();
iterator.remove();
}

        }
    return sum;
    }
}


--------------COLLATOR---------------------
public List<String> getPassengerNamesOrdered() {
List<String> names = new ArrayList<>();
for (Passenger passenger: passengers) {
names.add(passenger.getName());
}
Collections.sort(names, Collator.getInstance(new Locale("hu", "HU")));
return names;
}


---------------------------MAP----------------------------------------
//A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk
//az összes névvel, mely ezzel a betűvel kezdődik).

public Map<Character, List<String>> index(List<String> names) {
Map<Character, List<String>> results = new TreeMap<>();

        for (int i=0; i< names.size();i++) {
            char key = names.get(i).charAt(0);
            if(results.containsKey(key)){
                List<String> temp = results.get(key);
                        temp.add(names.get(i));
               results.put(key, temp);
            }
            else{
                List<String> temp2 = new ArrayList<>();
                temp2.add(names.get(i));
                results.put(key, temp2);
            }

                }
                 return results;

           }
//Készíts statisztikát a rendelt termékekből. Tárold el a termékeket és azt, hogy összesen hány darabot rendeltek belőle.
public Map<String,Integer> statistics() {
Map<String, Integer> results = new TreeMap<>();
for (Set<String> item : productList.values()) {
for (String i : item) {
if (results.containsKey(i)) {
int value = results.get(i);
results.put(i, value + 1);
} else {
results.put(i, 1);
}

                    }

                }return results;
            }

// Írj egy countWords() metódust, mely paraméterül várja a fájlt, varargsban szavakat.
// Megszámolja, hogy melyik szó hány sorban szerepel a szövegben

            public Map<String,Integer> countWords(Path path, String...words){
                    List<String> rows = listCreator(path);
                    Map<String,Integer> results= new HashMap<>();
                    for(String item :words){
                        int number =0;
                        for(String i :rows){
                            if(i.contains(item)){
                                number++;
                            }
                        }
                        results.put(item,number);
                    }return results;

                   }

                public List<String> listCreator(Path path){
                    path = Path.of("src/main/resources/hachiko.srt");
                    List<String> rows= new ArrayList<>();
                    try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/hachiko.srt"),Charset.forName("windows-1250"))) {
                        String line;
                        while((line = reader.readLine()) != null){
                            rows.add(line);

                        }return rows;

                    } catch (IOException e) {
                        throw new IllegalStateException("Can not read file",e);
                    }

                }

//Map value maximum search.Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját
megkapjuk egy Map-ben. A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott
pontok küzül, hol van a függvénynek maximum helye és ott mennyi az értéke.

             public Map.Entry<Integer, Integer> searchMax(Map<Integer,Integer> coordinates) {
                     Map.Entry<Integer, Integer> result = null;
                     int max = 0;
                     for( Integer item : coordinates.values()){
                         if( max < item) {
                             max = item;
                         }
                         for(Map.Entry<Integer, Integer> entry : coordinates.entrySet()){
                             if(entry.getValue().equals(max)){
                                 result = entry;
                             }
                         }

                     }
                     return result;
                 }

----------------------MAP EGY KULCSHOZ HÁNY ÉRTÉK TARTOZIK-------------------

                 public Map<CanoeType,Integer> countRentals(){
                         Map<CanoeType,Integer> results = new HashMap<>();
                         for(CanoeRental item : canoeRentals){
                             if (!results.containsKey(item.getCanoeType())) {
                                 results.put(item.getCanoeType(), 0);
                             }
                                 results.put(item.getCanoeType(), results.get(item.getCanoeType()) + 1);
                             }
                         return results;

                         }

                     }

Írj egy metódust, amely megszámolja, hogy hány különböző betű van egy szóban. A kis és nagybetűk közötti
különbség nem számít! A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az angol ábécé betűit!

public int characterCounter(String word) {
char[] arr = word.toLowerCase().toCharArray();
Set<Character> characters = new HashSet<>();
for (int i = 0; i < arr.length; i++) {
if (isEnglishChar(arr[i])) {
characters.add(arr[i]);
}
}
return characters.size();

}

private boolean isEnglishChar(char c) {
return (c >= 'a' && c <= 'z')
}

---------------------TEMPLATE-------------------------------
public class Contract {

    private String client;
    private List<Integer> monthlyPrices;

    public Contract(Contract contract) {
        client = contract.client;
        monthlyPrices = new ArrayList<>(contract.monthlyPrices);
    }

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }
    //getters, toString()...

    public class ContractCreator {

        private Contract template;



        public ContractCreator(String client, List<Integer> monthlyPrices) {
            this.template = new Contract(client, monthlyPrices);
        }

        public Contract create(String name) {
         return new Contract(name, new ArrayList<>(template.getMonthlyPrices()));
        }


        public static void main(String[] args) {
            String s = "alma,, \"korte, korte\", meggy,";
            StringBuilder sb = new StringBuilder();
            List<String> parts = new ArrayList<>();
            boolean insideValue = false;
            for (char c: s.toCharArray()) {
                if (c == '\"') {
                    insideValue = !insideValue;
                }
                if (c != ',') {
                    sb.append(c);
                }
                else {
                    if (!insideValue) {
                        parts.add(sb.toString());
                        sb = new StringBuilder();
                    } else {
                        sb.append(",");
                    }
                }
            }
            parts.add(sb.toString());
            for (String element: parts) {
                System.out.println(element);
            }
        }

---------------------SAJÁT KIVÉTEL OSZTÁLY-------------

létrehozás, extends RuntimeException;

attribútum: private String message;

insert constructor , sima, felső

