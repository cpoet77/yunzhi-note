package cn.cpoet.yunzhi.note.web.space.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import io.ebean.typequery.Generated;

import io.ebean.config.ModuleInfo;
import io.ebean.config.ModuleInfoLoader;

@Generated("io.ebean.querybean.generator")
@ModuleInfo(entities={"cn.cpoet.yunzhi.note.web.space.domain.Article","cn.cpoet.yunzhi.note.web.space.domain.Category","cn.cpoet.yunzhi.note.web.space.domain.Comment","cn.cpoet.yunzhi.note.web.space.domain.Page"})
public class _Ebean$ModuleInfo implements ModuleInfoLoader {

  /**
   * Register AttributeConverter etc
   */
  private List<Class<?>> otherClasses() {
    return Collections.emptyList();
  }

  /**
   * Entities with no @DbName
   */
  private List<Class<?>> defaultEntityClasses() {
    List<Class<?>> entities = new ArrayList<>();
    entities.add(cn.cpoet.yunzhi.note.web.space.domain.Article.class);
    entities.add(cn.cpoet.yunzhi.note.web.space.domain.Category.class);
    entities.add(cn.cpoet.yunzhi.note.web.space.domain.Comment.class);
    entities.add(cn.cpoet.yunzhi.note.web.space.domain.Page.class);
    return entities;
  }

  private List<Class<?>> classesFor(String dbName) {
    return new ArrayList<>();
  }

  @Override
  public List<Class<?>> classesFor(String dbName, boolean defaultServer) {
    List<Class<?>> classes = classesFor(dbName);
    if (defaultServer) {
      classes.addAll(defaultEntityClasses());
    }
    return classes;
  }

}
