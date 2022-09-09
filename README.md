[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=448316&assignment_repo_type=GroupAssignmentRepo)
# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Petter Kreutz Sundh, S356095, s356095@oslomet.no
* Alexandros Messaritakis Chousein Aga, S326156, s326156@oslomet.no
* Trygve Reisæter Kristoffersen, s354579, s3545679@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Petter har hatt hovedansvar for oppgave 1 , 4 og 6. 
* Alex har hatt hovedansvar for oppgave 5, 8, og 10. 
* Trygve har hatt hovedansvar for oppgave 7 og 9. 
* Vi har i fellesskap løst oppgave 2 og 3. 

# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å  først lage en if-setning som sjekker om arrayets lengde er 0, en exception gis om dette er tilfellet.
Vi sjekker så om lengden er 1 og returnerer da verdien ved hjelp av en "else if" da du ikke kan sortere et sett med bare en verdi.
Etter dette lagde jeg en for-løkke som sammenligner to og to tall i arrayet, løkkens indeks starter på 1 for å unngå en out of bounds exception.
Selve sammenligningen ble gjort ved hjelp av en if-setning.

For å lage antall ombyttinger funksjonen la vi til en "counter" variabel kalt "c" og inkrementerte denne hver gang et bytte forekom.

I oppgave 2 så brukte vi en for-løkke til å løpe gjennom tabellen og inkrementere en teller hver gang neste tall i tabellen var større enn det forrige.
Dette fungerer bare da listen er ferdig sortert og vil gi feil tilbakemelding i alle andre tilfeller. En rekke if-setninger ble brukt for å hindre untak
og out of bounds tilfeller, se kommentarer i kildekode for nærmere forklaringer.

I oppgave 3 er det brukt en nested for-løkke for å sammenligne hvert tall i tabellen med alle tall før det. Støttevariablene int "counter"
og bool "nonunique" brukes for å holde styr på hvor mange unike tall vi har funnet og om den nåvœrende sammenligningen gjøres på et unikt tall.
If-setninger brukes for å hindre for-løkkene fra å kjøre på tabeller med mindre enn 2 verdier da dette hadde gitt feil resultat.

I oppgave 4 brukte jeg to forskjellige sorteringsfunksjoner. Først en type algoritme som søkte gjennom tabellen fra begge sider og søkte seg inn mot midten, om den møtte et partall
på venstre side stoppet den og ventet til et oddetall ble funnet fra høyreside, når dette skjedde bytter de to tallene plass og søket fortsetter til indeksene møtes i "midten.
Deretter tok jeg i bruk en quicksort funksjon som så på de to "seksjonene" av tabellen separat og sorterete dem på størrelse i stigende rekkefølge.

I oppgave 5 For å kunne "rotere" alle bokstavenene et skritt til høyre
, så måtte jeg flytte hver eneste element til et indeks videre i arrayet. 
F.eks( Index 7-> Index 8, og så Index 6 -> Index 7 til vi kommer frem til Index 0.) 
Til slutt ved hjelp av en midlertidig variabel, kunne jeg lagre det siste bokstavet i arrayet og legge den i index 0.

I oppgave 6 brukte jeg en forbedret utgave av oppgave 5, den tillater rotasjoner i beggge retninger og over flere plasser ved hjelp av en indeks "j"
og en støttetabell "b". Se kommentarer i kildekode.

Oppgave 7a)
Første FOR-løkke:
-kjører så lenge i er mindre enn lengden på "s" og "t".
Første if:
-Dersom "i" er mindre enn "s" så legger vi verdien av indeks "i" fra "s", inn i "streng".
Andre if:
-Denne gjør det samme som den første, men med "t".

Instansierer så et streng-array kalt "c" og legger "streng" inn her.
Andre FOR-løkke:
-løper gjennom "c".
Returner til slutt "c" ved hjelp av "toString()".

Oppgave 7b)
Instansierer "String ut = "" ".
instansierer "int lengde", og legger lengden av "s" inn i denne. Dette blir da antall strenger i "s", og ikke antall tegn.
Instansierer "int indeks" og setter denne til 0.
Første FOR-løkke:
-looper gjennom "s", og legger lengden av hver streng i "s" inn i "indeks", altså totalt antall tegn, mellomrom osv.

Instansierer tomt array "b", og setter av antall plasser som det er tegn i "s", som man får fra første for-løkke.
Andre FOR-løkke:
Den andre for-løkka kjører så lenge "i" er mindre enn "indeks" (som er det totale antall tegn i "s").

Nøstet FOR-løkke:
-Den tredje, og nøstede for-løkka kjører så lenge "j" er mindre enn "lengde" (som er lengden på "s", altså 
antall strenger, og ikke tegn).
IF-statement:
-Dersom indeks "j" av "b" er mindre enn lengden av indeks "j" av "s": legger vi verdien av "s[j].charAt(b(j))" over i "ut",
og sier "b[j]++", for å hoppe til neste indeks i strengen og unngå at vi behandler samme indeks flere ganger.
"s[j]" velger hvilken streng vi skal se på, og "charAt(b(j))" velger hvilken indeks i strengen som skal legges over i ut-strengen.

I oppgave 8 bruker jeg 2 arrays som skal være clones av a-arrayet. Hele poenget med det er 
vi må ha en tabel som skal være sortert på stigende og skal sammenlignes med den andre.
Når vi har funnet like verdier fra begge de tabelene, så bruker vi en hjelpevariabel som skal ta inn
indeks av den verdien og legge den i et nytt array som skal ha samme lengde som den arrayet vi prøver å jobbe med.
Vi bruker dobbel for-loops for å kunne kjøre gjennom begge array. I den sorterte arrayet skal vi ta den første verdien og sammenligne den med alle 
de verdiene fra den usorterte arrayet helt til vi har lagt inn alle de indeksene som vi må printe ut.

I oppgave 9 brukte vi en del støttetabeller og variabler. Vi laget en støttetabell 'b' med tre første verdiene fra tabell 'a', kjørte indekssorterings funksjonen fra
oppgave 8 på tabell 'b' og la resultatet inn i en tabell 'c'. Tabell 'c' ble brukt for å initiere støttevariablene for indeks og verdi på de tre minste verdiene fra 'a'.
Disse variablene ble utgangspunkt for sammenligninger i en for-løkke. For-løkken starter på posisjon 3 i 'a' da 0,1 og 2 allerede er tatt hånd om i støttevariablene.
For-løkken løper gjennom 'a' om a[i] er mindre enn vår nåværende minste verdi dytter vi minste til nest minste, nest minste til tredje minste og setter minste til a[i].
Det samme gjøres også for indekser. Etter at for-løkken er ferdig returnerer vi en tabell med indeksen til de tre minste verdiene. Da minst 3 verdier er nødvendig kastes
ett untak om 'a' ikke har minst 3 verdier.

I oppgave 10 så legger jeg begge ordene i char-array. Hver bokstav av hvert ord settes i de nye char-array. Deretter sorterer jeg begge char-array og på den måte
kan jeg sammenligne begge tabelene. Om jeg finner en likhet, så erstatter jeg bokstavet fra den andre array med "-". Dette gjør jeg for å hindre å sammenligne samme 
bokstav igjen og igjen. Hvis alle bokstavene fra den ene arrayet er lik de bokstavene fra den andre, så returnerer metoden true.
