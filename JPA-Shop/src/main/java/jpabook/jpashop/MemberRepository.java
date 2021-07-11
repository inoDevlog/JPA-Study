/*
 * Copyright (c) 2021, ino, Inc. All rights reserved.
 */

package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <b>클래스 제목(작업목적)</b>
 * <p>
 * 작업내용
 * </p>
 *
 * @author Choi, Inho <inho.choi@softwareinlife.com>
 * @since 2021/07/10
 */
@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
