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
public class PricePerSharesdata {
    public Integer idpricepershare;
    public Double transactionPricePerShare;
    public Double transactionPricePerShareMin;
    public Double transactionPricePerShareMax;
    public String transactionAcquiredDisposedCode;
    
    public static final String TABLA="HARVARD_PRICEPERSHARE";
    public static List<PricePerSharesdata> listapricepershares=new ArrayList<>();
    
    public PricePerSharesdata() {
        idpricepershare=0;
        transactionPricePerShare=0.0;
        transactionPricePerShareMin=0.0;
        transactionPricePerShareMax=0.0;
        transactionAcquiredDisposedCode="";
    }
    public String cadena() {
        return idpricepershare+"\t"
                + getTransactionPricePerShare()+"\t"
                + getTransactionPricePerShareMin()+"\t"
                + getTransactionPricePerShareMax()+"\t"
                + getTransactionAcquiredDisposedCode()
                ;
    }
    public static String Cabeza() {
        return "idpricepershare\t"
                + "transactionPricePerShare\t"
                + "transactionPricePerShareMin\t"
                + "transactionPricePerShareMax\t"
                + "transactionAcquiredDisposedCode"
                ;
    }
    public static String LatexCabeza() {
        return "\\textbf{Ac.Disp.Code}"
                + "& \\textbf{PricePerShare}"
                + "& \\textbf{Min}"
                + "& \\textbf{Max}"
                + "\\\\\n";
    }
    public String latex() {
        return getTransactionAcquiredDisposedCode()
                + " & "+getTransactionPricePerShare()
                + " & "+getTransactionPricePerShareMin()
                + " & "+getTransactionPricePerShareMax()
                + "\\\\\n";
    }
    public String getTransactionPricePerShare() {
        return String.format("%,.2f", transactionPricePerShare);
    }
    public String getTransactionPricePerShareMin() {
        return String.format("%,.2f", transactionPricePerShareMin);
    }
    public String getTransactionPricePerShareMax() {
        return String.format("%,.2f", transactionPricePerShareMax);
    }
    public String getTransactionAcquiredDisposedCode() {
        if (transactionAcquiredDisposedCode!=null) {
            if (transactionAcquiredDisposedCode.equals("null")) return "";
            else return transactionAcquiredDisposedCode;
        } else return "";
    }
    
    public String CreaStr() {
        return "insert into "+PricePerSharesdata.TABLA+" ("
                + "idpricepershare,"
                + "transactionPricePerShare,"
                + "transactionPricePerShareMin,"
                + "transactionPricePerShareMax,"
                + "transacAcquiredDisposedCode "
                + ") values ("
                + ""+idpricepershare+","
                + ""+transactionPricePerShare+","
                + ""+transactionPricePerShareMin+","
                + ""+transactionPricePerShareMax+","
                + "'"+transactionAcquiredDisposedCode+"' "
                + ")";
    }
    public String GuardaStr() {
        return "update "+PricePerSharesdata.TABLA+" set "
                + "transactionPricePerShare="+transactionPricePerShare+","
                + "transactionPricePerShareMin="+transactionPricePerShareMin+","
                + "transactionPricePerShareMax="+transactionPricePerShareMax+","
                + "transacAcquiredDisposedCode='"+transactionAcquiredDisposedCode+"' "
                + "where idpricepershare="+idpricepershare+" "
                ;
    }
    
}
