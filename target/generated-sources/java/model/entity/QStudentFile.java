package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentFile is a Querydsl query type for StudentFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentFile extends EntityPathBase<StudentFile> {

    private static final long serialVersionUID = 1465444241L;

    public static final QStudentFile studentFile = new QStudentFile("studentFile");

    public final SimplePath<java.sql.Clob> content = createSimple("content", java.sql.Clob.class);

    public final NumberPath<Integer> fileID = createNumber("fileID", Integer.class);

    public final StringPath title = createString("title");

    public QStudentFile(String variable) {
        super(StudentFile.class, forVariable(variable));
    }

    public QStudentFile(Path<? extends StudentFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentFile(PathMetadata metadata) {
        super(StudentFile.class, metadata);
    }

}

