package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGradingComment is a Querydsl query type for GradingComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGradingComment extends EntityPathBase<GradingComment> {

    private static final long serialVersionUID = -1678550671L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGradingComment gradingComment = new QGradingComment("gradingComment");

    public final NumberPath<Integer> commentID = createNumber("commentID", Integer.class);

    public final StringPath content = createString("content");

    public final QGrading grading;

    public final QStudent student;

    public final QTeacher teacher;

    public final DateTimePath<java.util.Date> time_Stamp = createDateTime("time_Stamp", java.util.Date.class);

    public QGradingComment(String variable) {
        this(GradingComment.class, forVariable(variable), INITS);
    }

    public QGradingComment(Path<? extends GradingComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGradingComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGradingComment(PathMetadata metadata, PathInits inits) {
        this(GradingComment.class, metadata, inits);
    }

    public QGradingComment(Class<? extends GradingComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.grading = inits.isInitialized("grading") ? new QGrading(forProperty("grading")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher")) : null;
    }

}

