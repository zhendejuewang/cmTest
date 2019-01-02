package cm.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Yunfeng Huang
 * @Description:
 * @Date: Created in 2018/12/21
 */
@Data
public class SimpleSeminarScoreVO {
    /**
     * seminar
     */
    private Long seminarId;

    private String seminarName;

    @JsonProperty("seminarOrder")
    private Byte seminarSerial;

    private String introduction;

    private BigDecimal totalScore;

    private BigDecimal presentationScore;

    private BigDecimal questionScore;

    private BigDecimal reportScore;

    private TeamVO teamVO;
}
