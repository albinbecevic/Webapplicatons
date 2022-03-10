package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAssignment is a Querydsl query type for Assignment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAssignment extends EntityPathBase<Assignment> {

    private static final long serialVersionUID = -1773345197L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAssignment assignment = new QAssignment("assignment");

    public final ListPath<AssignmentComment, QAssignmentComment> assignmentComments = this.<AssignmentComment, QAssignmentComment>createList("assignmentComments", AssignmentComment.class, QAssignmentComment.class, PathInits.DIRECT2);

    public final StringPath assignmentID = createString("assignmentID");

    public final QCourse course;

    public final StringPath Description = createString("Description");

    public final QGrading grading;

    public final ListPath<StudentFile, QStudentFile> studentFiles = this.<StudentFile, QStudentFile>createList("studentFiles", StudentFile.class, QStudentFile.class, PathInits.DIRECT2);

    public final ListPath<TeacherFile, QTeacherFile> teacherFiles = this.<TeacherFile, QTeacherFile>createList("teacherFiles", TeacherFile.class, QTeacherFile.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> time_Stamp = createDateTime("time_Stamp", java.util.Date.class);

    public QAssignment(String variable) {
        this(Assignment.class, forVariable(variable), INITS);
    }

    public QAssignment(Path<? extends Assignment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAssignment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAssignment(PathMetadata metadata, PathInits inits) {
        this(Assignment.class, metadata, inits);
    }

    public QAssignment(Class<? extends Assignment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course"), inits.get("course")) : null;
        this.grading = inits.isInitialized("grading") ? new QGrading(forProperty("grading")) : null;
    }

}

