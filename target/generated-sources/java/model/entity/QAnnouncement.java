package model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnnouncement is a Querydsl query type for Announcement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnnouncement extends EntityPathBase<Announcement> {

    private static final long serialVersionUID = -1616911539L;

    public static final QAnnouncement announcement = new QAnnouncement("announcement");

    public final ListPath<AnnouncementComment, QAnnouncementComment> announcementComments = this.<AnnouncementComment, QAnnouncementComment>createList("announcementComments", AnnouncementComment.class, QAnnouncementComment.class, PathInits.DIRECT2);

    public final NumberPath<Integer> announcementID = createNumber("announcementID", Integer.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> time_Stamp = createDateTime("time_Stamp", java.util.Date.class);

    public QAnnouncement(String variable) {
        super(Announcement.class, forVariable(variable));
    }

    public QAnnouncement(Path<? extends Announcement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnnouncement(PathMetadata metadata) {
        super(Announcement.class, metadata);
    }

}

