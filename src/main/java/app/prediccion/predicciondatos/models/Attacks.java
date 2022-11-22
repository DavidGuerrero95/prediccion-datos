package app.prediccion.predicciondatos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "data")
@Data
@NoArgsConstructor
public class Attacks {

    @Id
    @JsonIgnore
    private String id;
    private Double stime;
    private String proto;
    private Integer proto_number;
    private String saddr;
    private Integer sport;
    private String daddr;
    private Integer dport;
    private Integer pkts;
    private Integer bytes;
    private String state;
    private Integer state_number;
    private Double ltime;
    private Double dur;
    private Integer spkts;
    private Integer dpkts;
    private Integer sbytes;
    private String dbytes;
    private Integer TnBPSrcIP;
    private Integer TnBPDstIP;
    private Integer TnP_PSrcIP;
    private Integer TnP_PDstIP;
    private Integer TnP_PerProto;
    private Integer TnP_Per_Dport;
    private Double AR_P_Proto_p_SrcIP;
    private Double AR_P_Proto_p_DstIP;
    private Integer N_IN_Conn_P_DstIP;
    private Integer N_IN_Conn_P_SrcIP;
    private Double AR_P_Proto_p_Sport;
    private Double AR_P_Proto_p_Dport;
    private Integer tag;
    private String attack_tool;
    private String attack_param;
    private Integer prediction_dt;
    private Double time_prediction_dt;
    private Integer prediction_lr;
    private Double time_prediction_lr;
    private Integer prediction_rf;
    private Double time_prediction_rf;
    private Integer prediction_svm_linear;
    private Double time_prediction_svm_linear;
}
