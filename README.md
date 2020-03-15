# Prvi preizkus virtualnega IT hekatona

Več informacij: https://www.mojedelo.com/hekaton

# CAMPAIGN BRIEF
## PRVI PREIZKUS
### LedDisplay

Prejel si naročilo iz podjetja MojaTrgovina. Naročnik želi, da se kupcu, ki skenira črtno kodo izdelka, na led zaslonu izpiše ime, cena in opis skeniranega izdelka. Vsi artikli, ki jih uporabnik skenira, morajo biti izpisani na zaslonu. V različnih trgovinah po Sloveniji imajo zaslone različnih velikosti, vendar so vsi pravokotni. Širina in višina zaslona sta navedena spodaj, skupaj z besedilom, ki naj bo izpisano na zaslonu. Ker želimo izkoristiti cel led zaslon je potrebno preračunati koliko pikslov je lahko velik posamezen znak besedila prikazanega na zaslonu, ne da bi pri tem razdelili katero koli besedo. Vsi znaki morajo imeti enako širino in višino (npr. 'l' in 'm' zavzemata isti vodoravni prostor, kot tudi presledek). Znaki pisave so enake širine in višine, zato ni dodatnega razmika med sosednjimi znaki ali sosednjimi vrsticami.

## Vhod

Vsaka vrstica vhodne datoteke vsebuje en testni primer v obliki 'S V B'. S je širina in V višina število pikslov razpoložljivega prostora; B je besedilo, ki bi se naj prikazalo na led zaslonu.

## Izhod

Izhod vsebuje po eno vrstico za vsak primer. Če teksta ne moremo prikazati potem je vrednost 0.

## Oddaja rešitve

V prilogi se nahaja datoteka vhodi.txt, ki vsebuje testne primere, katere morate rešiti z vašim programom. Kot rešitev naloge oddate ZIP arhiv, ki vsebuje programsko rešitev (programsko kodo). V opis pri oddaji ideje dodajte izhode, ki jih vrne vaš program za testne primere iz datoteke vhodi.txt. Rešitve brez ustreznega opisa se ne bodo upoštevale.

## Primer delovanja programa
```sh
Vhod:
20 6 led display
100 20 led display 2020
10 20 MUST BE ABLE TO DISPLAY
55 25 Can you hack
100 20 display product text

Izhod:
2
9
1
8
8
```

## Pogosto zastavljena vprašanja

**Kako si lahko predstavljam znake/črke velikosti 2x2 p ali celo 1x1 p (druga in tretja izhodna vrstica primera)?**

Čeprav tehnično ne bi bilo izvedljivo si za potrebe naloge lahko predstavljamo, da v polje 1x1 lahko zapišemo vseh 25 črk abecede in so dovolj dobro čitljive.

**Ali se išče maksimalna velikost posameznega znaka, da se zapolni zaslon s podatki produkta?**

Ja bistvo naloge je, da so znaki največje možne velikosti, da bo vso besedilo lahko prikazano na zaslonu in ne bo nobena beseda razdeljena v več vrstic. Stavki so pa lahko razdeljeni v več vrstic.

**Ali se lahko stavki delijo v več vrstic, le da se posamezna beseda ne razdeli?**

Ja stavki se lahko delijo v več vrstic, samo beseda se ne sme bit razdeljena v več vrstic.

Tudi besedna zveza wait-for-it se šteje kot posamezna beseda, saj ni razdeljena z presledki, ampak z vezaji.

**Ali se beseda z vezaji wait-for-it lahko deli v nove vrstice ali ne?**

Ne, beseda wait-for-it mora biti v eni vrstici, ker je beseda vezana z vezaji in ni ločena s presledki.

**Kako je lahko en znak dimenzij 1, 2 ali 3 piksle, kot je to prikazano v primeru? Ce je znak velik 1x1 piksel, to pomeni da ima samo 2 mozni stanji in nikakor ne more prikazovati 25 znakov abecede. Enako velja za znake velikosti 2x2 piksla (16 stanj). Za 3x3 piksle lahko prikazujemo 512 razlicnih stanj, vendar je vprasanje, ce bodo tam crke se citljive. Kaj torej pomeni, da je znak lahko velik 1 piksel, kot je to prikazano v primeru naloge?**

Čeprav imate prav, da tehnično ne bi bilo izvedljivo, da v enem pikslu prikažemo vse črke abecede, si za potrebe naloge, ki je bolj logične in ne praktične narave, lahko predstavljamo, da v polje 1x1 lahko zapišemo vseh 25 črk abecede in so le te dovolj dobro čitljive.

**Kakšen je nabor znakov, ki se uporablja za vhod? Kaksen je encoding datoteke? Kateri so veljavni znaki vhoda?**

Nabor znakov, ki se uporablja kot vhod so znaki, ki jih lahko kodiramo v ASCII, ker je encoding datoteke prav tako ASCII.

**Kako se ločuje beseda? Ali je beseda vedno locena samo s presledkom, ali kot svojo besedo šteje tudi ločila (npr v vhodih: wait-for-it, 'hello', friend!)**

Beseda se ločuje samo s presledki, kar seveda pomeni, da se mora vhod wait-for-it pojaviti v eni vrstici, ne sme biti razdeljen v več vrstic.

**Ali mora v primeru nove vrstice presledek biti tudi prikazan na koncu vrstice ali ne? Npr. ce ima zaslon zadosti prostora za 5 znakov, ali to pomeni, da lahko v 2 vrstici spraviš 2 besedi s 5 znaki ali samo eno besedo s 4 znaki in presledkom in eno besedo s 5 znaki**

Če je naslednja beseda v novi vrstici to pomeni, da v prejšnji vrstici na koncu presledek ni potreben.