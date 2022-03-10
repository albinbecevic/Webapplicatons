package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourseModule is a Querydsl query type for CourseModule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseModule extends EntityPathBase<CourseModule> {

    private static final long serialVersionUID = -572831635L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourseModule courseModule = new QCourseModule("courseModule");

    public final QCourse course;

    public final StringPath exercises = createString("exercises");

    public final StringPath lectureDescp = createString("lectureDescp");

    public final StringPath moduleID = createString("moduleID");

    public final ListPath<TeacherFile, QTeacherFile> teacherFiles = this.<TeacherFile, QTeacherFile>createList("teacherFiles", TeacherFile.class, QTeacherFile.class, PathInits.DIRECT2);

    public final StringPath topic = createString("topic");

    public final StringPath week = createString("week");

    public QCourseModule(String variable) {
        this(CourseModule.class, forVariable(variable), INITS);
    }

    public QCourseModule(Path<? extends CourseModule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourseModule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourseModule(PathMetadata metadata, PathInits inits) {
        this(CourseModule.class, metadata, inits);
    }

    public QCourseModule(Class<? extends CourseModule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course"), inits.get("course")) : null;
    }

}

