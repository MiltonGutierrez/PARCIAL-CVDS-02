package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private Category role;

    @Column(name = "RATING", columnDefinition = "TINYINT(1)")
    private Short rating;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    /*@Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName +
                ", lastName=" + lastName + ", role=" + role + ", salary =" + salary + "]";
    }*/

    /**
     * Metodo de creación vacio
     */
    public Product(){}

    public Product(Integer id, String name, String description, Category role, Integer price, Integer quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.role = role;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setRole(Category role){
        this.role = role;
    }

    public Category getRole(){
        return role;
    }

    public void setRating(Short rating){
        this.rating = rating;
    }

    public Short getRating(){
        return rating;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

    public Integer getPrice(){
        return price;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public Integer getQuantity(){
        return quantity;
    }
}
