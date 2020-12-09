package eti.policarto.data;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Datas com Java 8");

        DateTimeFormatter brazilianFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate hoje = LocalDate.now();
        System.out.println(brazilianFormatter.format(hoje));

        LocalDate copaMundoQuatar = LocalDate.of(2022,7,1);
        System.out.println(brazilianFormatter.format(copaMundoQuatar));

        Period between = Period.between(hoje, copaMundoQuatar);
        System.out.printf(
                "%s Ano, %s Meses e %s dias %n",
                between.getYears(),
                between.getMonths(),
                between.getDays()
        );

        brazilianFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(brazilianFormatter));

        MonthDay monthDay = MonthDay.of(9,21);

        System.out.println(monthDay.toString());

    }
}
