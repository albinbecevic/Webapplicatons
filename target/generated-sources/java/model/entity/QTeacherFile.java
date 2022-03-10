package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeacherFile is a Querydsl query type for TeacherFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeacherFile extends EntityPathBase<TeacherFile> {

    private static final long serialVersionUID = 770770360L;

    public static final QTeacherFile teacherFile = new QTeacherFile("teacherFile");

    public final StringPath content = createString("content");

    public final NumberPath<Integer> courseID = createNumber("courseID", Integer.class);

    public final ListPath<CourseModule, QCourseModule> courseModules = this.<CourseModule, QCourseModule>createList("courseModules", CourseModule.class, QCourseModule.class, PathInits.DIRECT2);

    public final NumberPath<Integer> fileID = createNumber("fileID", Integer.class);

    public final StringPath title = createString("title");

    public QTeacherFile(String variable) {
        super(TeacherFile.class, forVariable(variable));
    }

    public QTeacherFile(Path<? extends TeacherFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeacherFile(PathMetadata metadata) {
        super(TeacherFile.class, metadata);
    }

}

