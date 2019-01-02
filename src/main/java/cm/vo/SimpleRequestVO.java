package cm.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: Yunfeng Huang
 * @Description:
 * @Date: Created in 2018/12/21
 */
@Data
public class SimpleRequestVO {

    private Long requestId;
    private String leaderName;
    private String reason;
    private String courseName;
    private String subCourseName;
    private String subCourseTeacherName;

    @JsonProperty("className")
    private String klassName;

    private Byte status;//null 未处理 0 不同意 1 同意

    public void setKlassName(Integer grade, Byte klassSerial) {
        this.klassName = String.valueOf(grade)+"(" +String.valueOf(klassSerial)+")";
    }
}
