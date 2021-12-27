package br.com.besistemagif.domains.clients;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.besistemagif.infrastructure.database.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "clients")
public class ClientsEntity extends BaseEntity {

    @Getter @Setter private String name;

    @Getter @Setter private String birthDate;
    
    @Getter @Setter private String genre;

    @Getter @Setter private String email;
}
