package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   @SuppressWarnings("unchecked")
   public User userByCar(Car car) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car = :car");
      query.setParameter("car", car);
      return query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> userByCarModel(String model) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User where car.series in (select series from Car where model = :model)");
      query.setParameter("model", model);
      return query.getResultList();
   }

}
