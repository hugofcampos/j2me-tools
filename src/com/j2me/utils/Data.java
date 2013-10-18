/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.j2me.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author willian
 */
public class Data {
    
    public static java.util.Date transformaEmData(String d) {   
       //2008-05-10T19:42:28.703
        String ano, mes, dia;

        ano = d.substring(0, 4);   
        mes = d.substring(5, 7);   
        dia = d.substring(8, 10);

        Calendar cal = Calendar.getInstance();   

        cal.setTime(new Date());   

        cal.set(Calendar.YEAR, Integer.parseInt(ano));   
        cal.set(Calendar.MONTH, (Integer.parseInt(mes)-1));   
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));   

        return cal.getTime();
    }
    
    public static java.util.Date transformaEmDataHora(String d) {   
        //2008-05-10T19:42:28.703
        String ano, mes, dia, hora, minuto;   
            
        ano = d.substring(0, 4);   
        mes = d.substring(5, 7);   
        dia = d.substring(8, 10);
        hora = d.substring(11, 13);
        minuto = d.substring(14, 16);
            
        Calendar cal = Calendar.getInstance();   
            
        cal.setTime(new Date());
            
        cal.set(Calendar.YEAR, Integer.parseInt(ano));   
        cal.set(Calendar.MONTH, (Integer.parseInt(mes)-1));   
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));   
        //cal.set(Calendar.HOUR, Integer.parseInt(hora));
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
        cal.set(Calendar.MINUTE, Integer.parseInt(minuto));
            
        return cal.getTime();
    }
    
    public static java.util.Date getTime(String d) {   
        //2008-05-10T19:42:28.703
        String ano, mes, dia, hora, minuto, segundo;   
        Calendar cal = Calendar.getInstance();
        
        cal.setTime(new Date());
            
        ano = d.substring(0, 4);   
        mes = d.substring(5, 7);   
        dia = d.substring(8, 10);
        
        if(d.length() > 10){
            hora = d.substring(11, 13);
            minuto = d.substring(14, 16);
            segundo = d.substring(17, 19);
            
            cal.set(Calendar.YEAR, Integer.parseInt(ano));   
            cal.set(Calendar.MONTH, (Integer.parseInt(mes)-1));   
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));   
            
            if(d.length() > 10){
                hora = d.substring(11, 13);
                cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
                
                if(d.length() > 13){
                    minuto = d.substring(14, 16);
                    cal.set(Calendar.MINUTE, Integer.parseInt(minuto));
                    
                    if(d.length() > 16){
                        segundo = d.substring(17, 19);
                        cal.set(Calendar.SECOND, Integer.parseInt(segundo));
                    }else{
                        cal.set(Calendar.SECOND, 0);
                    }
                }else{
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                }
            }else{
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            }
        }else{
            cal.set(Calendar.YEAR, Integer.parseInt(ano));   
            cal.set(Calendar.MONTH, (Integer.parseInt(mes)-1));   
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));   
            
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
        }
            
        return cal.getTime();
    }
    
    public static String formataScreenData(String d) {
        //2008-05-10T19:42:28.703
        String data="";
            
        if(d.length() >= 16){
            data = d.substring(8,10)+"/"+d.substring(5, 7) + " " + d.substring(11, 13) + ":" + d.substring(14, 16);
        }else if(d.length() == 10){
            data = d.substring(8,10)+"/"+d.substring(5, 7);
        }
        
        return data;
    }
    
    public static String formataData(Date d) {
        return formataData(d, false);
    }

    public static String formataData(Date d, boolean ptBR) {
        String ret = "";
        String ano, mes, dia;

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        ano = Integer.toString(cal.get(Calendar.YEAR));
        mes = Integer.toString((cal.get(Calendar.MONTH)+1));
        dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));

        mes = (mes.length() == 1 ? "0" : "") + mes;
        dia = (dia.length() == 1 ? "0" : "") + dia;

        if(ptBR){
            ret = dia + "/" + mes + "/" + ano;
        }else{
            ret = ano + "/" + mes + "/" + dia;
        }

        return ret;
    }

    public static String formataDataHora(Date d, boolean horaScreen) {
        String ret = formataData(d);   
        String hora, minuto;
           
        Calendar cal = Calendar.getInstance();   
        cal.setTime(d);           
        
        //hora = Integer.toString(cal.get(Calendar.HOUR));
        hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(cal.get(Calendar.MINUTE));   
  
        hora = (hora.length() == 1 ? "0" : "") + hora;
        minuto = (minuto.length() == 1 ? "0" : "") + minuto;
  
        if(horaScreen){
            ret = ret.substring(8, 9) + "/" + ret.substring(5, 6) + " " + hora + ":" + minuto;
        }else{
            ret = ret + " " + hora + ":" + minuto;
        }
           
        return ret;   
    }
    
    public static String formataDataHora(Date d) {   
        return formataDataHora(d, false);
    }
    
    public static java.util.Date adicionaDiaNaData(Date data, long dias) {   
        long dataRecebida = data.getTime();

        if(dias > 0){
            dataRecebida = dataRecebida + (86400000L * dias);
        }else if(dias < 0){
            dataRecebida = dataRecebida - (86400000L * (dias*-1));            
        }

        return new Date(dataRecebida);
    }

    public static String toString(String dateNoSeparator) {
        String ret = "";
        String ano, mes, dia, hora, minuto, segundo;

        ano = dateNoSeparator.substring(0, 4);
        mes = dateNoSeparator.substring(4, 6);
        dia = dateNoSeparator.substring(6, 8);
        hora = dateNoSeparator.substring(8, 10);
        minuto = dateNoSeparator.substring(10, 12);
        segundo = dateNoSeparator.substring(12, 14);

        ret = ano + "/" + mes + "/" + dia;
        ret = ret + " " + hora + ":" + minuto + ":" + segundo;

        return ret;
    }

    public static String toString(Date d) {
        return toString(d, true);
    }

    public static String toString(Date d, boolean usingSeparator) {
        String ret = "";   
        String ano, mes, dia, hora, minuto, segundo;
           
        Calendar cal = Calendar.getInstance();   
        cal.setTime(d);           
           
        ano = Integer.toString(cal.get(Calendar.YEAR));   
        mes = Integer.toString((cal.get(Calendar.MONTH)+1));   
        dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        
        //hora = Integer.toString(cal.get(Calendar.HOUR));
        hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(cal.get(Calendar.MINUTE));
        segundo = Integer.toString(cal.get(Calendar.SECOND));
  
        mes = (mes.length() == 1 ? "0" : "") + mes;   
        dia = (dia.length() == 1 ? "0" : "") + dia;
  
        hora = (hora.length() == 1 ? "0" : "") + hora;   
        minuto = (minuto.length() == 1 ? "0" : "") + minuto;
        segundo = (segundo.length() == 1 ? "0" : "") + segundo;

        if(usingSeparator){
            ret = ano + "/" + mes + "/" + dia;
            ret = ret + " " + hora + ":" + minuto + ":" + segundo;
        }else{
            ret = ano + mes + dia;
            ret = ret + hora + minuto + segundo;
        }
           
        return ret; 
    }
    
    public static int compare(String data1, String data2) throws Exception{
        int ret = -2;
        long ddData1;
        long ddData2;
        
        if(data1.indexOf('/') >= 0){
            data1 = data1.replace('/','-');
        }
        
        if(data2.indexOf('/') >= 0){
            data2 = data2.replace('/','-');
        }
        
        if(data1.equals(data2)){
            ret = 0;
        }else{
            ddData1 = getTime(data1).getTime();
            ddData2 = getTime(data2).getTime();
        
            if(ddData1 < ddData2){
                ret = -1;
            }else if(ddData1 > ddData2){
                ret = 1;
            }
        }
        
        if(ret != -2){
            return ret;
        }else{
            throw new Exception("Bad Date Format");
        }
    }
    
    public static String getMonthDescription(int month){
        switch(month){
            case 1:
                return "Jan";
            case 2:
                return "Fev";
            case 3:
                return "Mar";
            case 4:
                return "Abr";
            case 5:
                return "Mai";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Ago";
            case 9:
                return "Set";
            case 10:
                return "Out";
            case 11:
                return "Nov";
            case 12:
                return "Dez";
            default:
                return "";
        }
    }
    
    public static int getYear(String data){
        String ano, mes, dia;
        
        ano = data.substring(0, 4);   
        mes = data.substring(5, 7);   
        dia = data.substring(8, 10);
        
        return Integer.parseInt(ano);
    }
    
    public static int getMonth(String data){
        String ano, mes, dia;
        
        ano = data.substring(0, 4);   
        mes = data.substring(5, 7);   
        dia = data.substring(8, 10);
        
        return Integer.parseInt(mes);
    }
    
    public static int getDay(String data){
        String ano, mes, dia;
        
        ano = data.substring(0, 4);   
        mes = data.substring(5, 7);   
        dia = data.substring(8, 10);
        
        return Integer.parseInt(dia);
    }

    public static java.util.Date transformaEmDataHoraCompleta(String d) {
        if(d != null && d.length() == 19){
            String ano, mes, dia, hora, minuto, segundo;

            ano = d.substring(0, 4);
            mes = d.substring(5, 7);
            dia = d.substring(8, 10);
            hora = d.substring(11, 13);
            minuto = d.substring(14, 16);
            segundo = d.substring(17, 19);

            Calendar cal = Calendar.getInstance();

            cal.setTime(new Date());

            cal.set(Calendar.YEAR, Integer.parseInt(ano));
            cal.set(Calendar.MONTH, (Integer.parseInt(mes)-1));
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
            //cal.set(Calendar.HOUR, Integer.parseInt(hora));
            cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
            cal.set(Calendar.MINUTE, Integer.parseInt(minuto));
            cal.set(Calendar.SECOND, Integer.parseInt(segundo));

            return cal.getTime();
        }else{
            return null;
        }
    }

    public static String formataDataHoraCompleta(Date d) {
        return formataDataHoraCompleta(d, false);
    }

    public static String formataDataHoraCompleta(Date d, boolean ptBR) {
        String ret = formataData(d, ptBR);
        String hora, minuto, segundo;

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        //hora = Integer.toString(cal.get(Calendar.HOUR));
        hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(cal.get(Calendar.MINUTE));
        segundo = Integer.toString(cal.get(Calendar.SECOND));

        hora = (hora.length() == 1 ? "0" : "") + hora;
        minuto = (minuto.length() == 1 ? "0" : "") + minuto;
        segundo = (segundo.length() == 1 ? "0" : "") + segundo;

        ret = ret + " " + hora + ":" + minuto + ":" + segundo;

        return ret;
    }
}