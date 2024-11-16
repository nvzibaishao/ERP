package learn.ERP.HRM.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工岗位变更历史表
 * </p>
 *
 * @author huqian
 * @since 2024-11-11
 */
@Getter
@Setter
@Accessors(chain = true)
public class Employeepositionhistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 历史记录ID
     */
    @TableId(value = "HistoryID", type = IdType.AUTO)
    private Integer HistoryID;

    /**
     * 员工ID（外键，关联Employee表）
     */
    private Integer EmployeeID;

    /**
     * 旧岗位
     */
    private String OldPosition;

    /**
     * 旧部门
     */
    private String OldDepartment;

    /**
     * 新岗位
     */
    private String NewPosition;

    /**
     * 新部门
     */
    private String NewDepartment;

    /**
     * 变更日期
     */
    private LocalDate ChangeDate;

    /**
     * 变更原因
     */
    private String ChangeReason;

    /**
     * 操作人
     */
    private String ModifiedBy;


}
