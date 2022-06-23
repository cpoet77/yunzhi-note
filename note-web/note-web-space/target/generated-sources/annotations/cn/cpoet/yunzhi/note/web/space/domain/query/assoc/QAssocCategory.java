package cn.cpoet.yunzhi.note.web.space.domain.query.assoc;

import cn.cpoet.yunzhi.note.web.space.domain.Category;
import cn.cpoet.yunzhi.note.web.space.domain.query.QCategory;
import io.ebean.Transaction;
import io.ebean.typequery.Generated;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PLocalDateTime;
import io.ebean.typequery.PLong;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;

/**
 * Association query bean for AssocCategory.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QAssocCategory<R> extends TQAssocBean<Category,R> {

  public PLong<R> id;
  public PInteger<R> version;
  public PBoolean<R> deleted;
  public PLong<R> createdMember;
  public PLocalDateTime<R> createdTime;
  public PLong<R> updatedMember;
  public PLocalDateTime<R> updatedTime;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetch(TQProperty<QCategory>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetchQuery(TQProperty<QCategory>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Eagerly fetch this association using L2 cache.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetchCache(TQProperty<QCategory>... properties) {
    return fetchCacheProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetchLazy(TQProperty<QCategory>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocCategory(String name, R root) {
    super(name, root);
  }

  public QAssocCategory(String name, R root, String prefix) {
    super(name, root, prefix);
  }
}
