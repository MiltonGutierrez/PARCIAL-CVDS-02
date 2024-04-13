package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "SALARY")
    private double salary;

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName +
                ", lastName=" + lastName + ", role=" + role + ", salary =" + salary + "]";
    }

    /**
     * Metodo de creación vacio
     */
    public Employee(){}

    /**
     * Metodo de creacion con cada uno de los atributos.
     * @param employeeId
     * @param firstName
     * @param lastName
     * @param role
     * @param salary
     */
    public Employee(String employeeId, String firstName, String lastName, String role, double salary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLasttName(){
        return lastName;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    // Método para buscar un empleado por su primer o último nombre
    public static Employee findEmployeeByName(String name) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("PU").createEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName = :name OR e.lastName = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
