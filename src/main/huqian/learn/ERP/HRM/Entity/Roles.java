package learn.ERP.HRM.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author huqian
 * @since 2024-11-12
 */
@Getter
@Setter
@Accessors(chain = true)
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer role_id;

    private String role_name;

    private String description;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;


}
