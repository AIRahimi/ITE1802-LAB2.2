# ITE1802-LAB2.2

## Utvikle en kalkulatorapp

### a) Lag en Android-app med en Activity som ser omentrent slik ut:

![kalkulatorbilde](http://kark.hin.no/~wfa004/fag/android/2019/img/calc1.png)


Når brukeren trykker på de ulike knappene skal knappens tekst dukke opp i "display"-delen av kalkulatoren. Dersom brukeren f.eks,. skriver inn 2 + 3 og deretter trykker = skal displayet vise svaret (5.0).

Bruk symja-biblioteket til å tolke/parse det mattematiske uttrykket som brukeren skriver inn. Se gjennomgangen her for mer info.: [Kalkulator-2.pdf](https://uit.instructure.com/courses/11664/files/404701/download?verifier=1KRFaJftn4ZaVVpocXJ9KO10W1ac2Y3m95rHZD0A&wrap=1)

### b) Legg til action bar

Les/jobb deg gjennom denne; "Adding the Action Bar [Adding the Action Bar](https://developer.android.com/training/appbar/)(til og med "Overlaying the Action Bar") og sørg for at din kalkulatorapplikasjon utvides med actionbar-elementer/ikoner for "Normal", "Vitenskapelig", "Enhetsomregning", "Avslutt" og "Hjelp".

Finn/lag selv ikoner. Foruten "Avslutt" skal trykk på et av ikonene/actionbar-knappene resultere i at det dukker opp en en dialogboks som viser hva som er valgt.

Bruk f.eks. følgende kode for å vise en dialogboks:

```
AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
alertDialog.setTitle("Hjelp");
alertDialog.setMessage("Info info info");
alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
alertDialog.show();
```

Ved trykk på "Avslutt" vil this.finish() sørge for at aktiviteten terminerer.
