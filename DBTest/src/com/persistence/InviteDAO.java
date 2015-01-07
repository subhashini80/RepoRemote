package com.persistence;



 

import java.util.List;
 

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.domain.Invite;


 
 
public class InviteDAO {
 
    private SqlSessionFactory sqlSessionFactory = null;
 
   
 
    /**
     * Returns the list of all Invite instances from the database.
     * @return the list of all Invite instances from the database.
     */
    @SuppressWarnings("unchecked")
    public  List<Invite> selectAll(){
    	List<Invite> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("Invite.getAllInvite");
        } finally {
            session.close();
        }
        return list;

    }
    /**
     * Select instance of Invite from the database.
     * @param invite the instance to be persisted.
     */
   public Invite selectById(String id){
       	List<Invite> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	list = session.selectList("Invite.selectById", id);
        

        } finally {
            session.close();
        }
        return list.get(0);
    } 
    /**
     * Insert an instance of Invite into the database.
     * @param invite the instance to be persisted.
     */
   public int insert(Invite invite){
	   int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Invite.saveInvite", invite);
        } finally {
            session.commit();
            session.close();
        }
        return id;
    }
    /**
   * Update an instance of Invite into the database.
   * @param invite the instance to be persisted.
   */
  	public int update(Invite invite){
	   int id = -1;
      SqlSession session = sqlSessionFactory.openSession();

      try {
          id = session.update("Invite.updateInvite", invite);
      

      } finally {
          session.commit();
          session.close();
      }
      return id;
  }
 
    /**
     * Delete an instance of Invite from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("Invite.deleteInvite", id);
        } finally {
            session.commit();
            session.close();
        }
    }
    
    /**
     * Select instance of Invite from the database.
     * @param invite the instance to be persisted.
     */
   public Invite selectSpById(int event_id){
       	List<Invite> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	list = session.selectList("Invite.getInviteById", event_id);
        

        } finally {
            session.close();
        }
        return list.get(0);
    } 
   
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
}