package cm.vo;

import cm.entity.TeamOrStrategy;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Yunfeng Huang
 * @Description:
 * @Date: Created in 2018/12/30
 */
@Data
public class TeamNeedVO {
    private CourseMemberLimitStrategyVO teamMemberLimitStrategy;
    private List<CourseMemberLimitStrategyVO> CourseMemberLimitStrategyList;
    private List<ConflictCourseStrategyVO> ConflictCourseStrategyList;
}
