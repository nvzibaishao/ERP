package learn.javalearnproject.Entity;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author huqian
 * @since 2024-10-18
 */
@Getter
@Setter
@Accessors(chain = true)
@Data
public class Password implements Serializable {

    private static final long serialVersionUID = 1L;

    private String passwordName;

    private String password;

    private String account;

    /**
     * 端口
     */
    private String port;

}
