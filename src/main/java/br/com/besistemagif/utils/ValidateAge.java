package br.com.besistemagif.utils;

import br.com.besistemagif.domains.clients.ClientsEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ValidateAge {

    public static boolean toValid(ClientsEntity clients) {
        if ( getAge(clients) > 16 ) {
            return true;
        } else {
            return false;
        }
    }

    private static Integer getAge(ClientsEntity clients) {
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar birthDate = new GregorianCalendar();
        birthDate.setTime(toDate(clients.getBirthDate()));
        int currentYear = today.get(Calendar.YEAR);
        int birthYear = birthDate.get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    private static Date toDate(String date) {
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            return formatDate.parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
