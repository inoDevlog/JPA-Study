package jpabook.jpashop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoty is a Querydsl query type for Categoty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoty extends EntityPathBase<Categoty> {

    private static final long serialVersionUID = 843258367L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoty categoty = new QCategoty("categoty");

    public final ListPath<Categoty, QCategoty> child = this.<Categoty, QCategoty>createList("child", Categoty.class, QCategoty.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<jpabook.jpashop.domain.item.Item, jpabook.jpashop.domain.item.QItem> items = this.<jpabook.jpashop.domain.item.Item, jpabook.jpashop.domain.item.QItem>createList("items", jpabook.jpashop.domain.item.Item.class, jpabook.jpashop.domain.item.QItem.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QCategoty parent;

    public QCategoty(String variable) {
        this(Categoty.class, forVariable(variable), INITS);
    }

    public QCategoty(Path<? extends Categoty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategoty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategoty(PathMetadata metadata, PathInits inits) {
        this(Categoty.class, metadata, inits);
    }

    public QCategoty(Class<? extends Categoty> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QCategoty(forProperty("parent"), inits.get("parent")) : null;
    }

}

