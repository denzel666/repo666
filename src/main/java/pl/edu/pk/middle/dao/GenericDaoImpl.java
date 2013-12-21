package pl.edu.pk.middle.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericDaoImpl<E extends Serializable, R extends Serializable> extends HibernateDaoSupport
		implements GenericDao<E, R> {
	
	private final static Logger logger = Logger.getLogger(GenericDaoImpl.class);
	
	private Class<E> type;

	public void flush(){
		getHibernateTemplate().flush();
	}
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public R save(E object) {
		return (R) getHibernateTemplate().save(object);
	}

	public E get(R id) {
		return getHibernateTemplate().get(type, id);
	}

	public void update(E e) {
		getHibernateTemplate().update(e);
	}

	public List<E> find(String query) {
		List<E> retList = (List<E>) getHibernateTemplate().find(query);
		return retList;
	}

	public List<E> findAll() {
		String query = "from " + type.getName() + "";
		List<E> retList = (List<E>) getHibernateTemplate().find(query);
		return retList;
	}

	public E load(R id) {
		return (E) getHibernateTemplate().load(type, id);
	}

	public void deleteById(R id) {
		Object obj = load(id);
		getHibernateTemplate().delete(obj);
	}
	
	public void delete(E obj) {
		getHibernateTemplate().delete(obj);
	}

	public int count() {
		List<E> list = getHibernateTemplate().find(
				"select count(*) from " + type.getName() + " x");
		Integer count = (Integer) list.get(0);
		return count.intValue();
	}

	public void deleteAll() {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hqlDelete = "delete " + type.getName();
				int deletedEntities = session.createQuery(hqlDelete)
						.executeUpdate();
				return null;
			}

		});
	}
	
	public void persist(E object){
		getHibernateTemplate().persist(object);
	}
	
	public void refresh(E object){
		getHibernateTemplate().refresh(object);
	}
}