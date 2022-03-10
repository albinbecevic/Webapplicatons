package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnnouncementComment is a Querydsl query type for AnnouncementComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnnouncementComment extends EntityPathBase<AnnouncementComment> {

    private static final long serialVersionUID = -454835630L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnnouncementComment announcementComment = new QAnnouncementComment("announcementComment");

    public final NumberPath<Integer> AnnouncementCommentID = createNumber("AnnouncementCommentID", Integer.class);

    public final StringPath content = createString("content");

    public final QStudent student;

    public final QTeacher teacher;

    public final DateTimePath<java.util.Date> time_Stamp = createDateTime("time_Stamp", java.util.Date.class);

    public QAnnouncementComment(String variable) {
        this(AnnouncementComment.class, forVariable(variable), INITS);
    }

    public QAnnouncementComment(Path<? extends AnnouncementComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnnouncementComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnnouncementComment(PathMetadata metadata, PathInits inits) {
        this(AnnouncementComment.class, metadata, inits);
    }

    public QAnnouncementComment(Class<? extends AnnouncementComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher")) : null;
    }

}

