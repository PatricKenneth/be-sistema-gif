package br.com.besistemagif.domains.clients;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.besistemagif.infrastructure.database.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "clients")
@Getter
@Setter
public class ClientsEntity extends BaseEntity {

    private String name;

    private String birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
}
