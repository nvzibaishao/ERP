package learn.ERP.HRM.Entity.DTO;

import lombok.Data;

@Data
public class  ResultMsg{
    public String info;
    public Object Data;

    public  int status;

    public ResultMsg() {
    }

    public ResultMsg(String info, Object data, int status) {
        this.info = info;
        Data = data;
        this.status = status;
    }
}