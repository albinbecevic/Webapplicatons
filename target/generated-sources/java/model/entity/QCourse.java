package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourse is a Querydsl query type for Course
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourse extends EntityPathBase<Course> {

    private static final long serialVersionUID = 542962337L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourse course = new QCourse("course");

    public final ListPath<Announcement, QAnnouncement> announcements = this.<Announcement, QAnnouncement>createList("announcements", Announcement.class, QAnnouncement.class, PathInits.DIRECT2);

    public final ListPath<Assignment, QAssignment> assignments = this.<Assignment, QAssignment>createList("assignments", Assignment.class, QAssignment.class, PathInits.DIRECT2);

    public final StringPath courseID = createString("courseID");

    public final ListPath<CourseModule, QCourseModule> courseModules = this.<CourseModule, QCourseModule>createList("courseModules", CourseModule.class, QCourseModule.class, PathInits.DIRECT2);

    public final StringPath courseName = createString("courseName");

    public final ListPath<Student, QStudent> students = this.<Student, QStudent>createList("students", Student.class, QStudent.class, PathInits.DIRECT2);

    public final QTeacher teacher;

    public QCourse(String variable) {
        this(Course.class, forVariable(variable), INITS);
    }

    public QCourse(Path<? extends Course> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourse(PathMetadata metadata, PathInits inits) {
        this(Course.class, metadata, inits);
    }

    public QCourse(Class<? extends Course> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher")) : null;
    }

}

