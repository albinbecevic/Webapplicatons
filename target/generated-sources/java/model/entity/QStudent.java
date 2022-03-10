package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1109835893L;

    public static final QStudent student = new QStudent("student");

    public final ListPath<AnnouncementComment, QAnnouncementComment> announcementComments = this.<AnnouncementComment, QAnnouncementComment>createList("announcementComments", AnnouncementComment.class, QAnnouncementComment.class, PathInits.DIRECT2);

    public final ListPath<AssignmentComment, QAssignmentComment> assignmentComments = this.<AssignmentComment, QAssignmentComment>createList("assignmentComments", AssignmentComment.class, QAssignmentComment.class, PathInits.DIRECT2);

    public final ListPath<Assignment, QAssignment> assignments = this.<Assignment, QAssignment>createList("assignments", Assignment.class, QAssignment.class, PathInits.DIRECT2);

    public final ListPath<Course, QCourse> courses = this.<Course, QCourse>createList("courses", Course.class, QCourse.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final ListPath<GradingComment, QGradingComment> gradingComments = this.<GradingComment, QGradingComment>createList("gradingComments", GradingComment.class, QGradingComment.class, PathInits.DIRECT2);

    public final StringPath lastName = createString("lastName");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath studentID = createString("studentID");

    public final StringPath userType = createString("userType");

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

