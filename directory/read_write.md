-------------ÍRÁS KIS MÉRET, EGYBEN-------------
Files.writeString(file, "John Doe\nJane Doe\n"): egy lépésben kiírja a teljes szöveget, létrehoz/felülír
Files.writeString(file, "John Doe\nJane Doe", StandardOpenOption.APPEND): hozzáfűz
Files.write(file, list): minden listaelem külön-külön sorba kerül


Path file = Path.of("employees.txt");
try{
Files.writeString(file, "John Doe\nJane Doe\n", Charset.forName("ISO-8859-2"));
}
catch(IOException ioe){
throw new IllegalStateException("Can not write file", ioe);
}


StandardOpenOption.APPEND: az új szöveget a már meglévő tartalom végéhez szeretnénk hozzáfűzni

List<String> employees = List.of("John Doe", "Jane Doe");
Files.write(file,employees);

A Files.write() metódusnak is lehet karakterkészletet, illetve OpenOption példányokat átadni paraméterként,ezzel
szövegek listája is kiírható fájlba

------------ÍRÁS DARABOKBAN? NAGY MÉRET---------------------

Files.newBufferedWriter(file):
write(): sorvége jelet külön karakterként nekünk kell kiírni. Mivel ez rendszerfüggő, a BufferedWriter newLine() metódust biztosít hozzá.

List<String> employees = List.of("John Doe", "Jane Doe", "Jack Doe");
Path file = Path.of("employees.txt");

        try(BufferedWriter writer = Files.newBufferedWriter(file)){
         for (String employee : employees) {
            writer.write(employee + "\n");
        }
    }
    catch(IOException ioe){
    throw new IllegalStateException("Can not write file", ioe);
}

Régen:
BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));

------------PRINTWRITER-----------

new PrintWriter(Files.newBufferedWriter(file)):különböző típusú adatok kiírása szöveggé konvertálás nélkül.
print(), println() és a printf():  overloadolt, minden primitív típusú, valamint String és általános Object típusú adattal is paraméterezhető.

List<String> employees = List.of("John Doe", "Jane Doe", "Jack Doe");
Path file = Path.of("employees.txt");
try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))){
for (String employee : employees) {
writer.print(employee);
writer.print(",");
writer.println(200_000);
}
}
catch(IOException ioe){
throw new IllegalStateException("Can not read file", ioe);
}

--------------------BINÁRIS ÍRÁS, KIS MÉRET EGYBEN---------
Files.write(file, new byte[]{97, 98, 99, 100, 101}): bináris állomány írására is, amennyiben második paraméterként byte[] típusú adatot adunk át.

Path file = Path.of("data.dat");
try {
Files.write(file, new byte[]{97, 98, 99, 100, 101});
}
catch (IOException ioe) {
throw new IllegalStateException("Can not write file", ioe);
}

------------------BINÁRIS NAGY MÉRET, DARABOKBAN-----------------

new BufferedOutputStream(Files.newOutputStream(file)): Bináris fájlok írásához
write() metódussal írhatjuk ki a paraméterként átadott byte[] típusú adatot.

Path file = Path.of("data.dat");
try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
for (int i = 0; i < 1100; i++) {
outputStream.write("abcde".getBytes());
}
}
catch (IOException ioe) {
throw new IllegalStateException("Cannot write file", ioe);
}


Régen:
OutputStream os = new BufferedOutputStream(new FileOutputStream("data.dat"))
OutputStream os = new BufferedOutputStream(new FileOutputStream(newFile("data.dat")))

-------------------ÍRÁS TÖMÖRÍTÉSSEL---------------

new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))
.putNextEntry(new ZipEntry("data.dat")):
new ZipEntry("folder/") egy folder nevű mappát hoz létre,
new ZipEntry("folder/data.dat") egy data.dat nevű fájlt hoz létre a folder mappában.

Path file = Path.of("data.zip");
try (ZipOutputStream os = newZipOutputStream(newBufferedOutputStream(Files.newOutputStream(file)))) {
os.putNextEntry(new ZipEntry("data.dat"));
for (int i = 0; i < 1100; i++) {
os.write("abcde".getBytes());
}
}   
catch (IOException ioe) {
throw new IllegalStateException("Can not write file", ioe);
}

--------------PRINTSTREAM---------------

A PrintStream metódusai bármilyen típusú adat szöveges reprezentációját képes kiírni a print(), println() és printf() overloadolt metódusaival.

Path file = Path.of("employees.txt");
List<String> employees = List.of("John Doe", "Jane Doe", "Jack Doe");

    try (PrintStream outputStream = new PrintStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (String employee: employees) {
                outputStream.print(employee);
                outputStream.print(",");
                outputStream.println(200_000);
            }
    }
        catch (IOException ioe) {
                throw new IllegalStateException("Can not write file", ioe);
        }

-----------------------DATAOUTPUTSTREAM---------------
Bináris állományba nem csak bájtokat, hanem egyéb primitív típusú adatokat és szöveget is írhatunk DataOutputStream segítségével. A metódusai az adatokat bájtsorozattá alakítják, majd átadják az alatta lévő OutputStream-nek. Minden adattípusnak saját metódusa van, például writeInt(), writeDouble, szöveghez a writeUTF().
new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))
writeInt(), writeDouble, szöveghez a writeUTF()



Path file = Path.of("data.dat");
try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
outputStream.writeUTF("John Doe");
outputStream.writeInt(200_000);
}
catch (IOException ioe) {
throw new IllegalStateException("Can not write file", ioe);
}

--------------------Writer absztrakt osztály leszármazottai--------------
---------------------nagy, szöveges fájlok kiírására--------------

BufferedWriter: Writer absztrakt osztály utóda
Files.newBufferdWriter(Path obj)
write(String str + “\n”): fájlba szöveget írni soronként, sortöréssel
(régen: BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));)
PrintWriter: különböző típusú adatok kiírása szöveggé konvertálás nélkül is lehetséges print(), println() és a printf() metódusok
StringWriter: Stringbe, memóriába ír, tesztelésre használjuk, ahol a metódus Writert vár
OutputStreamWriter: OutputStream-et Writerré konvertál: bájtokat konvertál karakterekké

--------------------OutputStream absztrakt osztály leszármazottai----------------
-------------------------bájtok folyamatos kiírására-------------------

BufferedOutputStream: bájtok folyamatos kiírására pufferelve
(régen: new BufferedOutputStream(new FileOutputStream(new File));)
DataOutputStream: egyéb adatok(int, double, String) konvertálása adatfolyammá. Az adatok byte reprezentációját írja ki
◦ writeInt()
◦ writeDouble()
◦ writeUTF()
OutputStream-et csomagol be.
bájtok folyamatos kiírására: zip-be írás
◦ putNextEntry(): új zipEntry-t rak a fájlbaés onnantól ugyanúgy ír bele, mint egy sima OutputStream


