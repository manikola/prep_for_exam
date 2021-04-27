KONSTANSOK
final módosító szó: egy változót deklaráláskor final módosítóval látunk el, akkor annak csak egyszer adható érték, és az később nem változtatható meg. Attribútumnál, paraméternél és lokális változónál is használható. A final módosítóval deklarált attribútumnak legkésőbb a konstruktorban értéket kell kapnia.

    final double packageWeight = 2.4;

static final módosító: azokat az attribútumokat, amelyeket static final módosítóval látunk el, az egész program futása alatt elérhetjük, de soha nem változtathatjuk meg. Ezeknek már az osztály betöltődésekor értéket kell kapniuk, és konvenció szerint csupa nagybetűvel írjuk őket, a több szóból állóknál pedig alulvonással segítjük az olvashatóságot.

public static final int NUMBER_OF_SEASONS = 4;

Ezeket a kvázi konstansokat általában abban az osztályban deklaráljuk, ahol használni szeretnénk, így elérésükhöz elég a nevükkel hivatkozni rájuk. A public static final módosítóval ellátott attribútumokat más osztályból is elérhetjük, ha az osztálynéven át hivatkozunk rájuk vagy statikus importot használunk.

Lokális változó
Nincs default kezdőértéke,Paraméterrel azonos nevű lokális változó --> fordítási idejű hiba !!!

Immutable:
Csak getterek, referencia attribútum esetén konstruktorban  new ArrayList<>(courses);

property = attribútum + getter és setter metódusa

JavaBeans : üres konstruktor, attribútumok privátok, csak publikus getter és setter

autoboxing
A primitív típus és a csomagoló osztálya között a fordító automatikusan tud be- és kicsomagolni. Ezt nevezzük autoboxingnak, illetve unboxingnak.

switch
Fejében String, enum,  int, vagy bármi, ami int-té automatikusan konvertálható lehet
switch - case   !!! break; nélkül folytatja a következő case parancsaival !!!

típuskonverzió
automatikus konverzió akkor működik, ha a bővebb ábrázolási tartomány felé kell konvertálni. Kivétel, hogy a float és double változónak adható long érték, de ez adatvesztéssel járhat. A byte, short, char típusnak értékül adható megfelelő int literál, ha az értékre belefér.
Explicit konverziót akkor kell használni, amikor a szűkebb ábrázolási tartomány felé szeretnénk konvertálni. Ebben az esetben információvesztés történhet.
i = (int) l;
i = (int) d;

⦁	Absztrakt osztály:
Egy osztály attól és csak attól absztrakt, hogy én az elejére kiírtam az "abstract" szócskát. Az absztrakt osztálynak nincs kötelezően absztrakt metódusa. Ha van abstract metódus, akkor az osztály is abstract kell legyen. (Fordítva nem áll fent.)

Interface:
Interfész nem példányosítható, de lehet egy változó statikus típusa, de ekkor az objektumból csak az interfészben deklarált metódusok érhetőek el.(dinamikus kötés)
Attribútumok: konstansokat (public static final) deklarálhat, melyeket kívülről az interfész nevét használva minősítőként érhetünk el.
az implementált metódus szignatúrájának meg kell egyeznie (név és paraméterlista)
ha egy osztály két olyan interfészt implementál, mely ugyanolyan nevű metódust ír elő (névütközés)?
1.	szignatúrája azonos, és ugyanazt a logikát akarjuk társítani hozzá, akkor nincs probléma.
2.	 más a paraméter szignatúrája - (overload)
3.	 ugyanaz a szignatúrája, de más a visszatérési értéke (és ez nem oldható fel), akkor ezek sajnos ütköznek. Nem implementálhatjuk mindkét interfészt., mert nem fordul le

⦁	Interface metódusok:
Alapból public abstract minden metódus, ami elé nem írok másmilyen láthatósági vagy egyéb módosítószót.
default interface metódus: amely nem csak a metódus fejét, de az alapértelmezett működését is tartalmazza, kötelező implementálni az interfészben (hiszen pont ez a lényege, hogy eleve adunk neki egy default működést) Nem lehet: static, a final vagy abstract (implementáló osztály dönthet úgy, hogy felülírja)
default interface metódus öröklődés: az eredeti default metódust meghagyja vagy absztrakttá teszi, vagy felül is írhatja másik default implementációval.
private metódus: Java9-től,kötelező implementálni az interfészben (lévén nem is hívható más osztályokból közvetlenül), nem lehet default
static metódus: kötelező implementálni az interfészben, csak public lehet, nem lehet default és nem öröklődik; csak az interfész nevével minősítve hívható. List.of()


Attribútumok:
Az attribútumok kezdőérték adása nélkül is rendelkeznek valamilyen értékkel, amely az attribútum típusától függ, szemben a lokális változókkal, amelyek nem.( byte, short, int, long: 0; double, float: 0.0; char: '000'; boolean: false; osztály: null
⦁	private: senki számára nem látható és nem módosítható
⦁	default vagy package private: csak az azonos csomagban lévő osztályok számára látható
⦁	protected: csak az azonos csomagban lévő vagy a leszármazott osztályokból látható (az öröklésről később még lesz szó)
⦁	public: mindenki számára látható és módosítható

Static attribútumok
osztályhoz tartoznak, osztályon belül csak a nevet kell megadnunk, osztályon kívülről azonban akár az osztálynevet, akár a változónevet használhatjuk minősítőnek
konstans tárolására használjuk gyakran, ilyenkor az attribútum static final
public static final double BOX_WEIGTH = 2.3;

Attribútumok öröklődése
Ha a leszármazottban látni szeretnénk: protected

Metódusok
túlterhelés (method overloading):
a metódus neve ugyanaz
a parameterlista eltérő (parameterek típusa és/vagy száma)
a visszatérési érték mindegy


Static metódusok meghívása lehetséges:
osztalynevvel minősítve (pl. Assertions.assertEquals()), ekkor az osztalynevet importálni kell
osztalynev nélkül (pl. simán assertEquals()), ekkor az import statikus import és magát a metódus nevét kell importálni, vagy a metódust tartalmazó Osztalynev.* - ot (ez utóbbival az adott osztály összes statikus tagját importálom)
példányon is meg lehet hívni (pl. new Assertions.assertEquals()), ez működik, de TILOS használni.
⦁	statikus metódusból csak példányosítás után hívható nem statikus
⦁	       csak így: psvm(){ new Osztály().nemstatikus(); }  !!! new Osztály nélkül nem megy !!!

Metódusok öröklődése
Csak a public és protected metódusok érhetőek el a leszármazott osztályból biztosan
Ha private vagy nem éri el, és ugyanolyan névvel létrehoz egyet, akkor az elfedi az örököltet.
A gyermek osztály az örökölt és általa elérhető metódusokat felülírhatja (override) az alábbi szabályok szerint: láthatósága nem lehet szűkebb, visszatérési érték típusa primitív típus esetén megegyezik, osztály esetén csak ugyanolyan, vagy a leszármazottja lehet, szignatúra ua., Nem dobhat újabb vagy bővebb kivételt
final kulcsszóval ellátott metódus nem írható felül.
Ha nem írja felül: akkor a gyermekből elérhető a szülő metódusa is a Sminősítővel.


A "mit ír ki az alábbi kódrészlet?"típusú feladatoknál mindig meg kell nézni, hogy helyesen van-e meghívva az adott metódus, pl.:
nincs-e elírva a psvm(), amin belül meghívják
nincs-e elírva maga a metódus neve valami módon
minden tekintetben helyes-e az átadott paraméter, helyes-e a típusa (pl. ha Stringet vár, akkor az átadott paraméter legyen idézőjelben)
és csak ezután érdemes egyáltalán elkezdeni azt nézni, hogy mit ír ki

Kivételek:
Throwable
I: unchecked(Error) - error leszármazottak
II:checked (Exception) -unchecked Runtime Exception leszármazottak,
- checked Exception leszármazottak

Saját kivétel:
public class InvalideAgeException extends RuntimeException {
private int parameterAge;
private int minAge;

     public InvalideAgeException(String message, int parameterAge, int minAge){
         super(message);
         this.minAge = minAge;
         this.parameterAge = parameterAge;
     }
}

Multicatch:
catch (NullPointerException | IllegalArgumentException | IndexOutOfBoundsException e) {
throw new ParseException("Invalid line = " + line, 0);

try-catch-finally:
⦁	try {} önmagában nem állhat, kell utána catch blokk
⦁	catch úgy néz ki, hogy: catch () {}, ahol a sima zárójelben az elkapni akart kivétel van (típus és szabadon választott változónév), a kapcsos zárójelben pedig utasítások, hogy mit csináljon a program akkor, ha elkap egy ilyen típusú kivételt.
⦁	catch sima zárójelében lehet 1 fajta kivételtípus + változónév, vagy többfajta (2 vagy több, multi catch) úgy, hogy (XException | YException |ZException ex), vagyis a változónevet csak egyszer kell megadni.
⦁	Ha a catch-nek a törzsében nem dobódik valamilyen módon új Exception, akkor a program futása nem áll meg, hanem továbblép a következő utasításokra.
⦁	finally ágat nem kötelező írni
⦁	finally ág mindig lefut (akkor is, ha nem írtunk, és akkor is, ha a catch-ben kivétel dobódik és leáll a program futása)

try-with-resources
úgy néz ki, hogy: try () {}
állhat önmagában, de írhatunk utána catch ágat is (ld. előző hsz)
finally ága is van (ld. előző hsz)
a try után a sima zárójelbe beleírt erőforrásra automatikusan meghívja annak a close() metódusát (pont ezért találták ki, hogy nehogy véletlenül lezáratlanul maradjon egy erőforrás azért, mert a feledékeny ember elfelejti manuálisan leírni azt, hogy erőforrás.close())
sokszor eleve a try fejében hozzuk létre az erőforrást, de megkaphatja kívülről is

A Map interfész nem a Collection interfész leszarmazottja.



példány és statikus:
példány attribútumból elérem a statikus attribútumot
példány metódusból elérem a statikus attribútumot
példány metódusból elérem a statikus metódust
statikus attribútum eléri a statikus attribútumot
statikus attribútum eléri a statikus metódust
statikus metódusból elérem a statikus attribútumot
statikus metódusból elérem a statikus metódust
DE NEM LEHET statikus bármiből elérni a példány bármit

Konstruktorok
Nem  öröklődnek. SOHA.
ha nem adunk meg konstruktort, a fordító : default konstruktor super() hívás
Konstruktor megadásakor megszűnik létezni a default paraméternélküli konstruktor(Kézzel lehet/kellhet újra megírni.)
Konstruktornak CSAK az első sorában szerepelhet a this. vagy  super. hívása. Ha mi nem írjuk oda egyiket sem, a fordító akkor oda teszi a supert! (Ebből lehet baj, ha nincs paraméter nélküli a szülőben.)
A super() hívás mindig a konstruktor első utasítása kell legyen.
Egy konstruktor vagy super(), vagy this() hívást tartalmaz, a kettőt egyszerre sosem.

Metódusok öröklődése:
A láthatóság nem lehet szűkebb
A visszatérés típusa nem lehet általánosabb (tehát referencia tipus esetén valamelyik ős osztályba tartozó)
A dobható kivételek nem lehetnek bővebbek (csak ugyanazok, szűkebb, vagy 0)
(edited)

Tömbök
tömb elemei mindig kapnak kezdőértéket: egész típusú elemek esetén ez 0, lebegőpontos szám esetén 0.0, logikai érték esetén false, osztály esetén null lesz.
⦁	System.arraycopy():Tömbök között adatok átmásolása
⦁	String toString(): A tömb elemeit adja vissza szöveges formában, paraméterként a tömböt kell átadni.
⦁	String deepToString(): Tömbök tömbjét adja vissza szöveges formában teljes mélységben olvashatóan, paraméterként a tömböt kell átadni.
⦁	boolean equals(): Két azonos típusú elemekből álló tömböt hasonlít össze, és igazzal tér vissza, ha az elemek páronként egyenlőek.
⦁	boolean deepEquals(): Két tömbök tömbjét hasonlítja össze, és igazzal tér vissza, ha az elemek minden szinten páronként megegyeznek.
⦁	void sort(): Berendezi egy tömb elemeit növekvő sorrendbe, amennyiben az elemek típusának van természetes rendezettsége. Paraméterként a rendezendő tömböt kell megadni.
⦁	T[] copyOf(): A paraméterként átadott tömb megadott hosszúságú másolatát adja vissza. Ha az eredeti tömb rövidebb, akkor a maradék helyeket alapértelmezett értékekkel tölti fel (lásd a tömb adattípusnál), ha hosszabb, akkor levágja a végét.
⦁	T[] copyOfRange(): A paraméterként átadott tömb megadott indexek közötti szakaszát adja vissza. Az esetleges üres helyeket az alapértelmezett értékkel tölti fel.
⦁	boolean Arrays.binarySearch() : Miután rendeztünk egy tömböt, lehetőség van arra, hogy abban hatékonyan keressünk egy konkrét elem
Enum
⦁	values() metódusról már volt szó, ez az összes enum értéket tartalmazó tömböt ad vissza.
⦁	A valueOf() metódussal String alapján lehet lekérni a felsorolásos típus egy elemét, ahol a String maga a definiált konstans neve.
⦁	A name() metódus az ellenkező irány, amikor az enum értékből szeretnénk String-et kapni.
⦁	Az ordinal() visszaadja az adott elem sorszámát. Ugyanúgy, mint a tömb indexelése, ez is 0-val kezdődik.

Lista
List: interface
ArrayList: osztály
⦁	Arrays.asList(): Tömbökből is készíthetünk listát, List<String> nameList = Arrays.asList(names);
⦁	boolean add(): új elem hozzáadása a listához. Paraméterként a beszúrandó elemet kell megadni, illetve ha nem a végére akarjuk tenni, akkor az indexet is meg kell adnunk. Ebben az esetben az utána következő elemek eggyel hátrébb kerülnek.
⦁	E get(int index): a megadott indexen lévő elemet adja vissza.
⦁	void clear(): törli a lista összes elemét
⦁	boolean contains(Object o): igazzal tér vissza, ha a megadott elem benne van a listában. Ennek eldöntésére az elem equals() metódusát használja.
⦁	int indexOf(Object o): megadja, hogy a paraméterként átadott elem milyen indexen szerepel először a listában. Ha nincs a listában, -1-et ad vissza.
⦁	boolean remove(Object o): törli a paraméterként átadott elem első előfordulását. Ha az elem nem szerepelt a listában, hamissal tér vissza.
⦁	int size(): a lista elemeinek száma

List<String> list1 = new ArrayList<>();  üres lista
List<String> list2 = Arrays.asList("a", "b","c");  nem lehet hozzáadni, fix elemszámú, de kicserélhetek elemeket
List<String> list3 = List.of("a", "b","c")  interfész, nem módosítható, nem bővíthető
List<String> list4 = new ArrayList<>(list3) a list4 már módosítható, lehet hozzáadni

STRING OSZTÁLY

⦁	boolean equals(String str): a szöveg betűről betűre megegyezik-e a paraméterként átadott másik szöveggel.
⦁	boolean  equalsIgnoreCase() :u.a. csak a kis- és nagybetűk közötti eltéréseket figyelmen kívül hagyja
⦁	boolean  contains() : visszatér true-val, ha a paraméterben kapott karakter sorozatot tartalmazza a sztring
⦁	boolean   startsWith(), endsWith() : ellenőrzi, hogy az aktuális sztring a paraméterben kapott sztringgel kezdődik, vagy végződik-e
⦁	boolean isEmpty(): azt vizsgálja, hogy üres-e a String
⦁	boolean isBlank(): Ha nem csak az üres, hanem a csupán whitespace karaktereket tartalmazó szöveget is szeretnénk kiszűrni, használjuk az isBlank() metódust. Ez akkor is igazzal tér vissza, ha a szöveg ugyan 5 karakterből áll, de egyik sem nyomtatható.
⦁	boolean hasContent(): // hasContent("   ") --> true
⦁	boolean hasReadableContent(): // hasReadableContent("   ") --> false
⦁	int indexOf(String substring): a paraméterként átadott szöveg hol kezdődik az adott szövegben. Ha nem található, akkor -1-gyel tér vissza. A karakterek indexelése, sorszámozása 0-ról indul.
⦁	int indexOf(String substring, int startIndex): a paraméterként átadott szöveg hol kezdődik az adott szövegben, de a keresést csak a startIndex-től kezdi.
⦁	int length(): a szöveg hosszát adja vissza.
⦁	intern(): azt nézi, hogy a paraméterként átadott String benne van-e a poolban, ha igen, arra ad vissza egy referenciát, ha nincs, akkor belerakja.
⦁	String  concat(): egy másik String-et vár paraméterül, de figyeljünk, hogy az objektum immutable, ezért egy új String objektum fog létrejönni.
⦁	String substring(int beginIndex): visszaadja a szöveg egy részét a megadott indextől kezdve a végéig.
⦁	String substring(int beginIndex, int endIndex): visszaadja a megadott indexek közé eső szövegrészt. A bal oldali indexű karaktert még tartalmazni fogja, a jobb oldalit nem
⦁	char charAt(x) : mi az x-edik karakter?
⦁	String split(): a kapott elválasztó karaktersorozat mentén szétvágja a szöveget és a
keletkezett darabokat tömbként adja vissza
⦁	String replace()	visszatér egy új sztringgel, az első paraméterként átadott szövegrész minden előfordulását lecserélhetjük a második paraméterként átadottra.
⦁	 String toLowerCase(), toUpperCase()	visszaad eg yúj sztringet, ami az aktuális sztring valamennyi karakterét nagybetűsíti/kisbetűsíti
⦁	String  trim():	visszaad egy új sztringet, amiben levágja a String eleji és végi whitespace karaktereket.
⦁	valueOf() : az adott paramétert Stringgé konvertálja
⦁	String  join(): s első paraméterként a használandó elválasztó karaktert várja, utána pedig
sorban az összefűzendő String-eket.Az összefűzendő részeket akár tömbként vagy listaként is odaadhatjuk. Ezt a metódust nem egy String objektumon, hanem magán az 	osztályon kell meghívni.
⦁	String repeat(int i): Paraméterként az ismétlések számát várja. Ha a paraméter értéke 0, akkor üres szöveget
ad vissza, de ha negatív, akkor kivételt dob

private boolean hasContent(String s) {          // hasContent("   ") --> true
return s != null && !s.isEmpty();
}

private boolean hasReadableContent(String s) {  // hasReadableContent("   ") --> false
return s != null && !s.isBlank();
}

Főbb StringBuilder metódusok
⦁	append() – újabb érték hozzáfűzése
⦁	toString() – karakterlánccá konvertálás
⦁	charAt(), indexOf(), length(), substring() – ugyanúgy működnek, mint a String-ben
⦁	insert() – új karakterláncot illeszt be
⦁	delete() / deleteCharAt() – szövegrészt/karaktert töröl
⦁	reverse() – karakterek sorrendjét megfordítja

Szövegből szám:
Integer i = new Integer("1234");

Számból szöveg:
int i = Integer.parseInt("1234");

SCANNER
Metódusok:
⦁	nextXXX() :– különböző típusokhoz, eltérő, de mindig next prefixű metódusok beolvasásra
int number = scanner.nextInt(); //Csak szám beolvasására jó!
⦁	hasNextXXX():  – boolean visszatérési értékű, megadja, hogy a következő érték adott típusú-e.
⦁	next() / hasNext():  - a következő elválasztó karakterig adja vissza a szöveget. Az elválasztó karakter alapértelmezetten whitespace (Charater.isWhiteSpace()). Az elválasztó karakter a useDelimiter() metódussal változtatható meg.
⦁	nextLine() / hasNextLine():  – akkor használjuk, ha egy szöveget soronként szeretnénk feldolgozni.

Fájl olvasása scannerrel:
A Scanner konstruktorának a fájlt kell átadnunk, melyet a Path objektum reprezentál. Ezt létre tudjuk hozni a fájl elérési útvonalával:

Scanner scanner = new Scanner(Path.of("books.txt"));

try (Scanner scanner = new Scanner(Path.of("books.txt"))) {
while(scanner.hasNextLine()) {
String line = scanner.nextLine();
System.out.println(line);
}
}
catch (IOException ioe) {
throw new IllegalStateException("Cannot read file", ioe);
}

A fájl útvonalát mind relatív, mind abszolút elérési úttal megadhatjuk. Ha a fájl az alkalmazás részét képezi, akkor Maven használata esetén azt az erőforrásoknak fenntartott srckönyvtáron belül kell elhelyeznünk, és Path helyett a Class getResourceAsStream() metódusával tudjuk a fájlt megnyitni. Az itt elhelyezett fájlok ún. gyökérútvonallal is megadhatók, melyet mindig / jellel kezdünk. A /books.txt azt jelenti, hogy a projekt classpath gyökerében található books.txt fájl. Relatív útvonal esetén a viszonyítási pont az osztályt tartalmazó csomag lesz. Ha a FileScannerMain osztályunk a training package-ben van, akkor a "books.txt" útvonal az src.txt fájlra mutat.

try (Scanner scanner = new Scanner(FileScannerMain.class.getResourceAsStream("/books.txt"))) {
while(scanner.hasNextLine()) {
String line = scanner.nextLine();
System.out.println(line);
}
}

A getResourceAsStream() metódust az aktuális osztály neve + .class előtaggal kell hívni. Az útvonal megadása ebben az esetben rendszerfüggetlen, azaz a könyvtárak elválasztására mindig / jelet használunk. A metódus nem dob IOException kivételt, ezért a catch ág ebben az esetben nem kell, de a Scanner objektum automatikus lezárásához még mindig try-with-resources szerkezetben példányosítjuk.


Collection framework of classes:
List:
(order matters,duplicate allowed,retrieve E by index. Both knows the same, we should choose by the requirements of usage)
ArrayList<>() : faster for retrieving data, slow for manipulating
LinkedList<>(): faster for manipulating data, slow for retrieving

List metódusok
⦁	void add(int index, E element): új elemet szúr be a meghatározott pozícióra.
⦁	E element get(int index): elem lekérdezése az indexe alapján.
⦁	int indexOf(Object o): megkeresi a paraméterben átadott elem első előfordulását, és az indexével tér vissza. Ha az elem nincs a listában, a visszaadott index -1.
⦁	int lastIndexOf(Object o): megkeresi a paraméterben átadott elem utolsó előfordulását, és az indexével tér vissza. Ha az elem nincs a listában, a visszaadott érték -1.
⦁	void remove(int index): törli a listából a megadott indexű elemet.
⦁	E set(int index, E element): lecseréli a megadott indexű elemet a paraméterként átadottra, és a régi elemmel tér vissza.

Set:
(order doesnt't matter,  duplicates not allowed, index not defined)
HashSet<>(): order doesnt't matter, in case of objects, hashcode and equals has to 	be overriden to be able to recognise them as duplicates (valójában hashMap, csak nem használjuk a kulcsokat)
TreeSet<>(): order matters,
LinkedHashSet<>(): strict order of insertion, ordered version of HashSet. LinkedHashSet lets us iterate through the elements in the order in which they were inserted.

Queue:
(adding and removing in strict order)
Queue metódusok
Kivételt dob		Speciális érték
Elem hozzáadása	boolean add(E e)	boolean offer(E e)
Elem kivétele		E remove()		E poll()
Fej lekérdezése	E element()		E peek()
Deque metódusok
Amennyiben veremként (LIFO) kezeljük a kétvégű sort, akkor az alábbi műveleteket használhatjuk:
⦁	void push(E e): elem hozzáadás a verem elejéhez
⦁	E pop(): elem kivétele a verem elejéről
⦁	addFirst(E e),
⦁	addLast(E e)
⦁	peekLast()
⦁	peekFirst()metódusok.
⦁
Map interface:
HashMap<>(): every row is an entry of key + value, usinghashCode() buckets, null allowed
LinkledHashMap<>(): strict order of insertion
.keySet();
.entrySet();
TreeMap<>(): natural order based on key values (abc)
----------------------------------------------------------------------
Collections.shuffle(pool)
Collections.sort(winningNumbers)

Map methods:
⦁	int size(): a Map bejegyzéseinek száma.
⦁	boolean isEmpty(): igaz, ha a Map mérete nulla.
⦁	void clear(): törli az összes bejegyzést.
⦁	V get(Object key): a paraméterként átadott kulcshoz hozzárendelt értéket adja vissza, vagy null-t, ha a kulcs nem található a Map-ben.
⦁	V put(K key, V value): új kulcs-érték pár beszúrása. Ha a Map-ben már létezett a kulcs, akkor a hozzárendelt értéket lecseréli az újra, és a régi értékkel tér vissza. Ha még nem létezett a kulcs, akkor új bejegyzést készít, és null-lal tér vissza.
⦁	V remove(Object key): törli az adott kulcshoz tartozó bejegyzést. Ha a kulcshoz tartozott érték, akkor azzal tér vissza, ha nem tartozott, akkor null-lal.
⦁	boolean containsKey(Object key): igazzal tér vissza, ha a megadott kulcs létezik a Map-ben.
⦁	boolean containsValue(Object value): igazzal tér vissza, ha a megadott érték legalább egy kulcshoz hozzá van rendelve.
⦁	Set<Map.Entry<K, V>> entrySet(): a Map bejegyzéseinek halmazával tér vissza.
⦁	Set<K> keySet(): a kulcsok halmazát adja vissza.
⦁	Collection<V> values(): az értékek sokaságát adja vissza.

Az entrySet(), keySet() és values() műveletek által visszaadott kollekciók mögött ott van az eredeti Map, így ha bármelyik változik, az hatással van a másikra is. A visszaadott kollekciókon nem hívható meg az add és addAll művelet.

A Collection interfészben deklarált metódusok
⦁	boolean add(E element): új elem hozzáadása.
⦁	boolean remove(Object o): a megadott elem eltávolítása; igazzal tér vissza, ha volt olyan elem, amit el akartunk távolítani.
⦁	int size(): az elemek számát adja meg.
⦁	boolean isEmpty(): igazzal tér vissza, ha a kollekció elemszáma nulla.
⦁	void clear(): eltávolítja az összes elemet.
⦁	boolean contains(Object o): megadja, hogy a paraméterként átadott elem megtalálható-e a kollekcióban.
⦁	 emptyXxx() metódusok üres kollekciót adnak vissza. Lehet emptyList(), emptySet() vagy emptyMap(), sőt néhány másik is. Ezek immutable kollekciókat adnak.
⦁	A singletonXxx(T o) metódusok egyelemű immutable kollekciót adnak vissza. Lehet singleton(T o), singletonList(T o) és singletonMap(K key, V value). Az első neve nem tartalmazza a kollekció típusát: Set-tel tér vissza. A fenti két metóduscsoportnál figyeljünk arra, hogy elemeket sem hozzáadni, sem elvenni, sem módosítani nem lehet.
⦁	A synchronizedXxx() metódusok a paraméterül kapott kollekciók szálbiztos burkoló osztályával térnek vissza. Ezek mind nézetek, ami azt jelenti, hogy kapcsolatban vannak az eredeti kollekcióval, azaz az ezen történő változások megjelennek abban is és viszont. A szálbiztos kollekciók akkor is jól működnek, ha egyszerre több szál is módosítani próbálja a tartalmát.
⦁	Az unmodifiableXxx() metódusok a paraméterként átadott kollekció csak olvasható nézetét adják vissza, azaz ezek tartalma nem módosítható. Az eredeti lista módosítható marad, ha abban változtatunk, akkor az látszani fog az itt visszakapott listán is.
⦁	A listákon még további két gyakran használt metódust tartalmaz. A reverse(List<?> list) a paraméterül kapott listában megfordítja az elemek sorrendjét, a shuffle(List<?> list) pedig véletlenszerűen összekeveri az elemeket. Ez utóbbihoz második paraméterként átadhatjuk a keveréshez használt Random példányt is, ami mint már láttuk, seeddel irányítható véletlenszám generátor. Az így kapott keverés már kiszámítható és jól tesztelhető.

Iterator:
Iterator<String> itr =resultSet.iterator();
while(itr.hasNext()){
System.out.println(itr.next());

