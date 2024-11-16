package learn.ERP.HRM.Entity;

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
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resource_id;

    private String resource_name;

    private String resource_type;

    private String parent_id;

    private String description;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;


}
