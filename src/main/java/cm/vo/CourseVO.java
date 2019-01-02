package cm.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Yunfeng Huang
 * @Description:
 * @Date: Created in 2018/12/21
 */
@Data
public class CourseVO {

    private Long id;
    private String name;
    /*
    0 主课程 1 从课程
     */
    private Boolean isShareTeam;
    /*
   0 主课程 1 从课程
    */
    private Boolean isShareSeminar;

    List<RoundVO> roundVOList;

}
