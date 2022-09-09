package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

// SUP SUP!
public class Oblig1 {

    private Oblig1() {

    }



    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) {                                                                    //Lager en if som sjekker om arrayets lengde er 0
            throw new NoSuchElementException("Arrayet er tomt");                                //en exception gis om dette er tilfellet.        
        }                                                                                       //Sjekker så om lengden er 1 og returnerer da verdien
        else if (a.length == 1){                                                                //da du ikke kan sortere et sett med bare en verdi.
            return a[0];
        }
        for (int i=1; i < a.length; i++ ){                                                      //Lager en for løkke som sammenligner to og to tall
            if (a[i] < a[i-1]){                                                                 //i arrayet, starter indeks på 1 for å unngå out of bounds.
                int b = a[i];                                                                   //Oppretter en variabel for å lagre en av verdiene
                a[i] = a[i-1];                                                                  //mens de bytter plass.
                a[i-1] = b;
            }
        }
        return a[a.length-1];                                                                   //Returnerer siste plass i arrayet.
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt");
        }
        else if (a.length == 1){
            return 0;
        }
        int c = 0;                                                                              //Introduserer variabel "c" som brukes some en counter,
        for (int i=1; i < a.length; i++ ){                                                      //denne inkrementeres hver gang et bytte forekommer.
            if (a[i] < a[i-1]){               
                int b = a[i];
                a[i] = a[i-1];
                a[i-1] = b;
                c++;
            }
        }
        return c;                                                                               //Returnerer antall bytter.
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int counter = 0;                                                                        //Lager en counter for å holde styr på antall unike verdier.
        if(a.length >= 1){                                                                      //If-setning som sørger for at vi ikke får en out of bounds
            counter = 1;                                                                        //Counter settes til 1 for å kompensere for skippet første. 
            for(int i = 1; i <= a.length-1; i++){                                               //i for-løkken(første verdi alltid unik).    
                if(a[i] > a[i-1]){          
                    counter++;                                                                  //Counter inkrementeres om verdi a[i] er større enn verdi
                }                                                                               //i forrige indeks.
                else if(a[i] < a[i-1]){                                                         //Om a[i] er mindre enn forrige indeks er listen usortert
                    throw new IllegalStateException("Tabellen er ikke sortert!");               //vi kaster da en exception.
                }
            }
        }
        else if(a.length == 2){                                                                 //Nested if-setning om listen er 2 lang. Er tallene like
            if(a[1] == a[0]){                                                                   //setter vi counter til 1, om de er forskjellige setter
                counter = 1;                                                                    //vi counter til 2.
            }
            else{
                counter = 2;
            }
        }
        return counter;    
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int counter = 0;                                                                    //oppretter en variabel for å holde styr på antall unike verdier.
        if(a.length>1){                                                                     //If-setning gjør at tellingen ikke forekommer på tabeller med
            counter = 1;                                                                    //mer enn 1 verdi. Counter settes til 1 da første verdi alltid er unik.                                                                    
            for(int i = 1; i < a.length; i++){                                              //Nested for-loop sammenligner hver verdi i "a" med alle verdiene før den.
                boolean nonunique = false;
                int test = a[i];
                for(int k = i-1; k >= 0; k--){
                    if(test == a[k]){                                                       //Om verdi a[i] har forekommet tidligere i tabellen er det ikke
                        nonunique = true;                                                   //unikt.
                    }
                }
                if(!nonunique){                                                             //Om det ikke har forekommet er boolen false og tallet er unikt,
                    counter++;                                                              //telleren inkrementeres.
                }
            }
        }
        else if(a.length == 1){                                                             //Om lengden av tabellen er 1 må vi returnere 1.
            counter = 1;
        }
        return counter;                                                                     //Returnerer antall unike.
    }

    ///// Oppgave 4 //////////////////////////////////////
    
    
    private static int partition(int[] a, int length){                                          //Lager først en partiotener funksjon som skiller oddetall fra partall.
        int max = length-1;
        int min = 0;
        while(max > min){                                                                       //While-løkke kjører til indeksene møtes i midten.
            int temp;
            while(a[min]%2 != 0 && min < max){                                                  //Sjekker om veriden på venstresiden er et oddetall,
                min++;                                                                          //inkrementerer min om dette er tilfelle.
            }
            while(a[max]%2 == 0 && max > min){                                                  //Sjekker om veriden på høyresiden er et partall,
                max--;                                                                          //senker max om dette er tilfelle.
            }
            temp = a[min];                                                                      //om venstresiden er et partall og høyresiden et
            a[min] = a[max];                                                                    //oddetall bytter de plass.
            a[max] = temp;
        }
        return max;                                                                             //Returnerer skillet mellom de to seksjonene
    }
    private static int bsparter(int[] a, int min, int max){                                     //Lager en Quicksort-partitioner som sammenligner
       int pivot = a[max];                                                                      //verdier i a[] mot en pivot som alltid er tilsvarende a[max].
       int i = min-1;
       for(int j = min; j <= max; j++){
           if(a[j] <= pivot){                                                                   //Om verdien i a[j] er mindre eller lik pivot utføres et swap
               i++;                                                                             //i inkrementeres og prosessen repeteres til vi når rekkens ende.
               int temp = a[i];
               a[i] = a[j];
               a[j] = temp;
           }
       }
       return i;
    }
    private static void quicksort(int[] a, int min, int max){                                     //Lager en Quicksort-manager, denne styrer partitionerens rekursive calls.
        if(min < max && min >= 0 && max >= 0){                                                    //If-setningen sørger for at ulovelige operasjoner ikke gjennomføres.
            
            
            int seperator = bsparter(a, min, max);                                                //Kjører bsparter-funksjonen for å finne en separator                                                                                     
            quicksort(a, min, seperator-1);                                                       //som splitter seksjonene av arrayet inn i mindre deler,
            quicksort(a, seperator+1, max);                                                       //qicksort blir så kalt rekursivt.
        }
    }
    public static void delsortering(int[] a) {
        if(a.length > 2){                                                                         //Det er umulig å sortere et sett på 1 eller 0 verdier,
            int limiter = partition(a, a.length);                                                 //if-setningen sørger for at dette ikke skjer.
            if(limiter == a.length-1){                                                            //Det er mulig at limiter == a.length, dette leder til 
                quicksort(a, 0, limiter);                                                         //at verdier hoppes over. Dette skjer bare om hele a[]
            }                                                                                     //består av partall eller oddetall. Begrensningene under
            else if(limiter == 0){                                                                //sørger for at sortering skjer på hele det spefiserte
                quicksort(a, limiter, a.length-1);                                                //settet.
            }
            else{
                quicksort(a, 0, limiter-1);
                quicksort(a, limiter, a.length-1);
            }
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        if(a.length != 0){                                               //sjekker om arrayet er tømt
            char last = a[a.length-1];                                   // lager last for å lagre det siste element i arrayet
            for( int i =a.length-1; i >= 0 ; i-- ) {                     // i den for-loop så skal jeg begynne fra slutten av arrayet og bevege bakover
                if(i<a.length-1){
                    a[i + 1] = a[i];                                     //hvis i er mindre lengden av arrayet så skal neste verdi bli erstattet med den forrige     
                }
            }
            a[0] = last;                                                 // forste element på array skal være lik den siste element.
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        int max = a.length - 1;
        int min = 0;
        if(k != 0 && max > 0){                                                                      //if-setning hindrer at deling på 0 forekommer.
            char[] b = a.clone();                                                                   //kloner a[] inn i en støttetabell b[]. 
            for( int i = a.length-1; i >= 0 ; i-- ) {
                int j = i + k;                                                                      //opretter j for å holde styr på målet.
                if(j > max){                                                                        //If-setninger sørger for a j alltid
                    j = j % a.length;                                                               //er innenfor tabellen.
                }
                else if(j < min){
                    j = j % a.length;
                    j = a.length + j;
                }
                if(i <= max){                                                                       //Erstatter posisjon j i a[]
                    a[j] = b[i];                                                                    //med verdi fra støttetabell.
                }
            }
        }

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String streng = "";                 //Instansierer tom streng, som en hjelpevariabel for å lagre resultatet.

        for (int i = 0; i < s.length() || i < t.length(); i++) {        //For løkke med nøstede if-setninger som gjør
            if (i < s.length()) {                                       //- flettingen ved bruk av s.charAt(i), som velger
                streng += (s.charAt(i));                                //- hvilken bokstav som skal hentes ut og lagres i streng.
            }
            if (i < t.length()) {
                streng += (t.charAt(i));
            }
        }
        String[] c = {streng};                             // Resultatet som hittil har blitt lagret i hjelpevariabel
        for (int j = 0; j < c.length; j++) {               //- lagres i nytt array.
            return (c[j]);
        }
        return c.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        String ut = "";

        int lengde = s.length;                    //Instansierer "int lengde" for å lagre lengden av "s". Altså antall strenger i "s".
        int indeks = 0;

        for (int i = 0; i < s.length; i++){        //løper gjennom "s" og henter total lengde av "s", som teller med alle
            indeks += s[i].length();                //-bokstaver, mellomrom osv.
        }

        int[] b = new int[lengde];                  //Opretter nytt array med korrekt antall plasser.
        for (int i = 0; i < indeks; i++) {
            for (int j = 0; j < lengde; j++) {
                if (b[j] < s[j].length()) {         //Hvis verdi av indeks "j" av "b" er mindre enn lengden på valgt streng i "s[j].length"
                    ut += s[j].charAt(b[j]);        //-legges verdien av "s[j].charAt(j)" i "ut".
                    b[j]++;                         //Det siste som gjøres er å inkrementere med en, slik at vi unngår
                }                                   //å behandle samme indeks i "b" flere ganger.
            }
        }
        return ut;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {

        //Lag copies (clones) av den opprinellig tabel.
        //int b[] og c[] kan funke som clones av a[].
        //b[] skal være som den er men c[] skal sorteres stigende med Arrays.sort().
        //Etter at b[] er sortert så skal vi sammenligne den med c[].
        //Hvis den verdien i b[] er lik den c[] så skal en variabel lagre indeks til denne.
        //Index verdien skal flyttes i et nytt array som vi skal inneholde alle de indeksene som oppgaven krever.
        // Vi kommer til å loop gjennom alle verdiene helt til den arrayet som skal inneholde de indeksene blir fylt opp.

        int clone_B [] = a.clone();//cloner av a[]
        int clone_C [] = a.clone();
        int index_Array []= new int [a.length]; // indeks array med størrelse av a[]
        int index = 0;
        Arrays.sort(clone_B);//sortering av tabel b til stigende.

        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a.length; j++){
                if(clone_B[i] == clone_C[j]){  //hvis den verdien fra array b ligner den fra c så skal vi lagre indeks til verdien
                    index_Array [index] = j;  //den tilsvarende indeks blir lagret i vårt nytt array.
                    clone_C[j]= -1; //Fjerner verdien fra d, slik at samme indeks ikke blir satt i c for duplikater
                    index++;  //index verdien i den nye tabellen økes med en slik at vi kan lagre de neste indeksene.
                }


            }
        }


        return index_Array;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        int indeksFM;                                       //Lager hjelpevariabler for å holde styr på indekser
        int indeksNM;
        int indeksTM;

        int verdiFM;                                        //Lager hjelpevariabler for å holde styr på verdiet
        int verdiNM;
        int verdiTM;

        if(a.length >= 3){                                  //Kjører bare programmet om a har mer enn tre verdier

            int[] b = {a[0],a[1],a[2]};                     //lager en støttetabell med de tre første verdiene i "a"
            int[] c = indekssortering(b);                   //Kjører indekssortering på støttetabellen for å sortere.

            indeksFM = c[0];                                //Setter inn de relevante indeksene på sine respektive plasser.
            indeksNM = c[1];
            indeksTM = c[2];

            verdiFM = b[indeksFM];                          //Setter verdiene for sammenligner
            verdiNM = b[indeksNM];
            verdiTM = b[indeksTM];

            for(int i = 3; i<a.length; i++){                //for-løkke går over verdier i "a" og sammenligner med støtteverdier
                if(a[i] < verdiFM){                         //om den er mindre enn en av de nåværende minste erstatter vi verdiene.
                    verdiTM = verdiNM;                      
                    verdiNM = verdiFM;
                    verdiFM = a[i];

                    indeksTM = indeksNM;
                    indeksNM = indeksFM;
                    indeksFM = i;
                }
                else if(a[i] < verdiNM){
                    verdiTM = verdiNM;
                    verdiNM = a[i];
                    
                    indeksTM = indeksNM;
                    indeksNM = i;       
                }
                else if(a[i] < verdiTM){
                    verdiTM = a[i];                    
                    indeksTM = i;  
                }           
            }
            return new int[] {indeksFM, indeksNM, indeksTM};    //returner liste med indeksene til de tre minste verdiene.
        }
        else{                                                   //om 'a' ikke har minst 3 verdier får vi en exception
            throw new NoSuchElementException("tabellen 'a' må ha minst 3 verdier!");
        }
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        boolean fant;                           //variabel som angir om man fant bokstaven i begge ordene
        char aArray[] = new char[a.length()];   //array for string a
        char bArray[] = new char[b.length()];   //array for string b

        for (int i = 0; i < a.length(); i++) {  //omgjør ordene til array med samme lengde som antall bokstaver
            aArray[i]=a.charAt(i);              //legger string a inn i aArray
        }

        for (int i = 0; i < b.length(); i++) {
            bArray[i]=b.charAt(i);              //legger string b inn i bArray
        }

        Arrays.sort(bArray);                        //sorterer ordene (arrayene)
        Arrays.sort(aArray);

        int e = 0;                                  //setter indeks i bArray til 0

        for (int i = 0; i<a.length(); i++) {        //denne for-løkken går gjennom sortert aArray
            fant = false;

            namedLoop: for ( ; e<b.length(); e++) { //denne for-løkken går gjennom sortert bArray
                if (aArray[i] == bArray[e]) {       //for hver verdi i aArray
                    bArray[e] = '-';                //fjerner verdien hvis man finner match
                    fant = true;                    //angir at man fant match
                    break namedLoop;                //avslutter letingen for gitt verdi i aArray
                }
            }                                       //siden e er angitt utenfor løkkene vil
                                                    //for-løkken lete der den slapp, i og med at de er sortert
            if (!fant) {
                return false;                       //returnerer false hvis den ikke fant verdi for alle
            }
        }

        return true;
    }
}


  // Oblig1
