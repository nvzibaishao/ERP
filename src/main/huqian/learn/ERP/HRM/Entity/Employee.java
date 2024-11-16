package learn.ERP.HRM.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
 * @since 2024-11-10
 */
@Data
public class Employee {

    private Integer EmployeeID;

    private String Name;

    private String Gender;

    private LocalDate BirthDate;

    private String Phone;

    private LocalDate HireDate;

    private String Position;

    private String Department;

    private LocalDate ContractStart;

    private LocalDate ContractEnd;

    private String ContractType;

    private String LastModifiedBy;

    private LocalDateTime LastModifiedDate;

    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public LocalDate getHireDate() {
        return HireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        HireDate = hireDate;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public LocalDate getContractStart() {
        return ContractStart;
    }

    public void setContractStart(LocalDate contractStart) {
        ContractStart = contractStart;
    }

    public LocalDate getContractEnd() {
        return ContractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        ContractEnd = contractEnd;
    }

    public String getContractType() {
        return ContractType;
    }

    public void setContractType(String contractType) {
        ContractType = contractType;
    }

    public String getLastModifiedBy() {
        return LastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        LastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }
}
