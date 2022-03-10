package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeacher is a Querydsl query type for Teacher
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeacher extends EntityPathBase<Teacher> {

    private static final long serialVersionUID = 1549404700L;

    public static final QTeacher teacher = new QTeacher("teacher");

    public final ListPath<AnnouncementComment, QAnnouncementComment> announcementComments = this.<AnnouncementComment, QAnnouncementComment>createList("announcementComments", AnnouncementComment.class, QAnnouncementComment.class, PathInits.DIRECT2);

    public final ListPath<AssignmentComment, QAssignmentComment> assignmentComments = this.<AssignmentComment, QAssignmentComment>createList("assignmentComments", AssignmentComment.class, QAssignmentComment.class, PathInits.DIRECT2);

    public final ListPath<Assignment, QAssignment> assignments = this.<Assignment, QAssignment>createList("assignments", Assignment.class, QAssignment.class, PathInits.DIRECT2);

    public final ListPath<Course, QCourse> courses = this.<Course, QCourse>createList("courses", Course.class, QCourse.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final ListPath<GradingComment, QGradingComment> gradingComments = this.<GradingComment, QGradingComment>createList("gradingComments", GradingComment.class, QGradingComment.class, PathInits.DIRECT2);

    public final ListPath<Grading, QGrading> gradings = this.<Grading, QGrading>createList("gradings", Grading.class, QGrading.class, PathInits.DIRECT2);

    public final StringPath lastName = createString("lastName");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath teacherID = createString("teacherID");

    public final StringPath userType = createString("userType");

    public QTeacher(String variable) {
        super(Teacher.class, forVariable(variable));
    }

    public QTeacher(Path<? extends Teacher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeacher(PathMetadata metadata) {
        super(Teacher.class, metadata);
    }

}

