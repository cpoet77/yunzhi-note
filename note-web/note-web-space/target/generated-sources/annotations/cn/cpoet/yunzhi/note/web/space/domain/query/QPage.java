package cn.cpoet.yunzhi.note.web.space.domain.query;

import cn.cpoet.yunzhi.note.web.space.domain.Page;
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
 * Query bean for Page.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QPage extends TQRootBean<Page,QPage> {

  private static final QPage _alias = new QPage(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QPage alias() {
    return _alias;
  }

  public PLong<QPage> id;
  public PInteger<QPage> version;
  public PBoolean<QPage> deleted;
  public PLong<QPage> createdMember;
  public PLocalDateTime<QPage> createdTime;
  public PLong<QPage> updatedMember;
  public PLocalDateTime<QPage> updatedTime;


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
  public static QPage forFetchGroup() {
    return new QPage(FetchGroup.queryFor(Page.class));
  }

  /**
   * Construct using the default Database.
   */
  public QPage() {
    super(Page.class);
  }

  /**
   * Construct with a given transaction.
   */
  public QPage(Transaction transaction) {
    super(Page.class, transaction);
  }

  /**
   * Construct with a given Database.
   */
  public QPage(Database database) {
    super(Page.class, database);
  }


  /**
   * Construct for Alias.
   */
  private QPage(boolean dummy) {
    super(dummy);
  }

  /**
   * Private constructor for FetchGroup building.
   */
  private QPage(Query<Page> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PLong<QPage> id = _alias.id;
    public static PInteger<QPage> version = _alias.version;
    public static PBoolean<QPage> deleted = _alias.deleted;
    public static PLong<QPage> createdMember = _alias.createdMember;
    public static PLocalDateTime<QPage> createdTime = _alias.createdTime;
    public static PLong<QPage> updatedMember = _alias.updatedMember;
    public static PLocalDateTime<QPage> updatedTime = _alias.updatedTime;
  }
}
