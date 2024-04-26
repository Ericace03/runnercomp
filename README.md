# Futóverseny kezelő alkalmazás
<img width="677" alt="feladat" src="https://github.com/Ericace03/runnercomp/assets/113349893/08bba890-7fc3-4fc9-b0e0-bb7c5f2f3167">

### GDE - Alkalmazásfejlesztés technológia - F17NZC
Cél: Fejlessz egy webalkalmazást, amely képes kezelni egy futóverseny résztvevőinek adatait, eredményeit, és megjeleníteni azok statisztikáit.

#### Funkcionális Követelmények
###### Alapvető Entitások
● Futó: név, életkor, nem, és egyéni azonosító.

● Verseny: neve, távolsága (km), azonosító.

● Eredmény: résztvevő, verseny, időeredmény perc.

#### Az entitásokhoz vegyünk fel automatikusan tesztadatot a program futtatásakor a H2 adatbázisban (min. 4 futó, 2 verseny, 6 eredmény)

###### Alapvető műveletek REST API-n keresztül:

● /getRunners: összes futó alapadatai json struktúrában)

● /addRunner: futó felvétele post payloadban átadott adatok alapján

● /getRaceRunners/{ID}: adott azonosítójú verseny összes futójának neve és időeredménye emelkedő sorrendben)

● /updateRace: POST json payloadban átadott versenyazonsító nevének és távolságának update-je

● /addResult: Új eredmény rögzítése futók és versenyek számára

● /getAverageTime/{VERSENYID} Átlagos futási idő számítása egy adott versenyre

###### Thymeleaf frontend:

● Versenyek listázása

● Új verseny létrehozása (név, táv megadásával)

● Versenyek részletek oldala, amelyen a futók eredményei látszódnak (név, időeredmény)
