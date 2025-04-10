package com.app.axibank.model.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String email;

    private String password;

    private String telephone;


    public enum CustomerType {
        USER("ROLE_USER"),
        ADMIN("ROLE_ADMIN");

        private final String role;

        CustomerType(String role) {
            this.role = role;
        }

        public String getRole() {
            return this.role;
        }
    }

    private CustomerType customerType = CustomerType.USER;
}
