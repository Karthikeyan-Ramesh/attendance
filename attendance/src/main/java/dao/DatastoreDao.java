package dao;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import pojo.User;

public class DatastoreDao {

	private DatastoreService datastore;
	  
	  private static final String USER_KIND = "userKind";
	  private static final String ATTENDANCE_KIND = "attendance";

	  public DatastoreDao() {
	    datastore = DatastoreServiceFactory.getDatastoreService();
	  }
	  
	  public String createCategory(User userObj) {
			
			Entity entityObj = new Entity(USER_KIND);
			entityObj.setProperty(User.ROLE_ID,userObj.getRoleId());
			entityObj.setProperty(User.USERNAME,userObj.getUserName());
			entityObj.setProperty(User.MOBILE,userObj.getMobile());
			entityObj.setProperty(User.PASSWORD,userObj.getPassword());
			Key userKey = datastore.put(entityObj);
			return (userKey.getId()!=0)?"Successfully added !":"Failed to add !";
	  }
	  
	  public List<User> getByPhone(String mobile) {
			
			    Filter propertyFilter = new FilterPredicate(User.MOBILE, FilterOperator.EQUAL, mobile);
			  	Query query = new Query(USER_KIND).setFilter(propertyFilter);
			    QueryResultIterator<Entity>results = datastore.prepare(query).asQueryResultIterator();
				List<User> resultUsers = new ArrayList<>();
			    while(results.hasNext())  
			    	 resultUsers.add(userEntities(results.next()));  
			    return resultUsers;
		
	 }
	 public User userEntities(Entity enObj) {
		 return new User.Builder()   
				 	.id(enObj.getKey().getId())
				 	.userName((String) enObj.getProperty(User.USERNAME))
				 	.mobile((String) enObj.getProperty(User.MOBILE))
				 	.roleId((int) enObj.getProperty(User.ROLE_ID))
				 	.password((String) enObj.getProperty(User.PASSWORD))
				 	.build();
	 }
}
