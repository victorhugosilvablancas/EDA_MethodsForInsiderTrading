package dcc.datasets;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Hugo Silva Blancas
 * @institution Universidad Autónoma de Querétaro, México
 * @school Facultad de Informática
 * @course Doctorado en Ciencias de la Computación
 * @year 2024
 */
public class Exercisesdata {
    public Integer idexercise;
    public Timestamp exerciseDate;
    public String exerciseDateFn;
    public Integer registros;
    
    public static final String TABLA="HARVARD_EXERCISE";
    public static List<Exercisesdata> listapricepershares=new ArrayList<>();
    
    public Exercisesdata() {
        idexercise=0;
        exerciseDate=new Timestamp(System.currentTimeMillis());
        exerciseDateFn="";
        registros=0;
    }
    public String cadena() {
        return getExerciseDateFn()+"\t"
                + registros
                ;
    }
    public static String Cabeza() {
        return "exerciseDateFn\t"
                + "registros"
                ;
    }
    public static String LatexCabeza() {
        return "\\textbf{idexercise} "
                + "& \\textbf{exerciseDateFn}"
                + "& \\textbf{registros}"
                + "\\\\\n";
    }
    public String latex() {
        return idexercise
                + " & "+getExerciseDateFn()
                + " & "+registros
                + "\\\\\n";
    }
    public String latexpuntos() {
        return "... & ... & ... \\\\\n";
    }
    public String getExerciseDate() {
        return exerciseDate.toString().substring(0, 10);
    }
    public String getExercisaYear() {
        return exerciseDate.toString().substring(0, 4);
    }
    public Integer getPeriodo() {
        return Integer.valueOf(getExercisaYear());
    }
    public String getExerciseDateFn() {
        if (exerciseDateFn!=null) {
            if (exerciseDateFn.equals("null")) return "";
            else return exerciseDateFn.replace("\"", "");
        } else return "";
    }
    
    public String CreaStr() {
        return "insert into "+Exercisesdata.TABLA+" ("
                + "idexercise,"
                + "exerciseDate,"
                + "exerciseDateFn,"
                + "registros "
                + ") values ("
                + ""+idexercise+","
                + "to_timestamp('"+exerciseDate.toString()+"', 'YYYY-MM-DD HH24:MI:SS.FF'),"
                + "'"+exerciseDateFn+"',"
                + ""+registros+" "
                + ")";
    }
    public String GuardaStr() {
        return "update "+Exercisesdata.TABLA+" set "
                + "exerciseDateFn='"+exerciseDateFn+"',"
                + "registros="+registros+" "
                + "where idexercise="+idexercise+" "
                ;
    }
    /*
    public static void AgregaRegistrosValor(Registrosdata rdata) {
        Sharesdata midato=new Sharesdata();
        for (int i=0;i<Sharesdata.listatransactions.size();i++) {
            midato=Sharesdata.listatransactions.get(i);
            if (midato.getTransactionType().equals(rdata.exerciseDate)) {
                midato.exerciseDateFn++;
                midato.valortotal+=rdata.transactionTotalValue;
                Sharesdata.listatransactions.set(i, midato);
            }
        }
    }*/
    
    
}
