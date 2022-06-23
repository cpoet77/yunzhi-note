package cn.cpoet.yunzhi.note.web.space.domain.query;

import cn.cpoet.yunzhi.note.web.space.domain.Comment;
import io.ebean.Database;
import io.ebean.FetchGroup;
import io.ebean.Query;
import io.ebean.Transaction;
import io.ebean.typequery.Generated;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PLocalDateTime;
import io.ebean.typequery.PLong;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;

/**
 * Query bean for Comment.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QComment extends TQRootBean<Comment,QComment> {

  private static final QComment _alias = new QComment(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QComment alias() {
    return _alias;
  }

  public PLong<QComment> id;
  public PInteger<QComment> version;
  public PBoolean<QComment> deleted;
  public PLong<QComment> createdMember;
  public PLocalDateTime<QComment> createdTime;
  public PLong<QComment> updatedMember;
  public PLocalDateTime<QComment> updatedTime;


  /**
   * Return a query bean used to build a FetchGroup.
   * <p>
   * FetchGroups are immutable and threadsafe and can be used by many
   * concurrent queries. We typically stored FetchGroup as a static final field.
   * <p>
   * Example creating and using a FetchGroup.
   * <pre>{@code
   * 
   * static final FetchGroup<Customer> fetchGroup = 
   *   QCustomer.forFetchGroup()
   *     .shippingAddress.fetch()
   *     .contacts.fetch()
   *     .buildFetchGroup();
   * 
   * List<Customer> customers = new QCustomer()
   *   .select(fetchGroup)
   *   .findList();
   * 
   * }</pre>
   */
  public static QComment forFetchGroup() {
    return new QComment(FetchGroup.queryFor(Comment.class));
  }

  /**
   * Construct using the default Database.
   */
  public QComment() {
    super(Comment.class);
  }

  /**
   * Construct with a given transaction.
   */
  public QComment(Transaction transaction) {
    super(Comment.class, transaction);
  }

  /**
   * Construct with a given Database.
   */
  public QComment(Database database) {
    super(Comment.class, database);
  }


  /**
   * Construct for Alias.
   */
  private QComment(boolean dummy) {
    super(dummy);
  }

  /**
   * Private constructor for FetchGroup building.
   */
  private QComment(Query<Comment> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PLong<QComment> id = _alias.id;
    public static PInteger<QComment> version = _alias.version;
    public static PBoolean<QComment> deleted = _alias.deleted;
    public static PLong<QComment> createdMember = _alias.createdMember;
    public static PLocalDateTime<QComment> createdTime = _alias.createdTime;
    public static PLong<QComment> updatedMember = _alias.updatedMember;
    public static PLocalDateTime<QComment> updatedTime = _alias.updatedTime;
  }
}
