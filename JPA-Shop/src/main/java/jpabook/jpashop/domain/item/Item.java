/*
 * Copyright (c) 2021, ino, Inc. All rights reserved.
 */

package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Categoty;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>클래스 제목(작업목적)</b>
 * <p>
 * 작업내용
 * </p>
 *
 * @author Choi, Inho <inho.choi@softwareinlife.com>
 * @since 2021/07/16
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Categoty> categories = new ArrayList<>();

    //==비즈니스 로직==//
    /**
     * stock 증가
     * @param quantity
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     * @param quantity
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }


}
