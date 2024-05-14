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
public class Sharesdata {
    public Integer idshare;
    public Timestamp transactionDate;
    public Integer transactionShares;
    
    public static final String TABLA="HARVARD_SHARES";
    public static List<Sharesdata> listashares=new ArrayList<>();
    
    public Sharesdata() {
        idshare=0;
        transactionDate=new Timestamp(System.currentTimeMillis());
        transactionShares=0;
    }
    public String cadena() {
        return idshare+"\t"
                + getTransactionYear()+"\t"
                + transactionShares
                ;
    }
    public static String Cabeza() {
        return "idshare\t"
                + "transactionDate\t"
                + "transactionShares"
                ;
    }
    public static String LatexCabeza() {
        return "\\textbf{idshare} "
                + "& \\textbf{transactionDate}"
                + "& \\textbf{transactionShares}"
                + "\\\\\n";
    }
    public String latex() {
        return idshare
                + " & "+getTransactionYear()
                + " & "+transactionShares
                + "\\\\\n";
    }
    public String getTransactionDate() {
        return transactionDate.toString().substring(0, 10);
    }
    public String getTransactionYear() {
        return transactionDate.toString().substring(0, 4);
    }
    public Integer getPeriodo() {
        return Integer.valueOf(getTransactionYear());
    }
    
    public String CreaStr() {
        return "insert into "+Sharesdata.TABLA+" ("
                + "idshare,"
                + "transactionDate,"
                + "transactionShares "
                + ") values ("
                + ""+idshare+","
                + "to_timestamp('"+transactionDate.toString()+"', 'YYYY-MM-DD HH24:MI:SS.FF'),"
                + ""+transactionShares+" "
                + ")";
    }
    public String GuardaStr() {
        return "update "+Sharesdata.TABLA+" set "
                + "transactionShares="+transactionShares+" "
                + "where idshare="+idshare+" "
                ;
    }
    
}
