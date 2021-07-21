/*
 * Copyright (c) 2021, ino, Inc. All rights reserved.
 */

package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * <b>클래스 제목(작업목적)</b>
 * <p>
 * 작업내용
 * </p>
 *
 * @author Choi, Inho <inho.choi@softwareinlife.com>
 * @since 2021/07/16
 */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected  Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
