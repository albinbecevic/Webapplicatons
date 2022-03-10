package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAssignmentComment is a Querydsl query type for AssignmentComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAssignmentComment extends EntityPathBase<AssignmentComment> {

    private static final long serialVersionUID = -1805357940L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAssignmentComment assignmentComment = new QAssignmentComment("assignmentComment");

    public final NumberPath<Integer> assignmentID = createNumber("assignmentID", Integer.class);

    public final StringPath content = createString("content");

    public final QStudent student;

    public final QTeacher teacher;

    public final DateTimePath<java.util.Date> time_Stamp = createDateTime("time_Stamp", java.util.Date.class);

    public QAssignmentComment(String variable) {
        this(AssignmentComment.class, forVariable(variable), INITS);
    }

    public QAssignmentComment(Path<? extends AssignmentComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAssignmentComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAssignmentComment(PathMetadata metadata, PathInits inits) {
        this(AssignmentComment.class, metadata, inits);
    }

    public QAssignmentComment(Class<? extends AssignmentComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher")) : null;
    }

}

