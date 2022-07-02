/*
Copyright 2022 José Luis De la Cruz Morales joseluis.delacruz@gmail.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.jos.dem.vetlog.model;

import com.jos.dem.vetlog.enums.RegistrationCodeStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class RegistrationCode {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date dateCreated = new Date();
    @Column(nullable = false)
    private String token = UUID.randomUUID().toString();
    @Column(nullable = false)
    private RegistrationCodeStatus status = RegistrationCodeStatus.VALID;

    private Boolean isValid() {
        return status == RegistrationCodeStatus.VALID ? true : false;
    }
}
