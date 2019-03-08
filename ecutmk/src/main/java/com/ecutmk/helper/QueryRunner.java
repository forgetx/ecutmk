package com.ecutmk.helper;

/**
 * 当需要在同一个事务中执行多个SQL时，可以使用 QueryRunner 的 doInTransaction 来实现
 */
public interface QueryRunner {
	
	/**
	 * 多个需要在同一个事务中执行的SQL语句可以在 doInTransaction 中执行<br>
	 * 在执行 doInTransaction 方法之前，事务已经准备就绪。<br>
	 * 当 doInTransaction 方法执行时发生异常，则向调用者抛出 DataAccessException 从而实现回滚事务。<br>
	 * 当 doInTransaction 方法顺利执行结束后，当前事务才提交。
	 * @throws DataAccessException 
	 * 					当 doInTransaction 内部的操作在运行阶段发生异常时，这些异常被转译成 DataAccessException 抛出
	 */
	void doInTransaction() throws DataAccessException ;

}
