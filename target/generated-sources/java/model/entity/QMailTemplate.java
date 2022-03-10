package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMailTemplate is a Querydsl query type for MailTemplate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMailTemplate extends EntityPathBase<MailTemplate> {

    private static final long serialVersionUID = -1146739369L;

    public static final QMailTemplate mailTemplate = new QMailTemplate("mailTemplate");

    public final StringPath body = createString("body");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath subject = createString("subject");

    public QMailTemplate(String variable) {
        super(MailTemplate.class, forVariable(variable));
    }

    public QMailTemplate(Path<? extends MailTemplate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMailTemplate(PathMetadata metadata) {
        super(MailTemplate.class, metadata);
    }

}

