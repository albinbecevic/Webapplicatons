package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrading is a Querydsl query type for Grading
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGrading extends EntityPathBase<Grading> {

    private static final long serialVersionUID = -1025998578L;

    public static final QGrading grading = new QGrading("grading");

    public final BooleanPath accepted = createBoolean("accepted");

    public final StringPath comment = createString("comment");

    public final ListPath<GradingComment, QGradingComment> gradingComments = this.<GradingComment, QGradingComment>createList("gradingComments", GradingComment.class, QGradingComment.class, PathInits.DIRECT2);

    public final NumberPath<Integer> gradingID = createNumber("gradingID", Integer.class);

    public final DateTimePath<java.util.Date> time_Stamp = createDateTime("time_Stamp", java.util.Date.class);

    public QGrading(String variable) {
        super(Grading.class, forVariable(variable));
    }

    public QGrading(Path<? extends Grading> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGrading(PathMetadata metadata) {
        super(Grading.class, metadata);
    }

}

