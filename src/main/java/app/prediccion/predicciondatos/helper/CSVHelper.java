package app.prediccion.predicciondatos.helper;

import app.prediccion.predicciondatos.models.Attacks;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream attacksToCSV(List<Attacks> attacksList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream(); CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
            for (Attacks attacks : attacksList) {
                List<String> data = Arrays.asList(attacks.getId(), String.valueOf(attacks.getStime()), attacks.getProto(), String.valueOf(attacks.getProto_number()), attacks.getSaddr(), String.valueOf(attacks.getSport()), attacks.getDaddr(), String.valueOf(attacks.getDport()), String.valueOf(attacks.getPkts()), String.valueOf(attacks.getBytes()), attacks.getState(), String.valueOf(attacks.getState_number()), String.valueOf(attacks.getLtime()), String.valueOf(attacks.getDur()), String.valueOf(attacks.getSpkts()), String.valueOf(attacks.getDpkts()), String.valueOf(attacks.getSbytes()), attacks.getDbytes(), String.valueOf(attacks.getTnBPSrcIP()), String.valueOf(attacks.getTnBPDstIP()), String.valueOf(attacks.getTnP_PSrcIP()), String.valueOf(attacks.getTnP_PDstIP()), String.valueOf(attacks.getTnP_PerProto()), String.valueOf(attacks.getTnP_Per_Dport()), String.valueOf(attacks.getAR_P_Proto_p_SrcIP()), String.valueOf(attacks.getAR_P_Proto_p_DstIP()), String.valueOf(attacks.getN_IN_Conn_P_DstIP()), String.valueOf(attacks.getN_IN_Conn_P_SrcIP()), String.valueOf(attacks.getAR_P_Proto_p_Sport()), String.valueOf(attacks.getAR_P_Proto_p_Dport()), String.valueOf(attacks.getTag()), attacks.getAttack_tool(), attacks.getAttack_param(), String.valueOf(attacks.getPrediction_dt()), String.valueOf(attacks.getTime_prediction_dt()), String.valueOf(attacks.getPrediction_lr()), String.valueOf(attacks.getTime_prediction_lr()), String.valueOf(attacks.getPrediction_rf()), String.valueOf(attacks.getTime_prediction_rf()), String.valueOf(attacks.getPrediction_svm_linear()), String.valueOf(attacks.getTime_prediction_svm_linear()));
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Fail to import data to CSV file: " + e.getMessage());
        }
    }

}
