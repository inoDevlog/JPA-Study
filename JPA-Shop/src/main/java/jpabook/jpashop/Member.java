/*
 * Copyright (c) 2021, ino, Inc. All rights reserved.
 */

package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Choi, Inho <inho.choi@softwareinlife.com>
 * @since 2021/07/10
 */
@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
}
