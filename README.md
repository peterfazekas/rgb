# RGB színek

- [Feladat](https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2023tavasz_emelt/e_inf_23maj_fl.pdf#page=10)
- [Forrás](https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2023tavasz_emelt/e_inffor_23maj_fl.zip)
---
Fényképek számítógépes tárolására sokféle képformátumot ismerünk. A legegyszerűbb
típusok az eredeti kép pixeleihez tartozó színértékeket tárolják, például ilyen a BMP vagy
a fényképezőgépek által használt RAW formátum. Az ilyen képállomány bináris, melynek első
néhány bájtja a kép jellemzőit írja le, míg a további bájtok sorfolytonosan a kép egy-egy
pixelének színét adják meg.

Ebben a feladatban egy RAW formátumú fájlból átalakított szöveges állományt kell
feldolgoznia. A kep.txt szöveges állomány egy 640×360 méretű, RGB kódolású képet ír le.
Az állomány csak a képpontok színét tartalmazza sorfolytonosan, azaz a fájl 360 sorának
mindegyike 640 képpontból, képpontonként három színértékből áll. Az első szám a piros (Red),
a második szám a zöld (Green) és a harmadik szám a kék (Blue) értéket tartalmazza. Az RGB
értékek 0 és 255 közötti egészek, melyeket a fájlban egy-egy szóköz választ el.

Részlet az állomány első néhány sorából:
```text

0 85 112 0 86 113 0 86 113 0 86 113 0 86 113 0 86 113 …
0 86 111 0 86 111 0 86 113 0 86 113 0 86 113 0 86 113 …
0 86 113 0 86 113 0 86 113 0 86 113 0 86 113 1 87 114 …
0 86 113 0 86 113 0 86 113 0 86 113 1 87 114 1 87 114 …
…
```

Az első sor első három száma a kép bal felső képpontjának színe, azaz RGB(0, 85, 112), míg
a második sor harmadik pixelének színe RGB(0, 86, 113), a negyedik sor hatodik oszlopában
lévő képpont színe RGB(1, 87, 114). 

Készítsen programot, amely az állomány adatait felhasználva megoldja az alábbi
feladatokat! A program forráskódját mentse `rgb` néven! A program megírásakor a felhasználó
által megadott adatok helyességét, érvényességét nem kell ellenőriznie, és feltételezheti, hogy
a beolvasandó adatok a leírtaknak megfelelnek.

A képernyőre írást igénylő részfeladatok esetén – a mintához tartalmában hasonlóan – írja
ki a képernyőre a feladat sorszámát (például: `2. feladat:`), és utaljon a kiírt tartalomra is!
Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár! Mindkét
esetben az ékezetmentes kiírás is elfogadott.
1. Olvassa be a `kep.txt` állomány tartalmát, és tárolja el a 640×360 képpont színét!
2. Kérje be a felhasználótól a kép egy pontjának sor- és oszlopszámát (a számozás mindkét
   esetben 1-től indul), és írja a képernyőre az adott képpont RGB színösszetevőit a minta
   szerint!
3. Világosnak tekintjük az olyan képpontot, amely RGB-értékeinek összege 600-nál nagyobb. Számolja meg és írja ki, hogy a teljes képen hány világos képpont van!
4. A kép legsötétebb pontjainak azokat a pontokat tekintjük, amelyek RGB-értékeinek összege
   a legkisebb. Adja meg, hogy mennyi a legkisebb összeg, illetve keresse meg az ilyen RGB
   összegű pixeleket, és írja ki mindegyik színét `RGB(r,g,b)` formában a mintának
   megfelelően!
5. A képen a kék ég látható közepén egy felhővel. Az ég és a felhő színe között jelentős
   különbség van, így az ég-felhő határvonal programmal is felismerhető. Ennek
   megtalálásához készítsen függvényt hatar néven, amely megadja, hogy egy adott sorban
   van-e olyan hely a képen, ahol az egymás melletti képpontok kék színösszetevőinek eltérése
   meghalad egy adott értéket! A függvény kapja meg paraméterként a sor számát, illetve
   az eltérés értékét, melyek egészek! A függvény visszatérési értéke egy logikai érték legyen,
   amely megadja, hogy az adott sorban volt-e az eltérést meghaladó különbség az egymás
   melletti képpontok kék színében!
6. Keresse meg a képen a felhő első és utolsó sorát az előzőleg elkészített függvény
   segítségével úgy, hogy eltérésként 10-et ad meg a függvénynek bemenetként! Adja meg
   az első és az utolsó olyan sor sorszámát, ahol az eltérés a soron belül valahol 10-nél
   nagyobb!

Példa a szöveges kimenetek kialakításához:

```text
2. feladat:
Kérem egy képpont adatait!
Sor:180
Oszlop:320
A képpont színe RGB(184,183,181)
3. feladat:
A világos képpontok száma: 7837
4. feladat:
A legsötétebb pont RGB összege: 197
A legsötétebb pixelek színe:
RGB(0,85,112)
RGB(0,86,111)
RGB(0,86,111)
6. feladat:
A felhő legfelső sora: 103
A felhő legalsó sora: 280
```